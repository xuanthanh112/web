import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NftBlogCrawl {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so trang muon lay");
        int numpage = sc.nextInt();
        for (int page = 1; page <= numpage; page++) {
            String url = "https://www.nftically.com/blog/page/" + page + "/";
            Document doc = null;

            try {
                doc = Jsoup
                        .connect(url)
                        .userAgent("Jsoup client")
                        .timeout(10000)
                        .get();

                List<Article> articlesList = new ArrayList<>();


                Elements lstArticles = doc.select("div.blog-info");
                for (Element element : lstArticles) {
                    String tag = element.select(".saspot-label").first().text();
                    Element title_elem = element.select(".blog-title > a").first();
                    Element time = element.select(".blog-date > ul > li").first();
                    String link = title_elem.attr("href");
                    String title = title_elem.text();
                    String date = time.text();
                    Article article = new Article(link, title, tag, date);
                    articlesList.add(article);
                }


            // Tạo file có tên là `articles.json`
            FileWriter writer = new FileWriter("articles.json");

            // Ghi chuỗi JSON vào file
            Gson gson = new Gson();
            String jsonString = gson.toJson(articlesList);
            writer.write(jsonString);

            // Đóng file
            writer.close();

                // In ra danh sách bài viết
                for (Article article : articlesList) {
                    System.out.println("Title: " + article.getTitle());
                    System.out.println("Link: " + article.getLink());
                    System.out.println("Tag : " + article.getTag());
                    System.out.println("Datetime : " + article.getDate());
                    System.out.println("---------------------");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Article {
        @SerializedName("tag")
        private String tag;
        @SerializedName("link")
        private String link;
        @SerializedName("title")
        private String title;
        @SerializedName("date")
        private String date;
        public Article(String link, String title, String tag, String date) {
            this.link = link;
            this.title = title;
            this.tag = tag;
            this.date = date;
        }

        public String getLink() {
            return link;
        }

        public String getTitle() {
            return title;
        }

        public String getTag() {
            return tag;
        }

        public String getDate() {
            return date;
        }

    }
}
