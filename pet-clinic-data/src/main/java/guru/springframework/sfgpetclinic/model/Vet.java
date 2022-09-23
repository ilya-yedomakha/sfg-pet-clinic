package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = {@JoinColumn(name = "vet_id", referencedColumnName = "id"),
            @JoinColumn(name = "first_name_vet", referencedColumnName = "first_name"),
            @JoinColumn(name = "last_name_vet", referencedColumnName = "last_name")
    },
            inverseJoinColumns = {@JoinColumn(name = "speciality_id",referencedColumnName = "id"),
                    @JoinColumn(name = "spec_description", referencedColumnName = "description")
            })
    private Set<Speciality> specialities = new HashSet<>();
}
