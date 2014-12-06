package aqume.spark.ml

import scala.util.Random
import org.apache.spark.mllib.linalg._
import org.apache.spark._
import org.apache.spark.rdd.RDD
import org.apache.spark.SparkContext._
import org.apache.spark.mllib.linalg.distributed._

object RowMatrix_lab_2 {

    def main(args: Array[String]): Unit = {
        val sc = new SparkContext("local", "RowMatrix lab 1", System.getenv("SPARK_HOME"))
        
        //-------- Random vectors ----------//
		val randVectList = for(
			i <- 1 to 10;
			dv: Vector = new DenseVector(randomArrayCreation(5))
		) yield dv
  
		val randRows: RDD[Vector] = sc.parallelize(randVectList)
		val rowMatx1: RowMatrix = new RowMatrix(randRows)
		println("rowMatx1.numRows: " + rowMatx1.numRows)
		println("rowMatx1.numCols: " + rowMatx1.numCols)
		println("rowMatx1: " + rowMatx1)
		
		//-------- Unit Vectors ---------//
		val n = 12 
		val unitVectList = for(
	        i <- 0 to n - 1;
	        uv: Vector = unitVect(n, i) 
        ) yield uv
        
        val unitRows: RDD[Vector] = sc.parallelize(unitVectList)
		val rowMatx2: RowMatrix = new RowMatrix(unitRows)
		println("rowMatx2.numRows: " + rowMatx2.numRows)
		println("rowMatx2.numCols: " + rowMatx2.numCols)
		println("rowMatx2: " + rowMatx2)
        
    } //----- end main -------------------------------------//
    
    def unitVect(n: Int, j: Int): Vector = {
	  	val arr = Array.ofDim[Double](n)
		arr(j) = 1
		Vectors.dense(arr)
    }
    
    //http://www.smipple.net/snippet/morph/Create%20Array%20filled%20with%20random%20Integers
	def randomArrayCreation(n: Int): Array[Double] = {
		// http://www.scala-lang.org/api/2.7.7/scala/Range.html
		val range = 0 to n/2
		var a:Array[Double] = new Array[Double](n)
		
		def getRndInt(range: Range): Double = {
			val rnd = new scala.util.Random
			return rnd.nextDouble
		}
		
		for (index <- 0 to a.length - 1) a(index) = (getRndInt(range))
		return a
	}

}