package BE.model.blog;

public abstract class BlogEntity implements Entity {
protected String title, link , tag, date;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getTag() {
        return tag;
    }

    public String getDate() {
        return date;
    }

    public BlogEntity(String title, String link, String tag, String date) {
        this.title = title;
        this.link = link;
        this.tag = tag;
        this.date = date;
    }
    @Override
    public void display() {
        System.out.println("Link:" + link + "     Title:" + title + "         Tag: " + tag + "      Datetime:" + date);
    }

    public BlogEntity() {
    }
}
