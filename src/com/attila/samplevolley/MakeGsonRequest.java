package com.attila.samplevolley;

import com.android.volley.RequestQueue;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.attila.samplevolley.application.VolleyHandler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MakeGsonRequest extends Activity implements OnClickListener{
	Button buttonGsonRequest;
	TextView textViewGsonRequest;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gson_request);
		buttonGsonRequest = (Button) findViewById(R.id.button_gson_request);
		textViewGsonRequest = (TextView) findViewById(R.id.textview_gson_request);
		buttonGsonRequest.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		MainActivity.showProgressDialog(MakeGsonRequest.this);
		RequestQueue queue = VolleyHandler.getRequestQueue();
		GsonRequest<GsonClass> myReq = new GsonRequest<GsonClass>(Method.GET,
                Constants.JSON_URL,
                GsonClass.class,
                successListener(),
                errorListener());
queue.add(myReq);
	}
	
	private Response.Listener<GsonClass> successListener() {
        return new Response.Listener<GsonClass>() {
            @Override
            public void onResponse(GsonClass response) {
            	MainActivity.dismissProgressDialog();
            	textViewGsonRequest.setText("Name: " + response.name);
            }
        };
    }
    
    
    private Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            	textViewGsonRequest.setText(error.getMessage());
            }
        };
    }
	
	
}
