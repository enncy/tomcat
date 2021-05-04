package cn.enncy.tomcat.service;


import cn.enncy.tomcat.entity.MethodTypes;
import cn.enncy.tomcat.request.HttpRequest;

import cn.enncy.tomcat.response.HttpResponse;


/**
 * //TODO
 * <br/>Created in 18:00 2021/5/3
 *
 * @author: enncy
 */
public abstract class HttpServlet implements Servlet {


    @Override
    public void service(HttpRequest req, HttpResponse res) {
        String method = req.getMethod();
        if(MethodTypes.GET.equals(method)){
            doGet(req,res);
        }else if(MethodTypes.POST.equals(method)){
            doPost(req,res);
        }
    }

    @Override
    public abstract void doGet(HttpRequest req, HttpResponse res);

    @Override
    public abstract void doPost(HttpRequest req, HttpResponse res);


}
