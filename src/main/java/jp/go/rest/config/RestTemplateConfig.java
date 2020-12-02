package jp.go.rest.config;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	@Bean
	public RestTemplate restTemplate() throws Exception {
		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(new TrustSelfSignedStrategy()).build(); // TrustSelfSignedStrategyで自己署名証明書を許可する設定

		CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext)
				.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE) // ホスト名の検証しない設定
				.build();

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		((HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory()).setHttpClient(httpClient); // RestTemplateで使うhttpClientを自己署名証明書対応されたClientに差し替え
		return restTemplate;
	}
}