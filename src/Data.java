import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Data {
    String link;
    String title;
    String tag;
    String date;


    public Data() {

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data{" +
                "link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public void display() {
        System.out.println("Link:" + link + "     Title:" + title + "         Tag: " + tag + "      Datetime:" + date);
    }

    public void searchByTitle(ArrayList<Data> dataList) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập tiêu đề cần tìm kiếm (Ấn 'Stop' để dừng): ");
            String searchTitle = scanner.nextLine();

            // Kiểm tra nếu người dùng muốn dừng
            if (searchTitle.equalsIgnoreCase("Stop")) {
                break;
            }

            // Tìm kiếm và hiển thị kết quả
            boolean found = false;
            for (Data data : dataList) {
                if (data.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                    data.display();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Không tìm thấy kết quả nào cho tiêu đề '" + searchTitle + "'.");
            }
        }
    }

    public void searchByDate(ArrayList<Data> dataList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập date cần tìm kiếm: ");
        String searchDate = scanner.nextLine().toLowerCase(); // Chuyển đổi sang chữ thường để tìm kiếm không phân biệt chữ hoa, chữ thường

        // Tìm kiếm và hiển thị kết quả
        boolean found = false;
        for (Data data : dataList) {
            if (data.getDate().toLowerCase().contains(searchDate)) {
                data.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy kết quả nào cho date gần giống '" + searchDate + "'.");
        }
    }

    public void searchByTag(ArrayList<Data> dataList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tag cần tìm kiếm: ");
        String searchTag = scanner.nextLine();

        // Tìm kiếm và hiển thị kết quả
        boolean found = false;
        for (Data data : dataList) {
            if (data.getTag().equalsIgnoreCase(searchTag)) {
                data.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy kết quả nào cho tag '" + searchTag + "'.");
        }
    }

    public static void sortByDateDescending(ArrayList<Data> dataList) {
        dataList.sort(new Comparator<>() {
            @Override
            public int compare(Data data1, Data data2) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    // Parse chuỗi ngày thành đối tượng Date để so sánh
                    Date date1 = sdf.parse(data1.getDate());
                    Date date2 = sdf.parse(data2.getDate());

                    // So sánh theo thứ tự giảm dần
                    return date2.compareTo(date1);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0; // Trả về giá trị mặc định nếu có lỗi
                }
            }
        });
    }
        public static void sortByTagFrequencyDescending (ArrayList < Data > dataList) {
            Map<String, Integer> tagFrequencyMap = new HashMap<>();

            // Đếm số lần xuất hiện của từng tag
            for (Data data : dataList) {
                String tag = data.getTag();
                tagFrequencyMap.put(tag, tagFrequencyMap.getOrDefault(tag, 0) + 1);
            }

            // Sắp xếp danh sách theo số lần xuất hiện giảm dần
            dataList.sort(new Comparator<>() {
                @Override
                public int compare(Data data1, Data data2) {
                    int frequency1 = tagFrequencyMap.getOrDefault(data1.getTag(), 0);
                    int frequency2 = tagFrequencyMap.getOrDefault(data2.getTag(), 0);

                    // So sánh theo thứ tự giảm dần
                    return Integer.compare(frequency2, frequency1);
                }
            });

        }
}

