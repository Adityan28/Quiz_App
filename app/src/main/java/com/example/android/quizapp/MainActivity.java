package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mScore=0;
    private TextView mScoreTextview;
    private CheckBox mQues3_op1;
    private CheckBox mQues3_op2;
    private CheckBox mQues3_op3;
    private CheckBox mQues3_op4;
    private RadioButton mQues1_op2;
    private RadioButton mQues2_op3;
    private RadioButton mQues4_op2;
    private RadioButton mQues6_op4;
    private EditText mQues5_text;
    private String mQues5_ans;
    private RadioGroup RGroup1;
    private RadioGroup RGroup2;
    private RadioGroup RGroup4;
    private RadioGroup RGroup6;
    private String resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreTextview=(TextView)findViewById(R.id.score_text_view);
        mScoreTextview.setVisibility(View.GONE);

        mQues1_op2=(RadioButton)findViewById(R.id.rb_ques1_op2);
        mQues2_op3=(RadioButton)findViewById(R.id.rb_ques2_op3);
        mQues3_op1=(CheckBox)findViewById(R.id.cb_ques3_op1);
        mQues3_op2=(CheckBox)findViewById(R.id.cb_ques3_op2);
        mQues3_op3=(CheckBox)findViewById(R.id.cb_ques3_op3);
        mQues3_op4=(CheckBox)findViewById(R.id.cb_ques3_op4);
        mQues4_op2=(RadioButton)findViewById(R.id.rb_ques4_op2);
        mQues6_op4=(RadioButton)findViewById(R.id.rb_ques6_op4);

        RGroup1=(RadioGroup)findViewById(R.id.r_group_1);
        RGroup2=(RadioGroup)findViewById(R.id.r_group_2);
        RGroup4=(RadioGroup)findViewById(R.id.r_group_4);
        RGroup6=(RadioGroup)findViewById(R.id.r_group_6);

        mQues5_text=(EditText)findViewById(R.id.ques5_edit_text);

    }

    public void buttonClicked(View view){

        mScore=0;

        if(mQues1_op2.isChecked()){
            mScore++;
        }
        if(mQues2_op3.isChecked()){
            mScore++;
        }
        if((mQues3_op1.isChecked() && mQues3_op3.isChecked()) && !(mQues3_op2.isChecked() || mQues3_op4.isChecked())){
            mScore++;
        }
        if(mQues4_op2.isChecked()){
            mScore++;
        }
        mQues5_ans=mQues5_text.getText().toString();
        if(mQues5_ans.equals(getString(R.string.ques5_ans))){
            mScore++;
        }
        if(mQues6_op4.isChecked()){
            mScore++;
        }

        resultMessage = getString(R.string.finalScore)+Integer.toString(mScore)+"\n";

        if(mScore>=5){
            resultMessage += getString(R.string.good);
        } else if(mScore>=3){
            resultMessage += getString(R.string.okay);
        } else {
            resultMessage += getString(R.string.bad);
        }

        Toast.makeText(this,getString(R.string.finalScore)+mScore,Toast.LENGTH_SHORT).show();
        mScoreTextview.setText(resultMessage);
        mScoreTextview.setVisibility(View.VISIBLE);
    }

    public void resetClicked(View view){
        mScore=0;
        RGroup1.clearCheck();
        RGroup2.clearCheck();
        RGroup4.clearCheck();
        RGroup6.clearCheck();
        if(mQues3_op1.isChecked()){
            mQues3_op1.toggle();
        }
        if(mQues3_op2.isChecked()){
            mQues3_op2.toggle();
        }
        if(mQues3_op3.isChecked()){
            mQues3_op3.toggle();
        }
        if(mQues3_op4.isChecked()){
            mQues3_op4.toggle();
        }
        mQues5_text.setText("");
        mScoreTextview.setVisibility(View.GONE);
    }
}
