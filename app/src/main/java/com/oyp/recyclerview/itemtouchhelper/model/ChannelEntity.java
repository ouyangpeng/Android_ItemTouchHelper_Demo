package com.oyp.recyclerview.itemtouchhelper.model;

/**
 * 频道实体类
 */
public class ChannelEntity {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChannelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}