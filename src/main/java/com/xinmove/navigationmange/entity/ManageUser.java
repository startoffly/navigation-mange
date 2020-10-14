package com.xinmove.navigationmange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: startoffly
 * @Date: 2020/10/14 12:57
 * @Description:
 */
@Entity
@Data
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@AllArgsConstructor
//使用后添加一个无参构造函数
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ManageUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String pwd;

    /**
     * 权限
     */
    @Column(nullable = false)
    private Integer role;

    @Column(name = "create_at")
    @CreatedDate
    private Date createAt;

    @Column(name = "update_at")
    @CreatedDate
    private Date updateAt;

}
