package ru.itis.kr1_oris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.kr1_oris.model.UserHistory;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Integer> {
}
