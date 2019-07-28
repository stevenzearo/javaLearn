package steve.spark.wordCount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCountTest {
    def main(args: Array[String]): Unit = {
        //执行入口
        val conf: SparkConf = new SparkConf().setMaster(args(0)).setAppName(args(1))
        val sc: SparkContext = new SparkContext(conf)
        val lineRdd: RDD[String] = sc.textFile(args(2))
        val value = lineRdd.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).sortBy(_._2, false)
        value.saveAsTextFile(args(3))
    }
}
