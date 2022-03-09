package com.example.moncalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
  EditText screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen =findViewById(R.id.input);
        screen.setShowSoftInputOnFocus(false);
        screen.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
          if(getString(R.string.saisir_votre_op_ration).equals(screen.getText())){
            screen.setText("");
          }
          }
        });

    }
    private void MAJscreen(String strAajouter){
    String oldString=screen.getText().toString();
    int curseurPos=screen.getSelectionStart();
    String leftStr=oldString.substring(0,curseurPos);
    String rightStr=oldString.substring(curseurPos);
    if(getString(R.string.saisir_votre_op_ration).equals(screen.getText())) {
      screen.setText(strAajouter);
      screen.setSelection(curseurPos + 1);
    }else {
      screen.setText(String.format("%S%S%S", leftStr, strAajouter, rightStr));
      screen.setSelection(curseurPos + 1);
    }
    }
    void zerobtn(View view){
     MAJscreen("0");
    }
    void _1btn(View view){
      MAJscreen("1");
    }
    void _2btn(View view){
      MAJscreen("2");
    }
    void _3btn(View view){
      MAJscreen("3");
    }
    void _4btn(View view){
      MAJscreen("4");
    }
    void _5btn(View view){
      MAJscreen("5");
    }
    void _6btn(View view){
      MAJscreen("6");
    }
    void _7btn(View view){
      MAJscreen("7");
    }
    void _8btn(View view){
      MAJscreen("8");
    }
    void _9btn(View view){
      MAJscreen("9");
    }
    void plusbtn(View view){
      MAJscreen("+");
    }
    void moinsbtn(View view){
      MAJscreen("-");
    }
    void multbtn(View view){
      MAJscreen("*");
    }
    void divbtn(View view){
      MAJscreen("/");
    }
    void parenthesesbtn(View view){
      int curseurPos=screen.getSelectionStart();
      int openedParentheses=0;
      int closedParentheses=0;
      int textLength=screen.getText().length();
      for(int i=0;i<curseurPos;i++){
        if(screen.getText().toString().substring(i,i+1).equals("(")){
          openedParentheses++;
        }
        if(screen.getText().toString().substring(i,i+1).equals(")")){
          closedParentheses++;
        }
      }
      if(closedParentheses==openedParentheses||screen.getText().toString().substring(textLength-1,textLength).equals("(")){
        MAJscreen("(");
      }
      else if(closedParentheses < openedParentheses||screen.getText().toString().substring(textLength-1,textLength).equals("(")){
        MAJscreen(")");
      }
      screen.setSelection(curseurPos+1);

    }
    void puissancebtn(View view){
      MAJscreen("");
    }
    void virgullebtn(View view){
      MAJscreen(".");
    }
  void egalbtn(View view){
    String operation= screen.getText().toString();
    operation.replaceAll("÷","/");
    operation.replaceAll("×","*");
    Expression expression=new Expression(operation);
    String resultat=String.valueOf(expression.calculate());
    screen.setText(resultat);
    screen.setSelection(resultat.length());
  }
  void clearbtn(View view){
    screen.setText("");
  }
  void delbtn(View view){
    int curseurPos=screen.getSelectionStart();
    int textLen=screen.getText().length();
    if(curseurPos!=0 && textLen!= 0){
      SpannableStringBuilder selection=(SpannableStringBuilder) screen.getText();
      selection.replace(curseurPos-1,curseurPos,"");
      screen.setText(selection);
      screen.setSelection(curseurPos-1);
    }
  }

  public void signbtn(View view) {
    MAJscreen("-");
  }
}


