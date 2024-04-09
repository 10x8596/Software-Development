package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list;
    Button button;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.URLtext);

        list = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);

        button.setOnClickListener(new View.OnClickListener() {
            /** Perform this action when button is pressed */
            @Override
            public void onClick(View v){
                String url = editText.getText().toString();
                list.add(url);
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ActivityWeb.class);
                if (list.get(position).isEmpty()){
                    Toast.makeText(MainActivity.this, "Invalid URL", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra("URL", list.get(position));
                    startActivity(intent);
                }
            }
        });
    }
}