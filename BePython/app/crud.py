from sqlalchemy.orm import Session
from typing import List, Optional

from models import Product, User
from recommend import get_recommendations


def get_products(db: Session, types: Optional[List]=None, alcohol: Optional[float]=None, isAward: Optional[bool]=None, user_id: Optional[int]=None):
    products = db.query(Product)

    if user_id:
        user = db.query(User).filter(User.id == user_id)
        return get_recommendations(user, products.filter(Product.type == '탁주'))

    else:
        products = products.filter(Product.alcohol < alcohol)
        if isAward:
            products = products.filter(Product.award)

        if types:
            tmp = products.filter(Product.type == types[0])
            for type in types[1:]:
                tmp = tmp.union(products.filter(Product.type == type))
            products = tmp

        products = products.order_by(Product.alcohol.desc())
    
    return products.all()


def get_product(db: Session, product_id: int):
    return db.query(Product).filter(Product.id == product_id).first()