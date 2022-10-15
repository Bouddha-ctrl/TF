package com.ufr.croissantshow.modele;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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
    @NotBlank(message = "This field is required")
    @Size(min=5, max=20, message = "Length should be between 5 and 20")
    private String username; // Entre 5 et 20 caractères, doit être unique entre tous les utilisateurs

    @Column(length = 20)
    @Size(min=8, max=24, message = "length should be between 8 and 24")
    @NotBlank(message = "This field is required")
   // @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,24}$", message = "at least one uppercase, one lowercase, one number.")
    private String password; // Entre 8 et 24 caractères, au moins une minuscule, une majuscule, un chiffre

    @Column
    @NotBlank(message = "This field is required")
    private String lastname;

    @Column
    @NotBlank(message = "This field is required")
    private String firstname;

    @Column
    @Email(message = "Invalid email")
    @NotBlank(message = "This field is required")
    private String email; // Adresse email valide (format X@Y.Z)

    @Column
    private boolean enabled;

    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private Role role;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "presents")
    private List<Mercredi> mercredis;

    public void addMercredi(Mercredi mercredi){
        if (mercredi == null)
            return;

        if (this.mercredis == null)
            this.mercredis = new ArrayList<>();

        this.mercredis.add(mercredi);
    }

    public void removeMercredi(Mercredi mercredi){ //do not use
        if(!mercredis.contains(mercredi))
            return;
        this.mercredis.remove(mercredi);
    }

    public List<Mercredi> getMercredis(){
        if (this.mercredis == null)
            this.mercredis = new ArrayList<>();
        return this.mercredis;
    }

    public void setMercredis(List<Mercredi> mercredis) {
        if(this.mercredis == null)
            this.mercredis = new ArrayList<>();
        else{
            for(Mercredi m:this.mercredis){
                m.removeUser(this);
            }
            this.mercredis.clear();
        }
        this.mercredis.addAll(mercredis);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", createdAt=" + createdAt +
                ", role=" + role +
                '}';
    }
}
