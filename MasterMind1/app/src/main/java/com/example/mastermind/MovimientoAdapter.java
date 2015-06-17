package com.example.mastermind;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
public class MovimientoAdapter extends ArrayAdapter<Movimiento> {
	private Context context;

	public MovimientoAdapter(Context ctx) {
		super(ctx, 0);
		context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        return li.inflate(R.layout.movimiento, null);
	}
	public View getDropDownView(int position, View cnvtView,ViewGroup prnt) {
		return getView(position, cnvtView, prnt);
	}

}
