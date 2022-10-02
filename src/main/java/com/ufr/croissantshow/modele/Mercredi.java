package com.ufr.croissantshow.modele;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Mercredi {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column
    private Date date;

    @Column
    private boolean mercrediAnnule; // Si l'admin l'a annulé (jour férié ect) ou si il n'y a pas de responsable

    @ManyToMany
    @JoinTable(
            name = "utilisateur_present",
            joinColumns = @JoinColumn(name = "mercredi_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
    private List<User> presents;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mercredi")
    private List<Absent> absents;

    @ManyToOne
    @JoinColumn(name="responsable_id")
    private User responsable;
}
