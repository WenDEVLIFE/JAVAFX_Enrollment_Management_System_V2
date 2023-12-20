/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javafx.scene.control.TableColumn;

public class Print_Student {
    private FileChooser fileChooser;
    private PDDocument document;

    public Print_Student() {
        this.fileChooser = new FileChooser(); // Initialize the fileChooser in the constructor

        // Set file extension filter to show only PDF files
        ExtensionFilter filter = new ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        this.fileChooser.getExtensionFilters().add(filter);
    }

    public void create_PDF_Student(TableView<Student> EnrollTable) throws IOException {
        try {
            document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            PDType0Font font = PDType0Font.load(document, new File("src/font/arialbd.ttf"));

            // Your school name and logo
            String schoolName = "Mabini National High School";
            String logoPath = "src/pictures/mabini.png";

            float schoolNameY = 630;
            float schoolNameX = 210;
            contentStream.beginText();
            contentStream.newLineAtOffset(schoolNameX, schoolNameY);
            contentStream.setFont(font, 18);
            contentStream.showText(schoolName);
            contentStream.endText();

            PDImageXObject logo = PDImageXObject.createFromFile(logoPath, document);
            contentStream.drawImage(logo, 250, 650, logo.getWidth() / 4, logo.getHeight() / 4);

            contentStream.beginText();
            contentStream.newLineAtOffset(220, 610);
            contentStream.setFont(font, 8);
            contentStream.showText("Km. 6, Narra Street, Bangkal, Davao City, Philippines");
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(220, 580);
            contentStream.setFont(font, 12);
            contentStream.showText("Enrollment Management System");
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(260, 560);
            contentStream.setFont(font, 12);
            contentStream.showText("Student Table");
            contentStream.endText();

            float xStart = 30;
            float yStart = 500;
            float tableHeight = 30;
            float rowHeight = 30;

            float[] columnWidths = calculateColumnWidths(EnrollTable);
            for (TableColumn<Student, ?> column : EnrollTable.getColumns()) {
                if (column.getText().equals("Delete") || column.getText().equals("Edit")) {
                    continue;
                }

                float headerCellWidth = columnWidths[EnrollTable.getColumns().indexOf(column)];

                contentStream.setLineWidth(0.5f);
                contentStream.addRect(xStart, yStart, headerCellWidth, tableHeight);
                contentStream.stroke();
                contentStream.beginText();
                contentStream.setFont(font, 8);
                contentStream.newLineAtOffset(xStart + 5, yStart + 5);
                contentStream.showText(column.getText());
                contentStream.endText();
                xStart += headerCellWidth;
            }

            yStart -= rowHeight;
            PDPage newPage = null;
            PDPageContentStream newContentStream = null;

            for (Student student : EnrollTable.getItems()) {
                xStart = 30; // Reset xStart for each row

                if (yStart < 50) {
                    // Close the current content stream
                    contentStream.close();

                    // Create a new page
                    newPage = new PDPage();
                    document.addPage(newPage);

                    // Create a new content stream for the new page
                    newContentStream = new PDPageContentStream(document, newPage);
                    yStart = 500;
                }

                for (TableColumn<Student, ?> column : EnrollTable.getColumns()) {
                    if (column.getText().equals("Delete") || column.getText().equals("Edit")) {
                        continue;
                    }

                    float headerCellWidth = columnWidths[EnrollTable.getColumns().indexOf(column)];

                    (newContentStream != null ? newContentStream : contentStream).setLineWidth(0.5f);
                    (newContentStream != null ? newContentStream : contentStream).addRect(xStart, yStart, headerCellWidth, tableHeight);
                    (newContentStream != null ? newContentStream : contentStream).stroke();
                    (newContentStream != null ? newContentStream : contentStream).beginText();
                    (newContentStream != null ? newContentStream : contentStream).setFont(font, 8);
                    (newContentStream != null ? newContentStream : contentStream).newLineAtOffset(xStart + 5, yStart + 5);
                    (newContentStream != null ? newContentStream : contentStream).showText(String.valueOf(column.getCellData(student)));
                    (newContentStream != null ? newContentStream : contentStream).endText();
                    xStart += headerCellWidth;
                }

                yStart -= rowHeight;
            }

            if (newContentStream != null) {
                newContentStream.close(); // Close the last content stream
            }

            // Show the file chooser dialog
            File selectedFile = fileChooser.showSaveDialog(null);

            if (selectedFile != null) {
                String iconPath = "src/pictures/icons8-reports-58.png";

                Image image = new Image(new File(iconPath).toURI().toString());

                Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);
                String iconPath1 = "pictures/pdf.png";
                // Load the PNG image
                Image iconImage = new Image(iconPath1);

                ImageView imageView = new ImageView(iconImage);
                imageView.setFitWidth(64);
                imageView.setFitHeight(64);
                confirmationDialog.getDialogPane().setGraphic(imageView);
                confirmationDialog.setTitle("PDF Message");
                confirmationDialog.setHeaderText(null);
                confirmationDialog.setContentText("The data is saved through PDF");
                confirmationDialog.setGraphic(new ImageView(image));

                ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
                confirmationDialog.getButtonTypes().setAll(yesButton, noButton);

                Optional<ButtonType> result = confirmationDialog.showAndWait();

                if (result.isPresent() && result.get() == yesButton) {
                    document.save(selectedFile.getAbsolutePath() + ".pdf");
                    
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("System Message");
                        alert.setHeaderText(null); // You can add header text if desired
                        String iconPath11 = "pictures/pdf.png";
                        // Load the PNG image
                        Image iconImage11 = new Image(iconPath11);

                        ImageView imageView1 = new ImageView(iconImage11);
                        imageView.setFitWidth(64);
                        imageView.setFitHeight(64);
                        alert.getDialogPane().setGraphic(imageView1);

                        // Set content text with user variable
                        String contentText = String.format("The PDF has successfully saved");
                        alert.setContentText(contentText);

                        alert.showAndWait();
                
                    System.out.println("PDF created successfully at: " + selectedFile.getAbsolutePath() + ".pdf");
                } else {
                    System.out.println("PDF creation canceled by the user.");
                }
            } else {
                System.out.println("PDF creation canceled by the user.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private float[] calculateColumnWidths(TableView<Student> EnrollTable) {
        int numColumns = EnrollTable.getColumns().size();
        float[] columnWidths = new float[numColumns];

        try {
            PDType0Font font = PDType0Font.load(document, new File("src/font/arialbd.ttf"));

            for (int col = 0; col < numColumns; col++) {
                TableColumn<Student, ?> column = EnrollTable.getColumns().get(col);

                float maxWidth = font.getStringWidth(column.getText()) / 1000 * 12;

                for (Student student : EnrollTable.getItems()) {
                    String value = String.valueOf(column.getCellData(student));
                    float width = font.getStringWidth(value) / 1000 * 8;

                    if (width > maxWidth) {
                        maxWidth = width;
                    }
                }

                columnWidths[col] = maxWidth + 10;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    return columnWidths;
}
}