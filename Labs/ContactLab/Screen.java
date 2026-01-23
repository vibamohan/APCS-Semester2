import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;
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

        addPlaceholder(searchField, "Search...");
        addPlaceholder(firstField, "First");
        addPlaceholder(lastField, "Last");
        addPlaceholder(emailField, "Email");

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

    private void addPlaceholder(JTextField field, String text) {
        field.setForeground(Color.GRAY);
        field.setText(text);

        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(text)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(text);
                }
            }
        });
    }

    private void updateDisplay() {
        display.setText("");
        for (int i = 0; i < count; i++) {
            display.append(myList[i] + "\n");
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
        mergeSort(myList, 0, count - 1, (a, b) -> {
            if (type.equals("first")) return a.getFirstName().compareTo(b.getFirstName());
            if (type.equals("last")) return a.getLastName().compareTo(b.getLastName());
            return a.getUsername().compareTo(b.getUsername());
        });
        updateDisplay();
    }

    private static void mergeSort(Contact[] contacts, int l, int r, Comparator<Contact> comparator) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(contacts, l, m, comparator);
            mergeSort(contacts, m + 1, r, comparator);
            merge(contacts, comparator, l, m, r);
        }
    }

    static void merge(Contact[] arr, Comparator<Contact> comparator, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Contact[] L = new Contact[n1];
        Contact[] R = new Contact[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (comparator.compare(L[i], R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == firstBtn) search("first");
        if (e.getSource() == lastBtn) search("last");
        if (e.getSource() == userBtn) search("user");
        if (e.getSource() == domainBtn) search("domain");
        if (e.getSource() == extBtn) search("ext");

        if (e.getSource() == addBtn && count < 10) {
            myList[count++] = new Contact(
                    firstField.getText(),
                    lastField.getText(),
                    emailField.getText()
            );
            updateDisplay();
        }

        if (e.getSource() == sortFirstBtn) sortBy("first");
        if (e.getSource() == sortLastBtn) sortBy("last");
        if (e.getSource() == sortUserBtn) sortBy("user");
    }
}
