import httpx
import os
from dotenv import load_dotenv
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
import uvicorn

load_dotenv()
app = FastAPI(title="ANews API")
WEBZ_API_KEY = os.getenv("WEBZ_API_KEY")

class Article(BaseModel):
    id: str
    title: str
    description: str
    image_url: str
    source: str
    published_at: str

class NewsData(BaseModel):
    breaking_news: list[Article]
    latest_news: list[Article]

@app.get("/api/news", response_model=NewsData)
async def get_news(lang: str = "en"):
    if not WEBZ_API_KEY:
        raise HTTPException(status_code=500, detail="API Key not found in .env file")
        
    query = "language:farsi" if lang == "fa" else "language:english"
    url = f"https://api.webz.io/newsApiLite?token={WEBZ_API_KEY}&q={query}"
    
    try:
        # افزایش تایم‌اوت به ۱۵ ثانیه
        async with httpx.AsyncClient(timeout=15.0) as client:
            response = await client.get(url)
            response.raise_for_status() # اگر status code خطا بود، ارور بدهد
            data = response.json()
    except httpx.RequestError as e:
        print(f"❌ Connection Error: {e}")
        raise HTTPException(status_code=503, detail=f"Failed to connect to news API: {e}")
    except Exception as e:
        print(f"❌ API Error: {e}")
        raise HTTPException(status_code=500, detail="Error processing news API response")
    
    articles = []
    # بررسی ساختار جیسون برگشتی از Webz.io
    news_items = data.get("news", []) or data.get("articles", [])
    
    for item in news_items:
        title = item.get("title", "No Title")
        desc = item.get("text", "")[:100] if item.get("text") else ""
        img = item.get("thread", {}).get("main_image", "https://images.unsplash.com/photo-1504711434969-e33886168f5c")
        src = item.get("site", "Unknown")
        pub = item.get("published", "")
        item_id = item.get("uuid", str(len(articles)))
        articles.append(Article(id=item_id, title=title, description=desc, image_url=img, source=src, published_at=pub))
    
    # اگر هیچ خبری نیامد، اخبار تستی بدهد تا اپ کرش نکند
    if not articles:
        print("⚠️ No articles found, returning empty list.")
        return {"breaking_news": [], "latest_news": []}
    
    breaking = articles[:2]
    latest = articles[2:] if len(articles) > 2 else []
    
    return {"breaking_news": breaking, "latest_news": latest}

if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8000)
