package com.attila.samplevolley;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.attila.samplevolley.application.VolleyHandler;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

public class JsonRequest extends Activity{
	TextView tvName;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json_request);
		tvName = (TextView)findViewById(R.id.textview_name);
		MainActivity.showProgressDialog(JsonRequest.this);
		
		RequestQueue queue = VolleyHandler.getRequestQueue();
        
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Method.GET, 
                                                "http://echo.jsontest.com/key/value/name/arun",
                                                null,
                                                SuccessListener(),
                                                ErrorListener());

        queue.add(jsonRequest);
        
	}
	
	private Response.Listener<JSONObject> SuccessListener() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
            	MainActivity.dismissProgressDialog();
                try {
                	tvName.setText(response.getString("name"));
                } catch (JSONException e) {
                	tvName.setText("error");
                }
            }
        };
    }
    
    
    private Response.ErrorListener ErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            	MainActivity.dismissProgressDialog();
            	tvName.setText(error.getMessage());
            }
        };
    }

}
