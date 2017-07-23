package com.aj.JPARelationships.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POST_ID")
    private Integer postId;

    @Column(name = "POST_DATE")
    private Date postDate;

    @Column(name = "POST_TITLE")
    private String postTitle;

    @OneToOne
    @JoinColumn(name = "POST_PART_ID")
    private PostPart postPart;

    @ManyToMany
    @JoinTable(name = "POST_TAG",
            joinColumns = {@JoinColumn(name = "POST_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TAG_ID")})
    private List<Tag> tags = new ArrayList<Tag>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public PostPart getPostPart() {
        return postPart;
    }

    public void setPostPart(PostPart postPart) {
        this.postPart = postPart;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) &&
                Objects.equals(postDate, post.postDate) &&
                Objects.equals(postTitle, post.postTitle) &&
                Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postDate, postTitle, comments);
    }
}
