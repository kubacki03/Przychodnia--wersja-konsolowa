package Projekt.projekcik;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="Pacjenci")
public class Pacjenci {

    @Column(name = "imie")
    String imie;
    @Column(name = "nazwisko")
    String nazwisko;
    @Column(name = "data_urodzenia")
    LocalDate dataUrodzenia;
    @Column(name = "plec")
    String plec;
    @Column(name = "wzrost")
    int wzrost;
    @Column(name = "waga")
    int waga;
    @Column(name = "id_adresu")
    int idAdresu;

    @Id
    String pesel;
}
