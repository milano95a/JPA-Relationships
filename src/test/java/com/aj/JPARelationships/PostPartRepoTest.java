package com.aj.JPARelationships;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
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

}
