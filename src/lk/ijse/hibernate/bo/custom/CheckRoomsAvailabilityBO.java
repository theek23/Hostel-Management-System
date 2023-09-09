package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.JoinQueryDAO;
import lk.ijse.hibernate.dao.custom.RoomDAO;
import lk.ijse.hibernate.dto.CustomDTO;

import java.util.ArrayList;


public interface CheckRoomsAvailabilityBO extends SuperBO {
    ArrayList<CustomDTO> loadAllRoomsDetails() throws Exception;
}
