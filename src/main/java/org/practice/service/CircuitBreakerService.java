package org.practice.service;

import org.practice.repository.CircuitBreakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerService {

    @Autowired
    private CircuitBreakerRepository circuitBreakerRepository;

    public String testCircuitBreaker(){
        return circuitBreakerRepository.testCircuitBreaker();
    }

    public String testCircuitBreakerAnnotation(){
        return circuitBreakerRepository.callExternalService();
    }
}
