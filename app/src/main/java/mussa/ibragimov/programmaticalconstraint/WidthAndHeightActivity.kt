package mussa.ibragimov.programmaticalconstraint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT

class WidthAndHeightActivity : AppCompatActivity() {

    private lateinit var rootView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_width_and_height)
        rootView = findViewById(R.id.activity_width_and_height_root)
        rootView.widthAndHeight()
    }
}

fun ConstraintLayout.widthAndHeight() {
    val textView = setupDummyTextView(WRAP_CONTENT, WRAP_CONTENT)

    val set = ConstraintSet()
    set.clone(this)
    set.constrainWidth(textView.id, 100)
    set.constrainHeight(textView.id, 200)
    set.applyTo(this)

}
