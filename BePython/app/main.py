from typing import List, Union

from fastapi import Depends, APIRouter, FastAPI, HTTPException, responses, Query
from fastapi_pagination import Page, add_pagination, paginate
from sqlalchemy.orm import Session
from starlette.middleware.cors import CORSMiddleware

from . import crud, models, database, schemas

origins = [
    "*"
]

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=[""],
    allow_headers=[""],
)

models.Base.metadata.create_all(bind=database.engine)

def get_db():
    db = database.SessionLocal()
    try:
        yield db
    finally:
        db.close()

@app.get("/")
def main():
    return responses.RedirectResponse(url="/docs/")


@app.get("/product/", tags=["data"], response_model=Page[schemas.ProductBase])
async def read_products(
    db: Session = Depends(get_db),
    types: Union[List[str], None] = Query(default=None),
    alcohol: float = 100,
    isAward: bool = False,
):
    products = crud.get_products(db, types, alcohol, isAward)
    return paginate(products)


@app.get("/product/{product_id}", tags=["data"], response_model=schemas.ProductDetail)
async def read_product(product_id: int, db: Session = Depends(get_db)):
    product = crud.get_product(db, product_id=product_id)
    if product is None:
        raise HTTPException(status_code=404, detail="Product not found")
    return product

add_pagination(app)