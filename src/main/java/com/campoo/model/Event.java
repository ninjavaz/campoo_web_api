package com.campoo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "owner_")
    private User owner;
    private String name;
    @ManyToOne
    @JoinColumn(name = "location_")
    private Location location;
    private Integer maxMembers;
    @ManyToMany
    private List<User> members;
    private String description;
    private String eventType;
}
