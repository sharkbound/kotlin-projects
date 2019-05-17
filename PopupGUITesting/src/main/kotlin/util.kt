import javax.swing.Spring
import javax.swing.SpringLayout


fun springConst(pref: Int): Spring =
    Spring.constant(pref)

fun springConst(pref: Int, min: Int, max: Int): Spring =
    Spring.constant(min, pref, max)

fun springConst(min: Int, max: Int): Spring =
    springConst(min, min, max)


fun springContraint(
    x: Int? = null,
    y: Int? = null,
    width: Int? = null,
    height: Int? = null
): SpringLayout.Constraints =
    SpringLayout.Constraints(
        x?.let(::springConst),
        y?.let(::springConst),
        width?.let(::springConst),
        height?.let(::springConst)
    )