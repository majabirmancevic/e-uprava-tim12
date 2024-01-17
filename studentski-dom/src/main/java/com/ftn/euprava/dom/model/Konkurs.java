package com.ftn.euprava.dom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Konkurs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "grad")

    private String grad;

    @Column(name = "skolska_godina")
    private String skolskaGodina;

    @ManyToMany
    @JoinTable(
            name = "konkurs_prijavljeni_studenti",
            joinColumns = @JoinColumn(name = "konkurs_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> prijavljeniStudenti;

    // Getteri i setteri

    public List<Student> getPrijavljeniStudenti() {
        return prijavljeniStudenti;
    }

    public void setPrijavljeniStudenti(List<Student> prijavljeniStudenti) {
        this.prijavljeniStudenti = prijavljeniStudenti;
    }

}
