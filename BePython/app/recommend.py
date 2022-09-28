import pandas as pd
import numpy as np
from sqlalchemy.orm import Session
from sklearn.metrics.pairwise import cosine_similarity
from schemas import ProductBase
import json

columns = [
  ['sweet', 'weight', 'carbonic', 'plain', 'acidity'],
  ['body', 'nutty', 'richness', 'spicy', 'flavor'],
  ['sweet', 'carbonic', 'plain', 'acidity', 'body', 'tannin', 'bitter'],
]

categorys = {}

def get_recommendations(user, products):
    target = [[4, 2, 2, 8, 2]]
    product_df = pd.read_sql(products.statement, products.session.bind)
    data = product_df[columns[0]]
    sim_scores = list(enumerate(cosine_similarity(target, data)[0]))
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[:10]

    sool_indices = [idx[0] for idx in sim_scores]

    result = product_df.iloc[sool_indices]
    result_json = result.to_json(orient="records")
    return json.loads(result_json)