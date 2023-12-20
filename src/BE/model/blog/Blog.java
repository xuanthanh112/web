package BE.model.blog;

public class Blog extends BlogEntity{
    public Blog(String title, String tag, String date, String link){
        super(title, link, tag, date);
    }
}
