package org.agilekip.tutorials.travel.process.travelAgencyProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel-agency-process/task-travel-insurance")
public class TaskTravelInsuranceController {

    private final Logger log = LoggerFactory.getLogger(TaskTravelInsuranceController.class);

    private final TaskTravelInsuranceService taskTravelInsuranceService;

    public TaskTravelInsuranceController(TaskTravelInsuranceService taskTravelInsuranceService) {
        this.taskTravelInsuranceService = taskTravelInsuranceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskTravelInsuranceContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskTravelInsuranceContextDTO taskTravelInsuranceContext = taskTravelInsuranceService.loadContext(id);
        return ResponseEntity.ok(taskTravelInsuranceContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskTravelInsuranceContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskTravelInsuranceContextDTO taskTravelInsuranceContext = taskTravelInsuranceService.claim(id);
        return ResponseEntity.ok(taskTravelInsuranceContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskTravelInsuranceContextDTO taskTravelInsuranceContext) {
        log.debug(
            "REST request to complete TravelAgencyProcess.TaskTravelInsurance {}",
            taskTravelInsuranceContext.getTaskInstance().getId()
        );
        taskTravelInsuranceService.complete(taskTravelInsuranceContext);
        return ResponseEntity.noContent().build();
    }
}
