package com.aachaerandio.wastedtime.components;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class Chronometer extends TextView{
	
	private Timer timer;
    private Context context;
    private long startTime;
    private long elapsed;
    private static final long DELAYTIME = 0;
    private static final long INTERVALTIME = 1;
     
     
    public Chronometer(Context context) {
        super(context);
        this.context = context;
    }
 
    public Chronometer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }
 

	public Chronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }
        
    public void start() {
        timer = new Timer();
        startTime = System.currentTimeMillis();
        elapsed = 0L;
        timer.scheduleAtFixedRate(new TimerTask() {
             
            @Override
            public void run() {
            	 ((Activity) context).runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						elapsed = System.currentTimeMillis() - startTime;
						DecimalFormat df = new DecimalFormat("00");
				        long hours = 0;
				        long min = 0;
				        long sec = 0;
				        long mill = 0;
				         
				        if (elapsed >= 1000) {
				        	//Calcula las horas que han pasado
				            hours = elapsed / (3600 * 1000);
				            //Guarda el resto, menor que 1h	
				            long remaining = (elapsed % (3600 * 1000));
				            
				            //Calcula los minutos que han pasado
				            min = remaining / (60 * 1000);
				            //Guarda el resto menor que 1min
				            remaining = remaining % (60 * 1000);
				            
				            //Calcula los seg que han pasado
				            sec = remaining / 1000;
				            //Guarda el resto menor que 1 seg
				            remaining = remaining % (1000);
				            
				            //El resto en millis
				            mill = (elapsed % 1000) / 10;
				        }
				        else {
				        	//El tiempo en millis
				            mill = (elapsed % 1000) / 10;
				        }

				        String text = "";
				        
				        if (hours > 0) {
				        	text += df.format(hours) + ":";
				        }
				        
				       	text += df.format(min) + ":";
				       	text += df.format(sec) + ":";
				       	text += df.format(mill);
				       	
				       	Chronometer.this.setText(text);  
					}
				});               
            }
        }, DELAYTIME, INTERVALTIME);
         
    }
    
    public void stop() {
    	timer.cancel();
	}

        	
}
