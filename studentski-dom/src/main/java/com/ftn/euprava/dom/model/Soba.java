package com.ftn.euprava.dom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Soba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "broj_sobe")
    private String brojSobe;

    @ManyToOne
    @JoinColumn(name = "dom_id", nullable = false)
    private Dom dom;



}
