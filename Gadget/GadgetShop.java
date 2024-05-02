import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShop {
    private ArrayList<Gadget> gadgets;
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField,
            phoneNumberField, durationField, downloadSizeField, displayNumberField;
    private JFrame frame;
   
   

    public GadgetShop() {
        gadgets = new ArrayList<>();

        // Create frame
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8,10));


        // Initialize text fields
        modelField = new JTextField();
        priceField = new JTextField();
        weightField = new JTextField();
        sizeField = new JTextField();
        creditField = new JTextField();
        memoryField = new JTextField();
        phoneNumberField = new JTextField();
        durationField = new JTextField();
        downloadSizeField = new JTextField();
        displayNumberField = new JTextField();

        // Add components to frame
        frame.add(new JLabel("Model:"));
        frame.add(modelField);
        frame.add(new JLabel("Price:"));
        frame.add(priceField);
        frame.add(new JLabel("Weight:"));
        frame.add(weightField);
        frame.add(new JLabel("Size:"));
        frame.add(sizeField);
        
        
        frame.add(new JLabel(" Credit:"));
        frame.add(creditField);
        frame.add(new JLabel(" Memory:"));
        frame.add(memoryField);
        JButton addMobileButton = new JButton("Add Mobile");
        frame.add(addMobileButton);
        JButton addMP3Button = new JButton("Add MP3");
        frame.add(addMP3Button);
        JButton clearButton = new JButton("Clear");
        frame.add(clearButton);
        JButton displayAllButton = new JButton("Display All");
        frame.add(displayAllButton);
       
        
        
        
       
       
       
        frame.add(new JLabel("Phone Number:"));
        frame.add(phoneNumberField);
        frame.add(new JLabel("Duration:"));
        frame.add(durationField);
        frame.add(new JLabel("Download Size:"));
        frame.add(downloadSizeField);
        frame.add(new JLabel("Display Number:"));
        frame.add(displayNumberField);

        // Initialize buttons
       
        JButton makeACallButton = new JButton("Make A Call");
        JButton downloadMusicButton = new JButton("Download Music");

        // Add buttons to frame
       
        frame.add(makeACallButton);
        frame.add(downloadMusicButton);

        // Add action listeners to buttons
        addMobileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMobile();
            }
        });

        addMP3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMP3();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });

        makeACallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeACall();
            }
        });

        downloadMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadMusic();
            }
        });

        // Pack and display the frame
        frame.pack();
        frame.setVisible(true);
    }

    // Method to read model field
    private String getModel() {
        return modelField.getText();
    }

    // Method to read price field
    private double getPrice() {
        return Double.parseDouble(priceField.getText());
    }

    // Method to read weight field
    private int getWeight() {
        return Integer.parseInt(weightField.getText());
    }

    // Method to read size field
    private String getSize() {
        return sizeField.getText();
    }

    // Method to read initial credit field
    private int getInitialCredit() {
        return Integer.parseInt(creditField.getText());
    }

    // Method to read initial available memory field
    private int getInitialMemory() {
        return Integer.parseInt(memoryField.getText());
    }

    // Method to read phone number field
    private String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    // Method to read duration field
    private int getDuration() {
        return Integer.parseInt(durationField.getText());
    }

    // Method to read download size field
    private int getDownloadSize() {
        return Integer.parseInt(downloadSizeField.getText());
    }

    // Method to handle display number input
    private int getDisplayNumber() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                JOptionPane.showMessageDialog(frame, "Invalid display number.");
                return -1;
            }
            return displayNumber;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Display number must be an integer.");
            return -1;
        }
    }

    // Action method for adding a mobile
    private void addMobile() {
        String model = getModel();
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int credit = getInitialCredit();

        Mobile mobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(mobile);
    }

    // Action method for adding an MP3 player
    private void addMP3() {
        String model = getModel();
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int memory = getInitialMemory();

        MP3 mp3 = new MP3(model, price, weight, size, memory);
        gadgets.add(mp3);
    }

    // Action method for clearing all fields
    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
    }

    // Action method for displaying all gadgets
    private void displayAll() {
        for (int i = 0; i < gadgets.size(); i++) {
            System.out.println("Display Number: " + i);
            gadgets.get(i).display();
        }
    }

    // Action method for making a phone call
    private void makeACall() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1) {
            Mobile mobile = (Mobile) gadgets.get(displayNumber);
            String phoneNumber = getPhoneNumber();
            int duration = getDuration();
            mobile.makePhoneCall(phoneNumber, duration);
        }
    }

    // Action method for downloading music
    private void downloadMusic() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1) {
            MP3 mp3 = (MP3) gadgets.get(displayNumber);
            int downloadSize = getDownloadSize();
            mp3.downloadMusic(downloadSize);
        }
    }

    public static void main(String[] args) {
        // Create an instance of GadgetShop
        new GadgetShop();
    }
}
