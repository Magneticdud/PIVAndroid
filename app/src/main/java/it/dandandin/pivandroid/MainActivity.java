package it.dandandin.pivandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static EditText editTextPIVA;
    static TextView scritta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scritta = (TextView) findViewById(R.id.testo);
        //scritta.setText(controllaPIVA(PIVADemo));
        editTextPIVA = (EditText)findViewById(R.id.editTextPIVA);
        editTextPIVA.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                scritta.setText(controllaPIVA(String.valueOf(editTextPIVA.getText())));
            }
        });
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
                return getResources().getString(R.string.valid);
            }
            else {
                return getResources().getString(R.string.not_valid);
            }
        }
        else if (PIVA.length()<11) {
            return getResources().getString(R.string.too_short);
        }
        else {
            return getResources().getString(R.string.too_long);
        }
    }
}
