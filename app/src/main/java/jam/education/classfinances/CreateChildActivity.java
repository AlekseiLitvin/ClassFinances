package jam.education.classfinances;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import jam.education.classfinances.model.Child;

public class CreateChildActivity extends AppCompatActivity {

    public static final String REGISTERED_CHILD = "registeredChild";
    public static final int SUCCESS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_child);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        final TextInputEditText firstName = findViewById(R.id.firstName);
        final TextInputEditText lastName = findViewById(R.id.lastName);

        Button saveChildButton = findViewById(R.id.save_child_button);
        saveChildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Child testChild = new Child(firstName.getText().toString() + " " + lastName.getText().toString());
                Intent data = new Intent();
                data.putExtra(REGISTERED_CHILD, testChild);
                setResult(SUCCESS, data);
                finish();
            }
        });
    }


}
