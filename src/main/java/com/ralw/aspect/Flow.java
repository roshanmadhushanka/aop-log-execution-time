package com.ralw.aspect;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author roshanalwis on 9/15/18
 */
@Service
public class Flow {

    @LogExecutionTime
    public void methodOne() {
        System.out.println("Executing method 1");
    }

    public void methodTwo() {
        System.out.println("Executing method 2");
    }
}
