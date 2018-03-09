package org.mdeforge.business.model;

import java.io.Serializable;


public class ATLTransformationTestServiceError implements Serializable{

	
	
	//INNER CLASS AND ENUMERATES
	
	
	
		
		/** attributes */
		private Model     model        = null;
		private String     errorMessage = "";
		public String getErrorMessage() {
			return errorMessage;
		}
		private String errorKind    = null;
		
		public String getErrorKind() {
			return errorKind;
		}
		public void setErrorKind(String errorKind) {
			this.errorKind = errorKind;
		}
		//		public Record (Model model) { 
//			this.model = model; 
//		}
//		
//		public Record (Model model, String error, ERROR_KIND kind) { 
//			this(model);
//			this.errorMessage = error;
//			this.errorKind    = kind;
//		}
		public void setErrorMessage (String errorMessage) {this.errorMessage = errorMessage;}
		public Model  getModel()                  { return model; }
		public void   setModel(Model model) 	   {this.model = model;}
		public String  getError()                  { return (model!=null? "[witness model "+model+"]: " : "") + errorMessage; }
		public boolean getExecutionRaisesException () { return errorKind.equals("ERROR_KIND.EXECUTION_RAISES_EXCEPTION;");  }
		public boolean getExecutionYieldsIllTarget () { return errorKind.equals("ERROR_KIND.EXECUTION_YIELDS_ILL_TARGET;"); }
		public boolean getAnatlyserNotifiesError ()   { return errorKind.equals("ERROR_KIND.ANATLYZER_DETECTED_ERROR;");    }
		public boolean getAnatlyserDoesNotFinish ()   { return errorKind.equals("ANATLYZER_DOES_NOT_FINISH;");   }
		
		
	
}
