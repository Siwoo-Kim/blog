package com.siwoo.blog.domain.Document;

import com.siwoo.blog.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "Document")
@SequenceGenerator(name = "DOCUMENT_SEQ_GENERATOR",
        sequenceName = "DOCUMENT_SEQ",
        initialValue = 1, allocationSize = 1)
public class Document {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_SEQ_GENERATOR")
    @Column(name = "DOCUMENT_ID")
    private Long id;

    private String title;

    @Lob
    private String content;

    @Column(length = 400)
    private String description;

    @Builder.Default
    private LocalDateTime postDate = LocalDateTime.now();

    @OneToOne(optional = false)
    @JoinColumn(name="MEMBER_ID")
    private Member writer;

    @Builder.Default
    private Double rating = .0;

    @ManyToOne(optional = false)
    @JoinColumn(name="CATEGORY_ID")
    Category category;


}