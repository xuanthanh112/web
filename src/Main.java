import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    public static void main(String[] args) {
        FileReader reader= null;
        try{
        reader = new FileReader("articles.json");
            Type classOfT = new TypeToken<ArrayList<Data>>(){}.getType();
            Gson gson = new Gson();
            ArrayList<Data>list = gson.fromJson(reader, classOfT);
            for(Data data: list){
                data.display();
            }
        }catch (FileNotFoundException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (reader!= null){
                try {
                    reader.close();
                }catch (IOException ex){
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }
}
