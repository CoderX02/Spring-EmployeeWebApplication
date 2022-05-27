package company.hsenid.employeewebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EmployeeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeWebApplication.class, args);
    }

}
