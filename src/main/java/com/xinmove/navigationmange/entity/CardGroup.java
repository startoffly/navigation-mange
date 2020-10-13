package com.xinmove.navigationmange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: startoffly
 * @Date: 2020/10/13 18:52
 * @Description:
 */
//@Entity注解加在实体类上，定义对象将会成为被JPA管理的实体，将映射到指定的数据库。@Table注解用来说明该实体类对应的表和数据库，其中name =“xxx"，用来表示数据表的名字，catalog = “xxx"是数据库的名字
@Entity
@Data
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@AllArgsConstructor
//使用后添加一个无参构造函数
@NoArgsConstructor
public class CardGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    @Column(name = "rank", nullable = false)
    private int rank;

    /**
     * 组与卡片
     */
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cardGroup")
    @Cascade(value= {CascadeType.ALL}) //设定级联关系
    private List<Card> cardList;

}
