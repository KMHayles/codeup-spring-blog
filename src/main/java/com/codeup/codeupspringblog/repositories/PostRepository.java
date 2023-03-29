package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByOrderByTitle();

    // example of derived query
    Post findByTitle(String title);

    // examples using JPQL / HQL
    @Query("from Post a where a.id like ?1")
    Post getAdById(long id);

    @Query("select title from Post where LENGTH(title) < 10")
    List<String> getAdsOfCertainTitleLength();

    // using a native query
    @Query(nativeQuery = true, value = "SELECT title FROM posts WHERE LENGTH(title) < 10")
    List<String> getPostsOfCertainTitleLengthNative();


}
