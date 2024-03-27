package ighorafi.studentservice.controller;

import ighorafi.studentservice.entity.Students;
import ighorafi.studentservice.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private StudentService pfeService;

    @PostMapping
    public ResponseEntity<Students> createStudent(@RequestBody Students student) {
        Students createdStudent = pfeService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> students = pfeService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable Long id) {
        Students student = pfeService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
