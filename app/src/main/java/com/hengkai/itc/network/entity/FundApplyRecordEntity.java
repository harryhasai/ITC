package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/27.
 */
public class FundApplyRecordEntity {

    /**
     * msg : 查询成功
     * code : 0
     * data : [{"createtime":1535354444000,"applycontent":"sdasdasd","fund_id":74,"id":7,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"createtime":1535190063000,"applycontent":"大发发","fund_id":76,"id":6,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"createtime":1534901209000,"applycontent":"23323232323","fund_id":76,"id":5,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"examineContent":"344444","createtime":1534128417000,"examineuser":"超级管理员","applycontent":"2","aggreement":"1","fund_id":76,"id":1,"createuser":"超级管理员","updatetime":1534992419000,"applyuser":"超级管理员","status":"2","updateuser":2},{"applycontent":"23323232323","fund_id":76,"id":4,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"}]
     * count : 5
     */

    public String msg;
    public int code;
    public int count;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * createtime : 1535354444000
         * applycontent : sdasdasd
         * fund_id : 74
         * id : 7
         * createuser : 超级管理员
         * applyuser : 超级管理员
         * status : 2
         * examineContent : 344444
         * examineuser : 超级管理员
         * aggreement : 1
         * updatetime : 1534992419000
         * updateuser : 2
         */

        public long createtime;
        public String applycontent;
        public int fund_id;
        public int id;
        public String createuser;
        public String applyuser;
        public String status;
        public String examineContent;
        public String examineuser;
        public String aggreement;
        public long updatetime;
        public int updateuser;
    }
}
