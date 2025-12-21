@Entity
public class HabitProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cleanliness;
    private int sleepSchedule;
    private int noiseTolerance;

    @ManyToOne
    private StudentProfile student;

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getSleepSchedule() {
        return sleepSchedule;
    }

    public void setSleepSchedule(int sleepSchedule) {
        this.sleepSchedule = sleepSchedule;
    }

    public int getNoiseTolerance() {
        return noiseTolerance;
    }

    public void setNoiseTolerance(int noiseTolerance) {
        this.noiseTolerance = noiseTolerance;
    }

    public StudentProfile getStudent() {
        return student;
    }

    public void setStudent(StudentProfile student) {
        this.student = student;
    }
}
