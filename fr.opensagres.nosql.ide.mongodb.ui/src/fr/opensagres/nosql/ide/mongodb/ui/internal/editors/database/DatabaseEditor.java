package fr.opensagres.nosql.ide.mongodb.ui.internal.editors.database;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;

import fr.opensagres.nosql.ide.mongodb.core.model.Database;
import fr.opensagres.nosql.ide.ui.editors.BasicModelFormEditor;

public class DatabaseEditor extends
		BasicModelFormEditor<DatabaseEditorInput, Database> {

	public static final String ID = "fr.opensagres.nosql.ide.mongodb.ui.editors.database.DatabaseEditor";

	@Override
	protected void doAddPages() throws PartInitException {
		super.addPage(new OverviewPage(this));
		super.addPage(new StatsPage(this));
		super.addPage(new UsersPage(this));
	}

	@Override
	protected String getOverridePartName() {
		// modify the title of the editor with the name of the database.
		Database database = getModelObject();
		if (database != null) {
			return database.getName();
		}
		return null;
	}

	@Override
	protected void onSave(IProgressMonitor monitor) {

	}

}
