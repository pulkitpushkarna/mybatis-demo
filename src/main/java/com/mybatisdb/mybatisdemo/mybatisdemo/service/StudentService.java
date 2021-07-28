package com.mybatisdb.mybatisdemo.mybatisdemo.service;

import com.mybatisdb.mybatisdemo.mybatisdemo.repository.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;
}
