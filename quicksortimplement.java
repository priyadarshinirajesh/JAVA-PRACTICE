import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class quicksortimplement {

    public static List<Integer> quicksort(List<Integer> arr)  {
        if (arr.size()<=1) {
            return arr;
        }

        int mid = arr.size()/2;
        List<Integer> leftarr = new ArrayList<>();
        List<Integer> midarr = new ArrayList<>();
        List<Integer> rightarr = new ArrayList<>();

        for(int i=0;i<arr.size();i++) {
            if (arr.get(i) < arr.get(mid)) {
                leftarr.add(arr.get(i));
            }
            else if (arr.get(i) > arr.get(mid)) {
                rightarr.add(arr.get(i));
            }
            else {
                midarr.add(arr.get(i));
            }
        }

        List<Integer> final_list = new ArrayList<>();

        final_list.addAll(quicksort(leftarr));
        final_list.addAll(midarr);
        final_list.addAll(quicksort(rightarr));

        return final_list;

    }
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        int num = obj.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<num;i++)  {
            list.add(obj.nextInt());
        }
        quicksortimplement q = new quicksortimplement();
        System.out.println(q.quicksort(list));
    }
}
