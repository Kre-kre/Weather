package Icon;

import javax.swing.*;

public class DropDown {
    public static void main(String[] args) {
        String[] month = {"December",
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November"};

        String getMonth = (String) JOptionPane.showInputDialog(
                null,
                "Select month",
                "Average temperature",
                JOptionPane.QUESTION_MESSAGE,
                null,
                month,
                month[0]);
        String[] variant = {"a", "b", "c", "d"};

        String getVariant = (String) JOptionPane.showInputDialog(
                null,
                "Select variant",
                "Average temperature",
                JOptionPane.QUESTION_MESSAGE,
                null,
                variant,
                variant[0]);

        System.out.println("Your selected: " + getMonth + ". Your selected variant: " + getVariant);
    }
}