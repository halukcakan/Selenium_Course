package Lesson14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        //  dosya yolunu bir string degiskenine ata
        String dosyaYolu = "src/test/resources/files/ulkeler.xlsx";

        //  FileInputStream objesi olustur ve parametre olarak dosya yolunu kullan
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //  Workbook objesi olustur ve parametre olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        //  WoorkbookFactory.create(fileInputStream)

        //  Sheet objesi olusturun workbook.getSheetAt(index)

        //  Row objesi olusturun sheet.getRow(index)

        //  Cell objesi olusturun row.getCell(index)
        String actutalData = workbook
                .getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();

        String expectedData = "Cezayir";
        Assert.assertEquals(expectedData,actutalData);
    }
}
