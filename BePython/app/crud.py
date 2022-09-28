from sqlalchemy.orm import Session
from typing import List, Optional

from models import Product, User


def get_products(db: Session, types: Optional[List]=None, alcohol: Optional[float]=None, isAward: Optional[bool]=None, userId: Optional[int]=None):
    products = db.query(Product)

    if userId:
        return 
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