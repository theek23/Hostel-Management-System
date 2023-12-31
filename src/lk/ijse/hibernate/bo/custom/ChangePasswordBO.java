package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.LoginDTO;


public interface ChangePasswordBO extends SuperBO {
    boolean changeUsernameAndPassword(String currentUserName, String newUserName, String newPassword) throws Exception;

    LoginDTO getLoginAccess(String userName, String password) throws Exception;
}
