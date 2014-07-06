package aqume.spark.ml

import org.apache.spark._
import org.apache.spark.mllib._
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.mllib.regression._
import org.apache.spark.mllib.linalg._
import org.apache.spark.rdd.RDD


object basics_lab_1 {
	// Note. Scala imports scala.collection.immutable.Vector by default,
	// so you have to import org.apache.spark.mllib.linalg.Vector explicitly
	// to use MLlib's Vector
	
  val vals1 = Array(1.0,2.3,3.6,4.7,9.5,10.0)     //> vals1  : Array[Double] = Array(1.0, 2.3, 3.6, 4.7, 9.5, 10.0)
  
  //********* VECTORS *********/
  
  val vect1 = new DenseVector(vals1)              //> vect1  : org.apache.spark.mllib.linalg.DenseVector = [1.0,2.3,3.6,4.7,9.5,10
                                                  //| .0]
  val vect2 = Vectors.dense(vals1)                //> vect2  : org.apache.spark.mllib.linalg.Vector = [1.0,2.3,3.6,4.7,9.5,10.0]
  
  val indices1 = Array(1,3,5,7,9)                 //> indices1  : Array[Int] = Array(1, 3, 5, 7, 9)
  val vect3 = new SparseVector(10, indices1, vals1)
                                                  //> vect3  : org.apache.spark.mllib.linalg.SparseVector = (10,[(1,1.0),(3,2.3),(
                                                  //| 5,3.6),(7,4.7),(9,9.5)])
  val vect4 = Vectors.sparse(10, indices1, vals1) //> vect4  : org.apache.spark.mllib.linalg.Vector = (10,[(1,1.0),(3,2.3),(5,3.6)
                                                  //| ,(7,4.7),(9,9.5)])
                                                  
  //********* LabeledPoint ******//
  
  val pos = LabeledPoint(1.0, vect2)              //> pos  : org.apache.spark.mllib.regression.LabeledPoint = LabeledPoint(1.0, [1
                                                  //| .0,2.3,3.6,4.7,9.5,10.0])
  val neg = LabeledPoint(0.0, vect4)              //> neg  : org.apache.spark.mllib.regression.LabeledPoint = LabeledPoint(0.0, (1
                                                  //| 0,[(1,1.0),(3,2.3),(5,3.6),(7,4.7),(9,9.5)]))
  
  val sc = new SparkContext("local", "basics lab 1", System.getenv("SPARK_HOME"))
                                                  //> 14/07/02 23:55:47 INFO spark.SecurityManager: Changing view acls to: hierony
                                                  //| mus
                                                  //| 14/07/02 23:55:47 INFO spark.SecurityManager: SecurityManager: authenticatio
                                                  //| n disabled; ui acls disabled; users with view permissions: Set(hieronymus)
                                                  //| 14/07/02 23:55:48 INFO slf4j.Slf4jLogger: Slf4jLogger started
                                                  //| 14/07/02 23:55:48 INFO Remoting: Starting remoting
                                                  //| 14/07/02 23:55:48 INFO Remoting: Remoting started; listening on addresses :[
                                                  //| akka.tcp://spark@10.15.2.24:50813]
                                                  //| 14/07/02 23:55:48 INFO Remoting: Remoting now listens on addresses: [akka.tc
                                                  //| p://spark@10.15.2.24:50813]
                                                  //| 14/07/02 23:55:48 INFO spark.SparkEnv: Registering MapOutputTracker
                                                  //| 14/07/02 23:55:48 INFO spark.SparkEnv: Registering BlockManagerMaster
                                                  //| 14/07/02 23:55:48 INFO storage.DiskBlockManager: Created local directory at 
                                                  //| /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/spark-local-20140702235548-
                                                  //| 8fd1
                                                  //| 14/07/02 23:55:48 INFO storage.MemoryStore: MemoryStore started with capacit
                                                  //| Output exceeds cutoff limit.
  val examples: RDD[LabeledPoint] = MLUtils.loadLibSVMFile(sc, "./test-data/sample_svm_data.txt")
                                                  //> 14/07/02 23:55:50 INFO storage.MemoryStore: ensureFreeSpace(35456) called w
                                                  //| ith curMem=0, maxMem=77974732
                                                  //| 14/07/02 23:55:50 INFO storage.MemoryStore: Block broadcast_0 stored as val
                                                  //| ues to memory (estimated size 34.6 KB, free 74.3 MB)
                                                  //| 14/07/02 23:55:50 WARN util.NativeCodeLoader: Unable to load native-hadoop 
                                                  //| library for your platform... using builtin-java classes where applicable
                                                  //| 14/07/02 23:55:50 WARN snappy.LoadSnappy: Snappy native library not loaded
                                                  //| org.apache.hadoop.mapred.InvalidInputException: Input path does not exist: 
                                                  //| file:/Applications/eclipse/Eclipse.app/Contents/MacOS/test-data/sample_svm_
                                                  //| data.txt
                                                  //| 	at org.apache.hadoop.mapred.FileInputFormat.listStatus(FileInputFormat.j
                                                  //| ava:197)
                                                  //| 	at org.apache.hadoop.mapred.FileInputFormat.getSplits(FileInputFormat.ja
                                                  //| va:208)
                                                  //| 	at org.apache.spark.rdd.HadoopRDD.getPartitions(HadoopRDD.scala:172)
                                                  //| 	at org.apache.spark.rdd.RDD$$anonfun$partitions$2.apply(RDD.scal
                                                  //| Output exceeds cutoff limit.-
  
  


  
}