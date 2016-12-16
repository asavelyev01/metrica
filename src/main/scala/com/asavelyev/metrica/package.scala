package com.asavelyev

package object metrica {
  sealed abstract class Real extends Field[Double]
  implicit object Real extends Real {
    override def div(l: Double, r: Double) = l / r

    override def mult(l: Double, r: Double) = l * r

    override def add(l: Double, r: Double) = l + r

    override val zero = 0

    override val one = 1
  }

  object Ints extends Ring[Int] {
    override def mult(l: Int, r: Int) = l * r

    override def add(l: Int, r: Int) = l + r

    override val zero = 0

    override val one = 1
  }


  sealed abstract class Length extends ContinuumDimension[Double, Real]
  implicit object Length extends Length

  abstract class LengthUnit extends UnitOfMeasure[Double, Real, Length]

  implicit object m extends BaseUnit[Double, Real, Length]("m")

  val tenmeter = new Quantity[Double, Real, Length](10, m)
}
