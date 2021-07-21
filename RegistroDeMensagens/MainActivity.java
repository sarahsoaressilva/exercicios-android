package com.example.registrodemensagens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ArrayList de Strings.
    private ArrayList<String> strRegistro;
    private EditText edtMensagem;
    private TextView txtRegistros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById é criado nesta classe.
        //Ele é executado uma vez só para toda activity.
        //Pode ser usado por todos os elementos.
        edtMensagem = findViewById(R.id.edtMensagem);
        txtRegistros = findViewById(R.id.txtRegistros);
        strRegistro = new ArrayList<>(); //construção do objeto.

        //Dentro do parametro --> objeto da classe (lateral, vertical e etc)
        txtRegistros.setMovementMethod(new ScrollingMovementMethod());
    }

    //Parametro da classe (View) + nome da classe (view);
    public void btnRegistraOnClick (View view) {
        String msg;

        //Converte o texto para mensagem.
        msg = edtMensagem.getText().toString();

        //Se a msg não estiver vazia.
        if (msg != null && !msg.isEmpty() ) {
            strRegistro.add(msg);
            edtMensagem.setText("");

            //Exibe o texto na caixa.
            exibeRegistro();

        } else {
            Toast.makeText(this, "O campo está vazio!", Toast.LENGTH_LONG).show();
        }

    }

    private void exibeRegistro() {
        int i;
        String s = "";

        //O valor de i fica armazenado.
        for (i = 0; i < strRegistro.size(); i++)
            s = s + " [ " + (i+1) + " ]: " + strRegistro.get(i) + "\n";
        txtRegistros.setText(s);
    }
}