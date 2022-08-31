package br.edu.ifpb.backend.application.controller;

import br.edu.ifpb.backend.application.dto.request.StudentRequest;
import br.edu.ifpb.backend.application.dto.request.UserRequest;
import br.edu.ifpb.backend.business.entity.Student;
import br.edu.ifpb.backend.business.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public List<Student> index() {
        return studentService.index();
    }

    @ApiOperation(value = "Create a new student in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = UserRequest.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createStudent(@RequestBody @Valid StudentRequest studentRequest){
        studentService.saveStudent(studentRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
