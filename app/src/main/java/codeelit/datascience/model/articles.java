package codeelit.datascience.model;

public class articles {
    private String title;
    private  String  desc;
    private  String  img_url;
    private  String web_url;

    public articles() {
    }

    public articles(String title, String desc, String img_url, String web_url) {
        this.title = title;
        this.desc = desc;
        this.img_url = img_url;
        this.web_url = web_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}
