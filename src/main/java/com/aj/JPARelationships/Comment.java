package com.aj.JPARelationships;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Integer commentId;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "BODY")
    private String body;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) &&
                Objects.equals(author, comment.author) &&
                Objects.equals(body, comment.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, author, body);
    }
}
