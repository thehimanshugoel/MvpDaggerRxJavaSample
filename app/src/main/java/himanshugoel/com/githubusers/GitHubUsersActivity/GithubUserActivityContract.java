package himanshugoel.com.githubusers.GitHubUsersActivity;

import java.util.List;

import himanshugoel.com.githubusers.Model.GithubUsers;

public interface GithubUserActivityContract {


    interface View {
        public void showError(String message);

        public void showData(List<GithubUsers> githubUsers);

        public void showProgressBar();

        public void hideProgressBar();

    }

    interface Presenter {
        public void loadData();
    }
}
