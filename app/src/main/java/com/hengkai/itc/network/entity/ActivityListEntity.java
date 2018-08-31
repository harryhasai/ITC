package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/31.
 */
public class ActivityListEntity {

    /**
     * msg : 查询成功
     * code : 1
     * data : [{"isRecommend":false,"activityEndTime":1535558400000,"createTime":1535359364000,"activityName":"huodongbiao23","activityIntro":"sadsadsad","activityStartTime":1535299200000,"id":55,"paramName":"4444","activityType":334,"userName":"超级管理员","isImgActivity":true,"pageView":1},{"isRecommend":false,"activityImg":"20180827162814474_730.jpg","activityName":"adssadas","activityStartTime":1535299200000,"paramName":"4444","userName":"超级管理员","pageView":0,"activityEndTime":1535299200000,"createTime":1535358506000,"activityIntro":"asdasdasd","id":54,"activityType":334,"isImgActivity":true},{"isRecommend":false,"activityEndTime":1535644800000,"createTime":1535358456000,"activityName":"huodongbiao123213","activityIntro":"jianjeils;ad2","activityStartTime":1534867200000,"id":53,"paramName":"4444","activityType":334,"userName":"超级管理员","isImgActivity":true,"pageView":0}]
     * page : {"currentPage":1,"pageSize":10,"recordCount":3,"pageCount":1,"beginPageIndex":1,"endPageIndex":1}
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     */

    public String msg;
    public int code;
    public PageBean page;
    public String attachmentPath;
    public List<DataBean> data;

    public static class PageBean {
        /**
         * currentPage : 1
         * pageSize : 10
         * recordCount : 3
         * pageCount : 1
         * beginPageIndex : 1
         * endPageIndex : 1
         */

        public int currentPage;
        public int pageSize;
        public int recordCount;
        public int pageCount;
        public int beginPageIndex;
        public int endPageIndex;
    }

    public static class DataBean {
        /**
         * isRecommend : false
         * activityEndTime : 1535558400000
         * createTime : 1535359364000
         * activityName : huodongbiao23
         * activityIntro : sadsadsad
         * activityStartTime : 1535299200000
         * id : 55
         * paramName : 4444
         * activityType : 334
         * userName : 超级管理员
         * isImgActivity : true
         * pageView : 1
         * activityImg : 20180827162814474_730.jpg
         */

        public boolean isRecommend;
        public long activityEndTime;
        public long createTime;
        public String activityName;
        public String activityIntro;
        public long activityStartTime;
        public int id;
        public String paramName;
        public int activityType;
        public String userName;
        public boolean isImgActivity;
        public int pageView;
        public String activityImg;
    }
}
