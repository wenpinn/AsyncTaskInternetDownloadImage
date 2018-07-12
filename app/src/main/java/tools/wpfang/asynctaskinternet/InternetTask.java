package tools.wpfang.asynctaskinternet;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InternetTask extends AsyncTask<String,Void,Bitmap> {
    private ImageView resultText;
    Bitmap bmp;
    private ProgressDialog pd;
    private Context ctx=null;
    String json_txt;
    public InternetTask(Context ct,ImageView tv)
    {
        ctx=ct;
        resultText=tv;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(ctx);
        pd.setTitle("Download");
        pd.setMessage("downloading");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
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
            bmp= BitmapFactory.decodeStream(fin);
         //   result_Txt=json_txt+result_Txt;
            fin.close();
            return bmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap s) {
       // resultText.setText(Html.fromHtml(s));
        resultText.setImageBitmap(s);
        pd.dismiss();
    }
}
