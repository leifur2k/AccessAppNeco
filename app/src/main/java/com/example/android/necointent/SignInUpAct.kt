package com.example.android.necointent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.android.necointent.constance.Constance
import com.example.android.necointent.databinding.ActivitySingUpInBinding

class SignInUpAct : AppCompatActivity() {

    private lateinit var bindingClass : ActivitySingUpInBinding
    private var signState = "Empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivitySingUpInBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE)!!
        if (signState == Constance.SIGN_IN_STATE){
            bindingClass.bAvatar2.visibility = View.INVISIBLE
            bindingClass.etName21.visibility = View.GONE
            bindingClass.etName22.visibility = View.GONE
            bindingClass.etName23.visibility = View.GONE
        }

        bindingClass.bDone2.setOnClickListener {
            if (signState == Constance.SIGN_UP_STATE) {
                val intent = Intent()
                intent.putExtra(Constance.LOGIN, bindingClass.etLogin2.text.toString())
                intent.putExtra(Constance.PASSWORD, bindingClass.etPassword2.text.toString())
                intent.putExtra(Constance.NAME, bindingClass.etName21.text.toString())
                intent.putExtra(Constance.NAME1, bindingClass.etName22.text.toString())
                intent.putExtra(Constance.NAME2, bindingClass.etName23.text.toString())
                if(bindingClass.imAvatar2.isVisible)intent.putExtra(Constance.AVATAR_ID, R.drawable.smile)
                setResult(RESULT_OK, intent)
                finish()
            } else if(signState == Constance.SIGN_IN_STATE){
                intent.putExtra(Constance.LOGIN, bindingClass.etLogin2.text.toString())
                intent.putExtra(Constance.PASSWORD, bindingClass.etPassword2.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }

        }

        bindingClass.bAvatar2.setOnClickListener {
            bindingClass.imAvatar2.visibility = View.VISIBLE
        }

    }
}