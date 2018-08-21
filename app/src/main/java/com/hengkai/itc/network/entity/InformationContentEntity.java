package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/20.
 */
public class InformationContentEntity {

    /**
     * msg : 查询成功
     * code : 1
     * data : [{"id":341,"permission":"other_management","permissionDescription":"三方机构信息","paramName":"其他","paramValue":"other_msg","sort":5,"createUserId":1,"createTime":"2018-08-16T02:14:14.000+0000","updateUserId":1,"updateTime":"2018-08-16T02:14:14.000+0000","isDelete":false},{"id":340,"permission":"other_management","permissionDescription":"三方机构信息","paramName":"推广类","paramValue":"generalize_msg","sort":4,"createUserId":1,"createTime":"2018-08-16T02:11:46.000+0000","updateUserId":1,"updateTime":"2018-08-16T02:11:46.000+0000","isDelete":false},{"id":339,"permission":"other_management","permissionDescription":"三方机构信息","paramName":"法律类","paramValue":"law_msg","sort":4,"createUserId":1,"createTime":"2018-08-16T02:11:12.000+0000","updateUserId":1,"updateTime":"2018-08-16T02:11:12.000+0000","isDelete":false},{"id":338,"permission":"other_management","permissionDescription":"三方机构信息","paramName":"代办类","paramValue":"agency_msg","sort":3,"createUserId":1,"createTime":"2018-08-16T02:10:38.000+0000","updateUserId":1,"updateTime":"2018-08-16T02:10:38.000+0000","isDelete":false},{"id":337,"permission":"other_management","permissionDescription":"三方机构信息","paramName":"认证类","paramValue":"approve_msg","sort":1,"createUserId":1,"createTime":"2018-08-16T02:10:03.000+0000","updateUserId":1,"updateTime":"2018-08-16T02:10:03.000+0000","isDelete":false},{"id":336,"permission":"other_management","permissionDescription":"三方机构信息","paramName":"金融类","paramValue":"financial_msg","sort":0,"createUserId":1,"createTime":"2018-08-16T02:08:36.000+0000","updateUserId":1,"updateTime":"2018-08-16T02:08:36.000+0000","isDelete":false},{"id":335,"permission":"activityType","permissionDescription":"活动类型","paramName":"活动类型4","paramValue":"4444","sort":0,"createUserId":1,"createTime":"2018-08-09T01:55:16.000+0000","updateUserId":1,"updateTime":"2018-08-16T02:13:39.000+0000","isDelete":false},{"id":334,"permission":"activityType","permissionDescription":"活动类型","paramName":"4444","paramValue":"4444","sort":0,"createUserId":1,"createTime":"2018-08-09T01:55:06.000+0000","updateUserId":1,"updateTime":"2018-08-16T02:13:48.000+0000","isDelete":false},{"id":333,"permission":"activityType","permissionDescription":"活动类型","paramName":"33","paramValue":"3333","sort":0,"createUserId":1,"createTime":"2018-08-09T01:54:56.000+0000","updateUserId":1,"updateTime":"2018-08-16T02:14:04.000+0000","isDelete":false},{"id":332,"permission":"enterprise_management","permissionDescription":"园区企业信息","paramName":"咨询信息","paramValue":"consulting_msg","sort":0,"createUserId":1,"createTime":"2018-08-01T07:39:37.000+0000","updateUserId":1,"updateTime":"2018-08-01T07:39:37.000+0000","isDelete":false},{"id":331,"permission":"colleges_management","permissionDescription":"院校信息","paramName":"分类1","paramValue":"分类1","sort":0,"createUserId":1,"createTime":"2018-08-01T07:42:46.000+0000","updateUserId":1,"updateTime":"2018-08-01T07:42:46.000+0000","isDelete":false},{"id":329,"permission":"enterprise_management","permissionDescription":"园区企业信息","paramName":"供求信息","paramValue":"sd_msg","sort":0,"createUserId":1,"createTime":"2018-08-01T07:39:37.000+0000","updateUserId":1,"updateTime":"2018-08-01T07:39:37.000+0000","isDelete":false},{"id":313,"permission":"park_management","permissionDescription":"园区信息管理","paramName":"园区动态","paramValue":"园区动态","sort":0,"createUserId":1,"createTime":"2018-07-27T01:36:36.000+0000","updateUserId":1,"updateTime":"2018-07-27T01:36:36.000+0000","isDelete":false},{"id":310,"permission":"park_management","permissionDescription":"园区信息管理","paramName":"园区服务","paramValue":"园区服务","sort":0,"createUserId":1,"createTime":"2018-07-27T01:36:07.000+0000","updateUserId":1,"updateTime":"2018-07-27T01:36:07.000+0000","isDelete":false},{"id":309,"permission":"park_management","permissionDescription":"园区信息管理","paramName":"行业政策","paramValue":"行业政策","sort":0,"createUserId":1,"createTime":"2018-07-27T01:35:43.000+0000","updateUserId":1,"updateTime":"2018-07-27T01:35:43.000+0000","isDelete":false},{"id":308,"permission":"park_management","permissionDescription":"园区信息管理","paramName":"园区通知","paramValue":"园区通知","sort":0,"createUserId":1,"createTime":"2018-07-27T01:35:23.000+0000","updateUserId":1,"updateTime":"2018-07-27T01:35:23.000+0000","isDelete":false},{"id":302,"permission":"activityType","permissionDescription":"1","paramName":"活动类型2","paramValue":"1","sort":0,"createUserId":1,"createTime":"2018-07-25T02:18:25.000+0000","updateUserId":1,"updateTime":"2018-07-25T02:18:25.000+0000","isDelete":false},{"id":301,"permission":"activityType","permissionDescription":"活动类型","paramName":"活动类型1","paramValue":"1","sort":0,"createUserId":1,"createTime":"2018-07-25T02:13:31.000+0000","updateUserId":1,"updateTime":"2018-07-25T02:13:31.000+0000","isDelete":false}]
     */

    public String msg;
    public int code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 341
         * permission : other_management
         * permissionDescription : 三方机构信息
         * paramName : 其他
         * paramValue : other_msg
         * sort : 5
         * createUserId : 1
         * createTime : 2018-08-16T02:14:14.000+0000
         * updateUserId : 1
         * updateTime : 2018-08-16T02:14:14.000+0000
         * isDelete : false
         */

        public int id;
        public String permission;
        public String permissionDescription;
        public String paramName;
        public String paramValue;
        public int sort;
        public int createUserId;
        public String createTime;
        public int updateUserId;
        public String updateTime;
        public boolean isDelete;
    }
}
