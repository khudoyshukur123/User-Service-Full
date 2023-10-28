package uz.pdp.user_crud_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.user_crud_service.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
