package br.ufmg.coltec.tp.e04actionbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button TerceiraTela = findViewById(R.id.botao2);

        TerceiraTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(SecondActivity.this,"Buscar o texto: " + s, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

//        MenuItem shareItem = menu.findItem(R.id.action_share);
//        ShareActionProvider shareProvider = (ShareActionProvider) shareItem.getActionProvider();
//
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/*");
//        intent.putExtra(intent.EXTRA_TEXT, "Text to share");
//
//        shareProvider.setShareIntent(intent);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id){
            case R.id.action_refresh:
                Toast.makeText(this,"Clicked refresh", Toast.LENGTH_SHORT).show();
            case R.id.action_about:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setTitle("About the app");
                alertBuilder.setMessage("App -> " + getResources().getString(R.string.app_name)+"\nBy: Mariana Santos\n");

                alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),"Thak you!", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = alertBuilder.create();
                dialog.show();
                return true;
            case R.id.action_exit:
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
