package com.example.calendar.controller;

import com.example.calendar.model.Event;
import com.example.calendar.repository.EventRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/event")
@CrossOrigin(value = "*")
public class EventController {

    private final EventRepository eventRepository;
    private final EventRepository EventRepository;

    public EventController(EventRepository EventRepository, EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.EventRepository = EventRepository;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        // Save the event in the database
        return EventRepository.saveAndFlush(event);
    }

    @GetMapping("/event")
    public ResponseEntity<Event> getEvent(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        // Find the event by ID
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Return the event with a success response
        return ResponseEntity.ok(event);
    }
    @GetMapping
    public List<Event> list(){
        return EventRepository.findAll(); }
    // Additional methods for retrieving, deleting, and managing events

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) throws ChangeSetPersister.NotFoundException {
        // Find the event by ID
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Update the event attributes
        existingEvent.setTitle(updatedEvent.getTitle());
        existingEvent.setDescription(updatedEvent.getDescription());
        existingEvent.setLocation(updatedEvent.getLocation());
        existingEvent.setStartTime(updatedEvent.getStartTime());
        existingEvent.setEndTime(updatedEvent.getEndTime());
        existingEvent.setReminder(updatedEvent.getReminder());

        // Save the updated event in the database
        Event updatedEventEntity = eventRepository.save(existingEvent);

        // Return the updated event with a success response
        return ResponseEntity.ok(updatedEventEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteEvent(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        // Find the event by ID
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Delete the event from the database
        if (event != null) {
            eventRepository.delete(event);
            return ResponseEntity.ok(id);
        } else {
            // Return a success response
            return ResponseEntity.noContent().build();
        }
    }
}


