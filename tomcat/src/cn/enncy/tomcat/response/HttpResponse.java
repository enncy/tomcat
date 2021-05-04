package cn.enncy.tomcat.response;


import cn.enncy.tomcat.entity.Header;
import cn.enncy.tomcat.entity.Status;
import cn.enncy.tomcat.handler.ResponseHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

/**
 * //TODO
 * <br/>Created in 18:17 2021/5/3
 *
 * @author: enncy
 */
public class HttpResponse extends Response {


    public HttpResponse(Socket socket, String protocol, Status status, List<Header> headers, Object data) {
        super(socket, protocol, status, headers, data);
    }

    public HttpResponse(Socket socket, String protocol, Status status, List<Header> headers) {
        super(socket, protocol, status, headers, "");
    }

    /**
     * 写出数据
     *
     * @param string 数据
     * @return: void
     */
    @Override
    public void write(String string) throws IOException {
        //设置数据
        this.setData(string);
        //转换成响应报文
        String data = this.getResponseMessage();
        //输出报文给服务器
        OutputStream outputStream = this.getSocket().getOutputStream();
        outputStream.write(data.getBytes(), 0, data.length());
        outputStream.close();
    }


    /**
     * 传递空数据，并强制关闭请求
     *
     * @return: void
     */
    public void close() throws IOException {
        if (!this.getSocket().isClosed()) {
            this.write("");
        }
    }

    /**
     * 重定向
     *
     * @param value 重定向值
     * @return: void
     */
    public void redirect(String value) throws IOException {
        this.getHeaders().add(new Header("Location", value));
        this.close();
    }
}
