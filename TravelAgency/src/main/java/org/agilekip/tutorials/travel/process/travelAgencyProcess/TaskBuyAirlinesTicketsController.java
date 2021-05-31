package org.agilekip.tutorials.travel.process.travelAgencyProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel-agency-process/task-buy-airlines-tickets")
public class TaskBuyAirlinesTicketsController {

    private final Logger log = LoggerFactory.getLogger(TaskBuyAirlinesTicketsController.class);

    private final TaskBuyAirlinesTicketsService taskBuyAirlinesTicketsService;

    public TaskBuyAirlinesTicketsController(TaskBuyAirlinesTicketsService taskBuyAirlinesTicketsService) {
        this.taskBuyAirlinesTicketsService = taskBuyAirlinesTicketsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskBuyAirlinesTicketsContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBuyAirlinesTicketsContextDTO taskBuyAirlinesTicketsContext = taskBuyAirlinesTicketsService.loadContext(id);
        return ResponseEntity.ok(taskBuyAirlinesTicketsContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskBuyAirlinesTicketsContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBuyAirlinesTicketsContextDTO taskBuyAirlinesTicketsContext = taskBuyAirlinesTicketsService.claim(id);
        return ResponseEntity.ok(taskBuyAirlinesTicketsContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskBuyAirlinesTicketsContextDTO taskBuyAirlinesTicketsContext) {
        log.debug(
            "REST request to complete TravelAgencyProcess.TaskBuyAirlinesTickets {}",
            taskBuyAirlinesTicketsContext.getTaskInstance().getId()
        );
        taskBuyAirlinesTicketsService.complete(taskBuyAirlinesTicketsContext);
        return ResponseEntity.noContent().build();
    }
}
