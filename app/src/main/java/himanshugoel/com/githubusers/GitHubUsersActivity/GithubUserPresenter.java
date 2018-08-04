package himanshugoel.com.githubusers.GitHubUsersActivity;

import java.util.List;

import javax.inject.Inject;

import himanshugoel.com.githubusers.Api.GithubUserService;
import himanshugoel.com.githubusers.Model.GithubUsers;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GithubUserPresenter implements GithubUserActivityContract.Presenter {
    @Inject
    GithubUserService githubUserService;

    private GithubUserActivityContract.View view;


    @Inject
    GithubUserPresenter(GithubUserActivityContract.View view) {
        this.view = view;

    }

    @Override
    public void loadData() {

        githubUserService.getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GithubUsers>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<GithubUsers> githubUsers) {
                        view.showData(githubUsers);

                    }
                });


    }
}
