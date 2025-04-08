package habit_tracker_api.controller;

import habit_tracker_api.domain.model.Habit;
import habit_tracker_api.domain.model.Historic;
import habit_tracker_api.domain.model.User;
import habit_tracker_api.service.HabitService;
import habit_tracker_api.service.HistoricService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/historic")
public class HistoricController {
    private final HistoricService historicService;

    public HistoricController(HistoricService historicService){
        this.historicService = historicService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historic> findById(@PathVariable Long id){
        var historic = historicService.findById(id);
        return ResponseEntity.ok(historic);
    };

//    @PostMapping
//    public ResponseEntity<Historic> create(@PathVariable Long idHabit, @PathVariable Long idUser){
//        var historicCreated = historicService.create(idHabit);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(historicCreated.getId())
//                .toUri();
//        return ResponseEntity.created(location).body(historicCreated);
//    };

}
