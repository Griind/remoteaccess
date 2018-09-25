package svitukha.remoteaccess;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OnOfActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_of);
        findViewById(R.id.main_btn).setOnClickListener(this);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    OkHttpClient client = new OkHttpClient();

    @Override
    public void onClick(View v) {
        final Request request = new Request.Builder()
                .url("http://192.168.0.3:80/OpenDoor")
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();
                    Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}






//
//        String response = "";
//        try {
//         response =  new OkHttp().run();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();


//    public class MyRequest extends StringRequest {
//        public MyRequest(String url, Response.Listener<String> listener,
//                         Response.ErrorListener errorListener) {
//            super(url, listener, errorListener);
//            setRetryPolicy(new DefaultRetryPolicy(5000,
//                    1000, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        }
//    }

//    private void OpenDoor() {
//
//        String url = "http://192.168.0.3/OpenDoor";
//        final RequestQueue requestQueue = Volley.newRequestQueue(OnOfActivity.this);
//        requestQueue.start();
//        MyRequest stringRequest = new MyRequest(url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
//                        requestQueue.stop();
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
////                    String message = null;
////                    if (volleyError instanceof NetworkError) {
////                        message = "Cannot connect to Internet...Please check your connection!1";
////                        volleyError.printStackTrace();
////                    } else if (volleyError instanceof ServerError) {
////                        message = "The server could not be found. Please try again after some time!!2";
////                    } else if (volleyError instanceof AuthFailureError) {
////                        message = "Cannot connect to Internet...Please check your connection!3";
////                    } else if (volleyError instanceof ParseError) {
////                        message = "Parsing error! Please try again after some time!!4";
////                    } else if (volleyError instanceof NoConnectionError) {
////                        message = "Cannot connect to Internet...Please check your connection!5";
////                    } else if (volleyError instanceof TimeoutError) {
////                        message = "Connection TimeOut! Please check your internet connection.6";
////                    }
////                    Toast.makeText(getApplicationContext(), "Error: " + message, Toast.LENGTH_LONG).show();
//            }
//        });
//
//        requestQueue.add(stringRequest);
//
//
//    }

