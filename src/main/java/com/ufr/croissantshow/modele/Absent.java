package com.ufr.croissantshow.modele;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Absent {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name="utilisateur_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="mercredi_id")
    private Mercredi mercredi;

}
