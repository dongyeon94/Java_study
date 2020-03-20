package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeFinance {
    static int n, m, k;
    static int[][] arr, init;
    static List<ArrayList<ArrayList<TreeData>>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n*n 諛곗뿴
        m = sc.nextInt(); // �굹臾� �젙蹂� �닔
        k = sc.nextInt(); // K�뀈�씠 吏��궃�썑.

        arr = new int[n][n];
        init = new int[n][n]; // 異붽� �릺�뼱�빞�븷 �뼇遺�
        // n媛쒖쓽 arrayList �깮�꽦
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < n; j++)
                list.get(i).add(new ArrayList<>());
        }

        // 珥덇린 �뼇遺꾧컪
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                init[i][j] = sc.nextInt();
                arr[i][j] = 5; // 珥덇린 �뼇遺꾩� 5
            }
        }

        // m媛쒖쓽 以꾩뿉 �긽�룄媛� �떖�� �굹臾댁젙蹂댁닔 (x,y), �굹臾대굹�씠
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int age = sc.nextInt();
            list.get(x - 1).get(y - 1).add(new TreeData(true, age));
        }

        // K�뀈 �룞�븞
        for (int i = 0; i < k; i++) {
            // 1�뀈�� 4怨꾩젅
            solveSpring();
            solveSummer();
            solveFall();
            solveWinter();
        }

        // k�뀈�씠 �쓲瑜� �썑 �궡�븘�엳�뒗 �굹臾� 議곗궗
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += list.get(i).get(j).size();
            }
        }
        System.out.println(result);
    }

    // 寃⑥슱�뿉�뒗 �븙�뿉 �뼇遺꾩쓣 異붽��븳�떎. 媛� 移몄뿉 異붽��릺�뒗 �뼇遺꾩� 珥덇린 �엯�젰 �뼇遺꾩씠�떎.
    private static void solveWinter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] += init[i][j];
            }
        }
    }

    // 媛��쓣�뿉�뒗 �굹臾닿� 踰덉떇�븳�떎. �굹�씠媛� 5�쓽 諛곗닔�씤 �굹臾댁쓽
    // �씤�젒 8移몄뿉 �굹�씠媛� 1�씤 �굹臾닿� �깮湲대떎.
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private static void solveFall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < list.get(i).get(j).size(); k++) {
                    // age媛� 5�쓽 諛곗닔媛� �븘�땲�씪硫� �뙣�뒪
                    if (list.get(i).get(j).get(k).age % 5 == 0) {
                        for (int z = 0; z < dir.length; z++) {
                            int tx = i + dir[z][0];
                            int ty = j + dir[z][1];

                            // �빐�떦 移몄씠 �굹�씠媛� 1�씤 �굹臾� �깮�꽦
                            if (tx >= 0 && ty >= 0 && tx < n && ty < n) {
                                list.get(tx).get(ty).add(0, new TreeData(true, 1));
                            }
                        }
                    }
                }
            }
        }
    }

    // �뿬由꾩뿉�뒗 遊꾩뿉 二쎌� �굹臾닿� �뼇遺꾩쑝濡� 蹂��븳�떎.
    // 二쎌� �굹臾댁쓽 �굹�씠/2媛� �뼇遺꾩쑝濡� �빐�떦移몄뿉 異붽��맂�떎.
    private static void solveSummer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // �빐�떦 醫뚰몴�쓽 �굹臾대뱾�쓣 蹂대㈃�꽌 0�씤寃껋쓣 �뾾�븷二쇱옄.
                for (int k = 0; k < list.get(i).get(j).size(); k++) {
                    ArrayList<TreeData> groundData = list.get(i).get(j);
                    // 二쎌� �굹臾대씪硫�
                    if (!groundData.get(k).state) {
                        arr[i][j] += groundData.get(k).age / 2;
                        groundData.remove(k);
                        // k--瑜� �빐二쇱뼱 �뾾�뼱吏� 嫄몃줈 �씤�븳 �쁺�뼢�쓣 �뾾�븻�떎. �씤�뜳�뒪 議곗젅
                        k--;
                    }
                }
            }
        }
    }

    // 遊꾩뿉�뒗 �굹臾닿� �굹�씠留� �겮 �뼇遺꾩쓣 癒밴퀬 �굹�씠媛� +1 (�옄�떊移몃쭔 媛��뒫)
    // �븯�굹�쓽 移몄뿉 �뿬�윭 媛쒖쓽 �굹臾닿� �엳�뵲硫� �굹�씠 �뼱由� �굹臾닿� 癒쇱� 癒밸뒗�떎.
    // �뼇遺꾩씠 遺�議깊빐 癒뱀�紐삵븯硫� 癒뱀� �븡怨� 諛붾줈 利됱궗
    private static void solveSpring() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ArrayList<TreeData> groundData = list.get(i).get(j);
                // �굹臾� 寃��궗
                for (int k = 0; k < groundData.size(); k++) {
                    if (groundData.get(k).age > arr[i][j]) {
                        // �굹臾댁쓽 �굹�씠媛� �뜑 �겕�떎硫� 利됱궗
                        groundData.get(k).state = false;
                    } else {
                        // �빐�떦吏��뿭 �굹�씠 留뚰겮 �뼇遺� 媛먯냼 諛� �굹�씠 利앷�
                        arr[i][j] -= groundData.get(k).age++;
                    }
                }
            }
        }
    }

    static class TreeData {
        boolean state; // �긽�깭 (true �궡�쓬, false 二쎌쓬)
        int age; // �굹�씠

        TreeData(boolean state, int age) {
            this.state = state;
            this.age = age;
        }
    }
}