package Projekt.projekcik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class UmawianieWizyty {

    @Autowired
    private KontoPacjentaRepository kontoPacjentaRepository;

    @Autowired
    private AdresRepository adresRepository;

    @Autowired
    private PacjenciRepository pacjenciRepository;

    @Autowired
    private WizytyRepository wizytyRepository;

    @Autowired
    private LekarzeRepository lekarzeRepository;

    public enum Specjalizacja {
        KARDIOLOG,
        PEDIATRA,
        ORTOPEDA,
        OKULISTA
    }


    public void umowWizyte(String idPacjenta) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dostepne specjalizacje:");
        for (Specjalizacja specjalizacja : Specjalizacja.values()) {
            System.out.println(specjalizacja.name());
        }

        System.out.println("Wybierz specjalizacje: ");
        Specjalizacja wybrana = Specjalizacja.valueOf(scanner.nextLine().toUpperCase());

        wypiszLekarzy(wybrana, idPacjenta);
    }

    public void wypiszLekarzy(Specjalizacja specjalizacja, String idPacjenta) {
        for (Lekarze l : lekarzeRepository.findLekarzeBySpecjalizacja(specjalizacja.name())) {
            System.out.println("Lekarz " + l.getImie() + " " + l.getNazwisko() + " " + l.getIdLekarza());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz lekarza: ");
        int wybranyLekarz = scanner.nextInt();
        scanner.nextLine();


        System.out.println("1) Aby wypisać najblizszy termin");
        System.out.println("2) Aby wybrac dokladny dzien");
        int decyzja = scanner.nextInt();
        scanner.nextLine();
        Wizyty w;
        if(decyzja==2){
            System.out.println("Wybierz dzien w formacie YYYY-MM-DD ");
            LocalDate wybranaData = LocalDate.parse(scanner.nextLine());
            wypiszTerminy(wybranaData,wybranyLekarz);
            System.out.println("Wybierz godzine hh:mm:ss : ");
            LocalTime wybranaGodzina = LocalTime.parse(scanner.nextLine());
            w = new Wizyty(0, wybranyLekarz, idPacjenta, "NWM", wybranaData, wybranaGodzina);
        }
        else {

            wypiszTerminy(LocalDate.now().plusDays(1), wybranyLekarz);
            System.out.println("Wybierz godzine hh:mm:ss : ");
            LocalTime wybranaGodzina = LocalTime.parse(scanner.nextLine());
            LocalDate wybranaData = LocalDate.now().plusDays(1);

             w = new Wizyty(0, wybranyLekarz, idPacjenta, "NWM", wybranaData, wybranaGodzina);
        }




        wizytyRepository.save(w);
    }


    public void wypiszTerminy(LocalDate dzien, int wybraneID) {

        List<LocalTime> lista = wizytyRepository.findAllWizytyGodzina(dzien,wybraneID);

        System.out.println("Wolne godziny w dniu "+dzien);

        LocalTime data = LocalTime.of(8, 0);

        for (int i = 0; i < 20; i++) {
            if (!lista.contains(data)) {
                System.out.println(data);
            }
            data = data.plusMinutes(30);
        }
    }


    public void wypiszLekarzy(String specjalizacja,String idPacjenta){



       for(Lekarze l : lekarzeRepository.findLekarzeBySpecjalizacja(specjalizacja)) {
           System.out.println("Lekarz "+l.getImie()+" "+l.getNazwisko() +" "+l.getIdLekarza());
        }

       Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz lekarza: ");
        int wybranyLekarz = scanner.nextInt();
        scanner.nextLine();
        wypiszTerminy(LocalDate.now().plusDays(1),wybranyLekarz);

        System.out.println("Wybierz godzine hh:mm:ss : ");
        LocalTime wybranaGodzina = LocalTime.parse(scanner.nextLine());

        LocalDate wybranaData= LocalDate.now().plusDays(1);


        Wizyty w = new Wizyty(0,wybranyLekarz, idPacjenta,"NWM",wybranaData,wybranaGodzina);

        wizytyRepository.save(w);
    }





}
