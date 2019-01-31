import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] arr = {"Вася", "Петя", "Коля", "Петя", "Петя",
                "просто", "слово", "повторим", "слово", "слово", "Слово"};
        HashMap<String, Integer> hm = new HashMap<>();

        int value;

        for (String name: arr) {
            try {
                value = hm.get(name);
            }catch (NullPointerException ex){
                value = 0;
            }

            hm.put(name, value + 1);
        }

        for (Map.Entry<String , Integer> entry : hm.entrySet()){
            System.out.print(entry.getKey() + " - ");
            System.out.println(entry.getValue());
        }
    }


}
