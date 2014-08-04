package com.liucanwen.faceshow.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

import com.liucanwen.faceshow.R;

/**
 * Face EditText
 * 
 * @author ck (liucanwen517@gmail.com)
 * @since 2014-8-2
 */
public class FaceShowEditText extends EditText {

	private int faceSize = (int) getTextSize();;
	private boolean faceStatus = true;

	public FaceShowEditText(Context context) {
		super(context);
	}

	public FaceShowEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		if (isInEditMode()) {
			return;
		}

		init(attrs);
	}

	public FaceShowEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	private void init(AttributeSet attrs) {
		TypedArray a = getContext().obtainStyledAttributes(attrs,
				R.styleable.faceShow);
		faceSize = (int) a.getDimension(R.styleable.faceShow_faceSize,
				getTextSize());
		faceStatus = a.getBoolean(R.styleable.faceShow_faceStatus, true);
		a.recycle();

		setText(getText());
	}

	@Override
	protected void onTextChanged(CharSequence text, int start,
			int lengthBefore, int lengthAfter) {
		if (faceStatus) {
			FaceHandler.addFaces(getContext(), getText(), faceSize);
		}
	}
}
