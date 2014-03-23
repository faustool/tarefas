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

	public Boolean diarioSegunda;
	public Boolean diarioTerca;
	public Boolean diarioQuarta;
	public Boolean diarioQuinta;
	public Boolean diarioSexta;
	public Boolean diarioSabado;
	public Boolean diarioDomingo;
	
	public Boolean mensalJaneiro;
	public Boolean mensalFevereiro;
	public Boolean mensalMarco;
	public Boolean mensalAbril;
	public Boolean mensalMaio;
	public Boolean mensalJunho;
	public Boolean mensalJulho;
	public Boolean mensalAgosto;
	public Boolean mensalSetembro;
	public Boolean mensalOutubro;
	public Boolean mensalNovembro;
	public Boolean mensalDezembro;
	
	public Boolean semanalPrimeira;
	public Boolean semanalSegunda;
	public Boolean semanalPenultima;
	public Boolean semanalUltima;
	public Boolean semanalACada15Dias;

	public static Finder<Integer, Programacao> finder = new Finder<Integer, Programacao>(
			Integer.class, Programacao.class);

	public static Form<Programacao> form = Form.form(Programacao.class);

	public Programacao(Integer id, Date inicio, Date fim) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
	}

	public static void submit() {
		Programacao progr = Programacao.form.bindFromRequest().get();
		if (progr.id != null)
			progr.update();
		else
			progr.save();
	}

}
