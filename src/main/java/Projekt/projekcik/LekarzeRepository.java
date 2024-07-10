package Projekt.projekcik;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LekarzeRepository  extends JpaRepository<Lekarze, Long> {
    @Query("SELECT l FROM Lekarze l WHERE l.idLekarza IN (SELECT sl.idLekarza FROM SpecLek sl WHERE sl.idSpecjalizacji = (SELECT s.idSpecjalizacji FROM Specjalizacje s WHERE LOWER(s.specjalizacja) = :wybrana))")
    List<Lekarze> findLekarzeBySpecjalizacja(@Param("wybrana") String wybrana);

}
