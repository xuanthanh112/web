public class Data {
String link;
String title;
String tag;
String date;


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

    public void display(){
        System.out.println("Link:"+ link+"     Title:"+ title+ "         Tag: "+tag+ "      Datetime:"+date);
    }

}
