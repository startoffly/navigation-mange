package com.xinmove.navigationmange.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @JoinTable(name="sys_card_card_group",
            joinColumns={@JoinColumn(name="card_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="card_group_id", referencedColumnName="gid")})
    @ManyToMany(fetch = FetchType.EAGER)
    @OrderBy("rank desc")
    private List<CardGroup> cardGroupList;


    public Card(String name, String description, String url, String img, int hide, int rank) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.img = img;
        this.hide = hide;
        this.rank = rank;
    }

    public Card(String name, String description, String url, String img, int hide, int rank,
                List<CardGroup> cardGroupList) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.img = img;
        this.hide = hide;
        this.rank = rank;
        this.cardGroupList = cardGroupList;
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
                List<CardGroup> cardGroupList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.img = img;
        this.hide = hide;
        this.rank = rank;
        this.cardGroupList = cardGroupList;
    }
}
