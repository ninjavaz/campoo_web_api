package com.campoo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="events")
@Entity(name="event")
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private User owner;
    private String name;
    private Location location;
    private Integer maxMembers;
    private List<User> members;
    private String description;
    private EventType eventType;
}
