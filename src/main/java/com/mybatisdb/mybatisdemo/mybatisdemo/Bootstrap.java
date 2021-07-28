package com.mybatisdb.mybatisdemo.mybatisdemo;

import com.mybatisdb.mybatisdemo.mybatisdemo.entity.Student;
import com.mybatisdb.mybatisdemo.mybatisdemo.repository.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createDatabase();
        initialStudentRecords();
    }

    public void initialStudentRecords(){
        Student student1 = studentMapper.getStudentByRollNo("1");
        if(Objects.isNull(student1)) {
            Student student = new Student();
            student.setId(1);
            student.setAddress("D-180, Rishi Nagar, Rani Bagh");
            student.setCity("Delhi");
            student.setFirstName("Pulkit");
            student.setLastName("Pushkarna");
            student.setRollNo("1");
            studentMapper.saveStudent(student);
        }
        Student student2 = studentMapper.getStudentByRollNo("2");
        if(Objects.isNull(student2)) {
            Student student = new Student();
            student.setId(2);
            student.setAddress("D-183, Rishi Nagar, Rani Bagh");
            student.setCity("Delhi");
            student.setFirstName("Shinji");
            student.setLastName("Kasai");
            student.setRollNo("2");
            studentMapper.saveStudent(student);
        }
    }

    public void createDatabase(){
        jdbcTemplate.update("create table if not exists student(" +
                "    student_id int auto_increment primary key," +
                "    roll_no    varchar(225) not null," +
                "    first_name varchar(255) not null," +
                "    last_name  varchar(255) not null," +
                "    address    varchar(255) not null," +
                "    city       varchar(255) not null," +
                "    deleted    tinyint(1)   not null" +
                ")");

    }
}
