package ex4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import static ex4.Helper.l;

//https://www.youtube.com/watch?v=6r-MpAWVw6c - 7.17
//create_school/{ "name":"school_1" }
//create_student/{"firstName":"n1","lastName":"l1","email":"e1@E1.com","age":"22", "schoolId": 1 }
//schools
//students

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		l("go ----->");
	}



//	public static void main_old_1(String[] args) {
//		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
//		FirstService firstService = ctx.getBean(FirstService.class);
//		l( firstService.tellStory() );
//		l(firstService.getCustomProperty("prop.t1"));
//	}
}
