package com.example.demo.dto;

import java.time.LocalTime;

public class AvailabilityDTO {
    private Long id;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer intervalDuration;

    public AvailabilityDTO(Long id, String dayOfWeek, LocalTime startTime, LocalTime endTime, Integer intervalDuration) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.intervalDuration = intervalDuration;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getIntervalDuration() {
        return intervalDuration;
    }

    public void setIntervalDuration(Integer intervalDuration) {
        this.intervalDuration = intervalDuration;
    }
}
