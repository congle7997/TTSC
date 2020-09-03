package com.example.ttsc.Interface;

import com.example.ttsc.Object.Exam;

import java.io.Serializable;
import java.util.List;

public interface OnUpdateResult extends Serializable {
    void onUpdateResult(List<Exam> listExam);
}
