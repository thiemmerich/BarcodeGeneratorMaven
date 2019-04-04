/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emmerich.util;

import java.io.File;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 *
 * @author estagiodev
 */
public class BarCodeGenerator {

    public void create128BBarCode(String code, String path) throws BarcodeException, OutputException {
        //Get 128B Barcode instance from the Factory
        Barcode barcode = BarcodeFactory.createCode128B(code);
        //Barcode barcode = BarcodeFactory.
        barcode.setBarHeight(60);
        barcode.setBarWidth(2);

        File imgFile = new File(path + code + ".png");

        //Write the bar code to PNG file
        BarcodeImageHandler.savePNG(barcode, imgFile);
    }
    
    public void createEAN13BarCode(String code, String path) throws BarcodeException, OutputException{
        
        Barcode barcode = BarcodeFactory.createEAN13(code);
        
        barcode.setBarHeight(60);
        barcode.setBarWidth(2);

        File imgFile = new File(path + code + ".png");

        BarcodeImageHandler.savePNG(barcode, imgFile);
    }
}
