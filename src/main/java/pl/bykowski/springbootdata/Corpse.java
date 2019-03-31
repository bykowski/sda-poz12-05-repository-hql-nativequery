package pl.bykowski.springbootdata;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Corpse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private CorpseSize corpseSize;

    private LocalDate dateOfDeath;

    private String name;

    public Corpse(CorpseSize corpseSize, LocalDate dateOfDeath, String name, int ageOfDeath) {
        this.corpseSize = corpseSize;
        this.dateOfDeath = dateOfDeath;
        this.name = name;
        this.ageOfDeath = ageOfDeath;
    }

    public int getAgeOfDeath() {
        return ageOfDeath;
    }

    public void setAgeOfDeath(int ageOfDeath) {
        ageOfDeath = ageOfDeath;
    }

    private int ageOfDeath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CorpseSize getCorpseSize() {
        return corpseSize;
    }

    public void setCorpseSize(CorpseSize corpseSize) {
        this.corpseSize = corpseSize;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Corpse() {
    }


}
