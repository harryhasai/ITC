package com.hengkai.itc.network.entity;

import java.util.List;

/**
 * Created by Harry on 2018/8/27.
 */
public class FundApplyRecordEntity {

    /**
     * msg : 查询成功
     * code : 1
     * data : [{"createtime":1535955571000,"fund_id":77,"fundname":"322","id":13,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"createtime":1535708146000,"applycontent":"撒旦法","fund_id":79,"fundname":"ew34323232","id":12,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"createtime":1535708032000,"applycontent":"发","fund_id":78,"fundname":"wewerr","id":11,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"createtime":1535708009000,"applycontent":"发大水发","fund_id":79,"fundname":"ew34323232","id":10,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"examineContent":"第三方","createtime":1535707761000,"applycontent":"士大夫","fund_id":80,"fundname":"sdafd dsaf","id":9,"createuser":"超级管理员","applyuser":"超级管理员","status":"1"},{"createtime":1535444210000,"applycontent":"Fsdaaaesfsdfas","aggreement":0,"fund_id":113,"id":8,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"createtime":1535354444000,"applycontent":"sdasdasd","aggreement":0,"fund_id":74,"fundname":"1","id":7,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"createtime":1535190063000,"applycontent":"大发发","aggreement":0,"fund_id":76,"fundname":"11大发","id":6,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"createtime":1534901209000,"applycontent":"23323232323","aggreement":0,"fund_id":76,"fundname":"11大发","id":5,"createuser":"超级管理员","applyuser":"超级管理员","status":"2"},{"createtime":1534128417000,"applycontent":"2","fund_id":76,"fundname":"11大发","createuser":"超级管理员","applyuser":"超级管理员","examineContent":"344444","examineuser":"超级管理员","aggreement":1,"id":1,"updatetime":1534992419000,"status":"1","updateuser":2}]
     * count : 11
     */

    public String msg;
    public int code;
    public int count;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * createtime : 1535955571000
         * fund_id : 77
         * fundname : 322
         * id : 13
         * createuser : 超级管理员
         * applyuser : 超级管理员
         * status : 2
         * applycontent : 撒旦法
         * examineContent : 第三方
         * aggreement : 0
         * examineuser : 超级管理员
         * updatetime : 1534992419000
         * updateuser : 2
         */

        public long createtime;
        public int fund_id;
        public String fundname;
        public int id;
        public String createuser;
        public String applyuser;
        public String status;
        public String applycontent;
        public String examineContent;
        public int aggreement;
        public String examineuser;
        public long updatetime;
        public int updateuser;
    }
}
