/*******************************************************************************
 * Copyright (C) 2012 Angelo Zerr <angelo.zerr@gmail.com>, Pascal Leclercq <pascal.leclercq@gmail.com>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Angelo ZERR - initial API and implementation
 *     Pascal Leclercq - initial API and implementation
 *******************************************************************************/
package fr.opensagres.mongodb.ide.ui.wizards.database;

import fr.opensagres.mongodb.ide.core.model.Database;
import fr.opensagres.mongodb.ide.ui.ServerUI;
import fr.opensagres.mongodb.ide.ui.internal.ImageResources;
import fr.opensagres.mongodb.ide.ui.internal.Messages;
import fr.opensagres.mongodb.ide.ui.wizards.AbstractSelectNodeWizard;

/**
 * New Database wizard.
 * 
 */
public class NewDatabaseWizard extends AbstractSelectNodeWizard {

	public static final String ID = "fr.opensagres.mongodb.ide.ui.wizards.database.NewDatabaseWizard";

	private final NewDatabaseWizardPage page;

	public NewDatabaseWizard() {
		super.setWindowTitle(Messages.NewDatabaseWizard_title);
		super.setDefaultPageImageDescriptor(ImageResources
				.getImageDescriptor(ImageResources.IMG_WIZBAN_NEW_DATABASE));
		page = new NewDatabaseWizardPage();
	}

	@Override
	public void addPages() {
		super.addPages();
		addPage(page);
	}

	@Override
	protected boolean doPerformFinish() throws Exception {
		String databaseName = page.getDatabaseName();
		// Create Database
		Database database = page.getSelectedServer().createDatabase(
				databaseName);
		if (page.isOpenDatabaseEditor()) {
			// Open database in an editor.
			ServerUI.editDatabase(database);
		}
		return true;
	}
}
