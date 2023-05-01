package chap02;

//@AnnotationConfigApplicationContext 클래스는 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리한다.
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext 객체를 생생할 때 앞서 작성한 AppContext 클래스를 생성자 파라미터로 전달
		//AnnotationConfigApplicationContext는 AppContext에 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppContext.class);
		//getBean 메서드는 AnnotationConfigApplicationContext가 자바 설정을 읽어와 생성한 빈 객체를 검색할 때 사용된다.
		//첫 번째 파라미터 : @Bean 어노테이션의 메서드이름인 빈 객체의 이름
		//두 번재 파라미터 : 검색할 빈 객체의 타입
		Greeter g = ctx.getBean("greeter",Greeter.class);
		String msg=g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}

}
