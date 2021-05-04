package cn.enncy.tomcat.entity;


/**
 * //TODO
 * <br/>Created in 15:23 2021/5/3
 *
 * @author: enncy
 */
public class Header {

    private String name;
    private Object value;

    public Header(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + ": " + value + "\n";
    }
}
