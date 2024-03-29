package com.example.autolink.textview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.auto.link.textview.AutoLinkMode;
import com.auto.link.textview.AutoLinkOnClickListener;
import com.auto.link.textview.AutoLinkTextView;
import com.sample.autolink.textview.R;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AutoLinkTextView autoLinkTextView = findViewById(R.id.active);

        autoLinkTextView.enableUnderLine();

        // Must to call setAutoLinkModes first
        autoLinkTextView.setAutoLinkModes(
                AutoLinkMode.MODE_HASHTAG,
                AutoLinkMode.MODE_PHONE,
                AutoLinkMode.MODE_URL,
                AutoLinkMode.MODE_EMAIL,
                AutoLinkMode.MODE_MENTION,
                AutoLinkMode.MODE_CUSTOM);

        autoLinkTextView.setCustomModeColor(ContextCompat.getColor(this, R.color.color1));
        autoLinkTextView.setHashtagModeColor(ContextCompat.getColor(this, R.color.color2));
        autoLinkTextView.setPhoneModeColor(ContextCompat.getColor(this, R.color.color3));
        autoLinkTextView.setMentionModeColor(ContextCompat.getColor(this, R.color.color5));

        autoLinkTextView.setCustomRegexMinLength(1);
        autoLinkTextView.addCustomRegex("android");
        autoLinkTextView.addCustomRegex("ios");
        autoLinkTextView.addCustomRegex(".");
        autoLinkTextView.enableUnderLine();

        // Set text after setAutoLinkModes
        autoLinkTextView.setText(getText(R.string.long_text));

        autoLinkTextView.setAutoLinkOnClickListener(new AutoLinkOnClickListener() {
            @Override
            public void onAutoLinkTextClick(AutoLinkMode autoLinkMode, String matchedText) {
                showDialog(autoLinkMode.toString(), matchedText);
            }
        });
    }

    private void showDialog(String title, String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setTitle(title)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
