package aqume.spark.ml

import org.apache.spark.mllib._
import org.apache.spark.mllib.linalg.{Matrices, DenseMatrix}

object Matrices_lab {

	/* Local vectors and local matrices are simple data models that serve as public interfaces.
	 * The underlying linear algebra operations are provided by Breeze and jblas.
	 * http://spark.apache.org/docs/latest/mllib-data-types.html
	 */

	val vals1 = Array(1.0,2.3,3.6,4.7,9.5,10.0)
                                                  //> vals1  : Array[Double] = Array(1.0, 2.3, 3.6, 4.7, 9.5, 10.0)
	
  val matx1 = new DenseMatrix(2, 3, vals1)        //> matx1  : org.apache.spark.mllib.linalg.DenseMatrix = 1.0  3.6  9.5   
                                                  //| 2.3  4.7  10.0  
  println("\nmatx1:\n" + matx1 + "\n")            //> 
                                                  //| matx1:
                                                  //| 1.0  3.6  9.5   
                                                  //| 2.3  4.7  10.0  
                                                  //| 
  (matx1.numRows, matx1.numCols)                  //> res0: (Int, Int) = (2,3)
  val matx2 = new DenseMatrix(3, 2, vals1)        //> matx2  : org.apache.spark.mllib.linalg.DenseMatrix = 1.0  4.7   
                                                  //| 2.3  9.5   
                                                  //| 3.6  10.0  
  (matx2.numRows, matx2.numCols)                  //> res1: (Int, Int) = (3,2)
  println("\nmatx2:\n" + matx2 + "\n")            //> 
                                                  //| matx2:
                                                  //| 1.0  4.7   
                                                  //| 2.3  9.5   
                                                  //| 3.6  10.0  
                                                  //| 
  
  val matx3 = Matrices.dense(6, 1, vals1)         //> matx3  : org.apache.spark.mllib.linalg.Matrix = 1.0   
                                                  //| 2.3   
                                                  //| 3.6   
                                                  //| 4.7   
                                                  //| 9.5   
                                                  //| 10.0  
  println("\nmatx3:\n" + matx3 + "\n")            //> 
                                                  //| matx3:
                                                  //| 1.0   
                                                  //| 2.3   
                                                  //| 3.6   
                                                  //| 4.7   
                                                  //| 9.5   
                                                  //| 10.0  
                                                  //| 
}