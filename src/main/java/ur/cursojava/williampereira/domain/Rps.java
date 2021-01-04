package ur.cursojava.williampereira.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "repository")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private int likes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "repositories_technologies",
            joinColumns = {
                    @JoinColumn(name = "repository_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "technology_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Technology> technologies = new HashSet<>();
}