package org.spring.springboot.utils;

/**
 * Created by jony.lai  on 2017/5/11.
 */
public  class ConstantUtil {
    public ConstantUtil() {
    }
    public static String CHANNEL_STATUS_WAIT ="WAIT";//待接入
    public static String CHANNEL_STATUS_NO ="STOP";//接入暂停
    public static String CHANNEL_STATUS_YES ="SUCCESS";//接入成功
    public static String RES_ERROR ="000000";//返回错误码
    public static String RES_ERROR_MSG ="系统异常";//返回错误信息
    public static String RES_SUCCESS ="999999";//返回成功码
    public static String RES_SUCCESS_MSG ="操作成功";//返回成功信息

    public static String AUTHENTICATE_ERROR ="110110";//登录认证返回错误码
    public static String AUTHENTICATE_ERROR_MSG ="登录失败";//登录认证返回错误信息
    public static String AUTHENTICATE_SUCCESS ="011011";//登录认证返回成功码
    public static String AUTHENTICATE_SUCCESS_MSG ="登录成功";//登录认证返回成功信息
    public static String AUTHENTICATE_LOGIN ="001001";//登录认证返回错误码
    public static String AUTHENTICATE_LOGIN_MSG ="登录页面";//登录认证返回错误信息

    public static String AUTHORITY_ERROR ="120120";//权限校验返回错误码
    public static String AUTHORITY_ERROR_MSG ="授权失败";//权限校验返回错误信息
    public static String AUTHORITY_SUCCESS ="021021";//权限校验返回成功码
    public static String AUTHORITY_SUCCESS_MSG ="授权成功";//权限校验返回成功信息

    public static String IS_ASYNC_DATA = "YES";
    public static String NO_ASYNC_DATA = "NO";
}
