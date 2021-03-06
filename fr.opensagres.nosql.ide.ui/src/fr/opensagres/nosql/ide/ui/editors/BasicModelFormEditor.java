package fr.opensagres.nosql.ide.ui.editors;

import fr.opensagres.nosql.ide.core.model.IModelIdentity;

public abstract class BasicModelFormEditor<EditorInput extends ModelEditorInput<Model>, Model extends IModelIdentity>
		extends ModelFormEditor<EditorInput, Model> {

	@Override
	protected Model onLoad(EditorInput input) throws Exception {
		return input.getModel();
	}
}
