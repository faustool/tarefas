package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

import org.junit.Before;
import org.junit.Test;

import play.test.WithApplication;

public class TarefaTest extends WithApplication {
	
	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}
	
	@Test
	public void createAndRetrieve() {
		new Tarefa(1, "Teste de tarefa").save();
		Tarefa t = Tarefa.finder.where().eq("id", 1).findUnique();
		assertNotNull("Couldn't find it", t);
		assertEquals("Wrong one", "Teste de tarefa", t.name);
	}

}
