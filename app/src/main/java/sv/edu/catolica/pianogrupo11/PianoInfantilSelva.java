package sv.edu.catolica.pianogrupo11;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PianoInfantilSelva extends AppCompatActivity {

    ImageButton ButtonDrawerToggle,ButtonDrawerToggle1,ButtonDrawerToggle2,ButtonDrawerToggle3,ButtonDrawerToggle4,ButtonDrawerToggle5,ButtonDrawerToggle6;

    View dcorview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piano_infantil_selva);
        dcorview = findViewById(R.id.main);
        dcorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ButtonDrawerToggle = findViewById(R.id.buttondrawertoggle2);
        ButtonDrawerToggle1 = findViewById(R.id.buttondrawertoggle1);
        ButtonDrawerToggle2 = findViewById(R.id.buttondrawertoggle3);
        ButtonDrawerToggle3 = findViewById(R.id.buttondrawertoggle4);
        ButtonDrawerToggle4 = findViewById(R.id.buttondrawertoggle5);
        ButtonDrawerToggle5 = findViewById(R.id.buttondrawertoggle6);
        ButtonDrawerToggle6 = findViewById(R.id.buttondrawertoggle7);

        ButtonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notado();
            }

        });

        ButtonDrawerToggle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notare();
            }
        });

        ButtonDrawerToggle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notami();
            }
        });

        ButtonDrawerToggle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notafa();
            }
        });

        ButtonDrawerToggle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notasol();
            }
        });

        ButtonDrawerToggle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notala();
            }
        });

        ButtonDrawerToggle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notasi();
            }
        });
    }

    private void notasol() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.cocodrilo);

        sonidore.start();
    }

    private void notami() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.mono);

        sonidore.start();
    }

    private void notasi() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.perro);

        sonidore.start();
    }

    private void notala() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.elefante);

        sonidore.start();
    }

    private void notafa() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.oso);

        sonidore.start();
    }

    private void notare() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.gallo);

        sonidore.start();
    }

    private void notado() {

        MediaPlayer sonidoDo = MediaPlayer.create(this,R.raw.leon);

        sonidoDo.start();
    };

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
            Intent pantalla = new Intent(PianoInfantilSelva.this, PianoInfantilSelva.class);
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



