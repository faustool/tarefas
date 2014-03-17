package controllers;

import java.util.List;

import models.Tarefa;
import play.api.mvc.Call;
import play.api.templates.Html;
import play.data.Form;
import play.db.ebean.Model.Finder;

public class TarefaController extends CRUDController<Tarefa> {

	/* DO NOT ADD ANY FIELD - KEEP IT STATELESS */

	@Override
	protected Call getListRoute() {
		return routes.TarefaController.list();
	}

	@Override
	protected Form<Tarefa> getModelForm() {
		return Tarefa.form;
	}

	@Override
	protected Finder<Integer, Tarefa> getModelFinder() {
		return Tarefa.finder;
	}

	@Override
	public Html renderList(List<Tarefa> items) {
		return views.html.tarefa.list.render(items);
	}

	@Override
	protected Html renderForm(Form<Tarefa> form) {
		return views.html.tarefa.form.render(form);
	}

}
