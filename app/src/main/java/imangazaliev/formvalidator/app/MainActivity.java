package imangazaliev.formvalidator.app;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import imangazaliev.formvalidator.FieldValidator;
import imangazaliev.formvalidator.FormValidator;
import imangazaliev.formvalidator.ValidatePattern;

public class MainActivity extends AppCompatActivity {

    EditText mLoginField;
    TextInputLayout mLoginInputLayout;

    private FormValidator mValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginField = (EditText) findViewById(R.id.loginField);
        mLoginInputLayout = (TextInputLayout) findViewById(R.id.loginInputLayout);

        FieldValidator loginFieldValidator = new FieldValidator(mLoginField, mLoginInputLayout);
        loginFieldValidator.addPattern(new ValidatePattern(".+", "Поле не может быть пустым"));
        loginFieldValidator.addPattern(new ValidatePattern("[A-Za-z]{5,10}", "Можно использовать только латиницу (5-10)"));

        mValidator = new FormValidator();
        mValidator.addField(loginFieldValidator);
    }

    public void checkForm(View v) {
        if (mValidator.validate()) {
            Toast.makeText(MainActivity.this, "Сохранено", Toast.LENGTH_SHORT).show();
        }

    }

}
