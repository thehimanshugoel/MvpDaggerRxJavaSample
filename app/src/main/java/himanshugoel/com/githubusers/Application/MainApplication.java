package himanshugoel.com.githubusers.Application;

import android.app.Activity;
import android.app.Application;

public class MainApplication extends Application {
    MainApplicationComponent mainApplicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mainApplicationComponent = DaggerMainApplicationComponent.builder().applicationContextModule(new ApplicationContextModule(this)).build();
        mainApplicationComponent.injectApplication(this);
    }

    public static MainApplication get(Activity activity){
        return (MainApplication) activity.getApplication();
    }

    public MainApplicationComponent getApplicationComponent() {
        return mainApplicationComponent;
    }


}
