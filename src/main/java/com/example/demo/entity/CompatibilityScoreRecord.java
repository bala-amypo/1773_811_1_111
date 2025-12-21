@Entity
public class CompatibilityScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private StudentProfile studentA;

    @ManyToOne
    private StudentProfile studentB;

    private double score;

    public void setScore(double score) {
        this.score = score;
    }
}
