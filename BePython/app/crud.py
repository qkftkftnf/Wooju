from sqlalchemy.orm import Session
from typing import List

from .models import Product


def get_products(db: Session, types: List, alcohol: float, isAward: bool):
    products = db.query(Product).filter(Product.alcohol < alcohol)
        
    if isAward:
        products = products.filter(Product.award)

    if types:
        tmp = products.filter(Product.type == types[0])
        for type in types[1:]:
            tmp = tmp.union(products.filter(Product.type == type))
        products = tmp

    return products.order_by(Product.alcohol.desc()).all()

def get_product(db: Session, product_id: int):
    return db.query(Product).filter(Product.id == product_id).first()