package com.example.demo1.Data;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_info")
@DynamicUpdate
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String user_name;
    private String user_password;
    private String user_email;
    private String user_phone;
    private String user_icon;
    private Date create_time;
    private Date update_time;

}
