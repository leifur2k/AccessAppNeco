package com.example.android.necointent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.necointent.constance.Constance
import com.example.android.necointent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass : ActivityMainBinding
    private var login: String = "Empty"
    private var password: String = "Empty"
    private var name: String = "Empty"
    private var name1: String = "Empty"
    private var name2: String = "Empty"
    private var avatarImageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.bSignIn1.setOnClickListener {

            val intent = Intent(this, SignInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)

        }

        bindingClass.bSignUp1.setOnClickListener {

            val intent = Intent(this, SignInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Constance.REQUEST_CODE_SIGN_IN){

        } else if (requestCode == Constance.REQUEST_CODE_SIGN_UP){

        }


    }

}