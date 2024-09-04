package com.example.demo.repository;

import com.example.demo.model.Session;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query("SELECT s FROM Session s JOIN s.participants p WHERE p = :participant")
    List<Session> findByParticipant(@Param("participant") User participant);
}