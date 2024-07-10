package Projekt.projekcik;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KontoPacjentaRepository extends JpaRepository<KontoPacjenta, Long> {


    boolean existsKontoPacjentaByPesel(String pesel);


    boolean existsKontoPacjentaByEmailOrLogin(String email, String login);

    KontoPacjenta findKontoPacjentaByEmailOrLogin(String login,String login2);


}
