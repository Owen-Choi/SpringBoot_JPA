package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
    joinColumns = @JoinColumn(name = "category_id"),
    inverseJoinColumns = @JoinColumn(name = "item_id"))
    // 다대다 관계의 경우 중간 테이블을 매핑해주어야 한다. 이를 명시하는 애노테이션이다.
    // 이렇게 테이블을 추가하면 되는데, 왜 실무에서 쓰지 말라고 할까?
    // 추가된 테이블이 필드 추가가 안되고 두 테이블의 기본키만 가질 수 있기 때문이다.
    // 실무에서는 그렇게 단순하게 매핑만 하고 끝나는 경우가 없기 때문.
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    // mappedBy로 parent를 지정해준다. 셀프로 양방향 연관관계를 건 것이라고 이해하면 된다.
    private List<Category> child = new ArrayList<>();
}
