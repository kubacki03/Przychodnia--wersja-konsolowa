package Projekt.projekcik;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="SpecLek")
public class SpecLek {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    @Column(name = "id_specjalizacji")
    int idSpecjalizacji;


    @Column(name = "id_lekarza")
    int idLekarza;
}
