package mussa.ibragimov.programmaticalconstraint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.Barrier
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView

class BarrierActivity : AppCompatActivity() {

    private lateinit var rootView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barrier)
        rootView = findViewById(R.id.activity_barrier_root)
        rootView.setViewsBeforeBarrier()
        rootView.setBarrier()
    }
}

fun ConstraintLayout.setViewsBeforeBarrier() {
    val textViewOne = setupDummyTextView(WRAP_CONTENT, WRAP_CONTENT)
    textViewOne.width = 200
    textViewOne.height = 200
    val textViewTwo = setupDummyTextView(WRAP_CONTENT, WRAP_CONTENT)
    textViewTwo.width = 400
    textViewTwo.height = 400
    val beforeSet = ConstraintSet()
    beforeSet.clone(this)
    beforeSet.connect(textViewOne.id, ConstraintSet.LEFT, this.id, ConstraintSet.LEFT)
    beforeSet.connect(textViewOne.id, ConstraintSet.TOP, this.id, ConstraintSet.TOP)
    beforeSet.connect(textViewTwo.id, ConstraintSet.LEFT, textViewOne.id, ConstraintSet.RIGHT)
    beforeSet.connect(textViewTwo.id, ConstraintSet.TOP, this.id, ConstraintSet.TOP)
    beforeSet.applyTo(this)
}

fun ConstraintLayout.setBarrier() {
    val barrier = Barrier(context).apply {
        layoutParams = ConstraintLayout.LayoutParams(1, 1)
    }
    setupView(barrier)

    val set = ConstraintSet()
    set.clone(this)
    set.createBarrier(barrier.id, Barrier.BOTTOM, *getTestViewIds())
    set.applyTo(this)

    val barrieredText = TextView(context).apply {
        layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        text = textsArray[0]
    }

    setupView(barrieredText)

    val barrieredConnection = ConstraintSet()
    barrieredConnection.clone(this)
    barrieredConnection.connect(barrieredText.id, ConstraintSet.TOP, barrier.id, ConstraintSet.BOTTOM)
    barrieredConnection.applyTo(this)
}

fun ConstraintLayout.getTestViewIds() : IntArray {
    return intArrayOf(this.getChildAt(0).id, this.getChildAt(1).id)
}
