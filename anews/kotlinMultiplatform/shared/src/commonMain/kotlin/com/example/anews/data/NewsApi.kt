package com.example.anews.data

import com.example.anews.model.NewsArticle
import com.example.anews.model.NewsResponse
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

expect class PlatformHttpClient() {
    val client: HttpClient
}

class NewsApi(private val apiKey: String) {
    
    private val baseUrl = "https://newsapi.org/v2"
    
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }
    
    suspend fun getTopHeadlines(country: String = "us", category: String? = null): List<NewsArticle> {
        return try {
            val url = buildString {
                append("$baseUrl/top-headlines")
                append("?country=$country")
                append("&apiKey=$apiKey")
                if (category != null) {
                    append("&category=$category")
                }
            }
            
            val response: NewsResponse = httpClient.get(url).body()
            response.articles
        } catch (e: Exception) {
            println("Error fetching news: ${e.message}")
            emptyList()
        }
    }
    
    suspend fun searchNews(query: String): List<NewsArticle> {
        return try {
            val url = "$baseUrl/everything?q=$query&apiKey=$apiKey"
            val response: NewsResponse = httpClient.get(url).body()
            response.articles
        } catch (e: Exception) {
            println("Error searching news: ${e.message}")
            emptyList()
        }
    }
}
