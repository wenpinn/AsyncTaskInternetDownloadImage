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
        internetTask=new InternetTask(webResultText);
        internetTask.execute("http://www.google.com");
    }
}
