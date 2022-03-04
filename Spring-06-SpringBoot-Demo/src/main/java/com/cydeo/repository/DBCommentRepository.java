package com.cydeo.repository;

import com.cydeo.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeCommand(Comment comment) {
        System.out.println("Storing comment: "+comment.getText());
    }
}
