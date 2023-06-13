package com.example.aopdemo.us.flows;

import com.example.aopdemo.us.processors.ConcatDummyProcessor;
import com.example.aopdemo.us.processors.ModifyDummyProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(DummyFlow.BEAN_NAME)
public class DummyFlow {
    public static final String BEAN_NAME = "DummyFlow";

    public List<String> run() {
        List<String> test = new ArrayList<>();
        this.addFlowProcessors(test);
        return test;
    }

    public void addFlowProcessors(List<String> processors) {
        processors.add(ModifyDummyProcessor.BEAN_NAME);
        processors.add(ConcatDummyProcessor.BEAN_NAME);
    }
}
