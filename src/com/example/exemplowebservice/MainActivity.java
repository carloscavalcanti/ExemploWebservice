package com.example.exemplowebservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button botao = (Button) findViewById(R.id.button1);
		botao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost("URL");

				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					nameValuePairs.add(new BasicNameValuePair("parametro", "valor"));

					httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					HttpResponse response = httpclient.execute(httpPost);
					System.out.println("response code: " + response.getStatusLine().getStatusCode());
					System.out.println("texto: " + EntityUtils.toString(response.getEntity()));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
