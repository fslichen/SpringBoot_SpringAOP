package evolution.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnyMonitor {
	// This refers to any methods with suffix equals 'Service' regardless of number of parameters under evolution package.
	@AfterReturning("execution(* evolution..*Service.*(..))")
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("After Returning : " + joinPoint);
	}
	
	// This refers to any methods under evolution.service.AnyService regardless of number of parameters.
	@Before("execution(* evolution.service.AnyService.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("Before : " + joinPoint);
	}
}