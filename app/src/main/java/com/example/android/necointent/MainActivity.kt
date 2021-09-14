package com.example.android.necointent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.android.necointent.constance.Constance
import com.example.android.necointent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass : ActivityMainBinding
    // Создаем глобальные переменные, чтобы сюда ловить введенные данные при регистрации пользователя на втором активити
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
        // Нажимаем на кнопку bSignIn1 и открывается второе активити + по ключу отправляем сообщение(в константах) и реквест код + Ждем ответа по реквест коду
        bindingClass.bSignIn1.setOnClickListener {
            val intent = Intent(this, SignInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
        }
        // Нажимаем на кнопку bSignUp1 и ПРОВЕРКА или открытие второго активити + по ключу отправляем сообщение(в константах) и реквест код + Ждем ответа по реквест коду
        bindingClass.bSignUp1.setOnClickListener {
            if(bindingClass.imAvatar1.isVisible) {
                bindingClass.imAvatar1.visibility = View.INVISIBLE
                bindingClass.tv1.visibility = View.INVISIBLE
                bindingClass.bSignIn1.visibility = View.VISIBLE
                bindingClass.bSignUp1.text = "Sign up"
            }
            else {
                val intent = Intent(this, SignInUpAct::class.java)
                intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
                startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
            }

        }

    }
    // Запускается когда возвращаем ответ со второго активити по реквест коду.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Если реквест код такой, то
        if(requestCode == Constance.REQUEST_CODE_SIGN_IN){
            val l = data?.getStringExtra(Constance.LOGIN)
            val p = data?.getStringExtra(Constance.PASSWORD)
            if(login == l && password == p){
                bindingClass.imAvatar1.setImageResource(R.drawable.smile)
                bindingClass.tv1.text = "$name $name1 $name2"
                bindingClass.tv1.visibility = View.VISIBLE
                bindingClass.imAvatar1.visibility = View.VISIBLE
                bindingClass.bSignIn1.visibility = View.GONE
                bindingClass.bSignUp1.text = "Выйти"
            } else {
                bindingClass.tv1.visibility = View.VISIBLE
                bindingClass.tv1.text = "Такого аккаунта не существует"
            }
        // Если реквест код иной, то
        } else if (requestCode == Constance.REQUEST_CODE_SIGN_UP){
            login = data?.getStringExtra(Constance.LOGIN)!!
            password = data?.getStringExtra(Constance.PASSWORD)!!
            name = data?.getStringExtra(Constance.NAME)!!
            name1 = data?.getStringExtra(Constance.NAME1)!!
            name2 = data?.getStringExtra(Constance.NAME2)!!
            avatarImageId = data?.getIntExtra(Constance.AVATAR_ID, 0)!!
            bindingClass.imAvatar1.setImageResource(R.drawable.smile)
            bindingClass.tv1.text = "$name $name1 $name2"
            bindingClass.tv1.visibility = View.VISIBLE
            bindingClass.imAvatar1.visibility = View.VISIBLE
            bindingClass.bSignIn1.visibility = View.GONE
            bindingClass.bSignUp1.text = "Выйти"
        }


    }

}