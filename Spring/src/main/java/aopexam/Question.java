package aopexam;

import org.aspectj.lang.ProceedingJoinPoint;

public class Question {
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
