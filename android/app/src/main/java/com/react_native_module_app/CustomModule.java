package com.react_native_module_app;

import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CustomModule extends ReactContextBaseJavaModule {

    private static ReactApplicationContext applicationContext;

    public CustomModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        applicationContext = reactApplicationContext;
    }

    @ReactMethod
    public void displaytost(){
        Toast.makeText(applicationContext, "Clicked successfully!!", Toast.LENGTH_SHORT).show();
    }

    @ReactMethod
    public void getDeviceId (Promise promise) {
        try {
            String android_id = Settings.Secure.getString(applicationContext.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            promise.resolve(android_id);
        }catch (Exception exception){
            promise.reject("error", exception);
        }
    }
    
    @NonNull
    @Override
    public String getName() {
        return "CustomModule";
    }
}
