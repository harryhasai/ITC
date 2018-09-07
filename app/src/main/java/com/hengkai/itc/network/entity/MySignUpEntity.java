package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/9/6.
 */
public class MySignUpEntity {

    /**
     * msg : 查询成功
     * code : 1
     * data : [{"isRecommend":false,"activityEndTime":1535558400000,"createTime":1535358007000,"activityName":"asdsadsa","activityIntro":"asdsad","activityStartTime":1535299200000,"id":52,"isImgActivity":true,"pageView":2},{"isRecommend":true,"activityEndTime":1535558400000,"activityContent":"<p>sadasdasd<\/p>","createTime":1535177897000,"activityImg":"20180825141811759_451.png","activityName":"huodong22323","activityIntro":"jianjiel;asdasasdsad","activityStartTime":1535385600000,"id":51,"isImgActivity":false,"pageView":7},{"isRecommend":false,"activityEndTime":1535558400000,"createTime":1535359364000,"activityName":"huodongbiao23","activityIntro":"sadsadsad","activityStartTime":1535299200000,"id":55,"isImgActivity":true,"pageView":7},{"isRecommend":false,"activityEndTime":1533052800000,"activityContent":"<p>萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22<\/p>","createTime":1532567409000,"activityImg":"20180809164429291_3.jpg","activityName":"活动1活动1活动1活动1活动1活动1活动1活动1活动1","activityIntro":"萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22萨达22","activityStartTime":1531670400000,"id":8,"isImgActivity":false,"pageView":72},{"isRecommend":true,"activityEndTime":1535040000000,"activityContent":"<p>活动费事1活动费事1活动费事1活动费事1活动费事1活动费事1活动费事1<\/p>","createTime":1533194795000,"activityImg":"20180810142714568_291.png","activityName":"活动费事1活动费事1活动费事1活动费事1活动费事1活动费事1活动费事1","activityStartTime":1533225600000,"id":21,"isImgActivity":false,"pageView":26}]
     * count : 5
     * page : {"currentPage":1,"pageSize":10,"recordCount":5,"pageCount":1,"beginPageIndex":1,"endPageIndex":1}
     */

    public String msg;
    public int code;
    public int count;
    public PageBean page;
    public List<DataBean> data;

    public static class PageBean {
        /**
         * currentPage : 1
         * pageSize : 10
         * recordCount : 5
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
         * createTime : 1535358007000
         * activityName : asdsadsa
         * activityIntro : asdsad
         * activityStartTime : 1535299200000
         * id : 52
         * isImgActivity : true
         * pageView : 2
         * activityContent : <p>sadasdasd</p>
         * activityImg : 20180825141811759_451.png
         */

        public boolean isRecommend;
        public long activityEndTime;
        public long createTime;
        public String activityName;
        public String activityIntro;
        public long activityStartTime;
        public int id;
        public boolean isImgActivity;
        public int pageView;
        public String activityContent;
        public String activityImg;
    }
}
