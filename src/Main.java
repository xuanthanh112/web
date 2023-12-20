import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
    public static void main(String[] args) {
        FileReader reader = null;

        try {
            reader = new FileReader("src\\BE\\data\\articles.json");
            Type classOfT = new TypeToken<ArrayList<Data>>() {}.getType();
            Gson gson = new Gson();
            ArrayList<Data> list = gson.fromJson(reader, classOfT);

            Scanner scanner = new Scanner(System.in);

            // Hiển thị menu chọn chức năng
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Hiển thị tất cả data");
                System.out.println("2. Tìm kiếm theo tiêu đề");
                System.out.println("3. Tìm kiếm theo tag");
                System.out.println("4. Tìm kiếm theo date");
                System.out.println("5. Sắp xếp các bài viết từ cũ đến mới");
                System.out.println("6. Sắp xếp các bài viết theo độ nổi bật:");
                System.out.println("0. Thoát");

                System.out.print("Chọn chức năng: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc dòng trống sau khi đọc số

                switch (choice) {
//                    case 1:
//                        // Hiển thị tất cả data
//                        System.out.println("Danh sách tất cả data:");
//                        for (Data data : list) {
//                            data.display();
//                        }
//                        break;
                    case 2:
                        // Tìm kiếm theo tiêu đề

                        var s= scanner.nextLine();
                        var l = Data.filterByTitle(list, s);
                        for(Data data : l ){
                            System.out.println(data);

                        }
                        break;
                    case 3:
                        // Tìm kiếm theo tag
                        var c = scanner.nextLine();
                        var d = Data.filterByTag(list, c);
                        for(Data data : d ){
                            System.out.println(data);

                        }
                        break;
                    case 4:
                        // Tìm kiếm theo date
                        var a = scanner.nextLine();
                        var b= Data.filterByDate(list, a);
                        for(Data data : b ){
                            System.out.println(data);

                        }
                        break;
                    case 5:
                        // Gọi phương thức sắp xếp theo ngày giảm dần
                       var e=  Data.sortByDateDescending(list);

                        // Hiển thị danh sách bài viết đã sắp xếp
                        System.out.println("Danh sách bài viết đã sắp xếp theo thứ tự từ mới đến cũ:");
                        for (Data data : e) {
                            System.out.println(data);
                        }
                    case 6:
                        // Sắp xếp theo tag xuất hiện nhiều nhất
                        var f = Data.sortByTagFrequencyDescending(list);
                        System.out.println("Danh sách sau khi sắp xếp theo tag xuất hiện nhiều nhất:");
                        for (Data data : f) {
                            System.out.println(data);
                        }
                        break;
                    case 0:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ. Hãy chọn lại.");
                        break;
                }
            } while (choice != 0);

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}