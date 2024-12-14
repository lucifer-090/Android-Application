package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityButtonTouchBinding

class ButtonTouchActivity : AppCompatActivity() {

    lateinit var binding: ActivityButtonTouchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityButtonTouchBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        button
        binding.touchButtonn.setOnClickListener{
            val username: String = binding.userName.text.toString()
            val password: String = binding.passwordText.text.toString()

            if (username.isEmpty()){
                binding.userName.error = "Username can't be empty"
            }else if (password.isEmpty()){
                binding.passwordText.error = "Password can't be empty"
            }else{
                val intent = Intent(this@ButtonTouchActivity, DestinationActivity::class.java)
                intent.putExtra("username",username)
                intent.putExtra("password", password)
                startActivity(intent)
                finish()
            }

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}