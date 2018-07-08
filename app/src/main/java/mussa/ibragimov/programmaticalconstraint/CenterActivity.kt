package mussa.ibragimov.programmaticalconstraint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.constraint.ConstraintSet.LEFT
import android.support.constraint.ConstraintSet.RIGHT

class CenterActivity : AppCompatActivity() {

    private lateinit var rootView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_center)
        rootView = findViewById(R.id.activity_center_root)

        val firstView = rootView.setupDummyTextView(250, 250)
        val secondView = rootView.setupDummyTextView(250, 250)
        val centerView = rootView.setupDummyTextView(250, 250)

        val set = ConstraintSet()
        set.clone(rootView)
        set.connect(firstView.id, LEFT, rootView.id, LEFT)
        set.connect(secondView.id, RIGHT, rootView.id, RIGHT)
        set.center(
                centerView.id,
                firstView.id,
                RIGHT,
                0,
                secondView.id,
                LEFT,
                0,
                0.5f
        )
        set.applyTo(rootView)
    }
}
