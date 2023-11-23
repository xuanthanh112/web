import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TwitterCrawl {
    public static void main(String[] args) {
        String url = "https://twitter.com/i/trends";
        System.out.println("Going to: " + url);
        Document doc = null;

        try {
            doc = Jsoup
                    .connect(url)
                    .userAgent("Jsoup client")
                    .timeout(10000).get();
            System.out.println("Got them");

            List<Article> articlesList = new ArrayList<>();



//            for (int i = 1; i <= 15; i++) {
            String selector = "div[data-testid=\"tweetText\"]>span";
            Elements lstArticles = doc.select(selector);
            System.out.println(lstArticles.size());
            for (Element element : lstArticles) {
//                String link = element.attr("href");
                String title = element.text();
                System.out.println(title);
                Article article = new Article(title);
                articlesList.add(article);
            }
//            }

            // Sử dụng thư viện Gson để chuyển đổi danh sách bài viết thành JSON
            Gson gson = new Gson();
            String jsonString = gson.toJson(articlesList);

            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Article {
//        @SerializedName("link")
//        private String link;
        @SerializedName("title")
        private String title;

        public Article(String link) {
//            this.link = link;
            this.title = title;
        }
    }
}
