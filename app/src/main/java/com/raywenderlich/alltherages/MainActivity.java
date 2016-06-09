/*
 * Copyright (c) 2015 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.alltherages;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RageComicListFragment.OnRageComicSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {

            if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frameMemeDetail, RageComicDetailsFragment.newInstance(), "memeDetailLand")
                        .add(R.id.frameMemeList, RageComicListFragment.newInstance(), "memeListLand")
                        .commit();



            }
            else
            {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.root_layout, RageComicListFragment.newInstance(), "memeListPort")
                        .commit();
            }
        }
        else
        {
            if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(getSupportFragmentManager().findFragmentByTag("memeListPort"))
                        .replace(R.id.frameMemeDetail, RageComicDetailsFragment.newInstance(), "memeDetailLand")
                        .replace(R.id.frameMemeList, RageComicListFragment.newInstance(), "memeListLand")
                        .commit();


            }
            else
            {

               getSupportFragmentManager()
                        .beginTransaction()
                        .remove(getSupportFragmentManager().findFragmentByTag("memeDetailLand"))
                        .remove(getSupportFragmentManager().findFragmentByTag("memeListLand"))
                        .replace(R.id.root_layout, RageComicListFragment.newInstance(), "memeListPort")
                        .commit();
            }
        }
    }

    @Override
    public void onRageComicSelectedMethod(int imageResId, String name, String description, String url) {
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameMemeDetail, RageComicDetailsFragment.newInstance(imageResId, name, description, url), "memeDetailLand")
                    .commit();
        }else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root_layout, RageComicDetailsFragment.newInstance(imageResId, name, description, url), "memeDetailPort")
                    .addToBackStack(null)
                    .commit();
        }

    }
}
