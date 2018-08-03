package com.stylefeng.guns.modular.system.model.DTO;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 123
 * @since 2018-07-23
 */

public class JiaoAnDTO  {

    private static final long serialVersionUID = 1L;

    /**
     * PrimaryKey
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String introduction;
    /**
     * 文章 html 内容
     */

    private String id_input_html;
    /**
     * 文章内容
     */

    private String id_input_md;
    @TableField("gmt_create")
    private Date gmtCreate;
    @TableField("gmt_modified")
    private Date gmtModified;



    /**
     * 作者
     */
    private String author;
    @TableField(exist = false)
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getId_input_html() {
        return id_input_html;
    }

    public void setId_input_html(String id_input_html) {
        this.id_input_html = id_input_html;
    }

    public String getId_input_md() {
        return id_input_md;
    }

    public void setId_input_md(String id_input_md) {
        this.id_input_md = id_input_md;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Jiaoan{" +
                "id=" + id +
                ", title=" + title +
                ", introduction=" + introduction +
                ", htmlMaterial=" + id_input_html +
                ", mdMaterial=" + id_input_md +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", author=" + author +
                ", tag=" + tag +
                "}";
    }
}
