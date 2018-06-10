package com.jlkg.jzg.jzg_android.home.beans;

/**
 * Created by zcs on 2018/3/15.
 */

public class TeamRateReviewBean {

    /**
     * imurl : http://jianzhugang.xzgapp.com/144936328977213421308731.png
     * progressRating : 5
     * review : 班组评价测试数据
     * name : 广东中凯建设工程有限公司
     * safeRating : 5
     * id : 3120
     * qualityRating : 5
     * creditRating : 5
     */

    private String imurl;
    private int progressRating;
    private String review;
    private String name;
    private int safeRating;
    private String reviewDate;

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    private String id;
    private int qualityRating;
    private int creditRating;

    public String getImurl() {
        return imurl;
    }

    public void setImurl(String imurl) {
        this.imurl = imurl;
    }

    public int getProgressRating() {
        return progressRating;
    }

    public void setProgressRating(int progressRating) {
        this.progressRating = progressRating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSafeRating() {
        return safeRating;
    }

    public void setSafeRating(int safeRating) {
        this.safeRating = safeRating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(int qualityRating) {
        this.qualityRating = qualityRating;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }
}
