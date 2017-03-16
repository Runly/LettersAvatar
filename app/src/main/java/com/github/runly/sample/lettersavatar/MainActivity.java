package com.github.runly.sample.lettersavatar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.github.runly.letteravatar.LetterAvatar;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageView imageView = (ImageView) findViewById(R.id.image);
		LetterAvatar.with(this)
			.chineseFirstLetter("中文", true)
			.letterColor(Color.WHITE)
			.backgroundColorResId(R.color.bg_color_one)
			.letterSize(150)
			.canvasSize(300, 300)
			.into(imageView);

		/*
		 * https://github.com/hdodenhof/CircleImageView
		 */
		CircleImageView circleImageView = (CircleImageView) findViewById(R.id.circleImage);
		LetterAvatar.with(this)
			.firstLetter("ABC DEF")
			.letterColor(Color.WHITE)
			.backgroundColorResId(R.color.bg_color_two)
			.letterSizeDIP(50)
			.canvasSizeDIP(100, 100)
			.into(circleImageView);

	}
}
