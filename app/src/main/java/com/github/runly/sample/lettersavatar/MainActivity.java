package com.github.runly.sample.lettersavatar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.runly.letteravatar.LetterAvatar;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		LinearLayout linearOne = (LinearLayout) findViewById(R.id.linear_one);
		LinearLayout linearTwo = (LinearLayout) findViewById(R.id.linear_two);

		int[] colors = {R.color.bg_color_one, R.color.bg_color_two,
			R.color.bg_color_three, R.color.bg_color_four, R.color.bg_color_five};
		String[] strs = {"A", "BC", "中", "の", "?"};

		for (int i = 0; i < linearOne.getChildCount(); i++) {
			LetterAvatar.with(this)
				.letters(strs[i])
				.letterColor(Color.WHITE)
				.backgroundColorResId(colors[i])
				.letterSize(75)
				.canvasSize(150, 150)
				.into((ImageView) linearOne.getChildAt(i));
		}

		for (int i = 0; i < linearTwo.getChildCount(); i++) {
			/*
			* https://github.com/hdodenhof/CircleImageView
			*/
			LetterAvatar.with(this)
				.letters(strs[i])
				.letterColor(Color.WHITE)
				.backgroundColorResId(colors[i])
				.letterSizeDIP(25)
				.canvasSizeDIP(50, 50)
				.into((ImageView) linearTwo.getChildAt(i));
		}
	}
}
