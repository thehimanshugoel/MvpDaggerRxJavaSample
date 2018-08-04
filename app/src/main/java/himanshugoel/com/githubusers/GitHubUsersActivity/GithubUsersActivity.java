package himanshugoel.com.githubusers.GitHubUsersActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import himanshugoel.com.githubusers.Adapter.GithubAdapter;
import himanshugoel.com.githubusers.Application.MainApplication;
import himanshugoel.com.githubusers.Application.MainApplicationComponent;
import himanshugoel.com.githubusers.Model.GithubUsers;
import himanshugoel.com.githubusers.Qualifiers.ActivityContext;
import himanshugoel.com.githubusers.Qualifiers.ApplicationContext;
import himanshugoel.com.githubusers.R;

public class GithubUsersActivity extends AppCompatActivity implements GithubUserActivityContract.View {
    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Inject
    GithubUserPresenter presenter;

    @Inject
    GithubAdapter githubAdapter;

    GitHubActivityComponent gitHubActivityComponent;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainApplicationComponent applicationComponent = MainApplication.get(this).getApplicationComponent();
        gitHubActivityComponent = DaggerGitHubActivityComponent.builder()
                .githubUserActivityContextModule(new GithubUserActivityContextModule(this))
                .githubUserMvpModule(new GithubUserMvpModule(this))
                .mainApplicationComponent(applicationComponent)
                .build();

        gitHubActivityComponent.inject(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(githubAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));

        presenter.loadData();


    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showData(List<GithubUsers> githubUsers) {
        githubAdapter.setItems(githubUsers);


    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
