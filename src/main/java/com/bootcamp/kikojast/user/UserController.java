package com.bootcamp.kikojast.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user/")
@AllArgsConstructor
public class UserController {

    private final IUserService service;
    private UserMapper mapper;


    @PostMapping("/v1")

    public ResponseEntity save(@RequestBody UserDTO userDTO){
    User user =mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")

    public ResponseEntity update(@RequestBody UserDTO userDTO){
        User user =mapper.toUser(userDTO);
        service.update(user);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")

    public ResponseEntity<UserDTO> getById(@PathVariable Long id ){
    User user = service.getById(id);
    UserDTO userDTO =mapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<UserDTO>> getAll(){
    List<User> users=    service.getAll();
    List<UserDTO> userDTOS =    mapper.toUserDTOS(users);

        return ResponseEntity.ok(userDTOS);
    }

    @DeleteMapping("/v1/{id}")

    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();


    }



}