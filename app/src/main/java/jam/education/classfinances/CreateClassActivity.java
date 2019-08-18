package jam.education.classfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class CreateClassActivity extends AppCompatActivity {

    public static final String CLASS_MODEL_NAME = "classModelName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);

        EditText editText = findViewById(R.id.class_name);
        String className = editText.getText().toString();

        Intent intent = new Intent(this, ChildsListActivity.class);
        intent.putExtra(CLASS_MODEL_NAME, className);
        startActivity(intent);

    }
}
