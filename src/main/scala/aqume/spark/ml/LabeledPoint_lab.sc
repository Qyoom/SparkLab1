package aqume.spark.ml

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint


object LabeledPoint_lab {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val pos = LabeledPoint(1.0, Vectors.dense(1.0, 0.0, 3.0))
                                                  //> pos  : org.apache.spark.mllib.regression.LabeledPoint = LabeledPoint(1.0, [1
                                                  //| .0,0.0,3.0])
  val neg = LabeledPoint(0.0, Vectors.sparse(3, Seq((0,1.0), (2,3.0))))
                                                  //> neg  : org.apache.spark.mllib.regression.LabeledPoint = LabeledPoint(0.0, (3
                                                  //| ,[(0,1.0),(2,3.0)]))
                                                  
  
  
  
}