package himanshugoel.com.githubusers.GitHubUsersActivity;

import dagger.Module;
import dagger.Provides;
import himanshugoel.com.githubusers.Scopes.ActivityScope;

@Module
public class GithubUserMvpModule {

    private final GithubUserActivityContract.View view;

    GithubUserMvpModule(GithubUserActivityContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public GithubUserActivityContract.View view() {
        return view;
    }

}
