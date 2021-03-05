package com.codpath.instaclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    //initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        //register your pare models
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("F0YIVtyen7equgj9e3tXF524tNSTlyOL5cXYa3Zr")
                .clientKey("9sINJraJdRtuQEPXGNlvi9bzXT7ruP6di4dPaQYD")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
