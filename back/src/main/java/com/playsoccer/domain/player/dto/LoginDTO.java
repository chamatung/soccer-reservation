package com.playsoccer.domain.player.dto;


import lombok.Data;
//
//@Data
//public class LoginDTO {
//    private String email;
//    private String password;
//}


public record LoginDTO(String email, String password) { }



/*
 당신이 보내주신 코드는 Java 16에서 새로 도입된 Record라는 기능을 사용하고 있습니다. Record는 Java에서 데이터 클래스를 정의하기 위한 새로운 방법입니다.
Record 클래스는 기본적으로 값 객체(Value Objects)를 만드는 데 사용됩니다.
이 클래스는 자동으로 final, immutable 및 equals(), hashCode(), toString() 메서드를 구현하며, 모든 인스턴스 필드에 대한 getter를 제공합니다.
Record 클래스는 간단하게 작성하고 읽기 쉬운 코드를 만드는 데 도움이 됩니다. 이전에는 개발자가 이러한 작업을 직접 작성해야 했습니다.
여기서 LoginDTO 클래스는 email과 password를 가지며, 각각 String 유형의 값입니다. Record를 사용하면 단순한 클래스를 간결하게 정의할 수 있으며,
이 클래스를 사용하는 코드도 더욱 직관적으로 만들 수 있습니다.
Lombok의 @Data 어노테이션은 Getter, Setter, toString(), equals(), hashCode() 등을 자동으로 생성해줍니다.
따라서, 위 코드에서는 별도로 이를 구현하지 않아도 되며, 코드가 더 간단해집니다.
*/