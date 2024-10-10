package sv.edu.catolica.pianogrupo11;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PianoInfantilSelva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piano_infantil_selva);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.piano_instrumentos){
            Intent pantalla = new Intent(PianoInfantilSelva.this, PianoInstrumentosMusicales.class);
            startActivity(pantalla);
            finish();
        }else if(id == R.id.piano_tradicional){
            Intent pantalla = new Intent(PianoInfantilSelva.this, MainActivity.class);
            startActivity(pantalla);
            finish();
        } else if (id == R.id.acerca_de_nosotros){
            Intent pantalla = new Intent(PianoInfantilSelva.this, AcercaDeNosotros.class);
            startActivity(pantalla);
            finish();
        }

        return true;
    }
}