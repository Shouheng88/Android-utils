package me.shouheng.samples.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import me.shouheng.samples.R;
import me.shouheng.utils.data.TimeUtils;
import me.shouheng.utils.ui.ToastUtils;

import static android.text.format.DateUtils.*;

public class TestTimeUtilsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_time_utils);

        long now = TimeUtils.now();
        TextView tv = findViewById(R.id.tv);
        final String info = TimeUtils.toString(now, new SimpleDateFormat("yyyy MMM dd E hh:mm a", Locale.getDefault())) + "\n"
                + "FORMAT_ABBREV_TIME: " + TimeUtils.toString(now, FORMAT_ABBREV_TIME) + "\n"
                + "FORMAT_ABBREV_WEEKDAY: " + TimeUtils.toString(now, FORMAT_ABBREV_WEEKDAY) + "\n"
                + "FORMAT_ABBREV_MONTH: " + TimeUtils.toString(now, FORMAT_ABBREV_MONTH) + "\n"
                + "FORMAT_NUMERIC_DATE: " + TimeUtils.toString(now, FORMAT_NUMERIC_DATE) + "\n"
                + "FORMAT_ABBREV_RELATIVE: " + TimeUtils.toString(now, FORMAT_ABBREV_RELATIVE) + "\n"
                + "FORMAT_ABBREV_ALL: " + TimeUtils.toString(now, FORMAT_ABBREV_ALL) + "\n"
                + "FORMAT_SHOW_TIME: " + TimeUtils.toString(now, FORMAT_SHOW_TIME) + "\n"
                + "FORMAT_SHOW_WEEKDAY: " + TimeUtils.toString(now, FORMAT_SHOW_WEEKDAY) + "\n"
                + "FORMAT_SHOW_YEAR: " + TimeUtils.toString(now, FORMAT_SHOW_YEAR) + "\n"
                + "FORMAT_NO_YEAR: " + TimeUtils.toString(now, FORMAT_NO_YEAR) + "\n"
                + "FORMAT_SHOW_DATE: " + TimeUtils.toString(now, FORMAT_SHOW_DATE) + "\n"
                + "FORMAT_NO_MONTH_DAY: " + TimeUtils.toString(now, FORMAT_NO_MONTH_DAY) + "\n"
                + "FORMAT_NO_NOON: " + TimeUtils.toString(now, FORMAT_NO_NOON) + "\n"
                + "FORMAT_CAP_NOON: " + TimeUtils.toString(now, FORMAT_CAP_NOON) + "\n"
                + "FORMAT_NO_MIDNIGHT: " + TimeUtils.toString(now, FORMAT_NO_MIDNIGHT) + "\n"
                + "FORMAT_CAP_MIDNIGHT: " + TimeUtils.toString(now, FORMAT_CAP_MIDNIGHT) + "\n"
                + "FORMAT_ABBREV_MONTH | FORMAT_SHOW_YEAR: \n"
                + TimeUtils.toString(now, FORMAT_ABBREV_MONTH | FORMAT_SHOW_YEAR) + "\n"
                + "FORMAT_SHOW_TIME | FORMAT_SHOW_DATE | FORMAT_ABBREV_ALL: \n"
                + TimeUtils.toString(now, FORMAT_SHOW_TIME | FORMAT_SHOW_DATE | FORMAT_ABBREV_ALL) + "\n"
                + "FORMAT_24HOUR | FORMAT_SHOW_DATE | FORMAT_SHOW_TIME | FORMAT_SHOW_YEAR | LENGTH_LONG | FORMAT_ABBREV_MONTH: \n"
                + TimeUtils.toString(now, FORMAT_24HOUR | FORMAT_SHOW_DATE | FORMAT_SHOW_TIME | FORMAT_SHOW_YEAR | LENGTH_LONG | FORMAT_ABBREV_MONTH) + "\n"
                + "BEGIN OF TODAY: " + TimeUtils.beginOfToday() + "\n"
                + "BEGIN OF WEEK (SUN): " + TimeUtils.beginOfWeek(true) + "\n"
                + "BEGIN OF WEEK: " + TimeUtils.beginOfWeek(false) + "\n"
                + "BEGIN OF MONTH: " + TimeUtils.beginOfMonth() + "\n"
                + "BEGIN OF YEAR: " + TimeUtils.beginOfYear() + "\n"
                + "END OF TODAY: " + TimeUtils.endOfToday() + "\n"
                + "END OF WEEK (SUN): " + TimeUtils.endOfWeek(true) + "\n"
                + "END OF WEEK: " + TimeUtils.endOfWeek(false) + "\n"
                + "END OF MONTH: " + TimeUtils.endOfMonth() + "\n"
                + "END OF YEAR: " + TimeUtils.endOfYear() + "\n"
                ;
        tv.setText(info);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setText(info);
                ToastUtils.showShort("copied");
                return true;
            }
        });
    }
}
