package fr.natsystem.cardgame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = CardgameApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardgameApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port +"/api/v1";
	}

	/**
	 * Context loads.
	 */
	@Test
	public void contextLoads() {
	}

	/**
	 * Test creation de message.
	 */
	/*@Test
	public void testCreateMessage() {

		Message message = new Message();
		message.setAuteur("Jérémie Durand");
		message.setDateMessage(new Date());
		message.setCanal(Canal.MAIL.toString());
		message.setMessage("Bonjour, j’ai un problème avec mon nouveau téléphone");
		ResponseEntity<DossierClient> postResponse = restTemplate.postForEntity(getRootUrl() + "/message", message, DossierClient.class);
		Assertions.assertNotNull(postResponse);
		Assertions.assertNotNull(postResponse.getBody());
	}

	/**
	 * Test affichage des dossiers clients.
	 */
	/*@Test
	public void testGetAllDossiers() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/message",
				HttpMethod.GET, entity, String.class);
		Assertions.assertNull(response.getBody());

	}*/

}
