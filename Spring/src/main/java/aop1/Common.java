package aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {
	long startTime = System.currentTimeMillis();
	public void a() {
		System.out.println("Method 호출 시각 ==> " + new Date(startTime));
	}
	
	public void b() {
		long endTime = System.currentTimeMillis();
		System.out.println("Method 실행 소요시간 (단위: 1/1000초) ==> " + (endTime - startTime));
	}
	
	public void c(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("Method 수행 이전");
			Object returnValue = joinPoint.proceed(); // pointcut 문법 선택 핵심관심
			System.out.println("Return Value: " + returnValue);
			System.out.println(joinPoint.getTarget());
			System.out.println(joinPoint.getArgs());
			System.out.println(joinPoint.toLongString());
			System.out.println("Method 수행 이후");
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
}
