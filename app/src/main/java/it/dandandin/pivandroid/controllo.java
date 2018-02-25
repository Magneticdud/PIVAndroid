package it.dandandin.pivandroid;

import java.util.Random;

public class controllo {
    final static int VALID=0;
    final static int INVALID=1;
    final static int TOO_SHORT=2;
    final static int TOO_LONG=3;

    public int controllaPIVA(String PIVA) {
        if (PIVA.length()==11) {
            //lunghezza giusta
            int sommaCifreDispari=0;
            int sommaCifrePari=0;
            int totale = 0;
            int cifraDiControllo=0;
            for (int i = 0; i<=9; i=i+2) {
                sommaCifreDispari += Character.getNumericValue(PIVA.charAt(i));
            }
            for (int i = 1; i<=9; i=i+2) {
                int cifra = Character.getNumericValue(PIVA.charAt(i))*2;
                if (cifra>9) {
                    cifra = cifra-9;
                }
                sommaCifrePari+=cifra;
            }
            totale = sommaCifreDispari+sommaCifrePari;
            cifraDiControllo = (10-(totale%10))%10;
            if (cifraDiControllo==Character.getNumericValue(PIVA.charAt(10))) {
                return VALID;
            }
            else {
                return INVALID;
            }
        }
        else if (PIVA.length()<11) {
            return TOO_SHORT;
        }
        else {
            return TOO_LONG;
        }
    }

    public static int randInt() {
        int min = 0, max = 9;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
