package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Room")
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class Room implements SuperEntity{
    @Id
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reservation> reserveList = new ArrayList<>();

    public Room(String room_type_id, String type, String key_money, int qty) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }

    public Room(String room_type_id) {
        this.room_type_id = room_type_id;
    }
}
