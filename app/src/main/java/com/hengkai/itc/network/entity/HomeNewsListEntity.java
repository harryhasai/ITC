package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/15.
 * 首页 - 最新资讯
 */
public class HomeNewsListEntity {


    /**
     * msg : 查询成功
     * code : 1
     * data : [{"newsIntro":"现在做 Web 全景合适吗？","isRecommend":false,"create_user_id":1,"isComment":"no","releaseTime":1533172800000,"coverImg":"20180802092113631_521.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":4,"isTop":false,"newsTitle":"现在做 Web 全景合适吗？","checkState":2,"createUser":"超级管理员","id":32,"isImgNews":false,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"公测近一年，支付宝拿出了这个挑战微信的大招","isRecommend":false,"create_user_id":1,"isComment":"no","releaseTime":1533172860000,"coverImg":"20180802092133900_908.png","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":45,"isTop":false,"newsTitle":"公测近一年，支付宝拿出了这个挑战微信的大招","checkState":2,"createUser":"超级管理员","id":33,"isImgNews":false,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"Vue 全站缓存之 keep-alive ： 动态移除缓存","isRecommend":false,"create_user_id":1,"isComment":"no","releaseTime":1533172860000,"coverImg":"20180802092140095_771.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":21,"isTop":false,"newsTitle":"Vue 全站缓存之 keep-alive ： 动态移除缓存","checkState":2,"createUser":"超级管理员","id":34,"isImgNews":false,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"特斯拉Q2营收同比增43%至40亿美元 净亏7.2亿美元","isRecommend":false,"create_user_id":1,"isComment":"no","releaseTime":1533172860000,"coverImg":"20180802092204667_157.png","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":9,"isTop":false,"newsTitle":"特斯拉Q2营收同比增43%至40亿美元 净亏7.2亿美元","checkState":2,"createUser":"超级管理员","id":35,"isImgNews":false,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"JS 装饰器，一篇就够","isRecommend":true,"create_user_id":1,"isComment":"no","releaseTime":1533172860000,"coverImg":"20180802092201933_139.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":7,"isTop":false,"newsTitle":"JS 装饰器，一篇就够","checkState":2,"createUser":"超级管理员","id":36,"isImgNews":false,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"全球首款易碎发烧耳机：森海塞尔HD820初烧体验，万元声音这么响","isRecommend":false,"create_user_id":1,"isComment":"no","releaseTime":1533195180000,"coverImg":"20180802153523604_832.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":5,"isTop":false,"newsTitle":"全球首款易碎发烧耳机：森海塞尔HD820初烧体验，万元声音这么响","checkState":2,"createUser":"超级管理员","id":37,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"腾讯市值重挫1600亿美元：股价与目标价之差创纪录","isRecommend":false,"create_user_id":1,"isComment":"no","releaseTime":1533195360000,"coverImg":"20180802153632635_960.png","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":6,"isTop":false,"newsTitle":"腾讯市值重挫1600亿美元：股价与目标价之差创纪录","checkState":2,"createUser":"超级管理员","id":38,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"OPPO F9真机上手照曝光：背影光彩炫目","isRecommend":false,"create_user_id":1,"isComment":"no","releaseTime":1533195360000,"coverImg":"20180802153724715_165.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":4,"isTop":false,"newsTitle":"OPPO F9真机上手照曝光：背影光彩炫目","checkState":2,"createUser":"超级管理员","id":39,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"邻家极路由夺命连环call，P2P开始引爆创投圈","isRecommend":false,"create_user_id":1,"isComment":"no","releaseTime":1533195420000,"coverImg":"20180802153843945_499.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":4,"isTop":false,"newsTitle":"邻家极路由夺命连环call，P2P开始引爆创投圈","checkState":2,"createUser":"超级管理员","id":40,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"拼多多上7.5元一桶的婴儿奶粉，让我们无需再去争论这家公司售卖的是假冒货还是劣质货\u2014\u2014把有食用安全隐患的产品出售给婴儿，这家公司的原罪不言而喻。道德指责已经过多，值得讨论的是，美国这样的成熟资本市场会如何对待有原罪的公司？","isRecommend":false,"create_user_id":1,"isComment":"no","releaseTime":1533195540000,"coverImg":"20180802153942845_473.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":8,"isTop":false,"newsTitle":"拼多多的罪与罚","checkState":2,"createUser":"超级管理员","id":41,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false}]
     * page : {"currentPage":2,"pageSize":10,"recordCount":40,"pageCount":4,"beginPageIndex":1,"endPageIndex":4}
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     */

    public String msg;
    public int code;
    public PageBean page;
    public String attachmentPath;
    public List<DataBean> data;

    public static class PageBean {
        /**
         * currentPage : 2
         * pageSize : 10
         * recordCount : 40
         * pageCount : 4
         * beginPageIndex : 1
         * endPageIndex : 4
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
         * newsIntro : 现在做 Web 全景合适吗？
         * isRecommend : false
         * create_user_id : 1
         * isComment : no
         * releaseTime : 1533172800000
         * coverImg : 20180802092113631_521.jpg
         * classifyId : 313
         * isAppMessage : false
         * permission : park_management
         * sort : 0
         * paramName : 园区动态
         * pageView : 4
         * isTop : false
         * newsTitle : 现在做 Web 全景合适吗？
         * checkState : 2
         * createUser : 超级管理员
         * id : 32
         * isImgNews : false
         * isHasTimeliness : false
         * isSendMessage : false
         */

        public String newsIntro;
        public boolean isRecommend;
        public int create_user_id;
        public String isComment;
        public long releaseTime;
        public String coverImg;
        public int classifyId;
        public boolean isAppMessage;
        public String permission;
        public int sort;
        public String paramName;
        public int pageView;
        public boolean isTop;
        public String newsTitle;
        public int checkState;
        public String createUser;
        public int id;
        public boolean isImgNews;
        public boolean isHasTimeliness;
        public boolean isSendMessage;
    }
}
