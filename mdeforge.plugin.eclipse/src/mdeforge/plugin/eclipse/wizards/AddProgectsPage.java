package mdeforge.plugin.eclipse.wizards;

import java.util.ArrayList;
import java.util.List;

import mdeforge.plugin.eclipse.control.ServiceController;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.mdeforge.business.model.Project;

public class AddProgectsPage extends WizardPage {

	private Text text1;
	private Button check;
	private Table table;
	private Composite container;
	private IFile file;
	private List<String> projects;
	private Button search_button;

	public AddProgectsPage(IFile file) {
		super("Select Remote Projects");
		setTitle("Select Remote Projects");
		setDescription("Choose where to put the Artifact on the Forge");
		this.file = file;
	}

	@Override
	public void createControl(Composite parent) {

		container = new Composite(parent, SWT.NONE);

		/* Text field management */
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		text1 = new Text(container, SWT.BORDER | SWT.SINGLE);
		text1.setText("");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text1.setLayoutData(gd);

		/*Search button with a listener to start the search*/
		search_button = new Button(container, SWT.PUSH);
		search_button.setText("search");
		search_button.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseUp(MouseEvent e) {
				System.out.println("string searched: " + text1.getText());
				searchProjects(text1.getText());
			}

		});


		/* Table listing all the project where to put the artifact */
		table = new Table(container, SWT.SINGLE | SWT.BORDER
				| SWT.FULL_SELECTION | SWT.CHECK);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);

		TableColumn column = new TableColumn(table, SWT.NONE);
		column.setText("Projects");
		table.getColumn(0).pack();
		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setText("Shared");
		table.getColumn(1).pack();
		table.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					TableItem item = (TableItem) event.item;
					boolean checked = item.getChecked();
					item.setChecked(checked);
					checked = false;
					for (TableItem i : table.getItems()) {
						if (i.getChecked()) {
							checked = true;
							break;
						}
					}
					if (checked) {
						setPageComplete(true);
					} else{
						setPageComplete(false);
					}
				}

			}
		});

		/* Code to retrieve project informations */
		/* Now just some example code */
		
		List<Project> projects = ServiceController.getProjects();
		/*
		projects = new ArrayList<String>();
		for (int i = 0; i <= 20; i++) {
			projects.add("project." + i);

		}
		for (int i = 0; i <= 20; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, projects.get(i));
			item.setText(1, "Yes/No");
			item.setChecked(false);
		}*/
		for(Project p : projects){
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, p.getName());
			if(p.getUsers().size() > 1){
				item.setText(1,"Yes");
			}
			else{
				item.setText(1,"No");
			}
		}

		table.getColumn(0).pack();
		table.getColumn(1).pack();

		Label fillField = new Label(container, SWT.NONE);
		fillField.setText("");
		Label labelCheck = new Label(container, SWT.NONE);
		labelCheck.setText("Public");
		check = new Button(container, SWT.CHECK);
		check.setSelection(true);
		container.pack();

		// required to avoid an error in the system
		setControl(container);
		setPageComplete(false);

	}

	/* utility method to search inside the table project lists */
	public void searchProjects(String search) {
		List<String> exclude_projects = new ArrayList<String>();
		List<String> checked_projects = new ArrayList<String>();
		
		if (!search.equals("")) {
			for (TableItem t : table.getItems()) {
				if (t.getText(0).indexOf(search) == -1 && !t.getChecked()) {
					exclude_projects.add(t.getText(0));
				} else if (t.getChecked()) {
					checked_projects.add(t.getText(0));
				}
			}

			table.removeAll();

			for (String i : projects) {
				boolean match = false;
				for (String k : exclude_projects) {
					if (i.equals(k)) {
						match = true;
						break;
					}
				}
				if (!match) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, i);
					item.setText(1, "Yes/No");
					for (String j : checked_projects) {
						if (i.equals(j)) {
							item.setChecked(true);
						} else {
							item.setChecked(false);
						}
					}
				}
			}

		} else {
			for (TableItem t : table.getItems()) {
				if (t.getChecked()) {
					checked_projects.add(t.getText(0));
				}
			}

			table.removeAll();
			
			for (String i : projects) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, i);
				item.setText(1, "Yes/No");
				for (String j : checked_projects) {
					if (i.equals(j)) {
						item.setChecked(true);
					} else {
						item.setChecked(false);
					}
				}
			}

		}
		table.getColumn(0).pack();
		table.getColumn(1).pack();
	}

	
	
	
	
	public boolean getPublic() {
		return check.getSelection();
	}

	public List<String> getProject() {
		List<String> ids = new ArrayList<String>();
		ids.add("5514b9a6d4c6c379396fe8b9");
		return ids;
	}
	
	public String getFile(){
		return this.file.getFullPath().toString();
	}

}
