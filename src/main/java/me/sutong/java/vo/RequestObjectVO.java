package me.sutong.java.vo;

/**
 * Created by tong on 4/5/16.
 */
public class RequestObjectVO {
    private String name = "default";

    private Long id = -1l;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
