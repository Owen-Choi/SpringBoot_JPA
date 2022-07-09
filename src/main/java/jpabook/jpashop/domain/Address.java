package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

// JPA의 내장타입이라는 것이기 때문에 @Embeddable 애노테이션을 붙여주어야 한다고 한다.
@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
