package com.example.boasvindastarde;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

// Estrutura básica.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // sabe que vai trabalhar com o activity.
    }

    // classe View = parâmetro.
    // Alt + Enter = import.
    // Manipulador de Eventos = nome do método.
    // Nome do btn+Evento

    public void btnExibeMsgOnClick(View view) {
        int nMsg;
        String nome = "FATEC-SP";
        Random rnd = new Random();
        nMsg = rnd.nextInt(5); //Podemos sobrecarregar ou deixar vazio.
        //Precisa ser numeros inteiros.

        TextView txtMensagem; //cria o objeto.
        txtMensagem = findViewById(R.id.txtMensagem); //R = resource, id = tipo que queremos.

        if (nMsg == 0) {
            txtMensagem.setText("Seja bem vinde, estudantes!"); //setters.
            txtMensagem.setBackgroundColor(Color.rgb(94, 67,191 )); //pegar uma cor pelo id.
        }
        else if (nMsg == 1) {
            txtMensagem.setText("A faculdade abre muitas portas.");
            txtMensagem.setTextColor(0xFF000000);
        }
        else if (nMsg == 2) {
            txtMensagem.setText("Não esqueça de se cuidar também.");
            txtMensagem.setTextColor(0xFFFFFFFF);
        }
        else if (nMsg == 3) {
            txtMensagem.setText("Você está estudando na " + nome);
        }
        else if (nMsg == 4)
            txtMensagem.setText("Você irá se formar na " + nome);
    }

    public void btnLimpaMsgOnClick (View view) {
        TextView txtMensagem = findViewById(R.id.txtMensagem);
        txtMensagem.setBackgroundColor(Color.rgb(33,150,243));
        txtMensagem.setText("...");
        Toast.makeText(this, "O campo mensagem foi limpo!", Toast.LENGTH_LONG).show();
    }

}