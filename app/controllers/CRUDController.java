package controllers;

import java.util.List;

import play.api.mvc.Call;
import play.api.templates.Html;
import play.data.Form;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public abstract class CRUDController<T extends Model> extends Controller {

	/* DO NOT ADD ANY FIELD - KEEP IT STATELESS */

	public Result submit() {
		T tarefa = getModelForm().bindFromRequest().get();
		tarefa.save();
		return Results.redirect(getListRoute());
	}

	protected abstract Call getListRoute();

	protected abstract Form<T> getModelForm();

	public Result formNew() {
		return ok(renderForm(getModelForm()));
	}

	public Result formUpdate(Integer id) {
		T tarefa = getModelFinder().byId(id);
		return ok(renderForm(getModelForm().fill(tarefa)));
	}

	protected abstract Finder<Integer, T> getModelFinder();

	public Result delete(Integer id) {
		getModelFinder().byId(id).delete();
		return Results.redirect(getListRoute());
	}

	protected abstract Html renderList(List<T> items);
	protected abstract Html renderForm(Form<T> form);

	public Result list() {
		return ok(renderList(getModelFinder().all()));
	}

}
