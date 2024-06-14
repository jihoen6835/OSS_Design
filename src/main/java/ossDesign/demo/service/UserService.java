package ossDesign.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ossDesign.demo.entity.UserEntity;
import ossDesign.demo.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserEntity signUp(UserEntity user) {
        Optional<UserEntity> exUser=userRepository.findByLoginId(user.getLoginId());
        if (exUser.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다(아이디 중복).");
        }
        userRepository.save(user);
        return user;
    }
}


