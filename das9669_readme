My submission directly follows the structure as instructed in the prompt on Brightspace.

For clarity, the data ingestion document provides my step-by-step process throughout my final project.

The following is my dataproc shell: das9669_nyu_edu@nyu-dataproc-m.
My input dataset is called dataset.csv and is located on HDFS final-project/input.
All my files related to this project is on HDFS final-project on my dataproc shell, which I have shared to the appropriate users.

Initially, I performed data profiling by finding the mean goals, the distinct teams, and the number of records in the dataset.

Then, I began munging the data by adding a Year column since my original dataset is an aggregation of multiple seasons in the English Premier League. Doing so would help with future analysis and visualizations. This outputs a csv formatted text, which I then converted into a csv file. The outputted dataset is called post-year-dataset.csv located on HDFS final-project/input.

After I used post-year-dataset.csv to do a final cleaning by removing all the columns I do not need. This outputs a csv formatted text, which I then converted into a csv file. The outputted dataset is called clean-dataset.csv located on HDFS final-project/input.

Following from that, I performed post-clean data profiling by finding the number of records in the dataset. It returns the same number of records because I did not remove any columns, since all the data is complete.

Finally, I perform my analysis. 

First, I computed Gls - Xg from the metrics I have in my dataset for each player. This provides information into how prolific players are given a shooting chance in the English Premier League. A higher Gls - Xg metric would indicate that a particular player is good at finishing their chances. The output of this analysis is located on HDFS final-project/output6/part-r-00000. The outputted dataset is in a csv formatted text, which I then converted into a csv file. The outputted dataset is called ExpectedGoalsVsGoalsOutput.csv located on HDFS final-project/input.

Then, using the ExpectedGoalsVsGoalsOutput.csv, I used my SortColumn code to sort the dataset in descending order based on their Gls - Xg metric that I computed in the previous step. This output is located on HDFS final-project/output7/part-r-00000.

Lastly, I performed a linear regression analysis between all the metrics in my dataset with the Gls metric in my dataset to determine which statistics are the best predictors for goals. I did so using my Regression code. This output is located on HDFS final-project/output8/part-r-00000.