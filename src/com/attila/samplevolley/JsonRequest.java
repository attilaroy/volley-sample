package com.attila.samplevolley;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import com.android.volley.Cache.Entry;
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
				
		RequestQueue queue = VolleyHandler.getRequestQueue();
			
			MainActivity.showProgressDialog(JsonRequest.this);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Method.GET, 
                                                Constants.JSON_URL,
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
