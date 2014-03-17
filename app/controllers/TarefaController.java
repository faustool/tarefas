package controllers;

import models.Tarefa;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.tarefa.form;

public class TarefaController extends Controller {

	/* DO NOT ADD ANY FIELD - KEEP IT STATELESS */
	
	public Result submit() {
		Tarefa tarefa = Tarefa.form.bindFromRequest().get();
		if (tarefa.id != null)
			tarefa.update();
		else
			tarefa.save();
		return Results.redirect(routes.TarefaController.list());
	}

	public Result formNew() {
		return ok(form.render(Tarefa.form));
	}

	public Result formUpdate(Integer id) {
		Tarefa tarefa = Tarefa.finder.byId(id);
		return ok(form.render(Tarefa.form.fill(tarefa)));
	}

	public Result delete(Integer id) {
		Tarefa.finder.byId(id).delete();
		return Results.redirect(routes.TarefaController.list());
	}

	public Result list() {
		return ok(views.html.tarefa.list.render(Tarefa.finder.all()));
	}

}
