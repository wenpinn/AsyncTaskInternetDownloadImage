package tools.wpfang.asynctaskinternet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView webResultText;
    InternetTask internetTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webResultText=findViewById(R.id.imageView);
    }

    public void doWebConnect(View view) {
        internetTask=new InternetTask(this,webResultText);
       // internetTask.execute("http://140.138.146.85/publish.htm");
       // internetTask.execute(" https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0002-001?Authorization=rdec-key-123-45678-011121314");
        internetTask.execute("http://wallscollection.net/wp-content/uploads/2016/12/Collection-of-Cool-Background-Images.jpg");
    }
}
