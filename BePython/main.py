from fastapi import FastAPI, responses
from routers import recommend

app = FastAPI()

@app.get("/")
def main():
    return responses.RedirectResponse(url="/docs/")

app.include_router(recommend.router)