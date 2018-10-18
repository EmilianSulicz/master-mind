import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class playgame {
    private static String[] getColors(){
        Scanner input = new Scanner(System.in);
        for (int retries = 0;; retries++)
            try {
                String a = input.next();
                String b = input.next();
                String c = input.next();
                String d = input.next();
                colors.valueOf(a);
                colors.valueOf(b);
                colors.valueOf(c);
                colors.valueOf(d);
                return new String[]{a, b, c, d};
            } catch (IllegalArgumentException m) {
                if (retries < 5) {
                    System.out.println("Podałeś zły kolor, jeżeli podasz zły kolor 5 razy, gra się wyłączy");
                } else {
                    System.out.println("Podałeś zły kolor za dużo razy");
                    throw m;
                }
            }
    }
    private static void recallColors(){
        System.out.println("Kolory do wyboru to: zielony, zolty, niebieski, czerwony, pomaranczowy, fioletowy");
    }


    public static void main(String[] args) {
        int gameover = 0;
        int trynum = 1;
        System.out.println("Podaj ukryty kod składający się z 4 kolorów");
        recallColors();
        code hiddenCode = new code(getColors());
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            while (gameover == 0){
                if (trynum <=10){
                    System.out.println("\nZgadnij ukryty kod składający się z 4 kolorów w 10 próbach, to twoja próba numer " + trynum);
                    recallColors();
                    int dobreMiejsce = 0;
                    int dobryKolor = 0;
                    code kod = new code(getColors());
                    for(int i =0; i<4; i++) {
                        if (hiddenCode.kolory[i].equals(kod.kolory[i])){
                            dobreMiejsce++;
                        }
                    }
                List<String> kodKolory = new ArrayList<>(Arrays.asList(kod.kolory));
                List<String> hiddenCodeKolory = new ArrayList<>(Arrays.asList(hiddenCode.kolory));
                for (String i : kodKolory) {
                    if (hiddenCodeKolory.contains(i)){
                        hiddenCodeKolory.remove(i);
                        dobryKolor ++;
                    }
                }
                if(Arrays.equals(kod.kolory, hiddenCode.kolory)){
                    System.out.println("Brawo, zgadłeś ukryty kod");
                    break;
                }
                else {
                    trynum+=1;
                }
                dobryKolor = dobryKolor - dobreMiejsce;
                System.out.println("Ilość poprawnych kolorów na dobrym miejscu: " + dobreMiejsce);
                System.out.println("Ilość poprawnych kolorów na złym miejscu: " + dobryKolor);
            }
            else {
                gameover = 1;
                System.out.println("Przegrałeś, nie udało ci się zgadnąć ukrytego kodu w 10 próbach. Ukryty kod to: " + hiddenCode);
            }
        }
    }
}