package mx.unam.petagram;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerFechaNacimiento;
    private EditText textFechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textFechaNacimiento =(EditText) findViewById(R.id.editText1);
        textFechaNacimiento.setInputType(InputType.TYPE_NULL);

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
    }
}