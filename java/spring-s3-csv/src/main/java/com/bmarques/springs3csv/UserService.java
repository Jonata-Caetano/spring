package com.bmarques.springs3csv;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private AmazonS3 amazonS3;

    public List<Map<String, String>> getUser() throws IOException, CsvValidationException {
        String bucketName = "poc-spring-s3-csv";
        String objectName = "username.csv";

        S3Object s3object = amazonS3.getObject(bucketName, objectName);
        S3ObjectInputStream inputStream = s3object.getObjectContent();
//        CSVReaderHeaderAware reader = getReader(inputStream);

        List<Map<String, String>> records = new ArrayList<>();
        try (CSVReaderHeaderAware reader = getReader(inputStream)) {
            Map<String, String> values;

            while ((values = reader.readMap()) != null) {
                records.add(values);
            }
            return records;
        }
//        try {
//            FileUtils.copyInputStreamToFile(inputStream, new File("." + File.separator + objectName));
//        } catch (IOException e) {
//            log.error(e.getMessage());
//        }
    }

    private CSVReaderHeaderAware getReader(S3ObjectInputStream inputStream) {
        CSVParser parser = new CSVParserBuilder().build();
        var br = new InputStreamReader(inputStream);
        return (CSVReaderHeaderAware) new CSVReaderHeaderAwareBuilder(br)
                .withCSVParser(parser)
                .build();
    }
}
