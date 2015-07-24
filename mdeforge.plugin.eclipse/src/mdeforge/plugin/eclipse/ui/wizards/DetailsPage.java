package mdeforge.plugin.eclipse.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DetailsPage extends WizardPage {

	private Composite container;
	private Label l1,l2,l3;
	private Text t1,t2;
	private Button b;
	
	public DetailsPage(){
		super("Details");
		setTitle("Details");
		setDescription("Insert the details");
	}
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label l1 = new Label(container, SWT.NONE);
		l1.setText("Name");
		t1 = new Text(container, SWT.BORDER | SWT.SINGLE);
		t1.setText("");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		t1.setLayoutData(gd);
		l2 = new Label(container, SWT.NONE);
		l2.setText("Description");
		t2 = new Text(container, SWT.BORDER | SWT.SINGLE);
		t2.setText("");
		t2.setLayoutData(gd);
		
		t1.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(t1.getText().length()>0){
					setPageComplete(true);
				}
				else{
					setPageComplete(false);
				}
				
			}
			
		});
		l3 = new Label(container, SWT.NONE);
		l3.setText("Public");
		b = new Button(container, SWT.CHECK);
		b.setSelection(false);
		
		container.pack();

		// required to avoid an error in the system
		setControl(container);
		setPageComplete(false);
	}
	
	public String getName(){
		return t1.getText();
	}
	
	public String getDescription(){
		return t2.getText();
	}
	
	public boolean getPublic(){
		return b.getSelection();
	}

}
