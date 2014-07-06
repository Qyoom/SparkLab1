package aqume.spark.ml
import org.apache.spark.mllib.linalg.{Vector, Vectors}

object vector_lab {
	val dv1 = Vectors.dense(1.0, 0.0, 3.0)    //> dv1  : org.apache.spark.mllib.linalg.Vector = [1.0,0.0,3.0]
	val sv1 = Vectors.sparse(3, Array(0,2), Array(1.0, 3.0))
                                                  //> sv1  : org.apache.spark.mllib.linalg.Vector = (3,[(0,1.0),(2,3.0)])
	sv1.toArray                               //> res0: Array[Double] = Array(1.0, 0.0, 3.0)
	
	val sv2 = Vectors.sparse(3, Seq((0,1.0), (2,3.0)))
                                                  //> sv2  : org.apache.spark.mllib.linalg.Vector = (3,[(0,1.0),(2,3.0)])
  sv2.toArray                                     //> res1: Array[Double] = Array(1.0, 0.0, 3.0)
}