package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.Form;
import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
public class Programacao extends Model {

	@Id
	public Integer id;

	public Date inicio;

	public Date fim;

	public String recorrencia;

	public static Finder<Integer, Programacao> finder = new Finder<Integer, Programacao>(
			Integer.class, Programacao.class);

	public static Form<Programacao> form = Form.form(Programacao.class);

	public Programacao(Integer id, Date inicio, Date fim, String recorrencia) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.recorrencia = recorrencia;
	}

	public static void submit() {
		Programacao progr = Programacao.form.bindFromRequest().get();
		if (progr.id != null)
			progr.update();
		else
			progr.save();
	}

}
