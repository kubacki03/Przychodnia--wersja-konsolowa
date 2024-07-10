package Projekt.projekcik;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="lekarze")
public class Lekarze {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int idLekarza;

    @Column(name = "imie")
    String imie;

    @Column(name = "nazwisko")
    String nazwisko;



}
