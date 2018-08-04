package himanshugoel.com.githubusers.GitHubUsersActivity;


import dagger.Module;
import dagger.Provides;
import himanshugoel.com.githubusers.Adapter.GithubAdapter;
import himanshugoel.com.githubusers.Scopes.ActivityScope;

@Module
public class AdapterModule {

    @Provides
    @ActivityScope
    public GithubAdapter githubAdapter() {
        return new GithubAdapter();
    }

}
