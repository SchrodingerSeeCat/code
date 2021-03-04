package com.valid.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String operator = ""; // 运算符
    private String firstNum = ""; // 第一个操作数
    private String secondNum = ""; // 第二个操作数
    private String result = ""; // 结果
    private boolean isOperator; // 当前是否已经输入过运算符
    private boolean isResult; // 当前是否已经计算出结果

    private TextView tv_msg;
    private Button btn_ce;
    private Button btn_division;
    private Button btn_multiplication;
    private Button btn_delete;
    private Button btn_seven;
    private Button btn_eight;
    private Button btn_nine;
    private Button btn_add;
    private Button btn_four;
    private Button btn_five;
    private Button btn_six;
    private Button btn_sub;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private ImageButton btn_sqrt;
    private Button btn_reciprocal;
    private Button btn_zero;
    private Button btn_spot;
    private Button btn_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 查找对应的控件
        findView();
        setClick();
    }

    private class MyOnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            // 存储操作符
            saveOperator(v);

            // 存储操作数
            saveNum(v);

            // 删除操作
            delete(v);

            // 显示结果
            result = firstNum + operator + secondNum;
            tv_msg.setText(result);

            if(v.getId() == R.id.btn_equal) {

                // 操作符不能为空
                if (operator.equals("")) {
                    Toast.makeText(MainActivity.this, "请输入操作符", Toast.LENGTH_LONG).show();
                    return;
                }

                // 操作数不能为空
                if (!operator.equals("√") && (firstNum.equals("") || secondNum.equals(""))) {
                    Toast.makeText(MainActivity.this, "无效操作数", Toast.LENGTH_LONG).show();
                    return;
                }

                // 除数不能为0
                if (operator.equals("÷") && Double.parseDouble(secondNum) == 0) {
                    Toast.makeText(MainActivity.this, "除数不能为0", Toast.LENGTH_LONG).show();
                    Log.d("log", "lll");
                    return;
                }

                // 开根号不能为负数
                Log.d("开根号: ", secondNum+"");
                if (operator.equals("√") && Double.parseDouble(secondNum) < 0) {
                    Toast.makeText(MainActivity.this, "根号不能为负数", Toast.LENGTH_LONG).show();
                    return;
                }

                // 计算结果
                calcResult();
            }
        }
    }

    // 计算结果
    public void calcResult() {
        // 运算
        double calc = 0;
        switch (operator) {
            case "+":
                calc = Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
                break;
            case "-":
                calc = Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
                break;
            case "*":
                calc = Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
                break;
            case "÷":
                calc = Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
                break;
            case "√":
                calc = Math.sqrt(Double.parseDouble(secondNum));
                break;
        }

        result = result + '=' + calc;
        tv_msg.setText(result);
        isResult = true;
    }

    // 删除操作
    public void delete(View v) {
        if(v.getId() == R.id.btn_delete) {
            if(isResult) {
                result = "";
                firstNum = "";
                secondNum = "";
                isOperator = false;
                isResult = false;
                operator = "";
            } else if(!secondNum.equals("")) {
                secondNum = secondNum = secondNum.substring(0, secondNum.length() - 1);
            } else if(!operator.equals("")) {
                operator = "";
                isOperator = false;
            } else if(!firstNum.equals("")) {
                firstNum = firstNum.substring(0, secondNum.length() - 1);
            }
        }
    }

    // 存储操作数
    public void saveNum(View v) {
        switch (v.getId()) {
            case R.id.btn_zero:
                if(!isOperator) {
                    firstNum += "0";
                } else {
                    secondNum += "0";
                }
                break;
            case R.id.btn_one:
                if(!isOperator) {
                    firstNum += "1";
                } else {
                    secondNum += "1";
                }
                break;
            case R.id.btn_two:
                if(!isOperator) {
                    firstNum += "2";
                } else {
                    secondNum += "2";
                }
                break;
            case R.id.btn_three:
                if(!isOperator) {
                    firstNum += "3";
                } else {
                    secondNum += "3";
                }
                break;
            case R.id.btn_four:
                if(!isOperator) {
                    firstNum += "4";
                } else {
                    secondNum += "4";
                }
                break;
            case R.id.btn_five:
                if(!isOperator) {
                    firstNum += "5";
                } else {
                    secondNum += "5";
                }
                break;
            case R.id.btn_six:
                if(!isOperator) {
                    firstNum += "6";
                } else {
                    secondNum += "6";
                }
                break;
            case R.id.btn_seven:
                if(!isOperator) {
                    firstNum += "7";
                } else {
                    secondNum += "7";
                }
                break;
            case R.id.btn_eight:
                if(!isOperator) {
                    firstNum += "8";
                } else {
                    secondNum += "8";
                }
                break;
            case R.id.btn_nine:
                if(!isOperator) {
                    firstNum += "9";
                } else {
                    secondNum += "9";
                }
        }
    }

    // 存储操作符
    public void saveOperator(View v) {
        if (v.getId() == R.id.btn_add) {
            operator = "+";
            isOperator = true;
        } else if (v.getId() == R.id.btn_sub) {
            if (operator.equals("√")) {
                secondNum = "-";
            } else if (firstNum.equals("")) {
                firstNum = "-";
            }else {
                operator = "-";
                isOperator = true;
            }
        } else if(v.getId() == R.id.btn_multiplication) {
            operator = "*";
            isOperator = true;
        } else if (v.getId() == R.id.btn_division) {
            operator = "÷";
            isOperator = true;
        }else if (v.getId() == R.id.btn_sqrt) {
            operator = "√";
            isOperator = true;
        }
    }

    // 查找组件
    public void findView() {
        tv_msg = findViewById(R.id.tv_msg);
        btn_ce = findViewById(R.id.btn_ce);
        btn_division = findViewById(R.id.btn_division);
        btn_multiplication = findViewById(R.id.btn_multiplication);
        btn_delete = findViewById(R.id.btn_delete);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);
        btn_add = findViewById(R.id.btn_add);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_sub = findViewById(R.id.btn_sub);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_sqrt = findViewById(R.id.btn_sqrt);
        btn_reciprocal = findViewById(R.id.btn_reciprocal);
        btn_zero = findViewById(R.id.btn_zero);
        btn_spot = findViewById(R.id.btn_spot);
        btn_equal = findViewById(R.id.btn_equal);
    }

    // 绑定点击事件
    public void setClick() {
        MyOnClick click = new MyOnClick();

        btn_ce.setOnClickListener(click);
        btn_division.setOnClickListener(click);
        btn_multiplication.setOnClickListener(click);
        btn_delete.setOnClickListener(click);
        btn_seven.setOnClickListener(click);
        btn_eight.setOnClickListener(click);
        btn_nine.setOnClickListener(click);
        btn_add.setOnClickListener(click);
        btn_four.setOnClickListener(click);
        btn_five.setOnClickListener(click);
        btn_six.setOnClickListener(click);
        btn_sub.setOnClickListener(click);
        btn_one.setOnClickListener(click);
        btn_two.setOnClickListener(click);
        btn_three.setOnClickListener(click);
        btn_sqrt.setOnClickListener(click);
        btn_reciprocal.setOnClickListener(click);
        btn_zero.setOnClickListener(click);
        btn_spot.setOnClickListener(click);
        btn_equal.setOnClickListener(click);
    }
}