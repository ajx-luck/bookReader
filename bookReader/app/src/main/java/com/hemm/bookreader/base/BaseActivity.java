package com.hemm.bookreader.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Administrator on 2017/5/21.
 */

public abstract class BaseActivity extends AppCompatActivity {



    public <K extends View> K findId(int id){
        return (K) findViewById(id);
    }
}
