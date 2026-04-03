import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.{IntWritable, Text}
import org.apache.hadoop.mapreduce.{Job, Mapper, Reducer}
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat

import java.lang

class WordCountMapper
    extends Mapper[Object, Text, Text, IntWritable] {

  private val one     = new IntWritable(1)
  private val key     = new Text()
  private val targets = Set('f', 'i', 't', 'h', 'c', 'm', 'u', 's')

  override def map(
      offset: Object,
      line:   Text,
      ctx:    Mapper[Object, Text, Text, IntWritable]#Context
  ): Unit = {
    val word = line.toString.trim
    if (word.nonEmpty) {
      val firstChar = word.charAt(0).toLower
      if (targets.contains(firstChar)) {
        key.set(firstChar.toString)
        ctx.write(key, one)
      }
    }
  }
}

class WordCountReducer
    extends Reducer[Text, IntWritable, Text, IntWritable] {

  private val result = new IntWritable()

  override def reduce(
      key:    Text,
      values: lang.Iterable[IntWritable],
      ctx:    Reducer[Text, IntWritable, Text, IntWritable]#Context
  ): Unit = {
    var sum = 0
    val it  = values.iterator()
    while (it.hasNext) sum += it.next().get()
    result.set(sum)
    ctx.write(key, result)
  }
}

object WordCount {
  def main(args: Array[String]): Unit = {
    if (args.length != 2) {
      System.err.println("Usage: WordCount <input path> <output path>")
      System.exit(-1)
    }

    val conf = new Configuration()
    val job  = Job.getInstance(conf, "WordCount fithcmus")

    job.setJarByClass(classOf[WordCountMapper])
    job.setMapperClass(classOf[WordCountMapper])
    job.setReducerClass(classOf[WordCountReducer])

    job.setOutputKeyClass(classOf[Text])
    job.setOutputValueClass(classOf[IntWritable])

    FileInputFormat.addInputPath(job,   new Path(args(0)))
    FileOutputFormat.setOutputPath(job, new Path(args(1)))

    System.exit(if (job.waitForCompletion(true)) 0 else 1)
  }
}
