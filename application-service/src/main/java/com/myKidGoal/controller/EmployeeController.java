package com.myKidGoal.controller;

import com.myKidGoal.model.employee.Employee;
import com.myKidGoal.model.employee.EmployeeExperience;
import com.myKidGoal.model.employee.EmployeeJob;
import com.myKidGoal.repository.employee.EmployeeExperienceRepository;
import com.myKidGoal.repository.employee.EmployeeJobRepository;
import com.myKidGoal.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeExperienceRepository employeeExperienceRepository;

    @Autowired
    private EmployeeJobRepository employeeJobRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allEmployees() {

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> res = new HashMap<>();
        res.put("employees", employeeRepository.findByDeletedIsFalse());

        response.put("_embedded", res);

        return response;
    }

    @GetMapping("/search/details/{id}")
    public Employee oneEmployee(@PathVariable(value = "id") int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new RuntimeException("Employee not found with ID [" + id + "]");
        }
    }

    @PostMapping("/save")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee) {
        if (employee.getId() == 0) {
            throw new EntityNotFoundException(
                    "Employee can't be updated before saving. First save the employee and then try updating!");
        }

        employeeRepository.save(employee);
    }

    @GetMapping(value = "/isUnique/email/{email}/{id}")
    public Map<String, String> isUniqueEmail(@PathVariable(value = "email") String email,
            @PathVariable(value = "id") int id) {

        Boolean isEmailExists = false;
        if (id == 0) {
            if (employeeRepository.findByEmail(email).isPresent()) {
                isEmailExists = true;
            }
        } else {
            if (employeeRepository.findByEmailAndId(email, id).isPresent()) {
                isEmailExists = true;
            }
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(isEmailExists));
        return response;
    }

    @GetMapping("{id}/experience/search/all")
    public Map<String, Object> allEmployeeExperience(@PathVariable(value = "id") int id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new EntityNotFoundException("Employee not found with id [" + id + "]");
        }

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> res = new HashMap<>();
        res.put("employeeExperiences", employeeExperienceRepository.findByEmployee(employeeOptional.get()));

        response.put("_embedded", res);

        return response;
    }

    @GetMapping("{/experience/search/details/{id}")
    public EmployeeExperience oneEmployeeExperience(@PathVariable(value = "id") int id) {
        Optional<EmployeeExperience> experienceOptional = employeeExperienceRepository.findById(id);

        if (experienceOptional.isPresent()) {
            return experienceOptional.get();
        } else {
            throw new RuntimeException("Employee Experience not found with ID [" + id + "]");
        }
    }

    @PostMapping("/experience/save")
    public void saveEmployeeExperience(@RequestBody EmployeeExperience employeeExperience) {
        employeeExperienceRepository.save(employeeExperience);
    }

    @PutMapping("/experience/update")
    public void updateEmployeeExperience(@RequestBody EmployeeExperience employeeExperience) {
        if (employeeExperience.getId() == 0) {
            throw new EntityNotFoundException(
                    "Employee Experience can't be updated before saving. First save the employee experience and then try updating!");
        }

        employeeExperienceRepository.save(employeeExperience);
    }

    @GetMapping("{id}/job/search/all")
    public Map<String, Object> allEmployeeJob(@PathVariable(value = "id") int id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new EntityNotFoundException("Employee not found with id [" + id + "]");
        }

        Map<String, Object> response = new HashMap<>();

        Map<String, Object> res = new HashMap<>();
        res.put("employeeJobs", employeeJobRepository.findByEmployee(employeeOptional.get()));

        response.put("_embedded", res);

        return response;
    }

    @GetMapping("{/job/search/details/{id}")
    public EmployeeJob oneEmployeeJob(@PathVariable(value = "id") int id) {
        Optional<EmployeeJob> employeeJobOptional = employeeJobRepository.findById(id);

        if (employeeJobOptional.isPresent()) {
            return employeeJobOptional.get();
        } else {
            throw new RuntimeException("Employee Job not found with ID [" + id + "]");
        }
    }

    @PostMapping("/job/save")
    public void saveEmployeeJob(@RequestBody EmployeeJob employeeJob) {
        employeeJobRepository.save(employeeJob);
    }

    @PutMapping("/job/update")
    public void updateEmployeeJob(@RequestBody EmployeeJob employeeJob) {
        if (employeeJob.getId() == 0) {
            throw new EntityNotFoundException(
                    "Employee Job can't be updated before saving. First save the employee job and then try updating!");
        }

        employeeJobRepository.save(employeeJob);
    }

}
