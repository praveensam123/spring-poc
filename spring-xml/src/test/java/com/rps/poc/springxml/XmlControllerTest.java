package com.rps.poc.springxml;

import com.rps.poc.springxml.web.Subject;
import com.rps.poc.springxml.web.XmlController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class XmlControllerTest {

	private @Autowired XmlController xmlController;

	@Test
	public void produceXml_returns_OK() {
		ResponseEntity<Subject> responseEntity = xmlController.produceXml();
		//assertThat(responseEntity.getHeaders().getContentType(), equalTo(MediaType.APPLICATION_XML));
		assertThat(responseEntity.getStatusCode(), equalTo(ResponseEntity.ok().build().getStatusCode()));
		assertThat(responseEntity.getBody(), equalTo(subject()));
	}

	@Test
	public void consumeXml_returns_OK() {
		ResponseEntity<Subject> responseEntity = xmlController.consumeXml(subject());
		//assertThat(responseEntity.getHeaders().getContentType(), equalTo(MediaType.APPLICATION_XML));
		assertThat(responseEntity.getStatusCode(), equalTo(ResponseEntity.ok().build().getStatusCode()));
		assertThat(responseEntity.getBody(), equalTo(modifiedSubject()));
	}

	@Test
	public void consumeXmlFile_returns_OK() throws IOException {
		String fileName = "test.xml";
		byte[] bytes = Files.readAllBytes(Paths.get(fileName));
		MockMultipartFile mockMultipartFile = new MockMultipartFile(fileName, bytes);
		ResponseEntity<Subject> responseEntity = xmlController.consumeXmlFile(mockMultipartFile);
		//assertThat(responseEntity.getHeaders().getContentType(), equalTo(MediaType.APPLICATION_XML));
		assertThat(responseEntity.getStatusCode(), equalTo(ResponseEntity.ok().build().getStatusCode()));
		assertThat(responseEntity.getBody(), equalTo(modifiedSubject()));
	}

	private Subject subject() {
		return Subject.builder()
				.id(1)
				.name("maths")
				.description("Mathematics")
				.build();
	}

	private Subject modifiedSubject() {
		return Subject.builder()
				.id(1)
				.name("math")
				.description("Mathematics")
				.build();
	}

}
