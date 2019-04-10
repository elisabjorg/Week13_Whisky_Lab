package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> findWhiskyByYear(int year);
    List<Whisky> findWhiskyByAgeInParticularDistillery(String distillery, int age);
}
