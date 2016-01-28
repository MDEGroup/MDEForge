package org.mdeforge.business.anatlyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atlext.ATL.Binding;
import anatlyzer.atlext.ATL.Callable;
import anatlyzer.atlext.ATL.ContextHelper;
import anatlyzer.atlext.ATL.LazyRule;
import anatlyzer.atlext.ATL.SimpleOutPatternElement;
import anatlyzer.atlext.ATL.StaticHelper;
import anatlyzer.atlext.OCL.Attribute;
import anatlyzer.atlext.OCL.CollectionOperationCallExp;
import anatlyzer.atlext.OCL.IntegerExp;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OCLFactory;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OclModel;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.OclType;
import anatlyzer.atlext.OCL.Operation;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.OperatorCallExp;
import anatlyzer.atlext.OCL.SequenceType;
import anatlyzer.atlext.OCL.StringExp;
import anatlyzer.atlext.OCL.VariableDeclaration;
import anatlyzer.atlext.OCL.VariableExp;
import anatlyzer.atlext.processing.AbstractVisitor;

public class OutputMetamodelVisitor extends AbstractVisitor {

//	private EPackage pkg;
	private HashMap<EObject, EModelElement> outputPatternMap = new HashMap<EObject, EModelElement>();
	private HashMap<OclExpression, OclType> oclExpressionTypeMap = new HashMap<OclExpression, OclType>();
	private HashMap<String, EPackage> outModel = new HashMap<String, EPackage>();
	private HashMap<SimpleOutPatternElement, OclType> outPatternType = new HashMap<SimpleOutPatternElement, OclType>();

	private List<OclExpression> constraint = new ArrayList<OclExpression>() ;
	//	private HashMap<OclExpression, OclType> oclExpressionTypeMap = new HashMap<OclExpression, OclType>();
	private HashMap<String, EClass> klassMap = new HashMap<String, EClass>();
	
	private HashMap<Callable, OclType> callableElements;
	
	public HashMap<String, EPackage> getOutModel() {
		return outModel;
	}
	
	
	public void setOutModel(HashMap<String, EPackage> outModel) {
		this.outModel = outModel;
	}
	
	public void perform(ATLModel model, HashMap<Callable, OclType> callableElements) {
		for (OclModel models : model.getModule().getOutModels()) {
			EPackage pac = EcoreFactory.eINSTANCE.createEPackage();
			pac.setName(models.getMetamodel().getName());
			outModel.put(models.getMetamodel().getName(), pac);
		}
		this.callableElements = callableElements;
		startVisiting(model.getRoot());
	}
	

	@Override
	public void beforeSimpleOutPatternElement(SimpleOutPatternElement self) {
		outPatternType.put(self, self.getType());
		String tgtClassName = self.getType().getName();
		EClass klass = klassMap.get(tgtClassName); 
		if (klass == null) {
			klass = EcoreFactory.eINSTANCE.createEClass();
			klass.setName(tgtClassName);
			klassMap.put(tgtClassName, klass);
		}
		// MAP
		if (self.getType() instanceof OclModelElement) {
			OclModelElement ome = (OclModelElement) self.getType();
			
			EPackage p = outModel.get(ome.getModel().getName());
			if (p!=null)
				p.getEClassifiers().add(klass);
//			System.out.println("2 " + ome.getModel().getName());
//			System.out.println("2 " + ome.getModel().getLocation());
//			System.out.println("3 " + tgtClassName);
		}
		outputPatternMap.put(self, klass);
		
		//NEW
//		OperationCallExp allInstancesCall = OCLFactory.eINSTANCE.createOperationCallExp();
//		allInstancesCall.setOperationName("allInstances");
//		allInstancesCall.setSource(self.getType());
//		
//		IteratorExp exists = OCLFactory.eINSTANCE.createIteratorExp();
//			exists.setName("exists");
//			exists.setSource(allInstancesCall);
//			
//			anatlyzer.atlext.OCL.Iterator iterator = OCLFactory.eINSTANCE.createIterator();
//			iterator.setVarName("e");
//			exists.getIterators().add(iterator);
//				OperatorCallExp classNameOperator = OCLFactory.eINSTANCE.createOperatorCallExp();
//					NavigationOrAttributeCallExp classNameNOACE = OCLFactory.eINSTANCE.createNavigationOrAttributeCallExp();
//						VariableExp iteratorVariable = OCLFactory.eINSTANCE.createVariableExp();
//						iteratorVariable.setReferredVariable(iterator);
//					classNameNOACE.setSource(iteratorVariable);
//					classNameNOACE.setName("name");
//				classNameOperator.setSource(classNameNOACE);
//				classNameOperator.setOperationName("=");
//					StringExp classNameSE = OCLFactory.eINSTANCE.createStringExp();
//					classNameSE.setStringSymbol(klass.getName());
//				classNameOperator.getArguments().add(classNameSE);
//			exists.setBody(classNameOperator);
//		String s = ATLSerializer.serialize(exists);
//		System.out.println(s);
	}
	
	@Override
	public void beforeVariableExp(VariableExp self) {
		VariableDeclaration vd = self.getReferredVariable();
		if (vd instanceof SimpleOutPatternElement) {
			SimpleOutPatternElement sop = (SimpleOutPatternElement) vd;
			if(sop.getType() instanceof OclModelElement) {
				OclModelElement ome = (OclModelElement) sop.getType();
				EClass klass = klassMap.get(ome.getName()); 
				if (klass == null) {
					klass = EcoreFactory.eINSTANCE.createEClass();
					klass.setName(ome.getName());
					klassMap.put(ome.getName(), klass);
					EPackage p = outModel.get(ome.getModel().getName());
					p.getEClassifiers().add(klass);
				}
				oclExpressionTypeMap.put(self, ome);
			}
		}
	}
//	
//
	@Override
	public void inBinding(Binding self) {
		OclType t = oclExpressionTypeMap.get(self.getValue());
		EClass klass = (EClass) outputPatternMap.get(self.getOutPatternElement());
		
		if (t instanceof SequenceType) {
			OclType sequenceType = ((SequenceType) t).getElementType();
			if (sequenceType instanceof OclModelElement) {
				EClass c = klassMap.get(sequenceType.getName());
				if(c==null) {
					c = EcoreFactory.eINSTANCE.createEClass();
					c.setName(sequenceType.getName());
					klassMap.put(sequenceType.getName(), c);
				}
				EStructuralFeature ref = EcoreFactory.eINSTANCE.createEReference();
				ref.setName(self.getPropertyName());
				ref.setEType(c);
				ref.setUpperBound(-1);
				boolean guard = false;
				for(EReference ea : klass.getEAllReferences()) {
					if(ea.getName().equals(self.getPropertyName()))
						guard = true;
				}
				if (!guard) {
					klass.getEStructuralFeatures().add(ref);
					//NEW
					VariableDeclaration oclType = OCLFactory.eINSTANCE.createVariableDeclaration();
					oclType.setVarName("EClass");
					VariableExp varExp = OCLFactory.eINSTANCE.createVariableExp();
					varExp.setReferredVariable(oclType);
					OperationCallExp allInstancesCall = createAllInstance(varExp);
					IteratorExp existsClass = createExists("e", allInstancesCall);
					StringExp classNameSE = OCLFactory.eINSTANCE.createStringExp();
					classNameSE.setStringSymbol(klass.getName());
					NavigationOrAttributeCallExp classNameNOACE = createNavigationOrAttributeCallExp(existsClass.getIterators().get(0), "name");
					OperatorCallExp classNameOperator = createOperatorCallExp(classNameNOACE, "=", new ArrayList<OclExpression>() {{add(classNameSE);}});
					NavigationOrAttributeCallExp allStructuralFeature = createNavigationOrAttributeCallExp(existsClass.getIterators().get(0), "eAllStructuralFeatures");
					IteratorExp existsReference = createExists("f", allStructuralFeature);
					OperationCallExp oclIsTypeOf = createOclIsTypeOf(existsReference.getIterators().get(0), "ecore::EReference");
					NavigationOrAttributeCallExp refNameNOCE = createNavigationOrAttributeCallExp(existsReference.getIterators().get(0), "name");
					StringExp refNameString = OCLFactory.eINSTANCE.createStringExp();
					refNameString.setStringSymbol(ref.getName());
					OperatorCallExp refNameEquals = createOperatorCallExp(refNameNOCE, "=", new ArrayList<OclExpression>() {{add(refNameString);}});
					OperatorCallExp nameAndOperator = createOperatorCallExp(oclIsTypeOf, "and", new ArrayList<OclExpression>() {{add(refNameEquals);}});
					IntegerExp unoInteger = OCLFactory.eINSTANCE.createIntegerExp();
					unoInteger.setIntegerSymbol(1);
					NavigationOrAttributeCallExp upperBoundNOCE = createNavigationOrAttributeCallExp(existsReference.getIterators().get(0), "upperBound");
					OperatorCallExp upperBound = createOperatorCallExp(upperBoundNOCE, ">", new ArrayList<OclExpression>() {{add(unoInteger);}});
					OperatorCallExp sequenceAndOperator = createOperatorCallExp(upperBound, "and", new ArrayList<OclExpression>() {{add(nameAndOperator);}});
					NavigationOrAttributeCallExp typeNOCE = createNavigationOrAttributeCallExp(existsReference.getIterators().get(0), "eType");
					NavigationOrAttributeCallExp typeNameNOCE = createNavigationOrAttributeCallExp(typeNOCE, "name");
					StringExp typeNameStringExp = OCLFactory.eINSTANCE.createStringExp();
					typeNameStringExp.setStringSymbol(ref.getEType().getName());
					OperatorCallExp typeOperatorCallExp = createOperatorCallExp(typeNameNOCE, "=", new ArrayList<OclExpression>() {{add(typeNameStringExp);}});
					OperatorCallExp typeAndOperator = createOperatorCallExp(typeOperatorCallExp, "and", new ArrayList<OclExpression>() {{add(sequenceAndOperator);}});
					existsReference.setBody(typeAndOperator);
					OperatorCallExp andOperator = createOperatorCallExp(classNameOperator, "and", new ArrayList<OclExpression>() {{add(existsReference);}});
					existsClass.setBody(andOperator);
					constraint.add(existsClass);
					String s = ATLSerializer.serialize(existsClass);
					System.out.println("seq " + s);
					//END NEW
				}
			} else {
				try {
					EStructuralFeature attr = EcoreFactory.eINSTANCE.createEAttribute();
					attr.setName(self.getPropertyName());
					//TODO verify if attribute is in the class
					attr.setUpperBound(-1);
					klass.getEStructuralFeatures().add(attr);
					attr.setEType(AnATLyzerUtils.getEcoreType(t));
				} catch (UndefinedTypeException e) {
					System.err.println("Unknow Type!: " + self.getPropertyName());
				}
			}
		}
		else 
		if (t instanceof OclModelElement) {
			EClass c = klassMap.get(t.getName());
			if(c==null) {
				c = EcoreFactory.eINSTANCE.createEClass();
				c.setName(t.getName());
				klassMap.put(t.getName(), c);
			}
			EStructuralFeature ref = EcoreFactory.eINSTANCE.createEReference();
			ref.setName(self.getPropertyName());
			ref.setEType(c);
			boolean guard = false;
			for(EReference ea : klass.getEAllReferences()) {
				if(ea.getName().equals(self.getPropertyName()))
					guard = true;
			}
			if (!guard) {
				klass.getEStructuralFeatures().add(ref);
				
				//NEW
				VariableDeclaration oclType = OCLFactory.eINSTANCE.createVariableDeclaration();
				oclType.setVarName("EClass");
				VariableExp varExp = OCLFactory.eINSTANCE.createVariableExp();
				varExp.setReferredVariable(oclType);
				OperationCallExp allInstancesCall = createAllInstance(varExp);
				IteratorExp existsClass = createExists("e", allInstancesCall);
				StringExp classNameSE = OCLFactory.eINSTANCE.createStringExp();
				classNameSE.setStringSymbol(klass.getName());
				NavigationOrAttributeCallExp classNameNOACE = createNavigationOrAttributeCallExp(existsClass.getIterators().get(0), "name");
				OperatorCallExp classNameOperator = createOperatorCallExp(classNameNOACE, "=", new ArrayList<OclExpression>() {{add(classNameSE);}});
				NavigationOrAttributeCallExp allStructuralFeature = createNavigationOrAttributeCallExp(existsClass.getIterators().get(0), "eAllStructuralFeatures");
				IteratorExp existsReference = createExists("f", allStructuralFeature);
				OperationCallExp oclIsTypeOf = createOclIsTypeOf(existsReference.getIterators().get(0), "ecore::EReference");
				NavigationOrAttributeCallExp refNameNOCE = createNavigationOrAttributeCallExp(existsReference.getIterators().get(0), "name");
				StringExp refNameString = OCLFactory.eINSTANCE.createStringExp();
				refNameString.setStringSymbol(ref.getName());
				OperatorCallExp refNameEquals = createOperatorCallExp(refNameNOCE, "=", new ArrayList<OclExpression>() {{add(refNameString);}});
				OperatorCallExp andOperatorName = createOperatorCallExp(oclIsTypeOf, "and", new ArrayList<OclExpression>() {{add(refNameEquals);}});
				
				NavigationOrAttributeCallExp typeNOCE = createNavigationOrAttributeCallExp(existsReference.getIterators().get(0), "eType");
				NavigationOrAttributeCallExp typeNameNOCE = createNavigationOrAttributeCallExp(typeNOCE, "name");
				StringExp typeNameStringExp = OCLFactory.eINSTANCE.createStringExp();
				typeNameStringExp.setStringSymbol(ref.getEType().getName());
				OperatorCallExp typeOperatorCallExp = createOperatorCallExp(typeNameNOCE, "=", new ArrayList<OclExpression>() {{add(typeNameStringExp);}});
				OperatorCallExp typeAndOperator = createOperatorCallExp(typeOperatorCallExp, "and", new ArrayList<OclExpression>() {{add(andOperatorName);}});
				
				existsReference.setBody(typeAndOperator);
				OperatorCallExp andOperator = createOperatorCallExp(classNameOperator, "and", new ArrayList<OclExpression>() {{add(existsReference);}});
				existsClass.setBody(andOperator);
				constraint.add(existsClass);
				String s = ATLSerializer.serialize(existsClass);
				System.out.println("JJ" + s);
				//END NEW
			}
		}
		else {
			try {
				
				EStructuralFeature attr = EcoreFactory.eINSTANCE.createEAttribute();
				attr.setName(self.getPropertyName());
				attr.setEType(AnATLyzerUtils.getEcoreType(t));
				boolean guard = false;
				for(EAttribute ea : klass.getEAllAttributes()) {
					if(ea.getName().equals(self.getPropertyName()))
						guard = true;
				}
				if (!guard) {
					klass.getEStructuralFeatures().add(attr);
					//NEW
					VariableDeclaration oclType = OCLFactory.eINSTANCE.createVariableDeclaration();
					oclType.setVarName("EClass");
					VariableExp varExp = OCLFactory.eINSTANCE.createVariableExp();
					varExp.setReferredVariable(oclType);
					OperationCallExp allInstancesCall = createAllInstance(varExp);
					IteratorExp existsClass = createExists("e", allInstancesCall);
					StringExp classNameSE = OCLFactory.eINSTANCE.createStringExp();
					classNameSE.setStringSymbol(klass.getName());
					NavigationOrAttributeCallExp classNameNOACE = createNavigationOrAttributeCallExp(existsClass.getIterators().get(0), "name");
					OperatorCallExp classNameOperator = createOperatorCallExp(classNameNOACE, "=", new ArrayList<OclExpression>() {{add(classNameSE);}});
					NavigationOrAttributeCallExp allStructuralFeature = createNavigationOrAttributeCallExp(existsClass.getIterators().get(0), "eAllStructuralFeatures");
					IteratorExp existsReference = createExists("f", allStructuralFeature);
					OperationCallExp oclIsTypeOf = createOclIsTypeOf(existsReference.getIterators().get(0), "ecore::EAttribute");
					NavigationOrAttributeCallExp refNameNOCE = createNavigationOrAttributeCallExp(existsReference.getIterators().get(0), "name");
					StringExp refNameString = OCLFactory.eINSTANCE.createStringExp();
					refNameString.setStringSymbol(attr.getName());
					OperatorCallExp refNameEquals = createOperatorCallExp(refNameNOCE, "=", new ArrayList<OclExpression>() {{add(refNameString);}});
					OperatorCallExp andOperatorName = createOperatorCallExp(oclIsTypeOf, "and", new ArrayList<OclExpression>() {{add(refNameEquals);}});
					
					NavigationOrAttributeCallExp typeNOCE = createNavigationOrAttributeCallExp(existsReference.getIterators().get(0), "eType");
					NavigationOrAttributeCallExp typeNameNOCE = createNavigationOrAttributeCallExp(typeNOCE, "name");
					StringExp typeNameStringExp = OCLFactory.eINSTANCE.createStringExp();
					typeNameStringExp.setStringSymbol(attr.getEType().getName());
					OperatorCallExp typeOperatorCallExp = createOperatorCallExp(typeNameNOCE, "=", new ArrayList<OclExpression>() {{add(typeNameStringExp);}});
					OperatorCallExp typeAndOperator = createOperatorCallExp(typeOperatorCallExp, "and", new ArrayList<OclExpression>() {{add(andOperatorName);}});
					
					
					existsReference.setBody(typeAndOperator);
					OperatorCallExp andOperator = createOperatorCallExp(classNameOperator, "and", new ArrayList<OclExpression>() {{add(existsReference);}});
					existsClass.setBody(andOperator);
					constraint.add(existsClass);
					String s = ATLSerializer.serialize(existsClass);
					System.out.println(s);
					//END NEW
				}
			} catch (UndefinedTypeException e) {
				System.err.println("Unknow Type!: " + self.getPropertyName());
			}
		}
	}
	
	private static OperationCallExp createAllInstance(OclExpression source) {
		OperationCallExp allInstancesCall = OCLFactory.eINSTANCE.createOperationCallExp();
		allInstancesCall.setOperationName("allInstances");
		allInstancesCall.setSource(source);
		return allInstancesCall;
	}
	
	private static OperationCallExp createOclIsTypeOf(VariableDeclaration source, String type) {
		VariableDeclaration oclType = OCLFactory.eINSTANCE.createVariableDeclaration();
		oclType.setVarName(type);
		VariableExp varExp = OCLFactory.eINSTANCE.createVariableExp();
		varExp.setReferredVariable(oclType);

		OperationCallExp allInstancesCall = OCLFactory.eINSTANCE.createOperationCallExp();
		allInstancesCall.setOperationName("oclIsTypeOf");
		VariableExp iteratorVariable = OCLFactory.eINSTANCE.createVariableExp();
		iteratorVariable.setReferredVariable(source);
		allInstancesCall.setSource(iteratorVariable);
		allInstancesCall.getArguments().add(varExp);
		return allInstancesCall;
	}
	
	private static IteratorExp createExists(String iteratorName, OclExpression source) {
		IteratorExp existsClass = OCLFactory.eINSTANCE.createIteratorExp();
		existsClass.setName("exists");
		existsClass.setSource(source);
		anatlyzer.atlext.OCL.Iterator classIterator = OCLFactory.eINSTANCE.createIterator();
		classIterator.setVarName(iteratorName);
		existsClass.getIterators().add(classIterator);
		return existsClass;
		
	}
	private static OperatorCallExp createOperatorCallExp(OclExpression source, String operationName, List<OclExpression> arguments) {
		OperatorCallExp classNameOperator = OCLFactory.eINSTANCE.createOperatorCallExp();
		classNameOperator.setSource(source);
		classNameOperator.setOperationName(operationName);
		for (OclExpression exp : arguments) {
			classNameOperator.getArguments().add(exp);
		}
		return classNameOperator;
	}
	private static NavigationOrAttributeCallExp createNavigationOrAttributeCallExp (OclExpression source, String name) {
		NavigationOrAttributeCallExp classNameNOACE = OCLFactory.eINSTANCE.createNavigationOrAttributeCallExp();
		
		classNameNOACE.setSource(source);
		classNameNOACE.setName(name);
		return classNameNOACE;
	}
	
	private static NavigationOrAttributeCallExp createNavigationOrAttributeCallExp (VariableDeclaration source, String name) {
		NavigationOrAttributeCallExp classNameNOACE = OCLFactory.eINSTANCE.createNavigationOrAttributeCallExp();
		VariableExp iteratorVariable = OCLFactory.eINSTANCE.createVariableExp();
		iteratorVariable.setReferredVariable(source);
		classNameNOACE.setSource(iteratorVariable);
		classNameNOACE.setName(name);
		return classNameNOACE;
	}
//
	@Override
	public void inNavigationOrAttributeCallExp(NavigationOrAttributeCallExp self) {
		oclExpressionTypeMap.put(self, discoverCallableType(self.getName()));
	}
	@Override
	public void beforeOclModelElement(OclModelElement self) {
		oclExpressionTypeMap.put(self, self);
	}
	@Override
	public void inOperationCallExp(OperationCallExp self) {
		if (self.getOperationName().equals("allInstances")) {
			SequenceType s = OCLFactory.eINSTANCE.createSequenceType();
			s.setElementType(oclExpressionTypeMap.get(self.getSource()));
			oclExpressionTypeMap.put(self, s);
		} else {
			OclType c = discoverCallableType(self.getOperationName());
			oclExpressionTypeMap.put(self, c);
		}
	}
	/*
	 * set the type of ocl operator call exp
	 * @see anatlyzer.atlext.processing.AbstractVisitor#inOperatorCallExp(anatlyzer.atlext.OCL.OperatorCallExp)
	 */
	@Override
	public void inOperatorCallExp(OperatorCallExp self) {
		//TODO better Unsterstand operator type
		OclType typeSource = oclExpressionTypeMap.get( self.getSource());
		if(typeSource!=null)
			oclExpressionTypeMap.put(self, typeSource);
		for (OclExpression iterable_element : self.getArguments()) {
			OclType types = oclExpressionTypeMap.get(iterable_element);
			if (types != null) {
				oclExpressionTypeMap.put(self, types);
			}
		}
	}

	@Override
	public void inIteratorExp(IteratorExp self) {
		//TODO SEQUENCE
		SequenceType s = OCLFactory.eINSTANCE.createSequenceType();
		s.setElementType(oclExpressionTypeMap.get(self.getBody()));
		oclExpressionTypeMap.put(self, s);
	}
	
	@Override
	public void beforeCollectionOperationCallExp(CollectionOperationCallExp self) {
		if(self.getOperationName().equals("size") || self.getOperationName().equals("sum"))
			oclExpressionTypeMap.put(self, OCLFactory.eINSTANCE.createIntegerType());
	}
	/*
	 * Create a Ocl String type
	 * (non-Javadoc)
	 * @see anatlyzer.atlext.processing.AbstractVisitor#beforeStringExp(anatlyzer.atlext.OCL.StringExp)
	 */
	@Override
	public void beforeStringExp(StringExp self) {
		oclExpressionTypeMap.put(self, OCLFactory.eINSTANCE.createStringType());
	};

	/*
	 * Create a OCL Integer type
	 * (non-Javadoc)
	 * @see anatlyzer.atlext.processing.AbstractVisitor#beforeIntegerExp(anatlyzer.atlext.OCL.IntegerExp)
	 */
	@Override
	public void beforeIntegerExp(IntegerExp self) {
		oclExpressionTypeMap.put(self, OCLFactory.eINSTANCE.createIntegerType());
	}
//	/*
//	 * Rough method. Can be better?
//	 */
	private OclType discoverCallableType(String operation) {
		Iterator<Entry<Callable, OclType>> iterator = callableElements.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Callable, OclType> a = iterator.next();
			
			//TO CONTEXT HELPER 
			if (a.getKey() instanceof ContextHelper) {
				ContextHelper ch = ((ContextHelper)a.getKey());
				if(ch.getDefinition().getFeature() instanceof Attribute) {
					Attribute oclFeature = (Attribute) ch.getDefinition().getFeature();
					if(oclFeature.getName().equals(operation)) {
						return a.getValue();
					}
				}
				if(ch.getDefinition().getFeature() instanceof Operation) {
					Operation oclFeature = (Operation) ch.getDefinition().getFeature();
					if(oclFeature.getName().equals(operation)) {
						return a.getValue();
					}
				}
			}
			
			//TO STATIC HELPER
			if (a.getKey() instanceof StaticHelper) {
				StaticHelper ch = ((StaticHelper)a.getKey());
				if(ch.getDefinition().getFeature() instanceof Attribute) {
					Attribute oclFeature = (Attribute) ch.getDefinition().getFeature();
					if(oclFeature.getName().equals(operation)) {
						return a.getValue();
					}
				}
				if(ch.getDefinition().getFeature() instanceof Operation) {
					Operation oclFeature = (Operation) ch.getDefinition().getFeature();
					if(oclFeature.getName().equals(operation)) {
						return a.getValue();
					}
				}
			}
			//TO LAZY RULE
			if (a.getKey() instanceof LazyRule) {
				LazyRule ch = ((LazyRule)a.getKey());
				if(ch.getName().equals(operation))
					return a.getValue();
			}
		}
		return callableElements.get(operation);
	}


	public List<OclExpression> getConstraint() {
		return constraint;
	}


	public void setConstraint(List<OclExpression> constraint) {
		this.constraint = constraint;
	}
}
