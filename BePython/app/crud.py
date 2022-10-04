from sqlalchemy.orm import Session
from typing import List, Optional
from  sqlalchemy.sql.expression import func

from models import Product, User
from recommend import get_taste, get_today


def get_products(db: Session, types: Optional[List]=None, alcohol: Optional[float]=None, isAward: Optional[bool]=None, user_id: Optional[int]=None):
    products = db.query(Product)

    if user_id:
        result = {}
        user = db.query(User).filter(User.id == user_id).first()
        result['taste'] = get_taste(user, products.filter(Product.type == '탁주'))
        result['today'] = products.order_by(func.rand())[:3]
        result['award'] = products.filter(Product.award).order_by(func.rand())[:3]

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
        result = products.all()
    
    return result


def get_product(db: Session, product_id: int):
    return db.query(Product).filter(Product.id == product_id).first()


def search_products(db: Session, keyword: str):
    search = f"%{keyword}%"
    print(search)
    return db.query(Product).filter(Product.name.like(search)).all()


def get_recommendation(db: Session, user: object, keywords: Optional[str]=None):
    products = db.query(Product)
    if user['type'] == '탁주':
        typed_products = products \
            .filter((Product.type == '탁주') | (Product.type == '탁주 기타주류'))
    elif user['type'] == '약주, 과실주':
        typed_products = products \
            .filter((Product.type == '약주') | (Product.type == '약청주 기타주류') | (Product.type == '과실주') | (Product.type == '과실주 기타주류') | (Product.type == '청주'))
    elif user['type'] == '증류주':
        typed_products = products \
            .filter((Product.type == '리큐르') | (Product.type == '증류식소주') | (Product.type == '일반증류주') | (Product.type == '증류주 기타주류'))
    else:
        pass

    
    result = {}
    result['taste'] = get_taste(user, typed_products)
    result['today'] = get_today(keywords, products) if keywords else {}
    result['award'] = products.filter(Product.award).order_by(func.rand())[:3]
    return result