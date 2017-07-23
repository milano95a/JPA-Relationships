package com.aj.JPARelationships;

import com.aj.JPARelationships.entities.Comment;
import com.aj.JPARelationships.entities.Post;
import com.aj.JPARelationships.entities.PostPart;
import com.aj.JPARelationships.entities.Tag;
import com.aj.JPARelationships.repos.PostRepo;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
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


    @Test
    public void test2(){
        String author1 = "Author1";
        String body1 = "Body1";
        Comment comment1 = new Comment();
        comment1.setAuthor(author1);
        comment1.setBody(body1);

        String author2 = "Author2";
        String body2 = "Body2";
        Comment comment2 = new Comment();
        comment2.setAuthor(author2);
        comment2.setBody(body2);

        PostPart postPart = new PostPart();
        String body = "Post Part Body";
        postPart.setBody(body);

        Post post = new Post();
        post.setPostDate(new Date());
        post.setPostTitle("First Post");
        post.setPostPart(postPart);
        post.setComments(Lists.newArrayList(comment1,comment2));

        repo.save(post);

        Post dbPost = repo.findOne(post.getPostId());
        assertNotNull(dbPost);
        assertNotNull(dbPost.getPostPart());

        assertTrue(dbPost.getComments().size() == 2);
        assertThat(dbPost.getComments().get(0).getAuthor().equals(author1) ||dbPost.getComments().get(0).getAuthor().equals(author2));
        assertThat(dbPost.getComments().get(0).getBody().equals(body1) ||dbPost.getComments().get(0).getBody().equals(body2));

        assertTrue(dbPost.getComments().contains(comment1));
        assertTrue(dbPost.getComments().contains(comment2));
    }

    @Test
    public void postTagRelationship(){

        Tag tag1 = new Tag();
        Tag tag2 = new Tag();

        String java = "Java";
        String spring = "Spring";

        tag1.setName(java);
        tag2.setName(spring);

        Post post = new Post();
        post.setPostDate(new Date());
        post.setPostTitle("post title");
        post.getTags().add(tag1);
        post.getTags().add(tag2);

        repo.save(post);

        Post dbPost = repo.getOne(post.getPostId());
        assertNotNull(dbPost);

        List<Tag> tags = dbPost.getTags();
        assertTrue(tags.size() == 2);
        assertTrue(tags.contains(tag1));
        assertTrue(tags.contains(tag2));
    }
}
