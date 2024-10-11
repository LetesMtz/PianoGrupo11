package sv.edu.catolica.pianogrupo11;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton ButtonDrawerToggle,ButtonDrawerToggle1,ButtonDrawerToggle2,ButtonDrawerToggle3,ButtonDrawerToggle4,ButtonDrawerToggle5,ButtonDrawerToggle6;
    View dcorview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.dor);
        sonidore.start();
        Toast.makeText(this, "Do", Toast.LENGTH_SHORT).show();
    }

    private void notami() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.re);
        sonidore.start();
        Toast.makeText(this, "Re", Toast.LENGTH_SHORT).show();
    }

    private void notasi() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.mi);
        sonidore.start();
        Toast.makeText(this, "Mi", Toast.LENGTH_SHORT).show();
    }

    private void notala() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.fa);
        sonidore.start();
        Toast.makeText(this, "Fa", Toast.LENGTH_SHORT).show();
    }

    private void notafa() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.sol);
        sonidore.start();
        Toast.makeText(this, "So", Toast.LENGTH_SHORT).show();
    }

    private void notare() {

        MediaPlayer sonidore = MediaPlayer.create(this,R.raw.la);
        sonidore.start();
        Toast.makeText(this, "La", Toast.LENGTH_SHORT).show();
    }

    private void notado() {

        MediaPlayer sonidoDo = MediaPlayer.create(this,R.raw.si);
        sonidoDo.start();
        Toast.makeText(this, "Si", Toast.LENGTH_SHORT).show();
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

        if(id == R.id.cambiarPiano){
            opcionesPianos();
        } else if (id == R.id.acerca_de_nosotros){
            Intent selva = new Intent(MainActivity.this, AcercaDeNosotros.class);
            startActivity(selva);
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
                        Toast.makeText(MainActivity.this, "Seleccionaste: " + selectedOption, Toast.LENGTH_SHORT).show();

                        if (selectedOption.equals("Piano Infantil de la Selva")) {
                            Intent selva = new Intent(MainActivity.this, PianoInfantilSelva.class);
                            startActivity(selva);
                        } else if (selectedOption.equals("Piano de Instrumentos Musicales")) {
                            Intent inst = new Intent(MainActivity.this, PianoInstrumentosMusicales.class);
                            startActivity(inst);
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
}