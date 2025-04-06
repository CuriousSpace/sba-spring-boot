package com.sba.board.repository;

import com.sba.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}