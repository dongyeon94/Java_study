package backjoon;

import java.util.Scanner;

public class P_1018 {
	static char trans[][]; // 8x8�� ü������ ��� �� �����ϴ� ü���� �����̴�.
	static char arr[][];  // nxm�� ���带 ���� �� �����̴�.
	static final char[][] white = { // (0,0)�� W�� �� ���� �� �ִ� ��Ģ�̴�.
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'}
	};
	
	static final char[][] black = { // (0,0)�� B�� �� ���� �� �ִ� ��Ģ�̴�.
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'}
	};
	public static int trans(int a, int b,int min) { // �� ü������ �� ��Ģ�� ���ϴ� �޼ҵ�
		int cnt_b =0; // BLACK ��Ģ�� ���Ͽ� �߻��ϴ� ��ȯȽ�� ���� ����
		int cnt_w =0; // WHITE "
		int k=0;
		StringBuilder builder = new StringBuilder("");
		for(int i =a;i<a+8;i++) { // �������� ���޵Ǹ� �׷κ��� 8ĭ�� ���忡�� �����´�
			builder.setLength(0); //StringBuilder �ʱ�ȭ , �������� �����.

			for(int j=b;j<b+8;j++) { // �������� ���޵Ǹ� �׷κ��� 8ĭ�� ���忡�� �����´�
				builder.append(arr[i][j]); // ���忡�� ������ �ش� ���� stringbuilder�� ����
				
			}		
			for(int j=0;j<builder.length();j++) {
				trans[k][j] = builder.charAt(j); //�� ������ ü���� �迭�� ����
			}
			k++; // ü���� �� ����, 
			
		}
				
		for(int i=0;i<trans.length;i++) { // ü������ Ž��
			for(int j=0;j<trans[i].length;j++) {									
						if(trans[i][j]!=black[i][j]) { // black�� ��Ģ���� ��ȯ�Ǵ� Ƚ��
							cnt_b++;
						}		
						if(trans[i][j]!=white[i][j]) { // white�� ��Ģ���� ��ȯ�Ǵ� Ƚ��
							cnt_w++;
						}			
				}			
				
			}
		
		
		
		return Math.min(Math.min(cnt_w, cnt_b), min); // min���� �ٸ� ü���ǿ��� �߻��� �ּڰ�
        											  // ù ��° ���ڴ� ���� ü���ǿ��� black�� white�� ��ȯȽ�� �� �ּڰ�
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Input
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new char [n][m];
		
		trans = new char [8][8]; 
		for(int i=0;i<n;i++) { // �� ������ �Է�
			String row = sc.next();
			
			for(int j=0;j<m;j++) {
				arr[i][j] = row.charAt(j);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<=n-8;i++) {// (0,0) ~ (n-8, m-8)�� ������ŭ �������� ����
			for(int j=0;j<=m-8;j++) {
				min =trans(i,j,min); // ���� �޼ҵ�� �������� ������� ���� ü���� �� �ּڰ� ����
				
			}
			
		}
		System.out.println(min);//output
		
	}

}
