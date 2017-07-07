package com.ddjc.basic;

import java.io.File;   
import java.util.Hashtable;   
  
import com.google.zxing.BarcodeFormat;   
import com.google.zxing.EncodeHintType;   
import com.google.zxing.MultiFormatWriter;   
import com.google.zxing.client.j2se.MatrixToImageWriter;   
import com.google.zxing.common.BitMatrix;   
import com.google.zxing.qrcode.QRCodeWriter;   
  
  
  
public class QRCodeEvents {   
       
    public static void main(String []args)throws Exception{   
        String text = "ÀÔ¥Û≈⁄ƒ„∫√";   
        int width = 100;   
        int height = 100;   
        String format = "png";   
        Hashtable hints= new Hashtable();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);   
        File outputFile = new File("F:\\new.png");   
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);          
    }   
}  
