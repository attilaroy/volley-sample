package com.attila.samplevolley;



import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.attila.samplevolley.application.VolleyHandler;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageLoading extends Activity{
	ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_loader);
		imageView = (ImageView) findViewById(R.id.imageview_image_loader);
		
		//MainActivity.showProgressDialog(ImageLoading.this);
		
		ImageLoader imgLoader = VolleyHandler.getImageLoader();
		imgLoader.get("http://blog.appliedis.com/wp-content/uploads/2013/11/android1.png", 
				ImageLoader.getImageListener(imageView, 
                                                     R.drawable.ic_launcher, 
                                                     R.drawable.warning));
	}

}
