
import static java.lang.System.currentTimeMillis;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrs_p
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //DOC DE EXCEL PARA VER TIEMPOS
        int[] arr = new int[1000000];
        
        /*arr[0] = 23;
        arr[1] = 78;
        arr[2] = 45;
        arr[3] = 8;
        arr[4] = 99;*/
        
        for(int i = 0; i < 1000000; i++) {
            arr[i] = (int)(Math.random() * 100 + 1);
        }
        
        //imprimir(arr);
        
        /*long ini = System.nanoTime();  //currentTimeMillis();
        selectionSort(arr);
        long fin = System.nanoTime();
        long total = fin - ini;
        //imprimir(arr);
        System.out.println(total);*/
        
        /*long ini = System.nanoTime();  //currentTimeMillis();
        insertionSort(arr);
        long fin = System.nanoTime();
        long total = fin - ini;
        //imprimir(arr);
        System.out.println(total);*/
        
        long ini = System.nanoTime();  //currentTimeMillis();
        bubbleSort(arr);
        long fin = System.nanoTime();
        long total = fin - ini;
        //imprimir(arr);
        System.out.println(total);
        
        /*quickSort ob = new quickSort();
        long ini = System.nanoTime();  //currentTimeMillis();
        ob.sort(arr, 0, arr.length -1);
        long fin = System.nanoTime();
        long total = fin - ini;
        //imprimir(arr);
        System.out.println(total);*/
        
        /*Scanner s = new Scanner(System.in);
        System.out.println("Valor a buscar");
        int buscar = s.nextInt();
        int resultado = binarySearch(arr, buscar);
        System.out.println(resultado);
        
        System.out.println("Valor a buscar");
        int key = s.nextInt();
        int resu = secSearch(arr, key);
        System.out.println(resu);*/
        
    }
    
    public static void selectionSort(int[] arr) {
        if(arr == null) {
            System.out.println("El arreglo está vacio");
        } else {
            int n;
            int i;
            int o;
            int num;
            for (o = 0; o < arr.length - 1; o++) {
                n = o;
                for(i = o+1; i < arr.length; i++) {
                    if(arr[i] < arr[n]) {
                        n = i;
                    }
                }
                num = arr[n];
                arr[n] = arr[o];
                arr[o] = num;
            }
            
            
            /*for(int g : arr) {
                System.out.print("[" + g + "]");
            }
            
            System.out.println("");*/
        }
    }
    
    public static void insertionSort(int[] arr) {
        if(arr == null) {
            System.out.println("El arreglo está vacío");
        } else {
            for (int i=1; i<arr.length; ++i) {
                int n = arr[i];
                int j = i-1;
                while (j>=0 && arr[j] > n) {
                    arr[j+1] = arr[j];
                    j = j-1;
                }
                
                arr[j+1] = n;
            }
        }
       }
    
    
    public static void bubbleSort(int[] arr) {
        if(arr == null) {
            System.out.println("El arreglo está vacío");
        } else {
            for(int i = 0; i < arr.length - 1; i++) {
                for(int j = 0; j < arr.length - 1; j++) {
                    if(arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
            
            
            /*for(int g: arr) {
                System.out.print("[" + g + "]");
            }*/
        }
    }
    
    public static int binarySearch(int[] arr, int key) {
        return searchRec(arr, key, 0, arr.length-1);
    }
    
    private static int searchRec(int[] arr, int buscar, int low, int high) {
        int pos = -1;
        int mid = low + ((high - low) / 2);
        if(low <= high) {
                if(buscar == arr[mid]) { //TARAN, LO ENCONTRAMOS
                pos = mid;
            } else if(buscar < arr[mid]) {
                pos = searchRec(arr, buscar, low, mid-1);
            } else if(buscar > arr[mid]) {
                pos = searchRec(arr, buscar, mid+1, high);
            }
        }
        
        return pos;
    }
    
    public static int secSearch(int[] arr, int buscar) {
        //int pos = -1;
        for(int i = 0; i < arr.length-1; i++) {
            if(buscar == arr[i]) {
                /*pos = i;
                break;*/
                return i;
            }
        }
        
        return -1;
    }
    
    
    public static void imprimir(int[] arr) {
        for(int g : arr) {
            System.out.print("[" + g + "]");
        }
        System.out.println("");
    }
    
}

class quickSort {
    private int[] numbers;
    private int number;
    
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {

            if (arr[j] <= pivot)
            {
                i++;
 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
       
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);

            
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}