// PomodoroController.java
package com.taskmanager.controller;

import com.taskmanager.entity.Pomodoro;
import com.taskmanager.service.PomodoroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pomodoro")
public class PomodoroController {
    @Autowired
    private PomodoroService pomodoroService;

    @PostMapping("/start")
    public Pomodoro startPomodoro(@RequestParam Long userId, @RequestParam int duration) {
        return pomodoroService.startPomodoro(userId, duration);
    }

    @PostMapping("/stop/{pomodoroId}")
    public Pomodoro stopPomodoro(@PathVariable Long pomodoroId) {
        return pomodoroService.stopPomodoro(pomodoroId);
    }

    @GetMapping("/user/{userId}")
    public List<Pomodoro> getPomodoroSessionsByUser(@PathVariable Long userId) {
        return pomodoroService.getPomodoroSessionsByUser(userId);
    }
}