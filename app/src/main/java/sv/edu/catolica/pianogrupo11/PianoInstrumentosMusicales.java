package sv.edu.catolica.pianogrupo11;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PianoInstrumentosMusicales extends AppCompatActivity {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.cambiarPiano){
            opcionesPianos();
        } else if (id == R.id.acerca_de_nosotros){
            Intent selva = new Intent(PianoInstrumentosMusicales.this, AcercaDeNosotros.class);
            startActivity(selva);
            finish();
        } else if (id == R.id.salir){
            finishAffinity();
        }

        return true;
    }

    private void opcionesPianos() {

        String[] options = {"Piano Tradicional", "Piano Infantil de la Selva", "Piano de Instrumentos Musicales"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una Opción")
                .setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int opc) {

                        String selectedOption = options[opc];
                        Toast.makeText(PianoInstrumentosMusicales.this, "Seleccionaste: " + selectedOption, Toast.LENGTH_SHORT).show();

                        if (selectedOption.equals("Piano Infantil de la Selva")) {
                            Intent selva = new Intent(PianoInstrumentosMusicales.this, PianoInfantilSelva.class);
                            startActivity(selva);
                            finish();
                        } else if (selectedOption.equals("Piano Tradicional")) {
                            Intent inst = new Intent(PianoInstrumentosMusicales.this, MainActivity.class);
                            startActivity(inst);
                            finish();
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Cerrar el diálogo
                    }
                });

        builder.create().show();
    }

    public void sonidoBombo(View view) {
        MediaPlayer sonido = MediaPlayer.create(this,R.raw.bombo);
        sonido.start();
        Toast.makeText(this, "Bombo", Toast.LENGTH_SHORT).show();
    }

    public void sonidoBongos(View view) {
        MediaPlayer sonido = MediaPlayer.create(this,R.raw.bongos);
        sonido.start();
        Toast.makeText(this, "Bongos", Toast.LENGTH_SHORT).show();
    }

    public void sonidoFlauta(View view) {
        MediaPlayer sonido = MediaPlayer.create(this,R.raw.flauta_dulce);
        sonido.start();
        Toast.makeText(this, "Flauta Dulce", Toast.LENGTH_SHORT).show();
    }

    public void sonidoGuitarra(View view) {
        MediaPlayer sonido = MediaPlayer.create(this,R.raw.guitarra);
        sonido.start();
        Toast.makeText(this, "Guitarra", Toast.LENGTH_SHORT).show();
    }

    public void sonidoTambor(View view) {
        MediaPlayer sonido = MediaPlayer.create(this,R.raw.tambor);
        sonido.start();
        Toast.makeText(this, "Tambor", Toast.LENGTH_SHORT).show();
    }

    public void sonidoTrompeta(View view) {
        MediaPlayer sonido = MediaPlayer.create(this,R.raw.trompeta);
        sonido.start();
        Toast.makeText(this, "Trompeta", Toast.LENGTH_SHORT).show();
    }

    public void sonidoXilofono(View view) {
        MediaPlayer sonido = MediaPlayer.create(this,R.raw.xilofono);
        sonido.start();
        Toast.makeText(this, "Xilófono", Toast.LENGTH_SHORT).show();
    }
}



