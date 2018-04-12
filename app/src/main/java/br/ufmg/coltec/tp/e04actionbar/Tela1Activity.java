package br.ufmg.coltec.tp.e04actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.widget.Toast;

public class Tela1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button btn2_tela2 = findViewById(R.id.btn2_tela2);

        btn2_tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_tela2 = new Intent(Tela1Activity.this, Tela2Activity.class);
                startActivity(intent_tela2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(Tela1Activity.this, "Buscar: "+ s, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        MenuItem shareItem = menu.findItem(R.id.action_share);
       ShareActionProvider shareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "E04 Action Bar\nDesenvolvedor: Willian\nVersão 1.0");

        shareProvider.setShareIntent(intent);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Tela1Activity.this);

        switch (id){
            case R.id.action_update:
                Toast.makeText(this, "Clicou no Atualizar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_info:

                alertBuilder.setTitle("Sobre");
                alertBuilder.setMessage("Desenvolvedor: Willian \n Versão 1.0");

                AlertDialog dialog = alertBuilder.create();
                dialog.show();
                return true;

            case R.id.action_leave:
                this.finishAffinity();
            return true;

            default:
                return super.onOptionsItemSelected(item);
        }

        }
    }
