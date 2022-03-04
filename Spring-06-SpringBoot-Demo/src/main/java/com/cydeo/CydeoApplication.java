package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CydeoApplication {

    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setAuthor("Joe");
        comment.setText("Spring Framwork");

//        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        ApplicationContext context = SpringApplication.run(CydeoApplication.class, args);
        CommentService cs1 = context.getBean(CommentService.class);
        cs1.publishComment(comment);
    }

}
