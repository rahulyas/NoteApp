package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.noteapp.ModelClass.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTaker extends AppCompatActivity {
  EditText editTitle,editnotes;
  ImageView imageView_save;
  Notes notes;
  boolean isOldNote= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);
        editTitle = findViewById(R.id.editTitle);
        editnotes = findViewById(R.id.editnotes);
        imageView_save = findViewById(R.id.imageView_save);


        notes = new Notes();
        try{
            notes = (Notes) getIntent().getSerializableExtra("old_note");
            editTitle.setText(notes.getTitle());
            editnotes.setText(notes.getNotes());
            isOldNote=true;

        }catch (Exception e){
            e.printStackTrace();
        }

        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTitle.getText().toString();
                String description = editnotes.getText().toString();

                if (description.isEmpty()){
                    Toast.makeText(NotesTaker.this,"Please add some notes!", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm a");
                Date date = new Date();

                if(!isOldNote){
                    notes =new Notes();
                }


                notes.setTitle(title);
                notes.setDate(formatter.format(date));
                notes.setNotes(description);

                Intent intent = new Intent();
                intent.putExtra("note", notes);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}