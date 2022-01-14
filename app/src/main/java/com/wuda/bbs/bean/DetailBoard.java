package com.wuda.bbs.bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DetailBoard extends BaseBoard {

    private String number;  // 删除收藏板块需要
    private String section;

    public DetailBoard(@NonNull String id, String name, String number, String section) {
        super(id, name);
        this.number = number;
        this.section = section;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
