### RDD(resilient distrubited datasets)
- 弹性
- 可复原
- 分布式
RDD只存储数据的转换关系（元数据信息）
#### 方法（分类）
##### Transformation(lazy)
延迟提交到集群
- union 并集
- intersection 交集
- join 按key内连接
- leftOuterJoin
- rightOuterJoin
reduceByKey 局部分组聚合再全局聚合
groupByKey -> mapValues 局部分组全局聚合
cogroup 协分组，按key分组，按分组前的组聚合
cartesian 笛卡尔集
##### Action
立即提交到集群
#### 创建方式
- 外部存储系统创建
- driver端（spark-submit）scala集合并行化sc.parallelize(),sc.makeRDD()

