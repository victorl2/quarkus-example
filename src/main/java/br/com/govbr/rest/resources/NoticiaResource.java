package br.com.govbr.rest.resources;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import br.com.govbr.domain.Noticia;

@Path("/noticia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
/**
 * Endpoints para manipulação de {@link Noticia}
 * @author victor.silva
 */
public class NoticiaResource {
   
	@GET
    public List<Noticia> getTodasNoticias() {
    	return Noticia.listAll();
    }
    
    @GET
    @Path("/{id}")
    public Noticia getNoticiaPorId(@PathParam("id") Long id) {
    	return Noticia.findById(id);
    }
    
    @POST
    @Transactional
    public Noticia salvarNoticia(Noticia noticia){
    	Noticia.persist(noticia);
    	return noticia;
    }
    
    @PUT
    @Transactional
    public void atualizarNoticia(Noticia noticia) {
    	if(Objects.isNull(noticia.id))
    		throw new WebApplicationException("Não foi possível encontrar uma notificação com o id informado");
    	
    	Noticia noticiaSalva = Noticia.findById(noticia.id);
    	
    	Optional.ofNullable(noticia.getTexto()).ifPresent(texto -> noticiaSalva.setTexto(texto));
    	Optional.ofNullable(noticia.getTitulo()).ifPresent(titulo -> noticiaSalva.setTitulo(titulo));
    	Optional.ofNullable(noticia.getDescricao()).ifPresent(descricao -> noticiaSalva.setDescricao(descricao));
    	
    	noticiaSalva.persist();
    }
}