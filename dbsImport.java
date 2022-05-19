import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// CSV��ǂݍ��ނ̂Ɏg��

public class dbsImport{
	public static final String SPLITTER = ","; // ��������
  public static void main(String[] args) {

    System.out.print("csv�t�@�C��������́F");
    Scanner scanFn = new Scanner(System.in);//�L�[�{�[�h���͂̏���
    String fname = scanFn.nextLine();//�L�[�{�[�h�������
		System.out.print("�e�[�u��������́F");
    Scanner scanTn = new Scanner(System.in);//�L�[�{�[�h���͂̏���
    String Tname = scanTn.nextLine();//�L�[�{�[�h�������

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
						int num = Integer.parseInt(cols[i]);	//try����parseInt�Œl������������
						System.out.print(num);
						filewriter.write(num);
					}catch(NumberFormatException e){	//��O=�����ł͂Ȃ�����������=������Ƃ��Ĉ���
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
