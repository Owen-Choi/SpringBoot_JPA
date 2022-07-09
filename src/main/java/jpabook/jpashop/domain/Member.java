package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private List<Order> orders = new ArrayList<>();
}
