package br.ufmg.coltec.tp.e04actionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.SearchView;
import android.support.v4.view.MenuItemCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSecondActivity = findViewById(R.id.activity2_btn);

        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(MainActivity.this, "Buscar o texto: " + s, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // executado enquanto texto é alterado pelo usuário
                return false;
            }
        });

        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider shareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        // criar intent que será exibida pelo provider
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Texto para Compartilhar");

        // exibe a intent
        shareProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.update_view:
                Toast.makeText(this, "Clicou no refresh", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_exit:
                finishAndRemoveTask();
                return true;
            case R.id.action_about:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setTitle("Informações!");
                alertBuilder.setMessage("Aplicativo - " + getResources().getString(R.string.app_name) + "\nDesenvolvedor: Germano Barcelos\n");

                alertBuilder.setPositiveButton("Estou ciente!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(), "Fique por sua conta e risco", Toast.LENGTH_LONG).show();
                    }
                });


                AlertDialog dialog = alertBuilder.create();
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
