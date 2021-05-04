package cn.enncy.tomcat;


import cn.enncy.tomcat.server.Server;
import cn.enncy.tomcat.utils.ServletClassLoader;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Objects;

/**
 * //TODO
 * <br/>Created in 12:25 2021/5/3
 *
 * @author: enncy
 */
public class Bootstrap {

    private static String path = null;
    private static int port = 9999;

    public static void main(String[] args) throws Exception {

        path = getArgsValue(args, "webAppsPath");
        port = Integer.parseInt(Objects.requireNonNull(getArgsValue(args, "port")));

        long time = System.currentTimeMillis();
        //初始化资源类
        Class[] classes = ServletClassLoader.loadClasses(path);
        for (Class aClass : classes) {
            System.out.println("[Tomcat] load servlet ["+aClass+"]");
        }
        Server.startup(port, classes, () -> {
            System.out.println("[Tomcat] server startup :  http://localhost:"+port+"/ , time consuming :"+(System.currentTimeMillis()-time)+"m/s");
        });
    }

    // 获取启动参数
    public static String getArgsValue(String[] args,String key) throws UnsupportedEncodingException {
        for (String arg : args) {
            if (arg.contains(key)) {
                String[] split = arg.split("=");
                return new String(split[1].trim().getBytes(),"GBK");
            }
        }
        return null;
    }

}
