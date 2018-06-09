package marleedonnelly.se_assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get components
        final EditText passwordField = findViewById(R.id.passwordField);
        Button validate = findViewById(R.id.validate);
        final TextView resultText = findViewById(R.id.resultText);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordField.getText().toString();
                //Validate password
                Validator validator = new Validator();

                int result = validator.validate(password);
                if(result == validator.getNumRules()){
                    resultText.setText("Password is strong enough.");
                }
                else{
                    resultText.setText("Password is not strong enough.");
                }
            }
        });


    }
}
