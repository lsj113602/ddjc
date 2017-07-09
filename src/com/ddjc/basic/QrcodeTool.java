package com.ddjc.basic;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class QrcodeTool {
	public QrcodeTool(){}
	public String toBufferedImage(String path,String fileName,String text,int width,int height) throws WriterException, IOException{
		String format = "png";   
        Hashtable hints= new Hashtable();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);   
        String filePath= path + fileName;
        String returnPath = "/qrcode/" + fileName;
        //File outputFile = new File("F:\\new.png");   
        File outputFile = new File(filePath);   
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);   
        return returnPath;
	}

}
