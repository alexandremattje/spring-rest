package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collection;

@Component
public class ResourceServerAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private GpUserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) {


		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken();

				return auth;
//
//		BearerTokenAuthenticationToken token = (BearerTokenAuthenticationToken) authentication;
//
//		ClientRegistration registration = ClientRegistrations.fromOidcIssuerLocation(issuer)
//				.clientId(clientId)
//				.clientSecret(clientSecret)
//				.build();
//		OAuth2UserRequest request = new OAuth2UserRequest(registration,
//				new OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER, token.getToken(), null, null));
//
//		OAuth2User oAuth2User = oauth2UserService.loadUser(request);
//		OidcUserInfo userInfo = new OidcUserInfo(oAuth2User.getAttributes());
//
//		Collection<? extends GrantedAuthority> authorities = oAuth2User.getAuthorities();
//		String userNameAttributeName = request.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
//		DefaultOidcUser user;
//		OidcIdToken idToken = new OidcIdToken("id_token_mock", null, null, oAuth2User.getAttributes());
//		if (StringUtils.hasText(userNameAttributeName)) {
//			user = new DefaultOidcUser(authorities, idToken, userInfo, userNameAttributeName);
//		} else {
//			user = new DefaultOidcUser(authorities, idToken, userInfo);
//		}
//
//		return new OAuth2AuthenticationToken(userService.createPrincipal(user), authorities, clientId);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}

//	@Override
//	public boolean supports(Class<?> aClass) {
//		return BearerTokenAuthenticationToken.class.isAssignableFrom(aClass);
//	}
}