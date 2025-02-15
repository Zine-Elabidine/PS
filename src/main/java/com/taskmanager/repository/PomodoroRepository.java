// PomodoroRepository.java
package com.taskmanager.repository;

import com.taskmanager.entity.Pomodoro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PomodoroRepository extends JpaRepository<Pomodoro, Long> {
    List<Pomodoro> findByUserId(Long userId);
}