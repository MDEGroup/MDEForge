package org.mdeforge.business.anatlyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;

import anatlyzer.atlext.ATL.Callable;
import anatlyzer.atlext.ATL.ContextHelper;
import anatlyzer.atlext.ATL.LazyRule;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.SimpleOutPatternElement;
import anatlyzer.atlext.ATL.StaticHelper;
import anatlyzer.atlext.OCL.Attribute;
import anatlyzer.atlext.OCL.BagType;
import anatlyzer.atlext.OCL.OCLFactory;
import anatlyzer.atlext.OCL.OCLPackage;
import anatlyzer.atlext.OCL.OclFeature;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.OclType;
import anatlyzer.atlext.OCL.Operation;
import anatlyzer.atlext.processing.AbstractVisitor;

public class CallableVisitor extends AbstractVisitor {
	
	private Callable callable;
	
	//private HashMap<Callable, OclType> callableContextTypeMap = new HashMap<Callable, OclType>();
	private HashMap<Callable, OclType> callableOutputTypeMap = new HashMap<Callable, OclType>();
	private HashMap<LazyRule, List<OclType>> lazyRuleType =  new HashMap<LazyRule, List<OclType>>();
	private HashMap<OclFeature, OclType> oclFeatureMap = new HashMap<OclFeature, OclType>();
	private OclFeature element;
	private OclType oclType;
	public Callable getElement() {
		return callable;
	}

	public OclType getOclType() {
		return oclType;
	}

	public void perform(Callable callable) {
		startVisiting(callable);
	}
	
	@Override
	public void beforeOperation(Operation self) {
		oclFeatureMap.put(self, self.getReturnType());
//		element = self;
//		oclType = self.getReturnType();
	}
	
	@Override
	public void beforeAttribute(Attribute self) {
		oclFeatureMap.put(self, self.getType());
//		element = self;
//		oclType = self.getType();
	}
	
	@Override
	public void inContextHelper(ContextHelper self) {
		callable = self;
		oclType = oclFeatureMap.get(self.getDefinition().getFeature());
	}
	
	@Override
	public void inStaticHelper(StaticHelper self) {
		callable = self;
		oclType = oclFeatureMap.get(self.getDefinition().getFeature());
	}
	
	@Override
	public void beforeLazyRule(LazyRule self) {
		if(self.getOutPattern().getElements().size()!=0) {
			OutPatternElement outClass = self.getOutPattern().getElements().get(0);
			OclModelElement as = OCLFactory.eINSTANCE.createOclModelElement();
			as.setName(outClass.getType().getName());
			callable = self;
			oclType = as;
		}
//		System.out.println("CI SONO");
	}
}
