

import java.util.TreeSet; 

  

public class GFG { 

  

  

    static class Pair implements Comparable<Pair> { 

        private int value, index; 

  

  

        public Pair(int v, int p) 

        { 

            value = v; 

            index = p; 

        } 

  


       

        public int compareTo(Pair o) 

        { 

  

         

      

            if (index == o.index) { 

                return 0; 

            } 

            else if (value == o.value) { 

                return Integer.compare(index, o.index); 

            } 

            else { 

                return Integer.compare(value, o.value); 

            } 

        } 

  

 

        public int value() 

        { 

            return value; 

        } 

  

         

        public void renew(int v, int p) 

        { 

            value = v; 

            index = p; 

        } 

  

        

        public String toString() 

        { 

            return String.format("(%d, %d)", value, index); 

        } 

    } 

  

    static void printMedian(TreeSet<Pair> minSet, 

                            TreeSet<Pair> maxSet, int window) 

    { 

  
 

        if (window % 2 == 0) { 

            System.out.print((minSet.last().value() 

                              + maxSet.first().value()) 

                             / 2.0); 

            System.out.print(" "); 

        } 

  

    

        else { 

            System.out.print(minSet.size() > maxSet.size() 

                                 ? minSet.last().value() 

                                 : maxSet.first().value()); 

            System.out.print(" "); 

        } 

    } 

  


    static void findMedian(int arr[], int k) 

    { 

        TreeSet<Pair> minSet = new TreeSet<>(); 

        TreeSet<Pair> maxSet = new TreeSet<>(); 

  

       

        

        Pair[] windowPairs = new Pair[k]; 

  

        for (int i = 0; i < k; i++) { 

            windowPairs[i] = new Pair(arr[i], i); 

        } 

  

        // Add k/2 items to maxSet 

        for (int i = 0; i < k / 2; i++) { 

            maxSet.add(windowPairs[i]); 

        } 

  

        for (int i = k / 2; i < k; i++) { 

   

            if (arr[i] < maxSet.first().value()) { 

                minSet.add(windowPairs[i]); 

            } 

            else { 

                minSet.add(maxSet.pollFirst()); 

                maxSet.add(windowPairs[i]); 

            } 

        } 

  

        printMedian(minSet, maxSet, k); 

  

        for (int i = k; i < arr.length; i++) { 

  
 

            Pair temp = windowPairs[i % k]; 

            if (temp.value() <= minSet.last().value()) { 

  

                

                minSet.remove(temp); 

  

            

                temp.renew(arr[i], i); 

  

             

               

                if (temp.value() < maxSet.first().value()) { 

                    minSet.add(temp); 

                } 

                else { 

                    minSet.add(maxSet.pollFirst()); 

                    maxSet.add(temp); 

                } 

            } 

            else { 

                maxSet.remove(temp); 

                temp.renew(arr[i], i); 

  

             

             

                if (temp.value() > minSet.last().value()) { 

                    maxSet.add(temp); 

                } 

                else { 

                    maxSet.add(minSet.pollLast()); 

                    minSet.add(temp); 

                } 

            } 

  

            printMedian(minSet, maxSet, k); 

        } 

    } 

  

   

    public static void main(String[] args) 

    { 

        int[] arr = new int[] { 0, 9, 1, 8, 2, 

                                7, 3, 6, 4, 5 }; 

        int k = 3; 

  

        findMedian(arr, k); 

    } 
} 
