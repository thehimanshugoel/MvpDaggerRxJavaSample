package himanshugoel.com.githubusers.GitHubUsersActivity;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import himanshugoel.com.githubusers.Qualifiers.ActivityContext;
import himanshugoel.com.githubusers.Scopes.ActivityScope;

@Module
public class GithubUserActivityContextModule {

    public Context context;
    GithubUsersActivity githubUsersActivity;


    GithubUserActivityContextModule(GithubUsersActivity githubUsersActivity) {
        this.githubUsersActivity = githubUsersActivity;
        context = githubUsersActivity;
    }


    @Provides
    @ActivityScope
    public GithubUsersActivity githubUsersActivity() {
        return githubUsersActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }


}
