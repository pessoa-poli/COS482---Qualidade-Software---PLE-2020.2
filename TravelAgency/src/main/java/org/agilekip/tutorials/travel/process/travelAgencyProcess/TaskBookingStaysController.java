package org.agilekip.tutorials.travel.process.travelAgencyProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel-agency-process/task-booking-stays")
public class TaskBookingStaysController {

    private final Logger log = LoggerFactory.getLogger(TaskBookingStaysController.class);

    private final TaskBookingStaysService taskBookingStaysService;

    public TaskBookingStaysController(TaskBookingStaysService taskBookingStaysService) {
        this.taskBookingStaysService = taskBookingStaysService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskBookingStaysContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBookingStaysContextDTO taskBookingStaysContext = taskBookingStaysService.loadContext(id);
        return ResponseEntity.ok(taskBookingStaysContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskBookingStaysContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBookingStaysContextDTO taskBookingStaysContext = taskBookingStaysService.claim(id);
        return ResponseEntity.ok(taskBookingStaysContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskBookingStaysContextDTO taskBookingStaysContext) {
        log.debug("REST request to complete TravelAgencyProcess.TaskBookingStays {}", taskBookingStaysContext.getTaskInstance().getId());
        taskBookingStaysService.complete(taskBookingStaysContext);
        return ResponseEntity.noContent().build();
    }
}
