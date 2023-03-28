package com.playsoccer;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PlaySoccerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlaySoccerApplication.class, args);
//      이거 사용하려면 일단 persitence.xml 설정 후 해야함...
//      EntityManagerFactory emf = Persistence.createEntityManagerFactory("여기는 persistence-unit name 들어감");
//      EntityManager em = emf.createEntityManager();

//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//
//            //여기서 테스트 해보자...
//            tx.commit();
//        } catch(Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
    }

}
