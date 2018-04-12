package br.ufmg.coltec.tp.e04actionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_tela1 = findViewById(R.id.btn_tela1);
        Button btn_tela2 = findViewById(R.id.btn_tela2);

        btn_tela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_tela1 = new Intent(MainActivity.this, Tela1Activity.class);
                startActivity(intent_tela1);
            }
        });

        btn_tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_tela2 = new Intent(MainActivity.this, Tela2Activity.class);
                startActivity(intent_tela2);
            }
        });
    }
}
