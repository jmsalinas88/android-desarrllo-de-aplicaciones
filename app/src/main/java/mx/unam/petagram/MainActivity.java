package mx.unam.petagram;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerFechaNacimiento;
    private EditText textFechaNacimiento;
    private TextInputEditText textNombre;
    private TextInputEditText textTelefono;
    private TextInputEditText textEmail;
    private EditText textDescContacto;
    private Button miBotonSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textFechaNacimiento =(EditText) findViewById(R.id.textFxNacimiento);
        textFechaNacimiento.setInputType(InputType.TYPE_NULL);
        textNombre =(TextInputEditText) findViewById(R.id.textNombre);
        textTelefono =(TextInputEditText) findViewById(R.id.textTelefono);
        textEmail =(TextInputEditText) findViewById(R.id.textEmail);
        textDescContacto =(TextInputEditText) findViewById(R.id.textDescContacto);
        miBotonSiguiente =(Button) findViewById(R.id.miBotonSiguiente);

        textFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH) + 1;
                int year = cldr.get(Calendar.YEAR);
                datePickerFechaNacimiento = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String dateStr = "";
                                if(dayOfMonth < 10){
                                    dateStr = "0" + dayOfMonth + "/" + monthOfYear + "/" + year;
                                }else{
                                    dateStr = dayOfMonth + "/" + monthOfYear + "/" + year;
                                }
                                textFechaNacimiento.setText(dateStr);
                            }
                        }, year, month, day);
                datePickerFechaNacimiento.show();
            }
        });

        textFechaNacimiento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    final Calendar cldr = Calendar.getInstance();
                    int day = cldr.get(Calendar.DAY_OF_MONTH);
                    int month = cldr.get(Calendar.MONTH) + 1;
                    int year = cldr.get(Calendar.YEAR);
                    datePickerFechaNacimiento = new DatePickerDialog(MainActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    String dateStr = "";
                                    if(dayOfMonth < 10){
                                        dateStr = "0" + dayOfMonth + "/" + monthOfYear + "/" + year;
                                    }else{
                                        dateStr = dayOfMonth + "/" + monthOfYear + "/" + year;
                                    }
                                    textFechaNacimiento.setText(dateStr);
                                }
                            }, year, month, day);
                    datePickerFechaNacimiento.show();
                }
            }
        });

        miBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
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

    @Override
    protected void onResume() {

        super.onResume();

        Bundle parametros = getIntent().getExtras();
        if(parametros != null){
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
        }
    }
}