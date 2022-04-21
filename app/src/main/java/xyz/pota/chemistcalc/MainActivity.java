package xyz.pota.chemistcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    TextView resulttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle( "kanamori_benkyo_siro_yo" );

        textview = (TextView) findViewById(R.id.form);
        resulttext = (TextView) findViewById(R.id.Result);

        findViewById(R.id.button_0).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_1).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_2).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_3).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_4).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_5).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_6).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_7).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_8).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_9).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_C).setOnClickListener(buttonElementListener);
        findViewById(R.id.button_H).setOnClickListener(buttonElementListener);
        findViewById(R.id.button_O).setOnClickListener(buttonElementListener);
        findViewById(R.id.button_N).setOnClickListener(buttonElementListener);
        findViewById(R.id.button_S).setOnClickListener(buttonElementListener);
        findViewById(R.id.button_Calculate).setOnClickListener(buttonResultListener);
        findViewById(R.id.button_Clear).setOnClickListener(buttonClearListener);

    }

    int halfway;
    int number;

    View.OnClickListener buttonElementListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            // EditTextの後ろに文字を追加
            textview.append(button.getText());
            if(number!=0){
                result = result+halfway*number;
                halfway=0;
                number=0;
            }
            if(halfway!=0){
                result=result+halfway;
                halfway=0;
            }
            switch(button.getText().toString()) {
                case "C":
                    halfway = 12;
                    break;
                case "H":
                    halfway = 1;
                    break;
                case "O":
                    halfway = 16;
                    break;
                case "N":
                    halfway = 14;
                    break;
                case "S":
                    halfway = 32;
                    break;
            }
        }
    };

    View.OnClickListener buttonNumberListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            textview.append(button.getText());
            String str = button.getText().toString();
            int newnum = Integer.parseInt(str);
            if(number==0) {
                number = newnum;
            }else{
                number = 10*number;
                number = number+newnum;
            }
        }
    };


    int recentOperator = R.id.button_Calculate; // 最近押された計算キー
    int result;  // 計算結果
    boolean isOperatorKeyPushed;    // 計算キーが押されたことを記憶

    View.OnClickListener buttonResultListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(number!=0){
                result = result+halfway*number;
            }else{
                result = result+halfway;
            }
            halfway=0;
            String value = String.valueOf(result);
            resulttext.setText(value);
        }
    };

    View.OnClickListener buttonClearListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            textview.setText("");
            resulttext.setText("0");
            result =0;
            number=0;
            halfway=0;
        }
    };
}
