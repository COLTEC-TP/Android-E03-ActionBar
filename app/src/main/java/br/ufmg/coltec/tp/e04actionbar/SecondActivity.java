package br.ufmg.coltec.tp.e04actionbar;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button botao = findViewById(R.id.botao2);
        final Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.item_atualizar:
                Toast.makeText(SecondActivity.this,"Atualizado",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_about:
                AlertDialog.Builder dialogoB = new AlertDialog.Builder(this);
                dialogoB.setTitle("Sobre");
                dialogoB.setMessage("Aplicativo que tem uma incrível ActionBar e que foi desenvolvido por Reinaldo, mais conhecido como kingnowdo");
                AlertDialog dialogo = dialogoB.create();
                dialogo.show();
                return true;
            case R.id.item_sair:
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
