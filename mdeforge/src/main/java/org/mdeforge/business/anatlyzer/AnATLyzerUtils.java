package org.mdeforge.business.anatlyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atlext.ATL.ATLPackage;
import anatlyzer.atlext.ATL.Callable;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OclType;
import anatlyzer.atlext.OCL.impl.IntegerTypeImpl;
import anatlyzer.atlext.OCL.impl.StringTypeImpl;

public class AnATLyzerUtils {

	
	public static EDataType getEcoreType(OclType t) throws UndefinedTypeException{
		if(t instanceof StringTypeImpl)
			return EcorePackage.eINSTANCE.getEString();
		if(t instanceof IntegerTypeImpl)
			return EcorePackage.eINSTANCE.getEInt();
		else throw new UndefinedTypeException();
	}
	
	public static List<Callable> getCallableElements(ATLModel atlModel) throws ParserException {
		System.out.println("EXTRACTING CALLABLE ELEMENTS FROM A ATL MODEL");
		//DEFINE OCL AND HELPER
		OCL<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, Constraint, EClass, EObject> ocl;
		OCLHelper<EClassifier, ?, ?, Constraint> helper;
		
		//INSTANCIATE OCL
		ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		//INSTANCIATE NEW HELPER FROM OCLEXPRESSION
		helper = ocl.createOCLHelper();
		//SET HELPER CONTEXT
		helper.setContext(ATLPackage.eINSTANCE.getModule());
		
		//CREATE OCLEXPRESSION
		OCLExpression<EClassifier> expression = helper.createQuery("Callable.allInstances()");
		//CREATE QUERY FROM OCLEXPRESSION
		Query<EClassifier, EClass, EObject> query = ocl.createQuery(expression);
		
		//EVALUATE OCL
		HashSet<Object> success = (HashSet<Object>) query.evaluate(atlModel.getRoot());
		List<Callable> callableMethods = new ArrayList<Callable>();
		for (Object object : success)
			callableMethods.add((Callable) object);
		System.out.println("EXTRACTED CALLABLE ELEMENTS FROM A ATL MODEL");
		return callableMethods;

	}
	public static boolean checkConstraint(EPackage atlModel, List<OclExpression> expr) throws ParserException {
		System.out.println("Check Constraint");
		//DEFINE OCL AND HELPER
		OCL<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, Constraint, EClass, EObject> ocl;
		OCLHelper<EClassifier, ?, ?, Constraint> helper;
		
		//INSTANCIATE OCL
		ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		//INSTANCIATE NEW HELPER FROM OCLEXPRESSION
		helper = ocl.createOCLHelper();
		//SET HELPER CONTEXT
		helper.setContext(ATLPackage.eINSTANCE.getModule());
		
		//CREATE OCLEXPRESSION
		OCLExpression<EClassifier> expression = helper.createQuery("ecore::" + ATLSerializer.serialize(expr.get(0)));
		//CREATE QUERY FROM OCLEXPRESSION
		Query<EClassifier, EClass, EObject> query = ocl.createQuery(expression);
		
		//EVALUATE OCL
		boolean success =  query.check(atlModel);
		System.out.println("success " + success);
		return success;
	}
	
}
