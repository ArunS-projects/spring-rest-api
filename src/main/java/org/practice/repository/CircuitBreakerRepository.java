package org.practice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CircuitBreakerRepository {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;
//    @CircuitBreaker()
    public String testCircuitBreaker(){
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        return circuitBreaker.run(() -> {
                    try {
                        return getRandomSuccess();
                    } catch (Exception e) {
                        throw new RuntimeException("Failed with random",e);
                    }
                },
                throwable -> getGuaranteedSuccess());

    }
    private String getRandomSuccess() throws Exception {
        if(Math.random() > 0.5){
            throw new Exception("Failed");
        }
        return "SUCCESS";
    }
    private String getGuaranteedSuccess(){
        return "SUCCESS12";
    }

    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "SAMPLE_SERVICE", fallbackMethod = "fallbackResponse")
    public String callExternalService() {
        // Simulating a random failure
        if (Math.random() > 0.5) {
            throw new RuntimeException("Service failed");
        }
        return "Service call succeeded";
    }

    /**
     * Fallback method called when the circuit breaker is open.
     * @param ex Exception thrown
     * @return Fallback response
     */
    public String fallbackResponse(Exception ex) {
        return "Fallback response: " + ex.getMessage();
    }
}
