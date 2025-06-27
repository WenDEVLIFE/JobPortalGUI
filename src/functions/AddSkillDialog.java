// File: functions/AddSkillDialog.java
package functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import database.SkillService;

public class AddSkillDialog extends JDialog {
    private JTextField skillNameField;
    private JTextField proficiencyLevelField;
    private JButton addButton;
    private JButton deleteButton;
    private JTable skillsTable;
    private int seekerId;

    public AddSkillDialog(Frame parent, int seekerId, String title, boolean visible) {
        super(parent, title, true);
        this.seekerId = seekerId;
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Skill Name:"));
        skillNameField = new JTextField();
        inputPanel.add(skillNameField);

        inputPanel.add(new JLabel("Proficiency Level:"));
        proficiencyLevelField = new JTextField();
        inputPanel.add(proficiencyLevelField);

        addButton = new JButton("Add");
        addButton.addActionListener(e -> addSkill());
        inputPanel.add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteSkill());
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);
        
        if(!visible) {
			 addButton.setVisible(false);
			 deleteButton.setVisible(false);
		}

        skillsTable = new JTable();
        refreshSkillsTable();
        add(new JScrollPane(skillsTable), BorderLayout.CENTER);

        setSize(400, 300);
        setLocationRelativeTo(parent);
    }

    private void addSkill() {
        String skillName = skillNameField.getText();
        String proficiency = proficiencyLevelField.getText();
        try {
            SkillService.getInstance().addSkill(seekerId, skillName, proficiency);
            JOptionPane.showMessageDialog(this, "Skill added successfully!");
            refreshSkillsTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // New: Delete selected skill
    private void deleteSkill() {
        int selectedRow = skillsTable.getSelectedRow();
        if (selectedRow >= 0) {
            String skillName = (String) skillsTable.getValueAt(selectedRow, 0);
            try {
                SkillService.getInstance().deleteSkill(seekerId, skillName);
                JOptionPane.showMessageDialog(this, "Skill deleted successfully!");
                refreshSkillsTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a skill to delete.");
        }
    }

    private void refreshSkillsTable() {
        try {
            List<String[]> skills = SkillService.getInstance().getSkills(seekerId);
            String[] columnNames = {"Skill Name", "Proficiency Level"};
            String[][] data = skills.toArray(new String[0][]);
            skillsTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        } catch (Exception ex) {
            // Handle error
        }
    }
}
