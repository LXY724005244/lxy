package com.stylefeng.guns.modular.system.model;

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
@TableName("bus_jiaoan")
public class Jiaoan extends Model<Jiaoan> {

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
    @TableField("html_material")
    private String htmlMaterial;
    /**
     * 文章内容
     */
    @TableField("md_material")
    private String mdMaterial;
    @TableField("gmt_create")
    private Date gmtCreate;
    @TableField("gmt_modified")
    private Date gmtModified;
    /**
     * 作者
     */
    private String author;


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


    public String getHtmlMaterial() {
        return htmlMaterial;
    }

    public void setHtmlMaterial(String htmlMaterial) {
        this.htmlMaterial = htmlMaterial;
    }

    public String getMdMaterial() {
        return mdMaterial;
    }

    public void setMdMaterial(String mdMaterial) {
        this.mdMaterial = mdMaterial;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Jiaoan{" +
        "id=" + id +
        ", title=" + title +
        ", introduction=" + introduction +
        ", htmlMaterial=" + htmlMaterial +
        ", mdMaterial=" + mdMaterial +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        ", author=" + author +
        "}";
    }
}
