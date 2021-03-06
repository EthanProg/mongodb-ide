package fr.opensagres.mongodb.ide.core.model;

import java.util.List;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import fr.opensagres.mongodb.ide.core.internal.Messages;

public class IndexesCategory extends TreeContainerNode<Collection> {

	private String id;

	@Override
	protected void doGetChildren() throws Exception {
		DBCollection dbCollection = getParent().getDBCollection();
		List<DBObject> infos = getParent().getShellCommandManager()
				.getDBCollectionGetIndexes(dbCollection);
		for (DBObject dbObject : infos) {
			super.addNode(new Index(dbObject));
		}
	}

	public String getId() {
		if (id == null) {
			this.id = computeId();
		}
		return id;
	}

	public String getName() {
		return Messages.Indexes_label;
	}

	public String getLabel() {
		return Messages.Indexes_label;
	}

	@Override
	public NodeType getType() {
		return NodeType.IndexesCategory;
	}

}
