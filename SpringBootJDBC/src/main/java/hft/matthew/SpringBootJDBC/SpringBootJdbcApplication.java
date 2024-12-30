package hft.matthew.SpringBootJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import hft.matthew.SpringBootJDBC.model.Programmer;
import hft.matthew.SpringBootJDBC.repo.ProgrammerRepo;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		
		Programmer prg1 = context.getBean(Programmer.class);
		prg1.setId(111);
		prg1.setName("Matthew");
		prg1.setTech("Java");
		
		ProgrammerRepo repo = context.getBean(ProgrammerRepo.class);
		repo.save(prg1);
		System.out.println(repo.findAll());
		
		
	}

}
