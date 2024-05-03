import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.*;
import org.apache.pdfbox.Loader;
import java.io.File;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;



class pdftoxls
{

    public static void main(String[] args)  {
        try
        {
            File file = new File("/Users/adityaanand/IdeaProjects/datamaticspdftoxls/HolidayList.pdf");
            PDDocument document = Loader.loadPDF(file);
            PDFTextStripper stripper = new PDFTextStripper();
            String pdfText = stripper.getText(document);
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");
             String[] lines = pdfText.split("\\r?\\n");

             // Populating Excel sheet
            int rowNum = 0;
            for (String line : lines) {
                String[] columns = line.split("\\s+"); // Split using whitespace
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (String column : columns) {
                    Cell cell = row.createCell(colNum++);
                    cell.setCellValue(column);
                }
            }
            // Writing  the Excel workbook to a file
            FileOutputStream outputStream = new FileOutputStream(new File("AdityaPDFtoXLS.xls"));
            workbook.write(outputStream);
            workbook.close();
            document.close();
            outputStream.close();

            System.out.println("PDF converted to XLS successfully.");
        }
        catch (Exception ex)
        {
            System.out.println("Exception :"+ex);
        }
    }
}
