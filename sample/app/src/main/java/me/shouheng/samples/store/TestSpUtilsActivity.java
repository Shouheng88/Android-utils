package me.shouheng.samples.store;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.shouheng.samples.R;
import me.shouheng.utils.store.KV;
import me.shouheng.utils.ui.ToastUtils;

public class TestSpUtilsActivity extends AppCompatActivity {

    private static final String NEW_SP_FILE_NAME = "sp_references";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sp_utils);
    }

    public void writeString2DefaultSP(View view) {
        KV.get().put("default_string", "default_string_value");
        ToastUtils.showShort(KV.get().getString("default_string"));
    }

    public void writeBoolean2DefaultSP(View view) {
        KV.get().put("default_boolean", true);
        ToastUtils.showShort("" + KV.get().getBoolean("default_boolean"));
    }

    public void writeInteger2DefaultSP(View view) {
        KV.get().put("default_integer", 12);
        ToastUtils.showShort("" + KV.get().getInt("default_integer"));
    }

    public void writeString2SP(View view) {
        KV.get(NEW_SP_FILE_NAME).put("sp_string", "default_string_value");
        ToastUtils.showShort(KV.get(NEW_SP_FILE_NAME).getString("sp_string"));
    }

    public void writeBoolean2SP(View view) {
        KV.get(NEW_SP_FILE_NAME).put("sp_boolean", true);
        ToastUtils.showShort("" + KV.get(NEW_SP_FILE_NAME).getBoolean("sp_boolean"));
    }

    public void writeInteger2SP(View view) {
        KV.get(NEW_SP_FILE_NAME).put("sp_integer", 12);
        ToastUtils.showShort("" + KV.get(NEW_SP_FILE_NAME).getInt("sp_integer"));
    }
}
