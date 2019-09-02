package com.sagar.android.servicedemo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.filter.Filter
import com.zhihu.matisse.listener.OnSelectedListener


class MainActivity : AppCompatActivity() {

    private lateinit var serviceIntent: Intent

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serviceIntent = Intent(
            this,
            ServiceOne::class.java
        )

        Log.i(
            "serviceDemo",
            "Main Activity : " + Thread.currentThread().id.toString()
        )

        Handler().postDelayed(
            {
                startTheService()
            },
            5000
        )

        /*
        the service can also be stopped by stopService() method.
         */

        Matisse.from(this@MainActivity)
            .choose(MimeType.ofAll())
            .countable(true)
            .maxSelectable(9)
            .addFilter(GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
            .gridExpectedSize(resources.getDimensionPixelSize(R.dimen.grid_expected_size))
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
            .thumbnailScale(0.85f)
            .imageEngine(Glide4Engine())
            .setOnSelectedListener(
                object : OnSelectedListener {
                    override fun onSelected(
                        uriList: MutableList<Uri>,
                        pathList: MutableList<String>
                    ) {
                        Log.i("dbdsngdn", "selected")
                    }
                }
            )
            .forResult(123)
    }

    private fun startTheService() {
        startService(
            serviceIntent
        )
    }
}
