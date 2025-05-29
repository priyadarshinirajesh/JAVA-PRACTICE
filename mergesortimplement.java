import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class mergesortimplement {

    public List<Integer> merge(List<Integer> left,List<Integer> right) {
        int left_index = 0;
        int right_index = 0;

        List<Integer> main_arr = new ArrayList<>();

        while(left_index<left.size() && right_index<right.size()) {

            if (left.get(left_index) <= right.get(right_index)) {
                main_arr.add(left.get(left_index));
                left_index += 1;
            }
            else {
                main_arr.add(right.get(right_index));
                right_index+=1;
            }
        }

        while (left_index < left.size()) {
            main_arr.add(left.get(left_index));
            left_index += 1;
        }

        while (right_index < right.size()) {
            main_arr.add(right.get(right_index));
            right_index+=1;
        }

        return main_arr;
    }

    public List<Integer> mergesort(List<Integer> arr) {
        if (arr.size()<=1) {
            return arr;
        }
        int mid = arr.size()/2;
        List<Integer> leftarr = mergesort(new ArrayList<>(arr.subList(0, mid))); 
        List<Integer> rightarr = mergesort(new ArrayList<>(arr.subList(mid, arr.size())));

        return merge(leftarr,rightarr);
    }
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the size of the list: ");
        int num = obj.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<num;i++) {
            list.add(obj.nextInt());
        }

        mergesortimplement m = new mergesortimplement();

        System.out.println(m.mergesort(list));
    }
}