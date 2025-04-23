import java.util.ArrayList;

public class  Sorter{
    public static void selectionSort(ArrayList<Sports> list){
        for(int i=0;i<list.size()-1; i++){
           int minimumIndex=i;

        for(int k=i+1; k<list.size(); k++){
            if(list.get(k).getPlayerCount()<list.get(minimumIndex).getPlayerCount()){
                minimumIndex=k;
            }
        }
        Sports temp=list.get(i);
        list.set(i, list.get(minimumIndex));
        list.set(minimumIndex,temp);

        }

    }
    public static void insertionSort(ArrayList<Sports> list){
        for(int i=1; i<list.size();i++){

            Sports key= list.get(i);
            int j=i-1;
        
        while(j>=0 && list.get(j).getPlayerCount()>key.getPlayerCount()){
            j--;

        }
        list.set(j+1 , key);
    }
    }
}