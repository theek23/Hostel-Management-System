package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.CustomDTO;
import lk.ijse.hibernate.dto.RoomDTO;

import java.util.ArrayList;

public interface ViewStudentRegistrationDetailBO extends SuperBO {
    RoomDTO searchRoom(String roomTypeId) throws Exception;

    boolean roomIsExists(String roomTypeID) throws Exception;

    ArrayList<CustomDTO> getStudentDetailsByRegisterRoomTypeId(String roomTypeId) throws Exception;
}
