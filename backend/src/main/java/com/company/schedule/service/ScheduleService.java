package com.company.schedule.service;


import com.company.schedule.model.Schedule;
import com.company.schedule.repository.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private Schedule schedule;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public Schedule findById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find schedule id=" + id));
    }

    public Schedule insert(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule update(Schedule schedule) {
        Schedule scheduleFromDB = findById(schedule.getId());
        BeanUtils.copyProperties(schedule, scheduleFromDB, "id, Guid");
        return scheduleRepository.save(schedule);
    }

    public Schedule deleteById(Long id) {
        Schedule schedule = findById(id);
        scheduleRepository.deleteById(id);
        return schedule;
    }

}


