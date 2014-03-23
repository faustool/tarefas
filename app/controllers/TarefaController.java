package controllers;

import models.Tarefa;
import static play.libs.Json.*;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.tarefa.form;

public class TarefaController extends Controller {

	public static Result submit() {
		Tarefa.submit();
		return Results.redirect(routes.TarefaController.list());
	}

	public static Result formNew() {
		return ok(form.render(Tarefa.form));
	}

	public static Result formUpdate(Integer id) {
		Tarefa tarefa = Tarefa.finder.byId(id);
		return ok(form.render(Tarefa.form.fill(tarefa)));
	}

	public static Result delete(Integer id) {
		Tarefa.finder.byId(id).delete();
		return Results.redirect(routes.TarefaController.list());
	}

	public static Result list() {
		return ok(views.html.tarefa.list.render(Tarefa.finder.all()));
	}

}
