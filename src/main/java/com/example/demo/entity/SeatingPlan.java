@Entity
@Data
public class SeatingPlan {
    @Id
    @GeneratedValue
    private Long id;
    private Long sessionId;
    private String planDetails;
}
