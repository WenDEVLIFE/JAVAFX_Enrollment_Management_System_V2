/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

/**
 *
 * @author Administrator
 */
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


public class Print_Grades {
    private FileChooser fileChooser;
    private PDDocument document;
   private String subjectname;
   private String subject_Receiver;

    public Print_Grades() {
        this.fileChooser = new FileChooser(); // Initialize the fileChooser in the constructor
    this.subjectname = subjectname;
    this.subject_Receiver = subject_Receiver;
        // Set file extension filter to show only PDF files
        ExtensionFilter filter = new ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        this.fileChooser.getExtensionFilters().add(filter);
    }
   
    public void create_PDF_Grades(TableView<Grading> GradingTable, String getsubjectvalues) throws IOException {
        // Set up PDF document
        try {
            document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                PDType0Font font = PDType0Font.load(document, new File("src/font/arialbd.ttf"));

                // Your school name and logo
                String schoolName = "Mabini National High School";
                String logoPath = "src/pictures/mabini.png";

                // Adjust the Y-coordinate for the school name
                float schoolNameY = 630; // Adjust this value based on your desired position
                float schoolNameX = 210; // Adjust this value based on your desired position
                contentStream.beginText();
                contentStream.newLineAtOffset(schoolNameX, schoolNameY);
                contentStream.setFont(font, 18);
                contentStream.showText(schoolName);
                contentStream.endText();

                // Add logo
                PDImageXObject logo = PDImageXObject.createFromFile(logoPath, document);
                contentStream.drawImage(logo, 250, 650, logo.getWidth() / 4, logo.getHeight() / 4);

                contentStream.beginText();
                contentStream.newLineAtOffset(220, 610);
                contentStream.setFont(font, 8);
                contentStream.showText("Km. 6, Narra Street, Bangkal, Davao City, Philippines");
                contentStream.endText();

                // Add event name
                contentStream.beginText();
                contentStream.newLineAtOffset(220, 580);
                contentStream.setFont(font, 12);
                contentStream.showText("Enrollment Management System");
                contentStream.endText();

                contentStream.beginText();
                contentStream.newLineAtOffset(250, 560);
                contentStream.setFont(font, 12);
                contentStream.showText("Subject Name:" +    getsubjectvalues);
                contentStream.endText();

                // Add table headers
                float xStart = 30;
                float yStart = 500;
                float tableHeight = 30;
                float rowHeight = 30;

                // Dynamically calculate header cell width based on content
                float[] columnWidths = calculateColumnWidths(GradingTable);
                for (TableColumn<Grading, ?> column : GradingTable.getColumns()) {
                    // Skip the "Delete" column
                   if (column.getText().equals("Delete") || column.getText().equals("Edit")) {
                            continue;
                        }

                    float headerCellWidth = columnWidths[GradingTable.getColumns().indexOf(column)];

                    // Draw rectangle
                    contentStream.setLineWidth(0.5f);
                    contentStream.addRect(xStart, yStart, headerCellWidth, tableHeight);
                    contentStream.stroke();

                    // Add text
                    contentStream.beginText();
                    contentStream.setFont(font, 8);
                    contentStream.newLineAtOffset(xStart + 5, yStart + 5); // Adjust text position within cell
                    contentStream.showText(column.getText());
                    contentStream.endText();

                    xStart += headerCellWidth;
                }

                // Add table data
                yStart -= rowHeight;
                for (Grading grading : GradingTable.getItems()) {
                    xStart = 30; // Reset xStart for each row

                    for (TableColumn<Grading, ?> column : GradingTable.getColumns()) {
                        // Skip the "Delete" column
                        if (column.getText().equals("Delete") || column.getText().equals("Edit")) {
                            continue;
                        }

                        float headerCellWidth = columnWidths[GradingTable.getColumns().indexOf(column)];

                        // Draw rectangle
                        contentStream.setLineWidth(0.5f);
                        contentStream.addRect(xStart, yStart, headerCellWidth, tableHeight);
                        contentStream.stroke();

                        // Add text
                        contentStream.beginText();
                        contentStream.setFont(font, 8);
                        contentStream.newLineAtOffset(xStart + 5, yStart + 5); // Adjust text position within cell
                        contentStream.showText(String.valueOf(column.getCellData(grading)));
                        contentStream.endText();

                        xStart += headerCellWidth;
                    }
                    yStart -= rowHeight;
                }
            }

            // Show the file chooser dialog
            File selectedFile = fileChooser.showSaveDialog(null);

            if (selectedFile != null) {
                // Get the selected file
                String iconPath = "src/pictures/icons8-reports-58.png";

                // Create an ImageIcon from the specified file path
                Image image = new Image(new File(iconPath).toURI().toString());

                // Create a confirmation dialog
                Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);
                confirmationDialog.setTitle("PDF Message");
                confirmationDialog.setHeaderText(null);
                confirmationDialog.setContentText("The data is saved through PDF");
                confirmationDialog.setGraphic(new ImageView(image));

                // Customize the buttons (Yes, No)
                ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
                confirmationDialog.getButtonTypes().setAll(yesButton, noButton);

                // Show the dialog and wait for a response
                Optional<ButtonType> result = confirmationDialog.showAndWait();

                // Check the user's choice
                if (result.isPresent() && result.get() == yesButton) {
                    // Save the PDF file to the selected location
                    document.save(selectedFile.getAbsolutePath() + ".pdf");
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

    private float[] calculateColumnWidths(TableView<Grading> GradingTable) {
    int numColumns = GradingTable.getColumns().size();
    float[] columnWidths = new float[numColumns];

    try {
        PDType0Font font = PDType0Font.load(document, new File("src/font/arialbd.ttf"));

        for (int col = 0; col < numColumns; col++) {
            TableColumn<Grading, ?> column = GradingTable.getColumns().get(col);

            float maxWidth = font.getStringWidth(column.getText()) / 1000 * 8; // Adjust font size if needed

            for (Grading grading : GradingTable.getItems()) {
                String value = String.valueOf(column.getCellData(grading));
                float width = font.getStringWidth(value) / 1000 * 8; // Adjust font size if needed

                // Set a maximum width (e.g., 150)
                maxWidth = Math.max(maxWidth, width);
            }

            columnWidths[col] = maxWidth + 10; // Add padding
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return columnWidths;
}
}