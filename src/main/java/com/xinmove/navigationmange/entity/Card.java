package com.xinmove.navigationmange.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: startoffly
 * @Date: 2020/10/13 18:53
 * @Description:
 */
@Entity
@Data
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@AllArgsConstructor
//使用后添加一个无参构造函数
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String url;

    private String img;

    /**
     * 不隐藏 0，隐藏1
     */
    @Column(nullable = false)
    private int hide;

    @Column(name = "rank", nullable = false)
    private int rank;

    @Column(name = "create_at")
    @CreatedDate
    private Date createAt;

    @Column(name = "update_at")
    @LastModifiedDate
    private Date updateAt;


    @ManyToOne
    @JoinColumn(name = "gid")
    private CardGroup cardGroup;

    public Card(String name, String description, String url, String img, int hide, int rank, CardGroup cardGroup) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.img = img;
        this.hide = hide;
        this.rank = rank;
        this.cardGroup = cardGroup;
    }

    public Card(Long id, String name, String description, String url, String img, int hide, int rank) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.img = img;
        this.hide = hide;
        this.rank = rank;
    }

    public Card(Long id, String name, String description, String url, String img, int hide, int rank,
                CardGroup cardGroup) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.img = img;
        this.hide = hide;
        this.rank = rank;
        this.cardGroup = cardGroup;
    }
}
