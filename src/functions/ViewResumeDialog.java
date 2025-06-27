// File: functions/ViewResumeDialog.java
package functions;

import javax.swing.*;
import database.ResumeService;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class ViewResumeDialog extends JDialog {
    private DefaultListModel<String> resumeListModel;
    private JList<String> resumeList;
    private List<String[]> resumes; // [filepath, filename]
    private JButton btnAdd, btnRemove, btnDownload, btnClose;
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

        btnDownload = new JButton("Download Resume");
        btnDownload.setBounds(30, 240, 140, 30);
        add(btnDownload);

        btnClose = new JButton("Close");
        btnClose.setBounds(310, 260, 70, 30);
        add(btnClose);

        loadResumes();

        btnAdd.addActionListener(e -> addResume());
        btnRemove.addActionListener(e -> removeSelectedResume());
        btnDownload.addActionListener(e -> downloadSelectedResume());
        btnClose.addActionListener(e -> setVisible(false));

        setLocationRelativeTo(parent);
    }

    private void loadResumes() {
        resumeListModel.clear();
        resumes = ResumeService.getInstance().getResumesForSeeker(seekerId);
        for (String[] resume : resumes) {
            resumeListModel.addElement(resume[1]); // Show filename
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
            String filePath = resumes.get(idx)[0];
            boolean success = ResumeService.getInstance().removeResume(seekerId, filePath);
            if (success) {
                loadResumes();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove resume.");
            }
        }
    }

 // In ViewResumeDialog.java
    private void downloadSelectedResume() {
        int idx = resumeList.getSelectedIndex();
        if (idx != -1) {
            String filePath = resumes.get(idx)[0];
            String filename = resumes.get(idx)[1];
            byte[] fileData = ResumeService.getInstance().getResumeBlob(seekerId, filename);
          
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(new File(filename));
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File destFile = fileChooser.getSelectedFile();
                boolean success = ResumeService.getInstance().downloadResume(seekerId, filePath, destFile, fileData, false);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Resume downloaded successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to download resume.");
                }
            }
        }
    }

    
    private byte[] getFileData(String filePath) {
        try (InputStream in = new FileInputStream(filePath);
             java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream()) {
            byte[] data = new byte[4096];
            int nRead;
            while ((nRead = in.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            return buffer.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
