package com.example.brincandocominteiros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Declara os objetos.
    private TextView txtGerado;
    private EditText edtTransfere;
    private TextView txtParidade;
    private TextView txtPrimo;
    private TextView txtDivisores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Estabelece o vínculo.
        txtGerado = findViewById(R.id.txtGerado);
        edtTransfere = findViewById(R.id.edtTransfere);
        txtParidade = findViewById(R.id.txtParidade);
        txtPrimo = findViewById(R.id.txtPrimo);
        txtDivisores = findViewById(R.id.txtDivisores);
    }

    @Override
    //Método sobre-escrito, usamos o polimorfismo dinâmico.
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState); //chamando o sobrescrito.

        //Salva os estados atuais de cada ID.
        savedInstanceState.putString("gerado", txtGerado.getText().toString());
        savedInstanceState.putString("paridade", txtParidade.getText().toString());
        savedInstanceState.putString("primo", txtPrimo.getText().toString());
        savedInstanceState.putString("divisores", txtDivisores.getText().toString());

    }

    //Override --> automatiza.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView txt;
        String s;

        //Usamos a chave para restaurar o estado salvo.
        s = savedInstanceState.getString("gerado");
        txt = findViewById(R.id.txtGerado);
        txt.setText(s);

        s = savedInstanceState.getString("paridade");
        txt = findViewById(R.id.txtParidade);
        txt.setText(s);

        s = savedInstanceState.getString("primo");
        txt = findViewById(R.id.txtPrimo);
        txt.setText(s);

        s = savedInstanceState.getString("divisores");
        txt = findViewById(R.id.txtDivisores);
        txt.setText(s);
    }

    public void btnGerarOnClick (View view) {
        Random rnd = new Random();
        int valor = rnd.nextInt(100000);

        //Formata o valor para String e Inteiro.
        txtGerado.setText(String.format("%d", valor));
    }

    public void btnTransferirOnClick (View view) {
        String s = txtGerado.getText().toString();
        edtTransfere.setText(s);
    }

    public void btnParidadeOnClick (View view) {
        String s = edtTransfere.getText().toString();
        int valor = Integer.parseInt(s);

        try {
            if (valor % 2 == 0)
                txtParidade.setText(String.format("%d é Par", valor));
            else
                txtParidade.setText(String.format("%d é Impar", valor));
        }
        catch (Exception e) {
            Toast.makeText(this, "É necessário fornecer um número inteiro", Toast.LENGTH_LONG).show();
        }
    }

    public void btnPrimoOnClick (View view){
        String s = edtTransfere.getText().toString();
        int valor = Integer.parseInt(s);

        try {
            if (ePrimo(valor))
                txtPrimo.setText(String.format("%d é Primo", valor));
            else
                txtPrimo.setText(String.format("%d não é Primo", valor));
        }
        catch (Exception e) {
            Toast.makeText(this, "É necessário fornecer um número inteiro", Toast.LENGTH_LONG).show();
        }
    }

    //Função que só funciona dentro dessa Activity.
    private boolean ePrimo(int x) {
        int i;
        int r = 1;
        double raiz;
        if (x == 2)
            return true;
        else if (x % 2 == 0)
            return false;
        else {
            raiz = Math.sqrt(x);
            i = 3;
            while (i <= raiz && r != 0) {
                r = x % i;
                i += 2;
            }
            return r != 0;
        }
    }

    //Exposição dos divisores.
    public void txtDivisoresOnClick (View view) {
        String s = edtTransfere.getText().toString();
        try {
            int valor = Integer.parseInt(s);
            s = produzDivisores(valor);
            txtDivisores.setText(s);
            txtDivisores.setMovementMethod(new ScrollingMovementMethod());
            txtDivisores.scrollTo(0,0);
        }
        catch (Exception e){
            Toast.makeText(this, "É necessário fornecer um número inteiro", Toast.LENGTH_SHORT).show();
        }
    }

    //Calcula os divisores do número.
    private String produzDivisores(int valor) {
        int i;
        double fim;
        String s = "";
        fim = valor / 2;
        i = 2;
        while (i <= fim ) {
            if (valor % i == 0)
                s = s + i + "\n";
            i++;
        }
        return (s);
    }

    public void btnLimpaOnClick (View view) {

        txtGerado.setText("");
        txtParidade.setText("");
        txtPrimo.setText("");
        txtDivisores.setText("");
        edtTransfere.setText("");

      /*
        TextView v;
        v = findViewById(R.id.txtGerado);
        v.setText("");
        v = findViewById(R.id.txtParidade);
        v.setText("");
        v = findViewById(R.id.txtPrimo);
        v.setText("");
        v = findViewById(R.id.txtDivisores);
        v.setText("");
        v = findViewById(R.id.edtTransfere);
        v.setText(""); */
    }

}