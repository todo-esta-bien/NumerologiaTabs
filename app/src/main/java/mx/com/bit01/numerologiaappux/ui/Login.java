package mx.com.bit01.numerologiaappux.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mx.com.bit01.numerologiaappux.R;
import mx.com.bit01.numerologiaappux.models.Person;
import mx.com.bit01.numerologiaappux.utils.Constants;

public class Login extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener{

    DatePickerDialog dpd;

    @BindView(R.id.etNombre)
    EditText etNombre;

    @BindView(R.id.etApellido)
    EditText etApellido;

    @BindView(R.id.spinnerOpcionesFecha)
    Spinner spinner;

    @BindView(R.id.txtFecha)
    TextView txtFecha;

    @BindView(R.id.valFecha)
    TextView valFecha;

    @BindView(R.id.fechaManual)
    EditText etFechaManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //Inicia Configuración Date Picker Dialog
        Calendar now = Calendar.getInstance();
        dpd = DatePickerDialog.newInstance(
                Login.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        dpd.setVersion(DatePickerDialog.Version.VERSION_2);
        dpd.setYearRange(1,2100);
        //Termina Configuración Date Picker Dialog

        //Incia Configuración del Spinner
        spinner = (Spinner) findViewById(R.id.spinnerOpcionesFecha);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.opcionesSpinnerFecha,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);
        //Termina Configuración del Spinner

    }

    @OnClick(R.id.fab)
    public void goToTabbedNumbers(){

        if(checarDatosVacios()){

            if(etFechaManual.getVisibility() == View.VISIBLE){

                if(checarFecha(etFechaManual.getText().toString())){

                    goToTabbedAvtivity();

                }

            }else{

                goToTabbedAvtivity();

            }

        }

    }

    @OnClick(R.id.valFecha)
    public void selectDate(){

        dpd.show(getFragmentManager(), "Datepickerdialog");

    }

    public boolean checarDatosVacios(){

        if(!etNombre.getText().toString().isEmpty()){

            if(etFechaManual.getVisibility()==View.VISIBLE){

                if(!etFechaManual.getText().toString().isEmpty()){

                    return true;

                }else{

                    Toast.makeText(Login.this, getString(R.string.errorDatosLogin),Toast.LENGTH_LONG).show();
                    return false;

                }

            }else{

                if (valFecha.getText().toString().equals(getString(R.string.seleccionaFechaText))){

                    Toast.makeText(Login.this, getString(R.string.errorDatosLogin),Toast.LENGTH_LONG).show();
                    return false;

                }else{

                    return true;

                }


            }


        }

        Toast.makeText(Login.this, getString(R.string.errorDatosLogin),Toast.LENGTH_LONG).show();
        return false;

    }

    public boolean checarFecha(String string){


        String[] date = string.split("/");
        if(date.length==3 && Integer.parseInt(date[0])<=31 && Integer.parseInt(date[1])<=12 && Integer.parseInt(date[2])>=0){

            return true;

        }else{

            Toast.makeText(this, getString(R.string.errorFecha), Toast.LENGTH_SHORT).show();
            return false;

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        updateuiFecha(position);
    }

    public void goToTabbedAvtivity(){

        Intent intent = new Intent(Login.this, TabbedActivity.class);
        String mName = etNombre.getText().toString();
        String mLastName;
        String date[];

        if(!etApellido.getText().toString().isEmpty()){
            mLastName=etApellido.getText().toString();
        }else{
            mLastName=" ";
        }

        if(etFechaManual.getVisibility() == View.VISIBLE){

            date = etFechaManual.getText().toString().split("/");

        }else{

            date = valFecha.getText().toString().split("/");
        }

        int mDay = Integer.parseInt(date[0]);
        int mMonth = Integer.parseInt(date[1]);
        int mYear = Integer.parseInt(date[2]);
        Person person = new Person(mName,mLastName,mDay,mMonth,mYear);
        intent.putExtra(Constants.TAG_PERSON,person);
        startActivity(intent);

    }

    public void updateuiFecha(int value){
        ButterKnife.bind(this);

        switch (value){

            case 0:
                txtFecha.setVisibility(View.VISIBLE);
                valFecha.setVisibility(View.VISIBLE);
                etFechaManual.setVisibility(View.GONE);
                break;
            case 1:
                txtFecha.setVisibility(View.GONE);
                valFecha.setVisibility(View.GONE);
                etFechaManual.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        valFecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
    }
}
