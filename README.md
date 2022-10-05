# HadoopTutorial


上課所建置的Hadoop機器：
  http://140.120.182.143:3000/cluster


## 如果你是在校外連線進來hadoop Cluster，請觀看下列VPN設定說明。如果你在校內，請直接跳過此部分。
VPN: https://cc.nchu.edu.tw/sslvpn/
因為機器限制只有學校IP才能連進來，不在學校的同學請使用學校VPN連線

VPN連線方式:
1. 進入VPN網址: https://nchuvpn.twaren.net/
2. 使用學校email(入口網站)帳密登入
   - 帳號: 學號@mail.nchu.edu.tw (ex. `g110056XXX@mail.nchu.edu.tw`)
   - 密碼: 入口網站密碼
3. 點選開始 ![](https://cc.nchu.edu.tw/sslvpn/images/win_2.jpg)
4. 照網頁指示安裝PulseSecure軟體後就可連線，其他詳細資訊可參考 https://cc.nchu.edu.tw/sslvpn/ 安裝說明

## 登入方式：
```shell
ssh hduser@140.120.182.143 -p 1000
```

Account: _hduser_

Password: 

## 關於帳號的創建

sudo adduser --ingroup hadoop **你的帳號**

例如：

```shell
sudo adduser --ingroup hadoop yao-chung 
```

## 修改hdfs 權限

```shell
cd /usr/local/hadoop/
bin/hadoop fs -mkdir -p /user/your_account/
bin/hadoop fs -chown -R your_account:hadoop /user/your_account/
```

## 使用自己帳號登入後，輸入下列設定檔
```shell
exit
ssh 你的帳號@140.120.182.143 -p 1000
```
### 登入後設定環境變數檔 (.bashrc)
```shell
nano .bashrc
export HADOOP_HOME=/usr/local/hadoop
export PATH=$PATH:$HADOOP_HOME/bin
export CLASSPATH=.:$HADOOP_HOME/share/hadoop/common/hadoop-common-2.7.7.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.7.jar:$HADOOP_HOME/share/hadoop/common/lib/commons-cli-1.2.jar:$CLASSPATH

```
### 登出後重新登入使設定檔生效 or 使用 source 指令
```shell
source .bashrc
```


### 上述如果不清楚的話，可以觀看下面的影片說明：
[Hadoop系統帳號創建說明影片](https://youtu.be/KP4E2E2yuOw)




# HDFS (Hadoop Distributed File System 基本操作):

* 瀏覽HDFS內容
``` shell
hadoop fs -ls 
```

* 創建目錄夾於HDFS中
```shell
hadoop fs -mkdir 目錄夾名稱
```

* 存放資料於HDFS中
```shell
hadoop fs -put local_file_name hdfs_file_name
```

* 從HDFS刪除資料
```shell
hadoop fs -rmr hdfs_file_name
```

* 查看HDFS檔案內容
```shell
hadoop fs -cat file_name
```

* 自HDFS中，取回檔案至本地端
```shell
hadoop fs -get hdfs_file_name local_file_name
```

# 如何執行Hadoop程式？
程式執行指令如下：

hadoop jar jar檔 類別名稱 欲處理的檔案 計算完後結果存放之處
```shell
hadoop jar example.jar WordCount hdfs_files result_stored_folder

```


### 關於程式執行部分，上述如果不清楚的話，可以觀看下面的影片說明：

[Hadoop jar檔程式執行說明](https://youtu.be/L2FheR8ByFo)


# 如何編譯程式呢？
確認目前工作目錄為hadoop_tutorial，確認src子目錄夾中有可編譯之java檔案
於命令列模式，直接輸入 "ant"，系統便會直接進行src目錄夾中檔案之編譯與jar檔包裝

```shell
ant
```

[Hadoop程式編譯說明](https://youtu.be/WPcnytCjyf8)



