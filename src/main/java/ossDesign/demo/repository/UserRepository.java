package ossDesign.demo.repository;

import ossDesign.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findById(long userId);
    Optional<UserEntity> findByLoginId(String loginId);
}
