package com.campoo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository  extends JpaRepository<Event,Long> {
    @Override
    Optional<Event> findById(Long id);
}
