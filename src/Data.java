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
        return "link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public static List<Data> filterByTitle(List<Data> dataList, String searchTitle){
        List<Data> list = new ArrayList();
        // Tìm kiếm và hiển thị kết quả

        for (Data data : dataList) {
            if (data.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                list.add(data);
            }
        }
           return list;
    }


    public static List<Data> filterByDate (List<Data> dataList, String searchDate) {
        List<Data> list1 = new ArrayList();
        for (Data data : dataList) {
            if (data.getDate().toLowerCase().contains(searchDate)) {
             list1.add(data);
            }
        }
       return list1;
    }

    public static List<Data> filterByTag (List<Data> dataList, String searchTag) {
      List<Data> list2 = new ArrayList();
        for (Data data : dataList) {
            if (data.getTag().equalsIgnoreCase(searchTag)) {
             list2.add(data);
            }
        }
        return list2;
        }


    public static List<Data> sortByDateDescending(List<Data> dataList) {
       List<Data> sortedList =  new ArrayList<>(dataList);
        sortedList.sort(new Comparator<>() {

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

    return sortedList;
    }
        public static List<Data> sortByTagFrequencyDescending (List < Data > dataList) {
            List<Data> sortedList1 = new ArrayList<>(dataList);

            Map<String, Integer> tagFrequencyMap = new HashMap<>();

            // Đếm số lần xuất hiện của từng tag
            for (Data data : sortedList1 ) {
                String tag = data.getTag();
                tagFrequencyMap.put(tag, tagFrequencyMap.getOrDefault(tag, 0) + 1);
            }

            // Sắp xếp danh sách theo số lần xuất hiện giảm dần
            sortedList1.sort(new Comparator<>() {
                @Override
                public int compare(Data data1, Data data2) {
                    int frequency1 = tagFrequencyMap.getOrDefault(data1.getTag(), 0);
                    int frequency2 = tagFrequencyMap.getOrDefault(data2.getTag(), 0);

                    // So sánh theo thứ tự giảm dần
                    return Integer.compare(frequency2, frequency1);
                }
            });

        return sortedList1;
    }
}

