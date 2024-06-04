package ossDesign.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ossDesign.demo.entity.UserEntity;
import ossDesign.demo.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserEntity signUp(UserEntity user) {
        UserEntity existingUser = userRepository.findById(user.getId());
        if (existingUser != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        userRepository.save(user);
        return user;
    }
}
