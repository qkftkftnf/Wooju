from sqlalchemy import Column, VARCHAR, BigInteger, SmallInteger, Float
from .database import Base

class Product(Base):
	__tablename__ = 'product'

	id = Column(BigInteger, primary_key=True, autoincrement=True)
	image = Column(VARCHAR(2048), nullable=True)
	cutted_img = Column(VARCHAR(2048), nullable=True)
	like_num = Column(BigInteger, nullable=True)
	name = Column(VARCHAR(255), nullable=False)
	alcohol = Column(Float, nullable=False)
	anju_note = Column(VARCHAR(255), nullable=True)
	award = Column(VARCHAR(255), nullable=True)
	price = Column(BigInteger, nullable=False)
	distinction = Column(VARCHAR(255), nullable=True)
	ingredient = Column(VARCHAR(255), nullable=True)
	keyword = Column(VARCHAR(255), nullable=True)
	other_note = Column(VARCHAR(255), nullable=False)
	storage_note = Column(VARCHAR(255), nullable=False)
	subtext = Column(VARCHAR(255), nullable=False)
	taste_note = Column(VARCHAR(255), nullable=False)
	taste_standard = Column(VARCHAR(255), nullable=False)
	type = Column(VARCHAR(255), nullable=False)
	volume = Column(VARCHAR(255), nullable=False)

	acidity = Column(SmallInteger, nullable=False)
	weight = Column(SmallInteger, nullable=False)
	bitter = Column(SmallInteger, nullable=False)
	body = Column(SmallInteger, nullable=False)
	carbonic = Column(SmallInteger, nullable=False)
	flavor = Column(SmallInteger, nullable=False)
	nutty = Column(SmallInteger, nullable=False)
	plain = Column(SmallInteger, nullable=False)
	richness = Column(SmallInteger, nullable=False)
	spicy = Column(SmallInteger, nullable=False)
	sweet = Column(SmallInteger, nullable=False)
	tannin = Column(SmallInteger, nullable=False)

	fruit_category = Column(SmallInteger, nullable=True)
	flower_category = Column(SmallInteger, nullable=True)
	herb_category = Column(SmallInteger, nullable=True)
	nut_category = Column(SmallInteger, nullable=True)
	other_category = Column(SmallInteger, nullable=True)
	situation_category = Column(SmallInteger, nullable=True)


class Food(Base):
	__tablename__ = 'food'

	id = Column(BigInteger, primary_key=True, autoincrement=True)
	img = Column(VARCHAR(2048), nullable=False)
	name = Column(VARCHAR(255), nullable=False)

class Maker(Base):
	__tablename__ = 'maker'

	id = Column(BigInteger, primary_key=True, autoincrement=True)
	address = Column(VARCHAR(255), nullable=False)
	ceo_name = Column(VARCHAR(255), nullable=False)
	name = Column(VARCHAR(255), nullable=False)
	official_name = Column(VARCHAR(255), nullable=False)

