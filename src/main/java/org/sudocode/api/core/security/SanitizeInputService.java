package org.sudocode.api.core.security;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Entities;
import org.jsoup.safety.Whitelist;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * A service for sanitizing unsafe HTML to protect against XSS attacks.
 */
@Service
public class SanitizeInputService {

	public String sanitizeInputs(String htmlInput) {
		return Jsoup.clean(htmlInput, Whitelist.basic());
	}

	public String escape(String cleanInput) {
		Assert.isTrue(Jsoup.isValid(cleanInput, Whitelist.basic()), "HTML should be sanitized before escaping.");
		return Entities.escape(cleanInput);
	}


	public static String sanitizeInput(String input) {
		return Entities.escape(Jsoup.clean(input, Whitelist.basic()));
	}

	public static String unescapeChars(String input) {
		return Entities.unescape(input);
	}
}
