package cn.syf.studyarchitecture

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.syf.studyarchitecture.java.JavaMainActivity
import cn.syf.studyarchitecture.kotlin.MainActivity
import kotlinx.android.synthetic.main.activity_enter.*

class EnterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)
        java_btn.setOnClickListener {
            startActivity(Intent(this, JavaMainActivity::class.java))
        }
        kotlin_btn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        socket_btn.setOnClickListener {
            startActivity(Intent(this, SocketActivity::class.java))
        }
    }
}
