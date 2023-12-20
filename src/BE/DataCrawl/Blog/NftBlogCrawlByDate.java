package BE.DataCrawl.Blog;

import BE.Common.Article;
import BE.Common.JsonWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NftBlogCrawlByDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập năm: ");
        String year = scanner.nextLine();

        System.out.print("Nhập tháng: ");
        String month = scanner.nextLine();

        String url = "https://www.nftically.com/blog/" + year + "/" + month + "/";

        Document doc;

        try {
            doc = Jsoup
                    .connect(url)
                    .userAgent("Jsoup client")
                    .timeout(10000)
                    .get();

            List<Article> articlesList = WebPageScraper.scrapeArticles(doc);
            String directoryPath = "F:\\Code\\java finalll\\intelli\\code intell\\web\\src\\BE\\data";// đổi đường dẫn này thành đường dẫn tuyệt đối của thư mục cần lưu
            String filename = directoryPath + File.separator + "articles"+year+month+".json";

            JsonWriter.writeToJson(articlesList, filename);

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
