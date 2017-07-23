package com.aj.JPARelationships;

import org.assertj.core.api.BooleanAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CommentRepoTest {

    @Autowired
    CommentRepo commentRepo;

    @Test
    public void insert(){
        Post post = new Post();
        post.setPostDate(new Date());
        String postTitle = "Post title";
        post.setPostTitle(postTitle);

        String author = "Comment author";
        String body = "Comment body";

        Comment comment = new Comment();
        comment.setAuthor(author);
        comment.setBody(body);
        comment.setPost(post);

        commentRepo.save(comment);

        Comment dbComment = commentRepo.findOne(comment.getCommentId());
        assertNotNull(dbComment);
        assertNotNull(dbComment.getPost());
        assertEquals(author,dbComment.getAuthor());
        assertEquals(body,dbComment.getBody());
    }
}
