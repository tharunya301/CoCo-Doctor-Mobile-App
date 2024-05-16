package com.example.myapp.Domains;

public class diagnose_Domain {
    private String title;
    private String subTitle;

    public diagnose_Domain(String title, String subtitle1, String description1, String subtitle2, String description2, String subtitle3, String description3, String picPath) {
        this.title = title;
        this.subTitle = subtitle1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getPicPath() {
        return null;
    }


}
