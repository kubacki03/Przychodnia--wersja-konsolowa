package Projekt.projekcik;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

public interface KontoPacjentaRepository extends JpaRepository<KontoPacjenta, Long> {


    boolean existsKontoPacjentaByPesel(String pesel);


    boolean existsKontoPacjentaByEmailOrLogin(String email, String login);



    KontoPacjenta findKontoPacjentaByEmailOrLogin(String login,String login2);


    @Modifying
    @Transactional
    @Query("UPDATE KontoPacjenta w SET w.haslo = :noweHaslo WHERE w.login = :podanyPesel or w.email = :podanyPesel")
    int updateHaslo(@Param("noweHaslo") String noweHaslo,  @Param("podanyPesel") String  podanyPesel);



}
