// PomodoroService.java
package com.taskmanager.service;

import com.taskmanager.entity.Pomodoro;
import com.taskmanager.entity.User;
import com.taskmanager.repository.PomodoroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PomodoroService {
    @Autowired
    private PomodoroRepository pomodoroRepository;

    public Pomodoro startPomodoro(Long userId, int duration) {
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setStartTime(LocalDateTime.now());
        pomodoro.setDuration(duration);

        User user = new User();
        user.setId(userId); // Set the ID directly
        pomodoro.setUser(user);

        return pomodoroRepository.save(pomodoro);
    }

    public Pomodoro stopPomodoro(Long pomodoroId) {
        Pomodoro pomodoro = pomodoroRepository.findById(pomodoroId).orElseThrow();
        pomodoro.setEndTime(LocalDateTime.now());
        return pomodoroRepository.save(pomodoro);
    }

    public List<Pomodoro> getPomodoroSessionsByUser(Long userId) {
        return pomodoroRepository.findByUserId(userId);
    }
}