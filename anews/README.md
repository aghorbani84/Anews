# anews

A new Flutter project.

## Getting Started

This project is a starting point for a Flutter application.

A few resources to get you started if this is your first Flutter project:

- [Learn Flutter](https://docs.flutter.dev/get-started/learn-flutter)
- [Write your first Flutter app](https://docs.flutter.dev/get-started/codelab)
- [Flutter learning resources](https://docs.flutter.dev/reference/learning-resources)

For help getting started with Flutter development, view the
[online documentation](https://docs.flutter.dev/), which offers tutorials,
samples, guidance on mobile development, and a full API reference.
cat << 'EOF' > ~/ANews_Project/README.md
# ANews - Modern News App (Flutter + FastAPI)

A full-stack news application featuring a modern Google News-like UI built with Flutter, and a high-performance backend powered by FastAPI. The app supports bilingual content (English/Farsi), Dark Mode, and dynamic news fetching.

## Features
- Flutter Frontend: Material 3 Design, Breaking News Carousel, Category Tabs.
- FastAPI Backend: High-performance asynchronous API.
- Bilingual Support: Instantly switch between English and Farsi (RTL support).
- Multi-Theme: Light, Dark, and System default themes.
- Secure: API keys are safely stored in environment variables (.env).

## Tech Stack
- Frontend: Flutter, Dart, HTTP
- Backend: Python, FastAPI, Uvicorn, HTTPX
- News Source: Webz.io API

## Getting Started
### 1. Backend Setup
```bash
cd backend
python -m venv venv
source venv/bin/activate
pip install -r requirements.txt
cp .env.example .env
# Edit .env and add your WEBZ_API_KEY
python main.py
