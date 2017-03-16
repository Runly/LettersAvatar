package com.github.runly.letteravatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.lang.ref.WeakReference;

/**
 * Created by ranly on 17-3-15.
 */

public class LetterAvatar {
	private WeakReference<Context> mContext;
	private static LetterAvatar letterAvatar;
	private int width = 300, height = 300, letterSize = 100, letterColor = Color.WHITE, backgroundColor = Color.BLACK;
	private String letter = "";


	private static LetterAvatar getInstance() {
		if (letterAvatar == null) {
			letterAvatar = new LetterAvatar();
		}
		return letterAvatar;
	}


	/**
	 * set context, it maybe activity or application...
	 *
	 * @param context your activity or application
	 * @return LetterAvatar itself
	 */
	public static LetterAvatar with(Context context) {
		if (context == null) {
			throw new NullPointerException("context is a null reference");
		} else {
			LetterAvatar letterAvatar = getInstance();
			letterAvatar.mContext = new WeakReference<>(context);
			return letterAvatar;
		}
	}


	/**
	 * set letter you want to draw
	 * only draw first char
	 *
	 * @param letter the letters you want to draw
	 * @return LetterAvatar itself
	 */
	public LetterAvatar firstLetter(String letter) {
		if (letter == null) {
			throw new NullPointerException("letter is a null reference");
		} else {
			letterAvatar.letter = String.valueOf(letter.charAt(0));
			return letterAvatar;
		}
	}


	/**
	 * set letter you want to draw
	 * use the chinese word's first letter as content
	 *
	 * @param text        chinese text
	 * @param capitalized can the first letter be capitalized
	 * @return LetterAvatar itself
	 */
	public LetterAvatar chineseFirstLetter(String text, boolean capitalized) {
		if (text == null) {
			throw new NullPointerException("text is a null reference");
		} else {
			try {
				String firstLetter = String.valueOf(PinyinHelper.getShortPinyin(text).charAt(0));
				if (capitalized) {
					letterAvatar.letter = firstLetter.toUpperCase();
				} else {
					letterAvatar.letter = firstLetter;
				}
			} catch (PinyinException e) {
				e.printStackTrace();
				letterAvatar.letter = "";
			}
			return letterAvatar;
		}
	}


	/**
	 * set letters you want to draw
	 *
	 * @param letters the letters you want to draw
	 * @return LetterAvatar itself
	 */
	public LetterAvatar letters(String letters) {
		if (letters == null) {
			throw new NullPointerException("letters is a null reference");
		} else {
			letterAvatar.letter = letters;
			return letterAvatar;
		}
	}


	/**
	 * set letter size with PX
	 *
	 * @param size the letters's size
	 * @return LetterAvatar itself
	 */
	public LetterAvatar letterSize(int size) {
		if (size < 0) {
			try {
				throw new NumberLessThanZeroException("letter size should be >= 0, but letterSize =" + size);
			} catch (NumberLessThanZeroException e) {
				e.printStackTrace();
			}
		} else {
			letterAvatar.letterSize = size;
		}

		return letterAvatar;
	}


	/**
	 * set letter size with DIP
	 *
	 * @param size the letters's size
	 * @return LetterAvatar itself
	 */
	public LetterAvatar letterSizeDIP(int size) {
		if (size < 0) {
			try {
				throw new NumberLessThanZeroException("letter size should be >= 0, but letterSize =" + size);
			} catch (NumberLessThanZeroException e) {
				e.printStackTrace();
			}
		} else {
			letterAvatar.letterSize = UnitConvert.dp2Px(mContext.get(), size);
		}

		return letterAvatar;
	}


	/**
	 * set canvas width and height with PX
	 *
	 * @param width  the bitmap's width
	 * @param height the bitmap's height
	 * @return LetterAvatar itself
	 */
	public LetterAvatar canvasSize(int width, int height) {
		if (width <= 0 || height <= 0) {
			try {
				throw new NumberLessThanZeroException("width and height should be > 0, but width =" + width + ", height = " + height);
			} catch (NumberLessThanZeroException e) {
				e.printStackTrace();
			}
		} else {
			letterAvatar.width = width;
			letterAvatar.height = height;
		}

		return letterAvatar;
	}


	/**
	 * set canvas width and height with DIP
	 *
	 * @param width  the bitmap's width
	 * @param height the bitmap's height
	 * @return LetterAvatar itself
	 */
	public LetterAvatar canvasSizeDIP(int width, int height) {
		if (width <= 0 || height <= 0) {
			try {
				throw new NumberLessThanZeroException("width and height should be > 0, but width =" + width + ", height = " + height);
			} catch (NumberLessThanZeroException e) {
				e.printStackTrace();
			}
		} else {
			letterAvatar.width = UnitConvert.dp2Px(mContext.get(), width);
			letterAvatar.height = UnitConvert.dp2Px(mContext.get(), height);
		}

		return letterAvatar;
	}


	/**
	 * set letter color
	 *
	 * @param color the color of letters
	 * @return LetterAvatar itself
	 */
	public LetterAvatar letterColor(int color) {
		letterAvatar.letterColor = color;
		return letterAvatar;
	}


	/**
	 * set letter color with resId
	 *
	 * @param resId the color resId of letters
	 * @return LetterAvatar itself
	 */
	public LetterAvatar letterColorResId(int resId) {
		letterAvatar.letterColor = ContextCompat.getColor(mContext.get(), resId);
		return letterAvatar;
	}


	/**
	 * set background color
	 *
	 * @param color the color of background
	 * @return LetterAvatar itself
	 */
	public LetterAvatar backgroundColor(int color) {
		letterAvatar.backgroundColor = color;
		return letterAvatar;
	}

	/**
	 * set background color with resId
	 *
	 * @param resId the color resId of background
	 * @return LetterAvatar itself
	 */
	public LetterAvatar backgroundColorResId(int resId) {
		letterAvatar.backgroundColor = ContextCompat.getColor(mContext.get(), resId);
		return letterAvatar;
	}


	/**
	 * return the bitmap you need
	 *
	 * @return the bitmap you need
	 */
	public Bitmap create() {
		Bitmap bitmap = Bitmap.createBitmap(letterAvatar.width, letterAvatar.height, Bitmap.Config.RGB_565);
		Canvas canvas = new Canvas(bitmap);
		RectF rectF = new RectF(0, 0, letterAvatar.width, letterAvatar.height);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(letterAvatar.backgroundColor);
		canvas.drawRoundRect(rectF, 0, 0, paint);
		float textSize = (float) Math.sqrt(letterSize * letterSize * 2);
		if (letterSize < 0) {
			textSize = - textSize;
		}
		paint.setTextSize(textSize);
		paint.setColor(letterColor);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		Paint.FontMetrics fontMetrics = paint.getFontMetrics();
		float bottom = fontMetrics.bottom;
		float ascent = fontMetrics.ascent;
		float descent = fontMetrics.descent;
		int baseline = (int) (rectF.centerY() - (ascent + descent) / 2 + Math.abs(descent - bottom) / 2);
		canvas.drawText(letterAvatar.letter, rectF.centerX(), baseline, paint);
		reSet();
		return bitmap;
	}

	/**
	 * set a letter bitmap into imageView
	 *
	 * @param imageView ImageView
	 */
	public void into(ImageView imageView) {
		if (imageView == null) {
			throw new NullPointerException("imageView is a null reference");
		}
		Bitmap bitmap = create();
		if (bitmap != null) {
			imageView.setImageBitmap(bitmap);
		}
	}


	private void reSet() {
		width = 300;
		height = 300;
		letterSize = 100;
		letterColor = Color.WHITE;
		backgroundColor = Color.BLACK;
	}


	private class NumberLessThanZeroException extends IllegalAccessException {
		NumberLessThanZeroException(String errorMessage) {
			super(errorMessage);
		}
	}
}
