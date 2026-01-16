
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener {

    private final Contact[] myList;
    private int count;

    private final JTextArea display;
    private final JTextField searchField;
    private final JTextField firstField;
    private final JTextField lastField;
    private final JTextField emailField;

    private final JButton firstBtn;
    private final JButton lastBtn;
    private final JButton userBtn;
    private final JButton domainBtn;
    private final JButton extBtn;
    private final JButton addBtn;
    private final JButton sortFirstBtn;
    private final JButton sortLastBtn;
    private final JButton sortUserBtn;

    public Screen() {
        myList = new Contact[10];
        count = 5;

        myList[0] = new Contact("John", "Smith", "john.smith@gmail.com");
        myList[1] = new Contact("Jane", "Doe", "janed@gmail.com");
        myList[2] = new Contact("George", "Washington", "gwashington@mvla.net");
        myList[3] = new Contact("Jennifer", "Smith", "1111111@mvla.net");
        myList[4] = new Contact("Alex", "Brown", "alexb@college.edu");

        display = new JTextArea(12, 35);
        display.setEditable(false);

        searchField = new JTextField(15);
        firstField = new JTextField(8);
        lastField = new JTextField(8);
        emailField = new JTextField(15);

        firstBtn = new JButton("First");
        lastBtn = new JButton("Last");
        userBtn = new JButton("Username");
        domainBtn = new JButton("Domain");
        extBtn = new JButton("Extension");

        addBtn = new JButton("Add");

        sortFirstBtn = new JButton("Sort First");
        sortLastBtn = new JButton("Sort Last");
        sortUserBtn = new JButton("Sort Username");

        firstBtn.addActionListener(this);
        lastBtn.addActionListener(this);
        userBtn.addActionListener(this);
        domainBtn.addActionListener(this);
        extBtn.addActionListener(this);
        addBtn.addActionListener(this);
        sortFirstBtn.addActionListener(this);
        sortLastBtn.addActionListener(this);
        sortUserBtn.addActionListener(this);

        JPanel top = new JPanel();
        top.add(searchField);
        top.add(firstBtn);
        top.add(lastBtn);
        top.add(userBtn);
        top.add(domainBtn);
        top.add(extBtn);

        JPanel addPanel = new JPanel();
        addPanel.add(firstField);
        addPanel.add(lastField);
        addPanel.add(emailField);
        addPanel.add(addBtn);

        JPanel sortPanel = new JPanel();
        sortPanel.add(sortFirstBtn);
        sortPanel.add(sortLastBtn);
        sortPanel.add(sortUserBtn);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(display), BorderLayout.CENTER);
        add(addPanel, BorderLayout.WEST);
        add(sortPanel, BorderLayout.SOUTH);

        updateDisplay();

        setTitle("Contacts");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updateDisplay() {
        display.setText("");
        for (int i = 0; i < count; i++) {
            display.append(myList[i].toString() + "\n");
        }
    }

    private void search(String type) {
        display.setText("");
        String key = searchField.getText();
        for (int i = 0; i < count; i++) {
            if (type.equals("first") && myList[i].getFirstName().equalsIgnoreCase(key)) {
                display.append(myList[i] + "\n");
            }
            if (type.equals("last") && myList[i].getLastName().equalsIgnoreCase(key)) {
                display.append(myList[i] + "\n");
            }
            if (type.equals("user") && myList[i].getUsername().equalsIgnoreCase(key)) {
                display.append(myList[i] + "\n");
            }
            if (type.equals("domain") && myList[i].getDomainName().equalsIgnoreCase(key)) {
                display.append(myList[i] + "\n");
            }
            if (type.equals("ext") && myList[i].getDomainExtension().equalsIgnoreCase(key)) {
                display.append(myList[i] + "\n");
            }
        }
    }

    private void sortBy(String type) {
        Arrays.sort(myList, 0, count, (a, b) -> {
            if (type.equals("first")) {
                return a.getFirstName().compareTo(b.getFirstName());
            }
            if (type.equals("last")) {
                return a.getLastName().compareTo(b.getLastName());
            }
            return a.getUsername().compareTo(b.getUsername());
        });
        updateDisplay();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == firstBtn) {
            search("first");
        }
        if (e.getSource() == lastBtn) {
            search("last");
        }
        if (e.getSource() == userBtn) {
            search("user");
        }
        if (e.getSource() == domainBtn) {
            search("domain");
        }
        if (e.getSource() == extBtn) {
            search("ext");
        }

        if (e.getSource() == addBtn && count < 10) {
            myList[count] = new Contact(firstField.getText(), lastField.getText(), emailField.getText());
            count++;
            updateDisplay();
        }

        if (e.getSource() == sortFirstBtn) {
            sortBy("first");
        }
        if (e.getSource() == sortLastBtn) {
            sortBy("last");
        }
        if (e.getSource() == sortUserBtn) {
            sortBy("user");
        }
    }
}
