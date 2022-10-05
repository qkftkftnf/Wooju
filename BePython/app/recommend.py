import pandas as pd
import numpy as np
from sklearn.metrics.pairwise import cosine_similarity
from sklearn.feature_extraction.text import TfidfVectorizer
from sqlalchemy.orm import Session
from schemas import ProductBase
import json

categorys = {}

def get_taste(user, products):
    if user.type == '탁주':
        target = [[
            user.question1,
            user.question2,
            user.question3,
            user.question4,
            user.question5,]]
        columns = ['sweet', 'weight', 'carbonic', 'plain', 'acidity']

    elif user.type == '증류주':
        target = [[
            user.question1,
            user.question2,
            user.question3,
            user.question4,
            user.question5,]]
        columns = ['body', 'nutty', 'richness', 'spicy', 'flavor']

    elif user.type == '약주, 과실주':
        target = [[
            user.question1,
            user.question2,
            user.question3,
            user.question4,
            user.question5,
            user.question6,
            user.question6,]]
        columns = ['sweet', 'carbonic', 'plain', 'acidity', 'body', 'tannin', 'bitter']

    product_df = pd.read_sql(products.statement, products.session.bind)
    taste_data = product_df[columns]

    sim_scores = list(enumerate(cosine_similarity(target, taste_data)[0]))
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[:10]

    sool_indices = [idx[0] for idx in sim_scores]
    result = product_df.iloc[sool_indices].sample(3)

    result_json = result.to_json(orient="records")
    return json.loads(result_json)


def get_today(keywords, products):
    product_df = pd.read_sql(products.statement, products.session.bind)

    target_data =  pd.DataFrame({'keyword': [keywords]})
    search_data = pd.concat([target_data, product_df], ignore_index = True)
    tfidf = TfidfVectorizer()
    tfidf_matrix = tfidf.fit_transform(search_data['keyword'].fillna(value=''))

    cosine_sim = cosine_similarity(tfidf_matrix, tfidf_matrix)
    sim_scores = list(enumerate(cosine_sim[0]))
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[1:11]

    sool_indices = [idx[0] for idx in sim_scores]
    result = product_df.iloc[sool_indices].sample(3)

    result_json = result.to_json(orient="records")
    return json.loads(result_json)
