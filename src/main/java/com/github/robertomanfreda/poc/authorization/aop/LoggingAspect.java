package com.github.robertomanfreda.poc.authorization.aop;

import com.github.robertomanfreda.poc.authorization.model.request.BaseRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {

    private final HttpServletRequest request;

    @Pointcut("execution(* com.github.robertomanfreda.poc.authorization.controller.*.*(..)) && args(baseRequest,..)")
    public void controllerPointcut(BaseRequest baseRequest) { }

    @Around("controllerPointcut(baseRequest)")
    public void beforeController(ProceedingJoinPoint pjp, BaseRequest baseRequest) throws Throwable {
        Instant before = Instant.now();
        pjp.proceed();
        Instant after = Instant.now();
        long elapsedTime = Duration.between(before, after).toMillis();
        log.info("requestId: {}, elapsedTime: {}, ipAddress: {}", baseRequest.getRequestID(), elapsedTime, request.getRemoteAddr());
    }
}
