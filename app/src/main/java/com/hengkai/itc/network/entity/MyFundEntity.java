package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/27.
 */
public class MyFundEntity {
    /**
     * msg : 查询成功
     * code : 0
     * data : [{"newsIntro":"1","isRecommend":false,"create_user_id":1,"releaseTime":1533954300000,"coverImg":"20180811102532677_281.jpg","isAppMessage":false,"sort":0,"pageView":0,"isTop":false,"newsTitle":"1","createUser":"超级管理员","id":74,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"2","isRecommend":false,"create_user_id":1,"releaseTime":1533955920000,"coverImg":"20180811105258294_832.jpg","isAppMessage":false,"sort":0,"pageView":0,"isTop":false,"newsTitle":"2","createUser":"超级管理员","id":75,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"第三方","isRecommend":false,"create_user_id":1,"releaseTime":1533956220000,"coverImg":"20180811105733697_569.jpg","isAppMessage":false,"sort":0,"pageView":0,"isTop":false,"newsTitle":"11大发","createUser":"超级管理员","id":76,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"32323232","isRecommend":false,"create_user_id":1,"releaseTime":1534228140000,"coverImg":"20180814142905815_686.jpg","isAppMessage":false,"sort":0,"pageView":0,"isTop":false,"newsTitle":"322","createUser":"超级管理员","id":77,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"wqewqeqwewqe","isRecommend":false,"create_user_id":1,"releaseTime":1534228500000,"coverImg":"20180814143614034_182.jpg","isAppMessage":false,"sort":0,"pageView":0,"isTop":false,"newsTitle":"wewerr","createUser":"超级管理员","id":78,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"323232323232","isRecommend":true,"create_user_id":1,"releaseTime":1534176000000,"coverImg":"20180824143403050_32.jpg","isAppMessage":false,"sort":0,"pageView":0,"isTop":true,"newsTitle":"ew34323232","createUser":"超级管理员","id":79,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"dfsa dsaf sa asf ","isRecommend":false,"create_user_id":1,"releaseTime":1534262400000,"coverImg":"20180815085345780_235.jpg","isAppMessage":false,"sort":0,"pageView":0,"isTop":false,"newsTitle":"sdafd dsaf","createUser":"超级管理员","id":80,"isHasTimeliness":false,"isSendMessage":false}]
     * count : 7
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     */

    public String msg;
    public int code;
    public int count;
    public String attachmentPath;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * newsIntro : 1
         * isRecommend : false
         * create_user_id : 1
         * releaseTime : 1533954300000
         * coverImg : 20180811102532677_281.jpg
         * isAppMessage : false
         * sort : 0
         * pageView : 0
         * isTop : false
         * newsTitle : 1
         * createUser : 超级管理员
         * id : 74
         * isHasTimeliness : false
         * isSendMessage : false
         */

        public String newsIntro;
        public boolean isRecommend;
        public int create_user_id;
        public long releaseTime;
        public String coverImg;
        public boolean isAppMessage;
        public int sort;
        public int pageView;
        public boolean isTop;
        public String newsTitle;
        public String createUser;
        public int id;
        public boolean isHasTimeliness;
        public boolean isSendMessage;
    }
}
