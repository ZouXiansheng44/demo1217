package com.example.demo1.Dao;

import com.example.demo1.Data.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminDao extends JpaRepository<Admin,String>, JpaSpecificationExecutor<Admin> {
        Admin findByAdminNameAndAdminPassword(String adminName,String adminPassword);
}
