package com.example.springjpatransactionlivelecture230428.entity;

import com.example.springjpatransactionlivelecture230428.repository.MemoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemoTest {

    @PersistenceContext // @Autowired
    EntityManager em;
    @Autowired
    MemoRepository memoRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("메모 생성 성공")
    void test1() {
        Memo memo = new Memo();
        memo.setUsername("Robbert");
        memo.setContents("@Transactional 테스트 중!");

        em.persist(memo);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }

    @Test
    @DisplayName("메모 생성 실패")
    void test2() {
        Memo memo = new Memo();
        memo.setUsername("Robbie");
        memo.setContents("@Transactional 테스트 중!");

        em.persist(memo);
    }

    @Test
    @DisplayName("영속성 컨텍스트와 트랜잭션의 생명 주기")
    void test3() {
        Memo memo = memoRepository.createMemo(em);// 트랜잭션이 적용되어있는 createMemo 메서드를 호출합니다.
        memo.setContents("update");
        System.out.println("@Transactional 비적용 상태의 memo = " + em.contains(memo)); // 영속성 컨텍스트에 저장된 상태인지 확인합니다.

    }


}
