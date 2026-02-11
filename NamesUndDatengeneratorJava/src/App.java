import javax.swing.*;

import java.awt.*;
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

//    static void AddElements(JFrame f) {
//        countryBox = new JComboBox<>();
//
//        countryBox.setBounds(30, 30, 150, 20);
//
//        for (String country : countries) {
//            countryBox.addItem(country);
//        }
//
//        f.add(countryBox);
//
//        JButton button = new JButton("Generate");
//        button.setBounds(350, 30, 150, 30);
//
//        button.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ButtonPressed();
//            }
//        });
//
//        f.add(button);
//
//        workerCount = new JTextField();
//        workerCount.setBounds(250, 30, 50, 20);
//
//        f.add(workerCount);
//    }

    static void ConfigureLayout(JFrame f){
        Panel panel = new Panel();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        panel.setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,10,10);
        panel.add(createLabel("Land: "), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(createLabel("Datensätze: "), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        countryBox = createCombobox(countries);
        panel.add(countryBox, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        workerCount = createTextField();
        workerCount.setBounds(0,0,50,20);
        panel.add(workerCount, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        JButton button = createButton("Generieren");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonPressed();
            }
        });
        panel.add(button, gbc);

        f.add(panel);
        f.pack();
    }

    static JLabel createLabel (String txt){
        JLabel label = new JLabel();
        label.setText(txt);
        label.setOpaque(true);
        return label;
    }

    static JComboBox<String> createCombobox (ArrayList<String> content){
        JComboBox<String> cb = new JComboBox<>();

        for (String addContent : content) {
            cb.addItem(addContent);
        }
        return cb;
    }

    static JTextField createTextField (){
        return new JTextField();
    }

    static JButton createButton(String txt){
        return new JButton(txt);
    }

    static JFrame ConfigureFrame() {
        JFrame f = new JFrame();

        ConfigureLayout(f);

        // 400 width and 500 height
        f.setSize(550, 400);

        // using no layout managers
        f.setLayout(null);

        // making the frame visible
        f.setVisible(true);

        return f;
    }

    static void ButtonPressed() {
        String selectedCountry = (String) countryBox.getSelectedItem();
        int workers = Integer.parseInt(workerCount.getText().length() > 0 ? workerCount.getText() : "1");
        System.out.println("Selected country: " + selectedCountry);
        System.out.println("Number of workers: " + workers);
    }
}
