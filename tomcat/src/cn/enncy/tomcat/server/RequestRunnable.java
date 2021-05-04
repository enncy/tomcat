package cn.enncy.tomcat.server;


import cn.enncy.tomcat.handler.RequestHandler;
import cn.enncy.tomcat.handler.ResponseHandler;
import cn.enncy.tomcat.request.HttpRequest;
import cn.enncy.tomcat.response.HttpResponse;
import cn.enncy.tomcat.service.HttpServlet;
import cn.enncy.tomcat.service.WebService;

import java.lang.reflect.Method;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * //TODO
 * <br/>Created in 13:12 2021/5/3
 *
 * @author: enncy
 */
public class RequestRunnable implements  Runnable{

    private Socket socket;
    private final Class[] classes;

    public RequestRunnable(Socket socket,Class[] classes) {
        this.socket = socket;
        this.classes = classes;
    }

    @Override
    public void run() {
        try{
            //请求处理
            HttpRequest request = RequestHandler.createRequest (socket);
            assert request != null;
            System.out.println("[Tomcat-"+Thread.currentThread().getName()+"]  "+request.getMethod()+" "+request.getPath()+" "+request.getProtocol());
            //创建请求
            HttpResponse response =  ResponseHandler.createResponse(socket);
            System.out.println(response.toString());
            //遍历资源类，反射获取 servlet
            for (Class clazz : classes) {
                WebService webService = (WebService) clazz.getAnnotation(WebService.class);
                String path = webService.path();
                //如果当前请求的文件路径和 servlet 的path路径匹配，则吧请求交给这个类处理
                Matcher matcher = Pattern.compile(path).matcher(request.getFilePath());
                if(matcher.find()){
                    //实例类，然后执行方法
                    Object object = clazz.getConstructor().newInstance();
                    HttpServlet httpServlet = (HttpServlet) object;
                    httpServlet.doGet(request, response);
                    break;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
