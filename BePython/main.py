from typing import List

from fastapi import Depends, APIRouter, FastAPI, HTTPException, responses
from fastapi_pagination import Page, add_pagination, paginate
from sqlalchemy.orm import Session

import crud, models, database, schemas

models.Base.metadata.create_all(bind=database.engine)

def get_db():
    db = database.SessionLocal()
    try:
        yield db
    finally:
        db.close()

app = FastAPI()

@app.get("/")
def main():
    return responses.RedirectResponse(url="/docs/")


@app.get("/product/", tags=["data"], response_model=Page[schemas.Product])
async def read_products(
    db: Session = Depends(get_db),
    size: int = 20,
    isRecommend: bool = False,
):
    products = crud.get_products(db)
    return paginate(products)


@app.get("/product/{product_id}", tags=["data"], response_model=schemas.Product)
async def read_product(product_id: int, db: Session = Depends(get_db)):
    product = crud.get_product(db, product_id=product_id)
    if product is None:
        raise HTTPException(status_code=404, detail="Product not found")
    return product

add_pagination(app)