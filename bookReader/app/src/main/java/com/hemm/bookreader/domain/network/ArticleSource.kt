package com.hemm.bookreader.domain.network

import com.hemm.bookreader.domain.model.Article
import com.hemm.bookreader.getHtml
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import org.jsoup.Jsoup

/**
 * Created by B04e on 2017/5/22.
 */
class ArticleSource() : Source<Article> {
    override fun obtain(url: String): Article {
        val html = getHtml(url)

        val doc = Jsoup.parse(html)

        val title = doc.select("h1").text()
        val content = doc.select("div.p").text()
        val article = Article(title, content)
        return article
    }

}