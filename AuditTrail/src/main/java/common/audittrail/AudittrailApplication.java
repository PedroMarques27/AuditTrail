package common.audittrail;

import common.audittrail.models.enums.Condition;
import common.audittrail.models.entities.Platform;
import common.audittrail.repository.IPlatformRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class AudittrailApplication {


	public static void main(String[] args) {
		SpringApplication.run(AudittrailApplication.class, args);
	}
	@Autowired
	private Environment environment;

	@Autowired
	private IPlatformRepository platformRepository;

	@PostConstruct
	public void init() {
		String host = environment.getProperty("server.address", "localhost");
		int port = Integer.parseInt(environment.getProperty("server.port", "8080"));
		try{
			Platform platform = new Platform();
			platform.systemName = environment.getProperty("system.name", "AuditTrail");
			platform.host = String.format("%s:%d", host, port);
			platform.healthEndpoint = "Platform/AuditTrail";
			platform.condition = Condition.UP;
			platform.lastCheckup = System.currentTimeMillis();

			platformRepository.save(platform);
		}catch (Exception e){

		}

	}

}
