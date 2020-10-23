package mx.unam.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {


    private TextView textFechaNacimiento;
    private TextView textNombre;
    private TextView textTelefono;
    private TextView textEmail;
    private TextView textDescContacto;
    private Button miBotonSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textFechaNacimiento =(TextView) findViewById(R.id.tvFxNacimientoEdit);
        textNombre =(TextView) findViewById(R.id.tvNombreEdit);
        textTelefono =(TextView) findViewById(R.id.tvTelefonoEdit);
        textEmail =(TextView) findViewById(R.id.tvEmailEdit);
        textDescContacto =(TextView) findViewById(R.id.tvDescContactoEdit);
        miBotonSiguiente = (Button)findViewById(R.id.miBotonEditDatos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.NOMBRE));
        String fxNacimiento = parametros.getString(getResources().getString(R.string.FXNACIMIENTO));
        String telefono = parametros.getString(getResources().getString(R.string.TELEFONO));
        String email = parametros.getString(getResources().getString(R.string.EMAIL));
        String descContacto = parametros.getString(getResources().getString(R.string.DESC_CONTACTO));

        textNombre.setText(nombre);
        textFechaNacimiento.setText(fxNacimiento);
        textTelefono.setText(telefono);
        textEmail.setText(email);
        textDescContacto.setText(descContacto);

        miBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.NOMBRE), textNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.FXNACIMIENTO),textFechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.TELEFONO),textTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.EMAIL),textEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.DESC_CONTACTO),textDescContacto.getText().toString());
                startActivity(intent);
                finish();
            }
        });

    }
}