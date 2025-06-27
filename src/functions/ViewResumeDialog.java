package functions;

import javax.swing.*;

import database.ResumeService;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ViewResumeDialog extends JDialog {
    private DefaultListModel<String> resumeListModel;
    private JList<String> resumeList;
    private JButton btnAdd, btnRemove, btnClose;
    private int seekerId;

    public ViewResumeDialog(Frame parent, int seekerId) {
        super(parent, "Manage Resumes", true);
        this.seekerId = seekerId;
        setLayout(null);
        setSize(400, 350);

        resumeListModel = new DefaultListModel<>();
        resumeList = new JList<>(resumeListModel);
        JScrollPane scrollPane = new JScrollPane(resumeList);
        scrollPane.setBounds(30, 30, 320, 150);
        add(scrollPane);

        btnAdd = new JButton("Add Resume");
        btnAdd.setBounds(30, 200, 120, 30);
        add(btnAdd);

        btnRemove = new JButton("Remove Resume");
        btnRemove.setBounds(160, 200, 140, 30);
        add(btnRemove);

        btnClose = new JButton("Close");
        btnClose.setBounds(310, 260, 70, 30);
        add(btnClose);

        // Load resumes
        loadResumes();

        btnAdd.addActionListener(e -> addResume());
        btnRemove.addActionListener(e -> removeSelectedResume());
        btnClose.addActionListener(e -> setVisible(false));

        setLocationRelativeTo(parent);
    }

    private void loadResumes() {
        resumeListModel.clear();
        List<String> resumes = ResumeService.getInstance().getResumesForSeeker(seekerId);
        for (String path : resumes) {
            resumeListModel.addElement(path);
        }
    }

    private void addResume() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            boolean success = ResumeService.getInstance().addResume(seekerId, filePath);
            if (success) {
                loadResumes();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add resume.");
            }
        }
    }

    private void removeSelectedResume() {
        int idx = resumeList.getSelectedIndex();
        if (idx != -1) {
            String filePath = resumeListModel.get(idx);
            boolean success = ResumeService.getInstance().removeResume(seekerId, filePath);
            if (success) {
                loadResumes();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove resume.");
            }
        }
    }
}
