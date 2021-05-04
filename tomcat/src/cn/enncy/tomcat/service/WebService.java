package cn.enncy.tomcat.service;


import java.lang.annotation.*;

/**
 * //TODO
 * <br/>Created in 16:57 2021/5/3
 *
 * @author: enncy
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebService {
    String path();
}
