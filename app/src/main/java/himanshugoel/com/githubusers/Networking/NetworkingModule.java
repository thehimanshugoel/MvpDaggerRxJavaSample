package himanshugoel.com.githubusers.Networking;

import dagger.Module;
import dagger.Provides;
import himanshugoel.com.githubusers.Scopes.ApplicationScope;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class NetworkingModule {

    @Provides
    @ApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

    }


    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor1 = new HttpLoggingInterceptor();
        httpLoggingInterceptor1.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor1;
    }
}
