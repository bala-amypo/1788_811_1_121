@Entity
@Data
public class StudentEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String regNo;
}
