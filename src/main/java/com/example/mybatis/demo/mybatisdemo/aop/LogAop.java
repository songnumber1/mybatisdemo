package com.example.mybatis.demo.mybatisdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
    // @Around("execution(* com.example.mybatis.demo.mybatisdemo.runtime.*.*(..))") // runtime 패키지만
    // @Around("execution(* com.example.mybatis.demo.mybatisdemo..*.*(..))") // 현재 패키지 전체
    @Around("execution(* com.example.mybatis.demo.mybatisdemo..*Controller.*(..)))") // 컨트롤러 전체
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		// 신호과 왔을때
        String signatureStr = joinpoint.getSignature().toShortString();
		
        System.out.println("----------------------------------------------------");
		System.out.println(signatureStr + " 시작");
		
		try {
			Object obj = joinpoint.proceed(); // 실행시 (클래스가 호출 된 시점)

			return obj;
		}
		// 이부분 추가되면 RestControllerAdvice이 호출되지 않는다.
		// catch (Exception e) {
		// 	System.out.println(e.toString());
		// 	System.out.println(signatureStr + " 오류");
		// 	System.out.println("==========================================");

		// 	return null;
		// }
		finally {
			// System.currentTimeMillis() : 밀리세컨 단위의 시간
			System.out.println("실행 후 : " + System.currentTimeMillis());
            System.out.println(signatureStr + " 종료");
            System.out.println("==========================================");
		}	
	}
}