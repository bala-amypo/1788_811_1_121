@Entity
@Data
public class Location {
    @Id
    @GeneratedValue
    private Long id;
    private String roomName;
    private int capacity;
}
