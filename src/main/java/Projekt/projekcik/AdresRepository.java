package Projekt.projekcik;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresRepository  extends JpaRepository<Adres, Long> {

    Adres findAdresByKodPocztowyAndAndNazwaUlicyAndAndNumerBudynkuAndAndNumerLokalu(String kod, String nazwa, int numer, int numerLok);


    Adres findAdresByKodPocztowyAndNazwaUlicyAndNumerBudynkuAndNumerLokalu(String kodPocztowy, String nazwaUlicy, int numerBudynku, int numerLokalu);
}
