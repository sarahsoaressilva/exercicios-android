package com.example.conversordemedidas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtValorUm;
    EditText edtValorDois;
    Spinner spnOpcoes;
    Button btnConverte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValorUm = findViewById(R.id.edtValorUm);
        edtValorDois = findViewById(R.id.edtValorDois);
        spnOpcoes = findViewById(R.id.spnOpcoes);
        btnConverte = findViewById(R.id.btnConverte);
    }

    public void btnConverteOnClick (View view) {
        //Converte o valor em String.
        String a = edtValorUm.getText().toString();
        double n = Double.parseDouble(a);

        if (spnOpcoes.getSelectedItemPosition() == 0)
            edtValorDois.setText(String.format("%.2f", PolegadaParaCm(n)));
        else if (spnOpcoes.getSelectedItemPosition() == 1)
            edtValorDois.setText(String.format("%.2f", CmParaPolegada(n)));
        else if (spnOpcoes.getSelectedItemPosition() == 2)
            edtValorDois.setText(String.format("%.3f", pesParaMetros(n)));
        else if (spnOpcoes.getSelectedItemPosition() == 3)
            edtValorDois.setText(String.format("%.3f", metrosParaPes(n)));
        else if (spnOpcoes.getSelectedItemPosition() == 4)
            edtValorDois.setText(String.format("%.3f", milhaPorKm(n)));
        else if (spnOpcoes.getSelectedItemPosition() == 5)
            edtValorDois.setText(String.format("%.3f", kmPorMilha(n)));
        else if (spnOpcoes.getSelectedItemPosition() == 6)
            edtValorDois.setText(String.format("%1f", farenParaCelcius(n)));
        else if (spnOpcoes.getSelectedItemPosition() == 7)
            edtValorDois.setText(String.format("%.1f", celsiusParaFaren(n)));
        else if (spnOpcoes.getSelectedItemPosition() == 8)
            edtValorDois.setText(String.format("%.1f", nosParaKm(n)));
        else if (spnOpcoes.getSelectedItemPosition() == 9)
            edtValorDois.setText(String.format("%.3f", kmParaNo(n)));

    }

    public void btnLimpaOnClick (View view) {
        edtValorDois.setText("");
        edtValorUm.setText("");
    }

    //Conversão de Polegada para Cm.
    public double PolegadaParaCm (double n) {
        double calc = n * 2.54;
        return (calc);
    }

    public double CmParaPolegada (double n) {
        double calc = n / 2.54;
        return (calc);
    }

    public double pesParaMetros (double n) {
        double calc = n / 3.281;
        return (calc);
    }

    public double metrosParaPes (double n) {
        double calc = n * 3.281;
        return (calc);
    }

    public double milhaPorKm (double n) {
        double calc = n * 1.609;
        return (calc);
    }

    public double kmPorMilha (double n) {
        double calc = n / 1.609;
        return (calc);
    }

    public double farenParaCelcius (double n) {
        double calc = ( (n - 32) * 5) / 9;
        return (calc);
    }

    public double celsiusParaFaren (double n) {
        double calc = ( (n*9) / 5) + 32;
        return (calc);
    }

    public double nosParaKm (double n) {
        double calc = n * 1.852;
        return (calc);
    }

    public double kmParaNo (double n) {
        double calc = n / 1.852;
        return (calc);
    }

}
