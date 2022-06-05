package com.campoo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="events")
@Entity(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @NotBlank(message="Name of event is required")
    private String name;
    @ManyToOne
    @JoinColumn(name = "location_name")
    private Location location;
    private Integer maxMembers;
    @ManyToMany
    private List<User> members;
    @NotBlank(message="Description of event is required")
    private String description;
    @NotBlank(message="Type of event is required")
    private String eventType;
    private Date dateTime;
}
