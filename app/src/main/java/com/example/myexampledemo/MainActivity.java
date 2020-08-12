package com.example.myexampledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ThemedSpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.
                LayoutParams.FLAG_FULLSCREEN);
*/        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

           // we make a progressDialouge
           // lets start
        // making a inOne method to not mess the onCreate method

        inOne();


    }
    public void inOne(){
        button  = findViewById(R.id.buttonId);

        // set listener
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ///wwwwwww haha

                 // progressDialog is a class
                 final ProgressDialog progressDialog =
                         new ProgressDialog(MainActivity.this);

                 progressDialog.setTitle("Progress Load");
                 progressDialog.setMessage("loading .....");
                 progressDialog.setMax(100);
                 progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                 progressDialog.show();
                 // when touch outside the progress stop
                 progressDialog.setCanceledOnTouchOutside(false);// by deafult it true
                 // it take some time
                 // now make a slow moton to progress

                 Thread thread = new Thread(new Runnable() {
                     @Override
                     public void run() {
                        // Thread.sleep(200);
                         // make some codition
                         while (progressDialog.getProgress() <= progressDialog.getMax()){

                             try {
                                 Thread.sleep(200);

                                 progressDialog.incrementProgressBy(1);// it can be 2or 3

                                 if(progressDialog.getProgress()==progressDialog.getMax())
                                 {
                                     progressDialog.dismiss();
                                 }

                             } catch (InterruptedException e) {
                                 e.printStackTrace();
                             }
                  }

                     }
                 });
                 thread.start();

             }
         });

    }


}

// there are so different in progressdialog and proressBar
           // so google it