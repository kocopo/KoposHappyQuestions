package eu.kocka.jeopardyBackEnd.enitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "game_name", nullable = false)
    private String gameName;
    @OneToMany(mappedBy = "game")
    private List<Category> categories;

}
