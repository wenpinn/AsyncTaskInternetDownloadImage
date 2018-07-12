package tools.wpfang.asynctaskinternet;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InternetTask extends AsyncTask<String,Void,String> {
    TextView resultText;
    public InternetTask(TextView tv)
    {
        resultText=tv;
    }
    @Override
    protected String doInBackground(String... strings) {
        String strUrl=strings[0];
        InputStream fin=null;
        String result_Txt="";
        try {
            URL myUrl=new URL(strUrl);
            HttpURLConnection con=(HttpURLConnection) myUrl.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(20000);
            con.connect();

            fin=con.getInputStream();
            BufferedReader bfRead=new BufferedReader((new InputStreamReader(fin)));
            String line="";
            while((line=bfRead.readLine())!=null)
            {
                result_Txt+=line+"   \n";
            }

            bfRead.close();
            fin.close();
            return result_Txt;
        } catch (Exception e) {
            e.printStackTrace();
            return "No Data";
        }
    }

    @Override
    protected void onPostExecute(String s) {
        resultText.setText(s);
    }
}
