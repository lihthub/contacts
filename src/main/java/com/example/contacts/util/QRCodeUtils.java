package com.example.contacts.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * 二维码工具类
 * 
 * @author Hollis
 */
public class QRCodeUtils {

	/**
	 * 将指定字符串编码为二维码
	 * 
	 * @param contents
	 *            二维码内容
	 * @param filePath
	 *            二维码生成路径
	 */
	public static void encode(String contents, String filePath, int width, int height) {
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "GBK");
		BitMatrix matrix = null;
		try {
			matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		File file = new File(filePath);
		try {
			MatrixToImageWriter.writeToPath(matrix, "png", file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析指定二维码
	 * 
	 * @param filePath
	 *            二维码路径
	 * @return 二维码内容
	 */
	public static String decode(String filePath) {
		File file = new File(filePath);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
		hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
		Result result = null;
		try {
			result = new MultiFormatReader().decode(bitmap, hints);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return result.toString();
	}
	
	/**
	 * 将指定字符串编码为二维码并输出到相应输出流
	 * 
	 * @param contents
	 *            二维码内容
	 * @param stream
	 *            二维码生成路径
	 */
	public static void encodeToStream(String contents, OutputStream stream, int width, int height) {
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "GBK");
		BitMatrix matrix = null;
		try {
			matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		try {
			MatrixToImageWriter.writeToStream(matrix, "png", stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
