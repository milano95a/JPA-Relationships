package com.aj.JPARelationships;

import com.aj.JPARelationships.entities.Post;
import com.aj.JPARelationships.entities.PostPart;
import com.aj.JPARelationships.repos.PostPartRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PostPartRepoTest {

    @Autowired
    private PostPartRepo repo;

    @Test
    public void test(){
        PostPart postPart = new PostPart();
        String body = "Post Part Body";
        postPart.setBody(body);

        repo.save(postPart);

        PostPart dbPostPart = repo.findOne(postPart.getPostPartId());
        assertNotNull(dbPostPart);
        assertEquals(body,dbPostPart.getBody());
        System.out.println(dbPostPart.getBody());
    }

    @Test
    public void insertTest(){
        Post post = new Post();
        post.setPostDate(new Date());
        post.setPostTitle("First Post");

        PostPart postPart = new PostPart();
        String body = "Post Part Body";
        postPart.setBody(body);
        postPart.setPost(post);

        repo.save(postPart);

        PostPart dbPostPart = repo.findOne(postPart.getPostPartId());
        assertNotNull(dbPostPart);
        assertNotNull(dbPostPart.getPost());
        assertNotNull(dbPostPart.getPost());
        assertEquals(body,dbPostPart.getBody());
    }

}
