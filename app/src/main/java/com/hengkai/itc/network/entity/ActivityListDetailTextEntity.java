package com.hengkai.itc.network.entity;

/**
 * Created by Harry on 2018/8/31.
 */
public class ActivityListDetailTextEntity {

    /**
     * msg : 查询成功
     * code : 1
     * data : {"isRecommend":true,"activityContent":"<p>sadasdasd<\/p>","activityImg":"20180825141811759_451.png","activityName":"huodong22323","activityStartTime":1535385600000,"permission":"activityType","paramName":"33","pageView":2,"activityEndTime":1535558400000,"createTime":1535177897000,"activityIntro":"jianjiel;asdasasdsad","createUser":"超级管理员","id":51,"isImgActivity":false}
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     */

    public String msg;
    public int code;
    public DataBean data;
    public String attachmentPath;

    public static class DataBean {
        /**
         * isRecommend : true
         * activityContent : <p>sadasdasd</p>
         * activityImg : 20180825141811759_451.png
         * activityName : huodong22323
         * activityStartTime : 1535385600000
         * permission : activityType
         * paramName : 33
         * pageView : 2
         * activityEndTime : 1535558400000
         * createTime : 1535177897000
         * activityIntro : jianjiel;asdasasdsad
         * createUser : 超级管理员
         * id : 51
         * isImgActivity : false
         */

        public boolean isRecommend;
        public String activityContent;
        public String activityImg;
        public String activityName;
        public long activityStartTime;
        public String permission;
        public String paramName;
        public int pageView;
        public long activityEndTime;
        public long createTime;
        public String activityIntro;
        public String createUser;
        public int id;
        public boolean isImgActivity;
    }
}
