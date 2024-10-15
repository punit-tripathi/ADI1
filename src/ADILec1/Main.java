package ADILec1;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinearProbhashtable h1=new LinearProbhashtable(10);

        h1.insert("hello");
        h1.insert("hello1");
        h1.insert("hello2");
        h1.insert("hello3");
        h1.insert("hello4");

//        h1.display();

        QuadraticProbhashtable h2=new QuadraticProbhashtable(10);

        h2.insert("hello");
        h2.insert("hello1");
        h2.insert("hello2");
        h2.insert("hello3");
        h2.insert("hello4");
        h2.insert("hello5");
        h2.insert("hello6");
        h2.insert("hello7");
        h2.insert("hello8");
        h2.insert("hello9");

        System.out.println(h2);



    }
}

class LinearProbhashtable{
    String [] hashtable;
    int capacity;

    LinearProbhashtable(int cap){
        hashtable=new String[cap];
        capacity=cap;
    }

    int hash(String key){
        return key.hashCode() % capacity;
    }

    void insert(String key){
        int hashIdx=hash(key);
        if(hashIdx < 0){
            hashIdx=hashIdx  * (-1);
        }

        while(hashtable[hashIdx] !=null){
            hashIdx=(hashIdx+1) % capacity;
        }
        hashtable[hashIdx]=key;
    }

    void display(){
        for(int i=0;i<capacity;i++){
            System.out.println(i + " " +hashtable[i]);
        }
    }



}

class QuadraticProbhashtable{
    String [] hashtable;
    int capacity;

    QuadraticProbhashtable(int cap){
        hashtable=new String[cap];
        capacity=cap;
    }

    int hash(String key){
        return key.hashCode() % capacity;
    }

    void insert(String key){
        int hashIdx=hash(key);
        int i=1;

        if(hashIdx < 0){
            hashIdx = hashIdx *(-1);
        }
        while(hashtable[hashIdx] != null){
            hashIdx = (hashIdx + i*i) % capacity;
            hashIdx = hashIdx *(-1);
            i++;
        }
        hashtable[hashIdx] = key;
    }

    void display(){
        for(int i=0;i<capacity;i++){
            System.out.println(i + " " +hashtable[i]);
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(hashtable);
    }
}

class Separatechainhashtable{
     LinkedList<String>[] hashtable;
     int capacity;

     Separatechainhashtable(int cap){
         hashtable = new LinkedList[cap];
         capacity=cap;

         for(int i=0;i<capacity;i++){
             hashtable[i]=new LinkedList<>();
         }
     }
     int hash(String key){
         return key.hashCode() % capacity;
     }
     void insert(String key){
         int hashIdx=hash(key);
         hashtable[hashIdx].add(key);
     }

     void display(){
         for(int i=0;i<capacity;i++){
             System.out.print(i + " ");
             for(String key:hashtable[i]){
                 System.out.print(key);
             }
             System.out.println();
         }

     }
}


