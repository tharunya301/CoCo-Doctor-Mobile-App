package com.example.myapp.Domains;

public class getStarted_Domain {
    private String title;
    private String subtitle1Text;
    private String description1Text;
    private String subtitle2Text;
    private String description2Text;
    private String subtitle3Text;
    private String description3Text;
    private String picPath;

    public getStarted_Domain(String title, String subTitle1, String description1, String subtitle2, String description2, String subtitle3, String description3, String picPath) {
        this.title = subTitle1;
        this.subtitle1Text = subtitle1Text;
        this.description1Text = description1Text;
        this.subtitle2Text = subtitle2Text;
        this.description2Text = description2Text;
        this.subtitle3Text = subtitle3Text;
        this.description3Text = description3Text;
        this.picPath = this.picPath;
    }

    public String getTitle() {
        return title;
    }
    public String getSubtitle1Text(){
        return subtitle1Text;
    }
    public String getDescription1Text() {
        return description1Text;
    }

    public String getSubtitle2Text(){
        return subtitle2Text;
    }

    public String getDescription2Text() {
        return description2Text;
    }

    public String getSubtitle3Text() {
        return subtitle3Text;
    }
    public String getDescription3Text() {
        return description3Text;
    }

    public String getPicPath() {
        return picPath;
    }
}
