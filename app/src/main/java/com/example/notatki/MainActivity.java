package com.example.notatki;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button dodajButton;
    private EditText tytulEdit;
    private EditText trescEdit;
    private ListView lista;

    private  ArrayList<String> notatki = new ArrayList<String>();
    private ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dodajButton = findViewById(R.id.dodaj);
        tytulEdit = findViewById(R.id.tytul);
        trescEdit = findViewById(R.id.tresc);
        lista = findViewById(R.id.lista);

        notatki.add("Tytuł \n treść");

        adapter = new ArrayAdapter<String>(this, R.layout.listviewitem, notatki);

        lista.setAdapter(adapter);

        dodajButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tekst = tytulEdit.getText().toString();

                tekst += "\n";

                tekst += trescEdit.getText().toString();

                notatki.add(tekst);

                adapter.notifyDataSetChanged();
            }
        });
    }
}