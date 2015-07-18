package mdeforge.plugin.eclipse.wizards;

import java.util.ArrayList;
import java.util.List;

import mdeforge.plugin.eclipse.control.Controller;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Project;

public class AddMMPage extends WizardPage {

	private Text text1;
	private Button check;
	private Table table;
	private Composite container;
	private List<EcoreMetamodel> metamodels;
	private Button search_button;

	public AddMMPage() {
		super("Select Metamodel");
		setTitle("Select Metamodel");
		setDescription("Select the Metamodel to which the Artifact Conforms To");
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
				searchMetamodels(text1.getText());
			}

		});


		/* Table listing all the metamodels where to put the artifact */
		table = new Table(container, SWT.SINGLE | SWT.BORDER
				| SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);

		TableColumn column = new TableColumn(table, SWT.NONE);
		column.setText("Metamodel");
		table.getColumn(0).pack();
		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setText("Description");
		table.getColumn(1).pack();
		table.addSelectionListener(
				new SelectionListener(){

					@Override
					public void widgetSelected(SelectionEvent e) {
						setPageComplete(true);
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
			
		});

		metamodels = Controller.getEcoreMetamodel();
		for(EcoreMetamodel p : metamodels){
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, p.getName());
			item.setText(1,"");
		}

		table.getColumn(0).pack();
		table.getColumn(1).pack();

		container.pack();

		// required to avoid an error in the system
		setControl(container);
		setPageComplete(false);

	}

	/* utility method to search inside the table metamodel lists */
	public void searchMetamodels(String search) {		
		table.removeAll();
		
		if (!search.equals("")) {
			for (EcoreMetamodel i : metamodels) {
				if(i.getName().indexOf(search) > -1){
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, i.getName());
					item.setText(1, "");
				}
					
					
			}
		}
		else {
			for(EcoreMetamodel p : metamodels){
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, p.getName());
				item.setText(1,"");
			}
		}
		table.getColumn(0).pack();
		table.getColumn(1).pack();
	}

}
