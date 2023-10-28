package uz.pdp.user_crud_service.service;


import jakarta.validation.Valid;
import uz.pdp.user_crud_service.payload.ApiResult;
import uz.pdp.user_crud_service.payload.UserDTO;

import java.util.List;

public interface UserService {

    ApiResult<UserDTO> findById(Integer id);

    ApiResult<List<UserDTO>> findAll();

    ApiResult<UserDTO> save(@Valid UserDTO user);

    ApiResult<Boolean> deleteById(Integer id);

    ApiResult<UserDTO> update(UserDTO updateUserDTO);

}
