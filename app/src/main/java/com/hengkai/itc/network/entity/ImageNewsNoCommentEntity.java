package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/24.
 * 图片新闻, 没有评论
 */
public class ImageNewsNoCommentEntity extends NewsDetailEntity {


    /**
     * msg : 查询成功
     * code : 1
     * data : {"newsIntro":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","imgNewsList":[{"id":167,"imgUrl":"20180802154457175_459.jpg","imgDesc":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","newsId":45,"sort":0,"isDelete":false}],"releaseTime":1533195840000,"coverImg":"20180802154453505_839.jpg","classifyId":313,"permission":"park_management","paramName":"园区动态","type":"sys_param","pageView":81,"seoIntro":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","newsList":[{"newsIntro":"2018年8月2日，北京，地铁4号线菜市口站公益画廊设置在地铁站，能让来往行人驻足观看，展出的是特殊儿童的画作及衍生品。据了解，近日有网友反映，该区域展出的画作遭到破坏。目前这处展示区归地铁4号地管理，展区附近执勤人员表示，目前人手有限建议装玻璃窗阻隔。","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195660000,"coverImg":"20180802154200195_183.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":38,"isTop":false,"newsTitle":"北京地铁站公益画廊遭涂鸦 半年\"面目全非\"","checkState":2,"createUser":"超级管理员","id":43,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"粉丝的疯狂行为很多时候都让人难以想象，美国一位大学生Jordan Baker是巨石强森的影迷，为了引起偶像的注意，甚至和巨石强森见面，他连续一百天在推特上发文深情呼唤巨石强森，除此之外还用各种奇特照片图片引起巨石强森的注意力。","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195600000,"coverImg":"20180802154045855_940.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":16,"isTop":false,"newsTitle":"疯狂粉丝连发100天推文要和巨石强森见面，结果喜感","checkState":2,"createUser":"超级管理员","id":42,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"拼多多上7.5元一桶的婴儿奶粉，让我们无需再去争论这家公司售卖的是假冒货还是劣质货\u2014\u2014把有食用安全隐患的产品出售给婴儿，这家公司的原罪不言而喻。道德指责已经过多，值得讨论的是，美国这样的成熟资本市场会如何对待有原罪的公司？","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195540000,"coverImg":"20180802153942845_473.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":8,"isTop":false,"newsTitle":"拼多多的罪与罚","checkState":2,"createUser":"超级管理员","id":41,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false}],"seoKeyWord":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","newsTitle":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","checkState":2,"createUser":"超级管理员","id":45,"isImgNews":true,"isHasTimeliness":false}
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     */

    public String msg;
    public int code;
    public DataBean data;
    public String attachmentPath;

    public static class DataBean {
        /**
         * newsIntro : 当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。
         * imgNewsList : [{"id":167,"imgUrl":"20180802154457175_459.jpg","imgDesc":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","newsId":45,"sort":0,"isDelete":false}]
         * releaseTime : 1533195840000
         * coverImg : 20180802154453505_839.jpg
         * classifyId : 313
         * permission : park_management
         * paramName : 园区动态
         * type : sys_param
         * pageView : 81
         * seoIntro : 在朝鲜阵亡美军遗骸回国仪式在韩国举行
         * newsList : [{"newsIntro":"2018年8月2日，北京，地铁4号线菜市口站公益画廊设置在地铁站，能让来往行人驻足观看，展出的是特殊儿童的画作及衍生品。据了解，近日有网友反映，该区域展出的画作遭到破坏。目前这处展示区归地铁4号地管理，展区附近执勤人员表示，目前人手有限建议装玻璃窗阻隔。","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195660000,"coverImg":"20180802154200195_183.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":38,"isTop":false,"newsTitle":"北京地铁站公益画廊遭涂鸦 半年\"面目全非\"","checkState":2,"createUser":"超级管理员","id":43,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"粉丝的疯狂行为很多时候都让人难以想象，美国一位大学生Jordan Baker是巨石强森的影迷，为了引起偶像的注意，甚至和巨石强森见面，他连续一百天在推特上发文深情呼唤巨石强森，除此之外还用各种奇特照片图片引起巨石强森的注意力。","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195600000,"coverImg":"20180802154045855_940.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":16,"isTop":false,"newsTitle":"疯狂粉丝连发100天推文要和巨石强森见面，结果喜感","checkState":2,"createUser":"超级管理员","id":42,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"拼多多上7.5元一桶的婴儿奶粉，让我们无需再去争论这家公司售卖的是假冒货还是劣质货\u2014\u2014把有食用安全隐患的产品出售给婴儿，这家公司的原罪不言而喻。道德指责已经过多，值得讨论的是，美国这样的成熟资本市场会如何对待有原罪的公司？","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195540000,"coverImg":"20180802153942845_473.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":8,"isTop":false,"newsTitle":"拼多多的罪与罚","checkState":2,"createUser":"超级管理员","id":41,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false}]
         * seoKeyWord : 在朝鲜阵亡美军遗骸回国仪式在韩国举行
         * newsTitle : 在朝鲜阵亡美军遗骸回国仪式在韩国举行
         * checkState : 2
         * createUser : 超级管理员
         * id : 45
         * isImgNews : true
         * isHasTimeliness : false
         */

        public String newsIntro;
        public long releaseTime;
        public String coverImg;
        public int classifyId;
        public String permission;
        public String paramName;
        public String type;
        public int pageView;
        public String seoIntro;
        public String seoKeyWord;
        public String newsTitle;
        public int checkState;
        public String createUser;
        public int id;
        public boolean isImgNews;
        public boolean isHasTimeliness;
        public List<ImgNewsListBean> imgNewsList;
        public List<NewsListBean> newsList;

        public static class ImgNewsListBean {
            /**
             * id : 167
             * imgUrl : 20180802154457175_459.jpg
             * imgDesc : 当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。
             * newsId : 45
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

        public static class NewsListBean {
            /**
             * newsIntro : 2018年8月2日，北京，地铁4号线菜市口站公益画廊设置在地铁站，能让来往行人驻足观看，展出的是特殊儿童的画作及衍生品。据了解，近日有网友反映，该区域展出的画作遭到破坏。目前这处展示区归地铁4号地管理，展区附近执勤人员表示，目前人手有限建议装玻璃窗阻隔。
             * isRecommend : false
             * create_user_id : 1
             * isComment : yes
             * releaseTime : 1533195660000
             * coverImg : 20180802154200195_183.jpg
             * classifyId : 313
             * isAppMessage : false
             * permission : park_management
             * sort : 0
             * paramName : 园区动态
             * pageView : 38
             * isTop : false
             * newsTitle : 北京地铁站公益画廊遭涂鸦 半年"面目全非"
             * checkState : 2
             * createUser : 超级管理员
             * id : 43
             * isImgNews : true
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
}
