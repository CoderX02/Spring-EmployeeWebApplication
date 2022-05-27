package company.hsenid.employeewebapplication.services;

import company.hsenid.employeewebapplication.models.Employee;
import company.hsenid.employeewebapplication.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@AutoConfigureDataMongo
@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;


    @Test
    void insertEmployee(){
        Employee employee = new Employee("Mithesh","Mathan");
        when(employeeRepository.save(employee)).thenReturn(employee);

        assertEquals(employee, employeeService.insertEmployee(employee));
    }

    @Test
    void deleteUser() {
        Employee employee = new Employee("001Intern","Mithesh","Mathan");
        employeeService.deleteUser("001Intern");
        verify(employeeRepository,times(1)).deleteById("001Intern");
    }

    @Test
    void fetchAllEmployee() {
        when(employeeRepository.findAll()).thenReturn(Stream.of(
                new Employee("987654321","chamud","patirana"),
                new Employee("123456789", "tithira","wickraarachchi")).collect(Collectors.toList()));

        assertEquals(2,employeeService.fetchAllEmployee().size());
    }

    @Test
    void FindByName() {
        String Name = "chamud";
        when(employeeRepository.findByFirstname(Name)).thenReturn( Stream.of(
                new Employee("987654321","chamud","patirana")).collect(Collectors.toList()));

        assertEquals(1, employeeService.FindByName(Name).size());
    }


}