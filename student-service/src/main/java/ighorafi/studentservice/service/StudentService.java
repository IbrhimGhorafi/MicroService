package ighorafi.studentservice.service;

import ighorafi.studentservice.entity.Students;
import ighorafi.studentservice.repository.ProjectRestClient;
import ighorafi.studentservice.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;
    private ProjectRestClient projectRestClient;
    public List<Students> getAllStudents() {
        try {
            List<Students> allStudents = studentRepository.findAll();
            allStudents.forEach(student -> {
                student.setProject(projectRestClient.findProjectById(student.getProjectId()));
            });
            return allStudents;
        } catch (Exception e) {
            System.out.println("Error in getting all students: " + e.getMessage());
            return Collections.emptyList();
        }
    }


    public Students getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Students createStudent(Students student) {
        return studentRepository.save(student);
    }
}
