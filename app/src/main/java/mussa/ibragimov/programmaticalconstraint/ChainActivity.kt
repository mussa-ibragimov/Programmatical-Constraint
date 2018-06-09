package mussa.ibragimov.programmaticalconstraint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.constraint.ConstraintSet.CHAIN_SPREAD_INSIDE
import android.support.constraint.ConstraintSet.LEFT
import android.support.constraint.ConstraintSet.RIGHT
import android.support.constraint.ConstraintSet.WRAP_CONTENT

class ChainActivity : AppCompatActivity() {

    private lateinit var rootView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chain)
        rootView = findViewById(R.id.activity_chain_root)
        val viewIds = mutableListOf<Int>()
        viewIds.add(rootView.setupDummyTextView(0, WRAP_CONTENT).id)
        viewIds.add(rootView.setupDummyTextView(0, WRAP_CONTENT).id)
        viewIds.add(rootView.setupDummyTextView(0, WRAP_CONTENT).id)
        viewIds.add(rootView.setupDummyTextView(0, WRAP_CONTENT).id)
        val weights = floatArrayOf(0.1f, 0.5f, 0.8f, 1.5f)
        val set = ConstraintSet()
        set.clone(rootView)
        set.createHorizontalChain(rootView.id, LEFT, rootView.id, RIGHT, viewIds.toIntArray(), weights, CHAIN_SPREAD_INSIDE)
        set.applyTo(rootView)
    }
}
