package uz.pdp.user_crud_service.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.user_crud_service.payload.ApiResult;
import uz.pdp.user_crud_service.payload.UserDTO;

import java.util.List;

@RestController
@RequestMapping("api/users")
public interface UserController {

    @GetMapping
    ApiResult<List<UserDTO>> getAll();

    @GetMapping("/{id}")
    ApiResult<UserDTO> get(@PathVariable Integer id);

    @PostMapping
    ApiResult<UserDTO> create(@RequestBody UserDTO userDTO);

    @PutMapping
    ApiResult<UserDTO> update(@RequestBody UserDTO userDTO);

    @DeleteMapping("{id}")
    ApiResult<Boolean> delete(@PathVariable Integer id);

}
