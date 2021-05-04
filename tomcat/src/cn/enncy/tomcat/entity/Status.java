package cn.enncy.tomcat.entity;


/**
 * //TODO   请求状态实体
 * <br/>Created in 16:10 2021/5/3
 *
 * @author: enncy
 */
public class Status {
    private int status;
    private String description;


    public Status( int status,String description) {
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

}
