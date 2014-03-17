package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.Form;
import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
public class Tarefa extends Model {

	@Id
	public Integer id;

	public String name;
	
	@Column(length=2000)
	public String notes;

	public static Finder<Integer, Tarefa> finder = new Finder<Integer, Tarefa>(
			Integer.class, Tarefa.class);
	
	public static Form<Tarefa> form = Form.form(Tarefa.class);

	public Tarefa(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static void submit() {
		Tarefa tarefa = Tarefa.form.bindFromRequest().get();
		if (tarefa.id != null)
			tarefa.update();
		else
			tarefa.save();
	}
	
}
