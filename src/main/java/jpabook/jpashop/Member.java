package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// 스프링에서 bean을 등록하듯이 jpa에서 entity를 등록해줘야 함.
@Entity
// lombok의 getter setter
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String username;
}
