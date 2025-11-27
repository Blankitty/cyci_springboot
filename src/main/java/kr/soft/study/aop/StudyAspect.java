package kr.soft.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StudyAspect {

    // execution( 접근제어자 패캐지. 클래스명. 메소드명(매게변수 타입)
    @Before("execution(* kr.soft.study.api.StudyController.*(..))")
    public void begforeAPi(JoinPoint joinPoint) {
        log.info(("======================before================="));
        log.info("type.name: {}", joinPoint.getSignature().getDeclaringType());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* kr.soft.study.api.StudyController.*(..))")
    public void afterAPi(JoinPoint joinPoint) {
        log.info(("======================after================="));
        log.info("type.name: {}", joinPoint.getSignature().getDeclaringType());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* kr.soft.study.api.StudyController.*(..))")
    public void afterReturningAPi(JoinPoint joinPoint) {
        log.info(("======================AFTER-RETUNING================="));
        log.info("type.name: {}", joinPoint.getSignature().getDeclaringType());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* kr.soft.study.api.StudyController.*(..))", throwing = "exception")
    public void afterThrowingAPi(JoinPoint joinPoint, Exception exception) {
        log.info(("======================after-THROWING================="));
        log.info("type.name: {}", joinPoint.getSignature().getDeclaringType());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }
}
