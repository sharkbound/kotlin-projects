classes used as example:

A : Any

B : A

C : B


```
Invariant (T): must be exact type match 
	allowed:
		Generic<B> = Generic<B>

Contravariant (in T): must be exact or superclass, subtyping is inverted
	allowed:
		Generic<B> = Generic<A>
		Generic<B> = Generic<B>

Covariant (out T): must be exact or subclass
	allowed:
		Generic<B> = Generic<B>
		Generic<B> = Generic<C>

```
```kotlin
// *
// * examples:
// *

fun main() {
    // Invariant<T>
    val invariant1: Invariant<B> = Invariant<A>() // error
    val invariant2: Invariant<B> = Invariant<B>() // compiles
    val invariant3: Invariant<B> = Invariant<C>() // error

    // ContraVariant<in T>
    val contraVariant1: ContraVariant<B> = ContraVariant<A>() // compiles
    val contraVariant2: ContraVariant<B> = ContraVariant<B>() // compiles
    val contraVariant3: ContraVariant<B> = ContraVariant<C>() // error

    // CoVariant<out T> /
    val coVariant1: CoVariant<B> = CoVariant<A>() // error
    val coVariant2: CoVariant<B> = CoVariant<B>() // compiles
    val coVariant3: CoVariant<B> = CoVariant<C>() // compiles

}

class Invariant<T>
class ContraVariant<in T>
class CoVariant<out T>
open class A
open class B : A()
open class C : B()
```