package steve.spark.wordCount;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class JavaWordCount {
    public static void main(String[] args) {
        //加载配置环境
        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("wordCount");
        //上下文
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
        //加载数据源
        JavaRDD<String> javaRDD = sparkContext.textFile("files/input/wordCountTest");
        //切分压平
        JavaRDD<String> flatMap = javaRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        //组合
        JavaPairRDD<String, Integer> wordPair = flatMap.mapToPair(word -> new Tuple2(word, 1));
        //聚合
        JavaPairRDD<String, Integer> reduceByKey = wordPair.reduceByKey((v1, v2) -> v1 + v2);
        //交换
        JavaPairRDD<Integer, String> reduceByKeySwap = reduceByKey.mapToPair(tp -> tp.swap());
        //排序
        JavaPairRDD<Integer, String> swapSorted = reduceByKeySwap.sortByKey(false);
        //交换
        JavaPairRDD<String, Integer> reduceSorted = swapSorted.mapToPair(tp -> tp.swap());
        //保存
        reduceSorted.saveAsTextFile("files/out/result");
        // 释放资源
        sparkContext.stop();
    }

}
