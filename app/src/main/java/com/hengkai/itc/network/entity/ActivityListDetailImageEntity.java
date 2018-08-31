package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/31.
 */
public class ActivityListDetailImageEntity {

    /**
     * msg : 查询成功
     * code : 1
     * data : {"isRecommend":false,"activityEndTime":1535558400000,"createTime":1535359364000,"activityName":"huodongbiao23","activityIntro":"sadsadsad","activityStartTime":1535299200000,"createUser":"超级管理员","permission":"activityType","id":55,"paramName":"4444","isImgActivity":true,"pageView":3}
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     * imgList : [{"id":196,"imgUrl":"20180815114135905_490.jpg","imgDesc":"2图片活动11111111111111111111图片活动11111111111111111111","newsId":49,"sort":0,"isDelete":false},{"id":197,"imgUrl":"20180815114138195_589.jpg","imgDesc":"图片活动11111111111111111111图片活动11111111111111111111","newsId":49,"sort":0,"isDelete":false},{"id":200,"imgUrl":"20180815141650788_3.jpg","imgDesc":"图片新闻图片新闻图片新闻图片新闻图片新闻","newsId":50,"sort":0,"isDelete":false},{"id":201,"imgUrl":"20180815141657438_752.jpg","imgDesc":"图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻","newsId":50,"sort":0,"isDelete":false},{"id":202,"imgUrl":"20180827162005786_177.png","imgDesc":"asdasd","newsId":52,"sort":0,"isDelete":false},{"id":204,"imgUrl":"20180815114135905_490.jpg","imgDesc":"2图片活动11111111111111111111图片活动11111111111111111111","newsId":53,"sort":0,"isDelete":false},{"id":205,"imgUrl":"20180815114138195_589.jpg","imgDesc":"图片活动11111111111111111111图片活动11111111111111111111","newsId":53,"sort":0,"isDelete":false},{"id":206,"imgUrl":"20180815141650788_3.jpg","imgDesc":"图片新闻图片新闻图片新闻图片新闻图片新闻","newsId":53,"sort":0,"isDelete":false},{"id":207,"imgUrl":"20180815141657438_752.jpg","imgDesc":"图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻图片新闻","newsId":53,"sort":0,"isDelete":false},{"id":208,"imgUrl":"20180827162005786_177.png","imgDesc":"asdasd","newsId":53,"sort":0,"isDelete":false},{"id":209,"imgUrl":"20180827162725546_686.png","imgDesc":"asdsad","newsId":53,"sort":0,"isDelete":false},{"id":212,"imgUrl":"20180827164238591_273.jpg","imgDesc":"asdsadasd","newsId":55,"sort":0,"isDelete":false},{"id":210,"imgUrl":"20180827162817945_39.jpg","imgDesc":"asdasdas","newsId":54,"sort":2,"isDelete":false},{"id":211,"imgUrl":"20180827164230471_707.png","imgDesc":"222222","newsId":55,"sort":15,"isDelete":false}]
     */

    public String msg;
    public int code;
    public DataBean data;
    public String attachmentPath;
    public List<ImgListBean> imgList;

    public static class DataBean {
        /**
         * isRecommend : false
         * activityEndTime : 1535558400000
         * createTime : 1535359364000
         * activityName : huodongbiao23
         * activityIntro : sadsadsad
         * activityStartTime : 1535299200000
         * createUser : 超级管理员
         * permission : activityType
         * id : 55
         * paramName : 4444
         * isImgActivity : true
         * pageView : 3
         */

        public boolean isRecommend;
        public long activityEndTime;
        public long createTime;
        public String activityName;
        public String activityIntro;
        public long activityStartTime;
        public String createUser;
        public String permission;
        public int id;
        public String paramName;
        public boolean isImgActivity;
        public int pageView;
    }

    public static class ImgListBean {
        /**
         * id : 196
         * imgUrl : 20180815114135905_490.jpg
         * imgDesc : 2图片活动11111111111111111111图片活动11111111111111111111
         * newsId : 49
         * sort : 0
         * isDelete : false
         */

        public int id;
        public String imgUrl;
        public String imgDesc;
        public int newsId;
        public int sort;
        public boolean isDelete;
    }
}
