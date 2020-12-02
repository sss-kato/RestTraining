package jp.go.rest.request.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTestService {

	private static final String URL = "https://localhost:8443/test/1";

	@Autowired
	RestTemplate restTemplate;

//
	public ResponseEntity<String> requestRest() {
//
		// ヘッダ作成
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
//		String strjson = "{\"val\": 123}}";
		String strjson = "{\"val1\":\"Tanaka\", \"val2\":26,\"members\":[{\"name\":\"yamada\",\"age\":23},{\"name\":\"sato\",\"age\":21}]}";
 		ResponseEntity<String> res = null;
		try {
			RequestEntity<String> req = new RequestEntity<>(strjson, headers, HttpMethod.POST, new URI(URL));

			ResponseEntity<String> test = restTemplate.exchange(req, String.class);
			System.out.println(test.getBody());

		} catch (URISyntaxException e) {

			e.printStackTrace();
		}
		return res;

	}

}
