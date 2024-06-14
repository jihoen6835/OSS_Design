package ossDesign.demo.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class LoginForm {

    @NotNull
    public String loginId;

    @NotNull
    public String password;

}
