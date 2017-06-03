package raviwan.trongtum.ponpitoon.msccheck;

import android.content.Context;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by User on 3/6/2560.
 */

public class PostNewUser extends AsyncTask<String, Voice, String>{

    private Context context;

    public PostNewUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Image", params[0])
                    .add("StudentID", params[1])
                    .add("Title", params[2])
                    .add("Name", params[3])
                    .add("Year", params[4])
                    .add("User", params[5])
                    .add("Password", params[6])
                    .add("Major", params[7])
                    .add("Class", params[8])
                    .add("Phone", params[9])
                    .add("Email", params[10])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[11]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("3JuneV1", "E doin ==>" + e.toString());
            return null;
        }


    }
}   // Main Class
