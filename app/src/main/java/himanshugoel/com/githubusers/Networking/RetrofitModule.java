package himanshugoel.com.githubusers.Networking;

import dagger.Module;
import dagger.Provides;
import himanshugoel.com.githubusers.Scopes.ApplicationScope;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkingModule.class)
public class RetrofitModule {

    @Provides
    @ApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okHttpClient)
                .build();
    }


}
