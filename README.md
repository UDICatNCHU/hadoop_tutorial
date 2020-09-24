# HadoopTutorial


我所建置的Hadoop機器：
  http://140.120.13.242:3000/cluster

登入方式：
ssh hduser@140.120.13.242 -p 1000

Account: _hduser_

Password: 

## 關於帳號的創建

sudo adduser --ingroup hadoop **你的帳號**

例如：

``` 
sudo adduser --ingroup hadoop yao-chung 
```

## 修改hdfs 權限

```
cd /usr/local/hadoop/
bin/hadoop fs -mkdir -p /user/你的帳號/
bin/hadoop fs -chown -R 你的帳號:hadoop /user/你的帳號/
```

## 使用自己帳號登入後，輸入下列設定檔
```
exit
ssh 你的帳號@140.120.13.242 -p 1000
```
### 登入後設定環境變數檔 (.bashrc)
```
nano .bashrc
export HADOOP_HOME=/usr/local/hadoop
export PATH=$PATH:$HADOOP_HOME/bin
export CLASSPATH=.:$HADOOP_HOME/share/hadoop/common/hadoop-common-2.7.7.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.7.jar:$HADOOP_HOME/share/hadoop/common/lib/commons-cli-1.2.jar:$CLASSPATH

```
### 登出後重新登入使設定檔生效 or 使用 source 指令
```
source .bashrc
```

# HDFS (Hadoop Distributed File System 基本操作):

* 瀏覽HDFS內容
``` 
hadoop fs -ls 
```

* 創建目錄夾於HDFS中
```
hadoop fs -mkdir 目錄夾名稱
```

* 存放資料於HDFS中
```
hadoop fs -put local_file_name hdfs_file_name
```

* 從HDFS刪除資料
```
hadoop fs -rmr hdfs_file_name
```

* 查看HDFS檔案內容
```
hadoop fs -cat file_name
```

* 自HDFS中，取回檔案至本地端
```
hadoop fs -get hdfs_file_name local_file_name
```

# Hadoop 程式執行
程式執行指令如下：

hadoop jar jar檔 類別名稱 欲處理的檔案 計算完後結果存放之處
```
hadoop jar example.jar WordCount hdfs_files result_stored_folder

```



