package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
// 상속관계 매핑이기 때문에 상속관계 전략을 잡아주어야 한다.
// inheritanceType에는 JOINED, SINGLE_TABLE, TABLE_PER_CLASS 가 있다.
// JOINED는 가장 정규화된 형태, SINGLE_TABLE은 한 테이블 안에 다 때려박는 방법 (예컨데 구분 칼럼을 두는 것.)
// TABLE_PER_CLASS는 ALBUM, BOOK, MOVIE 각각의 클래스를 각각의 테이블로 만드는 방법.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 위 주석에서 언급된 구분 칼럼을 지정해주는 애노테이션.
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
// 상속관계 매핑때문에 abstract인가?
public abstract class Item {

    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
