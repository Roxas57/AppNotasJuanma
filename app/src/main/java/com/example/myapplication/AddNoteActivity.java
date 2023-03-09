package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Data.DbNotes;
import com.google.android.material.button.MaterialButton;

import java.util.Calendar;


public class AddNoteActivity extends AppCompatActivity {

    private String selectedDate;
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText titleInput = findViewById(R.id.titleinput);
        EditText descriptionInput = findViewById(R.id.descriptioninput);
        CalendarView calendar = findViewById(R.id.calendarView);
        Spinner statusInput = findViewById(R.id.statusView);
        MaterialButton saveBtn = findViewById(R.id.savebtn);
        selectedDate=getFecha(calendar);

        String[] options = new String[] {
                "Recordatorios",
                "Comprar",
                "Eventos",
                "Tareas"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusInput.setAdapter(adapter);

        statusInput.setSelection(0);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String Date = dayOfMonth + "/" + (month+1)  + "/" + year;
                selectedDate=Date;
            }
        });

        statusInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                status = parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                status = parentView.getItemAtPosition(0).toString();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    String title = titleInput.getText().toString();
                    String description = descriptionInput.getText().toString();

                    Note note = new Note(title,description,selectedDate,status);

                    DbNotes db = new DbNotes(AddNoteActivity.this);
                    db.addNote(note);
                } else {
                    Toast.makeText(AddNoteActivity.this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
            private boolean validarCampos() {
                boolean camposRellenos = true;

                String titulo = titleInput.getText().toString();
                String contenido = descriptionInput.getText().toString();

                if (TextUtils.isEmpty(titulo)) {
                    camposRellenos = false;
                    titleInput.setError("Introduce un título");
                }

                if (TextUtils.isEmpty(contenido)) {
                    camposRellenos = false;
                    descriptionInput.setError("Introduce un contenido");
                }
                return camposRellenos;
            }
        });
    }

    public String  getFecha(CalendarView calendar){
        Calendar selectedDate = Calendar.getInstance();
        selectedDate.setTimeInMillis(calendar.getDate());
        int year = selectedDate.get(Calendar.YEAR);
        int month = selectedDate.get(Calendar.MONTH);
        int dayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
        return  dayOfMonth + "/" + (month+1)  + "/" + year;

    }

}
