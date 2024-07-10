package Projekt.projekcik;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="Adres")
public class Adres {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id_adresu;

    @Column(name = "nazwa_ulicy")
    String nazwaUlicy;

    @Column(name = "numer_budynku")
    int numerBudynku;


    @Column(name = "numer_lokalu")
    int numerLokalu;

    @Column(name = "miasto")
    String miasto;

    @Column(name = "kod_pocztowy")
    String kodPocztowy;
}
