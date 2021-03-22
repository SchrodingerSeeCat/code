package com.valid.share.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import com.valid.share.dao.UserDBHelper;

public class UserInfoContent implements BaseColumns {
    // 这里的名称必须与AndroidManifest.xml里的android:authorities保持一致
    public static final String AUTHORITIES = "com.valid.share.provider.UserInfoProvider";

    // 内容提供器的外部表名
    public static final String TABLE_NAME = UserDBHelper.TABLE_NAME;

    // 访问内容提供器的URI
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITIES + "/user");

    // 下面是该表的各个字段的名称
    public static final String USER_NAME = "name";
    public static final String USER_AGE = "age";
    public static final String USER_HEIGHT = "height";
    public static final String USER_WEIGHT = "weight";
}
