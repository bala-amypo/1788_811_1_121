@Entity
@Data
public class ExamSession {
    @Id
    @GeneratedValue
    private Long id;
    private String examName;
    private String date;
}
