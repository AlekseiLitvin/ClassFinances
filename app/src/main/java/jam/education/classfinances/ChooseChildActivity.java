package jam.education.classfinances;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import jam.education.classfinances.model.Child;

public class ChooseChildActivity extends AppCompatActivity {

    public static final String CHILD_NAME = "childName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_child);

        ArrayList<Child> childrenList = getIntent().getParcelableArrayListExtra(ChildsListActivity.ALL_CHILDREN);
        ArrayList<String> childrenNames = new ArrayList<>();
        for (Child child : childrenList) {
            childrenNames.add(child.getName());
        }
        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, childrenNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button confirmButton = findViewById(R.id.chose_child_confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String childName = spinner.getSelectedItem().toString();
                Intent intent = new Intent(ChooseChildActivity.this, ChildDetailActivity.class);
                intent.putExtra(CHILD_NAME, childName);
                startActivity(intent);
            }
        });

    }
}
