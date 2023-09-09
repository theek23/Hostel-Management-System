package lk.ijse.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDTO {
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;

    public String toString(){
        return room_type_id;
    }
}
