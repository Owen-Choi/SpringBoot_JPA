package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    // enum에 대해서는 @Enumerated 애노테이션을 달아주어야 한다.
    // @Enumerated에는 type이 ORDINAL, STRING이 있는데 ORDINAL은 숫자로 들어간다.
    // 즉 READY, COMP 이렇게 있다면 각각 1, 2가 된다.
    // 하지만 중간에 새로운 값이 이 사이에 들어가게 되면 "망한다."
    // ORDINAL은 위와 같은 이유로 "절대" 쓰지 말라고 한다.
    private DeliveryStatus status;
}
