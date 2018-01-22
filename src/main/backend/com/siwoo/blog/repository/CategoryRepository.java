package com.siwoo.blog.repository;

import com.siwoo.blog.domain.Document.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
