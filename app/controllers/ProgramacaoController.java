package controllers;

import models.Programacao;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.programacao.form;

public class ProgramacaoController extends Controller {

	public static Result submit() {
		Programacao.submit();
		return Results.redirect(routes.ProgramacaoController.list());
	}

	public static Result formNew() {
		return ok(form.render(Programacao.form));
	}

	public static Result formUpdate(Integer id) {
		Programacao programacao = Programacao.finder.byId(id);
		return ok(form.render(Programacao.form.fill(programacao)));
	}

	public static Result delete(Integer id) {
		Programacao.finder.byId(id).delete();
		return Results.redirect(routes.ProgramacaoController.list());
	}

	public static Result list() {
		return ok(views.html.programacao.list.render(Programacao.finder.all()));
	}

}
