package com.asavelyev

package object metrica {

  object Real extends NumericField[Double] {
    override def div = (a: T, b: T) => a / b
  }

  object Ints extends NumericRing[Int]

  sealed class NumericRing[X: Numeric] extends Ring[X] {
    protected val op = implicitly[Numeric[X]]
    //    implicit def c(f: (X, X) => X) = f.curried
    override val times = op.times _
    override val plus = op.plus _
    override val `0` = op.zero
    override val `1` = op.one
  }

  abstract class NumericField[X: Numeric] extends NumericRing[X] with Field[X]

}
