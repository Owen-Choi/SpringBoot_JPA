package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    // @Column(name = "member_id")는 하단의 id라는 변수 명이 바로 데이터베이스의 칼럼명으로 설정되지 않고
    // member_id 라는 이름으로 들어가게 해준다.
    @Column(name = "member_id")
    private Long id;

    private String name;

    private Address address;

    @OneToMany(mappedBy = "member")
    // Order와 Member는 양방향 연관관계를 가진다. 따라서 연관관계의 주인을 정해야 한다.
    // 연관관계의 주인은 외래키를 가지고 있는 Order 테이블이고, 연관관계의 주인이 아닌 Member 테이블에서
    // mappedBy를 명시해줘야 한다. 다음에 오는 member는 Order 클래스 안에 있는 Member 클래스(테이블)의 객체를 가리킨다.
    private List<Order> orders = new ArrayList<>();

}
