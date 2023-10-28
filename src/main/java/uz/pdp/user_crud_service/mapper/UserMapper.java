package uz.pdp.user_crud_service.mapper;


import org.mapstruct.Mapper;
import uz.pdp.user_crud_service.entity.User;
import uz.pdp.user_crud_service.payload.UserDTO;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserDTO> usersToUserDTOList(List<User> users);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
