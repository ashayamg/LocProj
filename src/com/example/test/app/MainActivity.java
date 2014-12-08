package com.example.test.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnTouchListener {

	public int value = 0;
	
    @SuppressLint("SimpleDateFormat") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => "+c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        // formattedDate have current date/time
        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();

        TextView TvDateTime = (TextView)findViewById(R.id.TvDateTime);
        Button buttChngBg = (Button)findViewById(R.id.butt_ChngBg);
        Button butt_ganda = (Button)findViewById(R.id.button1);
        buttChngBg.setOnClickListener(this);     
        
      // Now we display formattedDate value in TextView
        TvDateTime.setTextSize(15);
        TvDateTime.setText(formattedDate);
       
        butt_ganda.setOnTouchListener(this);
       
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		
		
		RelativeLayout Rl = (RelativeLayout)findViewById(R.id.mainLayout);
		if(value%2 == 0)
		Rl.setBackgroundResource(R.drawable.test_bg2);
		else
			Rl.setBackgroundResource(R.drawable.test_bg);
		
		value++;
	}


	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		
		
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			Toast.makeText(this, "Button Pressed down", Toast.LENGTH_SHORT).show();
        }
        if(event.getAction() == MotionEvent.ACTION_UP)
        {
             //finger was lifted
        	Toast.makeText(this, "Button Pressed up", Toast.LENGTH_SHORT).show();
        }
		// TODO Auto-generated method stub
		return false;
	}
    
}
