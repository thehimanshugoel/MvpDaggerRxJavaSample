package himanshugoel.com.githubusers.GitHubUsersActivity;


import dagger.Module;
import dagger.Provides;
import himanshugoel.com.githubusers.Api.GithubUserService;
import himanshugoel.com.githubusers.Scopes.ActivityScope;
import retrofit2.Retrofit;

@Module
public class APiModule {

    @ActivityScope
    @Provides
    GithubUserService getService(Retrofit retrofit) {
        //Here Retrofit is provided in parameter because in GithubActivityComponent , we tell dagger to look for dependency of Retrofit
        //in the main application component class where we have exposed the retrofit to the public

        return retrofit.create(GithubUserService.class);
    }
}
