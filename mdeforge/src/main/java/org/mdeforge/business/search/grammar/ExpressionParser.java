package org.mdeforge.business.search.grammar;

import org.parboiled.BaseParser;
import org.parboiled.Rule;

public class ExpressionParser extends BaseParser<Object> {
	Rule Expression() {
		return Sequence(Ch('-'), Query());
	}
	Rule Query() {
		return null;
	}
	
	
}
