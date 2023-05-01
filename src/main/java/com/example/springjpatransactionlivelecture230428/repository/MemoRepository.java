package com.example.springjpatransactionlivelecture230428.repository;

import com.example.springjpatransactionlivelecture230428.entity.Memo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class MemoRepository {

    @Transactional
    public Memo createMemo(EntityManager em) {
        Memo memo = new Memo();
        memo.setUsername("Robbert");
        memo.setContents("트랜잭션과 영속성 컨텍스트의 범위는 같다"); // 비영속!

        em.persist(memo); // 영속성 컨텍스트에 저장!
        System.out.println("@Transactional 적용 상태의 memo = " + em.contains(memo)); // 영속성 컨텍스트에 저장되었는지 확인
        return memo; // 트랜잭션이 커밋되면서!
    }

}
