/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javafx.functions;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Administrator
 */
public class Printreports {
 private FileChooser fileChooser;
    private PDDocument document;


    public Printreports() {
        this.fileChooser = new FileChooser(); // Initialize the fileChooser in the constructor

        // Set file extension filter to show only PDF files
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        this.fileChooser.getExtensionFilters().add(filter);
    }
   
    public void create_PDF_Grades(TableView<Reports> ReportTable) throws IOException {
    // Set up PDF document
    try {
        document = new PDDocument();

        // Calculate the height of a page
        float pageHeight = PDRectangle.A4.getHeight();  // Adjust as needed

        // Calculate the height of the table (including headers)
        float tableHeight = calculateTableHeight(ReportTable);

        // Calculate the number of pages needed
        int numPages = (int) Math.ceil(tableHeight / pageHeight);

        for (int pageIndex = 0; pageIndex < numPages; pageIndex++) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                PDType0Font font = PDType0Font.load(document, new File("src/font/arialbd.ttf"));

                // Draw the table for the current page
               drawTableOnPage(contentStream, ReportTable, font, pageIndex, pageHeight);

                // Add page number (optional)
                contentStream.beginText();
                contentStream.setFont(font, 10);
                contentStream.newLineAtOffset(520, 30);
                contentStream.showText("Page " + (pageIndex + 1));
                contentStream.endText();
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
            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
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
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("System Message");
                        alert.setHeaderText(null); // You can add header text if desired
                        String iconPath11 = "pictures/pdf.png";
                        // Load the PNG image
                        Image iconImage11 = new Image(iconPath11);

                        ImageView imageView1 = new ImageView(iconImage11);
                        imageView1.setFitWidth(64);
                        imageView1.setFitHeight(64);
                        alert.getDialogPane().setGraphic(imageView1);

                        // Set content text with user variable
                        String contentText = String.format("The PDF has successfully saved");
                        alert.setContentText(contentText);

                        alert.showAndWait();
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

private float calculateTableHeight(TableView<Reports> ReportTable) {
    float tableHeight = 0;
    float rowHeight = 30;  // Adjust as needed

    // Calculate the height of the headers
    tableHeight += rowHeight;

    // Calculate the height of the data rows
    tableHeight += rowHeight * ReportTable.getItems().size();

    return tableHeight;
}

private void drawTableOnPage(PDPageContentStream contentStream, TableView<Reports> ReportTable, PDType0Font font, int pageIndex, float pageHeight) throws IOException {
    float xStart = 210;
    float yStartHeader = 750;
    float yStartData = 720;
    float tableHeight = 30;
    float rowHeight = 30;

    float[] columnWidths = calculateColumnWidths(ReportTable);
    if (pageIndex ==0){
                  // Your school name and logo
            String schoolName = "Apolinario Mabini National High School";
String logoPath = "src/pictures/mabini.png";

// Adjust the Y-coordinate for the school name
float schoolNameY = 440; // Adjust this value based on your desired position
float schoolNameX = 140; // Adjust this value based on your desired position

contentStream.beginText();
contentStream.newLineAtOffset(schoolNameX, schoolNameY);
contentStream.setFont(font, 20);
contentStream.showText(schoolName);
contentStream.endText();

// Add logo
PDImageXObject logo = PDImageXObject.createFromFile(logoPath, document);
contentStream.drawImage(logo, 230, 480, logo.getWidth() / 4, logo.getHeight() / 4);

// Address
contentStream.beginText();
contentStream.newLineAtOffset(120, 380);
contentStream.setFont(font, 16);
contentStream.showText("Km. 6, Narra Street, Bangkal, Davao City, Philippines");
contentStream.endText();

// Event name
contentStream.beginText();
contentStream.newLineAtOffset(200, 360);
contentStream.setFont(font, 16);
contentStream.showText("Enrollment Management System");
contentStream.endText();

// Report Table
contentStream.beginText();
contentStream.newLineAtOffset(260, 330);
contentStream.setFont(font, 16);
contentStream.showText("Report Table");
contentStream.endText();
    }
    else  if (pageIndex >= 1) {

        for (TableColumn<Reports, ?> column : ReportTable.getColumns()) {
            if (column.getText().equals("Delete")) {
                continue;
            }
        float headerCellWidth = columnWidths[ReportTable.getColumns().indexOf(column)];
            contentStream.setLineWidth(0.5f);
            contentStream.addRect(xStart, yStartHeader, headerCellWidth, tableHeight);
            contentStream.stroke();
            contentStream.beginText();
            contentStream.setFont(font, 8);
            contentStream.newLineAtOffset(xStart + 5, yStartHeader + 5);
            contentStream.showText(column.getText());
            contentStream.endText();
            xStart += headerCellWidth;
  
   
        }

        int numRowsPerPage = (int) Math.floor(pageHeight / rowHeight) - 1;
        int startIdx =(pageIndex - 1) * numRowsPerPage;
        int endIdx = Math.min(startIdx + numRowsPerPage, ReportTable.getItems().size());

        for (int i = startIdx; i < endIdx; i++) {
            xStart = 210;
            Reports reportselected = ReportTable.getItems().get(i);

            for (TableColumn<Reports, ?> column : ReportTable.getColumns()) {
                if (column.getText().equals("Delete") || column.getText().equals("Edit")) {
                    continue;
                }

                float headerCellWidth = columnWidths[ReportTable.getColumns().indexOf(column)];
                contentStream.setLineWidth(0.5f);
                contentStream.addRect(xStart, yStartData, headerCellWidth, tableHeight);
                contentStream.stroke();
                contentStream.beginText();
                contentStream.setFont(font, 8);
                contentStream.newLineAtOffset(xStart + 5, yStartData + 5);
                contentStream.showText(String.valueOf(column.getCellData(reportselected)));
                contentStream.endText();
                xStart += headerCellWidth;
            }

            yStartData -= rowHeight;

            if (yStartData < 50) {
                contentStream.close(); // Close the current content stream
                PDPage newPage = new PDPage();
                document.addPage(newPage);
                contentStream = new PDPageContentStream(document, newPage);
                yStartData = 750;
            }
        }
    }

    // Ensure the content stream is closed at the end
    contentStream.close();
}


    private float[] calculateColumnWidths(TableView<Reports> ReportTable) {
    int numColumns = ReportTable.getColumns().size();
    float[] columnWidths = new float[numColumns];

    try {
        PDType0Font font = PDType0Font.load(document, new File("src/font/arialbd.ttf"));

        for (int col = 0; col < numColumns; col++) {
            TableColumn<Reports, ?> column = ReportTable.getColumns().get(col);

            float maxWidth = font.getStringWidth(column.getText()) / 1000 * 8; // Adjust font size if needed

            for (Reports reportselected : ReportTable.getItems()) {
                String value = String.valueOf(column.getCellData(reportselected));
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
