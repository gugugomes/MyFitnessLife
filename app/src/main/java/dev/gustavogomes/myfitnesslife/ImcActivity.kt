package dev.gustavogomes.myfitnesslife

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
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
      val imcResponseId = imcResponse(finalResult)

      val dialogTitle = getString(R.string.imc_response, finalResult)
      AlertDialog.Builder(this)
        .setTitle(dialogTitle)
        .setMessage(imcResponseId)
        .setPositiveButton(
          android.R.string.ok
        ) { _, _ -> }
        .create()
        .show()

      val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
      service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
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

  @StringRes
  private fun imcResponse(imc: Double): Int {
    return when {
      imc < 15.0 -> R.string.imc_severely_low_weight
      imc < 16.0 -> R.string.imc_very_low_weight
      imc < 18.5 -> R.string.imc_low_weight
      imc < 25.0 -> R.string.normal
      imc < 30.0 -> R.string.imc_high_weight
      imc < 35.0 -> R.string.imc_so_high_weight
      imc < 40.0 -> R.string.imc_severely_high_weight
      else -> R.string.imc_extreme_weight
    }
  }
}