package com.aj.JPARelationships;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepTest {

    @Autowired
    private PostRepo repo;

    @Test
    public void test(){
        Post post = new Post();
        post.setPostDate(new Date());
        post.setPostTitle("First Post");

        repo.save(post);

        Post dbPost = repo.findOne(post.getPostId());
        assertNotNull(dbPost);
        System.out.println(dbPost.getPostTitle());
    }
}
