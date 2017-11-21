import java.util.Scanner;
//Ana lucia Diaz Leppe 151378
public class Particiones
{
    public static void print(int[]p, int n)
    {
        for(int i=0; i<n; i++)
            System.out.print(p[i]+" ");
        System.out.println();
    }
    
    // prepara recursiva
    public static void partition(int n) {
        partition(n, n, "");
    }
    // si la n determinada anteriormente es diferente a 0. se imprima la sumas acumulativas.
    //En las sumas acumulativas se determino n-i. En donde a la n ingresada le voy restando i. 
    public static void partition(int n, int max, String accumulated_sums) {
        // 
        if (n == 0) {
            System.out.println(accumulated_sums);
            return;
        }
        // recursive
        int i;
        for (i = Math.min(max, n); i >= 1; i--) {
            partition(n-i, i, accumulated_sums + " " + i);
        }
    }
    //codigo para generar la particion se realizo con un while con el objetivo que se va acumulando 
    //cada sumando de la particion 
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
    //pedir valores en el main. 
    public static void main(String args[])
    {
        System.out.println("Particiones de un numero entero");
        System.out.println("Ingresa el numero entero:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        partition(n);
        sc.close();
    }
}
