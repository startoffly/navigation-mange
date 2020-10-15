package com.xinmove.navigationmange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: startoffly
 * @Date: 2020/10/13 18:52
 * @Description: 分组
 */
//@Entity注解加在实体类上，定义对象将会成为被JPA管理的实体，将映射到指定的数据库。@Table注解用来说明该实体类对应的表和数据库，其中name =“xxx"，用来表示数据表的名字，catalog = “xxx"是数据库的名字
@Entity
@Data
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@AllArgsConstructor
//使用后添加一个无参构造函数
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CardGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    /**
     * 组名
     */
    private String name;
    /**
     * 组小图标 如 fa fa-hand-peace-o
     */
    private String icon;
    /**
     * 组简介
     */
    private String description;
    /**
     * 不隐藏 0，隐藏1
     */
    @Column(nullable = false)
    private int hide;
    /**
     * 排序
     */
    @Column(nullable = false)
    private int rank;

    @Column(name = "create_at")
    @CreatedDate
    private Date createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Date updateAt;

    /**
     * 组与卡片
     * 删除组时会将 卡片关系设为空
     */
    @ManyToMany(mappedBy = "cardGroupList",fetch = FetchType.EAGER)
    @OrderBy("rank desc")
    private List<Card> cardList;

    public CardGroup(Integer gid, String name, String icon, String description, int hide, int rank) {
        this.gid = gid;
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.hide = hide;
        this.rank = rank;
    }

    public CardGroup(String name, String icon, String description, int rank) {
        this(name,icon,description,0,rank);
    }

    public CardGroup(String name, String icon, String description, int hide, int rank) {
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.hide = hide;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "CardGroup{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                ", hide=" + hide +
                ", rank=" + rank +
                '}';
    }
}
