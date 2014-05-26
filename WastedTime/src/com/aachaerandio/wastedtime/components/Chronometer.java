package com.aachaerandio.wastedtime.components;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import com.aachaerandio.wastedtime.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Araceli
 */
public class Chronometer extends TextView {
	
	private Timer timer;
    private Context context;
    private long startTime;
    private long elapsedTime;
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
       start(0);
    }
    
    public void start(long startingTime) {
        timer = new Timer();
        startTime = System.currentTimeMillis()-startingTime;
        elapsedTime = startingTime;
        timer.scheduleAtFixedRate(new TimerTask() {
             
            @Override
            public void run() {
            	 ((Activity) context).runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						elapsedTime = System.currentTimeMillis() - startTime;
						String text = formatTime(elapsedTime);
				       	
				       	Chronometer.this.setText(text);  
					}
				});               
            }
        }, DELAYTIME, INTERVALTIME);
         
    }
    
    public long getElapsedTime() {
		return elapsedTime;
	}

	public void stop() {
    	timer.cancel();
	}

	public static String formatTime(long time) {
		DecimalFormat df = new DecimalFormat("00");
		long hours = 0;
		long min = 0;
		long sec = 0;
		long mill = 0;
		 
		if (time >= 1000) {
			//Calcula las horas que han pasado
		    hours = time / (3600 * 1000);
		    //Guarda el resto, menor que 1h	
		    long remaining = (time % (3600 * 1000));
		    
		    //Calcula los minutos que han pasado
		    min = remaining / (60 * 1000);
		    //Guarda el resto menor que 1min
		    remaining = remaining % (60 * 1000);
		    
		    //Calcula los seg que han pasado
		    sec = remaining / 1000;
		    //Guarda el resto menor que 1 seg
		    remaining = remaining % (1000);
		    
		    //El resto en millis
		    mill = (time % 1000) / 10;
		}
		else {
			//El tiempo en millis
		    mill = (time % 1000) / 10;
		}

		String text = "";
		
		if (hours > 0) {
			text += df.format(hours) + ":";
		}
		
		text += df.format(min) + ":";
		text += df.format(sec) + ",";
		text += df.format(mill);
		return text;
	}

	public static String formatShare (long time) {
		DecimalFormat df = new DecimalFormat("0");
		long hours = 0;
		long min = 0;
		long sec = 0;
		long mill = 0;
		 
		if (time >= 1000) {
			//Calcula las horas que han pasado
		    hours = time / (3600 * 1000);
		    //Guarda el resto, menor que 1h	
		    long remaining = (time % (3600 * 1000));
		    
		    //Calcula los minutos que han pasado
		    min = remaining / (60 * 1000);
		    //Guarda el resto menor que 1min
		    remaining = remaining % (60 * 1000);
		    
		    //Calcula los seg que han pasado
		    sec = remaining / 1000;
		    //Guarda el resto menor que 1 seg
		    remaining = remaining % (1000);
		    
		    //El resto en millis
		    mill = (time % 1000) / 10;
		}
		else {
			//El tiempo en millis
		    mill = (time % 1000) / 10;
		}

		String text = "";
		
		if (hours > 0) {
			text += df.format(hours) + "h ";
		}

		if (min > 0) {
			text += df.format(min) + "m ";
		}
		
		text += df.format(sec) + "s";
		return text;
	}

	public void reset() {
		setText(getResources().getString(R.string.chrono));
	}
        	
}
