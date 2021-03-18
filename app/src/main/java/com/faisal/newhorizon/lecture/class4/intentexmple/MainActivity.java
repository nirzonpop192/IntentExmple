package com.faisal.newhorizon.lecture.class4.intentexmple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSms).setOnClickListener( view -> {
            Uri uri = Uri.parse("smsto:01753264897");
            Intent it = new Intent(Intent.ACTION_SENDTO, uri);
            it.putExtra("sms_body", "Here you can set the SMS text to be sent");
            startActivity(it);
        });

        findViewById(R.id.btnEmail).setOnClickListener( view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, "nirzon192@hotmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Info");
            intent.putExtra(Intent.EXTRA_TEXT, "Need help");

            startActivity(Intent.createChooser(intent, "Send Email"));
        });

        findViewById(R.id.btnMap).setOnClickListener( view -> {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?saddr= 23.8223482,90.3654215&daddr= 23.8223482,90.4654215"));
            startActivity(intent);

        });

        findViewById(R.id.btnWhatup).setOnClickListener(view -> {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
            startActivity(launchIntent);
        });

    }
}
