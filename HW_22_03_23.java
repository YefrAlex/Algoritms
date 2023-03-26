
public class HW_22_03_23 {
    public static void main(String[] args) {
        int x=2;
        int n=5;
        // System.out.println(getPow(x,n));
        int[] array1={100, 112, 256, 349, 770};
        int[] array2={72, 86, 113, 119, 265, 445, 892};
        int k=7;
        //  System.out.println( "значение позиции "+ k + " в итоговом массиве равно " + findNumberByIndex(array1,array2,k));
        int[] nums={1, 1, 2, 2, 2, 2, 3};
        int w=2;
        //System.out.println(countXinArray(nums, w, binaryserch(nums, w)));
        int r=5;
        int l=5;
        int[][] dobleArray=new int[r][l];
        findPick(r, l); // поиск пиков


    }
    /*
    1 уровень сложности: 1. Даны два целых числа x и n, напишите функцию для вычисления x^n
     решение 1 - рекурсивно O(n)
     решение 2 - улучшить решение 1 до O(lon n)
     */

    public static int getPow(int x, int n) {
        int result;
        if (n == 1) {
            result=x;
        } else {
            result=x * getPow(x, n - 1);
        }
        return result;
    }
    /*
    Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент, который будет находиться на k-й позиции в конечном отсортированном массиве.
Массив 1 - 100 112 256 349 770
Массив 2 - 72 86 113 119 265 445 892
к = 7
Вывод : 256
Окончательный отсортированный массив -
72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
7-й элемент этого массива равен 256.
     */
    // public static

    static int findNumberByIndex(int[] array1, int[] array2, int k) {
        int sum=array1.length + array2.length;
        int[] arraySummary=new int[sum];
        int j=0;
        int q=0;
        for (int i=0; i < sum; i++) {
            if (array1[j] <= array2[q]) {
                arraySummary[i]=array1[j];
                if (j == array1.length - 1) {
                    array1[j]=Integer.MAX_VALUE;
                } else {
                    j++;
                }
            } else {
                arraySummary[i]=array2[q];
                if (q == array2.length - 1) {
                    array2[q]=Integer.MAX_VALUE;
                } else {
                    q++;
                }
            }
        }
        return arraySummary[k - 1];
    }

    /*
    Имея отсортированный массив arr[] и число x, напишите функцию, которая подсчитывает вхождения x в arr[]. Ожидаемая временная сложность O(Log n)
arr[] = {1, 1, 2, 2, 2, 2, 3,}
x = 2
Вывод: 4 раза
     */
    static int binaryserch(int[] nums, int w) {
        int first=0;
        int second=nums.length - 1;
        int index=0;
        while (first <= second) {
            int middle=first + (second - first) / 2;
            if (nums[middle] == w) {
                index=middle;
                return index;
            }
            if (nums[middle] < w) {
                first=middle + 1;
            } else {
                second=middle - 1;
            }
        }
        return index;
    }

    static int countXinArray(int[] nums, int w, int index) {
        int count=1;
        int up=index;

        while (w == nums[up + 1]) {
            count++;
            up++;
        }
        while (w == nums[index - 1]) {
            count++;
            index--;
        }
        return count;
    }

    static void findPick(int r, int l) {
        int pick;
        int[][] helpArray=new int[r + 2][l + 2];
        for (int i=0; i < helpArray.length; i++) {
            for (int j=0; j < helpArray[i].length; j++) {
                if (i == 0 | j == 0 | i == helpArray.length - 1 | j == helpArray[i].length - 1) {
                    helpArray[i][j]=Integer.MIN_VALUE;
                } else {
                    helpArray[i][j]=(int) (Math.random() * 30);
                    System.out.print(helpArray[i][j] + " ");
                }
            }
            System.out.println();
        }
        for (int i=1; i < helpArray.length - 1; i++) {
            for (int j=1; j < helpArray[i].length - 1; j++) {

                if (helpArray[i][j] >= helpArray[i - 1][j] && helpArray[i][j] >= helpArray[i][j - 1] && helpArray[i][j] >= helpArray[i + 1][j] && helpArray[i][j] >= helpArray[i][j + 1]) {
                    pick=helpArray[i][j];
                    System.out.println(pick + " является пиковым числом");
                }
            }
        }
    }
}
/*

4* Найдите пиковый элемент в двумерном массиве
Элемент является пиковым, если он больше или равен своим четырем соседям слева, справа, сверху и снизу. Например,
соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1] и A[i][j+1 ].
Для угловых элементов отсутствующие соседи считаются отрицательными бесконечными значениями.
10 20 15
21 30 14
 7 16 32
Выход: 30
30 — пиковый элемент, потому что все его
соседи меньше или равны ему.
32 также можно выбрать в качестве пика.


note
1 Смежная диагональ не считается соседней.
2 Пиковый элемент не обязательно является максимальным элементом.
3 Таких элементов может быть несколько.
4 Всегда есть пиковый элемент.
 */
