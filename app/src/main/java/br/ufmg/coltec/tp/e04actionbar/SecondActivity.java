package br.ufmg.coltec.tp.e04actionbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
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

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button btnThird = findViewById(R.id.btnThird);

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_second, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        MenuItem shareItem = menu.findItem(R.id.action_share);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SecondActivity.this, "Buscar pelo termo " + query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        ShareActionProvider shareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
//
//        Uri uri = Uri.parse("br.ufmg.coltec.tp.e04actionbar");
//        Intent share = new Intent (Intent.ACTION_VIEW, uri);
//        share.setPackage("com.whatsapp");
//        shareProvider.setShareIntent(share);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setPackage("com.whatsapp");
        intent.setType("text/*");
        intent.putExtra(intent.EXTRA_TEXT, "br.ufmg.coltec.tp.e04actionbar");
        shareProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_refresh:
                Toast.makeText(SecondActivity.this, "Atualizando a tela", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Sobre nós");
                builder.setMessage("Aplicativo criado por Douglas Coelho");
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;

            case R.id.action_logout:
                finishAffinity();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
