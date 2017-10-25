package myapplication7.myapplication7;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/**
 * Created by Bare on 2017/10/25.
 */

public class CacheInterceptor implements Interceptor{

    public String checkNULL;

    @Override
    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//        Response response = chain.proceed(request);
//        String cache = request.header("Cache-Time");
//        if (Util.checkNULL(cache)) {
//            return response;
//        } else {
//            Response response1 = response.newBuilder()
//                    .removeHeader("Pragma")
//                    .removeHeader("Cache-Control")
//                    .header("Cache-Control", "max-age="+cache)
//                    .build();
//            return response1;
//        }
        return null;
    }
}
