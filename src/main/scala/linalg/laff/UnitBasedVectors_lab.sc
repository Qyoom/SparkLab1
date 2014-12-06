package linalg.laff

import org.apache.spark.mllib.linalg._

object UnitBasedVectors_lab {
  /*
  val xArr = Array(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0)
  xArr.length
  xArr(0)
  xArr(9)
  
  val j = 9
  val n = xArr.length
  xArr(j)
  n - j - 1
  */
  
  //----------- unit vector exercise : dynamic construction ----------//
  
  def unitVect(n: Int, j: Int): Vector = {
  		val arr = Array.ofDim[Double](n)
		arr(j) = 1
		Vectors.dense(arr)
  }                                               //> unitVect: (n: Int, j: Int)org.apache.spark.mllib.linalg.Vector
  
  val n = 12                                      //> n  : Int = 12
  val j = 9                                       //> j  : Int = 9
  n - j - 1                                       //> res0: Int = 2
  
  val uv1 = unitVect(n, j)                        //> uv1  : org.apache.spark.mllib.linalg.Vector = [0.0,0.0,0.0,0.0,0.0,0.0,0.0,0
                                                  //| .0,0.0,1.0,0.0,0.0]
  //uv1.toArray(0)
  uv1.toArray(j)                                  //> res1: Double = 1.0
  uv1.toArray.indexOf(1.0)                        //> res2: Int = 9
  
  val uv2 = uv1                                   //> uv2  : org.apache.spark.mllib.linalg.Vector = [0.0,0.0,0.0,0.0,0.0,0.0,0.0,0
                                                  //| .0,0.0,1.0,0.0,0.0]
  uv2                                             //> res3: org.apache.spark.mllib.linalg.Vector = [0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.
                                                  //| 0,0.0,1.0,0.0,0.0]
  uv1 == (uv2)                                    //> res4: Boolean = true
  
  val uv3 = unitVect(n, j)                        //> uv3  : org.apache.spark.mllib.linalg.Vector = [0.0,0.0,0.0,0.0,0.0,0.0,0.0,0
                                                  //| .0,0.0,1.0,0.0,0.0]
  
  uv1 == uv3                                      //> res5: Boolean = true
  uv2 == uv3                                      //> res6: Boolean = true

  
}