package org.geekbang.thinking.in.spring.ioc.overview.domain;

/**
 * 用户类
 * @author yingkefa
 * @date 2020年06月29日15:40:18
 */
public class User {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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
