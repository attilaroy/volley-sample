package com.attila.samplevolley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	Button imageLoader,jsonRequest,gsonParser,getRequest,postRequest;
	static ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intializeUI();
		
		imageLoader.setOnClickListener(this);
		jsonRequest.setOnClickListener(this);
		gsonParser.setOnClickListener(this);
		getRequest.setOnClickListener(this);
		postRequest.setOnClickListener(this);
		
	}
	
   public void intializeUI() {
	imageLoader = (Button) findViewById(R.id.button_image_loading);
	jsonRequest = (Button) findViewById(R.id.button_json_request);
	gsonParser = (Button) findViewById(R.id.button_gson);
	getRequest = (Button) findViewById(R.id.button_get);
	postRequest = (Button) findViewById(R.id.button_post);
   }

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	switch (v.getId()) {
	
	case R.id.button_image_loading: 
		Intent imageIntent = new Intent(MainActivity.this,ImageLoading.class);
		startActivity(imageIntent);		
		break;
		
	case R.id.button_json_request: 
		Intent jsonIntent = new Intent(MainActivity.this,JsonRequest.class);
		startActivity(jsonIntent);
		break;	
		
	case R.id.button_gson: 
		
		break;
		
	case R.id.button_get: 
		
		break;
		
	case R.id.button_post: 
		
		break;

	default:
		break;
	}
}

public static void showProgressDialog(Context context) {
	progressDialog = new ProgressDialog(context);
	progressDialog.setTitle("Sample Volley");
	progressDialog.setMessage("Loading...");
	progressDialog.show();
}

public static void dismissProgressDialog() {
	progressDialog.dismiss();
}




}
