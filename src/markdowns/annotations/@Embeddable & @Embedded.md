## @Embeddable

해당 애노테이션을 지정한 클래스를 밸류 클래스라고 한다.  
밸류 클래스란 int, double 처럼 하나의 값을 나타내는 클래스를 일컫는다.

밸류 클래스의 예시는 다음과 같다.  

    public class Address {

    private String city;
    private String street;
    private String zipcode;
    
    }

이렇게 도시명, 거리명, 상세주소를 포함하는 "주소" 라는 클래스가 있다고 가정하면,  
이 주소 클래스는 3가지 변수가 합쳐서 하나의 주소라는 값을 표현한다.

***
### 활용 전 예시

    @Entity
    @Table(name = "user")
    public class User {
        @Id
        @GenerativeValue(strategy = GenerationType.AUTO)
        private Long uid;
        private String name;
        private String phoneNum;
        
        private String city;
        private String street;
        private String zipcode;
    }

밸류 클래스와 @Embeddable 애노테이션을 활용하기 전 User 엔티티 코드이다.  
이렇게 되면, 주소로 인식하기에 약간의 어려움이 발생하고 가독성이 떨어진다고 한다.  

따라서 밸류 클래스를 만들고, 엔티티에 해당 클래스를 사용하는 것이 좋다.

### 활용 후 예시

    @Entity
    @Table(name = "user")
    public class User {
        @Id
        @GenerativeValue(strategy = GenerationType.AUTO)
        private Long uid;
        private String name;
        private String phoneNum;

        @Embedded
        private Address address;
    }

밸류 클래스 객체에 *@Embedded* 애노테이션을 붙여야 한다.
***

    @Embeddable
    public class Address {
        private String city;
        private String street;
        private String zipcode;
    }

+ 가독성이 증가하였다.
+ JPA Entity 안의 column을 하나의 객체로서 사용할 수 있다.