package com.hengkai.itc.network.entity;

/**
 * Created by Harry on 2018/8/20.
 */
public class LoginEntity {


    /**
     * msg : 登录成功
     * code : 0
     * data : {"user":{"id":1,"loginName":"admin","password":"2b232ee4b2fb88f1852c918d7c070098b52d8035","plainPassword":null,"salt":"97ad6dd0fd22e803","phone":"123456","email":null,"status":0,"usertype":0,"createTime":"2018-07-20T02:32:35.000+0000","createUser":1,"updateTime":null,"updateUser":null,"isDelete":false,"name":"超级管理员","headPortraitLink":"20180818151346648_724.jpg"}}
     * isDataReport : false
     * attachmentPath : http://192.168.2.157:8084/ITC/file/
     * token : 5E5ED7E311F7309C88E6B5A0B5C868D7
     */

    public String msg;
    public int code;
    public DataBean data;
    public boolean isDataReport;
    public String attachmentPath;
    public String token;

    public static class DataBean {
        /**
         * user : {"id":1,"loginName":"admin","password":"2b232ee4b2fb88f1852c918d7c070098b52d8035","plainPassword":null,"salt":"97ad6dd0fd22e803","phone":"123456","email":null,"status":0,"usertype":0,"createTime":"2018-07-20T02:32:35.000+0000","createUser":1,"updateTime":null,"updateUser":null,"isDelete":false,"name":"超级管理员","headPortraitLink":"20180818151346648_724.jpg"}
         */

        public UserBean user;

        public static class UserBean {
            /**
             * id : 1
             * loginName : admin
             * password : 2b232ee4b2fb88f1852c918d7c070098b52d8035
             * plainPassword : null
             * salt : 97ad6dd0fd22e803
             * phone : 123456
             * email : null
             * status : 0
             * usertype : 0
             * createTime : 2018-07-20T02:32:35.000+0000
             * createUser : 1
             * updateTime : null
             * updateUser : null
             * isDelete : false
             * name : 超级管理员
             * headPortraitLink : 20180818151346648_724.jpg
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
            public String createTime;
            public int createUser;
            public Object updateTime;
            public Object updateUser;
            public boolean isDelete;
            public String name;
            public String headPortraitLink;
        }
    }
}
