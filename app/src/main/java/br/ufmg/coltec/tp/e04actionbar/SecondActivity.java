package br.ufmg.coltec.tp.e04actionbar;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // infla menu na tela
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(SecondActivity.this, "Buscar o texto: " + s, Toast.LENGTH_SHORT).show();
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
            case R.id.action_refresh:
                Toast.makeText(this, "Clicou no refersh", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_about:
            // 1. Instantiate an AlertDialog.Builder with its constructor
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            // 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage("About")
                    .setTitle("ABOUT");

            builder.setNeutralButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            // 3. Get the AlertDialog from create()
            AlertDialog dialog = builder.create();

            dialog.show();
            return true;

            case R.id.action_logOut:
                finishAffinity();

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
