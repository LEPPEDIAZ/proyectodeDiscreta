import java.math.*;
import java.util.*;


public class UniquePartition {

    private BigInteger n;
    private ArrayList<ArrayList<BigInteger>> allPartitions;

 
    public UniquePartition(int num) {
        n = new BigInteger(String.valueOf(num));
        allPartitions = new ArrayList<ArrayList<BigInteger>>();
        allPartitions = findPartitions();
    }   


    public UniquePartition(BigInteger num) {
        n = num;
        allPartitions = new ArrayList<ArrayList<BigInteger>>();
        allPartitions = findPartitions();
    }

    public ArrayList<ArrayList<BigInteger>> getPartitions() {
        return allPartitions;
    }

    public ArrayList<BigInteger> getPartitionN(int n) {
    //  ArrayList<ArrayList<BigInteger>> partitions = new ArrayList<ArrayList<BigInteger>>();
        return allPartitions.get(n);
    }

    public ArrayList<ArrayList<BigInteger>> findPartitions() {
        ArrayList<String> pS = new ArrayList<String>();
        pS = findPartitions(pS,n,n,"");

        for(int i=0;i<pS.size();i++) {
            ArrayList<BigInteger> partition = new ArrayList<BigInteger>();
            String line[] = (pS.get(i)).split(" ");
            for (String entry: line) {
                BigInteger num = new BigInteger(entry);
                partition.add(num);
            }
            allPartitions.add(partition);
        }

        return allPartitions;
    }

 
    public ArrayList<String> findPartitions(ArrayList<String> p, BigInteger target, BigInteger maxValue, String suffix) {
        if (target.equals(BigInteger.ZERO)) {
          //            System.out.println(suffix);
            p.add(suffix);
        }
        else {
            if (maxValue.compareTo(BigInteger.ONE) > 0)
                findPartitions(p, target, maxValue.subtract(BigInteger.ONE), suffix);
            if (maxValue.compareTo(target)<=0 && !containsInteger(maxValue,suffix))
                findPartitions(p, target.subtract(maxValue), maxValue, maxValue + " " + suffix);
        }
        return p;
    }

    public boolean containsInteger(BigInteger n, String s) {
        boolean b = false;
        String line[] = s.split(" ");
        for(String entry: line) {
            if(entry == "")
                entry = "0";
            BigInteger BI = new BigInteger(entry);
            if(n.equals(BI))
                b = true;
        }
        return b;
    }

    public String toString() {

        String output = "";     
        for(int i = 0;i<allPartitions.size();i++) {
            for(int j=0; j<(allPartitions.get(i)).size();j++) {
                output = output + (allPartitions.get(i)).get(j).toString()+" ";
            }
            output = output + "\n";
        }
        return output;
    }

    public String toString(int k) {

        String output = "";     
        for(int j=0; j<(allPartitions.get(k)).size();j++) {
            output = output + (allPartitions.get(k)).get(j).toString()+" ";
        }
        return output;
    }
}
