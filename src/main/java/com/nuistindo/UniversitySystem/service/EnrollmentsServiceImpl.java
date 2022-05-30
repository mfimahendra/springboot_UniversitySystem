package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.EnrollmentsModel;
import com.nuistindo.UniversitySystem.repository.EnrollmentsRepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentsServiceImpl {
    private final EnrollmentsRepository enrollmentsRepository;

    public EnrollmentsServiceImpl(EnrollmentsRepository enrollmentsRepository) { this.enrollmentsRepository = enrollmentsRepository; }

}
