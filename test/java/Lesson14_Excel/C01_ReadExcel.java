package Lesson14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {

        //  dosya yolunu bir string degiskenine ata
        String dosyaYolu = "src/test/resources/files/ulkeler.xlsx";

        //  FileInputStream objesi olustur ve parametre olarak dosya yolunu kullan
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //  Workbook objesi olustur ve parametre olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        //  WoorkbookFactory.create(fileInputStream)

        //  Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");

        //  Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(3);

        //  Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(3);

        /*
        index sifirdan baslar

        siralama yukarida ki gibi olmali
         */

        String expectedData = "Cezayir";
        String actualData = cell.toString();

        Assert.assertEquals(expectedData,actualData);



    }
}
