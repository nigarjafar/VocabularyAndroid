package com.example.ali_j.voc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        this.db = new DatabaseHandler(this);


    }

    public void SearchForWord(View view) {
        Log.e("log","searchfor");
        EditText word=(EditText)findViewById(R.id.word);
        Toast.makeText(this, this.db.readItem(word.getText().toString()),
                Toast.LENGTH_LONG).show();
        word.setText("");
    }
}
