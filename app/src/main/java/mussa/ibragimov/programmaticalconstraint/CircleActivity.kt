package mussa.ibragimov.programmaticalconstraint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet

class CircleActivity : AppCompatActivity() {

    private lateinit var rootView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle)
        rootView = findViewById(R.id.activity_circle_root)

        val firstView = rootView.setupDummyTextView(300, 300)
        val secondView = rootView.setupDummyTextView(600, 600)

        val set = ConstraintSet()
        set.clone(rootView)
        set.constrainCircle(
                firstView.id,
                rootView.id,
                150,
                360f
        )
        set.constrainCircle(
                secondView.id,
                rootView.id,
                300,
                180f
        )
        set.applyTo(rootView)
    }
}
