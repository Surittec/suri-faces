/*
 * SURITTEC
 * Copyright 2015, TTUS TECNOLOGIA DA INFORMACAO LTDA, 
 * and individual contributors as indicated by the @authors tag
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package br.com.surittec.surifaces.rewrite.condition;

import java.util.Arrays;
import java.util.Collection;

import org.ocpsoft.rewrite.context.EvaluationContext;
import org.ocpsoft.rewrite.servlet.config.HttpCondition;
import org.ocpsoft.rewrite.servlet.http.event.HttpServletRewrite;

/**
 * Condição de validação se o usuário possui alguma das permissões informadas.
 * 
 * @author Fred Estrela
 *
 */
public class JAASOrRoles extends HttpCondition {

	private final Collection<String> roles;

	/**
	 * Create a new {@link JAASOrRoles} condition specifying the roles of which the current user
	 * must be a member for evaluation to return <code>true</code>.
	 */
	public static JAASOrRoles hasntAnyRoles(String... roles) {
		return new JAASOrRoles(roles);
	}

	private JAASOrRoles(String[] roles) {
		this.roles = Arrays.asList(roles);
	}

	@Override
	public boolean evaluateHttp(HttpServletRewrite event, EvaluationContext context) {
		HttpServletRewrite rewrite = event;

		boolean hasAnyRoles = false;

		// check if user has any required roles
		for (String role : roles) {
			if (rewrite.getRequest().isUserInRole(role)) {
				hasAnyRoles = true;
			}
		}

		return !hasAnyRoles;
	}

}
