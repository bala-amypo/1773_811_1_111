@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;

    public int getAge() {
        return age;
    }
}
