import java.util.Scanner;

public class Particiones
{
    public static void print(int[]p, int n)
    {
        for(int i=0; i<n; i++)
            System.out.print(p[i]+" ");
        System.out.println();
    }
    public static void generatePartition(int n)
    {
        int []p = new int[n+n];
        int k = 0;
        p[k] = n;
        while(true)
        {
            print(p, k=1);
            int rem_value = 0;
            while(k >= 0 && p[k] == 1)
            {
                rem_value += p[k];
                k--;
            }
            if(k < 0)
                return;
            p[k]--;
            rem_value++;
            while(rem_value > p[k])
            {
                p[k+1] = p[k];
                rem_value -= p[k];
                k++;
            }
            p[k+1] = rem_value;
            k++;
        }
    }
    public static void main(String args[])
    {
        System.out.println("Particiones de un numero entero");
        System.out.println("Ingresa el numero entero:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generatePartition(n);
        sc.close();
    }
}
