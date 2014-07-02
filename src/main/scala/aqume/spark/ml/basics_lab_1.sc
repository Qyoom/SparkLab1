package aqume.spark.ml

import org.apache.spark._
import org.apache.spark.mllib._
import org.apache.spark.mllib.linalg._
import breeze.linalg.DenseMatrix

object basics_lab_1 {
	// Note. Scala imports scala.collection.immutable.Vector by default,
	// so you have to import org.apache.spark.mllib.linalg.Vector explicitly
	// to use MLlib's Vector
	
  val vals1 = Array(1.0,2.3,3.6,4.7,9.5,10.0)     //> vals1  : Array[Double] = Array(1.0, 2.3, 3.6, 4.7, 9.5, 10.0)
  val vect1 = new DenseVector(vals1)              //> vect1  : org.apache.spark.mllib.linalg.DenseVector = [1.0,2.3,3.6,4.7,9.5,10
                                                  //| .0]
  val vect2 = Vectors.dense(vals1)                //> vect2  : org.apache.spark.mllib.linalg.Vector = [1.0,2.3,3.6,4.7,9.5,10.0]
  
  val indices1 = Array(1,3,5,7,9)                 //> indices1  : Array[Int] = Array(1, 3, 5, 7, 9)
  val vect3 = new SparseVector(10, indices1, vals1)
                                                  //> vect3  : org.apache.spark.mllib.linalg.SparseVector = (10,[(1,1.0),(3,2.3),(
                                                  //| 5,3.6),(7,4.7),(9,9.5)])
  val vect4 = Vectors.sparse(10, indices1, vals1) //> vect4  : org.apache.spark.mllib.linalg.Vector = (10,[(1,1.0),(3,2.3),(5,3.6)
                                                  //| ,(7,4.7),(9,9.5)])
  val matx1 = new DenseMatrix(2, 3, vals1)        //> matx1  : breeze.linalg.DenseMatrix[Double] = 1.0  3.6  9.5   
                                                  //| 2.3  4.7  10.0  
  println("\n" + matx1 + "\n")                    //> 
                                                  //| 1.0  3.6  9.5   
                                                  //| 2.3  4.7  10.0  
                                                  //| 
  (matx1.rows, matx1.cols)                        //> res0: (Int, Int) = (2,3)
  val matx2 = new DenseMatrix(3, 2, vals1)        //> matx2  : breeze.linalg.DenseMatrix[Double] = 1.0  4.7   
                                                  //| 2.3  9.5   
                                                  //| 3.6  10.0  
  println("\n" + matx2 + "\n")                    //> 
                                                  //| 1.0  4.7   
                                                  //| 2.3  9.5   
                                                  //| 3.6  10.0  
                                                  //| 
  (matx2.rows, matx2.cols)                        //> res1: (Int, Int) = (3,2)
}