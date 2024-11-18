package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스를 통한 기본적인 CRUD 제공
// 공통적인 것이 아닌 쿼리는 아래처럼 작성하면 됨
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL select m from Member m where m.name = ?
    // 인터페이스 이름 만으로 쿼리가 자동으로 짜진다.
    @Override
    Optional<Member> findByName(String name);
    // findByNameAndAge(String name, int age) 이런것도 가능

}
