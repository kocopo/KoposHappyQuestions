package eu.kocka.jeopardyBackEnd.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "category_name", nullable = false)
    private String categoryName;
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;
    @OneToMany(mappedBy = "category")
    private List<Question> questions;
}
