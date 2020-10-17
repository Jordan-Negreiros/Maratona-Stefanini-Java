package br.com.maratona.dev.resource;

import java.util.List;

import javax.inject.Inject;
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

	@Inject
	private InscricaoHelper inscricaoHelper;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/lista/inscritos")
	public List<Pessoa> matricula() {
		inscricaoHelper.init();
		return inscricaoHelper.getPessoas();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/lista/inscritos/{id}")
	public Response matriculaPorId(@PathParam("id") String id) {

		try {
			Pessoa objetoRetorno = inscricaoHelper.findPessoa(Integer.valueOf(id));

			if (objetoRetorno != null) {
				return Response.status(Status.OK).entity(objetoRetorno).build();
			}

		} catch (NumberFormatException e) {
			Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro na solicitação").build();
		} catch (NullPointerException e) {
			Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro na solicitação... Null").build();
		}

		return Response.status(Status.NO_CONTENT).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/remover/inscritos/{id}")
	public Response remover(@PathParam("id") String id) {

		Pessoa remove = inscricaoHelper.findPessoa(Integer.valueOf(id));

		if (inscricaoHelper.getPessoas().remove(remove)) {
			return Response.status(Status.OK).entity("Removido com Sucesso!").build();
		}

		return Response.status(Status.NO_CONTENT).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/alterar/inscritos/{id}")
	public Response alterar(@PathParam("id") String id, Pessoa pessoa) {
		inscricaoHelper.init();

		Pessoa novaPessoa = new Pessoa();
		novaPessoa.setMatricula( Integer.valueOf(id));
		novaPessoa.setNome(pessoa.getNome());

		Pessoa atualPessoa = inscricaoHelper.findPessoa(Integer.valueOf(id));

		if (inscricaoHelper.getPessoas().contains(atualPessoa)) {
			int index = inscricaoHelper.getPessoas().indexOf(atualPessoa);
			inscricaoHelper.getPessoas().set(index, novaPessoa);
			return Response.status(Status.OK).entity(novaPessoa).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/incluir/inscritos/")
	public Response cadastrar(Pessoa pessoa) {
		inscricaoHelper.init();
		pessoa.setMatricula(inscricaoHelper.getPessoas().size() + 1);
		inscricaoHelper.getPessoas().add(pessoa);

		return Response.status(Status.CREATED).entity(pessoa).build();
	}

}
