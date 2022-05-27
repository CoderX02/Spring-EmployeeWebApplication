package company.hsenid.employeewebapplication;

import company.hsenid.employeewebapplication.models.Employee;
import company.hsenid.employeewebapplication.repositories.EmployeeRepository;
import company.hsenid.employeewebapplication.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeWebApplicationTests {
    @Test
    void contextLoads() {
    }

}
