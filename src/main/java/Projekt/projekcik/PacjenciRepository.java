package Projekt.projekcik;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacjenciRepository extends JpaRepository<Pacjenci, Long> {

    boolean existsPacjenciByPesel(String pesel);

    Pacjenci getPacjenciByPesel(String pesel);
}
