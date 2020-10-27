package com.study.demo.vo;

/**
 * @author tungchi
 * @date 2020年10月12日10:35:32
 */
public class ArthasVO {
    String name;
    Integer age;
    Long id;

    @Override
    public String toString() {
        return "ArthasVO{" + "name='" + name + '\'' + ", age=" + age + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
