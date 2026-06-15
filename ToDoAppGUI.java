import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoAppGUI {

    JFrame frame;
    JTextField textField;
    DefaultListModel<String> listModel;
    JList<String> taskList;

    public ToDoAppGUI() {

        // FRAME
        frame = new JFrame("To-Do App");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // TEXT FIELD
        textField = new JTextField();
        textField.setBounds(20, 20, 240, 30);
        frame.add(textField);

        // ADD BUTTON
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(270, 20, 90, 30);
        frame.add(addBtn);

        // LIST
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(20, 70, 340, 300);
        frame.add(scrollPane);

        // DELETE BUTTON
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(140, 390, 100, 30);
        frame.add(deleteBtn);

        // ADD ACTION
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = textField.getText();

                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    textField.setText("");
                }
            }
        });

        // DELETE ACTION
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();

                if (index != -1) {
                    listModel.remove(index);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoAppGUI();
    }
}