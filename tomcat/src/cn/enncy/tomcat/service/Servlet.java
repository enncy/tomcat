package cn.enncy.tomcat.service;

import cn.enncy.tomcat.entity.MethodTypes;
import cn.enncy.tomcat.request.HttpRequest;
import cn.enncy.tomcat.response.HttpResponse;

/**
 * //TODO
 * <br/>Created in 22:43 2021/5/3
 *
 * @author: enncy
 */
public interface Servlet {

    void service(HttpRequest req, HttpResponse res);

    void doGet(HttpRequest req, HttpResponse res);

    void doPost(HttpRequest req, HttpResponse res);
}
