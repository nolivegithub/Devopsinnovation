package com.company.schedule.controller;

import com.company.schedule.model.Schedule;
import com.company.schedule.service.ScheduleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/scheduleevents")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/getData")
    public ResponseEntity<List<Schedule>> getData(@RequestBody Object model) {
        List<Schedule> events = scheduleService.findAll();
        return ResponseEntity.ok(events);
    }

    @PostMapping("/crudActions")
    public ResponseEntity<List<Schedule>> crudActions(@RequestBody Object model) {

        Map<String, List<Map<String, Object>>> data = (Map<String, List<Map<String, Object>>>) model;
        List<Schedule> events = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (String action : data.keySet()) {
            List<Map<String, Object>> actionData = data.get(action);

            for (Map<String, Object> actionItem : actionData) {
                try {
                    Schedule schedule = mapper.convertValue(actionItem, Schedule.class);

                    if ("added".equals(action)) {
                        events.add(scheduleService.insert(schedule));
                    } else if ("changed".equals(action)) {
                        events.add(scheduleService.update(schedule));
                    } else if ("deleted".equals(action)) {
                        events.add(scheduleService.deleteById(schedule.getId()));
                    }

                    return ResponseEntity.ok(events);

                } catch (Exception e) {
                    ResponseEntity.status(500).body(e.toString());
                }
            }
        }

        return ResponseEntity.ok(events);
    }

}
