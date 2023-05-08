val GKData = sc.textFile("FinalCode/profiling_code/Count/input/GKData.txt")

val values = GKData.flatMap(x => x.split(": "))

val counts = values.countByValue()

counts.foreach(println)
