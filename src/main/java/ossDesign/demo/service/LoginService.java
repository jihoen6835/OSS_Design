    package ossDesign.demo.service;

    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;
    import ossDesign.demo.entity.UserEntity;
    import ossDesign.demo.repository.UserRepository;

    import java.util.Optional;

    @Service
    @RequiredArgsConstructor
    public class LoginService {

        private final UserRepository userRepository;

        public UserEntity login(String loginid, String loginpw) {
            // logind와 password를 받음
            System.out.println("아이디: " + loginid );
            System.out.println("패스워드: " + loginpw );

            Optional<UserEntity> findUserOptional = userRepository.findByLoginId(loginid);
            UserEntity user = findUserOptional.get();

            if (user.getPassword().equals(loginpw)) {
                System.out.println("내가 가져온 패스워드 :" + user.getPassword());
                System.out.println("내가 넣은 패스워드 :" + loginpw);

                return user;

            }else{

                return null;

            }
        }
    }
