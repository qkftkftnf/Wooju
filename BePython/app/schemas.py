from typing import List, Union

from pydantic import BaseModel


class ProductBase(BaseModel):
    id: int
    name: str
    image: str
    cutted_img: Union[str, None] = None
    type: str
    volume: str
    alcohol: float
    
    class Config:
        orm_mode = True
    

class ProductDetail(ProductBase):
    subtext: Union[str, None] = None
    award: Union[str, None] = None

    acidity: int
    weight: int
    bitter: int
    body: int
    carbonic: int
    flavor: int
    nutty: int
    plain: int
    richness: int
    spicy: int
    sweet: int
    tannin: int


class FoodBase(BaseModel):
    email: str


class FoodCreate(FoodBase):
    password: str


class Food(FoodBase):
    id: int
    # is_active: bool
    # items: List[Item] = []

    class Config:
        orm_mode = True

class MakerBase(BaseModel):
    email: str


class MakerCreate(MakerBase):
    password: str


class Maker(MakerBase):
    id: int
    # is_active: bool
    # items: List[Item] = []

    class Config:
        orm_mode = True