package codeelit.datascience;

public class ListitemImage {
    private String head;
    private  String desc;
    private int image;
    private String img_desc;

    public ListitemImage(String head, String desc, int image, String img_desc) {
        this.head = head;
        this.desc = desc;
        this.image = image;
        this.img_desc = img_desc;
    }
    public String getHead1(){
        return head;
    }
    public String getDesc1(){
        return desc;
    }
    public int getImg(){
        return image;
    }
    public String getImgdesc(){
        return img_desc;
    }
}
