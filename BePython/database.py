import json
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

with open('./secrets.json', 'r', encoding='utf-8') as f:
    secrets = json.load(f)

MYSQL_URL = f'mysql+pymysql://{secrets["USERNAME"]}:{secrets["PASSWORD"]}@{secrets["HOSTNAME"]}:{secrets["PORT"]}/{secrets["DBNAME"]}'
engine = create_engine(MYSQL_URL, encoding='utf-8')
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

Base = declarative_base()