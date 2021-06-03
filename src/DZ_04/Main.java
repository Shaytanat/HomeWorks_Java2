package DZ_04;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] godsOlimpusNames = {"Zeus", "Hera", "Athena", "Dionisus", "Poseidon", "Aid",
                "Ares", "Zeus", "Hera", "Demeter", "Poseidon", "Ares"};
        HashMap<String, Integer> godsHowMachRepeats = new HashMap<>();
        for (int i = 0; i < godsOlimpusNames.length; i++) {
            if (godsHowMachRepeats.containsKey(godsOlimpusNames[i])) {
                godsHowMachRepeats.put(godsOlimpusNames[i], godsHowMachRepeats.get(godsOlimpusNames[i]) + 1);
            } else {
                godsHowMachRepeats.put(godsOlimpusNames[i], 1);
            }
        }
        System.out.println(godsHowMachRepeats);

    }
}
