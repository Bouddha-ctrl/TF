package com.ufr.croissantshow.modele;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
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


    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private boolean mercrediAnnule; // Si l'admin l'a annulé (jour férié ect) ou si il n'y a pas de responsable

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "utilisateur_present",
            joinColumns = @JoinColumn(name = "mercredi_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
    private List<User> presents;

    @ManyToOne
    @JoinColumn(name="responsable_id")
    private User responsable;

    public List<User> getPresents(){
        if (this.presents == null)
            this.presents = new ArrayList<>();
        return this.presents;
    }

    public void setPresents(List<User> users){
        if(this.presents == null)
            this.presents = new ArrayList<>();
        else{
            for(User u:this.presents){
                u.removeMercredi(this);
            }
            this.presents.clear();
        }
        this.presents.addAll(users);
    }
    public void addUser(User user){
        if (user == null)
            return;

        if (this.presents == null)
            this.presents = new ArrayList<>();

        if (this.presents.contains(user))
            return;

        presents.add(user);
        user.addMercredi(this);
    }

    public void removeUser(User user){ //do not use
        if(!presents.contains(user))
            return;
        presents.remove(user);
        user.removeMercredi(this);
    }

    public boolean containUserByUsername(String username){ //used in html
        return this.presents
                .stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }
}
