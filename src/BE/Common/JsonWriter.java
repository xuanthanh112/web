package BE.Common;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {

    public static void writeToJson(List<Article> articlesList, String fileName) {

        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File đã được tạo: " + file.getAbsolutePath());
            } else {
                System.out.println("File đã tồn tại: " + file.getAbsolutePath());
            }
            FileWriter writer = new FileWriter(fileName);

            // Ghi chuỗi JSON vào file
            Gson gson = new Gson();
            String jsonString = gson.toJson(articlesList);
            writer.write(jsonString);

            // Đóng file
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}