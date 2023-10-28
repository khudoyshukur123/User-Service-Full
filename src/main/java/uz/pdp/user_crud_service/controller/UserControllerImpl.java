package uz.pdp.user_crud_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.user_crud_service.payload.ApiResult;
import uz.pdp.user_crud_service.payload.UserDTO;
import uz.pdp.user_crud_service.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ApiResult<List<UserDTO>> getAll() {
        return userService.findAll();
    }

    @Override
    public ApiResult<UserDTO> get(Integer id) {
        return userService.findById(id);
    }

    @Override
    public ApiResult<UserDTO> create(UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @Override
    public ApiResult<UserDTO> update(UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        return userService.deleteById(id);
    }
}
