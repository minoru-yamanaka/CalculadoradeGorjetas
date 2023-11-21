package com.example.imagem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Atribuir IDs
    private EditText editValor;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    // TextView = textPorcentagem
    private TextView textPorcentagem;

    // Criei uma variável = porcentagem
    private double porcentagem = 0;

    @SuppressLint("MissingInfLatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chamar IDs
        editValor = findViewById(R.id.editValor);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);  // Corrigi para textTotal
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);

        // Método onSeekBarChangeListener
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {




            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(porcentagem + "%");

                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Ações a serem executadas quando o usuário começa a interagir com o SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Ações a serem executadas quando o usuário para de interagir com o SeekBar
            }
        });
    }

    public void calcular() {
        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(getApplicationContext(), "Digite o valor da conta primeiro: ",
                    Toast.LENGTH_SHORT).show();
        } else {
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = valorDigitado + gorjeta;  // Corrigi para calcular o total corretamente
            textGorjeta.setText("R$ " + gorjeta);
            textTotal.setText("R$ " + total);  // Corrigi para exibir o total corretamente
        }
    }
}
