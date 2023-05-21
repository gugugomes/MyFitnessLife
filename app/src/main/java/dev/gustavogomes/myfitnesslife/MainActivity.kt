package dev.gustavogomes.myfitnesslife

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  private lateinit var buttonImc: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    buttonImc = findViewById(R.id.buttonIMC)

    buttonImc.setOnClickListener {
      val imcScreen = Intent(this, ImcActivity::class.java)
      startActivity(imcScreen)
    }
  }
}