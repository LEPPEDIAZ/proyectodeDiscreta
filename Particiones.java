import java.util.Scanner;
//Ana lucia Diaz Leppe 151378
//Byron Andrés Mota Hernández 15246		
public class Particiones{
    public static void print(int[]p, int n){
        for(int i=0; i<n; i++)
            System.out.print(p[i]+" ");
        System.out.println();
    }
    
    // prepara recursiva
    public static void partition(int n, int len) {
        partition(n, n, "",len);
    }
	public static int strangle(String archive){
		String temp = archive.replace(" ", "");
		return temp.length();
	}
    // si la n determinada anteriormente es diferente a 0. se imprima la sumas acumulativas.
    //En las sumas acumulativas se determino n-i. En donde a la n ingresada le voy restando i. 
    public static void partition(int n, int max, String accumulated_sums, int max_length) {
        // 
        if (n==0) {
			if(max_length==0){
				System.out.println(accumulated_sums);
			}else if(strangle(accumulated_sums)==max_length){
					System.out.println(accumulated_sums);
			}
            return;
        }
        // recursive
        int i;
        for (i = Math.min(max, n); i >= 1; i--) {
            partition(n-i, i, accumulated_sums + " " + i,max_length);
        }
    }
    //codigo para generar la particion se realizo con un while con el objetivo que se va acumulando 
    //cada sumando de la particion 
    public static void generatePartition(int n)
    {
        int []p = new int[n+n];
        int k = 0;
        p[k] = n;
        while(true){
            print(p, k=1);
            int rem_value = 0;
            while(k >= 0 && p[k] == 1){
                rem_value += p[k];
                k--;
            }
            if(k < 0)
                return;
            p[k]--;
            rem_value++;
            while(rem_value > p[k]){
                p[k+1] = p[k];
                rem_value -= p[k];
                k++;
            }
            p[k+1] = rem_value;
            k++;
        }
    }
    //pedir valores en el main. 
    public static void main(String args[]){
        System.out.println("Particiones de un numero entero");
        System.out.println("Ingresa el numero entero:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		System.out.println("Ingrese la longitud de la partición");
		int len=sc.nextInt();
        partition(n,len);
        sc.close();
    }
}
