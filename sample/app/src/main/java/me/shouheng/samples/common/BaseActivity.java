package me.shouheng.samples.common;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.shouheng.utils.app.ActivityUtils;
import me.shouheng.utils.permission.PermissionResultHandler;
import me.shouheng.utils.permission.PermissionResultResolver;
import me.shouheng.utils.permission.callback.OnGetPermissionCallback;
import me.shouheng.utils.permission.callback.PermissionResultCallbackImpl;

public abstract class BaseActivity extends AppCompatActivity implements PermissionResultResolver {

    private OnGetPermissionCallback onGetPermissionCallback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.addToList(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionResultHandler.handlePermissionsResult(this, requestCode, permissions, grantResults,
                new PermissionResultCallbackImpl(this, onGetPermissionCallback));
    }

    @Override
    public void setOnGetPermissionCallback(OnGetPermissionCallback onGetPermissionCallback) {
        this.onGetPermissionCallback = onGetPermissionCallback;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtils.removeFromList(this);
    }
}
