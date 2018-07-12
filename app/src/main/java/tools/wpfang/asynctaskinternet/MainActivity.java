package tools.wpfang.asynctaskinternet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView webResultText;
    InternetTask internetTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webResultText=findViewById(R.id.web_result);
    }

    public void doWebConnect(View view) {
        internetTask=new InternetTask(this,webResultText);
       // internetTask.execute("http://140.138.146.85/publish.htm");
        internetTask.execute(" https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0002-001?Authorization=rdec-key-123-45678-011121314");
    }
}
