package steve.spark.wordCount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCountTest {
    def main(args: Array[String]): Unit = {
        // 执行入口
        val conf: SparkConf = new SparkConf().setAppName("wordCountApp").setMaster("local[*]")
        // 上下文
        val sc: SparkContext = new SparkContext(conf)
        // 加载文件
        val lineRdd: RDD[String] = sc.textFile("D:\\projects\\sparkWordCountTest\\files\\input\\wordCountTest")
        // 切分压平
        val flatMap = lineRdd.flatMap(_.split(" "))
        // 创建键值对
        val wordMap = flatMap.map((_, 1))
        // 分组聚合
        val reducedResult = wordMap.reduceByKey(_ + _)
        // 排序
        val sortedResult = reducedResult.sortBy(_._2, false)
        // 保存结果
        sortedResult.saveAsTextFile("D:\\projects\\sparkWordCountTest\\files\\out\\result2")
        // 释放资源
        sc.stop()
    }
}
