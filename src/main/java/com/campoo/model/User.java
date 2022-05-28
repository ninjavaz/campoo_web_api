package com.campoo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_own")
@Entity(name="user_own")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String username;
    private String description;
    private String city;
    private Date entryDate;
}
