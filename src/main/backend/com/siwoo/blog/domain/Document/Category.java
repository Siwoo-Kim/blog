package com.siwoo.blog.domain.Document;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "CATEGORY")
@SequenceGenerator(name = "CATEGORY_SEQ_GENERATOR",
        sequenceName = "CATEGORY_SEQ",
        initialValue = 1, allocationSize = 1)
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ_GENERATOR")
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    private LocalDateTime lastDocument;

}