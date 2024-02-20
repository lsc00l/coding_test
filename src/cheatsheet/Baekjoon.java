package cheatsheet;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n, m;
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();

            for (int i = 0; i < m; i++) {

            }
        }
    }
    public static void main2(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(reader.readLine());

        for(int i=0; i<testcase; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            reader.readLine();
            writer.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())+"\n"));
        }

        writer.flush();
        writer.close();
    }
}