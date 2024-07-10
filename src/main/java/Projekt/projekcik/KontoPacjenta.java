package Projekt.projekcik;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="konto_pacjenta")
public class KontoPacjenta {


    @Id
    String pesel;


    @Column(name = "login")
    String login;

    @Column(name = "haslo")
    String haslo;

    @Column(name = "email")
    String email;
}
