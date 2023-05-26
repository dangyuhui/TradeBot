package system;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author yhdang
 * @date 2023/5/22 18:00
 */
public class OAuthInterceptor implements Interceptor {


    private final String username;
    private final String password;

    public OAuthInterceptor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        String credentials = username + ":" + password;

        Request originalRequest = chain.request();
        HttpUrl url = originalRequest.url();
        System.out.println("111111111111 " + url);

        String cacheControl = originalRequest.cacheControl().toString();
        System.out.println("2222222222222222222 " + cacheControl);
        return chain.proceed(originalRequest);
    }
}
