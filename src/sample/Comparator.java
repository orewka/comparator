package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparator {
    List<String> result1 = new ArrayList<>();
    List<String> result2 = new ArrayList<>();
    String chip;
    String[] temp;
    int start;
    int end;
    int q1;
    int q2;

    public void clearResults() {
        result1.clear();
        result2.clear();
    }

    public List<List<String>> compare(String in1, String in2) {
        String[] splitIn1 = in1.trim()
                               .toUpperCase()
                               .replace("С", "C")
                               .replace(" ","")
                               .split(",");
        String[] splitIn2 = in2.trim()
                               .toUpperCase()
                               .replace("С","C")
                               .replace(" ","")
                               .split(",");
        chip = splitIn1[0].contains("C") ? "C" : "R";
        scan(splitIn1, result1);
        scan(splitIn2, result2);
        finalScan(result1, result2);
        List<List<String>> res = new ArrayList<>();
        Collections.addAll(res , result1, result2);
        return res;
    }

    private void scan(String[] inputArr, List<String> inputList) {
        for (String s : inputArr) {
            if (s.contains("-")) {
                splitGenerator(s, inputList);
            } else {
                inputList.add(s);
            }
        }
        q1 = result1.size();
        q2 = result2.size();
    }

    private void splitGenerator(String input, List<String> inputList) {
        temp = input.replace(chip, "").split("-");
        start = Integer.parseInt(temp[0]);
        end = Integer.parseInt(temp[1]);
        for (int j = start; j < end+1; j++) {
            inputList.add(chip + j);
        }
    }

    private void finalScan(List<String> list1, List<String> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))) {
                list2.remove(list1.get(i));
                list1.remove(list1.get(i));
                i--;
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
    }
}
