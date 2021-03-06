package com.example.wylosujlotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/********************************************************
 * nazwa klasy: MainActivity
 * parametry wejściowe: brak
 * wartość zwracana: brak
 * autor: 45678901234
 * ****************************************************/
public class MainActivity extends AppCompatActivity {

    /********************************************************
     * nazwa funkcji: onCreate
     * parametry wejściowe: savedInstanceState - prametr uruchomieniowy
     * wartość zwracana: brak
     * opis: główna funkcja uruchomieniowa
     * autor: 45678901234
     * ****************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /********************************************************
     * nazwa funkcji: wylosuj
     * parametry wejściowe: view - widok, na którym wykonywana jest obsługa zdarzenia
     * wartość zwracana: brak
     * opis: obsługa naciśnięcia przycisku Wylosuj
     * autor: 45678901234
     * ****************************************************/

    public void wylosuj(View view) {
        String komunikatStr = "";

        EditText liczbaKul = (EditText) findViewById(R.id.liczbaKul);
        String liczbaKulStr = liczbaKul.getText().toString();
        int liczbaKulInt = 0;
        if(liczbaKulStr.length()==0){
            komunikatStr += "Liczba kul jest wymagana. ";
        } else {
           liczbaKulInt = Integer.parseInt(liczbaKulStr);
        }

        EditText liczbaLosowanych = (EditText) findViewById(R.id.liczbaLosowanych);
        String liczbaLosowanychStr = liczbaLosowanych.getText().toString();
        int liczbaLosowanychInt = 0;
        if(liczbaLosowanychStr.length()==0){
            komunikatStr += "Liczba losowanych jest wymagana. ";
        } else{
            liczbaLosowanychInt = Integer.parseInt(liczbaLosowanychStr);
        }

        if(liczbaLosowanychInt > liczbaKulInt){
            komunikatStr += "Liczba kul musi być większa od liczby losowanych. ";
        }

        if(komunikatStr.length()==0) {
            int[] wynikLosowania = new int[liczbaLosowanychInt];
            for(int i = 0; i<liczbaLosowanychInt; i++){
                int wylosowana = 0;
                boolean jestPowotorzony;
                do {
                    jestPowotorzony = false;
                    wylosowana = (int) (Math.random() * liczbaKulInt + 1);
                    for(int j=0; j<i; j++){
                        if(wylosowana==wynikLosowania[j]){
                            jestPowotorzony = true;
                        }
                    }

                } while(jestPowotorzony);
                wynikLosowania[i] = wylosowana;
            }
            komunikatStr = "Wynik losowania: ";
            for(int i = 0; i<liczbaLosowanychInt; i++){
                komunikatStr +=  wynikLosowania[i] + ", ";
            }
        }

        TextView komunikat = (TextView) findViewById(R.id.komunikt);
        komunikat.setText(komunikatStr);
    }
}