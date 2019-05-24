package com.example.lab7e6;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;


public class SendActivity extends Activity {
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    private EditText sendToView;
    private EditText messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_layout);
        this.sendToView = findViewById(R.id.PhoneNumber);
        this.messageView = findViewById(R.id.messageView);
    }


    public void onSendClick(View view) {
        requestPermission();
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_CODE_ASK_PERMISSIONS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    Toast.makeText(SendActivity.this, "SNS Permission Granted", Toast.LENGTH_SHORT).show();
                    sendSNS();

                } else {
                    // Permission Denied
                    Toast.makeText(SendActivity.this, "SNS Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void sendSNS() {
        try {
            String to = this.sendToView.getText().toString();
            String message = this.messageView.getText().toString();

            if (to.length() > 0 && message.length() > 0) {
                SmsManager SMS = SmsManager.getDefault();
                SMS.sendTextMessage(to, null, message, null, null);
                Toast.makeText(SendActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SendActivity.this, "no phone number or message", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(SendActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
        }
    }

}
