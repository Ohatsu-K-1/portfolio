import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class simulateFreeFall{
  public static void main(String[] args) {
    double h = 0.01;  //���ݕ�
    double v0, x0;  //�����x�A�����x�i�O��̌v�Z�ł̑��x�A���x�j
    double t, v, x; //�����A���x�A���x
    double g = 9.80665;//�d�͉����x�i�萔�j

    double k0, k1, k2, k3;  //�����Q�N�b�^�@�ő��x�����߂�̂Ɏg��
    double l0, l1, l2, l3;  //�����Q�N�b�^�@�ō��x�����߂�̂Ɏg��

    System.out.print("�����xv0�F");
    Scanner scanv = new Scanner(System.in);
    v0 = scanv.nextDouble();
    System.out.print("�����xx0�F");
    Scanner scanx = new Scanner(System.in);
    x0 = scanx.nextDouble();
    t = 0;
    x = x0;
    v = v0;

    try {
      FileWriter fw = new FileWriter("data.csv"); //data.csv�Ɍ��ʂ��o��
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);
      pw.printf("����t,����x,���xv\n");
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
      System.out.println("�t�@�C�����o�͂��܂����B");
      pw.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
