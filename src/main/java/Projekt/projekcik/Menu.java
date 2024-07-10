package Projekt.projekcik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    KontoPacjentaRepository kontoPacjentaRepository;

    @Autowired
    PacjenciRepository pacjenciRepository;

    @Autowired
    WizytyRepository wizytyRepository;

    @Autowired
    UmawianieWizyty umawianieWizyty;

    @Autowired
    PrzekladanieWizyty przekladanieWizyty;

    @Autowired
    UsuwanieWizyty usuwanieWizyty;

    @Autowired
    AdresRepository adresRepository;

    @Autowired
    private ZakładanieKontaPacjenta zakładanieKontaPacjenta;


    public void wyswietlMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1) Zaloguj sie ");
        System.out.println("2) Zalóż konto ");
        int decyzja =scanner.nextInt();
        scanner.nextLine();

        if(decyzja==1){
            logowanie();

        } else if (decyzja==2) {
          zakładanieKontaPacjenta.dodajKonto();
        }

        wyswietlMenu();


    }

    void logowanie(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Podaj swój login/email");
        String login = scanner.nextLine();

        System.out.println("Podaj swoje haslo: ");
        String haslo = scanner.nextLine();

        KontoPacjenta k = kontoPacjentaRepository.findKontoPacjentaByEmailOrLogin(login, login);

        if (k.haslo.equals(haslo)) {
            Pacjenci p = pacjenciRepository.getPacjenciByPesel(k.getPesel());
            System.out.println("Jestes zalogowany jako: " + p.getImie() + " " + p.getNazwisko());

            int wybor = 0;
            while (wybor != 5) {
                System.out.println("1) Wyswietl moje wizyty");
                System.out.println("2) Umów nową wizyte ");
                System.out.println("3) Przeloz wizyte");
                System.out.println("4) Usun wizyte");
                System.out.println("5) Wyloguj");
                System.out.println("Wybierz opcje: ");
                wybor = scanner.nextInt();
                scanner.nextLine();

                switch (wybor) {
                    case 1:
                        wizytyRepository.findWizytyByIdPacjenta(k.getPesel()).forEach(System.out::println);

                        break;

                    case 2:
                        umawianieWizyty.umowWizyte(k.getPesel());
                        break;

                    case 3:
                        przekladanieWizyty.przelozWizyte(k.getPesel());
                        break;

                    case 4:
                        usuwanieWizyty.usunWizyte(k.getPesel());
                        break;

                    case 5:
                        System.out.println("Wyjście z programu.");
                        break;

                    default:
                        System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
                        break;
                }
            }
        } else {
            System.out.println("Błędny login lub hasło.");
        }
    }
}
