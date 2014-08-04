package com.liucanwen.faceshow;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.liucanwen.faceshow.lib.FaceShowEditText;
import com.liucanwen.faceshow.lib.FaceShowTextView;

/**
 * 
 * @author ck (liucanwen517@gmail.com)
 * @since 2014-8-2
 */
public class MainActivity extends Activity {

	private EditText normalEditText;
	private TextView normalTextView;
	
	private FaceShowEditText faceShowEditText;
	private FaceShowTextView faceShowTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		normalEditText = (EditText) findViewById(R.id.normalshow_et);
		normalTextView = (TextView) findViewById(R.id.normalshow_tv);
		
		faceShowEditText = (FaceShowEditText) findViewById(R.id.faceshow_et);
		faceShowTextView = (FaceShowTextView) findViewById(R.id.faceshow_tv);
		
		faceShowEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				
				faceShowTextView.setText(arg0);
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				
				normalEditText.setText(arg0.toString());
				normalTextView.setText(arg0.toString());
			}
		});
	}

}
