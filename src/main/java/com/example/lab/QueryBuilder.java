package com.example.lab;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;


@Component
public class QueryBuilder {

	 private static Logger logger = LoggerFactory.logger(QueryBuilder.class);

	 public static String getStatement(final String file) {
	        try {
	            String result = FileUtils.readFileToString(new ClassPathResource("/query/"+file+".sql").getFile(), StandardCharsets.UTF_8);
	            return result;
	        } catch (IOException exception) {
	        	logger.error("IOException reading file [" + file + "].", exception);
	            throw new IllegalStateException("Error reading for file [" + file + "]", exception);
	        }
	    }
}
