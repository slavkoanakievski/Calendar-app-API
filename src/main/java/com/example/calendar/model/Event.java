package com.example.calendar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime startime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime endtime;
    private String reminder;

    public Event(Long id, String title, String description, String location, LocalDateTime startime, LocalDateTime endtime, String reminder){

        this.id=id;
        this.title=title;
        this.description=description;
        this.location=location;
        this.startime=startime;
        this.endtime=endtime;
        this.reminder=reminder;

    }

    public Event() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getStartTime() {
        return this.startime = startime;
    }

    public LocalDateTime getEndTime() {
        return this.endtime = endtime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endtime = endTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startime = startTime;
    }

}

