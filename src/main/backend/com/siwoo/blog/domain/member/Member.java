package com.siwoo.blog.domain.member;

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

    @Enumerated(EnumType.STRING) @Builder.Default
    private Level level = Level.BRONZE;

    @Builder.Default
    private int point = 0;

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
            throw new MemberDomainException("Member[point:"+point+"] does not have enough point","notEnough.member.point");
        }

        this.point = restPoint;
    }

}