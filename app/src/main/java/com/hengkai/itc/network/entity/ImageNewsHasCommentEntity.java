package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/24.
 * 图片新闻, 有评论
 */
public class ImageNewsHasCommentEntity extends NewsDetailEntity {

    /**
     * msg : 查询成功
     * code : 1
     * data : {"newsIntro":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","commentList":[{"newsIntro":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","isReplied":true,"createUserId":1,"commentUser":"超级管理员","permission":"sys_news","type":0,"content":"哎呀妈呀","replyCreateTime":1535092920000,"replyUser":"超级管理员","commentImg":"20180821085813233_303.jpg","createTime":1533548069000,"replyCreateUserId":1,"newsTitle":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","replyId":33,"id":21,"replyContent":"会返回","replyImg":"20180821085813233_303.jpg","objectId":45},{"newsIntro":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","isReplied":true,"createUserId":1,"commentUser":"超级管理员","permission":"sys_news","type":0,"content":"哎呀妈呀","replyCreateTime":1535092930000,"replyUser":"超级管理员","commentImg":"20180821085813233_303.jpg","createTime":1533548063000,"replyCreateUserId":1,"newsTitle":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","replyId":34,"id":20,"replyContent":"huihui","replyImg":"20180821085813233_303.jpg","objectId":45},{"newsIntro":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","isReplied":false,"createUserId":1,"commentImg":"20180821085813233_303.jpg","createTime":1533547965000,"newsTitle":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","commentUser":"超级管理员","permission":"sys_news","id":19,"type":0,"objectId":45,"content":"11111111111111111111"}],"imgNewsList":[{"id":167,"imgUrl":"20180802154457175_459.jpg","imgDesc":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","newsId":45,"sort":0,"isDelete":false}],"releaseTime":1533195840000,"coverImg":"20180802154453505_839.jpg","classifyId":313,"permission":"park_management","paramName":"园区动态","type":"sys_param","pageView":80,"seoIntro":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","seoKeyWord":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","newsTitle":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","checkState":2,"createUser":"超级管理员","id":45,"isImgNews":true,"isHasTimeliness":false}
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     */

    public String msg;
    public int code;
    public DataBean data;
    public String attachmentPath;

    public static class DataBean {
        /**
         * newsIntro : 当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。
         * commentList : [{"newsIntro":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","isReplied":true,"createUserId":1,"commentUser":"超级管理员","permission":"sys_news","type":0,"content":"哎呀妈呀","replyCreateTime":1535092920000,"replyUser":"超级管理员","commentImg":"20180821085813233_303.jpg","createTime":1533548069000,"replyCreateUserId":1,"newsTitle":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","replyId":33,"id":21,"replyContent":"会返回","replyImg":"20180821085813233_303.jpg","objectId":45},{"newsIntro":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","isReplied":true,"createUserId":1,"commentUser":"超级管理员","permission":"sys_news","type":0,"content":"哎呀妈呀","replyCreateTime":1535092930000,"replyUser":"超级管理员","commentImg":"20180821085813233_303.jpg","createTime":1533548063000,"replyCreateUserId":1,"newsTitle":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","replyId":34,"id":20,"replyContent":"huihui","replyImg":"20180821085813233_303.jpg","objectId":45},{"newsIntro":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","isReplied":false,"createUserId":1,"commentImg":"20180821085813233_303.jpg","createTime":1533547965000,"newsTitle":"在朝鲜阵亡美军遗骸回国仪式在韩国举行","commentUser":"超级管理员","permission":"sys_news","id":19,"type":0,"objectId":45,"content":"11111111111111111111"}]
         * imgNewsList : [{"id":167,"imgUrl":"20180802154457175_459.jpg","imgDesc":"当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。","newsId":45,"sort":0,"isDelete":false}]
         * releaseTime : 1533195840000
         * coverImg : 20180802154453505_839.jpg
         * classifyId : 313
         * permission : park_management
         * paramName : 园区动态
         * type : sys_param
         * pageView : 80
         * seoIntro : 在朝鲜阵亡美军遗骸回国仪式在韩国举行
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
        public List<CommentListBean> commentList;
        public List<ImgNewsListBean> imgNewsList;

        public static class CommentListBean {
            /**
             * newsIntro : 当地时间2018年8月1日，韩国京畿道，近日从朝鲜接回的朝鲜战争时期在朝鲜地区阵亡的55具美军遗骸当天将运往夏威夷，遗骸回国仪式当天下午在京畿道乌山美国空军基地举行。
             * isReplied : true
             * createUserId : 1
             * commentUser : 超级管理员
             * permission : sys_news
             * type : 0
             * content : 哎呀妈呀
             * replyCreateTime : 1535092920000
             * replyUser : 超级管理员
             * commentImg : 20180821085813233_303.jpg
             * createTime : 1533548069000
             * replyCreateUserId : 1
             * newsTitle : 在朝鲜阵亡美军遗骸回国仪式在韩国举行
             * replyId : 33
             * id : 21
             * replyContent : 会返回
             * replyImg : 20180821085813233_303.jpg
             * objectId : 45
             */

            public String newsIntro;
            public boolean isReplied;
            public int createUserId;
            public String commentUser;
            public String permission;
            public int type;
            public String content;
            public long replyCreateTime;
            public String replyUser;
            public String commentImg;
            public long createTime;
            public int replyCreateUserId;
            public String newsTitle;
            public int replyId;
            public int id;
            public String replyContent;
            public String replyImg;
            public int objectId;
        }

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
    }
}
