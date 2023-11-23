public class Data {
String link;
String title;
public Data(){

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

    @Override
    public String toString() {
        return "Data{" +
                "link='" + link + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
    public void display(){
        System.out.println("Link:"+ link+" Title:"+ title);
    }

}
