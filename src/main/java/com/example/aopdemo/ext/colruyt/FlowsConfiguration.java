package com.example.aopdemo.ext.colruyt;

import com.example.aopdemo.ext.colruyt.processors.ColruytDummyProcessor;
import com.example.aopdemo.ext.engine.ExternalFlowFilter;
import com.example.aopdemo.us.flows.DummyFlow;
import com.example.aopdemo.us.processors.ConcatDummyProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlowsConfiguration implements ExternalFlowFilter {

    @Override
    public void filterProcessor(String beanName, List<String> processors) {
        switch (beanName) {
            case DummyFlow.BEAN_NAME : {
                processors.add(0, ColruytDummyProcessor.BEAN_NAME);
                processors.remove(ConcatDummyProcessor.BEAN_NAME);
            }
        }
    }
}
