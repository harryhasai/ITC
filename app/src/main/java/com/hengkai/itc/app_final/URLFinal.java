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
    public static final String BASE_URL = "http://192.168.2.157:8084/ITCAPP/";
//    public static final String BASE_URL = "http://192.168.2.22:8080/ITCAPP/";

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
     * 获取我的评论列表
     */
    public static final String MY_COMMENT_LIST = "comment/getMyCommentListData";
}
