/**
 * @Generated
 */
grammar MyAtl;

options {
  language=JavaScript;
  output=AST;
  ASTLabelType=CommonTree;
}

@lexer::header {
}

@parser::header {
}


rule_Module:

	'module'
	name_0=rule_UnrestrictedName';' 
	'create' 'OUT' ':' outmodels_1+=rule_NameExpCS	(','outmodels_2+=rule_NameExpCS)*
	'from' (inmodels_3+=rule_NameExpCS (',' | ':')	(','inmodels_4+=rule_NameExpCS)*)* 'IN' ':' inmodels_5+=rule_NameExpCS	(','inmodels_6+=rule_NameExpCS)* 
	';' ('uses' varname_7=rule_NameExpCS ';')?	
	elements_8+=rule_ModuleElement*
	
	 EOF!;

 

		

rule_EssentialOCLUnreservedName :
	rule_UnrestrictedName | rule_CollectionTypeIdentifier |  rule_PrimitiveTypeIdentifier | 'Tuple' 
;



rule_UnreservedName :
	rule_EssentialOCLUnreservedName
;



rule_PrimitiveTypeIdentifier:
	'Boolean' | 'Integer' | 'Real' | 'String' | 'UnlimitedNatural' | 'OclAny'
	| 'OclInvalid' | 'OclVoid'
;





rule_CollectionTypeIdentifier :
	'Set' | 'Bag' | 'Sequence' | 'Collection' | 'OrderedSet'
;




rule_UnrestrictedName :
	rule_EssentialOCLUnrestrictedName
;





rule_EssentialOCLUnrestrictedName :
		SIMPLE_ID
;




rule_ModuleElement: 

	rule_Helper | rule_MatchedRule | rule_CalledRule  | rule_QueryRule;



rule_MatchedRule : 
	('lazy')? 'rule' name_0=rule_UnrestrictedName '{'
		'from'
		inpattern_1=rule_InPattern 
		('using' '{'
		variables_2 += rule_RuleVariableDeclaration*
		'}')?
		'to'
		outpattern_3=rule_OutPattern ('...')? (',')?
		('do' '{'
			actionblock_4=rule_ActionBlock
			'}'
		)?

	 (',')?'}'

;




rule_CalledRule :
	('entrypoint' | 'endpoint') 'rule' name_0=rule_UnrestrictedName
	('('')')? '{'
		('using' '{'
		variables_1 += rule_RuleVariableDeclaration*
		'}')?
		'to'
		outpattern_2=rule_OutPattern ('...')? (',')?
		('do' '{'
			actionblock_3=rule_ActionBlock
		'}'
		)?
	 (',')?'}'
;



rule_QueryRule :
	'query'  name_0=rule_UnrestrictedName 
	('('
	(parameters_1+=rule_ATLParameterCS (','
		parameters_2+=rule_ATLParameterCS)*)?
	')')?
	
	'=' initexpression_3=rule_ExpCS ';'
	
;



/*

 *helper [context context type]? def :

 *helper_name(parameters) : return_type = exp;

 */



rule_Helper :
	'helper'  ('context')? (name_0=rule_UnrestrictedName)? 	
	definition_1=rule_ATLDefCS 
;





/*

 *Implementation of Complete OGL Parts for ATL.

 *Adaption, ATL hac nome differences; 'context' is not

 *optional in OCL.

 *OCL DefCS requires 'stat1c' key word.

 */




rule_ATLDefCS:

	'def' ':' varname_0=rule_UnrestrictedName
	('('
	(parameters_1+=rule_ATLParameterCS (','
		parameters_2+=rule_ATLParameterCS)*)?
	')')?
	':' type_3=rule_ATLType
	'=' initexpression_4=rule_ExpCS ';'

;






rule_ATLParameterCS:

	varname_0=rule_UnrestrictedName ':' type_1=rule_ATLType

;





rule_RuleVariableDeclaration:
		varname_0=rule_UnrestrictedName ':' type_1=rule_ATLType 
		'=' initexpression_2=rule_ExpCS ';'

;





rule_InPattern:
	elements_0+=rule_InPatternElement ('('
	filter_1=rule_ExpCS?
	')')?

;




rule_InPatternElement  :
	varname_0=rule_UnrestrictedName ':' type_1=rule_ATLType

;




rule_OutPattern:
	elements_0+=rule_OutPatternElement (','
		elements_1+=rule_OutPatternElement)*

;




rule_OutPatternElement:
	rule_SimpleOutPatternElement	| rule_ForEachOutPatternElement
;




rule_SimpleOutPatternElement :
	varname_0=rule_UnrestrictedName ':' type_1=rule_ATLType
	('('
		(bindings_2+=rule_Binding (',' bindings_3+=rule_Binding)*)?
	')')?

;




rule_ForEachOutPatternElement:
	'xxx'
	collection_0 = rule_ExpCS
	'yyy'
;



rule_Binding:
	propertyname_0=rule_UnrestrictedName '<-' value_1=rule_ExpCS

;





rule_ActionBlock:
	statements_0+=rule_Statement+
;





rule_Statement:
	rule_BindingStat
;





rule_BindingStat:
	source_0=rule_ExpCS '.' 
	propertyname_1=rule_UnrestrictedName '<-'
	value_2=rule_ExpCS ';'
;




rule_ATLType :
	(modelname_0 = rule_ATLModelName '!')? type_1 = rule_TypeExpCS
;





rule_ATLModelName :
	rule_UnrestrictedName;





rule_EssentialOCLRersevedKeyword:
	'and' | 'else' | 'endif' | 'if' | 'implies' | 'in' | 'let' 
	| 'not' | 'or' | 'then' | 'xor'

;



rule_EssentialOCLPrefixOperator:

	'-' | 'not' 

;



rule_EssentialOCLInfixOperator:
	'*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and'
	| 'or' | 'xor' | 'implies'

;



rule_EssentialOCLNavigationOperator:
	'.' | '->'

;




rule_StringLiteral:
	SINGLE_QUOTED_STRING
;





rule_PrefixOperator:
	rule_EssentialOCLPrefixOperator
;



rule_InfixOperator:
	rule_EssentialOCLInfixOperator

;



rule_NavigationOperator:
	rule_EssentialOCLNavigationOperator
;





rule_CollectionTypeCS :
	name_0=rule_CollectionTypeIdentifier ((('(' | '{') (ownedtype_1=rule_TypeExpCS)? (')' | '}'))
		| ('<' ownedtype_2=rule_TypeExpCS '>'))?
				//backtrack='true'

;





rule_TupleTypeCS:
	name_0='Tuple'
	(('(' (ownedparts_1+=rule_TuplePartCS (',' ownedparts_2+=rule_TuplePartCS)*)? ')')
		| ('<' (ownedparts_3+=rule_TuplePartCS (',' ownedparts_4+=rule_TuplePartCS)*)?'>'))?
			backtrack_5='true'
;



 

rule_TuplePartCS:
	name_0=rule_UnrestrictedName ':' ownedtype_1=rule_TypeExpCS

;




rule_CollectionLiteralExpCS:
	ownedtype_0=rule_CollectionTypeCS
	'{' (ownedparts_1+=rule_CollectionLiteralPartCS (',' ownedparts_2+=rule_CollectionLiteralPartCS)*)?'}'


;



rule_CollectionLiteralPartCS:
	expressioncs_0=rule_ExpCS ('..' lastexpressioncs_1=rule_ExpCS)?

;





rule_PrimitiveLiteralExpCS:
	rule_NumberLiteralExpCS | rule_StringLiteralExpCS | rule_BooleanLiteralExpCS 
	| rule_UnlimitedNaturalLiteralExpCS | rule_InvalidLiteralExpCS | rule_NullLiteralExpCS

;



rule_TupleLiteralExpCS:
	'Tuple' '{' ownedparts_0+=rule_TupleLiteralPartCS (','
		ownedparts_1+=rule_TupleLiteralPartCS)* '}'

;



rule_TupleLiteralPartCS:
	name_0=rule_UnrestrictedName (':' ownedtype_1=rule_TypeExpCS)? '='
	initexpression_2=rule_ExpCS
;



rule_NumberLiteralExpCS:
	name_0=BIG_INT

;



rule_StringLiteralExpCS:
	name_0+=rule_StringLiteral

;



rule_BooleanLiteralExpCS:
	name_0='true' | name_1='false'


;





rule_UnlimitedNaturalLiteralExpCS:
	 '*'

;



rule_InvalidLiteralExpCS:
	 'invalid'

;



rule_NullLiteralExpCS:
	 'null'

;





rule_PrimitiveTypeCS:
	name_0=rule_PrimitiveTypeIdentifier

;





rule_TypeLiteralCS:
	rule_PrimitiveTypeCS  | rule_TupleTypeCS | rule_CollectionTypeCS 	

;



rule_TypeLiteralExpCS:
	ownedtype_0=rule_TypeLiteralCS

;



 

rule_TypeNameExpCS:
	namespace_0+=rule_UnrestrictedName  
	((
		(
			(  '::' (namespace_1 +=rule_UnreservedName '::')*   )
		element_2=rule_UnreservedName) 
	| element_3=rule_UnrestrictedName))?;




rule_TypeExpCS:
	rule_TypeNameExpCS | rule_TypeLiteralCS	
;




rule_NavigatingArgCS:
	name_0=rule_NavigatingArgExpCS (':' ownedtype_1=rule_TypeExpCS)? ('=' init_2=rule_ExpCS)?;



	

rule_NavigatingBarArgCS:
	prefix_0='|' name_1=rule_NavigatingArgExpCS (':' ownedtype_2=rule_TypeExpCS)? ('=' init_3=rule_ExpCS)?;





rule_NavigatingCommaArgCS:
	prefix_0=',' name_1=rule_NavigatingArgExpCS (':' ownedtype_2=rule_TypeExpCS)? ('=' init_3=rule_ExpCS)?;



		

rule_NavigatingSemiArgCS :
	prefix_0=';' name_1=rule_NavigatingArgExpCS (':' ownedtype_2=rule_TypeExpCS)? ('=' init_3=rule_ExpCS)?;





rule_NavigatingArgExpCS:
	rule_ExpCS;



	

rule_IfExpCS:
	'if' condition_0=rule_ExpCS
	'then' thenexpression_1=rule_ExpCS
	'else' elseexpression_2=rule_ExpCS
	'endif';



rule_LetExpCS:
	'let' variable_0+=rule_LetVariableCS (',' variable_1+=rule_LetVariableCS)*
	'in' in_2=rule_ExpCS;


	

rule_LetVariableCS:
	name_0=rule_UnrestrictedName (':'ownedtype_1=rule_TypeExpCS)? '='
	initexpression_2=rule_ExpCS;



	

rule_NestedExpCS:
	'(' source_0=rule_ExpCS ')';



	

rule_SelfExpCS:
	'self';




 //TypeLiteralExpCS | CollectionLiteralExpCS |

 			

  //regola ricorsiva da sistemare

 

rule_PrimaryExpCS:
	rule_NavigatingExpCS | rule_SelfExpCS | rule_PrimitiveLiteralExpCS | rule_TupleLiteralExpCS |
 	rule_LetExpCS | rule_IfExpCS | rule_NestedExpCS | rule_StringExpCs
		;




rule_StringExpCs:
	name_0 ='...'
;






rule_NameExpCS:
	namespace_0+=rule_UnrestrictedName  
	((
		(
			( '::' (namespace_1 +=rule_UnreservedName '::')*   )
		element_2=rule_UnreservedName) 
	| element_3=rule_UnrestrictedName))?;



		

rule_ExpCS:
	rule_InfixedExpCS

;





rule_InfixedExpCS:
		rule_PrefixedExpCS (
	(ownedoperator_0+=rule_BinaryOperatorCS ownedexpression_1+=rule_PrefixedExpCS)+)?

	 ;





rule_BinaryOperatorCS :
	rule_InfixOperatorCS | rule_NavigationOperatorCS ;

	

rule_InfixOperatorCS:
	name_0=rule_InfixOperator ;



	

rule_NavigationOperatorCS :
	name_0=rule_NavigationOperator ;







rule_PrefixedExpCS :
	rule_PrimaryExpCS | ( ownedoperator_0+=rule_UnaryOperatorCS+
		ownedexpression_1=rule_PrimaryExpCS) ;



		

rule_UnaryOperatorCS :
	name_0=rule_PrefixOperator ;



	



rule_IndexExpCS:
	rule_NameExpCS
	(
		'[' firstindexes_0+=rule_ExpCS (',' firstindexes_1+=rule_ExpCS)* ']'
		('[' secondindexes_2+=rule_ExpCS (',' secondindexes_3+=rule_ExpCS)* ']')?)?;



		

rule_NavigatingExpCS_Base:

	rule_IndexExpCS

;





rule_NavigatingExpCS :
	rule_NavigatingExpCS_Base 
	(
		'(' (argument_0+=rule_NavigatingArgCS (argument_1+=rule_NavigatingCommaArgCS)*
			(argument_2+=rule_NavigatingSemiArgCS
				(argument_3+=rule_NavigatingCommaArgCS)*)?
				(argument_4+=rule_NavigatingBarArgCS (argument_5+=rule_NavigatingCommaArgCS)*)?)?')'
					) ?;



		






SINGLE_QUOTED_STRING:
	'\'' ('\\'('b' | 't'| 'n' | 'f' | 'r'  | 'u'  | '"'  | '\''
		| '\\') | ~('\\' | '\''))* '\''	
;




SIMPLE_ID:
	('a'..'z' | 'A'..'Z'|'_'|'#' | '|' | '"' ) ('a'..'z'|'A'..'Z' | '_' | '0'..'9'|'!' | '|' | '"' )*

;





BIG_INT :
	('0'..'9')+

;





ID : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')* ;

STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~('\\'|'"'))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~('\\'|'\''))* '\'');

COMMENT : ('/*' .* '*/' | '//' ~('\r' | '\n')*) +  {$channel = HIDDEN; } ;

WS:  (' '|'\r'|'\t'|'\u000C'|'\n')+ {$channel = HIDDEN; } ;

INT: ('0'..'9')+;

