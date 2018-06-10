package com.jlkg.jzg.jzg_android.personal.bean;

import java.io.Serializable;

/**
 * @author wuwang
 * @Description
 * @email 1558183202@qq.com
 * @date 2018/4/26
 */

public class ClassBeforeObjectBean implements Serializable{


    /**
     * id : 87390
     * title : Gggg
     * companyName : Gggh
     * resumeDesc : Cvvhhj
     * image1 : {"id":87385,"host":"http://jianzhugang.xzgapp.com","name":"fe31bcac-aad0-4e03-a2d0-7b46b8c0db6e.jpg","url":"http://jianzhugang.xzgapp.com/fe31bcac-aad0-4e03-a2d0-7b46b8c0db6e.jpg"}
     * image2 : {"id":87386,"host":"http://jianzhugang.xzgapp.com","name":"7849db47-e274-453c-b86f-c4e34891047f.jpg","url":"http://jianzhugang.xzgapp.com/7849db47-e274-453c-b86f-c4e34891047f.jpg"}
     * image3 : {"id":87387,"host":"http://jianzhugang.xzgapp.com","name":"1a5b65b8-2006-449c-8ce0-9baf84fc04c2.jpg","url":"http://jianzhugang.xzgapp.com/1a5b65b8-2006-449c-8ce0-9baf84fc04c2.jpg"}
     * image4 : {"id":87388,"host":"http://jianzhugang.xzgapp.com","name":"8bb8ce7f-2651-49be-9f2d-4110fa9f5ba3.jpg","url":"http://jianzhugang.xzgapp.com/8bb8ce7f-2651-49be-9f2d-4110fa9f5ba3.jpg"}
     * image5 : {"id":87389,"host":"http://jianzhugang.xzgapp.com","name":"7859e199-f409-4d9a-8c12-cae3699a7c65.jpg","url":"http://jianzhugang.xzgapp.com/7859e199-f409-4d9a-8c12-cae3699a7c65.jpg"}
     * image6 : null
     * projectDate : 2018-05-02 00:00:00
     */

    private int id;
    private String title;
    private String companyName;
    private String resumeDesc;
    private Image1Entity image1;
    private Image2Entity image2;
    private Image3Entity image3;
    private Image4Entity image4;
    private Image5Entity image5;
    private Image6Entity image6;
    private String projectDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getResumeDesc() {
        return resumeDesc;
    }

    public void setResumeDesc(String resumeDesc) {
        this.resumeDesc = resumeDesc;
    }

    public Image1Entity getImage1() {
        return image1;
    }

    public void setImage1(Image1Entity image1) {
        this.image1 = image1;
    }

    public Image2Entity getImage2() {
        return image2;
    }

    public void setImage2(Image2Entity image2) {
        this.image2 = image2;
    }

    public Image3Entity getImage3() {
        return image3;
    }

    public void setImage3(Image3Entity image3) {
        this.image3 = image3;
    }

    public Image4Entity getImage4() {
        return image4;
    }

    public void setImage4(Image4Entity image4) {
        this.image4 = image4;
    }

    public Image5Entity getImage5() {
        return image5;
    }

    public void setImage5(Image5Entity image5) {
        this.image5 = image5;
    }

    public Image6Entity getImage6() {
        return image6;
    }

    public void setImage6(Image6Entity image6) {
        this.image6 = image6;
    }

    public String getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate;
    }

    public static class Image1Entity implements Serializable{
        /**
         * id : 87385
         * host : http://jianzhugang.xzgapp.com
         * name : fe31bcac-aad0-4e03-a2d0-7b46b8c0db6e.jpg
         * url : http://jianzhugang.xzgapp.com/fe31bcac-aad0-4e03-a2d0-7b46b8c0db6e.jpg
         */

        private int id;
        private String host;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Image2Entity implements Serializable{
        /**
         * id : 87386
         * host : http://jianzhugang.xzgapp.com
         * name : 7849db47-e274-453c-b86f-c4e34891047f.jpg
         * url : http://jianzhugang.xzgapp.com/7849db47-e274-453c-b86f-c4e34891047f.jpg
         */

        private int id;
        private String host;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Image3Entity implements Serializable{
        /**
         * id : 87387
         * host : http://jianzhugang.xzgapp.com
         * name : 1a5b65b8-2006-449c-8ce0-9baf84fc04c2.jpg
         * url : http://jianzhugang.xzgapp.com/1a5b65b8-2006-449c-8ce0-9baf84fc04c2.jpg
         */

        private int id;
        private String host;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Image4Entity implements Serializable{
        /**
         * id : 87388
         * host : http://jianzhugang.xzgapp.com
         * name : 8bb8ce7f-2651-49be-9f2d-4110fa9f5ba3.jpg
         * url : http://jianzhugang.xzgapp.com/8bb8ce7f-2651-49be-9f2d-4110fa9f5ba3.jpg
         */

        private int id;
        private String host;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Image5Entity implements Serializable{
        /**
         * id : 87389
         * host : http://jianzhugang.xzgapp.com
         * name : 7859e199-f409-4d9a-8c12-cae3699a7c65.jpg
         * url : http://jianzhugang.xzgapp.com/7859e199-f409-4d9a-8c12-cae3699a7c65.jpg
         */

        private int id;
        private String host;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Image6Entity implements Serializable{
        /**
         * id : 87389
         * host : http://jianzhugang.xzgapp.com
         * name : 7859e199-f409-4d9a-8c12-cae3699a7c65.jpg
         * url : http://jianzhugang.xzgapp.com/7859e199-f409-4d9a-8c12-cae3699a7c65.jpg
         */

        private int id;
        private String host;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
