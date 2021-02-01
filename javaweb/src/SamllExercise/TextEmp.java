package SamllExercise;

import java.util.*;

import static java.util.Collections.*;

public class TextEmp {
    public static void main(String[] args) {
        List<Emp> emps = Emp.searchAll();

        ArrayList<Emp> emp = (ArrayList<Emp>) emps;

        Collections.sort(emp, new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return (int) (o1.getSalary()-o2.getSalary());
            }
        });

        for(Emp e:emps){
            System.out.println(e);
        }


    }
}
