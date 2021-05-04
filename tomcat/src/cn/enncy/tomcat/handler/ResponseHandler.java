package cn.enncy.tomcat.handler;


import cn.enncy.tomcat.entity.ContentTypes;
import cn.enncy.tomcat.entity.Header;
import cn.enncy.tomcat.response.HttpResponse;
import cn.enncy.tomcat.response.ResponseProtocol;
import cn.enncy.tomcat.response.ResponseStatus;
import cn.enncy.tomcat.utils.TimeUtils;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * //TODO
 * <br/>Created in 15:17 2021/5/3
 *
 * @author: enncy
 */
public class ResponseHandler {

    public static HttpResponse createResponse(Socket socket) {
        List<Header> headers = new ArrayList<>();
        headers.add(new Header("Server", "Tomcat"));
        headers.add(new Header("Date", TimeUtils.getGMTTime()));
        headers.add(new Header("Content-Type", ContentTypes.textHtml));
        return new HttpResponse(socket, ResponseProtocol.HTTP1, ResponseStatus.OK, headers, "");
    }

    public static HttpResponse createTextResponse(Socket socket, String data) {
        List<Header> headers = new ArrayList<>();
        headers.add(new Header("Server", "Tomcat"));
        headers.add(new Header("Date", TimeUtils.getGMTTime()));
        headers.add(new Header("Content-Type", ContentTypes.textHtml));
        headers.add(new Header("Content-Length", data.getBytes().length));
        return new HttpResponse(socket, ResponseProtocol.HTTP1, ResponseStatus.OK, headers, data);
    }


}
