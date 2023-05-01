package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppContext.class);
		//스프링은 기본적으로 한 개의 @Bean 어노테이션에 대해 한 개의 빈 객체를 생성한다.
		//따라서 여러개의 빈객체를 생성하기 위해서는 아래와 같이 다른 이름의 메서드를 가진 빈 객체를 별도로 선언해주고 사용해야 한다.
		Greeter g1 = ctx.getBean("greeter",Greeter.class);
		Greeter g2 = ctx.getBean("greeter",Greeter.class);
		Greeter g3 = ctx.getBean("greeter1",Greeter.class);
		System.out.println("(g1==g2)="+(g1==g2));
		System.out.println("(g1==g3)="+(g1==g3));
		ctx.close();
	}

}
