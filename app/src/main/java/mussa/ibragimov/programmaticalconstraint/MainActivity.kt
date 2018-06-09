package mussa.ibragimov.programmaticalconstraint

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var rootView: ConstraintLayout

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootView = findViewById(R.id.main_activity_root)
    }

    fun displayConstraintSet(view: View) {
        when (view.id) {
            R.id.main_activity_barrier -> {
                startActivity(Intent(this, BarrierActivity::class.java))
            }
            R.id.main_activity_width_and_height -> {
                startActivity(Intent(this, WidthAndHeightActivity::class.java))
            }
            R.id.main_Activity_chain -> {
                startActivity(Intent(this, ChainActivity::class.java))
            }
        }
    }
}
