package dev.gustavogomes.myfitnesslife

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

  //  private lateinit var buttonImc: Button
  private lateinit var rvMain: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val adapter = MainAdpter()
    rvMain = findViewById(R.id.mainRecycleView)
    rvMain.adapter = adapter
    rvMain.layoutManager = LinearLayoutManager(this)
  }

  private inner class MainAdpter : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
      val view = layoutInflater.inflate(R.layout.main_item, parent, false)
      return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {}

    override fun getItemCount(): Int {
      return 15
    }
  }

  private class MainViewHolder(view: View) : RecyclerView.ViewHolder(view)
}