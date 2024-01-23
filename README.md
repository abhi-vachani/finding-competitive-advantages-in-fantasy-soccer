# finding-competitive-advantages-in-fantasy-soccer

## Important: Open the "Research_Paper.pdf" file to understand the project in greater detail. 

This is the README file in the directory for Abhi Vachani's part of the Final Code Drop. 
Project Name: Finding Competitive Advantages In Fantasy Soccer Using Data Analytics
Partner: Argy Sakti 

Data Ingestion:

To ingest the data download the three datasets on your local machine:
They are located at /final-project-code-submission-das9669-apv9448/Datasets/apv9448
- matches22-23.csv
- soccer21-22.csv
- gk.csv

Then, upload them to HDFS.

Finally,
Make a directory (if it does not exist already in HDFS) named /FinalCode/input
You can do this by using the command: 
hdfs dfs -mkdir FinalCode
hdfs dfs -mkdir FinalCode/input
While making sure you are in the same directory as the datasets /final-project-code-submission-das9669-apv9448/Datasets/apv9448
Run the following commands to put the three datasets into HDFS:
hdfs dfs -put matches22-23.csv FinalCode/input
hdfs dfs -put soccer21-22.csv FinalCode/input
hdfs dfs -put gk.csv FinalCode/input

##################################################################################################################################################################################################################################################################################################
##################################################################################################################################################################################################################################################################################################
##################################################################################################################################################################################################################################################################################################

Cleaning: 

To compile and run the cleaning code for the data file "matches22-23.csv" navigate to the path /final-project-code-submission-das9669-apv9448/etl_code/apv9448/CurrSeasonClean and run the following commands: 

First delete the existing .class and .jar files AND remove the output directory from HDFS:
rm *class *.jar
hdfs dfs -rm -r FinalCode/etl_code/CurrSeasonClean/output

Then compile and run:
javac -classpath `yarn classpath` -d . CurrSeasonCleanMapper.java
javac -classpath `yarn classpath` -d . CurrSeasonCleanReducer.java
javac -classpath `yarn classpath`:. -d . CurrSeasonClean.java
jar -cvf CurrSeasonClean.jar *.class
hadoop jar CurrSeasonClean.jar CurrSeasonClean FinalCode/input/matches22-23.csv FinalCode/etl_code/CurrSeasonClean/output

To view the output: 
hdfs dfs -cat FinalCode/etl_code/CurrSeasonClean/output/part-r-00000

##################################################################################################################################################################################################################################################################################################

To compile and run the cleaning code for the data file "soccer21-22.csv" navigate to the path /final-project-code-submission-das9669-apv9448/etl_code/apv9448/LastSeasonClean and run the following commands: 

First delete the existing .class and .jar files AND remove the output directory from HDFS:
rm *class *.jar
hdfs dfs -rm -r FinalCode/etl_code/LastSeasonClean/output

Then compile and run:
javac -classpath `yarn classpath` -d . LastSeasonCleanMapper.java
javac -classpath `yarn classpath` -d . LastSeasonCleanReducer.java
javac -classpath `yarn classpath`:. -d . LastSeasonClean.java
jar -cvf LastSeasonClean.jar *.class
hadoop jar LastSeasonClean.jar LastSeasonClean FinalCode/input/soccer21-22.csv FinalCode/etl_code/LastSeasonClean/output

To view the output: 
hdfs dfs -cat FinalCode/etl_code/LastSeasonClean/output/part-r-00000

##################################################################################################################################################################################################################################################################################################
##################################################################################################################################################################################################################################################################################################
##################################################################################################################################################################################################################################################################################################

Profiling: 

Profiling code for the "gk.csv" dataset. 
This part of the profiling_code directory maps the player names to the teams they play for. 
This is important because another part of this project analyses goals conceded by team.
We want to know which player plays for which team to give respective goalkeepers credit. 

To compile and run the profiling code for the data file "gk.csv" navigate to the path /final-project-code-submission-das9669-apv9448/profiling_code/apv9448/GK and run the following commands: 

First delete the existing .class and .jar files AND remove the output directory from HDFS:
rm *class *.jar
hdfs dfs -rm -r FinalCode/profiling_code/GK/output

Then compile and run:
javac -classpath `yarn classpath` -d . GKMapper.java
javac -classpath `yarn classpath` -d . GKReducer.java
javac -classpath `yarn classpath`:. -d . GK.java
jar -cvf GK.jar *.class
hadoop jar GK.jar GK FinalCode/input/gk.csv FinalCode/profiling_code/GK/output

To view the output:
hdfs dfs -cat FinalCode/profiling_code/GK/output/part-r-00000

##################################################################################################################################################################################################################################################################################################

Using this output, copy and paste it to a new file named GKData.txt
We will use it for further profiling. 
Move GKData.txt to /final-project-code-submission-das9669-apv9448/profiling_code/apv9448/Count
Navigate to /final-project-code-submission-das9669-apv9448/profiling_code/apv9448/Count
Create the respective directories in HDFS and put GKData.txt into HDFS with the following commands: 
hdfs dfs -mkdir FinalCode/profiling_code/Count
hdfs dfs -mkdir FinalCode/profiling_code/Count/input
hdfs dfs -put GKData.txt FinalCode/profiling_code/Count/input

To run profile.scala follow the steps below:
Open the spark terminal by typing: spark-shell --deploy-mode client -i
Run every command one at a time in the file "profile.scala"

This second profiling code has counted the value for each player and team, therefore, giving us a better understanding of the datasets.

##################################################################################################################################################################################################################################################################################################
##################################################################################################################################################################################################################################################################################################
##################################################################################################################################################################################################################################################################################################

Analysis: 

For the analysis portion, I have decided to calculate the number of goals conceded per team in a full season. 
I have done this using the data file "soccer21-22.csv" which contains data from every match in the 2021-22 season. 

To compile and run the analysis code for the data file "soccer21-22.csv" navigate to the path /final-project-code-submission-das9669-apv9448/ana_code/apv9448/GoalsConceded and run the following commands: 

First delete the existing .class and .jar files AND remove the output directory from HDFS:
rm *class *.jar
hdfs dfs -rm -r FinalCode/ana_code/GoalsConceded/output

Then compile and run:
javac -classpath `yarn classpath` -d . FinalCodeMapper.java
javac -classpath `yarn classpath` -d . FinalCodeReducer.java
javac -classpath `yarn classpath`:. -d . FinalCode.java
jar -cvf FinalCode.jar *.class
hadoop jar FinalCode.jar FinalCode FinalCode/input/soccer21-22.csv FinalCode/ana_code/GoalsConceded/output

To view the output: 
hdfs dfs -cat FinalCode/ana_code/GoalsConceded/output/part-r-00000
