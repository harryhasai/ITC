package com.hengkai.itc.network.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Harry on 2018/8/15.
 */
public class HomeMultiItem implements MultiItemEntity {

//    public static final int TITLE = 1;
    public static final int BANNER = 2;
    public static final int MENU = 3;
    public static final int SHORTCUT = 4;
    public static final int MORE = 5;
    public static final int NEWS_LIST = 6;
    private int itemType;

    public HomeMultiItem(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

}
