package himanshugoel.com.githubusers.Application;

import android.content.Context;

import dagger.Component;
import himanshugoel.com.githubusers.Networking.RetrofitModule;
import himanshugoel.com.githubusers.Qualifiers.ApplicationContext;
import himanshugoel.com.githubusers.Scopes.ApplicationScope;
import retrofit2.Retrofit;

@ApplicationScope
@Component(modules = {ApplicationContextModule.class, RetrofitModule.class})
public interface MainApplicationComponent {

    @ApplicationContext
    Context getContext();

    Retrofit getRetrofit();


    void injectApplication(MainApplication myApplication);

}
