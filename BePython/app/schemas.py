from re import U
from typing import List, Union

from pydantic import BaseModel


class FoodBase(BaseModel):
    id: int

    class Config:
        orm_mode = True


class Food(FoodBase):
    name: str
    img: Union[str, None] = None


class MakerBase(BaseModel):
    id: int

    class Config:
        orm_mode = True


class Maker(MakerBase):
    name: str
    official_name: str
    address: str
    ceo_name: str

    
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
    foods: List[Food]
    makers: List[Maker]

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