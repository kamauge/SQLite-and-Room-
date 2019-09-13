package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.notes.models.Note;
import com.example.notes.adapters.NotesRecyclerAdapter;
import com.example.notes.utils.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {
    public static final String TAG ="NotesActivity";

    //ui components
    RecyclerView mRecyclerView;

    //variables
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNoteRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        initRecyclerView();
        fakeNotes();

    }
    private void fakeNotes(){
        for (int i=0; i <= 1000; i++){
            Note note = new Note();
            note.setTitle("Title #" +i);
            note.setContent("Content #" +i);
            note.setTimestamp("Sept 2019");
            mNotes.add(note);
        }
        mNoteRecyclerAdapter.notifyDataSetChanged();

    }
    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator verticalSpacingItemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(verticalSpacingItemDecorator);
        mNoteRecyclerAdapter = new NotesRecyclerAdapter(mNotes);
        mRecyclerView.setAdapter(mNoteRecyclerAdapter);

    }
}
