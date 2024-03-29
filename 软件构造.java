import java.util.Random;
public class KST {

	public static void main(String[] args) {
		int[] first = new int [50];
		int[] second = new int [50];
		int[] chars = new int [50];//chars用来存储运算符，0代表减法，1代表加法
		printHeader();  //打印算式的头部函数
		generateEquations(first, second, chars);
		printExercise(first, second, chars);
		printCalculations(first, second, chars);

	}
	static void  printHeader() {
		System.out.print("\n");
		System.out.println("程序输出五十道100以内的加减法算式的习题：");
		System.out.println("每次运行程序可得到一套50道题的习题集答案");
	}
	static void generateEquations(int[] first, int[] second, int[] chars) {
		System.out.println("-----------下面是生成的50道习题---------------------------------------------");
		System.out.print("\n");
		Random r = new Random();
		for(int i = 0; i < 50; i++) {
			first[i] = r.nextInt(101);
			second[i] = r.nextInt(101);
			chars[i] = r.nextInt(2);
			if(chars[i] == 0) {
				if(first[i] - second[i] < 0) {
					i--;
					continue;
				}		
			}
			else {
				if(first[i] + second[i] > 100) {
					i--;
					continue;
				}
				
			}
			int flag = 0;
			for(int j = i-1; j >=0; j--) {
				if(first[i] == first[j] && second[i] == second[j] && chars[i] == chars[j]) {
					flag = 1;
					break;
				}
			}
			if(flag == 1) {
				i--;
				continue;
			}
		}
	}
	static void printExercise(int[] first, int[] second, int[] chars) {
		int m = 0;  //用于调整习题前面的序号从1开始
		int n = 0;   //用于调整习题前面的序号从1开始
		for(int i = 0; i < 50; i++) {
			if(chars[i] == 0) {
				n = i + 1;
				System.out.print("第" + n + "道习题 ："  + first[i] + "-" + second[i] + "=" + "\t");
			}
			else{
				m = i + 1;
				System.out.print("第" + m + "道习题： " + first[i] + "+" + second[i] + "=" + "\t");
			}
			if((i + 1 ) % 5 == 0) {
				System.out.println("");  //每连续打印五道习题就空一行
			}
		}
	}
	static void printCalculations(int[] first, int[] second, int[] chars) {
		int c = 0; //用来接收两个数的差
		int b = 0; //用来接收两个数的和
		int k = 0; //用于调整答案前的序号从1开始
		int j = 0; //用于调整答案前的序号从1开始
		System.out.println("");
		System.out.println("-----------下面是50道习题的参考答案---------------------------------------------");
		for(int i = 0; i < 50; i++) {
			if(chars[i] == 0) {
				 c = first[i] - second[i];
				 k = i + 1;
				System.out.print("第" + k + "题的参考答案："+ c +"\t");
			}
			else{
				 b = first[i] + second[i];
				 c = i + 1;
				System.out.print("第" + i + "题的参考答案："+ b + "\t");
			}
			if((i + 1 ) % 5 == 0) {
				System.out.println(""); //每连续打印五道习题答案就空一行
			}
		}
	}
}
