package com.example.ttsc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.ttsc.Adapter.VocabularyAdapter;
import com.example.ttsc.Database.Model;
import com.example.ttsc.Object.Vocabulary;
import com.example.ttsc.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VocabularyActivity extends AppCompatActivity {

    String TAG = "VocabularyActivity";

    ListView lvVocabulary;
    FloatingActionButton fabExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        lvVocabulary = findViewById(R.id.lv_vocabulary);
        fabExam = findViewById(R.id.fab_exam);

        int topicID = getIntent().getIntExtra("topic_id", 0);

        Model model = new Model(VocabularyActivity.this);
        final List<Vocabulary> listVocabulary = model.getListVocabulary(topicID);
        VocabularyAdapter vocabularyAdapter = new VocabularyAdapter(VocabularyActivity.this, R.layout.item_vocabulary, listVocabulary);
        lvVocabulary.setAdapter(vocabularyAdapter);

        fabExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyActivity.this, ExamActivity.class);
                startActivity(intent);
            }
        });
    }
}