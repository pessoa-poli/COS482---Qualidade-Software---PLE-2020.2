package org.agilekip.tutorials.travel.process.travelAgencyProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel-agency-process/task-car-rentals")
public class TaskCarRentalsController {

    private final Logger log = LoggerFactory.getLogger(TaskCarRentalsController.class);

    private final TaskCarRentalsService taskCarRentalsService;

    public TaskCarRentalsController(TaskCarRentalsService taskCarRentalsService) {
        this.taskCarRentalsService = taskCarRentalsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskCarRentalsContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskCarRentalsContextDTO taskCarRentalsContext = taskCarRentalsService.loadContext(id);
        return ResponseEntity.ok(taskCarRentalsContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskCarRentalsContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskCarRentalsContextDTO taskCarRentalsContext = taskCarRentalsService.claim(id);
        return ResponseEntity.ok(taskCarRentalsContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskCarRentalsContextDTO taskCarRentalsContext) {
        log.debug("REST request to complete TravelAgencyProcess.TaskCarRentals {}", taskCarRentalsContext.getTaskInstance().getId());
        taskCarRentalsService.complete(taskCarRentalsContext);
        return ResponseEntity.noContent().build();
    }
}
