package Projekt.projekcik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

@Component
public class PrzekladanieWizyty {

    @Autowired
    WizytyRepository wizytyRepository;

    @Autowired
    UmawianieWizyty umawianieWizyty;

    public void przelozWizyte(String idPacjenta){



        Scanner scanner = new Scanner(System.in);
        LocalDateTime minimalnaData = LocalDateTime.now().plusHours(24);
        List<Wizyty> lista= wizytyRepository.findWizytyByIdPacjenta(idPacjenta);


        Wizyty wybrana;
        for (Wizyty w : lista ){
            LocalDateTime dokladaData = w.getData().atTime(w.getGodzina());
            if(dokladaData.isAfter(minimalnaData)){
                System.out.println(w);


            }



        }
        System.out.println("Wybierz id: ");
        int wybraneId=scanner.nextInt();
        scanner.nextLine();



        for(Wizyty wizyta : lista){
            if(wizyta.getIdWizyty()==wybraneId){
                System.out.println("Wybierz nowa date: ");
                LocalDate nowaData = LocalDate.parse(scanner.nextLine());



                umawianieWizyty.wypiszTerminy(nowaData,wizyta.getIdLekarza());


                LocalTime nowaGodzina = LocalTime.parse(scanner.nextLine());

                wizytyRepository.updateTerminWizyty(nowaData,nowaGodzina,wizyta.getIdWizyty());

                System.out.println("Przelozono wizyte");




            }


        }


    }



}
