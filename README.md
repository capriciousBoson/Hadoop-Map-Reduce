# Hadoop-Map-Reduce
# Hadoop MapReduce Word Count

This repository contains a Hadoop MapReduce program that performs word counting on a text file. The program reads an input text file, processes it line by line to count occurrences of each word, and then outputs the result as key-value pairs where the key is the word and the value is its count.

## Program Overview

### 1. **WordCountMapper.java**
   - The `Mapper` class reads each line of the input text file, tokenizes it to split the words, and emits each word with a count of 1.
   
### 2. **WordCountReducer.java**
   - The `Reducer` class receives each word (key) and its list of associated counts (values). It sums the counts and emits each word with its final total count.

### 3. **WordCountDriver.java**
   - The `Driver` class configures and runs the `MapReduce` job. It sets the input and output paths, mapper, reducer, and intermediate types.

## How to Run the Program

### Step 1: Setup Hadoop
If you haven't set up Hadoop yet, follow these steps:
1. Download Hadoop from the official site: [Hadoop Download](https://hadoop.apache.org/releases.html)
2. Extract it to a directory of your choice:
   ```bash
   tar -xzvf hadoop-3.3.2.tar.gz
   mv hadoop-3.3.2 /path/to/hadoop

export JAVA_HOME=/path/to/java

