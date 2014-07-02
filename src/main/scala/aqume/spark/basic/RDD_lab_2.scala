package aqume.spark.basic
import org.apache.spark._
import org.apache.spark.SparkContext._
import scala.collection.immutable.Map

object RDD_lab_2 {
    def main(args: Array[String]): Unit = {
        
        val sc = new SparkContext("local", "RDD lab 2", System.getenv("SPARK_HOME"))
        
        // https://groups.google.com/forum/#!topic/spark-users/Zc3rOQxvvzY
        val r = sc.parallelize(1 to 100)
        val r_agg = r.aggregate(0)(_+_, _+_)
        println("r_agg: " + r_agg) // 5050
        
        /****** RDD key-value pairs ******/
        
        val file = sc.textFile("./test-data/CHANGES.txt")
        println("file.count: " + file.count)
        val filePairRddByFirstWord = file.map(line => (line.split(" ")(0), line))
        
        val trainingSet = List(
    		List(270, 43.0, 19.5, 5),
    		List(314, 43.0, 19.5, 6),
    		List(400, 43.0, 26.7, 4),
    		List(376, 46.0, 19.5, 6),
    		List(408, 53.0, 19.5, 3),
    		List(312, 101.0, 19.9, 6)
        )
        val f1 = (sc.parallelize(trainingSet)).map(example => ("thisSeemsWorthless", example(0)))
        println("f1: " + f1.first)
    }

}