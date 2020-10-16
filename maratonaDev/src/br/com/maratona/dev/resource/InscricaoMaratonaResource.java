package br.com.maratona.dev.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path(value = "/inscricao")
public class InscricaoMaratonaResource {
	
	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public void init() {
		pessoas.add(new Pessoa("Kleber", 1));
		pessoas.add(new Pessoa("Marcus", 2));
		pessoas.add(new Pessoa("Stag", 3));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/lista/inscritos")
	public List<Pessoa> matricula() {
		init();
		return pessoas;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/lista/inscritos/{id}")
	public Response matriculaPorId(@PathParam("id") String id) {
		init();
		
		for (Pessoa indice : pessoas) {
			if (indice.getMatricula().equals(new Integer(id))) {
				return Response.status(Status.OK).entity(indice).build();
			}
		}
		
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/remover/inscritos/{id}")
	public Response remover(@PathParam("id") String id) {
		init();
		
		Pessoa remove = null;
		for (Pessoa indice : pessoas) {
			if (indice.getMatricula().equals(new Integer(id))) {
				remove = indice;
			}
		}
		if (pessoas.remove(remove)) {
			return Response.status(Status.OK).entity("Removido com Sucesso!").build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/alterar/inscritos/{id}")
	public Response alterar(@PathParam("id") String id, Pessoa pessoa) {
		init();
		
		Pessoa novaPessoa = new Pessoa();
		novaPessoa.setMatricula(new Integer(id));
		novaPessoa.setNome(pessoa.getNome());
		
		Pessoa atualPessoa = null;
		for (Pessoa indice : pessoas) {
			if (indice.getMatricula().equals(new Integer(id))) {
				atualPessoa = indice;
			}
		}
		
		if (pessoas.contains(atualPessoa)) {
			int index = pessoas.indexOf(atualPessoa);
			pessoas.set(index, novaPessoa);
			return Response.status(Status.OK).entity(novaPessoa).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/incluir/inscritos/")
	public Response incluir(Pessoa pessoa) {
		init();
		pessoa.setMatricula(pessoas.size() + 1);
		pessoas.add(pessoa);
		
		return Response.status(Status.CREATED).entity(pessoa).build();
	}
	
	
}
