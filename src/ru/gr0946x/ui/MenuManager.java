package ru.gr0946x.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuManager {

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");

        JMenuItem saveJpgItem = new JMenuItem("Сохранить как JPG...");
        saveJpgItem.addActionListener(this::showNotImplementedMessage);
        fileMenu.add(saveJpgItem);

        JMenuItem savePngItem = new JMenuItem("Сохранить как PNG...");
        savePngItem.addActionListener(this::showNotImplementedMessage);
        fileMenu.add(savePngItem);

        JMenuItem saveFracItem = new JMenuItem("Сохранить как FRAC...");
        saveFracItem.addActionListener(this::showNotImplementedMessage);
        fileMenu.add(saveFracItem);

        fileMenu.addSeparator();

        JMenuItem openFracItem = new JMenuItem("Открыть FRAC...");
        openFracItem.addActionListener(this::showNotImplementedMessage);
        fileMenu.add(openFracItem);

        menuBar.add(fileMenu);

        JMenu editMenu = new JMenu("Правка");

        JMenuItem undoItem = new JMenuItem("Отменить");
        undoItem.addActionListener(this::showNotImplementedMessage);
        editMenu.add(undoItem);

        JMenuItem redoItem = new JMenuItem("Повторить");
        redoItem.addActionListener(this::showNotImplementedMessage);
        editMenu.add(redoItem);

        menuBar.add(editMenu);

        JMenu viewMenu = new JMenu("Вид");

        JMenu formulaMenu = new JMenu("Формулы для построения");

        ButtonGroup formulaGroup = new ButtonGroup();
        JRadioButtonMenuItem formula1 = new JRadioButtonMenuItem("Формула RGB 1 (sin/cos)");
        JRadioButtonMenuItem formula2 = new JRadioButtonMenuItem("Формула RGB 2");
        JRadioButtonMenuItem formula3 = new JRadioButtonMenuItem("Формула RGB 3");

        formula1.setSelected(true);
        formula1.addActionListener(this::showNotImplementedMessage);
        formula2.addActionListener(this::showNotImplementedMessage);
        formula3.addActionListener(this::showNotImplementedMessage);

        formulaGroup.add(formula1);
        formulaGroup.add(formula2);
        formulaGroup.add(formula3);

        formulaMenu.add(formula1);
        formulaMenu.add(formula2);
        formulaMenu.add(formula3);

        JMenu colorSchemeMenu = new JMenu("Цветовая схема");

        ButtonGroup schemeGroup = new ButtonGroup();
        JRadioButtonMenuItem scheme1 = new JRadioButtonMenuItem("Схема 1 (по умолчанию)");
        JRadioButtonMenuItem scheme2 = new JRadioButtonMenuItem("Схема 2");
        JRadioButtonMenuItem scheme3 = new JRadioButtonMenuItem("Схема 3");

        scheme1.setSelected(true);
        scheme1.addActionListener(this::showNotImplementedMessage);
        scheme2.addActionListener(this::showNotImplementedMessage);
        scheme3.addActionListener(this::showNotImplementedMessage);

        schemeGroup.add(scheme1);
        schemeGroup.add(scheme2);
        schemeGroup.add(scheme3);

        colorSchemeMenu.add(scheme1);
        colorSchemeMenu.add(scheme2);
        colorSchemeMenu.add(scheme3);

        viewMenu.add(formulaMenu);
        viewMenu.add(colorSchemeMenu);

        menuBar.add(viewMenu);

        JMenu fractalMenu = new JMenu("Фрактал");

        JMenuItem tourItem = new JMenuItem("Экскурсия по фракталу");
        tourItem.addActionListener(this::showNotImplementedMessage);
        fractalMenu.add(tourItem);

        menuBar.add(fractalMenu);

        return menuBar;
    }

    private void showNotImplementedMessage(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        JOptionPane.showMessageDialog(
                null,
                "Функция \"" + source.getText() + "\" будет реализована позже",
                "Информация",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}