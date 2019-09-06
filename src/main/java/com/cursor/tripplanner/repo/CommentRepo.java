package com.cursor.tripplanner.repo;

import com.cursor.tripplanner.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findAll();

}
