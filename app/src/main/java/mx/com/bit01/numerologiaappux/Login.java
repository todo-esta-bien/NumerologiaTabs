package mx.com.bit01.numerologiaappux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {

    @BindView(R.id.etNombre)
    EditText etNombre;

    @BindView(R.id.etApellido)
    EditText etApellido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.fab)
    public void goToTabbedNumbers(){

        if(checarDatos()){

            Intent intent = new Intent(Login.this, TabbedActivity.class);
            intent.putExtra(Constants.TAG_NOMBRE, etNombre.getText().toString());
            intent.putExtra(Constants.TAG_APELLIDO, etApellido.getText().toString());
            startActivity(intent);

        }

    }

    public boolean checarDatos(){

        if(!etNombre.getText().toString().isEmpty() &&
                !etApellido.getText().toString().isEmpty()){

            return true;

        }

        Toast.makeText(Login.this, getString(R.string.errorDatosLogin),Toast.LENGTH_LONG).show();
        return false;

    }

}
