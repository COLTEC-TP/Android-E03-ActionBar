package br.ufmg.coltec.tp.e04actionbar;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button botaoProximaActivity3 = findViewById(R.id.proximaActivity3);

        botaoProximaActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item = menu.findItem(R.id.procurar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String procurarTexto) {
                Toast.makeText(SecondActivity.this, "Procurar: " + procurarTexto, Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String procurarTexto) {
                return false;
            }
        });

        MenuItem shareItem = menu.findItem(R.id.compartilhar);
        ShareActionProvider shareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Compartilhar");
        shareProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.atualizar:
                Toast.makeText(SecondActivity.this,"Atualiar",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                AlertDialog.Builder mostrarDialogo = new AlertDialog.Builder(this);
                mostrarDialogo.setTitle("Sobre");
                mostrarDialogo.setMessage("Sobre o aplicativo: deu muito trabalho pra fazer poiso android studio nao colabora");
                AlertDialog alertarDialogo = mostrarDialogo.create();
                alertarDialogo.show();
                return true;
            case R.id.sair:
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}