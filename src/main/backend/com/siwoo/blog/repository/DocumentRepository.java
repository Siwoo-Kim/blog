package com.siwoo.blog.repository;

import com.siwoo.blog.domain.Document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {

}
