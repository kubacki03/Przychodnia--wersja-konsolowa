package Projekt.projekcik;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

@Component
public class PrzypomnijHaslo {



    @Autowired
    private EmailSenderService senderService;

    @Autowired
    private  KontoPacjentaRepository kontoPacjentaRepository;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STRING_LENGTH = 8;
    void przypomnij(String login) {
        Scanner scanner = new Scanner(System.in);

        if (kontoPacjentaRepository.existsKontoPacjentaByEmailOrLogin(login,login)){

         KontoPacjenta k =  kontoPacjentaRepository.findKontoPacjentaByEmailOrLogin(login, login);

            Random random = new SecureRandom();


            StringBuilder randomString = new StringBuilder(STRING_LENGTH);
            for (int i = 0; i < STRING_LENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                randomString.append(CHARACTERS.charAt(randomIndex));
            }

            String kod = randomString.toString();

        senderService.sendSimpleEmail(k.getEmail(),
                "Zmiana hasla",
                "Twoj kod do zmiany hasla to: "+randomString);




            System.out.println("Podaj kod autoryzacji: ");
            String odp = scanner.nextLine();

            if(kod.equals(odp)){
                System.out.println("Podaj nowe haslo: ");
                String noweHaslo = scanner.nextLine();


                kontoPacjentaRepository.updateHaslo(noweHaslo,login);

                System.out.println("Haslo zostalo zmienione");
            }
            else {
                System.out.println("Podany zly kod");
            }

    }








    }
    }

