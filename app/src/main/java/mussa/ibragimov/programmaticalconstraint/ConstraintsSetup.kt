package mussa.ibragimov.programmaticalconstraint

import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.TextView

val textsArray = arrayOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean a sollicitudin quam. In sem est, congue.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ut ullamcorper diam, quis sagittis erat. Nulla gravida urna vitae volutpat.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed consectetur dolor ex, at laoreet.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu varius leo. Maecenas vehicula velit felis, a vulputate enim gravida vitae. In id sem sit amet felis vehicula laoreet sit amet eu massa. Morbi ornare nisl et mi vestibulum pulvinar. In."
)

fun ConstraintLayout.setupDummyTextView(width: Int, height: Int): TextView {
    val textView = TextView(context).apply {
        layoutParams = ConstraintLayout.LayoutParams(width, height)
    }
    textView.text = textsArray[this.childCount % 4]
    setupView(textView)

    return textView
}

fun ConstraintLayout.setupView(view: View): View {
    view.id = this.id + this.childCount + 1
    addView(view)

    return view
}