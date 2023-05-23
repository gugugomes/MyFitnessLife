package dev.gustavogomes.myfitnesslife

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ImcActivity : AppCompatActivity() {

  private lateinit var editWeight: EditText
  private lateinit var editHeight: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_imc)

    editWeight = findViewById(R.id.editImcWeight)
    editHeight = findViewById(R.id.editImcHeight)
    val buttonSend: Button = findViewById(R.id.buttonImcSend)

    buttonSend.setOnClickListener {
      if (!validate()) {
        Toast.makeText(this, R.string.fields_message, Toast.LENGTH_SHORT).show()
        return@setOnClickListener
      }

      val weight = editWeight.text.toString().toInt()
      val height = editHeight.text.toString().toInt()

      val finalResult = imcCalc(weight, height)

    }
  }

  private fun validate(): Boolean {
    return (editWeight.text.toString().isNotEmpty()
            && editHeight.text.toString().isNotEmpty()
            && !editWeight.text.toString().startsWith("0")
            && !editHeight.text.toString().startsWith("0"))
  }

  private fun imcCalc(weight: Int, height: Int): Double {
    return weight / ((height / 100.0) * (height / 100.0))
  }
}