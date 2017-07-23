package com.aj.JPARelationships.repos;

import com.aj.JPARelationships.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Integer>{}
