package me.shouheng.samples.ui;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import me.shouheng.samples.R;
import me.shouheng.utils.ui.ToastUtils;

public class TestToastUtilsActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toast_utils);
    }

    public void showToast(View view) {
        ToastUtils.showShort("Toast_"  + count++);
    }

    public void showCustomMsgToast(View view) {
        ToastUtils.setMsgColor(Color.GREEN);
        ToastUtils.setMsgTextSize(20);
        ToastUtils.showShort("Toast_"  + count++);
    }

    public void showCenterToast(View view) {
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.showShort("Toast_"  + count++);
    }

    public void cancelToast(View view) {
        ToastUtils.cancel();
    }
}
