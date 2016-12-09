package com.example;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UnZipCommandRunner implements CommandLineRunner {
	 private static final int BUFFER_SIZE = 4096;
	@Autowired
	private UnZipProperties properties;

	@Override
	public void run(String... args) throws Exception {
		File extractDir = new File(properties.getExtractDir());
		if (!extractDir.exists()) {
			extractDir.mkdirs();
		}
		ZipInputStream zipStream = new ZipInputStream(new FileInputStream(new File(properties.getZipFilePath())));
		ZipEntry zipEntry = zipStream.getNextEntry();
		while (zipEntry != null) {
			String filePath = extractDir + File.separator + zipEntry.getName();
			//System.out.println("extracting file:: "+zipEntry.getName());
			if (zipEntry.isDirectory()) {
				File file = new File(filePath);
				file.mkdir();
			} else {
				extractFile(zipStream,filePath);
			}
			zipEntry = zipStream.getNextEntry();
		}		
	}
	public void extractFile(ZipInputStream zipInputStream,String filePath) throws Exception
	{
		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
		byte[] bytes =new byte[BUFFER_SIZE];
		int readBytesCount =0;
		while((readBytesCount = zipInputStream.read(bytes))!=-1)
		{
			outputStream.write(bytes, 0, readBytesCount);
		}
		outputStream.flush();
		outputStream.close();
	}
}