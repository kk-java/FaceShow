package com.liucanwen.faceshow.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;

import com.liucanwen.faceshow.R;

/**
 * face TextView
 * 
 * @author ck (liucanwen517@gmail.com)
 * @since 2014-8-2
 */
public class FaceShowTextView extends TextView {

	private int faceSize = (int) getTextSize();

	private boolean faceStatus = true;

	public FaceShowTextView(Context context) {
		super(context);
		init(null);
	}

	public FaceShowTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if (isInEditMode()) {
			return;
		}
		init(attrs);
	}

	public FaceShowTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	private void init(AttributeSet attrs) {
		if (attrs == null) {
			faceSize = (int) getTextSize();
		} else {
			TypedArray a = getContext().obtainStyledAttributes(attrs,
					R.styleable.faceShow);
			faceSize = (int) a.getDimension(R.styleable.faceShow_faceSize,
					getTextSize());
			faceStatus = a.getBoolean(R.styleable.faceShow_faceStatus, true);
			a.recycle();
		}
		setText(getText());
	}

	@Override
	public void setText(CharSequence text, BufferType type) {

		SpannableStringBuilder builder = new SpannableStringBuilder(text);

		if (faceStatus) {
			FaceHandler.addFaces(getContext(), builder, faceSize);
		}

		super.setText(builder, type);
	}

}
