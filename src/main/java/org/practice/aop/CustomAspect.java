package org.practice.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomAspect {

    private static final Logger logger = LoggerFactory.getLogger(CustomAspect.class);

    public void loggingBeforeAdvice() {
        logger.info("Before method call");
    }
}
