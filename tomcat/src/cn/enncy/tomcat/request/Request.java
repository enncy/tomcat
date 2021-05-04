package cn.enncy.tomcat.request;


import cn.enncy.tomcat.entity.Header;

import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * //TODO
 * <br/>Created in 17:21 2021/5/3
 *
 * @author: enncy
 */
public class Request {

    //请求
    protected Socket socket;
    //请求方法
    protected String method;
    //请求路径
    protected String path;
    //请求协议
    protected String protocol;
    //请求头
    protected List<Header> headers ;
    //请求内容
    protected String raw;


    public Request(Socket socket,String method, String path, String protocol) {
        this.socket = socket;
        this.method = method;
        this.path = path;
        this.protocol = protocol;
    }


    public Request(Socket socket,String method, String path, String protocol, List<Header> headers) {
        this.socket = socket;
        this.method = method;
        this.path = path;
        this.protocol = protocol;
        this.headers = headers;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        return "Request{" +
                "socket=" + socket +
                ", method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", protocol='" + protocol + '\'' +
                ", headers=" + headers +
                ", raw='" + raw + '\'' +
                '}';
    }
}
