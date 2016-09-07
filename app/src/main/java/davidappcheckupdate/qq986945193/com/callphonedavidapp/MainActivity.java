package davidappcheckupdate.qq986945193.com.callphonedavidapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub:https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @交流Qq ：986945193
 */
public class MainActivity extends AppCompatActivity {

    private EditText etPhone;
    private Button btnPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPhone = (EditText) findViewById(R.id.et_phone_num);
        btnPhone = (Button) findViewById(R.id.btn_call_phone);

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPhone.getText().toString().trim() == null || etPhone.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "对不起，电话不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else if (etPhone.getText().toString().trim() != null && !(etPhone.getText().toString().trim().equals(""))) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                            + etPhone.getText().toString().trim()));
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(intent);

                }
            }
        });
    }
}
