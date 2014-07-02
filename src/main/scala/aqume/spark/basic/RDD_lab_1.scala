package aqume.spark.basic

import org.apache.spark.SparkContext._
import org.apache.spark._

object RDD_lab_1 {

	def main(args: Array[String]): Unit = {
		val sc = new SparkContext("local", "RDD lab 1", System.getenv("SPARK_HOME"))
		val doc1 = sc.textFile("./test-data/CHANGES.txt")
		//println("doc1:")
		//doc1.foreach(println)
		val fixes = doc1.filter(line => line.contains("Fix")) // This should be RegEx
		val broken = doc1.filter(line => line.contains("broken")) // This should be RegEx
		val fixed_or_broken = fixes.union(broken)
		println("Number of fixes: " + fixes.count)
		println("Things that were broken: " + broken.count)
		println("Union test; sum of fixed and broken: " + fixed_or_broken.count)
		
		val lines = sc.parallelize(List("hello world", "hi"))
		//println("lines.first: " + lines.first)
		val words = lines.flatMap(line => line.split(" "))
		//println(words.first())
		
		val fbFlat = fixed_or_broken.flatMap(line => line.split(" "))
		//println("fixed_or_broken.flatMap:")
		fbFlat.foreach(println)
		
		println("fixes.intersection(broken).count: " + fixes.intersection(broken).count)
		println("fixes.count: " + fixes.count)
		println("fixes.subtract(broken).count: " + fixes.subtract(broken).count)
		
		val alpha = sc.parallelize(List('a', 'b', 'c', 'd'))
		val numer = sc.parallelize(List(1, 2, 3, 4, 5))
		val cartDemo = alpha.cartesian(numer)
		println("alpha.cartesian(numer):")
		cartDemo.foreach(println)
	}
}