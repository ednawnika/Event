package com.project.Event.repositories;

import com.project.Event.models.Comment;
import java.util.List;
import javax.persistence.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface CommentRepository extends CrudRepository<Comment,Long>{
	List<Comment> findAll();
}
