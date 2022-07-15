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

    // 값을 나타내는 클래스라 Immutable 하게 설계해야 한다. 따라서 Setter를 제공하지 말고 생성자를 활용하는 것이 좋다.

    // empty 생성자가 없으면 JPA 오류 발생, 하지만 public으로 열어두기는 좀 그렇다.
    // 따라서 JPA에서는 protected 까지 허용해주고, public 보다는 생성자를 남발하는 것을 방지해줄 수 있다.
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
