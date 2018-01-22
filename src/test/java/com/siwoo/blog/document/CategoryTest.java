package com.siwoo.blog.document;

import com.siwoo.blog.domain.Document.Category;
import com.siwoo.blog.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void persist(){

        Category category = Category.builder()
                .name("JSP")
                .description("JSP is server page")
                .build();

        categoryRepository.save(category);

        Category foundCategory = categoryRepository.findById(category.getId()).get();

        assertThat(category,is(foundCategory));
        //When category is created, there is must be null for lastDocument
        assertThat("When category is created, there is must be null for lastDocument"
                ,foundCategory.getLastDocument(),is(nullValue()));
    }


}
