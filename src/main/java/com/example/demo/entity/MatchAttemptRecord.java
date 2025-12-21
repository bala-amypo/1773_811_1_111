@Entity
public class MatchAttemptRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentAId;
    private Long studentBId;

    public void setStudentAId(Long studentAId) {
        this.studentAId = studentAId;
    }

    public void setStudentBId(Long studentBId) {
        this.studentBId = studentBId;
    }
}
