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

        // Gọi hàm crawl và in kết quả vào file
        crawlAndSave(year, month);
    }

    public static void crawlAndSave(String year, String month) {
        String url = "https://www.nftically.com/blog/" + year + "/" + month + "/";
        Document doc;

        try {
            doc = Jsoup
                    .connect(url)
                    .userAgent("Jsoup client")
                    .timeout(10000)
                    .get();

            List<Article> articlesList = WebPageScraper.scrapeArticles(doc);

            // Tạo đường dẫn thư mục lưu file
            String directoryPath = "F:\\Code\\java finalll\\intelli\\code intell\\web\\src\\BE\\data"; // Thay đổi đường dẫn này thành đường dẫn tuyệt đối của thư mục cần lưu
            String fileName = directoryPath + File.separator + "articles.json";

            // Ghi kết quả vào file
            JsonWriter.writeToJson(articlesList, fileName);

            // In ra danh sách bài viết, comment lại
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
