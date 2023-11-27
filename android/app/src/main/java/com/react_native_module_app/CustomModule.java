package com.react_native_module_app;

import android.widget.Toast;

import androidx.annotation.NonNull;

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
        Toast.makeText(applicationContext, "Welcome to react-native world!!", Toast.LENGTH_SHORT).show();
    }
    
    @NonNull
    @Override
    public String getName() {
        return "CustomModule";
    }
}
