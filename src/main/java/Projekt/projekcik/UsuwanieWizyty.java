package Projekt.projekcik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;



@Component
public class UsuwanieWizyty {

    @Autowired
    WizytyRepository wizytyRepository;

    void usunWizyte(String pesel){
        Scanner scanner =new Scanner(System.in);

        wizytyRepository.findWizytyByIdPacjentaAndAndDataAfter(pesel,LocalDate.now().plusDays(2)).forEach(System.out::println);

        System.out.println("Podaj id wizyty: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        wizytyRepository.deleteWizytyByIdWizyty(id);

    }

}
