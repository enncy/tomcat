package cn.enncy.tomcat.response;


import cn.enncy.tomcat.entity.Header;
import cn.enncy.tomcat.entity.Status;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/**
 * //TODO
 * <br/>Created in 18:04 2021/5/3
 *
 * @author: enncy
 */
public abstract class Response {
    //请求
    private Socket socket;
    //响应协议
    private String protocol;
    //响应状态
    private Status status;
    //响应数据
    private Object data;
    //响应请求头
    private  List<Header> headers ;


    public Response(Socket socket,String protocol, Status status, List<Header> headers, Object data) {
        this.protocol = protocol;
        this.status = status;
        this.data = data;
        this.headers = headers;
        this.socket = socket;
    }

    abstract public void write(String string) throws IOException;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public String getResponseMessage(){
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(protocol).append(" ").append(status.getStatus()).append(" ").append(status.getDescription()).append("\n");
        for (Header header : headers) {
            stringBuilder.append(header.toString());
        }
        stringBuilder.append("\n");
        stringBuilder.append(data);
        return stringBuilder.toString();
    }
}
