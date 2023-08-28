import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Table(name = "person")
@Entity

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 25)
    private String name;

    // Her burde den automatisk gøre det for os i stedet for main, i stedet for "em.persist(p1);"
    @OneToOne(cascade = CascadeType.PERSIST)
    // Man bruger kun Maps hvis man bruger onetoone
    @MapsId
    private Phone phone;

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Person(String name) {
        this.name = name;
    }
}
