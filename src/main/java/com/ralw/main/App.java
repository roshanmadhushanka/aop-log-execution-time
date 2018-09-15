package com.ralw.main;

import com.ralw.aspect.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author roshanalwis on 9/15/18
 */
@Component
public class App {

    @Autowired
    private Flow flow;

    @Scheduled(fixedRate = 50000)
    public void process() {
        flow.methodOne();
        flow.methodTwo();
    }
}
