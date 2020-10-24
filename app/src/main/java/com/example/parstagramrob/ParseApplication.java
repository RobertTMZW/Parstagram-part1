package com.example.parstagramrob;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("1h4cLzIfFcx15rwwsKDJYyylxgfGq07H6dZcaFlf")
                .clientKey("SBTFB40CFAC5nHcLfFKZjdOknSjHoeVKZRSshcZV")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
