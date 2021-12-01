package com.trelloclone.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.trelloclone.Activities.IntroActivity
import com.trelloclone.R
import com.trelloclone.firebase.FirestoreClass

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN

            )
        //val typeFace: Typeface =Typeface.createFromAsset(assets,"ANTSYPAN.TTF")
        //tv_app_name.typeface = typeFace
        Handler().postDelayed({
            var currentUserID =FirestoreClass().getCurrentUserId()
            if(currentUserID.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))

            }else{
                startActivity(Intent(this, IntroActivity::class.java))

            }
            finish()
        },2500)
    }
}