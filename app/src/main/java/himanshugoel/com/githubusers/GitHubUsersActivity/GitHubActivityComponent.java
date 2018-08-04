package himanshugoel.com.githubusers.GitHubUsersActivity;

import android.content.Context;

import dagger.Component;
import himanshugoel.com.githubusers.Application.MainApplicationComponent;
import himanshugoel.com.githubusers.Qualifiers.ActivityContext;
import himanshugoel.com.githubusers.Scopes.ActivityScope;

@ActivityScope
@Component(modules = {GithubUserActivityContextModule.class, GithubUserMvpModule.class, APiModule.class, AdapterModule.class}, dependencies = MainApplicationComponent.class)
public interface GitHubActivityComponent {
    //Here we are using dependencies from another component MainApplicationComponent because our ApiModule class requires Retrofit instance
    //which is provided by the MainApplicationComponent.


    @ActivityContext
    Context getContext();


    public void inject(GithubUsersActivity githubUsersActivity);
}
