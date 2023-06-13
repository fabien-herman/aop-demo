package com.example.aopdemo.ext.engine;

import java.util.List;

public interface ExternalFlowFilter
{
    void filterProcessor(String beanName, List<String> processor);
}
