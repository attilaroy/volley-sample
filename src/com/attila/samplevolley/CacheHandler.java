package com.attila.samplevolley;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Cache.Entry;
import com.attila.samplevolley.application.VolleyHandler;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CacheHandler extends Activity implements OnClickListener{
	Button btnJsonCache,btnImageCache;
	TextView tvJsonCache,tvImageCache;
	ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_cache);
		intializeUI();
		btnJsonCache.setOnClickListener(this);
	}
	
	public void intializeUI() {
		btnJsonCache = (Button) findViewById(R.id.button_json_cache);
		tvJsonCache = (TextView) findViewById(R.id.textview_json_cache);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		RequestQueue queue = VolleyHandler.getRequestQueue();
		
		if(v.getId() == R.id.button_json_cache) {
		Entry entry = queue.getCache().get(Constants.JSON_URL);
		if(entry!=null){
			
			try {
				String data = new String(entry.data, "UTF-8");
				
				try {
					JSONObject mainObject = new JSONObject(data);
					String name = (String) mainObject.get("name");
					tvJsonCache.setText(name);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     // process data
		}
		else {
			tvJsonCache.setText("Make Json Request first and click again Cache Example");
		}
		}
		
		
//		else if(v.getId() == R.id.button_image_cache){
//			//Log.e("xgd", "zsdgsg");
//			//tvImageCache.setVisibility(View.VISIBLE);
//			BitmapLruCache bitmapLruCache = new BitmapLruCache(VolleyHandler.cacheSize);
//			Bitmap image = bitmapLruCache.getBitmap(Constants.IMAGE_URL);
//			
//			if(image != null) {
//				imageView.setVisibility(View.VISIBLE);
//				imageView.setImageBitmap(image);
//			} else {
//				System.out.println("cache has no image");
//			}
//			
//		}
		
	}
}
