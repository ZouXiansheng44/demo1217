package com.example.demo1.Data;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
/**
 * 管理员表
 */

@Data
@Entity
@Table(name = "admin_info")
@DynamicUpdate
@DynamicInsert
public class Admin {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)//自增
    private Integer adminId;
    private String adminName;
    private String adminPassword;
    private String adminEmail;
    private String adminPhone;
    private String adminIcon;
    private Date createTime;
    private Date updateTime;

}
