package Projekt.projekcik;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="Specjalizacja")
public class Specjalizacje {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int idSpecjalizacji;

    @Column(name = "specjalizacja")
    String specjalizacja;
}
