package myapplication7.myapplication7.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Bare on 2017/10/25.
 */

public class Fragment2Model {
    public void getData(String path, final Fragment2ModelListener listener){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(path)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                listener.success(response.body().string());
            }
        });
    }
}
