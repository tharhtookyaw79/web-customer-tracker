package com.beyondasync.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup Logger
	private Logger log = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* com.beyondasync.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.beyondasync.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.beyondasync.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		log.info("==========>>> in @Before: calling method: " + theMethod);

		// display the arguments to the methods

		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop thru and display args
		for (Object tempArg : args) {
			log.info("==========>>> argument: " + tempArg);
		}

	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		log.info("==========>>> in @AfterReturning: calling method: " + theMethod);

		// display data return
		log.info("==========>>> result: "+theResult);
	}

}
