package br.ufmg.coltec.tp.e04actionbar;


import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_second, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.action_refresh:
                Toast.makeText(SecondActivity.this, R.string.string_refresh, Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_about:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

                alertBuilder.setIcon(R.drawable.ic_launcher_foreground);
                alertBuilder.setTitle("Informações do aplicativo e desenvolvedor");
                alertBuilder.setMessage("Este é o aplicativo E04-ActionBar, desenvolvido por Frederico Teixeira Azevedo");

                alertBuilder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SecondActivity.this, "Saindo do Dialog", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = alertBuilder.create();
                dialog.show();
                return true;
            case R.id.action_exit:
                finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }
}