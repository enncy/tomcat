package cn.enncy.tomcat.utils;


import cn.enncy.tomcat.service.WebService;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * //TODO   从指定路径加载类文件
 * <br/>Created in 20:03 2021/5/3
 *
 * @author: enncy
 */
public class ServletClassLoader {

    public static Class[] loadClasses(String rootClassPath) throws Exception {
        Set<Class<?>> classSet = new HashSet<>();
        // 设置class文件所在根路径
        File clazzPath = new File(rootClassPath);

        // 记录加载.class文件的数量
        int clazzCount = 0;

        if (clazzPath.exists() && clazzPath.isDirectory()) {
            // 获取路径长度
            int clazzPathLen = clazzPath.getAbsolutePath().length() + 1;

            Stack<File> stack = new Stack<>();
            stack.push(clazzPath);

            // 遍历类路径
            while (!stack.isEmpty()) {
                File path = stack.pop();
                File[] classFiles = path.listFiles(pathname -> {
                    //只加载class文件
                    return pathname.isDirectory() || pathname.getName().endsWith(".class");
                });
                if (classFiles == null) {
                    break;
                }
                for (File subFile : classFiles) {
                    if (subFile.isDirectory()) {
                        stack.push(subFile);
                    } else {
                        if (clazzCount++ == 0) {
                            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                            if (! method.isAccessible()) {
                                method.setAccessible(true);
                            }
                            // 设置类加载器
                            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                            // 将当前类路径加入到类加载器中
                            method.invoke(classLoader, clazzPath.toURI().toURL());
                        }
                        // 文件名称
                        String className = subFile.getAbsolutePath();
                        //去掉后缀名
                        className = className.substring(clazzPathLen, className.length() - 6);
                        //将/替换成. 得到全路径类名
                        className = className.replace(File.separatorChar, '.');
                        // 加载 Servlet 类
                        Class<?> clazz = Class.forName(className);
                        if(clazz.isAnnotationPresent(WebService.class)){
                            classSet.add(clazz);
                        }


                    }
                }
            }
        }

        return classSet.toArray(new Class[0]);
    }



}
