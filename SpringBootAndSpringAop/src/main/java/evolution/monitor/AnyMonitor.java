package evolution.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
	
	@Before("execution(* evolution.service.AnyService.anotherMethod(..)) && args(name)")
	public void before(JoinPoint joinPoint, String name) {
		System.out.println("Before : " + joinPoint + ". The parameter is " + name + ".");
	}
	
	@After("execution(* evolution.service.AnyService.anotherMethod(..))")
	public void after(JoinPoint joinPoint) {
		Object[] objects = joinPoint.getArgs();
		int i = 1;
		for (Object object : objects) {
			System.out.println("The " + i + " object is " + object + ".");
			i++;
		}
	}
}