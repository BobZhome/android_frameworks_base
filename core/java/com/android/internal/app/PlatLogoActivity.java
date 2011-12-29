/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class PlatLogoActivity extends Activity {
    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final String text;
        final int resource;
        if (getIntent().getStringExtra("special").equals("douche")) {
            text = "Brought to you by your friends at TeamDouche";
            resource = com.android.internal.R.drawable.tdyacht;
        }else{
          if (getIntent().getStringExtra("special").equals("bobz")) {
              text = "Thanks for the awesome kernel Bob!";
              resource = com.android.internal.R.drawable.bobzhome;
          }else{
            if (getIntent().getStringExtra("special").equals("cassini")) {
                text = "Actual photo of Saturn taken by Cassini";
                resource = com.android.internal.R.drawable.saturn;
            }else{
              if (getIntent().getStringExtra("special").equals("blarf")) {
                  text = "Thanks Blarf! +1";
                  resource = com.android.internal.R.drawable.ihologo;
              }else{
                if (getIntent().getStringExtra("special").equals("xmas")) {
                    text = "Happy New Year!";
                    resource = com.android.internal.R.drawable.newyears;
                }else{
                    text = "Zombie art by Jack Larson";
                    resource = com.android.internal.R.drawable.platlogo;
                }
              }
            }
          }
        }
        
        mToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        ImageView content = new ImageView(this);
        content.setImageResource(resource);
        content.setScaleType(ImageView.ScaleType.FIT_CENTER);
        
        setContentView(content);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            mToast.show();
        }
        return super.dispatchTouchEvent(ev);
    }
}
