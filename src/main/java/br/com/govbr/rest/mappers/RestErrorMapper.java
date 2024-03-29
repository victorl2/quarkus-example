package br.com.govbr.rest.mappers;

import javax.json.Json;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Mapeador de {@link WebApplicationException} para {@link Response} de código 500.
 * 
 * @author victor.silva
 */
@Provider
public class RestErrorMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		int code = 500;
		if (exception instanceof WebApplicationException) {
			code = ((WebApplicationException) exception).getResponse().getStatus();
		}
		return Response.status(code)
				.entity(Json.createObjectBuilder().add("error", exception.getMessage()).add("code", code).build())
				.build();
	}

}