from sqlalchemy.orm import Session

from models import Product


def get_products(db: Session):
    #     'items': json_data[(pageNum - 1) * pageSize : (pageNum) * pageSize],
    #     'total': total_len // pageSize + 1,
    #     'page': pageNum, 'size': pageSize
    return db.query(Product).order_by(Product.alcohol.desc()).all()
    # .paginate(page=int(page_num), error_out=False, max_per_page=int(page_size))

def get_product(db: Session, product_id: int):
    return db.query(Product).filter(Product.id == product_id).first()