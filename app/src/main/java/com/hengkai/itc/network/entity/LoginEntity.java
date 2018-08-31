package com.hengkai.itc.network.entity;

/**
 * Created by Harry on 2018/8/20.
 */
public class LoginEntity {

    /**
     * msg : 登录成功
     * code : 1
     * data : {"user":{"id":1,"loginName":"admin","password":"6064d4074e4ca84503688ae23d05c993eddcbcb1","plainPassword":null,"salt":"4453fbae2c028365","phone":"admin","email":null,"status":0,"usertype":0,"createTime":1532053955000,"createUser":1,"updateTime":null,"updateUser":null,"isDelete":false,"name":"超级管理员","headPortraitLink":"20180821085813233_303.jpg"}}
     * isDataReport : false
     * DateReport : true
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     * token : 9CB5BD0E59B605A562B625CF08F292FF
     */

    public String msg;
    public int code;
    public DataBean data;
    /**
     * 控制数据上报
     */
    public boolean isDataReport;
    /**
     * 控制统计分析
     */
    public boolean DateReport;
    public String attachmentPath;
    public String token;

    public static class DataBean {
        /**
         * user : {"id":1,"loginName":"admin","password":"6064d4074e4ca84503688ae23d05c993eddcbcb1","plainPassword":null,"salt":"4453fbae2c028365","phone":"admin","email":null,"status":0,"usertype":0,"createTime":1532053955000,"createUser":1,"updateTime":null,"updateUser":null,"isDelete":false,"name":"超级管理员","headPortraitLink":"20180821085813233_303.jpg"}
         */

        public UserBean user;

        public static class UserBean {
            /**
             * id : 1
             * loginName : admin
             * password : 6064d4074e4ca84503688ae23d05c993eddcbcb1
             * plainPassword : null
             * salt : 4453fbae2c028365
             * phone : admin
             * email : null
             * status : 0
             * usertype : 0
             * createTime : 1532053955000
             * createUser : 1
             * updateTime : null
             * updateUser : null
             * isDelete : false
             * name : 超级管理员
             * headPortraitLink : 20180821085813233_303.jpg
             */

            public int id;
            public String loginName;
            public String password;
            public Object plainPassword;
            public String salt;
            public String phone;
            public String email;
            public int status;
            public int usertype;
            public long createTime;
            public int createUser;
            public Object updateTime;
            public Object updateUser;
            public boolean isDelete;
            public String name;
            public String headPortraitLink;
        }
    }
}
