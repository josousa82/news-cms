package org.cmsspringfive.newscms.domain.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.cmsspringfive.newscms.domain.models.User;
import org.cmsspringfive.newscms.domain.vo.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(tags = "User", description = "User API")
public class UserResource {

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find User", notes = "Find the user by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 400, message = "User not found")
    })
    public ResponseEntity<User> findOne(@PathVariable(value = "id") String id){

        return ResponseEntity.ok(new User());
    }

    @GetMapping
    @ApiOperation(value = "List Users", notes = "List all Users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 400, message = "User not found")
    })
    public ResponseEntity<List<User>> getAll(){

        return ResponseEntity.ok(Arrays.asList(new User(), new User()));
    }

    @PostMapping
    @ApiOperation(value = "Create User", notes = "It permits to create a new User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User created successfully"),
            @ApiResponse(code = 400, message = "User not found")
    })
    public ResponseEntity<User> newUser(UserRequest userRequest){
        return new ResponseEntity<>(new User(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete User", notes = "It permits to remove a User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User removed successfully"),
            @ApiResponse(code = 400, message = "User not found")
    })
    public void removeUser(@PathVariable(value = "id") String id){

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Create User", notes = "It permits to create a new User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User update successfully"),
            @ApiResponse(code = 400, message = "User not found"),
            @ApiResponse(code = 404, message = "Invalid request")
    })
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") String id, User userRequest){
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }

}
