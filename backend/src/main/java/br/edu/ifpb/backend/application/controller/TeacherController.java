package br.edu.ifpb.backend.application.controller;

import br.edu.ifpb.backend.application.dto.request.TeacherRequest;
import br.edu.ifpb.backend.application.dto.request.UserRequest;
import br.edu.ifpb.backend.business.entity.Teacher;
import br.edu.ifpb.backend.business.service.TeacherService;
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
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherController {
    private TeacherService teacherService;

    @ApiOperation(value = "Get all teachers from the database")
    @GetMapping
    public List<Teacher> index() {
        return teacherService.index();
    }

    @ApiOperation(value = "Create a new teacher in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = UserRequest.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createTeacher(@RequestBody @Valid TeacherRequest teacherRequest) {
        teacherService.saveTeacher(teacherRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a teacher from the database")
    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> removeTeacher(@PathVariable Long teacherId) {
        teacherService.removeTeacher(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Update a teacher's data in the database")
    @PutMapping("/{teacherId}")
    public ResponseEntity<Void> updateTeacher(@RequestBody @Valid TeacherRequest teacherRequest, @PathVariable Long teacherId) {
        teacherService.updateTeacher(teacherRequest, teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
