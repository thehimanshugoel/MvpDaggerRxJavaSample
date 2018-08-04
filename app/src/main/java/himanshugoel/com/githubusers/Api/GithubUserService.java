package himanshugoel.com.githubusers.Api;

import java.util.List;

import himanshugoel.com.githubusers.Model.GithubUsers;
import retrofit2.http.GET;
import rx.Observable;

public interface GithubUserService {

    @GET("/users")
    Observable<List<GithubUsers>> getData();


}
