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
