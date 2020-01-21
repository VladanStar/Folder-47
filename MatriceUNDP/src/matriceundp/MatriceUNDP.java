package matriceundp;

import java.util.Arrays;
import java.util.Scanner;

public class MatriceUNDP {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ucitaj broj vrsta matrice: ");
        int n = input.nextInt();
        System.out.print("Ucitaj broj kolona matrice: ");
        int m = input.nextInt();

        int mat[][] = new int[n][m];
        System.out.println("Ucitaj matricu dimenzija " + m + " x " + n);
        ucitajMatricu(mat);
        stampajMatricu(n, m, mat);
        sortirajVrste(mat);
        System.out.println("Stampaj nakon sortiranja: ");
        stampajMatricu(n, m, mat);
        System.out.println("Maxinmum je: " + max(mat, n, m));
        System.out.println("Minimum je: " + min(mat, n, m));
        System.out.println("Zbir: " + zbir(mat, n, m));
        System.out.println("Zbir dijagonale: " + zbirDijagonale(mat));
        System.out.println("Zbir sporedne: " + zbirSporedne(mat));
        System.out.println("Zbir dijagonala:  " + zbirDijagonala(mat));
        System.out.println("Broj parnih elemenata: " + brojParnihElemenata(mat));

    }

    private static void ucitajMatricu(int a[][]) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("a [" + i + "," + j + "] = ");
                a[i][j] = input.nextInt();

            }
        }
    }

    private static void stampajMatricu(int n, int m, int[][] mat) {
        System.out.println("Stampaj matricu dimenzija " + n + "," + m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println(" ");
        }

    }

    private static void sortirajVrste(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            Arrays.sort(mat[i]);
        }
    }

    private static int max(int[][] a, int n, int m) {
        int ma = a[0][0];
        int k = 0, p = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] > ma) {
                    ma = a[i][j];
                    k = i;
                    p = j;
                }
            }
        }
        System.out.println("Maksimum ima indekse: (" + k + ", " + p + ")");

        return ma;
    }

    private static int min(int[][] a, int n, int m) {
        int k = 0, p = 0;
        int mi = a[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] < mi) {
                    mi = a[i][j];
                    k = i;
                    p = j;
                }
            }
        }
        System.out.println("Minimum ima indekse:(" + k + ", " + p + ")");

        return mi;
    }

    private static int zbir(int[][] a, int n, int m) {
        int z = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                z += a[i][j];
            }
        }
        return z;
    }

    private static int zbirDijagonale(int[][] a) {
        int z = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) //Zbir parnih elemenata sa glavne dijagonale
            {
                if (i == j) {
                    z += a[i][j];
                }
            }
        }
        return z;
    }

    private static int zbirSporedne(int[][] mat) {
        int z = 0;

        for (int i = 0; i < mat.length; i++) {
            z += mat[i][mat.length - i - 1];
        }

        return z;
    }

    private static int zbirDijagonala(int a[][]) {
        return zbirDijagonale(a) + zbirSporedne(a);
    }

    private static int brojParnihElemenata(int[][] mat) {
 int par = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] % 2 == 0) {
                    par++;
                }
            }
        }
        return par;
    }

}
