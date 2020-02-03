package annotation.aopexam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Question {
	@Pointcut("execution (public * annotation.aopexam.*.*(..))")
	public void pc() { };
	
	@Around("pc()")
	public void q(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("오늘 점심에 뭐 먹었어요?");
			Object returnValue = joinPoint.proceed();
			System.out.println(returnValue + " 먹었군요.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
