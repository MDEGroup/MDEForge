package mdeforge.plugin.eclipse.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.mdeforge.business.model.EcoreMetamodel;

public class AddArtifactPageEMM1 extends WizardPage {
	
	private Text text1;
	private Button check;
	private Table table;
	private Composite container;
	private EcoreMetamodel emm;
	private IFile file;
	private List<String> projects;

	
	public AddArtifactPageEMM1(IFile file){
		super("First Page");
	    setTitle("First Page");
	    setDescription("Fake Wizard: First page");
	    emm = new EcoreMetamodel();
	    this.file = file;

	}

	@Override
	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.NONE);
	    
		
		
		/*Text field management*/
		GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    layout.numColumns = 2;
	    Label label1 = new Label(container, SWT.NONE);
	    label1.setText("search text");
	    text1 = new Text(container, SWT.BORDER | SWT.SINGLE);

	    text1.setText("");

	    text1.addKeyListener(new KeyListener() {
	    	String search = "";

	      @Override
	      public void keyPressed(KeyEvent e) {
	    	  System.out.println("Hai premuto un tasto");

	      }

	      @Override
	      public void keyReleased(KeyEvent e) {
	    	  char[] admissible_char = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
	    			  ,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','.'
	    			  ,'1','2','3','4','5','6','7','8','9','0'};
	    	  boolean check = false;
	    	  for(char i : admissible_char){
	    		  if(e.character == i){
	    			  search = search+e.character;
	    			  check = true;
	    		  }
	    	  }
	    	  if(!check){
	    		  search = "";
	    		  System.out.println("cancella tutto il campo perchè l'ho resettato!");
	    	  }
	    	  System.out.println("Hai rilasciato un tasto\n"
	    	  		+ "la stringa di ricerca attuale è: "+search);
	    	  table.removeAll();
	    	  searchProjects(search);
	      }
	    });
	    
	    
	    /*checkbox public artifact*/
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    text1.setLayoutData(gd);
	    Label labelCheck = new Label(container, SWT.NONE);
	    labelCheck.setText("Public");
	    check = new Button(container, SWT.CHECK);
	    check.setSelection(true);
	    
	    
	    /*Table listing all the project where to put the artifact*/
	    table = new Table(container,SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
	    table.setLinesVisible(true);
        table.setHeaderVisible(true);
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.heightHint = 200;
        table.setLayoutData(data);
        
        TableColumn column = new TableColumn(table,SWT.NONE);
        column.setText("Projects");
        table.getColumn(0).pack();
        TableColumn column2 = new TableColumn(table,SWT.NONE);
        column2.setText("Shared");
        table.getColumn(1).pack();
        table.addMouseListener(new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if(!text1.getText().equals("") && table.getSelection().length > 0){
		  	    	setPageComplete(true);
		  	    }
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseUp(MouseEvent e) {
				if(!text1.getText().equals("") && table.getSelection().length > 0){
		  	    	setPageComplete(true);
		  	    }
				
			}
        	
        });
        
        
        /*Code to retrieve project informations*/
	    /*Now just some example code*/
        projects = new ArrayList<String>();
        for(int i=0;i<=20;i++){
	    	projects.add("project."+i);
	    	
	    }
        for(int i=0;i<=20;i++){
	    	TableItem item = new TableItem(table,SWT.NONE);
	    	item.setText(0,projects.get(i));
	    	item.setText(1,"Yes/No");
	    }
        
	    table.getColumn(0).pack();
	    table.getColumn(1).pack();
	    container.pack();
	    
	    
	    
	    // required to avoid an error in the system
	    setControl(container);
	    setPageComplete(false);

	}
	/*utility method to search inside the table project lists*/
	public void searchProjects(String search){
		for(String i : projects){
			if(i.startsWith(search)){
				TableItem item = new TableItem(table,SWT.NONE);
		    	item.setText(0,i);
		    	item.setText(1,"Yes/No");
			}
		}
		table.getColumn(0).pack();
	    table.getColumn(1).pack();
		
	}

	public String getText1() {
	    return text1.getText();
	  }
	
	public boolean getPublic(){
		return check.getSelection();
	}
	
	public String getProject(){
		return table.getSelection()[0].getText();
	}


}
