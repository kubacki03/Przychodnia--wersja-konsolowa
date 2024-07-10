package Projekt.projekcik;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "Wizyty")
public class Wizyty {

    @Id
    int idWizyty;

    @Column(name = "id_lekarza")
    int idLekarza;

    @Column(name = "id_pacjenta")
    String idPacjenta;

    @Column(name = "opis")
    String opis;

    @Column(name = "data")
    LocalDate data;

    @Column(name = "godzina")
    LocalTime godzina;
}
