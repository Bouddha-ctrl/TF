package com.ufr.croissantshow.modele;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name="utilisateur")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(unique = true, length = 20)
    @Size(min=5, max=20, message = "Length should be between 5 and 20")
    @NotBlank(message = "This field is required")
    private String username; // Entre 5 et 20 caractères, doit être unique entre tous les utilisateurs

    @Column(length = 20)
    @Size(min=8, max=24, message = "length should be between 8 and 24")
    @NotBlank(message = "This field is required")
    private String password; // Entre 8 et 24 caractères, au moins une minuscule, une majuscule, un chiffre

    @Column
    @NotBlank(message = "This field is required")
    private String lastname;

    @Column
    @NotBlank(message = "This field is required")
    private String firstname;

    @Column
    @Email(message = "Invalid email")
    private String email; // Adresse email valide (format X@Y.Z)

    @Column
    private boolean enabled;

    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Absent> absentList;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "presents")
    private List<Mercredi> attendedMercredi;
}
