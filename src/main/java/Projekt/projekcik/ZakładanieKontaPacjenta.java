package Projekt.projekcik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class ZakładanieKontaPacjenta {



    @Autowired
    private KontoPacjentaRepository kontoPacjentaRepository;

    @Autowired
    private AdresRepository adresRepository;

    @Autowired
    private PacjenciRepository pacjenciRepository;

    public void dodajKonto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj pesel: ");
        String pesel = scanner.nextLine();


        System.out.println("Podaj email: ");
        String email = scanner.nextLine();

        System.out.println("Podaj login: ");
        String login = scanner.nextLine();

        while (login.contains("@")) {
            System.out.println("Login nie może zawierać @. Podaj login ponownie: ");
            login = scanner.nextLine();
        }

        System.out.println("Podaj hasło: ");
        String haslo = scanner.nextLine();

        if (kontoPacjentaRepository.existsKontoPacjentaByPesel(pesel) || kontoPacjentaRepository.existsKontoPacjentaByEmailOrLogin(email, login)) {
            System.out.println("Konto o podanym PESEL-u lub loginie już istnieje.");
            return;
        }

        System.out.println("Tworzenie nowego konta...");

        System.out.println("Podaj swoje imię: ");
        String imie = scanner.nextLine();

        System.out.println("Podaj swoje nazwisko: ");
        String nazwisko = scanner.nextLine();

        System.out.println("Podaj datę urodzenia (YYYY-MM-DD): ");
        String data = scanner.nextLine();
        LocalDate dataUrodzenia = LocalDate.parse(data);

        System.out.println("Podaj płeć: ");
        String plec = scanner.nextLine();

        System.out.println("Podaj wagę: ");
        int waga = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj wzrost: ");
        int wzrost = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj miasto zamieszkania: ");
        String miasto = scanner.nextLine();

        System.out.println("Podaj ulicę: ");
        String ulica = scanner.nextLine();

        System.out.println("Podaj numer budynku: ");
        int numerBudynku = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj numer mieszkania: ");
        int numerMieszkania = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj kod pocztowy: ");
        String kod = scanner.nextLine();

        Adres adresZamieszkania = adresRepository.findAdresByKodPocztowyAndNazwaUlicyAndNumerBudynkuAndNumerLokalu(kod, ulica, numerBudynku, numerMieszkania);
        if (adresZamieszkania == null) {
            adresZamieszkania = new Adres(0, ulica, numerBudynku, numerMieszkania, miasto, kod);
            adresRepository.save(adresZamieszkania);
            adresZamieszkania = adresRepository.findAdresByKodPocztowyAndNazwaUlicyAndNumerBudynkuAndNumerLokalu(kod, ulica, numerBudynku, numerMieszkania);
        }


        KontoPacjenta kontoPacjenta = new KontoPacjenta(pesel, login, haslo, email);
        Pacjenci pacjenci = new Pacjenci(imie, nazwisko, dataUrodzenia, plec, wzrost, waga, adresZamieszkania.getId_adresu(), pesel);

        kontoPacjentaRepository.save(kontoPacjenta);
        pacjenciRepository.save(pacjenci);

        System.out.println("Konto zostało pomyślnie utworzone.");
    }
}
