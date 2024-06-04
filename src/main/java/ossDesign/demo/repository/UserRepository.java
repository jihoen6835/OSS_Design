package ossDesign.demo.repository;

import ossDesign.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findById(String Id);
}
