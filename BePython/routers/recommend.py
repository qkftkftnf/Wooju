from fastapi import APIRouter

router = APIRouter()

@router.get("/sool/", tags=["data"])
async def recommend_sool():
    return [{"username": "Rick"}, {"username": "Morty"}]