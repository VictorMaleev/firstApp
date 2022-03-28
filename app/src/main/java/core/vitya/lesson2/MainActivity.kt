package core.vitya.lesson2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.TextView as TextView

class MainActivity : AppCompatActivity() {
    private var  tvText: TextView? =null
    private var cLayout:ConstraintLayout? = null
    private var number:Int = 1
    private var counter:Int = 0
    private var start:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText=findViewById(R.id.tvText)
        cLayout=findViewById(R.id.cLayout)
        tvText?.setText(number.toString())
        Thread {
            start = true
            while (start) {
                Thread.sleep(1000)
                runOnUiThread{
                    if (counter==5) cLayout?.setBackgroundColor(Color.RED)
                    tvText?.setText(counter.toString())
                    counter++

                }

            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        start = false
    }
}