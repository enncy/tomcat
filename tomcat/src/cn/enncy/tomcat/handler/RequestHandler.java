package cn.enncy.tomcat.handler;


import cn.enncy.tomcat.entity.Header;
import cn.enncy.tomcat.request.HttpRequest;
import cn.enncy.tomcat.request.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * //TODO   处理请求
 * <br/>Created in 16:58 2021/5/3
 *
 * @author: enncy
 */
public class RequestHandler {

    public static HttpRequest createRequest(Socket socket){

        try {

            InputStream inputStream  = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //创建请求类
            HttpRequest request = null;
            StringBuilder stringBuilder = new StringBuilder();
            List<Header> headers = new ArrayList<>();
            String inline;
            //读取第一行，获取请求方法，请求路径，请求协议以及版本
            if (!"".equals(inline = bufferedReader.readLine())) {
                String[] info = inline.split(" ");
                request = new HttpRequest(socket,info[0],info[1],info[2]);
            }
            //获取请求头
            while (!"".equals(inline = bufferedReader.readLine())) {
                stringBuilder.append(inline).append("\n");
                String[] headerInfo = inline.split(":");
                headers.add(new Header(headerInfo[0].trim(), headerInfo[1].trim()));
            }
            assert request != null;
            request.setHeaders(headers);
            request.setRaw(stringBuilder.toString());


            return request;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
