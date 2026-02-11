import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Java.FileManager;

public class App {
    static JFrame frame;
    static ArrayList<String> countries;
    static JComboBox<String> countryBox;
    static JTextField workerCount;
    static FileManager fileManager;

    public static void main(String[] args) throws Exception {
        fileManager = new FileManager();
        countries = fileManager.getCountryNames();
        
        frame = ConfigureFrame();
    }

    static void AddElements(JFrame f) {
        countryBox = new JComboBox<>();

        countryBox.setBounds(30, 30, 150, 20);

        for (String country : countries) {
            countryBox.addItem(country);
        }

        f.add(countryBox);

        JButton button = new JButton("Select Country");
        button.setBounds(350, 30, 150, 30);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonPressed();
            }
        });

        f.add(button);

        workerCount = new JTextField();
        workerCount.setBounds(250, 30, 50, 20);
        
        f.add(workerCount);
    }

    static JFrame ConfigureFrame() {
        JFrame f = new JFrame();

        AddElements(f);

        // 400 width and 500 height
        f.setSize(500, 600);

        // using no layout managers
        f.setLayout(null);

        // making the frame visible
        f.setVisible(true);

        return f;
    }

    static void ButtonPressed() {
        String selectedCountry = (String) countryBox.getSelectedItem();
        int workers = Integer.parseInt(workerCount.getText().length() > 0 ? workerCount.getText() : "1");
    }
}
