package annotation.aop1;

import java.util.Date;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component // <bean id="common" class="Common">
@Aspect // <aop:aspect id="c" ref="common"> 둘 다 Class위에 붙어 있어야 함
public class Common {
	// <aop:pointcut expression="execution (public * aop1.*.*(..))" id="pc"/>
	@Pointcut("execution (public * annotation.aop1.*.*(..))")
	public void pc() { }
	
	long startTime = System.currentTimeMillis();
	// <aop:before method="a" pointcut-ref="pc"/>
//	@Before("pc()")
	public void a() {
		System.out.println("Method 호출 시각 ==> " + new Date(startTime));
	}
	
	// <aop:after method="b" pointcut-ref="pc"/>
//	@After("pc()")
	public void b() {
		long endTime = System.currentTimeMillis();
		System.out.println("Method 실행 소요시간 (단위: 1/1000초) ==> " + (endTime - startTime));
	}
	
	// <aop:around method="c" pointcut-ref="pc"/>
	@Around("pc()")
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
