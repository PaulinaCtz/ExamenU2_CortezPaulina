package mx.edu.itson.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val button: Button = findViewById(R.id.btn_detalles)

        button.setOnClickListener {
            var intent: Intent = Intent( this, Principal::class.java)

            startActivity(intent)
        }
    }
}