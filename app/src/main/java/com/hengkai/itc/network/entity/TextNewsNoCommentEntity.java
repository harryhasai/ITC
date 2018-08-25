package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/24.
 * 文字新闻, 没有评论
 */
public class TextNewsNoCommentEntity extends NewsDetailEntity {


    /**
     * msg : 查询成功
     * code : 1
     * data : {"newsIntro":"7月24日，日本交易所BtcBox副总裁柳岩终于可以稍微歇口气了，日本金融厅接受了BtcBox上交整改计划。","releaseTime":1533172260000,"coverImg":"20180802091347128_236.png","classifyId":313,"permission":"park_management","paramName":"园区动态","type":"sys_param","content":"<p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">柳岩告诉网易科技，这次审查，金融厅基本按照金融机构的要求对交易所进行审查的。虽然据日本《日经亚洲评论》7月17日报道，日本已经对其金融监管机构\u2014\u2014金融服务管理局（FSA）进行了全面改革。新成立的战略发展和管理局，处理涉及数字货币市场洗钱等问题。很多专家分析认为，日本此举将把数字货币作为金融产品正式监管。此次网易科技通过走访日本各交易所等机构发现，实际在监管中，日本金融厅已经开始实施了这种转变。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">与日本严格监管相比，中国海外的交易所都还在草莽之中野蛮生长。但是监管迟早都会到来，成了戴在每个人头上的紧箍咒。大家紧紧盯着日本政府的一举一动，揣测着这些会为中国政府将来监管带来启示和借鉴作用。<\/p><p><br/><\/p>","pageView":8,"seoIntro":"独家探访！揭秘日本数字货币交易所的监管之路","newsList":[{"newsIntro":"2018年8月2日，北京，地铁4号线菜市口站公益画廊设置在地铁站，能让来往行人驻足观看，展出的是特殊儿童的画作及衍生品。据了解，近日有网友反映，该区域展出的画作遭到破坏。目前这处展示区归地铁4号地管理，展区附近执勤人员表示，目前人手有限建议装玻璃窗阻隔。","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195660000,"coverImg":"20180802154200195_183.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":38,"isTop":false,"newsTitle":"北京地铁站公益画廊遭涂鸦 半年\"面目全非\"","checkState":2,"createUser":"超级管理员","id":43,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"粉丝的疯狂行为很多时候都让人难以想象，美国一位大学生Jordan Baker是巨石强森的影迷，为了引起偶像的注意，甚至和巨石强森见面，他连续一百天在推特上发文深情呼唤巨石强森，除此之外还用各种奇特照片图片引起巨石强森的注意力。","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195600000,"coverImg":"20180802154045855_940.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":16,"isTop":false,"newsTitle":"疯狂粉丝连发100天推文要和巨石强森见面，结果喜感","checkState":2,"createUser":"超级管理员","id":42,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"拼多多上7.5元一桶的婴儿奶粉，让我们无需再去争论这家公司售卖的是假冒货还是劣质货\u2014\u2014把有食用安全隐患的产品出售给婴儿，这家公司的原罪不言而喻。道德指责已经过多，值得讨论的是，美国这样的成熟资本市场会如何对待有原罪的公司？","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195540000,"coverImg":"20180802153942845_473.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":8,"isTop":false,"newsTitle":"拼多多的罪与罚","checkState":2,"createUser":"超级管理员","id":41,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false}],"seoKeyWord":"独家探访！揭秘日本数字货币交易所的监管之路","newsTitle":"独家探访！揭秘日本数字货币交易所的监管之路","checkState":2,"createUser":"超级管理员","id":22,"isImgNews":false,"isHasTimeliness":false}
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     */

    public String msg;
    public int code;
    public DataBean data;
    public String attachmentPath;

    public static class DataBean {
        /**
         * newsIntro : 7月24日，日本交易所BtcBox副总裁柳岩终于可以稍微歇口气了，日本金融厅接受了BtcBox上交整改计划。
         * releaseTime : 1533172260000
         * coverImg : 20180802091347128_236.png
         * classifyId : 313
         * permission : park_management
         * paramName : 园区动态
         * type : sys_param
         * content : <p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">柳岩告诉网易科技，这次审查，金融厅基本按照金融机构的要求对交易所进行审查的。虽然据日本《日经亚洲评论》7月17日报道，日本已经对其金融监管机构——金融服务管理局（FSA）进行了全面改革。新成立的战略发展和管理局，处理涉及数字货币市场洗钱等问题。很多专家分析认为，日本此举将把数字货币作为金融产品正式监管。此次网易科技通过走访日本各交易所等机构发现，实际在监管中，日本金融厅已经开始实施了这种转变。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">与日本严格监管相比，中国海外的交易所都还在草莽之中野蛮生长。但是监管迟早都会到来，成了戴在每个人头上的紧箍咒。大家紧紧盯着日本政府的一举一动，揣测着这些会为中国政府将来监管带来启示和借鉴作用。</p><p><br/></p>
         * pageView : 8
         * seoIntro : 独家探访！揭秘日本数字货币交易所的监管之路
         * newsList : [{"newsIntro":"2018年8月2日，北京，地铁4号线菜市口站公益画廊设置在地铁站，能让来往行人驻足观看，展出的是特殊儿童的画作及衍生品。据了解，近日有网友反映，该区域展出的画作遭到破坏。目前这处展示区归地铁4号地管理，展区附近执勤人员表示，目前人手有限建议装玻璃窗阻隔。","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195660000,"coverImg":"20180802154200195_183.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":38,"isTop":false,"newsTitle":"北京地铁站公益画廊遭涂鸦 半年\"面目全非\"","checkState":2,"createUser":"超级管理员","id":43,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"粉丝的疯狂行为很多时候都让人难以想象，美国一位大学生Jordan Baker是巨石强森的影迷，为了引起偶像的注意，甚至和巨石强森见面，他连续一百天在推特上发文深情呼唤巨石强森，除此之外还用各种奇特照片图片引起巨石强森的注意力。","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195600000,"coverImg":"20180802154045855_940.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":16,"isTop":false,"newsTitle":"疯狂粉丝连发100天推文要和巨石强森见面，结果喜感","checkState":2,"createUser":"超级管理员","id":42,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false},{"newsIntro":"拼多多上7.5元一桶的婴儿奶粉，让我们无需再去争论这家公司售卖的是假冒货还是劣质货\u2014\u2014把有食用安全隐患的产品出售给婴儿，这家公司的原罪不言而喻。道德指责已经过多，值得讨论的是，美国这样的成熟资本市场会如何对待有原罪的公司？","isRecommend":false,"create_user_id":1,"isComment":"yes","releaseTime":1533195540000,"coverImg":"20180802153942845_473.jpg","classifyId":313,"isAppMessage":false,"permission":"park_management","sort":0,"paramName":"园区动态","pageView":8,"isTop":false,"newsTitle":"拼多多的罪与罚","checkState":2,"createUser":"超级管理员","id":41,"isImgNews":true,"isHasTimeliness":false,"isSendMessage":false}]
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
        public List<NewsListBean> newsList;

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
