package uz.pdp.user_crud_service.service;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.user_crud_service.entity.User;
import uz.pdp.user_crud_service.mapper.UserMapper;
import uz.pdp.user_crud_service.payload.ApiResult;
import uz.pdp.user_crud_service.payload.UserDTO;
import uz.pdp.user_crud_service.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public ApiResult<UserDTO> findById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) return ApiResult.failResponse("No such user");
        User user = optionalUser.get();

        return ApiResult.successResponse(userMapper.userToUserDTO(user));
    }

    @Override
    public ApiResult<List<UserDTO>> findAll() {
        List<User> allUsers = userRepository.findAll();
        List<UserDTO> userDTOS = userMapper.usersToUserDTOList(allUsers);
        return ApiResult.successResponse(userDTOS);
    }

    @Override
    public ApiResult<UserDTO> save(@Valid UserDTO user) {
        User user1 = userMapper.userDTOToUser(user);
        User saved = userRepository.save(user1);
        UserDTO data = userMapper.userToUserDTO(saved);
        return ApiResult.successResponse(data);
    }

    @Override
    public ApiResult<Boolean> deleteById(Integer id) {
        userRepository.deleteById(id);
        return ApiResult.successResponse();
    }

    @Override
    public ApiResult<UserDTO> update(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(userDTO.getId());
        if (optionalUser.isEmpty()) return ApiResult.failResponse("No such user");

        User user = optionalUser.get();

        if (!userDTO.getEmail().equals(user.getEmail())
            && userRepository.existsByEmail(userDTO.getEmail())) {
            return ApiResult.failResponse("Already existing email");
        } else user.setEmail(userDTO.getEmail());


        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        System.out.println();
        User updated = userRepository.save(user);

        return ApiResult.successResponse(userMapper.userToUserDTO(updated));
    }
}
