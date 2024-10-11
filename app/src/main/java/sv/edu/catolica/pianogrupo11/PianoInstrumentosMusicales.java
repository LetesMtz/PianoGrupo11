package sv.edu.catolica.pianogrupo11;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PianoInstrumentosMusicales extends AppCompatActivity {

    ImageButton ButtonDrawerToggle,ButtonDrawerToggle1,ButtonDrawerToggle2,ButtonDrawerToggle3,ButtonDrawerToggle4,ButtonDrawerToggle5,ButtonDrawerToggle6;

    View dcorview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piano_instrumentos_musicales);
        dcorview = findViewById(R.id.main);
        dcorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void sonidoBombo() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.dor);

        sonidore.start();
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

        if(id == R.id.piano_selva){
            Intent pantalla = new Intent(PianoInstrumentosMusicales.this, PianoInfantilSelva.class);
            startActivity(pantalla);
            finish();
        }else if(id == R.id.piano_tradicional){
            Intent pantalla = new Intent(PianoInstrumentosMusicales.this, MainActivity.class);
            startActivity(pantalla);
            finish();
        } else if (id == R.id.acerca_de_nosotros){
            Intent pantalla = new Intent(PianoInstrumentosMusicales.this, AcercaDeNosotros.class);
            startActivity(pantalla);
            finish();
        }

        return true;
    }

    public void sonidoBombo(View view) {
        MediaPlayer sonido = MediaPlayer.create(this,R.raw.bombo);
        sonido.start();
    }
}



