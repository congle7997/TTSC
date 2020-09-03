package com.example.ttsc.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.ttsc.Adapter.ExamAdapter;
import com.example.ttsc.Database.Model;
import com.example.ttsc.Object.Exam;
import com.example.ttsc.Interface.OnUpdateResult;
import com.example.ttsc.R;

import java.util.List;

public class ExamActivity extends AppCompatActivity implements OnUpdateResult {

    ViewPager vpExam;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        vpExam = findViewById(R.id.vp_exam);
        Model model = new Model(ExamActivity.this);
        List<Exam> listExam = model.getListExam();
        total = listExam.size();
        ExamAdapter examAdapter = new ExamAdapter(getSupportFragmentManager(), listExam, ExamActivity.this);
        vpExam.setAdapter(examAdapter);
    }

    @Override
    public void onUpdateResult(List<Exam> listExam) {
        int correct = 0;
        for (Exam exam : listExam) {
            if (exam.getAnsChoose().equals(exam.getAnsCorrect())) {
                correct++;
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(ExamActivity.this);
        builder.setTitle("Thông báo");
        builder.setMessage("Số câu làm đúng: " + correct + "/" + total);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}