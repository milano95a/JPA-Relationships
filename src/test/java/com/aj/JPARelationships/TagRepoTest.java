package com.aj.JPARelationships;

import com.aj.JPARelationships.entities.Post;
import com.aj.JPARelationships.entities.Tag;
import com.aj.JPARelationships.repos.TagRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional

public class TagRepoTest {

    @Autowired
    TagRepo repo;

    @Test
    public void insertTest(){

        Post post1 = new Post();
        post1.setPostDate(new Date());
        post1.setPostTitle("Java 101");

        Post post2 = new Post();
        post2.setPostDate(new Date());
        post2.setPostTitle("Intensive Spring");

        Tag tag = new Tag();
        String java = "Java";
        tag.setName(java);
        tag.getPosts().add(post1);
        tag.getPosts().add(post2);

        repo.save(tag);


        Tag dbTag = repo.findOne(tag.getTagId());
        assertNotNull(dbTag);
        assertEquals(dbTag.getName(),java);

        List<Post> posts = dbTag.getPosts();
        assertTrue(posts.size() == 2);
        assertTrue(posts.contains(post1));
        assertTrue(posts.contains(post2));
    }
}
