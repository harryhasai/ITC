package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/24.
 * 文字新闻, 有评论
 */
public class TextNewsHasCommentEntity extends NewsDetailEntity {


    /**
     * msg : 查询成功
     * code : 1
     * data : {"newsIntro":"7月24日，日本交易所BtcBox副总裁柳岩终于可以稍微歇口气了，日本金融厅接受了BtcBox上交整改计划。","commentList":[],"releaseTime":1533172260000,"coverImg":"20180802091347128_236.png","classifyId":313,"permission":"park_management","paramName":"园区动态","type":"sys_param","content":"<p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">柳岩告诉网易科技，这次审查，金融厅基本按照金融机构的要求对交易所进行审查的。虽然据日本《日经亚洲评论》7月17日报道，日本已经对其金融监管机构\u2014\u2014金融服务管理局（FSA）进行了全面改革。新成立的战略发展和管理局，处理涉及数字货币市场洗钱等问题。很多专家分析认为，日本此举将把数字货币作为金融产品正式监管。此次网易科技通过走访日本各交易所等机构发现，实际在监管中，日本金融厅已经开始实施了这种转变。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">与日本严格监管相比，中国海外的交易所都还在草莽之中野蛮生长。但是监管迟早都会到来，成了戴在每个人头上的紧箍咒。大家紧紧盯着日本政府的一举一动，揣测着这些会为中国政府将来监管带来启示和借鉴作用。<\/p><p><br/><\/p>","pageView":9,"seoIntro":"独家探访！揭秘日本数字货币交易所的监管之路","seoKeyWord":"独家探访！揭秘日本数字货币交易所的监管之路","newsTitle":"独家探访！揭秘日本数字货币交易所的监管之路","checkState":2,"createUser":"超级管理员","id":22,"isImgNews":false,"isHasTimeliness":false}
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     */

    public String msg;
    public int code;
    public DataBean data;
    public String attachmentPath;

    public static class DataBean {
        /**
         * newsIntro : 7月24日，日本交易所BtcBox副总裁柳岩终于可以稍微歇口气了，日本金融厅接受了BtcBox上交整改计划。
         * commentList : []
         * releaseTime : 1533172260000
         * coverImg : 20180802091347128_236.png
         * classifyId : 313
         * permission : park_management
         * paramName : 园区动态
         * type : sys_param
         * content : <p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">柳岩告诉网易科技，这次审查，金融厅基本按照金融机构的要求对交易所进行审查的。虽然据日本《日经亚洲评论》7月17日报道，日本已经对其金融监管机构——金融服务管理局（FSA）进行了全面改革。新成立的战略发展和管理局，处理涉及数字货币市场洗钱等问题。很多专家分析认为，日本此举将把数字货币作为金融产品正式监管。此次网易科技通过走访日本各交易所等机构发现，实际在监管中，日本金融厅已经开始实施了这种转变。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">与日本严格监管相比，中国海外的交易所都还在草莽之中野蛮生长。但是监管迟早都会到来，成了戴在每个人头上的紧箍咒。大家紧紧盯着日本政府的一举一动，揣测着这些会为中国政府将来监管带来启示和借鉴作用。</p><p><br/></p>
         * pageView : 9
         * seoIntro : 独家探访！揭秘日本数字货币交易所的监管之路
         * seoKeyWord : 独家探访！揭秘日本数字货币交易所的监管之路
         * newsTitle : 独家探访！揭秘日本数字货币交易所的监管之路
         * checkState : 2
         * createUser : 超级管理员
         * id : 22
         * isImgNews : false
         * isHasTimeliness : false
         */

        public String newsIntro;
        public long releaseTime;
        public String coverImg;
        public int classifyId;
        public String permission;
        public String paramName;
        public String type;
        public String content;
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
    }
}
