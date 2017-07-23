package com.aj.JPARelationships.repos;

import com.aj.JPARelationships.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer>{}
