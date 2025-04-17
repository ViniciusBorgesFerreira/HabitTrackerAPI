package habit_tracker_api.controller;


import habit_tracker_api.domain.model.Habit;

import habit_tracker_api.service.HabitService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping("users/{idUser}/habits")
public class HabitController {
    private final HabitService habitService;

    public HabitController(HabitService habitService){
        this.habitService = habitService;
    }

    @GetMapping("/{idHabit}")
    public ResponseEntity<Habit> findById(@PathVariable Long idUser, @PathVariable Long idHabit){
        var habit = habitService.findById(idUser, idHabit);
        return ResponseEntity.ok(habit);
    };

    @PostMapping()
    public ResponseEntity<Habit> create(@PathVariable Long idUser, @RequestBody Habit habitToCreate){
        var habitCreated = habitService.create(idUser, habitToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idHabit}")
                .buildAndExpand(habitCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(habitCreated);
    };
    @PostMapping("/{idHabit}/complete")
    public ResponseEntity<Habit> completeHabit(@PathVariable Long idHabit, @PathVariable Long idUser){
        Habit updatedHabit = habitService.completeHabit(idUser, idHabit);
        return ResponseEntity.ok(updatedHabit);
    }

    @DeleteMapping("/{idHabit}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long idUser, @PathVariable Long idHabit){
        habitService.delete(idUser, idHabit);
        return ResponseEntity.noContent().build();
    };

}
