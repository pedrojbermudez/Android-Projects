package com.example.mastermind;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;


public class MainActivity extends Activity {
    ListView lv;
    Button bt;
    MasterMind masterMind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView1);
        masterMind = new MasterMind();
        bt = (Button) findViewById(R.id.button1);
        Drawable[] drawable = new Drawable[10];
		drawable[0] = getResources().getDrawable(R.drawable.color0);
		drawable[1] = getResources().getDrawable(R.drawable.color1);
		drawable[2] = getResources().getDrawable(R.drawable.color2);
		drawable[3] = getResources().getDrawable(R.drawable.color3);
		drawable[4] = getResources().getDrawable(R.drawable.color4);
		drawable[5] = getResources().getDrawable(R.drawable.color5);
		drawable[6] = getResources().getDrawable(R.drawable.color6);
		drawable[7] = getResources().getDrawable(R.drawable.color7);
		drawable[8] = getResources().getDrawable(R.drawable.color8);
		drawable[9] = getResources().getDrawable(R.drawable.color9);
        Drawable descolocada = getResources().getDrawable(R.drawable.descolocada);
        Drawable colocada = getResources().getDrawable(R.drawable.colocada);
        ImageAdapter adapter = new ImageAdapter(this);
        final MovimientoAdapter mAdapter = new MovimientoAdapter(this);
        lv.setAdapter(mAdapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for(Drawable dra : drawable)
		{
			adapter.add(dra);
		}
        Spinner number1 = (Spinner) findViewById(R.id.number1);
        Spinner number2 = (Spinner) findViewById(R.id.number2);
        Spinner number3 = (Spinner) findViewById(R.id.number3);
        Spinner number4 = (Spinner) findViewById(R.id.number4);
        number1.setAdapter(adapter);   
        number2.setAdapter(adapter);
        number3.setAdapter(adapter);
        number3.setAdapter(adapter);
        number4.setAdapter(adapter);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.add();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
