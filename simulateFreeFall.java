import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class simulateFreeFall{
  public static void main(String[] args) {
    double h = 0.01;  //刻み幅
    double v0, x0;  //初速度、初高度（前回の計算での速度、高度）
    double t, v, x; //時刻、速度、高度
    double g = 9.80665;//重力加速度（定数）

    double k0, k1, k2, k3;  //ルンゲクッタ法で速度を求めるのに使う
    double l0, l1, l2, l3;  //ルンゲクッタ法で高度を求めるのに使う

    System.out.print("初速度v0：");
    Scanner scanv = new Scanner(System.in);
    v0 = scanv.nextDouble();
    System.out.print("初高度x0：");
    Scanner scanx = new Scanner(System.in);
    x0 = scanx.nextDouble();
    t = 0;
    x = x0;
    v = v0;

    try {
      FileWriter fw = new FileWriter("data.csv"); //data.csvに結果を出力
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);
      pw.printf("時刻t,距離x,速度v\n");
      pw.printf("%f,%f,%f\n", t,x,v);
      //System.out.printf("t = %.2f\tx = %f\tv = %f\n", t,x,v);

      while (x > 0) {

        k0 = v0 * h;
        l0 = g * h;
        k1 = (v0 + l0/2) * h;
        l1 = (g + k0/2) * h;
        k2 = (v0 + l1/2) * h;
        l2 = (g + k1/2) * h;
        k3 = (v0 + l2) * h;
        l3 = (g + k2) * h;

        v = v0 + (l0 + l1 * 2 + l2 * 2 + l3)/6 ;
        x = x0 - (k0 + k1 * 2 + k2 * 2 + k3)/6 ;
        t = t + h;
        pw.printf("%f,%f,%f\n", t,x,v);
        //System.out.printf("t = %.2f,x = %f,v = %f\n", t,x,v);

        v0 = v;
        x0 = x;

      }
      System.out.println("ファイルを出力しました。");
      pw.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
