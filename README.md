<h1 align="center">📰 ANews - Modern News App</h1>
<p align="center">A full-stack news application with Flutter & FastAPI</p>

<h2>✨ Features</h2>
<ul>
    <li><b>Flutter Frontend</b>: Material 3 Design, Breaking News Carousel, Category Tabs.</li>
    <li><b>FastAPI Backend</b>: High-performance asynchronous API.</li>
    <li><b>Bilingual Support</b>: Instantly switch between English and Farsi (RTL support).</li>
    <li><b>Multi-Theme</b>: Light, Dark, and System default themes.</li>
    <li><b>Secure</b>: API keys are safely stored in environment variables (.env).</li>
</ul>

<h2>🛠 Tech Stack</h2>
<ul>
    <li><b>Frontend</b>: Flutter, Dart, HTTP</li>
    <li><b>Backend</b>: Python, FastAPI, Uvicorn, HTTPX</li>
    <li><b>News Source</b>: Webz.io API</li>
</ul>

<h2>🚀 Getting Started</h2>

<h3>1. Backend Setup</h3>
<pre><code>cd backend
python -m venv venv
source venv/bin/activate
pip install -r requirements.txt
cp .env.example .env
# Edit .env and add your WEBZ_API_KEY
python main.py</code></pre>

<h3>2. Frontend Setup</h3>
<pre><code>cd anews
flutter pub get
flutter run</code></pre>
<p><i>Note: Update the IP address in lib/main.dart to your local machine's IP if testing on a physical device.</i></p>

<h2>📄 License</h2>
<p>This project is licensed under the MIT License.</p>
