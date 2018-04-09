package br.ufmg.coltec.tp.e04actionbar;



import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.ShareActionProvider;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;



import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // infla menu na tela
        getMenuInflater().inflate(R.menu.menu_layout, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(ThirdActivity.this, "Buscar o texto: " + s, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // executado enquanto texto é alterado pelo usuário
                return false;
            }
        });

        // recupera share provider
        MenuItem share = menu.findItem(R.id.action_share);

        // Fetch and store ShareActionProvider
        ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(share);

        // criar intent que será exibida pelo provider
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Compartilhar :)");

        // exibe a intent
        mShareActionProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // recupera id do item selecionado
        int id = item.getItemId();

        // verifica qual é o botão selecionado com base no id
        switch (id) {
            case R.id.config:
                Toast.makeText(this, "Clicou no Configurações", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_refresh:
                Toast.makeText(this, "Clicou no Atualizar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_share:
                Toast.makeText(this, "Clicou no Share", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Toast.makeText(this, "Clicou no About", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(ThirdActivity.this);
                alertBuilder.setTitle("Informções do APP");
                alertBuilder.setMessage("Desenvolvido Por: Mathias Oliveira\nDesigned in California");

                AlertDialog dialog = alertBuilder.create();
                dialog.show();
                return true;
            case R.id.sair:
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

