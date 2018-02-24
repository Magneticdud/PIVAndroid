package it.dandandin.pivandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //piva di fastweb, presa a caso
    final static String PIVADemo = "12878470157";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView scritta = (TextView) findViewById(R.id.testo);
        scritta.setText(controllaPIVA(PIVADemo));
    }

    protected String controllaPIVA(String PIVA) {
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
                return "la partita IVA hardcoded è corretta";
            }
            else {
                return "partita IVA hardcoded non corretta";
            }
        }
        else {
            //lunghezza non valida
            return "lunghezza invalida";
        }
    }
}
