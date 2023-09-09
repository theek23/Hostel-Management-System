package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.LoginDTO;

import java.util.ArrayList;

public interface LoginBO extends SuperBO {
    boolean saveLoginAccess(LoginDTO dto) throws Exception;

    LoginDTO getLoginAccess(String userName, String password) throws Exception;

    ArrayList<LoginDTO> existLogins() throws Exception;
}
