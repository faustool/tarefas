package controllers;

import java.util.List;

import models.Tarefa;
import play.api.mvc.Call;
import play.api.templates.Html;
import play.data.Form;
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.tarefa.form;

public class CRUDController extends Controller {

	/* DO NOT ADD ANY FIELD - KEEP IT STATELESS */

	public Result submit() {
		Tarefa tarefa = getModelForm().bindFromRequest().get();
		tarefa.save();
		return Results.redirect(getListRoute());
	}

	private Call getListRoute() {
		return routes.TarefaController.list();
	}

	private Form<Tarefa> getModelForm() {
		return Tarefa.form;
	}

	public Result formNew() {
		return ok(form.render(getModelForm()));
	}

	public Result formUpdate(Integer id) {
		Tarefa tarefa = getModelFinder().byId(id);
		return ok(form.render(getModelForm().fill(tarefa)));
	}

	private Finder<Integer, Tarefa> getModelFinder() {
		return Tarefa.finder;
	}

	public Result delete(Integer id) {
		getModelFinder().byId(id).delete();
		return Results.redirect(getListRoute());
	}

	public Html renderList(List<Tarefa> items) {
		return views.html.tarefa.list.render(items);
	}

	public Result list() {
		return ok(renderList(getModelFinder().all()));
	}

}
