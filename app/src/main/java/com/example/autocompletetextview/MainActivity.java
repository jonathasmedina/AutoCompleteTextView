package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    AutoCompleteTextView autoCompleteTextView_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView1);

        //AutoCompleteTextView
        autoCompleteTextView_ = findViewById(R.id.autoCompleteTextView);
        String[] paises = getResources().getStringArray(R.array.paises_array);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        autoCompleteTextView_.setAdapter(adapter);


        //ação no autoComplete e detectar item
        autoCompleteTextView_.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv1.setText(adapter.getItem(i));
            }
        });

    }
}