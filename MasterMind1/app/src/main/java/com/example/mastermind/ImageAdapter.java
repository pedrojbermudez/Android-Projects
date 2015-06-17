package com.example.mastermind;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends ArrayAdapter<Drawable> {
	private Context context;

	public ImageAdapter(Context ctx) {
		super(ctx, 0);
		context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView image = new ImageView(context);
		Drawable drawable = getItem(position);
		image.setLayoutParams(new GridView.LayoutParams(40, 40));
		image.setScaleType(ImageView.ScaleType.CENTER_CROP);
		image.setImageDrawable(drawable);
		return image;
	}
	public View getDropDownView(int position, View cnvtView,ViewGroup prnt) {
		return getView(position, cnvtView, prnt);
	}

}
