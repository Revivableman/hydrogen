package com.revivable.hydrogen.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

public class Area {
    @TableId
    private Integer id;
    @TableField("areaname")
    private String areaname;
    private String descri;
    private Integer priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Area(String areaname, String descri, Integer priority) {
        this.areaname = areaname;
        this.descri = descri;
        this.priority = priority;
    }

    public Area() {
    }
}
