import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// CSVを読み込むのに使う

public class dbsImport{
	public static final String SPLITTER = ","; // 分割文字
  public static void main(String[] args) {

    System.out.print("csvファイル名を入力：");
    Scanner scanFn = new Scanner(System.in);//キーボード入力の準備
    String fname = scanFn.nextLine();//キーボードから入力
		System.out.print("テーブル名を入力：");
    Scanner scanTn = new Scanner(System.in);//キーボード入力の準備
    String Tname = scanTn.nextLine();//キーボードから入力

    try {
      File file = new File(fname);
			FileReader filereader = new FileReader(file);
			BufferedReader br = new BufferedReader(filereader);
			String text;

			File output = new File("output.txt");
			FileWriter filewriter = new FileWriter(output);

			while((text = br.readLine()) != null){
				String [] cols = text.split(SPLITTER);
				System.out.print("insert into " + Tname + " values(");
				for (int i = 0;i < cols.length; i++) {
					try{
						int num = Integer.parseInt(cols[i]);	//try文とparseIntで値が数字か判定
						System.out.print(num);
						filewriter.write(num);
					}catch(NumberFormatException e){	//例外=数字ではない文字がある=文字列として扱う
						System.out.print("'" + cols[i] + "'");
						filewriter.write("'" + cols[i] + "'");
					}
					if (i !=  cols.length-1) {
						System.out.print(",");
						filewriter.write(",");
					}
				}
				System.out.println(");");
				filewriter.write(");");
				filewriter.close();
			}

    }catch(Exception e){
      e.printStackTrace();
    }



  }
}
