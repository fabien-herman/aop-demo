package com.example.aopdemo.ext.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExternalEngineService {

    @Autowired
    private ExternalFlowFilter filter;

    public void doFilterProcessor(String beanName, List<String> processor) {
        filter.filterProcessor(beanName, processor);
    }
}
