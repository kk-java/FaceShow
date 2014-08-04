package com.liucanwen.faceshow.lib;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ImageSpan;

import com.liucanwen.faceshow.R;

/**
 * face Handler
 * 
 * @author ck (liucanwen517@gmail.com)
 * @since 2014-8-2
 */
public class FaceHandler {

	private static Map<String, Integer> faces = new LinkedHashMap<String, Integer>();

	private FaceHandler() {
	}

	static {
		// faces lib
		faces.put("[cry]", R.drawable.face_cry);
		faces.put("[delicious]", R.drawable.face_delicious);
		faces.put("[good]", R.drawable.face_good);
		faces.put("[happy]", R.drawable.face_happy);
		faces.put("[love]", R.drawable.face_heart);
		faces.put("[kb]", R.drawable.face_kb);
		faces.put("[naughty]", R.drawable.face_naughty);
		faces.put("[rose]", R.drawable.face_rose);
		faces.put("[win]", R.drawable.face_win);
	}

	private static int getFaceResource(String faceName) {
		return faces.get(faceName) == null ? -1 : faces.get(faceName);
	}

	public static void addFaces(Context context, Spannable text, int iconSize) {

		Pattern p = Pattern.compile("\\[\\w+\\]");
		Matcher m = p.matcher(text.toString());

		while (m.find()) {
			String faceKey = m.group();

			int icon = getFaceResource(faceKey);

			if (icon > 0) {
				Drawable drawable = context.getResources().getDrawable(icon);
				drawable.setBounds(0, 0, iconSize, iconSize);
				ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
				text.setSpan(span, m.start(), m.end(),
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}

			m.groupCount();
		}
	}
}
