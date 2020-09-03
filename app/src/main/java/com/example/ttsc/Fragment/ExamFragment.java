package com.example.ttsc.Fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ttsc.Object.Exam;
import com.example.ttsc.Interface.OnUpdateResult;
import com.example.ttsc.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExamFragment extends Fragment {

    String TAG = "ExamFragment";
    List<Exam> listExam;
    OnUpdateResult onUpdateResult;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExamFragment newInstance(String param1, String param2) {
        ExamFragment fragment = new ExamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        listExam = (List<Exam>) getArguments().getSerializable("list");
        onUpdateResult = (OnUpdateResult) getArguments().getSerializable("i");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        int pos = getArguments().getInt("pos");
        TextView txtNumber = view.findViewById(R.id.txt_number);
        ImageView imgExam = view.findViewById(R.id.img_exam);
        RadioGroup rgAns = view.findViewById(R.id.rg_ans);
        RadioButton rbAns1 = view.findViewById(R.id.rbAns1);
        RadioButton rbAns2 = view.findViewById(R.id.rbAns2);
        RadioButton rbAns3 = view.findViewById(R.id.rbAns3);
        Button btnCheck = view.findViewById(R.id.btn_check);
        final Exam exam = listExam.get(pos);
        txtNumber.setText("Câu số: " + (pos + 1));
        try {
            InputStream inputStream = getContext().getAssets().open("image/" + exam.getExamImage() + ".jpg");
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imgExam.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        rbAns1.setText(exam.getAns1());
        rbAns2.setText(exam.getAns2());
        rbAns3.setText(exam.getAns3());

        rgAns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                exam.setAnsChoose(convertID(checkedId));
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUpdateResult.onUpdateResult(listExam);
            }
        });

        return view;
    }

    public String convertID(int id) {
        if (id == R.id.rbAns1) {
            return "A";
        } else if (id == R.id.rbAns2) {
            return "B";
        } else{
            return "C";
        }
    }
}