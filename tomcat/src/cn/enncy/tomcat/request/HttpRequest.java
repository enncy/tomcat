package cn.enncy.tomcat.request;


import cn.enncy.tomcat.entity.Header;

import java.net.Socket;
import java.util.List;

/**
 * //TODO
 * <br/>Created in 18:17 2021/5/3
 *
 * @author: enncy
 */
public class HttpRequest extends Request{

    private String filePath;
    private String queryString;

    public HttpRequest(Socket socket, String method, String path, String protocol) {
        super(socket, method, path, protocol);
        //处理路径值
        if(path.indexOf("?")!=-1){
            this.filePath = path.substring(0, path.indexOf("?"));
            this.queryString = path.substring(path.indexOf("?")+1);
        }else{
            this.filePath = this.path;
        }

    }



    public String getFilePath() {
        return filePath;
    }


    public String getQueryString() {
        return queryString;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "filePath='" + filePath + '\'' +
                ", queryString='" + queryString + '\'' +
                ", method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", protocol='" + protocol + '\'' +
                '}';
    }
}
