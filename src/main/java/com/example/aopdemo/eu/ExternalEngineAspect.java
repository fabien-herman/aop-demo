package com.example.aopdemo.eu;

import com.example.aopdemo.ext.engine.ExternalEngineService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
@Aspect
public class ExternalEngineAspect {
    private final ExternalEngineService engine;

    public ExternalEngineAspect(ExternalEngineService engine) {
        this.engine = engine;
    }

    @Around("execution(void com.example.aopdemo.us.flows.DummyFlow.addFlowProcessors(..))")
    public Object addFilterFlowProcessors(ProceedingJoinPoint joinPoint) throws Throwable {
        String beanName = Stream
                .of(joinPoint.getTarget().getClass().getAnnotationsByType(Component.class))
                .findFirst()
                .map(Component::value)
                .get();

        Object[] args = joinPoint.getArgs();
        Object result;

        if ("addFlowProcessors".equals(joinPoint.getSignature().getName())) {

            List<String> processorsNames = (List<String>)args[0];

            result =  joinPoint.proceed(args);

            engine.doFilterProcessor(beanName, processorsNames);
        }
        else {
            result = joinPoint.proceed(args);
        }
        return result;
    }
}
