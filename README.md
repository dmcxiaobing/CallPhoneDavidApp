# CallPhoneDavidApp
【Android】Android开发初学者实现拨打电话的功能，拨打电话app应用，电话拨号器

作者：程序员小冰，GitHub主页：https://github.com/QQ986945193 

新浪微博：http://weibo.com/mcxiaobing

首先先给大家看一下最终实现的效果:

![这里写图片描述](http://img.blog.csdn.net/20160907102033375)

其实这个案例的demo实在是太简单了。不过此功能也是非常强大，用处挺多的，

就像所谓的蚂蚁虽小，五脏俱全。我们可以用它集成在我们的app中。

拨打客服电话之类的。所以下面看代码吗，首先我们写好布局：

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <EditText
        android:id="@+id/et_phone_num"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:hint="请输入手机号码" />

    <Button
        android:id="@+id/btn_call_phone"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="点击拨打电话" />
</LinearLayout>

```

然后java代码中实现拨打电话的功能
```
`package davidappcheckupdate.qq986945193.com.callphonedavidapp;

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
`
```
最后重要的一点就是，添加拨打电话的权限在AndroidManifest.xml：

```
 <uses-permission android:name="android.permission.CALL_PHONE" />

```
好了，介绍到此结束。直接运行项目文件即可看到上面的效果。如果对您有帮助，欢迎star，fork。。。
