package com.aj.JPARelationships.repos;

import com.aj.JPARelationships.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag,Integer>{}
