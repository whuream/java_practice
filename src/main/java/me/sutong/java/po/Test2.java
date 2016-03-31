package me.sutong.java.po;

/**
 * Created by tong on 12/8/15.
 */
public class Test2 {
    private Long id;
    private String name;

    public Test2(String name){
        this.name = name;
    }

    public Test2(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
