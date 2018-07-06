
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Exercico_8 {

    public static void main(String[] args) {
        List<List<Integer>> arrayList = new ArrayList<>();
        {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            arrayList.add(list);
        }

        {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(10);
            list.add(5);
            arrayList.add(list);
        }

        
        Object[] toArray = arrayList.toArray();
        
        System.out.println();

    }

//    public static void main(String[] args) {
//        Integer a = 10256;
//        Integer b = 512;
//        System.out.println("Valores de Entrada: " + a + " - " + b);
//        String c = "";
//        int limite = Math.max(a.toString().length(), b.toString().length());
//        for (int i = 0; i <= limite; i++) {
//            if (i < a.toString().length()) {
//                c += a.toString().charAt(i);
//            }
//            if (i < b.toString().length()) {
//                c += b.toString().charAt(i);
//            }
//        }
//        int result = Integer.valueOf(c) > 1000000 ? -1 : Integer.valueOf(c);
//        System.out.println("Valor de Saída: " + result);
//    }
}
