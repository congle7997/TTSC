package com.example.ttsc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.ttsc.Adapter.TopicAdapter;
import com.example.ttsc.Database.Model;
import com.example.ttsc.Object.Topic;
import com.example.ttsc.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    GridView grvTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grvTopic = findViewById(R.id.grv_topic);

        Model model = new Model(MainActivity.this);
        if (!model.isCopyDB()) {
            model.copyDB();
        }

        final List<Topic> listTopic = model.getListTopic();
        TopicAdapter topicAdapter = new TopicAdapter(MainActivity.this, R.layout.item_topic, listTopic);
        grvTopic.setAdapter(topicAdapter);

        grvTopic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, VocabularyActivity.class);
                intent.putExtra("topic_id", listTopic.get(position).getTopicID());
                startActivity(intent);
            }
        });
    }
}