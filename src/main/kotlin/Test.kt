import edu.umontreal.kotlingrad.api.*

val x by DReal.Var()
val y by DReal.Var()
val z by DReal.Var()

@Suppress("NonAsciiCharacters", "LocalVariableName")
fun main() {
  val z = x * (-sin(x * y) + y) * 4  // Infix notation
  val `∂z∕∂x` = d(z) / d(x)          // Leibniz notation [Christianson, 2012]
  val `∂z∕∂y` = d(z) / d(y)          // Partial derivatives
  val `∂²z∕∂x²` = d(`∂z∕∂x`) / d(x)  // Higher order derivatives
  val `∂²z∕∂x∂y` = d(`∂z∕∂x`) / d(y) // Higher order partials
  val `∇z` = z.grad()                // Gradient operator

  val values = arrayOf(x to 0, y to 1)

  println("z(x, y) \t= $z\n" +
    "z(${values.map { it.second }.joinToString()}) \t\t= ${z(*values)}\n" +
    "∂z/∂x \t\t= $`∂z∕∂x` \n\t\t= " + `∂z∕∂x`(*values) + "\n" +
    "∂z/∂y \t\t= $`∂z∕∂y` \n\t\t= " + `∂z∕∂y`(*values) + "\n" +
    "∂²z/∂x² \t= $`∂z∕∂y` \n\t\t= " + `∂²z∕∂x²`(*values) + "\n" +
    "∂²z/∂x∂y \t= $`∂²z∕∂x∂y` \n\t\t= " + `∂²z∕∂x∂y`(*values) + "\n" +
    "∇z \t\t= $`∇z` \n\t\t= [${`∇z`[x]!!(*values)}, ${`∇z`[y]!!(*values)}]ᵀ")
}

