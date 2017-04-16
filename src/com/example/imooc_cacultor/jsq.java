package com.example.imooc_cacultor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;




public class jsq extends Activity implements OnClickListener{
	Button btn_0;
	Button btn_1;
	Button btn_2;
	Button btn_3;
	Button btn_4;
	Button btn_5;
	Button btn_6;
	Button btn_7;
	Button btn_8;
	Button btn_9;
	Button btn_point; //小数点
	Button btn_clear;
	Button btn_del;
	Button btn_plus;
	Button btn_minus;
	Button btn_multiply;
	Button btn_divide;
	Button btn_equal;
	EditText et_input;
	boolean clear_flag;
//	Button[] btn = {btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_clear,btn_del,btn_divide,btn_equal,btn_minus,btn_multiply,btn_plus,btn_point};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jsq);
		btn_0 = (Button) findViewById(R.id.btn_0);
		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_2 = (Button) findViewById(R.id.btn_2);
		btn_3 = (Button) findViewById(R.id.btn_3);
		btn_4 = (Button) findViewById(R.id.btn_4);
		btn_5 = (Button) findViewById(R.id.btn_5);
		btn_6 = (Button) findViewById(R.id.btn_6);
		btn_7 = (Button) findViewById(R.id.btn_7);
		btn_8 = (Button) findViewById(R.id.btn_8);
		btn_9 = (Button) findViewById(R.id.btn_9);
		btn_point = (Button) findViewById(R.id.btn_point);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_plus = (Button) findViewById(R.id.btn_plus);
		btn_minus = (Button) findViewById(R.id.btn_minus);
		btn_multiply = (Button) findViewById(R.id.btn_multiply);
		btn_divide = (Button) findViewById(R.id.btn_divide);
		btn_equal = (Button) findViewById(R.id.btn_equal);
//		实例化显示屏
		et_input = (EditText) findViewById(R.id.et_input);
//		TODO
/*//		设置点击事件，为什么不行呢
		for (int i = 0; i < btn.length; i++) {
			btn[i].setOnClickListener(this);
		}*/
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);

		btn_point.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_plus.setOnClickListener(this);
		btn_equal.setOnClickListener(this);

		btn_clear.setOnClickListener(this);
		btn_del.setOnClickListener(this);
	}
	public void onClick(View v) {
		String str =  et_input.getText().toString();
		switch (v.getId()) {
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn_point:
			if (clear_flag) {
				clear_flag = false;
				et_input.setText("");
			}
			et_input.setText(str+((Button)v).getText());
			break;
		case R.id.btn_plus:
		case R.id.btn_minus:
		case R.id.btn_multiply:
		case R.id.btn_divide:
			if (clear_flag) {
				clear_flag = false;
				et_input.setText("");
			}
			et_input.setText(str+" "+((Button)v).getText()+" ");
			break;
		case R.id.btn_clear:
			et_input.setText("");
			break;
		case R.id.btn_del:
			if (str!=null&&!str.equals("")) {
				et_input.setText(str.substring(0, str.length()-1));
			}
			break;
		case R.id.btn_equal:
			clear_flag = false;
			getResult();
			Log.i("test", "等号运行完毕");
			break;
		default:
			break;
		}
	}
	//运算结果
	private void getResult() {
//		Log.i("test1", "进入结果运算方法");
//		clear_flag = true;
//		String exp = et_input.getText().toString();
//		double r = 0;
//	    int space = exp.indexOf(' ');//用于搜索空格位置
//        String s1 = exp.substring(0, space);//s1用于保存第一个运算数
//        String op = exp.substring(space + 1, space + 2);//op用于保存运算符
//        String s2 = exp.substring(space + 3);//s2用于保存第二个运算数
//        double arg1 = Double.parseDouble(s1);//将运算数从string转换为Single
//        double arg2 = Double.parseDouble(s2);
//        Log.i("test", "赋值");
//        if(op.equals("＋")){
//        	 r = arg1 + arg2;
//        }else if(op.equals("－")){
//        	r = arg1 - arg2;
//        }else if(op.equals("×")){
//        	 r = arg1 * arg2;
//        }else if(op.equals("÷")){
//        	 if (arg2 == 0)
//             {
//                r=0;
//             }
//             else
//             {
//                 r = arg1 / arg2;
//             }
//        }       
//        if(!s1.contains(".")&&!s2.contains(".")){
//        	int result = (int)r;
//        	et_input.setText(result+"");
//        }else{
//        	et_input.setText(r+"");
//        }
		
		Log.i("test1", "进入结果运算方法");
		String exp = et_input.getText().toString();
		if (exp == null ||exp.equals("")) {
			return;
		}
		if (exp.equals(" ")) {
			return;
		}
		if (!exp.contains(" ")) {   //判断是否有空格，没有的话返回，避免下面的indexOf出错
			return;
		}
		if (clear_flag) {
			clear_flag = false;
			return;
		}
		clear_flag = true;
		Log.i("test5", "测试clear_flag影响");
		double result=0;
		int space = exp.indexOf(" ");//用于搜索空格位置
		String s1 = exp.substring(0, space);//s1用于保存第一个运算数
		String op = exp.substring(space + 1, space + 2);//op用于保存运算符
		String s2 = exp.substring(space + 3);//s2用于保存第二个运算数
		double d1 = Double.parseDouble(s1);
		double d2 = Double.parseDouble(s2);
		Log.i("test16", "赋值完毕");
///*		String s1 = exp.substring(0,exp.indexOf(" ") );
//		String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2 );
//		String s2 = exp.substring(exp.indexOf(" ")+3);*/
		if ((!s1.equals(""))&&(!s2.equals(""))) {  //s1s2都有
			Log.i("test2", "运行到对运算式判断");
			if (op.equals("+")) {
				result = d1 + d2;
			}else if (op.equals("-")) {
				result = d1 - d2;
			}else if (op.equals("*")) {
				result = d1 * d2;
			}else if (op.equals("/")) {
				if (d2==0) {
					result = 0;
				}else {
						result = d1 / d2;
				}
			}
			if (!s1.contains(".")&&!s2.contains(".")&&!op.equals("/")) {  //此处有BUG，S2等于 null时
				int r = (int)result;
				et_input.setText(r+"");
			}else {
				et_input.setText(result+"");
			}
		}
		//下面的不需要
//		else if (!s1.equals("")&&s2.equals("")) {  //s1有，s2空
//			et_input.setText(exp);
//			Log.i("test7", "运行到对运算式判断2");
//		}else if (s1.equals("")&&!s2.equals("")){    //s1空，s2有
//			Log.i("test8", "运行到对运算式判断3");
//			if (op.equals("+")) {
//				result = 0 + d2;
//			}else if (op.equals("-")) {
//				result = 0 - d2;
//			}else if (op.equals("*")) {
//				result = 0;
//			}else if (op.equals("/")) {
//				result = 0;
//			}else {
//				result = 0;
//			}
//			if (!s2.contains(".")) {
//				int r = (int)result;
//				et_input.setText(r+"");
//			}else {
//				et_input.setText(result+"");
//			}
//			}else {
//			et_input.setText("");
//			Log.i("test6", "运行最后一种情况");
//		}
		Log.i("test4", "运算方法完毕");
		Log.i("test3", String.valueOf(result));
	}
}
