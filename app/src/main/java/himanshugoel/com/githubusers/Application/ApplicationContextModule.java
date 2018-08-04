package himanshugoel.com.githubusers.Application;


import android.content.Context;

import dagger.Module;
import dagger.Provides;
import himanshugoel.com.githubusers.Qualifiers.ApplicationContext;
import himanshugoel.com.githubusers.Scopes.ApplicationScope;

@Module
public class ApplicationContextModule {

    private Context context;

    public ApplicationContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }


}
