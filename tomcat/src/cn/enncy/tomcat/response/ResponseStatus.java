package cn.enncy.tomcat.response;

import cn.enncy.tomcat.entity.Status;

/**
 * //TODO
 * <br/>Created in 15:43 2021/5/3
 *
 * @author: enncy
 */
public class ResponseStatus {




    /**
     *  请求成功
     */
    public static final Status OK = new Status(200,"OK");
    /**
     * 隐式重定向
     */

    public static final Status MOVED_PERMANENTLY = new Status(301, "Moved Permanently");
    /**
     * 显式重定向
     */
    public static final Status FOUND = new Status(302, "Found");
    /**
     * Not Modified 请求的资源没有改变 可以继续使用缓存
     */
    public static final Status NOT_MODIFIED = new Status(304, "Not Modified");
    /**
     * BAD REQUEST  错误的请求方式,语法
     */
    public static final Status BAD_REQUEST = new Status(400, "Bad Request");
    /**
     * 未授权
     */
    public static final Status UNAUTHORIZED = new Status(401, "Unauthorized");
    /**
     * 禁止访问
     */
    public static final Status FORBIDDEN = new Status(403, "Forbidden");
    /**
     * 没有发现文件、查询或URL
     */
    public static final Status NOT_FOUND =  new Status(404, "Not Found");
    /**
     * 服务器错误
     */
    public static final Status INTERNAL_SERVER_ERROR = new Status(500, "Internal Server Error");
    /**
     * 请求超时
     */
    public static final Status SERVICE_UNAVALIABLE = new Status(503, "Service Unavailable");
}
