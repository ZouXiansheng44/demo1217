package com.example.demo1.Service;

import com.example.demo1.Data.Admin;

public interface AdminService  {
    Admin findByAdminNameAndAdminPassword(String adminName,String adminPassword);
}
