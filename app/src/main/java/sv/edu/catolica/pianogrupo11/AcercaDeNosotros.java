package sv.edu.catolica.pianogrupo11;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AcercaDeNosotros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acerca_de_nosotros);
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
//            Intent selva = new Intent(AcercaDeNosotros.this, AcercaDeNosotros.class);
//            startActivity(selva);
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
                        Toast.makeText(AcercaDeNosotros.this, "Seleccionaste: " + selectedOption, Toast.LENGTH_SHORT).show();

                        if (selectedOption.equals("Piano Infantil de la Selva")) {
                            Intent selva = new Intent(AcercaDeNosotros.this, PianoInfantilSelva.class);
                            startActivity(selva);
                            finish();
                        } else if (selectedOption.equals("Piano Tradicional")) {
                            Intent inst = new Intent(AcercaDeNosotros.this, MainActivity.class);
                            startActivity(inst);
                            finish();
                        } else if (selectedOption.equals("Piano de Instrumentos Musicales")) {
                            Intent inst = new Intent(AcercaDeNosotros.this, PianoInstrumentosMusicales.class);
                            startActivity(inst);
                            finish();
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }
}