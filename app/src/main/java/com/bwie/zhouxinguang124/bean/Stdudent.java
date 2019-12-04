package com.bwie.zhouxinguang124.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:周鑫光
 *@Date: 2019/12/4
 *@Time:9:25
 *@Description:${DESCRIPTION}
 * */
@Entity
public class Stdudent {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String sex;
    @Generated(hash = 1959069963)
    public Stdudent(Long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    @Generated(hash = 240958058)
    public Stdudent() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Stdudent(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Stdudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
