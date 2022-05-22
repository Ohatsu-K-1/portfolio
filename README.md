# portfolio
ここは K-1 のポートフォリオ です

ゲーム作品のソースコード&実行例動画はGooGleドライブにuploadしています↓
https://drive.google.com/drive/folders/1sQna3ebewqGwGtufvq5Dfg4IgMWTy7Ou?usp=sharing

***
### ファイル説明

#### dbsImport.java
csvファイルからSQLのimport文を生成します。
実行後、コマンドラインからcsvファイル名とテーブル名を入力します。
結果はoutput.txtという名前のテキストファイルで出力されます。

#### simulateFreeFall.java
ルンゲクッタ法による、自由落下運動のシミュレーションをします。
実行後、コマンドラインから初速度v0と初高度x0を入力します。
結果はdata.csvという名前のcsvファイルで出力されます。カラムは時刻t,距離x,速度vとの順となっています。

#### primalityTest.py
素数判定+エラトステネスの篩による素数リスト表示のプログラムです。
アルゴリズムはhttps://club.informatix.co.jp/?p=13457 の内容を参考にさせていただきました。
実行後、コマンドラインから正の整数nを入力すると、nが素数か否かの判定結果、およびn以下の値で素数である値のリストが出力されます。
