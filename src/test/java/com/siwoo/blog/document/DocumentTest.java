package com.siwoo.blog.document;

import com.siwoo.blog.domain.Document.Category;
import com.siwoo.blog.domain.Document.Document;
import com.siwoo.blog.domain.member.Member;
import com.siwoo.blog.repository.DocumentRepository;
import lombok.extern.java.Log;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.print.Doc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@Log
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentTest {

    @Autowired
    DocumentRepository documentRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void persist(){

        Category category = Category.builder().build();
        Member member = Member.builder().build();

        entityManager.persist(member); entityManager.persist(category);

        Document document = Document.builder()
                .category(category).writer(member)
                //Content must have enough space for letters
                .content("content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1content1descriptiondescriptiondescriptiondescriptiondescriptiondescriptioncontent1content1content1content1")
                .description("descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription")
                .title("title1")
                .build();

        documentRepository.save(document);

        Document foundDocument = this.documentRepository.findById(document.getId()).get();

        log.warning(foundDocument::toString);

        assertThat(foundDocument, is(document));
        assertThat("Default rating should be 0.0",foundDocument.getRating(),is(0.0));
        assertThat("Default postDate must not be null",foundDocument.getPostDate(),is(notNullValue()));


    }
}
