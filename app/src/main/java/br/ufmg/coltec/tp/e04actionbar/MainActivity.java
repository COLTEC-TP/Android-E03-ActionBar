package br.ufmg.coltec.tp.e04actionbar;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button entrar = findViewById(R.id.Entrar);

        entrar.setOnClickListener(new View.OnClickListener() {

            @Override
        public void onClick(View view){

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);

        }
    });




    }
}
