package com.example.ali_j.voc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.db = new DatabaseHandler(this);
        db.create();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.Search:
                Intent intent = new Intent(this, SearchActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public void InsertNewWord(View view) {
        EditText azeText=(EditText)findViewById(R.id.aze);
        EditText engText=(EditText)findViewById(R.id.eng);
        this.db.insert(azeText.getText().toString(),engText.getText().toString());

        Toast.makeText(this, "Item added",
                Toast.LENGTH_LONG).show();
        azeText.setText("");
        engText.setText("");
    }


}
