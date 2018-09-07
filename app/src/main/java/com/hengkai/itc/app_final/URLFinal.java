package com.hengkai.itc.app_final;

import com.blankj.utilcode.util.AppUtils;

/**
 * Created by Harry on 2018/8/13.
 */
public class URLFinal {

    /**
     * 版本控制
     */
    public static final String VERSION = AppUtils.getAppVersionName();
    /**
     * baseURL
     */
//    public static final String BASE_URL = "http://192.168.2.18/ITCAPP/";
    public static final String BASE_URL = "http://192.168.2.199:8010/ITCAPP/";
//    public static final String BASE_URL = "http://192.168.2.77:8080/ITCAPP/";

    /**
     * 资讯
     */
    public static final String INFORMATION_CONTENT = "news/selectAllClassify";
    /**
     * 登录
     */
    public static final String LOGIN = "user/moveUserLogin";
    /**
     * 修改头像
     */
    public static final String MODIFY_HEADER = "user/headPortraitUploading";
    /**
     * 数据上报
     */
    public static final String DATA_REPORT = "enterprisedatareport/insert";
    /**
     * 首页 - 获取新闻列表
     */
    public static final String GET_NEWS_LIST_HOME = "news/selectNewsByClassifyId";
    /**
     * 新闻详情
     */
    public static final String GET_NEWS_DETAIL = "news/selectNewDetails";
    /**
     * 新闻详情 - 评论
     */
    public static final String GO_TO_COMMENT = "comment/insertComment";
    /**
     * 获取我的评论列表
     */
    public static final String MY_COMMENT_LIST = "comment/getMyCommentListData";
    /**
     * 我的基金 - 列表
     */
    public static final String MY_FUND_LIST = "portalFund/getListData";
    /**
     * 我的基金列表详情
     */
    public static final String MY_FUND_DETAIL = "portalFund/getDetailsData";
    /**
     * 我的基金列表详情 - 报名
     */
    public static final String MY_FUND_DETAIL_SIGN_UP = "portalFund/insertexamine";
    /**
     * 我的基金申请记录
     */
    public static final String FUND_APPLY_RECORD = "portalFund/getMyExamine";
    /**
     * 修改密码
     */
    public static final String MODIFY_PASSWORD = "user/updatePassWord";
    /**
     * 资讯 - 活动 - 活动列表
     */
    public static final String ACTIVITY_LIST = "activity/selectactivitybytype";
    /**
     * 我的活动报名列表
     */
    public static final String MY_SIGN_UP_LIST = "activity/selectactivitylistbyuser";
    /**
     * 资讯 - 活动 - 活动列表 - 详情
     */
    public static final String ACTIVITY_LIST_DETAIL = "activity/todetail";
    /**
     * 发送并验证手机号
     */
    public static final String SEND_VERIFICATION_CODE = "user/messageUpdatePassword";
    /**
     * 验证验证码
     */
    public static final String VERIFY_VERIFICATION_CODE = "user/SelectVerify";
    /**
     * 通过验证后修改密码
     */
    public static final String MODIFY_PASSWORD_VERIFICATION_CODE = "user/updateVerifyPassword";
}
