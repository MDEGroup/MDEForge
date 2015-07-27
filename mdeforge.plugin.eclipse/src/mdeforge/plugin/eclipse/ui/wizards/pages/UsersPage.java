package mdeforge.plugin.eclipse.ui.wizards.pages;

import java.util.List;

import mdeforge.plugin.eclipse.control.ServiceController;
import mdeforge.plugin.eclipse.control.ViewController;

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

public class UsersPage extends WizardPage {

	private Text text1;
	private Button check;
	private Table table;
	private Composite container;
	private Button search_button;
	private String[][] items;
	
	public UsersPage(){
		super("Select Users");
		setTitle("Select Users");
		setDescription("Select users to with whom to share it");
		
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
				searchUsers(text1.getText().toLowerCase());
			}

		});


		/* Table listing all the metamodels where to put the artifact */
		table = new Table(container, SWT.SINGLE | SWT.BORDER
				| SWT.FULL_SELECTION | SWT.CHECK);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
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

		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setText("Username");
		table.getColumn(0).pack();
		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setText("Name");
		table.getColumn(1).pack();
		
		TableColumn column3 = new TableColumn(table,SWT.NONE);
		column3.setWidth(0);
		table.getColumn(2).pack();
		column3.setWidth(0);
		
		items = ViewController.getUsers();
		for(int i = 0; i < items.length; i++){
			TableItem item = new TableItem(table,SWT.NONE);
			item.setText(0, items[i][0]);
			item.setText(1, items[i][1]);
			item.setText(2,items[i][2]);
			i++;
		}

		table.getColumn(0).pack();
		table.getColumn(1).pack();
		table.getColumn(2).pack();
		column3.setWidth(0);

		container.pack();

		// required to avoid an error in the system
		setControl(container);
		setPageComplete(false);


	}
	
	/* utility method to search inside the table metamodel lists */
	public void searchUsers(String search) {		
		String [] userids = new String[table.getItems().length];
		int i = 0;
		for(TableItem ti : table.getItems()){
			if(ti.getChecked()){
				userids[i] = ti.getText(2);
			}
		}
		
		table.removeAll();
		
		if (!search.equals("")) {
			for(i=0;i< items.length;i++){
				if(items[i][0].toLowerCase().indexOf(search) > -1){
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, items[i][0]);
					item.setText(1, items[i][1]);
					item.setText(2,items[i][2]);
					for(String s : userids){
						if(items[i][2].equals(s)){
							item.setChecked(true);
							break;
						}
						else{
							item.setChecked(false);
						}
					}
				}else{
					for(String s : userids){
						if(items[i][2].equals(s)){
							TableItem item = new TableItem(table, SWT.NONE);
							item.setText(0, items[i][0]);
							item.setText(1, ""/*items[i][1]*/);
							item.setText(2,items[i][2]);
							item.setChecked(true);
						}
					}
				}
			}
		}
		else {
			for(i=0;i< items.length;i++){
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, items[i][0]);
					item.setText(1, items[i][1]);
					item.setText(2,items[i][2]);
					for(String s : userids){
						if(items[i][2].equals(s)){
							item.setChecked(true);
							break;
						}else{
							item.setChecked(false);
						}
					}
				}
		}
		table.getColumn(0).pack();
		table.getColumn(1).pack();
		table.getColumn(2).pack();
		table.getColumn(2).setWidth(0);
	}

	/*Access the selected metamodel*/
	public String[] getSelectedUsers(){
		String [] s = new String[table.getItems().length];
		for(int i = 0; i < table.getItems().length; i++){
			if(table.getItem(i).getChecked()){
				s[i] = table.getItem(i).getText(2);
			}
		}
		return s;
	}
}
