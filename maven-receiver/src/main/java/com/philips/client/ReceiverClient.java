package com.philips.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import com.philips.operations.CsvWrite;
import com.philips.operations.WordCount;
import com.philips.service.ICount;
import com.philips.service.IWriter;

public class ReceiverClient {

	public static void main(String[] args) {
		
		BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		ICount wc = new WordCount(reader);
		IWriter writer = new CsvWrite();
		Map<String, Integer> wordCountMap = wc.generateWordCount();
		wc.printWordCount(wordCountMap);
		writer.generateCsvFile(wordCountMap, "G:\\Philips\\Bootcamp\\review-case-s3b1\\maven-receiver\\src\\main\\resources\\word-count.csv");
	}

}