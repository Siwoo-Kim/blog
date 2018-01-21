package com.siwoo.blog.domain;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "MEMBER")
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String email;

    private int age;

    private String password;

    @Enumerated(EnumType.STRING)
    private Level level;

    private int point;

    public enum Level{
        GOLD(null), SILVER(GOLD), BRONZE(SILVER);
        private Level nextLevel;

        Level(Level nextLevel) {
            this.nextLevel = nextLevel;
        }
    }

    public void addPoint(int amount){
        this.point += amount;
    }

    public void removePoint(int amount){
        int restPoint = this.point - amount;

        if(restPoint < 0 ){
            throw new IllegalStateException("User point is not enough & THIS EXCEPTION MUST BE CHANGED");
        }

        this.point = restPoint;
    }

}