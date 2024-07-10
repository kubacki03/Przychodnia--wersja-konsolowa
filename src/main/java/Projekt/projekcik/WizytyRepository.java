package Projekt.projekcik;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface WizytyRepository extends JpaRepository<Wizyty, Long> {

    boolean existsWizytyByDataAndGodzinaAndIdLekarza(LocalDate data, LocalTime godzina, int id);



    @Query("SELECT w.godzina FROM Wizyty w WHERE w.data=:dzien and w.idLekarza=:wybraneID")
    List<LocalTime> findAllWizytyGodzina(LocalDate dzien, int wybraneID);

    List<Wizyty> findWizytyByIdPacjenta(String pesel);


    List<Wizyty> findWizytyByIdPacjentaAndAndDataAfter(String pesel, LocalDate data);


    @Modifying
    @Transactional
    @Query("UPDATE Wizyty w SET w.data = :nowaData, w.godzina = :nowaGodzina WHERE w.idWizyty = :idWiz")
    int updateTerminWizyty(@Param("nowaData") LocalDate nowaData, @Param("nowaGodzina") LocalTime nowaGodzina, @Param("idWiz") int idWybranejWizyty);


    @Modifying
    @Transactional
    void deleteWizytyByIdWizyty(int idWizyty);

    List<Wizyty> findWizytiesByIdPacjenta(String id);


}
