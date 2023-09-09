package lk.ijse.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDTO {
    private String name;
    private String userName;
    private String password;
    private String jobRole;
}
