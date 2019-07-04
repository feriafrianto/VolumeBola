package com.pens.volumebola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtJari;
    Button btnHitung;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJari = findViewById(R.id.txt_jari_jari);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);

        btnHitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hitung){
            String inputJariJari = txtJari.getText().toString().trim();

            boolean isEmptyField = false;

            if (TextUtils.isEmpty(inputJariJari)){
                isEmptyField = true;
                txtJari.setError(getString(R.string.txt_field_kosong));
            }

            Double Jari_Jari = Double.valueOf(inputJariJari);

            if (!isEmptyField){
                double pangkat = Math.pow(Jari_Jari,3);
                double hasil = 4.0 / 3.0 * Math.PI * pangkat;
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                tvHasil.setText(numberFormat.format(hasil));
            }
        }
    }
}
