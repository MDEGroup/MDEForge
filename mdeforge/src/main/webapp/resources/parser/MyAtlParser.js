// $ANTLR 3.3 avr. 19, 2016 01:13:22 E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g 2018-02-13 18:13:43



/**
 * @Generated
 */
var MyAtlParser = function(input, state) {
    if (!state) {
        state = new org.antlr.runtime.RecognizerSharedState();
    }

    (function(){
    }).call(this);

    MyAtlParser.superclass.constructor.call(this, input, state);

    this.dfa41 = new MyAtlParser.DFA41(this);

         

    /* @todo only create adaptor if output=AST */
    this.adaptor = new org.antlr.runtime.tree.CommonTreeAdaptor();

};

org.antlr.lang.augmentObject(MyAtlParser, {
    EOF: -1,
    T__12: 12,
    T__13: 13,
    T__14: 14,
    T__15: 15,
    T__16: 16,
    T__17: 17,
    T__18: 18,
    T__19: 19,
    T__20: 20,
    T__21: 21,
    T__22: 22,
    T__23: 23,
    T__24: 24,
    T__25: 25,
    T__26: 26,
    T__27: 27,
    T__28: 28,
    T__29: 29,
    T__30: 30,
    T__31: 31,
    T__32: 32,
    T__33: 33,
    T__34: 34,
    T__35: 35,
    T__36: 36,
    T__37: 37,
    T__38: 38,
    T__39: 39,
    T__40: 40,
    T__41: 41,
    T__42: 42,
    T__43: 43,
    T__44: 44,
    T__45: 45,
    T__46: 46,
    T__47: 47,
    T__48: 48,
    T__49: 49,
    T__50: 50,
    T__51: 51,
    T__52: 52,
    T__53: 53,
    T__54: 54,
    T__55: 55,
    T__56: 56,
    T__57: 57,
    T__58: 58,
    T__59: 59,
    T__60: 60,
    T__61: 61,
    T__62: 62,
    T__63: 63,
    T__64: 64,
    T__65: 65,
    T__66: 66,
    T__67: 67,
    T__68: 68,
    T__69: 69,
    T__70: 70,
    T__71: 71,
    T__72: 72,
    T__73: 73,
    T__74: 74,
    T__75: 75,
    T__76: 76,
    T__77: 77,
    T__78: 78,
    T__79: 79,
    T__80: 80,
    T__81: 81,
    T__82: 82,
    T__83: 83,
    T__84: 84,
    T__85: 85,
    T__86: 86,
    T__87: 87,
    SIMPLE_ID: 4,
    SINGLE_QUOTED_STRING: 5,
    BIG_INT: 6,
    ID: 7,
    STRING: 8,
    COMMENT: 9,
    WS: 10,
    INT: 11
});

(function(){
// public class variables
var EOF= -1,
    T__12= 12,
    T__13= 13,
    T__14= 14,
    T__15= 15,
    T__16= 16,
    T__17= 17,
    T__18= 18,
    T__19= 19,
    T__20= 20,
    T__21= 21,
    T__22= 22,
    T__23= 23,
    T__24= 24,
    T__25= 25,
    T__26= 26,
    T__27= 27,
    T__28= 28,
    T__29= 29,
    T__30= 30,
    T__31= 31,
    T__32= 32,
    T__33= 33,
    T__34= 34,
    T__35= 35,
    T__36= 36,
    T__37= 37,
    T__38= 38,
    T__39= 39,
    T__40= 40,
    T__41= 41,
    T__42= 42,
    T__43= 43,
    T__44= 44,
    T__45= 45,
    T__46= 46,
    T__47= 47,
    T__48= 48,
    T__49= 49,
    T__50= 50,
    T__51= 51,
    T__52= 52,
    T__53= 53,
    T__54= 54,
    T__55= 55,
    T__56= 56,
    T__57= 57,
    T__58= 58,
    T__59= 59,
    T__60= 60,
    T__61= 61,
    T__62= 62,
    T__63= 63,
    T__64= 64,
    T__65= 65,
    T__66= 66,
    T__67= 67,
    T__68= 68,
    T__69= 69,
    T__70= 70,
    T__71= 71,
    T__72= 72,
    T__73= 73,
    T__74= 74,
    T__75= 75,
    T__76= 76,
    T__77= 77,
    T__78= 78,
    T__79= 79,
    T__80= 80,
    T__81= 81,
    T__82= 82,
    T__83= 83,
    T__84= 84,
    T__85= 85,
    T__86= 86,
    T__87= 87,
    SIMPLE_ID= 4,
    SINGLE_QUOTED_STRING= 5,
    BIG_INT= 6,
    ID= 7,
    STRING= 8,
    COMMENT= 9,
    WS= 10,
    INT= 11;

// public instance methods/vars
org.antlr.lang.extend(MyAtlParser, org.antlr.runtime.Parser, {
        
    setTreeAdaptor: function(adaptor) {
        this.adaptor = adaptor;
    },
    getTreeAdaptor: function() {
        return this.adaptor;
    },

    getTokenNames: function() { return MyAtlParser.tokenNames; },
    getGrammarFileName: function() { return "E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g"; }
});
org.antlr.lang.augmentObject(MyAtlParser.prototype, {

    // inline static return class
    rule_Module_return: (function() {
        MyAtlParser.rule_Module_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_Module_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:19:1: rule_Module : 'module' name_0= rule_UnrestrictedName ';' 'create' 'OUT' ':' outmodels_1+= rule_NameExpCS ( ',' outmodels_2+= rule_NameExpCS )* 'from' (inmodels_3+= rule_NameExpCS ( ',' | ':' ) ( ',' inmodels_4+= rule_NameExpCS )* )* 'IN' ':' inmodels_5+= rule_NameExpCS ( ',' inmodels_6+= rule_NameExpCS )* ';' ( 'uses' varname_7= rule_NameExpCS ';' )? (elements_8+= rule_ModuleElement )* EOF ;
    // $ANTLR start "rule_Module"
    rule_Module: function() {
        var retval = new MyAtlParser.rule_Module_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal1 = null;
        var char_literal2 = null;
        var string_literal3 = null;
        var string_literal4 = null;
        var char_literal5 = null;
        var char_literal6 = null;
        var string_literal7 = null;
        var set8 = null;
        var char_literal9 = null;
        var string_literal10 = null;
        var char_literal11 = null;
        var char_literal12 = null;
        var char_literal13 = null;
        var string_literal14 = null;
        var char_literal15 = null;
        var EOF16 = null;
        var list_outmodels_1=null;
        var list_outmodels_2=null;
        var list_inmodels_3=null;
        var list_inmodels_4=null;
        var list_inmodels_5=null;
        var list_inmodels_6=null;
        var list_elements_8=null;
         var name_0 = null;
         var varname_7 = null;
        var outmodels_1 = null;
        var outmodels_2 = null;
        var inmodels_3 = null;
        var inmodels_4 = null;
        var inmodels_5 = null;
        var inmodels_6 = null;
        var elements_8 = null;
        var string_literal1_tree=null;
        var char_literal2_tree=null;
        var string_literal3_tree=null;
        var string_literal4_tree=null;
        var char_literal5_tree=null;
        var char_literal6_tree=null;
        var string_literal7_tree=null;
        var set8_tree=null;
        var char_literal9_tree=null;
        var string_literal10_tree=null;
        var char_literal11_tree=null;
        var char_literal12_tree=null;
        var char_literal13_tree=null;
        var string_literal14_tree=null;
        var char_literal15_tree=null;
        var EOF16_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:19:12: ( 'module' name_0= rule_UnrestrictedName ';' 'create' 'OUT' ':' outmodels_1+= rule_NameExpCS ( ',' outmodels_2+= rule_NameExpCS )* 'from' (inmodels_3+= rule_NameExpCS ( ',' | ':' ) ( ',' inmodels_4+= rule_NameExpCS )* )* 'IN' ':' inmodels_5+= rule_NameExpCS ( ',' inmodels_6+= rule_NameExpCS )* ';' ( 'uses' varname_7= rule_NameExpCS ';' )? (elements_8+= rule_ModuleElement )* EOF )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:21:2: 'module' name_0= rule_UnrestrictedName ';' 'create' 'OUT' ':' outmodels_1+= rule_NameExpCS ( ',' outmodels_2+= rule_NameExpCS )* 'from' (inmodels_3+= rule_NameExpCS ( ',' | ':' ) ( ',' inmodels_4+= rule_NameExpCS )* )* 'IN' ':' inmodels_5+= rule_NameExpCS ( ',' inmodels_6+= rule_NameExpCS )* ';' ( 'uses' varname_7= rule_NameExpCS ';' )? (elements_8+= rule_ModuleElement )* EOF
            root_0 = this.adaptor.nil();

            string_literal1=this.match(this.input,12,MyAtlParser.FOLLOW_12_in_rule_Module58); 
            string_literal1_tree = this.adaptor.create(string_literal1);
            this.adaptor.addChild(root_0, string_literal1_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_Module63);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            char_literal2=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_Module64); 
            char_literal2_tree = this.adaptor.create(char_literal2);
            this.adaptor.addChild(root_0, char_literal2_tree);

            string_literal3=this.match(this.input,14,MyAtlParser.FOLLOW_14_in_rule_Module68); 
            string_literal3_tree = this.adaptor.create(string_literal3);
            this.adaptor.addChild(root_0, string_literal3_tree);

            string_literal4=this.match(this.input,15,MyAtlParser.FOLLOW_15_in_rule_Module70); 
            string_literal4_tree = this.adaptor.create(string_literal4);
            this.adaptor.addChild(root_0, string_literal4_tree);

            char_literal5=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_Module72); 
            char_literal5_tree = this.adaptor.create(char_literal5);
            this.adaptor.addChild(root_0, char_literal5_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_NameExpCS_in_rule_Module76);
            outmodels_1=this.rule_NameExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, outmodels_1.getTree());
            if (org.antlr.lang.isNull(list_outmodels_1)) list_outmodels_1 = [];
            list_outmodels_1.push(outmodels_1.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:23:49: ( ',' outmodels_2+= rule_NameExpCS )*
            loop1:
            do {
                var alt1=2;
                var LA1_0 = this.input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:23:50: ',' outmodels_2+= rule_NameExpCS
                    char_literal6=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_Module79); 
                    char_literal6_tree = this.adaptor.create(char_literal6);
                    this.adaptor.addChild(root_0, char_literal6_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NameExpCS_in_rule_Module82);
                    outmodels_2=this.rule_NameExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, outmodels_2.getTree());
                    if (org.antlr.lang.isNull(list_outmodels_2)) list_outmodels_2 = [];
                    list_outmodels_2.push(outmodels_2.getTree());



                    break;

                default :
                    break loop1;
                }
            } while (true);

            string_literal7=this.match(this.input,18,MyAtlParser.FOLLOW_18_in_rule_Module87); 
            string_literal7_tree = this.adaptor.create(string_literal7);
            this.adaptor.addChild(root_0, string_literal7_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:24:9: (inmodels_3+= rule_NameExpCS ( ',' | ':' ) ( ',' inmodels_4+= rule_NameExpCS )* )*
            loop3:
            do {
                var alt3=2;
                var LA3_0 = this.input.LA(1);

                if ( (LA3_0==SIMPLE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:24:10: inmodels_3+= rule_NameExpCS ( ',' | ':' ) ( ',' inmodels_4+= rule_NameExpCS )*
                    this.pushFollow(MyAtlParser.FOLLOW_rule_NameExpCS_in_rule_Module92);
                    inmodels_3=this.rule_NameExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, inmodels_3.getTree());
                    if (org.antlr.lang.isNull(list_inmodels_3)) list_inmodels_3 = [];
                    list_inmodels_3.push(inmodels_3.getTree());

                    set8=this.input.LT(1);
                    if ( (this.input.LA(1)>=16 && this.input.LA(1)<=17) ) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set8));
                        this.state.errorRecovery=false;
                    }
                    else {
                        var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                        throw mse;
                    }

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:24:49: ( ',' inmodels_4+= rule_NameExpCS )*
                    loop2:
                    do {
                        var alt2=2;
                        var LA2_0 = this.input.LA(1);

                        if ( (LA2_0==17) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:24:50: ',' inmodels_4+= rule_NameExpCS
                            char_literal9=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_Module103); 
                            char_literal9_tree = this.adaptor.create(char_literal9);
                            this.adaptor.addChild(root_0, char_literal9_tree);

                            this.pushFollow(MyAtlParser.FOLLOW_rule_NameExpCS_in_rule_Module106);
                            inmodels_4=this.rule_NameExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, inmodels_4.getTree());
                            if (org.antlr.lang.isNull(list_inmodels_4)) list_inmodels_4 = [];
                            list_inmodels_4.push(inmodels_4.getTree());



                            break;

                        default :
                            break loop2;
                        }
                    } while (true);



                    break;

                default :
                    break loop3;
                }
            } while (true);

            string_literal10=this.match(this.input,19,MyAtlParser.FOLLOW_19_in_rule_Module112); 
            string_literal10_tree = this.adaptor.create(string_literal10);
            this.adaptor.addChild(root_0, string_literal10_tree);

            char_literal11=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_Module114); 
            char_literal11_tree = this.adaptor.create(char_literal11);
            this.adaptor.addChild(root_0, char_literal11_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_NameExpCS_in_rule_Module118);
            inmodels_5=this.rule_NameExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, inmodels_5.getTree());
            if (org.antlr.lang.isNull(list_inmodels_5)) list_inmodels_5 = [];
            list_inmodels_5.push(inmodels_5.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:24:120: ( ',' inmodels_6+= rule_NameExpCS )*
            loop4:
            do {
                var alt4=2;
                var LA4_0 = this.input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:24:121: ',' inmodels_6+= rule_NameExpCS
                    char_literal12=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_Module121); 
                    char_literal12_tree = this.adaptor.create(char_literal12);
                    this.adaptor.addChild(root_0, char_literal12_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NameExpCS_in_rule_Module124);
                    inmodels_6=this.rule_NameExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, inmodels_6.getTree());
                    if (org.antlr.lang.isNull(list_inmodels_6)) list_inmodels_6 = [];
                    list_inmodels_6.push(inmodels_6.getTree());



                    break;

                default :
                    break loop4;
                }
            } while (true);

            char_literal13=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_Module130); 
            char_literal13_tree = this.adaptor.create(char_literal13);
            this.adaptor.addChild(root_0, char_literal13_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:25:6: ( 'uses' varname_7= rule_NameExpCS ';' )?
            var alt5=2;
            var LA5_0 = this.input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:25:7: 'uses' varname_7= rule_NameExpCS ';'
                    string_literal14=this.match(this.input,20,MyAtlParser.FOLLOW_20_in_rule_Module133); 
                    string_literal14_tree = this.adaptor.create(string_literal14);
                    this.adaptor.addChild(root_0, string_literal14_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NameExpCS_in_rule_Module137);
                    varname_7=this.rule_NameExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, varname_7.getTree());
                    char_literal15=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_Module139); 
                    char_literal15_tree = this.adaptor.create(char_literal15);
                    this.adaptor.addChild(root_0, char_literal15_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:26:12: (elements_8+= rule_ModuleElement )*
            loop6:
            do {
                var alt6=2;
                var LA6_0 = this.input.LA(1);

                if ( ((LA6_0>=35 && LA6_0<=36)||(LA6_0>=43 && LA6_0<=44)||LA6_0==47||LA6_0==49) ) {
                    alt6=1;
                }


                switch (alt6) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:26:12: elements_8+= rule_ModuleElement
                    this.pushFollow(MyAtlParser.FOLLOW_rule_ModuleElement_in_rule_Module147);
                    elements_8=this.rule_ModuleElement();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, elements_8.getTree());
                    if (org.antlr.lang.isNull(list_elements_8)) list_elements_8 = [];
                    list_elements_8.push(elements_8.getTree());



                    break;

                default :
                    break loop6;
                }
            } while (true);

            EOF16=this.match(this.input,EOF,MyAtlParser.FOLLOW_EOF_in_rule_Module154); 



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_EssentialOCLUnreservedName_return: (function() {
        MyAtlParser.rule_EssentialOCLUnreservedName_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_EssentialOCLUnreservedName_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:34:1: rule_EssentialOCLUnreservedName : ( rule_UnrestrictedName | rule_CollectionTypeIdentifier | rule_PrimitiveTypeIdentifier | 'Tuple' );
    // $ANTLR start "rule_EssentialOCLUnreservedName"
    rule_EssentialOCLUnreservedName: function() {
        var retval = new MyAtlParser.rule_EssentialOCLUnreservedName_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal20 = null;
         var rule_UnrestrictedName17 = null;
         var rule_CollectionTypeIdentifier18 = null;
         var rule_PrimitiveTypeIdentifier19 = null;

        var string_literal20_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:34:33: ( rule_UnrestrictedName | rule_CollectionTypeIdentifier | rule_PrimitiveTypeIdentifier | 'Tuple' )
            var alt7=4;
            switch ( this.input.LA(1) ) {
            case SIMPLE_ID:
                alt7=1;
                break;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                alt7=2;
                break;
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                alt7=3;
                break;
            case 21:
                alt7=4;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 7, 0, this.input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:35:2: rule_UnrestrictedName
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_EssentialOCLUnreservedName171);
                    rule_UnrestrictedName17=this.rule_UnrestrictedName();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_UnrestrictedName17.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:35:26: rule_CollectionTypeIdentifier
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionTypeIdentifier_in_rule_EssentialOCLUnreservedName175);
                    rule_CollectionTypeIdentifier18=this.rule_CollectionTypeIdentifier();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_CollectionTypeIdentifier18.getTree());


                    break;
                case 3 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:35:59: rule_PrimitiveTypeIdentifier
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_PrimitiveTypeIdentifier_in_rule_EssentialOCLUnreservedName180);
                    rule_PrimitiveTypeIdentifier19=this.rule_PrimitiveTypeIdentifier();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_PrimitiveTypeIdentifier19.getTree());


                    break;
                case 4 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:35:90: 'Tuple'
                    root_0 = this.adaptor.nil();

                    string_literal20=this.match(this.input,21,MyAtlParser.FOLLOW_21_in_rule_EssentialOCLUnreservedName184); 
                    string_literal20_tree = this.adaptor.create(string_literal20);
                    this.adaptor.addChild(root_0, string_literal20_tree);



                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_UnreservedName_return: (function() {
        MyAtlParser.rule_UnreservedName_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_UnreservedName_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:40:1: rule_UnreservedName : rule_EssentialOCLUnreservedName ;
    // $ANTLR start "rule_UnreservedName"
    rule_UnreservedName: function() {
        var retval = new MyAtlParser.rule_UnreservedName_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_EssentialOCLUnreservedName21 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:40:21: ( rule_EssentialOCLUnreservedName )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:41:2: rule_EssentialOCLUnreservedName
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_EssentialOCLUnreservedName_in_rule_UnreservedName197);
            rule_EssentialOCLUnreservedName21=this.rule_EssentialOCLUnreservedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_EssentialOCLUnreservedName21.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_PrimitiveTypeIdentifier_return: (function() {
        MyAtlParser.rule_PrimitiveTypeIdentifier_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_PrimitiveTypeIdentifier_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:46:1: rule_PrimitiveTypeIdentifier : ( 'Boolean' | 'Integer' | 'Real' | 'String' | 'UnlimitedNatural' | 'OclAny' | 'OclInvalid' | 'OclVoid' );
    // $ANTLR start "rule_PrimitiveTypeIdentifier"
    rule_PrimitiveTypeIdentifier: function() {
        var retval = new MyAtlParser.rule_PrimitiveTypeIdentifier_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set22 = null;

        var set22_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:46:29: ( 'Boolean' | 'Integer' | 'Real' | 'String' | 'UnlimitedNatural' | 'OclAny' | 'OclInvalid' | 'OclVoid' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set22=this.input.LT(1);
            if ( (this.input.LA(1)>=22 && this.input.LA(1)<=29) ) {
                this.input.consume();
                this.adaptor.addChild(root_0, this.adaptor.create(set22));
                this.state.errorRecovery=false;
            }
            else {
                var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                throw mse;
            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_CollectionTypeIdentifier_return: (function() {
        MyAtlParser.rule_CollectionTypeIdentifier_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_CollectionTypeIdentifier_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:55:1: rule_CollectionTypeIdentifier : ( 'Set' | 'Bag' | 'Sequence' | 'Collection' | 'OrderedSet' );
    // $ANTLR start "rule_CollectionTypeIdentifier"
    rule_CollectionTypeIdentifier: function() {
        var retval = new MyAtlParser.rule_CollectionTypeIdentifier_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set23 = null;

        var set23_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:55:31: ( 'Set' | 'Bag' | 'Sequence' | 'Collection' | 'OrderedSet' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set23=this.input.LT(1);
            if ( (this.input.LA(1)>=30 && this.input.LA(1)<=34) ) {
                this.input.consume();
                this.adaptor.addChild(root_0, this.adaptor.create(set23));
                this.state.errorRecovery=false;
            }
            else {
                var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                throw mse;
            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_UnrestrictedName_return: (function() {
        MyAtlParser.rule_UnrestrictedName_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_UnrestrictedName_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:62:1: rule_UnrestrictedName : rule_EssentialOCLUnrestrictedName ;
    // $ANTLR start "rule_UnrestrictedName"
    rule_UnrestrictedName: function() {
        var retval = new MyAtlParser.rule_UnrestrictedName_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_EssentialOCLUnrestrictedName24 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:62:23: ( rule_EssentialOCLUnrestrictedName )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:63:2: rule_EssentialOCLUnrestrictedName
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_EssentialOCLUnrestrictedName_in_rule_UnrestrictedName280);
            rule_EssentialOCLUnrestrictedName24=this.rule_EssentialOCLUnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_EssentialOCLUnrestrictedName24.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_EssentialOCLUnrestrictedName_return: (function() {
        MyAtlParser.rule_EssentialOCLUnrestrictedName_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_EssentialOCLUnrestrictedName_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:70:1: rule_EssentialOCLUnrestrictedName : SIMPLE_ID ;
    // $ANTLR start "rule_EssentialOCLUnrestrictedName"
    rule_EssentialOCLUnrestrictedName: function() {
        var retval = new MyAtlParser.rule_EssentialOCLUnrestrictedName_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var SIMPLE_ID25 = null;

        var SIMPLE_ID25_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:70:35: ( SIMPLE_ID )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:71:3: SIMPLE_ID
            root_0 = this.adaptor.nil();

            SIMPLE_ID25=this.match(this.input,SIMPLE_ID,MyAtlParser.FOLLOW_SIMPLE_ID_in_rule_EssentialOCLUnrestrictedName295); 
            SIMPLE_ID25_tree = this.adaptor.create(SIMPLE_ID25);
            this.adaptor.addChild(root_0, SIMPLE_ID25_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_ModuleElement_return: (function() {
        MyAtlParser.rule_ModuleElement_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_ModuleElement_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:77:1: rule_ModuleElement : ( rule_Helper | rule_MatchedRule | rule_CalledRule | rule_QueryRule );
    // $ANTLR start "rule_ModuleElement"
    rule_ModuleElement: function() {
        var retval = new MyAtlParser.rule_ModuleElement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_Helper26 = null;
         var rule_MatchedRule27 = null;
         var rule_CalledRule28 = null;
         var rule_QueryRule29 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:77:19: ( rule_Helper | rule_MatchedRule | rule_CalledRule | rule_QueryRule )
            var alt8=4;
            switch ( this.input.LA(1) ) {
            case 49:
                alt8=1;
                break;
            case 35:
            case 36:
                alt8=2;
                break;
            case 43:
            case 44:
                alt8=3;
                break;
            case 47:
                alt8=4;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 8, 0, this.input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:79:2: rule_Helper
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_Helper_in_rule_ModuleElement309);
                    rule_Helper26=this.rule_Helper();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_Helper26.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:79:16: rule_MatchedRule
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_MatchedRule_in_rule_ModuleElement313);
                    rule_MatchedRule27=this.rule_MatchedRule();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_MatchedRule27.getTree());


                    break;
                case 3 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:79:35: rule_CalledRule
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_CalledRule_in_rule_ModuleElement317);
                    rule_CalledRule28=this.rule_CalledRule();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_CalledRule28.getTree());


                    break;
                case 4 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:79:54: rule_QueryRule
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_QueryRule_in_rule_ModuleElement322);
                    rule_QueryRule29=this.rule_QueryRule();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_QueryRule29.getTree());


                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_MatchedRule_return: (function() {
        MyAtlParser.rule_MatchedRule_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_MatchedRule_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:83:1: rule_MatchedRule : ( 'lazy' )? 'rule' name_0= rule_UnrestrictedName '{' 'from' inpattern_1= rule_InPattern ( 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_3= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_4= rule_ActionBlock '}' )? ( ',' )? '}' ;
    // $ANTLR start "rule_MatchedRule"
    rule_MatchedRule: function() {
        var retval = new MyAtlParser.rule_MatchedRule_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal30 = null;
        var string_literal31 = null;
        var char_literal32 = null;
        var string_literal33 = null;
        var string_literal34 = null;
        var char_literal35 = null;
        var char_literal36 = null;
        var string_literal37 = null;
        var string_literal38 = null;
        var char_literal39 = null;
        var string_literal40 = null;
        var char_literal41 = null;
        var char_literal42 = null;
        var char_literal43 = null;
        var char_literal44 = null;
        var list_variables_2=null;
         var name_0 = null;
         var inpattern_1 = null;
         var outpattern_3 = null;
         var actionblock_4 = null;
        var variables_2 = null;
        var string_literal30_tree=null;
        var string_literal31_tree=null;
        var char_literal32_tree=null;
        var string_literal33_tree=null;
        var string_literal34_tree=null;
        var char_literal35_tree=null;
        var char_literal36_tree=null;
        var string_literal37_tree=null;
        var string_literal38_tree=null;
        var char_literal39_tree=null;
        var string_literal40_tree=null;
        var char_literal41_tree=null;
        var char_literal42_tree=null;
        var char_literal43_tree=null;
        var char_literal44_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:83:18: ( ( 'lazy' )? 'rule' name_0= rule_UnrestrictedName '{' 'from' inpattern_1= rule_InPattern ( 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_3= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_4= rule_ActionBlock '}' )? ( ',' )? '}' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:84:2: ( 'lazy' )? 'rule' name_0= rule_UnrestrictedName '{' 'from' inpattern_1= rule_InPattern ( 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_3= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_4= rule_ActionBlock '}' )? ( ',' )? '}'
            root_0 = this.adaptor.nil();

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:84:2: ( 'lazy' )?
            var alt9=2;
            var LA9_0 = this.input.LA(1);

            if ( (LA9_0==35) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:84:3: 'lazy'
                    string_literal30=this.match(this.input,35,MyAtlParser.FOLLOW_35_in_rule_MatchedRule335); 
                    string_literal30_tree = this.adaptor.create(string_literal30);
                    this.adaptor.addChild(root_0, string_literal30_tree);



                    break;

            }

            string_literal31=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_MatchedRule339); 
            string_literal31_tree = this.adaptor.create(string_literal31);
            this.adaptor.addChild(root_0, string_literal31_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_MatchedRule343);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            char_literal32=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_MatchedRule345); 
            char_literal32_tree = this.adaptor.create(char_literal32);
            this.adaptor.addChild(root_0, char_literal32_tree);

            string_literal33=this.match(this.input,18,MyAtlParser.FOLLOW_18_in_rule_MatchedRule349); 
            string_literal33_tree = this.adaptor.create(string_literal33);
            this.adaptor.addChild(root_0, string_literal33_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_InPattern_in_rule_MatchedRule355);
            inpattern_1=this.rule_InPattern();

            this.state._fsp--;

            this.adaptor.addChild(root_0, inpattern_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:87:3: ( 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}' )?
            var alt11=2;
            var LA11_0 = this.input.LA(1);

            if ( (LA11_0==38) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:87:4: 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}'
                    string_literal34=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_MatchedRule361); 
                    string_literal34_tree = this.adaptor.create(string_literal34);
                    this.adaptor.addChild(root_0, string_literal34_tree);

                    char_literal35=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_MatchedRule363); 
                    char_literal35_tree = this.adaptor.create(char_literal35);
                    this.adaptor.addChild(root_0, char_literal35_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:88:15: (variables_2+= rule_RuleVariableDeclaration )*
                    loop10:
                    do {
                        var alt10=2;
                        var LA10_0 = this.input.LA(1);

                        if ( (LA10_0==SIMPLE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:88:15: variables_2+= rule_RuleVariableDeclaration
                            this.pushFollow(MyAtlParser.FOLLOW_rule_RuleVariableDeclaration_in_rule_MatchedRule371);
                            variables_2=this.rule_RuleVariableDeclaration();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, variables_2.getTree());
                            if (org.antlr.lang.isNull(list_variables_2)) list_variables_2 = [];
                            list_variables_2.push(variables_2.getTree());



                            break;

                        default :
                            break loop10;
                        }
                    } while (true);

                    char_literal36=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_MatchedRule376); 
                    char_literal36_tree = this.adaptor.create(char_literal36);
                    this.adaptor.addChild(root_0, char_literal36_tree);



                    break;

            }

            string_literal37=this.match(this.input,40,MyAtlParser.FOLLOW_40_in_rule_MatchedRule382); 
            string_literal37_tree = this.adaptor.create(string_literal37);
            this.adaptor.addChild(root_0, string_literal37_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_OutPattern_in_rule_MatchedRule388);
            outpattern_3=this.rule_OutPattern();

            this.state._fsp--;

            this.adaptor.addChild(root_0, outpattern_3.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:91:32: ( '...' )?
            var alt12=2;
            var LA12_0 = this.input.LA(1);

            if ( (LA12_0==41) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:91:33: '...'
                    string_literal38=this.match(this.input,41,MyAtlParser.FOLLOW_41_in_rule_MatchedRule391); 
                    string_literal38_tree = this.adaptor.create(string_literal38);
                    this.adaptor.addChild(root_0, string_literal38_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:91:41: ( ',' )?
            var alt13=2;
            var LA13_0 = this.input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:91:42: ','
                    char_literal39=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_MatchedRule396); 
                    char_literal39_tree = this.adaptor.create(char_literal39);
                    this.adaptor.addChild(root_0, char_literal39_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:92:3: ( 'do' '{' actionblock_4= rule_ActionBlock '}' )?
            var alt14=2;
            var LA14_0 = this.input.LA(1);

            if ( (LA14_0==42) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:92:4: 'do' '{' actionblock_4= rule_ActionBlock '}'
                    string_literal40=this.match(this.input,42,MyAtlParser.FOLLOW_42_in_rule_MatchedRule403); 
                    string_literal40_tree = this.adaptor.create(string_literal40);
                    this.adaptor.addChild(root_0, string_literal40_tree);

                    char_literal41=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_MatchedRule405); 
                    char_literal41_tree = this.adaptor.create(char_literal41);
                    this.adaptor.addChild(root_0, char_literal41_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ActionBlock_in_rule_MatchedRule412);
                    actionblock_4=this.rule_ActionBlock();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, actionblock_4.getTree());
                    char_literal42=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_MatchedRule417); 
                    char_literal42_tree = this.adaptor.create(char_literal42);
                    this.adaptor.addChild(root_0, char_literal42_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:97:3: ( ',' )?
            var alt15=2;
            var LA15_0 = this.input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:97:4: ','
                    char_literal43=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_MatchedRule428); 
                    char_literal43_tree = this.adaptor.create(char_literal43);
                    this.adaptor.addChild(root_0, char_literal43_tree);



                    break;

            }

            char_literal44=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_MatchedRule431); 
            char_literal44_tree = this.adaptor.create(char_literal44);
            this.adaptor.addChild(root_0, char_literal44_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_CalledRule_return: (function() {
        MyAtlParser.rule_CalledRule_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_CalledRule_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:104:1: rule_CalledRule : ( 'entrypoint' | 'endpoint' ) 'rule' name_0= rule_UnrestrictedName ( '(' ')' )? '{' ( 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_2= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_3= rule_ActionBlock '}' )? ( ',' )? '}' ;
    // $ANTLR start "rule_CalledRule"
    rule_CalledRule: function() {
        var retval = new MyAtlParser.rule_CalledRule_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set45 = null;
        var string_literal46 = null;
        var char_literal47 = null;
        var char_literal48 = null;
        var char_literal49 = null;
        var string_literal50 = null;
        var char_literal51 = null;
        var char_literal52 = null;
        var string_literal53 = null;
        var string_literal54 = null;
        var char_literal55 = null;
        var string_literal56 = null;
        var char_literal57 = null;
        var char_literal58 = null;
        var char_literal59 = null;
        var char_literal60 = null;
        var list_variables_1=null;
         var name_0 = null;
         var outpattern_2 = null;
         var actionblock_3 = null;
        var variables_1 = null;
        var set45_tree=null;
        var string_literal46_tree=null;
        var char_literal47_tree=null;
        var char_literal48_tree=null;
        var char_literal49_tree=null;
        var string_literal50_tree=null;
        var char_literal51_tree=null;
        var char_literal52_tree=null;
        var string_literal53_tree=null;
        var string_literal54_tree=null;
        var char_literal55_tree=null;
        var string_literal56_tree=null;
        var char_literal57_tree=null;
        var char_literal58_tree=null;
        var char_literal59_tree=null;
        var char_literal60_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:104:17: ( ( 'entrypoint' | 'endpoint' ) 'rule' name_0= rule_UnrestrictedName ( '(' ')' )? '{' ( 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_2= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_3= rule_ActionBlock '}' )? ( ',' )? '}' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:105:2: ( 'entrypoint' | 'endpoint' ) 'rule' name_0= rule_UnrestrictedName ( '(' ')' )? '{' ( 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_2= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_3= rule_ActionBlock '}' )? ( ',' )? '}'
            root_0 = this.adaptor.nil();

            set45=this.input.LT(1);
            if ( (this.input.LA(1)>=43 && this.input.LA(1)<=44) ) {
                this.input.consume();
                this.adaptor.addChild(root_0, this.adaptor.create(set45));
                this.state.errorRecovery=false;
            }
            else {
                var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                throw mse;
            }

            string_literal46=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_CalledRule453); 
            string_literal46_tree = this.adaptor.create(string_literal46);
            this.adaptor.addChild(root_0, string_literal46_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_CalledRule457);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:106:2: ( '(' ')' )?
            var alt16=2;
            var LA16_0 = this.input.LA(1);

            if ( (LA16_0==45) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:106:3: '(' ')'
                    char_literal47=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_CalledRule461); 
                    char_literal47_tree = this.adaptor.create(char_literal47);
                    this.adaptor.addChild(root_0, char_literal47_tree);

                    char_literal48=this.match(this.input,46,MyAtlParser.FOLLOW_46_in_rule_CalledRule462); 
                    char_literal48_tree = this.adaptor.create(char_literal48);
                    this.adaptor.addChild(root_0, char_literal48_tree);



                    break;

            }

            char_literal49=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_CalledRule466); 
            char_literal49_tree = this.adaptor.create(char_literal49);
            this.adaptor.addChild(root_0, char_literal49_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:107:3: ( 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}' )?
            var alt18=2;
            var LA18_0 = this.input.LA(1);

            if ( (LA18_0==38) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:107:4: 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}'
                    string_literal50=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_CalledRule471); 
                    string_literal50_tree = this.adaptor.create(string_literal50);
                    this.adaptor.addChild(root_0, string_literal50_tree);

                    char_literal51=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_CalledRule473); 
                    char_literal51_tree = this.adaptor.create(char_literal51);
                    this.adaptor.addChild(root_0, char_literal51_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:108:15: (variables_1+= rule_RuleVariableDeclaration )*
                    loop17:
                    do {
                        var alt17=2;
                        var LA17_0 = this.input.LA(1);

                        if ( (LA17_0==SIMPLE_ID) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:108:15: variables_1+= rule_RuleVariableDeclaration
                            this.pushFollow(MyAtlParser.FOLLOW_rule_RuleVariableDeclaration_in_rule_CalledRule481);
                            variables_1=this.rule_RuleVariableDeclaration();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, variables_1.getTree());
                            if (org.antlr.lang.isNull(list_variables_1)) list_variables_1 = [];
                            list_variables_1.push(variables_1.getTree());



                            break;

                        default :
                            break loop17;
                        }
                    } while (true);

                    char_literal52=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_CalledRule486); 
                    char_literal52_tree = this.adaptor.create(char_literal52);
                    this.adaptor.addChild(root_0, char_literal52_tree);



                    break;

            }

            string_literal53=this.match(this.input,40,MyAtlParser.FOLLOW_40_in_rule_CalledRule492); 
            string_literal53_tree = this.adaptor.create(string_literal53);
            this.adaptor.addChild(root_0, string_literal53_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_OutPattern_in_rule_CalledRule498);
            outpattern_2=this.rule_OutPattern();

            this.state._fsp--;

            this.adaptor.addChild(root_0, outpattern_2.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:111:32: ( '...' )?
            var alt19=2;
            var LA19_0 = this.input.LA(1);

            if ( (LA19_0==41) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:111:33: '...'
                    string_literal54=this.match(this.input,41,MyAtlParser.FOLLOW_41_in_rule_CalledRule501); 
                    string_literal54_tree = this.adaptor.create(string_literal54);
                    this.adaptor.addChild(root_0, string_literal54_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:111:41: ( ',' )?
            var alt20=2;
            var LA20_0 = this.input.LA(1);

            if ( (LA20_0==17) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:111:42: ','
                    char_literal55=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_CalledRule506); 
                    char_literal55_tree = this.adaptor.create(char_literal55);
                    this.adaptor.addChild(root_0, char_literal55_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:112:3: ( 'do' '{' actionblock_3= rule_ActionBlock '}' )?
            var alt21=2;
            var LA21_0 = this.input.LA(1);

            if ( (LA21_0==42) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:112:4: 'do' '{' actionblock_3= rule_ActionBlock '}'
                    string_literal56=this.match(this.input,42,MyAtlParser.FOLLOW_42_in_rule_CalledRule513); 
                    string_literal56_tree = this.adaptor.create(string_literal56);
                    this.adaptor.addChild(root_0, string_literal56_tree);

                    char_literal57=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_CalledRule515); 
                    char_literal57_tree = this.adaptor.create(char_literal57);
                    this.adaptor.addChild(root_0, char_literal57_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ActionBlock_in_rule_CalledRule522);
                    actionblock_3=this.rule_ActionBlock();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, actionblock_3.getTree());
                    char_literal58=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_CalledRule526); 
                    char_literal58_tree = this.adaptor.create(char_literal58);
                    this.adaptor.addChild(root_0, char_literal58_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:116:3: ( ',' )?
            var alt22=2;
            var LA22_0 = this.input.LA(1);

            if ( (LA22_0==17) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:116:4: ','
                    char_literal59=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_CalledRule536); 
                    char_literal59_tree = this.adaptor.create(char_literal59);
                    this.adaptor.addChild(root_0, char_literal59_tree);



                    break;

            }

            char_literal60=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_CalledRule539); 
            char_literal60_tree = this.adaptor.create(char_literal60);
            this.adaptor.addChild(root_0, char_literal60_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_QueryRule_return: (function() {
        MyAtlParser.rule_QueryRule_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_QueryRule_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:121:1: rule_QueryRule : 'query' name_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? '=' initexpression_3= rule_ExpCS ';' ;
    // $ANTLR start "rule_QueryRule"
    rule_QueryRule: function() {
        var retval = new MyAtlParser.rule_QueryRule_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal61 = null;
        var char_literal62 = null;
        var char_literal63 = null;
        var char_literal64 = null;
        var char_literal65 = null;
        var char_literal66 = null;
        var list_parameters_1=null;
        var list_parameters_2=null;
         var name_0 = null;
         var initexpression_3 = null;
        var parameters_1 = null;
        var parameters_2 = null;
        var string_literal61_tree=null;
        var char_literal62_tree=null;
        var char_literal63_tree=null;
        var char_literal64_tree=null;
        var char_literal65_tree=null;
        var char_literal66_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:121:16: ( 'query' name_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? '=' initexpression_3= rule_ExpCS ';' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:122:2: 'query' name_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? '=' initexpression_3= rule_ExpCS ';'
            root_0 = this.adaptor.nil();

            string_literal61=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_QueryRule551); 
            string_literal61_tree = this.adaptor.create(string_literal61);
            this.adaptor.addChild(root_0, string_literal61_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_QueryRule556);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:123:2: ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )?
            var alt25=2;
            var LA25_0 = this.input.LA(1);

            if ( (LA25_0==45) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:123:3: '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')'
                    char_literal62=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_QueryRule561); 
                    char_literal62_tree = this.adaptor.create(char_literal62);
                    this.adaptor.addChild(root_0, char_literal62_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:124:2: (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )?
                    var alt24=2;
                    var LA24_0 = this.input.LA(1);

                    if ( (LA24_0==SIMPLE_ID) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:124:3: parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLParameterCS_in_rule_QueryRule567);
                            parameters_1=this.rule_ATLParameterCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, parameters_1.getTree());
                            if (org.antlr.lang.isNull(list_parameters_1)) list_parameters_1 = [];
                            list_parameters_1.push(parameters_1.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:124:37: ( ',' parameters_2+= rule_ATLParameterCS )*
                            loop23:
                            do {
                                var alt23=2;
                                var LA23_0 = this.input.LA(1);

                                if ( (LA23_0==17) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:124:38: ',' parameters_2+= rule_ATLParameterCS
                                    char_literal63=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_QueryRule570); 
                                    char_literal63_tree = this.adaptor.create(char_literal63);
                                    this.adaptor.addChild(root_0, char_literal63_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_ATLParameterCS_in_rule_QueryRule576);
                                    parameters_2=this.rule_ATLParameterCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, parameters_2.getTree());
                                    if (org.antlr.lang.isNull(list_parameters_2)) list_parameters_2 = [];
                                    list_parameters_2.push(parameters_2.getTree());



                                    break;

                                default :
                                    break loop23;
                                }
                            } while (true);



                            break;

                    }

                    char_literal64=this.match(this.input,46,MyAtlParser.FOLLOW_46_in_rule_QueryRule583); 
                    char_literal64_tree = this.adaptor.create(char_literal64);
                    this.adaptor.addChild(root_0, char_literal64_tree);



                    break;

            }

            char_literal65=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_QueryRule590); 
            char_literal65_tree = this.adaptor.create(char_literal65);
            this.adaptor.addChild(root_0, char_literal65_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_QueryRule594);
            initexpression_3=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, initexpression_3.getTree());
            char_literal66=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_QueryRule596); 
            char_literal66_tree = this.adaptor.create(char_literal66);
            this.adaptor.addChild(root_0, char_literal66_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_Helper_return: (function() {
        MyAtlParser.rule_Helper_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_Helper_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:144:1: rule_Helper : 'helper' ( 'context' )? (name_0= rule_UnrestrictedName )? definition_1= rule_ATLDefCS ;
    // $ANTLR start "rule_Helper"
    rule_Helper: function() {
        var retval = new MyAtlParser.rule_Helper_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal67 = null;
        var string_literal68 = null;
         var name_0 = null;
         var definition_1 = null;

        var string_literal67_tree=null;
        var string_literal68_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:144:13: ( 'helper' ( 'context' )? (name_0= rule_UnrestrictedName )? definition_1= rule_ATLDefCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:145:2: 'helper' ( 'context' )? (name_0= rule_UnrestrictedName )? definition_1= rule_ATLDefCS
            root_0 = this.adaptor.nil();

            string_literal67=this.match(this.input,49,MyAtlParser.FOLLOW_49_in_rule_Helper615); 
            string_literal67_tree = this.adaptor.create(string_literal67);
            this.adaptor.addChild(root_0, string_literal67_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:145:12: ( 'context' )?
            var alt26=2;
            var LA26_0 = this.input.LA(1);

            if ( (LA26_0==50) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:145:13: 'context'
                    string_literal68=this.match(this.input,50,MyAtlParser.FOLLOW_50_in_rule_Helper619); 
                    string_literal68_tree = this.adaptor.create(string_literal68);
                    this.adaptor.addChild(root_0, string_literal68_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:145:25: (name_0= rule_UnrestrictedName )?
            var alt27=2;
            var LA27_0 = this.input.LA(1);

            if ( (LA27_0==SIMPLE_ID) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:145:26: name_0= rule_UnrestrictedName
                    this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_Helper626);
                    name_0=this.rule_UnrestrictedName();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, name_0.getTree());


                    break;

            }

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLDefCS_in_rule_Helper635);
            definition_1=this.rule_ATLDefCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, definition_1.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_ATLDefCS_return: (function() {
        MyAtlParser.rule_ATLDefCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_ATLDefCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:168:1: rule_ATLDefCS : 'def' ':' varname_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? ':' type_3= rule_ATLType '=' initexpression_4= rule_ExpCS ';' ;
    // $ANTLR start "rule_ATLDefCS"
    rule_ATLDefCS: function() {
        var retval = new MyAtlParser.rule_ATLDefCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal69 = null;
        var char_literal70 = null;
        var char_literal71 = null;
        var char_literal72 = null;
        var char_literal73 = null;
        var char_literal74 = null;
        var char_literal75 = null;
        var char_literal76 = null;
        var list_parameters_1=null;
        var list_parameters_2=null;
         var varname_0 = null;
         var type_3 = null;
         var initexpression_4 = null;
        var parameters_1 = null;
        var parameters_2 = null;
        var string_literal69_tree=null;
        var char_literal70_tree=null;
        var char_literal71_tree=null;
        var char_literal72_tree=null;
        var char_literal73_tree=null;
        var char_literal74_tree=null;
        var char_literal75_tree=null;
        var char_literal76_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:168:14: ( 'def' ':' varname_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? ':' type_3= rule_ATLType '=' initexpression_4= rule_ExpCS ';' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:170:2: 'def' ':' varname_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? ':' type_3= rule_ATLType '=' initexpression_4= rule_ExpCS ';'
            root_0 = this.adaptor.nil();

            string_literal69=this.match(this.input,51,MyAtlParser.FOLLOW_51_in_rule_ATLDefCS656); 
            string_literal69_tree = this.adaptor.create(string_literal69);
            this.adaptor.addChild(root_0, string_literal69_tree);

            char_literal70=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_ATLDefCS658); 
            char_literal70_tree = this.adaptor.create(char_literal70);
            this.adaptor.addChild(root_0, char_literal70_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_ATLDefCS662);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:171:2: ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )?
            var alt30=2;
            var LA30_0 = this.input.LA(1);

            if ( (LA30_0==45) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:171:3: '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')'
                    char_literal71=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_ATLDefCS666); 
                    char_literal71_tree = this.adaptor.create(char_literal71);
                    this.adaptor.addChild(root_0, char_literal71_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:172:2: (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )?
                    var alt29=2;
                    var LA29_0 = this.input.LA(1);

                    if ( (LA29_0==SIMPLE_ID) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:172:3: parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLParameterCS_in_rule_ATLDefCS672);
                            parameters_1=this.rule_ATLParameterCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, parameters_1.getTree());
                            if (org.antlr.lang.isNull(list_parameters_1)) list_parameters_1 = [];
                            list_parameters_1.push(parameters_1.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:172:37: ( ',' parameters_2+= rule_ATLParameterCS )*
                            loop28:
                            do {
                                var alt28=2;
                                var LA28_0 = this.input.LA(1);

                                if ( (LA28_0==17) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:172:38: ',' parameters_2+= rule_ATLParameterCS
                                    char_literal72=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_ATLDefCS675); 
                                    char_literal72_tree = this.adaptor.create(char_literal72);
                                    this.adaptor.addChild(root_0, char_literal72_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_ATLParameterCS_in_rule_ATLDefCS681);
                                    parameters_2=this.rule_ATLParameterCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, parameters_2.getTree());
                                    if (org.antlr.lang.isNull(list_parameters_2)) list_parameters_2 = [];
                                    list_parameters_2.push(parameters_2.getTree());



                                    break;

                                default :
                                    break loop28;
                                }
                            } while (true);



                            break;

                    }

                    char_literal73=this.match(this.input,46,MyAtlParser.FOLLOW_46_in_rule_ATLDefCS688); 
                    char_literal73_tree = this.adaptor.create(char_literal73);
                    this.adaptor.addChild(root_0, char_literal73_tree);



                    break;

            }

            char_literal74=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_ATLDefCS693); 
            char_literal74_tree = this.adaptor.create(char_literal74);
            this.adaptor.addChild(root_0, char_literal74_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_ATLDefCS697);
            type_3=this.rule_ATLType();

            this.state._fsp--;

            this.adaptor.addChild(root_0, type_3.getTree());
            char_literal75=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_ATLDefCS700); 
            char_literal75_tree = this.adaptor.create(char_literal75);
            this.adaptor.addChild(root_0, char_literal75_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_ATLDefCS704);
            initexpression_4=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, initexpression_4.getTree());
            char_literal76=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_ATLDefCS706); 
            char_literal76_tree = this.adaptor.create(char_literal76);
            this.adaptor.addChild(root_0, char_literal76_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_ATLParameterCS_return: (function() {
        MyAtlParser.rule_ATLParameterCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_ATLParameterCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:185:1: rule_ATLParameterCS : varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ;
    // $ANTLR start "rule_ATLParameterCS"
    rule_ATLParameterCS: function() {
        var retval = new MyAtlParser.rule_ATLParameterCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal77 = null;
         var varname_0 = null;
         var type_1 = null;

        var char_literal77_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:185:20: (varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:187:2: varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_ATLParameterCS724);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            char_literal77=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_ATLParameterCS726); 
            char_literal77_tree = this.adaptor.create(char_literal77);
            this.adaptor.addChild(root_0, char_literal77_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_ATLParameterCS730);
            type_1=this.rule_ATLType();

            this.state._fsp--;

            this.adaptor.addChild(root_0, type_1.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_RuleVariableDeclaration_return: (function() {
        MyAtlParser.rule_RuleVariableDeclaration_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_RuleVariableDeclaration_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:195:1: rule_RuleVariableDeclaration : varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType '=' initexpression_2= rule_ExpCS ';' ;
    // $ANTLR start "rule_RuleVariableDeclaration"
    rule_RuleVariableDeclaration: function() {
        var retval = new MyAtlParser.rule_RuleVariableDeclaration_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal78 = null;
        var char_literal79 = null;
        var char_literal80 = null;
         var varname_0 = null;
         var type_1 = null;
         var initexpression_2 = null;

        var char_literal78_tree=null;
        var char_literal79_tree=null;
        var char_literal80_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:195:29: (varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType '=' initexpression_2= rule_ExpCS ';' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:196:3: varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType '=' initexpression_2= rule_ExpCS ';'
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_RuleVariableDeclaration747);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            char_literal78=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_RuleVariableDeclaration749); 
            char_literal78_tree = this.adaptor.create(char_literal78);
            this.adaptor.addChild(root_0, char_literal78_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_RuleVariableDeclaration753);
            type_1=this.rule_ATLType();

            this.state._fsp--;

            this.adaptor.addChild(root_0, type_1.getTree());
            char_literal79=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_RuleVariableDeclaration758); 
            char_literal79_tree = this.adaptor.create(char_literal79);
            this.adaptor.addChild(root_0, char_literal79_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_RuleVariableDeclaration762);
            initexpression_2=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, initexpression_2.getTree());
            char_literal80=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_RuleVariableDeclaration764); 
            char_literal80_tree = this.adaptor.create(char_literal80);
            this.adaptor.addChild(root_0, char_literal80_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_InPattern_return: (function() {
        MyAtlParser.rule_InPattern_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_InPattern_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:205:1: rule_InPattern : elements_0+= rule_InPatternElement ( '(' (filter_1= rule_ExpCS )? ')' )? ;
    // $ANTLR start "rule_InPattern"
    rule_InPattern: function() {
        var retval = new MyAtlParser.rule_InPattern_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal81 = null;
        var char_literal82 = null;
        var list_elements_0=null;
         var filter_1 = null;
        var elements_0 = null;
        var char_literal81_tree=null;
        var char_literal82_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:205:15: (elements_0+= rule_InPatternElement ( '(' (filter_1= rule_ExpCS )? ')' )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:206:2: elements_0+= rule_InPatternElement ( '(' (filter_1= rule_ExpCS )? ')' )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_InPatternElement_in_rule_InPattern780);
            elements_0=this.rule_InPatternElement();

            this.state._fsp--;

            this.adaptor.addChild(root_0, elements_0.getTree());
            if (org.antlr.lang.isNull(list_elements_0)) list_elements_0 = [];
            list_elements_0.push(elements_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:206:36: ( '(' (filter_1= rule_ExpCS )? ')' )?
            var alt32=2;
            var LA32_0 = this.input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:206:37: '(' (filter_1= rule_ExpCS )? ')'
                    char_literal81=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_InPattern783); 
                    char_literal81_tree = this.adaptor.create(char_literal81);
                    this.adaptor.addChild(root_0, char_literal81_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:207:10: (filter_1= rule_ExpCS )?
                    var alt31=2;
                    var LA31_0 = this.input.LA(1);

                    if ( ((LA31_0>=SIMPLE_ID && LA31_0<=BIG_INT)||LA31_0==21||LA31_0==41||LA31_0==45||LA31_0==60||(LA31_0>=63 && LA31_0<=64)||(LA31_0>=68 && LA31_0<=69)||LA31_0==78||(LA31_0>=80 && LA31_0<=82)||LA31_0==85) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:207:10: filter_1= rule_ExpCS
                            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_InPattern788);
                            filter_1=this.rule_ExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, filter_1.getTree());


                            break;

                    }

                    char_literal82=this.match(this.input,46,MyAtlParser.FOLLOW_46_in_rule_InPattern792); 
                    char_literal82_tree = this.adaptor.create(char_literal82);
                    this.adaptor.addChild(root_0, char_literal82_tree);



                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_InPatternElement_return: (function() {
        MyAtlParser.rule_InPatternElement_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_InPatternElement_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:215:1: rule_InPatternElement : varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ;
    // $ANTLR start "rule_InPatternElement"
    rule_InPatternElement: function() {
        var retval = new MyAtlParser.rule_InPatternElement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal83 = null;
         var varname_0 = null;
         var type_1 = null;

        var char_literal83_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:215:24: (varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:216:2: varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_InPatternElement811);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            char_literal83=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_InPatternElement813); 
            char_literal83_tree = this.adaptor.create(char_literal83);
            this.adaptor.addChild(root_0, char_literal83_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_InPatternElement817);
            type_1=this.rule_ATLType();

            this.state._fsp--;

            this.adaptor.addChild(root_0, type_1.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_OutPattern_return: (function() {
        MyAtlParser.rule_OutPattern_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_OutPattern_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:223:1: rule_OutPattern : elements_0+= rule_OutPatternElement ( ',' elements_1+= rule_OutPatternElement )* ;
    // $ANTLR start "rule_OutPattern"
    rule_OutPattern: function() {
        var retval = new MyAtlParser.rule_OutPattern_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal84 = null;
        var list_elements_0=null;
        var list_elements_1=null;
        var elements_0 = null;
        var elements_1 = null;
        var char_literal84_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:223:16: (elements_0+= rule_OutPatternElement ( ',' elements_1+= rule_OutPatternElement )* )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:224:2: elements_0+= rule_OutPatternElement ( ',' elements_1+= rule_OutPatternElement )*
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_OutPatternElement_in_rule_OutPattern832);
            elements_0=this.rule_OutPatternElement();

            this.state._fsp--;

            this.adaptor.addChild(root_0, elements_0.getTree());
            if (org.antlr.lang.isNull(list_elements_0)) list_elements_0 = [];
            list_elements_0.push(elements_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:224:37: ( ',' elements_1+= rule_OutPatternElement )*
            loop33:
            do {
                var alt33=2;
                var LA33_0 = this.input.LA(1);

                if ( (LA33_0==17) ) {
                    var LA33_2 = this.input.LA(2);

                    if ( (LA33_2==SIMPLE_ID||LA33_2==52) ) {
                        alt33=1;
                    }


                }


                switch (alt33) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:224:38: ',' elements_1+= rule_OutPatternElement
                    char_literal84=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_OutPattern835); 
                    char_literal84_tree = this.adaptor.create(char_literal84);
                    this.adaptor.addChild(root_0, char_literal84_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_OutPatternElement_in_rule_OutPattern841);
                    elements_1=this.rule_OutPatternElement();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, elements_1.getTree());
                    if (org.antlr.lang.isNull(list_elements_1)) list_elements_1 = [];
                    list_elements_1.push(elements_1.getTree());



                    break;

                default :
                    break loop33;
                }
            } while (true);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_OutPatternElement_return: (function() {
        MyAtlParser.rule_OutPatternElement_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_OutPatternElement_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:232:1: rule_OutPatternElement : ( rule_SimpleOutPatternElement | rule_ForEachOutPatternElement );
    // $ANTLR start "rule_OutPatternElement"
    rule_OutPatternElement: function() {
        var retval = new MyAtlParser.rule_OutPatternElement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_SimpleOutPatternElement85 = null;
         var rule_ForEachOutPatternElement86 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:232:23: ( rule_SimpleOutPatternElement | rule_ForEachOutPatternElement )
            var alt34=2;
            var LA34_0 = this.input.LA(1);

            if ( (LA34_0==SIMPLE_ID) ) {
                alt34=1;
            }
            else if ( (LA34_0==52) ) {
                alt34=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 34, 0, this.input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:233:2: rule_SimpleOutPatternElement
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_SimpleOutPatternElement_in_rule_OutPatternElement856);
                    rule_SimpleOutPatternElement85=this.rule_SimpleOutPatternElement();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_SimpleOutPatternElement85.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:233:33: rule_ForEachOutPatternElement
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ForEachOutPatternElement_in_rule_OutPatternElement860);
                    rule_ForEachOutPatternElement86=this.rule_ForEachOutPatternElement();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_ForEachOutPatternElement86.getTree());


                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_SimpleOutPatternElement_return: (function() {
        MyAtlParser.rule_SimpleOutPatternElement_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_SimpleOutPatternElement_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:239:1: rule_SimpleOutPatternElement : varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ( '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')' )? ;
    // $ANTLR start "rule_SimpleOutPatternElement"
    rule_SimpleOutPatternElement: function() {
        var retval = new MyAtlParser.rule_SimpleOutPatternElement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal87 = null;
        var char_literal88 = null;
        var char_literal89 = null;
        var char_literal90 = null;
        var list_bindings_2=null;
        var list_bindings_3=null;
         var varname_0 = null;
         var type_1 = null;
        var bindings_2 = null;
        var bindings_3 = null;
        var char_literal87_tree=null;
        var char_literal88_tree=null;
        var char_literal89_tree=null;
        var char_literal90_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:239:30: (varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ( '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')' )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:240:2: varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ( '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')' )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_SimpleOutPatternElement875);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            char_literal87=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_SimpleOutPatternElement877); 
            char_literal87_tree = this.adaptor.create(char_literal87);
            this.adaptor.addChild(root_0, char_literal87_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_SimpleOutPatternElement881);
            type_1=this.rule_ATLType();

            this.state._fsp--;

            this.adaptor.addChild(root_0, type_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:241:2: ( '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')' )?
            var alt37=2;
            var LA37_0 = this.input.LA(1);

            if ( (LA37_0==45) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:241:3: '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')'
                    char_literal88=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_SimpleOutPatternElement885); 
                    char_literal88_tree = this.adaptor.create(char_literal88);
                    this.adaptor.addChild(root_0, char_literal88_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:242:3: (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )?
                    var alt36=2;
                    var LA36_0 = this.input.LA(1);

                    if ( (LA36_0==SIMPLE_ID) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:242:4: bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_Binding_in_rule_SimpleOutPatternElement892);
                            bindings_2=this.rule_Binding();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, bindings_2.getTree());
                            if (org.antlr.lang.isNull(list_bindings_2)) list_bindings_2 = [];
                            list_bindings_2.push(bindings_2.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:242:29: ( ',' bindings_3+= rule_Binding )*
                            loop35:
                            do {
                                var alt35=2;
                                var LA35_0 = this.input.LA(1);

                                if ( (LA35_0==17) ) {
                                    alt35=1;
                                }


                                switch (alt35) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:242:30: ',' bindings_3+= rule_Binding
                                    char_literal89=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_SimpleOutPatternElement895); 
                                    char_literal89_tree = this.adaptor.create(char_literal89);
                                    this.adaptor.addChild(root_0, char_literal89_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_Binding_in_rule_SimpleOutPatternElement899);
                                    bindings_3=this.rule_Binding();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, bindings_3.getTree());
                                    if (org.antlr.lang.isNull(list_bindings_3)) list_bindings_3 = [];
                                    list_bindings_3.push(bindings_3.getTree());



                                    break;

                                default :
                                    break loop35;
                                }
                            } while (true);



                            break;

                    }

                    char_literal90=this.match(this.input,46,MyAtlParser.FOLLOW_46_in_rule_SimpleOutPatternElement906); 
                    char_literal90_tree = this.adaptor.create(char_literal90);
                    this.adaptor.addChild(root_0, char_literal90_tree);



                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_ForEachOutPatternElement_return: (function() {
        MyAtlParser.rule_ForEachOutPatternElement_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_ForEachOutPatternElement_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:250:1: rule_ForEachOutPatternElement : 'xxx' collection_0= rule_ExpCS 'yyy' ;
    // $ANTLR start "rule_ForEachOutPatternElement"
    rule_ForEachOutPatternElement: function() {
        var retval = new MyAtlParser.rule_ForEachOutPatternElement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal91 = null;
        var string_literal92 = null;
         var collection_0 = null;

        var string_literal91_tree=null;
        var string_literal92_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:250:30: ( 'xxx' collection_0= rule_ExpCS 'yyy' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:251:2: 'xxx' collection_0= rule_ExpCS 'yyy'
            root_0 = this.adaptor.nil();

            string_literal91=this.match(this.input,52,MyAtlParser.FOLLOW_52_in_rule_ForEachOutPatternElement921); 
            string_literal91_tree = this.adaptor.create(string_literal91);
            this.adaptor.addChild(root_0, string_literal91_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_ForEachOutPatternElement928);
            collection_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, collection_0.getTree());
            string_literal92=this.match(this.input,53,MyAtlParser.FOLLOW_53_in_rule_ForEachOutPatternElement931); 
            string_literal92_tree = this.adaptor.create(string_literal92);
            this.adaptor.addChild(root_0, string_literal92_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_Binding_return: (function() {
        MyAtlParser.rule_Binding_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_Binding_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:258:1: rule_Binding : propertyname_0= rule_UnrestrictedName '<-' value_1= rule_ExpCS ;
    // $ANTLR start "rule_Binding"
    rule_Binding: function() {
        var retval = new MyAtlParser.rule_Binding_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal93 = null;
         var propertyname_0 = null;
         var value_1 = null;

        var string_literal93_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:258:13: (propertyname_0= rule_UnrestrictedName '<-' value_1= rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:259:2: propertyname_0= rule_UnrestrictedName '<-' value_1= rule_ExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_Binding944);
            propertyname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, propertyname_0.getTree());
            string_literal93=this.match(this.input,54,MyAtlParser.FOLLOW_54_in_rule_Binding946); 
            string_literal93_tree = this.adaptor.create(string_literal93);
            this.adaptor.addChild(root_0, string_literal93_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_Binding950);
            value_1=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, value_1.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_ActionBlock_return: (function() {
        MyAtlParser.rule_ActionBlock_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_ActionBlock_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:267:1: rule_ActionBlock : (statements_0+= rule_Statement )+ ;
    // $ANTLR start "rule_ActionBlock"
    rule_ActionBlock: function() {
        var retval = new MyAtlParser.rule_ActionBlock_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var list_statements_0=null;
        var statements_0 = null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:267:17: ( (statements_0+= rule_Statement )+ )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:268:2: (statements_0+= rule_Statement )+
            root_0 = this.adaptor.nil();

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:268:14: (statements_0+= rule_Statement )+
            var cnt38=0;
            loop38:
            do {
                var alt38=2;
                var LA38_0 = this.input.LA(1);

                if ( ((LA38_0>=SIMPLE_ID && LA38_0<=BIG_INT)||LA38_0==21||LA38_0==41||LA38_0==45||LA38_0==60||(LA38_0>=63 && LA38_0<=64)||(LA38_0>=68 && LA38_0<=69)||LA38_0==78||(LA38_0>=80 && LA38_0<=82)||LA38_0==85) ) {
                    alt38=1;
                }


                switch (alt38) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:268:14: statements_0+= rule_Statement
                    this.pushFollow(MyAtlParser.FOLLOW_rule_Statement_in_rule_ActionBlock966);
                    statements_0=this.rule_Statement();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, statements_0.getTree());
                    if (org.antlr.lang.isNull(list_statements_0)) list_statements_0 = [];
                    list_statements_0.push(statements_0.getTree());



                    break;

                default :
                    if ( cnt38 >= 1 ) {
                        break loop38;
                    }
                        var eee = new org.antlr.runtime.EarlyExitException(38, this.input);
                        throw eee;
                }
                cnt38++;
            } while (true);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_Statement_return: (function() {
        MyAtlParser.rule_Statement_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_Statement_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:275:1: rule_Statement : rule_BindingStat ;
    // $ANTLR start "rule_Statement"
    rule_Statement: function() {
        var retval = new MyAtlParser.rule_Statement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_BindingStat94 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:275:15: ( rule_BindingStat )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:276:2: rule_BindingStat
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_BindingStat_in_rule_Statement980);
            rule_BindingStat94=this.rule_BindingStat();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_BindingStat94.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_BindingStat_return: (function() {
        MyAtlParser.rule_BindingStat_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_BindingStat_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:283:1: rule_BindingStat : source_0= rule_ExpCS '.' propertyname_1= rule_UnrestrictedName '<-' value_2= rule_ExpCS ';' ;
    // $ANTLR start "rule_BindingStat"
    rule_BindingStat: function() {
        var retval = new MyAtlParser.rule_BindingStat_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal95 = null;
        var string_literal96 = null;
        var char_literal97 = null;
         var source_0 = null;
         var propertyname_1 = null;
         var value_2 = null;

        var char_literal95_tree=null;
        var string_literal96_tree=null;
        var char_literal97_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:283:17: (source_0= rule_ExpCS '.' propertyname_1= rule_UnrestrictedName '<-' value_2= rule_ExpCS ';' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:284:2: source_0= rule_ExpCS '.' propertyname_1= rule_UnrestrictedName '<-' value_2= rule_ExpCS ';'
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_BindingStat995);
            source_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, source_0.getTree());
            char_literal95=this.match(this.input,55,MyAtlParser.FOLLOW_55_in_rule_BindingStat997); 
            char_literal95_tree = this.adaptor.create(char_literal95);
            this.adaptor.addChild(root_0, char_literal95_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_BindingStat1003);
            propertyname_1=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, propertyname_1.getTree());
            string_literal96=this.match(this.input,54,MyAtlParser.FOLLOW_54_in_rule_BindingStat1005); 
            string_literal96_tree = this.adaptor.create(string_literal96);
            this.adaptor.addChild(root_0, string_literal96_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_BindingStat1010);
            value_2=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, value_2.getTree());
            char_literal97=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_BindingStat1012); 
            char_literal97_tree = this.adaptor.create(char_literal97);
            this.adaptor.addChild(root_0, char_literal97_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_ATLType_return: (function() {
        MyAtlParser.rule_ATLType_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_ATLType_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:292:1: rule_ATLType : (modelname_0= rule_ATLModelName '!' )? type_1= rule_TypeExpCS ;
    // $ANTLR start "rule_ATLType"
    rule_ATLType: function() {
        var retval = new MyAtlParser.rule_ATLType_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal98 = null;
         var modelname_0 = null;
         var type_1 = null;

        var char_literal98_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:292:14: ( (modelname_0= rule_ATLModelName '!' )? type_1= rule_TypeExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:293:2: (modelname_0= rule_ATLModelName '!' )? type_1= rule_TypeExpCS
            root_0 = this.adaptor.nil();

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:293:2: (modelname_0= rule_ATLModelName '!' )?
            var alt39=2;
            var LA39_0 = this.input.LA(1);

            if ( (LA39_0==SIMPLE_ID) ) {
                var LA39_1 = this.input.LA(2);

                if ( (LA39_1==56) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:293:3: modelname_0= rule_ATLModelName '!'
                    this.pushFollow(MyAtlParser.FOLLOW_rule_ATLModelName_in_rule_ATLType1030);
                    modelname_0=this.rule_ATLModelName();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, modelname_0.getTree());
                    char_literal98=this.match(this.input,56,MyAtlParser.FOLLOW_56_in_rule_ATLType1032); 
                    char_literal98_tree = this.adaptor.create(char_literal98);
                    this.adaptor.addChild(root_0, char_literal98_tree);



                    break;

            }

            this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_ATLType1040);
            type_1=this.rule_TypeExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, type_1.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_ATLModelName_return: (function() {
        MyAtlParser.rule_ATLModelName_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_ATLModelName_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:300:1: rule_ATLModelName : rule_UnrestrictedName ;
    // $ANTLR start "rule_ATLModelName"
    rule_ATLModelName: function() {
        var retval = new MyAtlParser.rule_ATLModelName_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_UnrestrictedName99 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:300:19: ( rule_UnrestrictedName )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:301:2: rule_UnrestrictedName
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_ATLModelName1054);
            rule_UnrestrictedName99=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_UnrestrictedName99.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_EssentialOCLRersevedKeyword_return: (function() {
        MyAtlParser.rule_EssentialOCLRersevedKeyword_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_EssentialOCLRersevedKeyword_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:307:1: rule_EssentialOCLRersevedKeyword : ( 'and' | 'else' | 'endif' | 'if' | 'implies' | 'in' | 'let' | 'not' | 'or' | 'then' | 'xor' );
    // $ANTLR start "rule_EssentialOCLRersevedKeyword"
    rule_EssentialOCLRersevedKeyword: function() {
        var retval = new MyAtlParser.rule_EssentialOCLRersevedKeyword_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set100 = null;

        var set100_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:307:33: ( 'and' | 'else' | 'endif' | 'if' | 'implies' | 'in' | 'let' | 'not' | 'or' | 'then' | 'xor' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set100=this.input.LT(1);
            if ( (this.input.LA(1)>=57 && this.input.LA(1)<=67) ) {
                this.input.consume();
                this.adaptor.addChild(root_0, this.adaptor.create(set100));
                this.state.errorRecovery=false;
            }
            else {
                var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                throw mse;
            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_EssentialOCLPrefixOperator_return: (function() {
        MyAtlParser.rule_EssentialOCLPrefixOperator_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_EssentialOCLPrefixOperator_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:315:1: rule_EssentialOCLPrefixOperator : ( '-' | 'not' );
    // $ANTLR start "rule_EssentialOCLPrefixOperator"
    rule_EssentialOCLPrefixOperator: function() {
        var retval = new MyAtlParser.rule_EssentialOCLPrefixOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set101 = null;

        var set101_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:315:32: ( '-' | 'not' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set101=this.input.LT(1);
            if ( this.input.LA(1)==64||this.input.LA(1)==68 ) {
                this.input.consume();
                this.adaptor.addChild(root_0, this.adaptor.create(set101));
                this.state.errorRecovery=false;
            }
            else {
                var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                throw mse;
            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_EssentialOCLInfixOperator_return: (function() {
        MyAtlParser.rule_EssentialOCLInfixOperator_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_EssentialOCLInfixOperator_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:323:1: rule_EssentialOCLInfixOperator : ( '*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'or' | 'xor' | 'implies' );
    // $ANTLR start "rule_EssentialOCLInfixOperator"
    rule_EssentialOCLInfixOperator: function() {
        var retval = new MyAtlParser.rule_EssentialOCLInfixOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set102 = null;

        var set102_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:323:31: ( '*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'or' | 'xor' | 'implies' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set102=this.input.LT(1);
            if ( this.input.LA(1)==48||this.input.LA(1)==57||this.input.LA(1)==61||this.input.LA(1)==65||(this.input.LA(1)>=67 && this.input.LA(1)<=76) ) {
                this.input.consume();
                this.adaptor.addChild(root_0, this.adaptor.create(set102));
                this.state.errorRecovery=false;
            }
            else {
                var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                throw mse;
            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_EssentialOCLNavigationOperator_return: (function() {
        MyAtlParser.rule_EssentialOCLNavigationOperator_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_EssentialOCLNavigationOperator_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:331:1: rule_EssentialOCLNavigationOperator : ( '.' | '->' );
    // $ANTLR start "rule_EssentialOCLNavigationOperator"
    rule_EssentialOCLNavigationOperator: function() {
        var retval = new MyAtlParser.rule_EssentialOCLNavigationOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set103 = null;

        var set103_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:331:36: ( '.' | '->' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set103=this.input.LT(1);
            if ( this.input.LA(1)==55||this.input.LA(1)==77 ) {
                this.input.consume();
                this.adaptor.addChild(root_0, this.adaptor.create(set103));
                this.state.errorRecovery=false;
            }
            else {
                var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                throw mse;
            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_StringLiteral_return: (function() {
        MyAtlParser.rule_StringLiteral_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_StringLiteral_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:339:1: rule_StringLiteral : SINGLE_QUOTED_STRING ;
    // $ANTLR start "rule_StringLiteral"
    rule_StringLiteral: function() {
        var retval = new MyAtlParser.rule_StringLiteral_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var SINGLE_QUOTED_STRING104 = null;

        var SINGLE_QUOTED_STRING104_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:339:19: ( SINGLE_QUOTED_STRING )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:340:2: SINGLE_QUOTED_STRING
            root_0 = this.adaptor.nil();

            SINGLE_QUOTED_STRING104=this.match(this.input,SINGLE_QUOTED_STRING,MyAtlParser.FOLLOW_SINGLE_QUOTED_STRING_in_rule_StringLiteral1220); 
            SINGLE_QUOTED_STRING104_tree = this.adaptor.create(SINGLE_QUOTED_STRING104);
            this.adaptor.addChild(root_0, SINGLE_QUOTED_STRING104_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_PrefixOperator_return: (function() {
        MyAtlParser.rule_PrefixOperator_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_PrefixOperator_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:347:1: rule_PrefixOperator : rule_EssentialOCLPrefixOperator ;
    // $ANTLR start "rule_PrefixOperator"
    rule_PrefixOperator: function() {
        var retval = new MyAtlParser.rule_PrefixOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_EssentialOCLPrefixOperator105 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:347:20: ( rule_EssentialOCLPrefixOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:348:2: rule_EssentialOCLPrefixOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_EssentialOCLPrefixOperator_in_rule_PrefixOperator1233);
            rule_EssentialOCLPrefixOperator105=this.rule_EssentialOCLPrefixOperator();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_EssentialOCLPrefixOperator105.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_InfixOperator_return: (function() {
        MyAtlParser.rule_InfixOperator_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_InfixOperator_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:353:1: rule_InfixOperator : rule_EssentialOCLInfixOperator ;
    // $ANTLR start "rule_InfixOperator"
    rule_InfixOperator: function() {
        var retval = new MyAtlParser.rule_InfixOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_EssentialOCLInfixOperator106 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:353:19: ( rule_EssentialOCLInfixOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:354:2: rule_EssentialOCLInfixOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_EssentialOCLInfixOperator_in_rule_InfixOperator1244);
            rule_EssentialOCLInfixOperator106=this.rule_EssentialOCLInfixOperator();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_EssentialOCLInfixOperator106.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NavigationOperator_return: (function() {
        MyAtlParser.rule_NavigationOperator_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NavigationOperator_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:360:1: rule_NavigationOperator : rule_EssentialOCLNavigationOperator ;
    // $ANTLR start "rule_NavigationOperator"
    rule_NavigationOperator: function() {
        var retval = new MyAtlParser.rule_NavigationOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_EssentialOCLNavigationOperator107 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:360:24: ( rule_EssentialOCLNavigationOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:361:2: rule_EssentialOCLNavigationOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_EssentialOCLNavigationOperator_in_rule_NavigationOperator1256);
            rule_EssentialOCLNavigationOperator107=this.rule_EssentialOCLNavigationOperator();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_EssentialOCLNavigationOperator107.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_CollectionTypeCS_return: (function() {
        MyAtlParser.rule_CollectionTypeCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_CollectionTypeCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:368:1: rule_CollectionTypeCS : name_0= rule_CollectionTypeIdentifier ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )? ;
    // $ANTLR start "rule_CollectionTypeCS"
    rule_CollectionTypeCS: function() {
        var retval = new MyAtlParser.rule_CollectionTypeCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set108 = null;
        var set109 = null;
        var char_literal110 = null;
        var char_literal111 = null;
         var name_0 = null;
         var ownedtype_1 = null;
         var ownedtype_2 = null;

        var set108_tree=null;
        var set109_tree=null;
        var char_literal110_tree=null;
        var char_literal111_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:368:23: (name_0= rule_CollectionTypeIdentifier ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:369:2: name_0= rule_CollectionTypeIdentifier ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionTypeIdentifier_in_rule_CollectionTypeCS1272);
            name_0=this.rule_CollectionTypeIdentifier();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:369:39: ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )?
            var alt41=3;
            alt41 = this.dfa41.predict(this.input);
            switch (alt41) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:369:40: ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:369:40: ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:369:41: ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' )
                    set108=this.input.LT(1);
                    if ( this.input.LA(1)==37||this.input.LA(1)==45 ) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set108));
                        this.state.errorRecovery=false;
                    }
                    else {
                        var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                        throw mse;
                    }

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:369:53: (ownedtype_1= rule_TypeExpCS )?
                    var alt40=2;
                    var LA40_0 = this.input.LA(1);

                    if ( (LA40_0==SIMPLE_ID||(LA40_0>=21 && LA40_0<=34)) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:369:54: ownedtype_1= rule_TypeExpCS
                            this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_CollectionTypeCS1287);
                            ownedtype_1=this.rule_TypeExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedtype_1.getTree());


                            break;

                    }

                    set109=this.input.LT(1);
                    if ( this.input.LA(1)==39||this.input.LA(1)==46 ) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set109));
                        this.state.errorRecovery=false;
                    }
                    else {
                        var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                        throw mse;
                    }






                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:5: ( '<' ownedtype_2= rule_TypeExpCS '>' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:5: ( '<' ownedtype_2= rule_TypeExpCS '>' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:6: '<' ownedtype_2= rule_TypeExpCS '>'
                    char_literal110=this.match(this.input,73,MyAtlParser.FOLLOW_73_in_rule_CollectionTypeCS1305); 
                    char_literal110_tree = this.adaptor.create(char_literal110);
                    this.adaptor.addChild(root_0, char_literal110_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_CollectionTypeCS1309);
                    ownedtype_2=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_2.getTree());
                    char_literal111=this.match(this.input,72,MyAtlParser.FOLLOW_72_in_rule_CollectionTypeCS1311); 
                    char_literal111_tree = this.adaptor.create(char_literal111);
                    this.adaptor.addChild(root_0, char_literal111_tree);






                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_TupleTypeCS_return: (function() {
        MyAtlParser.rule_TupleTypeCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_TupleTypeCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:379:1: rule_TupleTypeCS : name_0= 'Tuple' ( ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' ) | ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' ) )? backtrack_5= 'true' ;
    // $ANTLR start "rule_TupleTypeCS"
    rule_TupleTypeCS: function() {
        var retval = new MyAtlParser.rule_TupleTypeCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var name_0 = null;
        var backtrack_5 = null;
        var char_literal112 = null;
        var char_literal113 = null;
        var char_literal114 = null;
        var char_literal115 = null;
        var char_literal116 = null;
        var char_literal117 = null;
        var list_ownedparts_1=null;
        var list_ownedparts_2=null;
        var list_ownedparts_3=null;
        var list_ownedparts_4=null;
        var ownedparts_1 = null;
        var ownedparts_2 = null;
        var ownedparts_3 = null;
        var ownedparts_4 = null;
        var name_0_tree=null;
        var backtrack_5_tree=null;
        var char_literal112_tree=null;
        var char_literal113_tree=null;
        var char_literal114_tree=null;
        var char_literal115_tree=null;
        var char_literal116_tree=null;
        var char_literal117_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:379:17: (name_0= 'Tuple' ( ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' ) | ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' ) )? backtrack_5= 'true' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:380:2: name_0= 'Tuple' ( ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' ) | ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' ) )? backtrack_5= 'true'
            root_0 = this.adaptor.nil();

            name_0=this.match(this.input,21,MyAtlParser.FOLLOW_21_in_rule_TupleTypeCS1335); 
            name_0_tree = this.adaptor.create(name_0);
            this.adaptor.addChild(root_0, name_0_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:381:2: ( ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' ) | ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' ) )?
            var alt46=3;
            var LA46_0 = this.input.LA(1);

            if ( (LA46_0==45) ) {
                alt46=1;
            }
            else if ( (LA46_0==73) ) {
                alt46=2;
            }
            switch (alt46) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:381:3: ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:381:3: ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:381:4: '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')'
                    char_literal112=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_TupleTypeCS1340); 
                    char_literal112_tree = this.adaptor.create(char_literal112);
                    this.adaptor.addChild(root_0, char_literal112_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:381:8: (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )?
                    var alt43=2;
                    var LA43_0 = this.input.LA(1);

                    if ( (LA43_0==SIMPLE_ID) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:381:9: ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1345);
                            ownedparts_1=this.rule_TuplePartCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedparts_1.getTree());
                            if (org.antlr.lang.isNull(list_ownedparts_1)) list_ownedparts_1 = [];
                            list_ownedparts_1.push(ownedparts_1.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:381:40: ( ',' ownedparts_2+= rule_TuplePartCS )*
                            loop42:
                            do {
                                var alt42=2;
                                var LA42_0 = this.input.LA(1);

                                if ( (LA42_0==17) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:381:41: ',' ownedparts_2+= rule_TuplePartCS
                                    char_literal113=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_TupleTypeCS1348); 
                                    char_literal113_tree = this.adaptor.create(char_literal113);
                                    this.adaptor.addChild(root_0, char_literal113_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1352);
                                    ownedparts_2=this.rule_TuplePartCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, ownedparts_2.getTree());
                                    if (org.antlr.lang.isNull(list_ownedparts_2)) list_ownedparts_2 = [];
                                    list_ownedparts_2.push(ownedparts_2.getTree());



                                    break;

                                default :
                                    break loop42;
                                }
                            } while (true);



                            break;

                    }

                    char_literal114=this.match(this.input,46,MyAtlParser.FOLLOW_46_in_rule_TupleTypeCS1358); 
                    char_literal114_tree = this.adaptor.create(char_literal114);
                    this.adaptor.addChild(root_0, char_literal114_tree);






                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:5: ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:5: ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:6: '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>'
                    char_literal115=this.match(this.input,73,MyAtlParser.FOLLOW_73_in_rule_TupleTypeCS1366); 
                    char_literal115_tree = this.adaptor.create(char_literal115);
                    this.adaptor.addChild(root_0, char_literal115_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:10: (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )?
                    var alt45=2;
                    var LA45_0 = this.input.LA(1);

                    if ( (LA45_0==SIMPLE_ID) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:11: ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1371);
                            ownedparts_3=this.rule_TuplePartCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedparts_3.getTree());
                            if (org.antlr.lang.isNull(list_ownedparts_3)) list_ownedparts_3 = [];
                            list_ownedparts_3.push(ownedparts_3.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:42: ( ',' ownedparts_4+= rule_TuplePartCS )*
                            loop44:
                            do {
                                var alt44=2;
                                var LA44_0 = this.input.LA(1);

                                if ( (LA44_0==17) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:43: ',' ownedparts_4+= rule_TuplePartCS
                                    char_literal116=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_TupleTypeCS1374); 
                                    char_literal116_tree = this.adaptor.create(char_literal116);
                                    this.adaptor.addChild(root_0, char_literal116_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1378);
                                    ownedparts_4=this.rule_TuplePartCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, ownedparts_4.getTree());
                                    if (org.antlr.lang.isNull(list_ownedparts_4)) list_ownedparts_4 = [];
                                    list_ownedparts_4.push(ownedparts_4.getTree());



                                    break;

                                default :
                                    break loop44;
                                }
                            } while (true);



                            break;

                    }

                    char_literal117=this.match(this.input,72,MyAtlParser.FOLLOW_72_in_rule_TupleTypeCS1383); 
                    char_literal117_tree = this.adaptor.create(char_literal117);
                    this.adaptor.addChild(root_0, char_literal117_tree);






                    break;

            }

            backtrack_5=this.match(this.input,78,MyAtlParser.FOLLOW_78_in_rule_TupleTypeCS1393); 
            backtrack_5_tree = this.adaptor.create(backtrack_5);
            this.adaptor.addChild(root_0, backtrack_5_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_TuplePartCS_return: (function() {
        MyAtlParser.rule_TuplePartCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_TuplePartCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:390:1: rule_TuplePartCS : name_0= rule_UnrestrictedName ':' ownedtype_1= rule_TypeExpCS ;
    // $ANTLR start "rule_TuplePartCS"
    rule_TuplePartCS: function() {
        var retval = new MyAtlParser.rule_TuplePartCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal118 = null;
         var name_0 = null;
         var ownedtype_1 = null;

        var char_literal118_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:390:17: (name_0= rule_UnrestrictedName ':' ownedtype_1= rule_TypeExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:391:2: name_0= rule_UnrestrictedName ':' ownedtype_1= rule_TypeExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_TuplePartCS1409);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            char_literal118=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_TuplePartCS1411); 
            char_literal118_tree = this.adaptor.create(char_literal118);
            this.adaptor.addChild(root_0, char_literal118_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_TuplePartCS1415);
            ownedtype_1=this.rule_TypeExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, ownedtype_1.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_CollectionLiteralExpCS_return: (function() {
        MyAtlParser.rule_CollectionLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_CollectionLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:398:1: rule_CollectionLiteralExpCS : ownedtype_0= rule_CollectionTypeCS '{' (ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )* )? '}' ;
    // $ANTLR start "rule_CollectionLiteralExpCS"
    rule_CollectionLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_CollectionLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal119 = null;
        var char_literal120 = null;
        var char_literal121 = null;
        var list_ownedparts_1=null;
        var list_ownedparts_2=null;
         var ownedtype_0 = null;
        var ownedparts_1 = null;
        var ownedparts_2 = null;
        var char_literal119_tree=null;
        var char_literal120_tree=null;
        var char_literal121_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:398:28: (ownedtype_0= rule_CollectionTypeCS '{' (ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )* )? '}' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:399:2: ownedtype_0= rule_CollectionTypeCS '{' (ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )* )? '}'
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionTypeCS_in_rule_CollectionLiteralExpCS1430);
            ownedtype_0=this.rule_CollectionTypeCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, ownedtype_0.getTree());
            char_literal119=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_CollectionLiteralExpCS1433); 
            char_literal119_tree = this.adaptor.create(char_literal119);
            this.adaptor.addChild(root_0, char_literal119_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:400:6: (ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )* )?
            var alt48=2;
            var LA48_0 = this.input.LA(1);

            if ( ((LA48_0>=SIMPLE_ID && LA48_0<=BIG_INT)||LA48_0==21||LA48_0==41||LA48_0==45||LA48_0==60||(LA48_0>=63 && LA48_0<=64)||(LA48_0>=68 && LA48_0<=69)||LA48_0==78||(LA48_0>=80 && LA48_0<=82)||LA48_0==85) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:400:7: ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )*
                    this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionLiteralPartCS_in_rule_CollectionLiteralExpCS1438);
                    ownedparts_1=this.rule_CollectionLiteralPartCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedparts_1.getTree());
                    if (org.antlr.lang.isNull(list_ownedparts_1)) list_ownedparts_1 = [];
                    list_ownedparts_1.push(ownedparts_1.getTree());

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:400:50: ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )*
                    loop47:
                    do {
                        var alt47=2;
                        var LA47_0 = this.input.LA(1);

                        if ( (LA47_0==17) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:400:51: ',' ownedparts_2+= rule_CollectionLiteralPartCS
                            char_literal120=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_CollectionLiteralExpCS1441); 
                            char_literal120_tree = this.adaptor.create(char_literal120);
                            this.adaptor.addChild(root_0, char_literal120_tree);

                            this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionLiteralPartCS_in_rule_CollectionLiteralExpCS1445);
                            ownedparts_2=this.rule_CollectionLiteralPartCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedparts_2.getTree());
                            if (org.antlr.lang.isNull(list_ownedparts_2)) list_ownedparts_2 = [];
                            list_ownedparts_2.push(ownedparts_2.getTree());



                            break;

                        default :
                            break loop47;
                        }
                    } while (true);



                    break;

            }

            char_literal121=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_CollectionLiteralExpCS1450); 
            char_literal121_tree = this.adaptor.create(char_literal121);
            this.adaptor.addChild(root_0, char_literal121_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_CollectionLiteralPartCS_return: (function() {
        MyAtlParser.rule_CollectionLiteralPartCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_CollectionLiteralPartCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:407:1: rule_CollectionLiteralPartCS : expressioncs_0= rule_ExpCS ( '..' lastexpressioncs_1= rule_ExpCS )? ;
    // $ANTLR start "rule_CollectionLiteralPartCS"
    rule_CollectionLiteralPartCS: function() {
        var retval = new MyAtlParser.rule_CollectionLiteralPartCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal122 = null;
         var expressioncs_0 = null;
         var lastexpressioncs_1 = null;

        var string_literal122_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:407:29: (expressioncs_0= rule_ExpCS ( '..' lastexpressioncs_1= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:408:2: expressioncs_0= rule_ExpCS ( '..' lastexpressioncs_1= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_CollectionLiteralPartCS1465);
            expressioncs_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, expressioncs_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:408:28: ( '..' lastexpressioncs_1= rule_ExpCS )?
            var alt49=2;
            var LA49_0 = this.input.LA(1);

            if ( (LA49_0==79) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:408:29: '..' lastexpressioncs_1= rule_ExpCS
                    string_literal122=this.match(this.input,79,MyAtlParser.FOLLOW_79_in_rule_CollectionLiteralPartCS1468); 
                    string_literal122_tree = this.adaptor.create(string_literal122);
                    this.adaptor.addChild(root_0, string_literal122_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_CollectionLiteralPartCS1472);
                    lastexpressioncs_1=this.rule_ExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, lastexpressioncs_1.getTree());


                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_PrimitiveLiteralExpCS_return: (function() {
        MyAtlParser.rule_PrimitiveLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_PrimitiveLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:416:1: rule_PrimitiveLiteralExpCS : ( rule_NumberLiteralExpCS | rule_StringLiteralExpCS | rule_BooleanLiteralExpCS | rule_UnlimitedNaturalLiteralExpCS | rule_InvalidLiteralExpCS | rule_NullLiteralExpCS );
    // $ANTLR start "rule_PrimitiveLiteralExpCS"
    rule_PrimitiveLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_PrimitiveLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_NumberLiteralExpCS123 = null;
         var rule_StringLiteralExpCS124 = null;
         var rule_BooleanLiteralExpCS125 = null;
         var rule_UnlimitedNaturalLiteralExpCS126 = null;
         var rule_InvalidLiteralExpCS127 = null;
         var rule_NullLiteralExpCS128 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:416:27: ( rule_NumberLiteralExpCS | rule_StringLiteralExpCS | rule_BooleanLiteralExpCS | rule_UnlimitedNaturalLiteralExpCS | rule_InvalidLiteralExpCS | rule_NullLiteralExpCS )
            var alt50=6;
            switch ( this.input.LA(1) ) {
            case BIG_INT:
                alt50=1;
                break;
            case SINGLE_QUOTED_STRING:
                alt50=2;
                break;
            case 78:
            case 80:
                alt50=3;
                break;
            case 69:
                alt50=4;
                break;
            case 81:
                alt50=5;
                break;
            case 82:
                alt50=6;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 50, 0, this.input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:417:2: rule_NumberLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NumberLiteralExpCS_in_rule_PrimitiveLiteralExpCS1488);
                    rule_NumberLiteralExpCS123=this.rule_NumberLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NumberLiteralExpCS123.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:417:28: rule_StringLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_StringLiteralExpCS_in_rule_PrimitiveLiteralExpCS1492);
                    rule_StringLiteralExpCS124=this.rule_StringLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_StringLiteralExpCS124.getTree());


                    break;
                case 3 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:417:54: rule_BooleanLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_BooleanLiteralExpCS_in_rule_PrimitiveLiteralExpCS1496);
                    rule_BooleanLiteralExpCS125=this.rule_BooleanLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_BooleanLiteralExpCS125.getTree());


                    break;
                case 4 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:418:4: rule_UnlimitedNaturalLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_UnlimitedNaturalLiteralExpCS_in_rule_PrimitiveLiteralExpCS1502);
                    rule_UnlimitedNaturalLiteralExpCS126=this.rule_UnlimitedNaturalLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_UnlimitedNaturalLiteralExpCS126.getTree());


                    break;
                case 5 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:418:40: rule_InvalidLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_InvalidLiteralExpCS_in_rule_PrimitiveLiteralExpCS1506);
                    rule_InvalidLiteralExpCS127=this.rule_InvalidLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_InvalidLiteralExpCS127.getTree());


                    break;
                case 6 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:418:67: rule_NullLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NullLiteralExpCS_in_rule_PrimitiveLiteralExpCS1510);
                    rule_NullLiteralExpCS128=this.rule_NullLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NullLiteralExpCS128.getTree());


                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_TupleLiteralExpCS_return: (function() {
        MyAtlParser.rule_TupleLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_TupleLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:424:1: rule_TupleLiteralExpCS : 'Tuple' '{' ownedparts_0+= rule_TupleLiteralPartCS ( ',' ownedparts_1+= rule_TupleLiteralPartCS )* '}' ;
    // $ANTLR start "rule_TupleLiteralExpCS"
    rule_TupleLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_TupleLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal129 = null;
        var char_literal130 = null;
        var char_literal131 = null;
        var char_literal132 = null;
        var list_ownedparts_0=null;
        var list_ownedparts_1=null;
        var ownedparts_0 = null;
        var ownedparts_1 = null;
        var string_literal129_tree=null;
        var char_literal130_tree=null;
        var char_literal131_tree=null;
        var char_literal132_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:424:23: ( 'Tuple' '{' ownedparts_0+= rule_TupleLiteralPartCS ( ',' ownedparts_1+= rule_TupleLiteralPartCS )* '}' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:425:2: 'Tuple' '{' ownedparts_0+= rule_TupleLiteralPartCS ( ',' ownedparts_1+= rule_TupleLiteralPartCS )* '}'
            root_0 = this.adaptor.nil();

            string_literal129=this.match(this.input,21,MyAtlParser.FOLLOW_21_in_rule_TupleLiteralExpCS1522); 
            string_literal129_tree = this.adaptor.create(string_literal129);
            this.adaptor.addChild(root_0, string_literal129_tree);

            char_literal130=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_TupleLiteralExpCS1524); 
            char_literal130_tree = this.adaptor.create(char_literal130);
            this.adaptor.addChild(root_0, char_literal130_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_TupleLiteralPartCS_in_rule_TupleLiteralExpCS1528);
            ownedparts_0=this.rule_TupleLiteralPartCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, ownedparts_0.getTree());
            if (org.antlr.lang.isNull(list_ownedparts_0)) list_ownedparts_0 = [];
            list_ownedparts_0.push(ownedparts_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:425:52: ( ',' ownedparts_1+= rule_TupleLiteralPartCS )*
            loop51:
            do {
                var alt51=2;
                var LA51_0 = this.input.LA(1);

                if ( (LA51_0==17) ) {
                    alt51=1;
                }


                switch (alt51) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:425:53: ',' ownedparts_1+= rule_TupleLiteralPartCS
                    char_literal131=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_TupleLiteralExpCS1531); 
                    char_literal131_tree = this.adaptor.create(char_literal131);
                    this.adaptor.addChild(root_0, char_literal131_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TupleLiteralPartCS_in_rule_TupleLiteralExpCS1537);
                    ownedparts_1=this.rule_TupleLiteralPartCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedparts_1.getTree());
                    if (org.antlr.lang.isNull(list_ownedparts_1)) list_ownedparts_1 = [];
                    list_ownedparts_1.push(ownedparts_1.getTree());



                    break;

                default :
                    break loop51;
                }
            } while (true);

            char_literal132=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_TupleLiteralExpCS1541); 
            char_literal132_tree = this.adaptor.create(char_literal132);
            this.adaptor.addChild(root_0, char_literal132_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_TupleLiteralPartCS_return: (function() {
        MyAtlParser.rule_TupleLiteralPartCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_TupleLiteralPartCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:432:1: rule_TupleLiteralPartCS : name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS ;
    // $ANTLR start "rule_TupleLiteralPartCS"
    rule_TupleLiteralPartCS: function() {
        var retval = new MyAtlParser.rule_TupleLiteralPartCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal133 = null;
        var char_literal134 = null;
         var name_0 = null;
         var ownedtype_1 = null;
         var initexpression_2 = null;

        var char_literal133_tree=null;
        var char_literal134_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:432:24: (name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:433:2: name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_TupleLiteralPartCS1555);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:433:31: ( ':' ownedtype_1= rule_TypeExpCS )?
            var alt52=2;
            var LA52_0 = this.input.LA(1);

            if ( (LA52_0==16) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:433:32: ':' ownedtype_1= rule_TypeExpCS
                    char_literal133=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_TupleLiteralPartCS1558); 
                    char_literal133_tree = this.adaptor.create(char_literal133);
                    this.adaptor.addChild(root_0, char_literal133_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_TupleLiteralPartCS1562);
                    ownedtype_1=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_1.getTree());


                    break;

            }

            char_literal134=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_TupleLiteralPartCS1566); 
            char_literal134_tree = this.adaptor.create(char_literal134);
            this.adaptor.addChild(root_0, char_literal134_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_TupleLiteralPartCS1571);
            initexpression_2=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, initexpression_2.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NumberLiteralExpCS_return: (function() {
        MyAtlParser.rule_NumberLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NumberLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:439:1: rule_NumberLiteralExpCS : name_0= BIG_INT ;
    // $ANTLR start "rule_NumberLiteralExpCS"
    rule_NumberLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_NumberLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var name_0 = null;

        var name_0_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:439:24: (name_0= BIG_INT )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:440:2: name_0= BIG_INT
            root_0 = this.adaptor.nil();

            name_0=this.match(this.input,BIG_INT,MyAtlParser.FOLLOW_BIG_INT_in_rule_NumberLiteralExpCS1584); 
            name_0_tree = this.adaptor.create(name_0);
            this.adaptor.addChild(root_0, name_0_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_StringLiteralExpCS_return: (function() {
        MyAtlParser.rule_StringLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_StringLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:446:1: rule_StringLiteralExpCS : name_0+= rule_StringLiteral ;
    // $ANTLR start "rule_StringLiteralExpCS"
    rule_StringLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_StringLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var list_name_0=null;
        var name_0 = null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:446:24: (name_0+= rule_StringLiteral )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:447:2: name_0+= rule_StringLiteral
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_StringLiteral_in_rule_StringLiteralExpCS1598);
            name_0=this.rule_StringLiteral();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            if (org.antlr.lang.isNull(list_name_0)) list_name_0 = [];
            list_name_0.push(name_0.getTree());




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_BooleanLiteralExpCS_return: (function() {
        MyAtlParser.rule_BooleanLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_BooleanLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:453:1: rule_BooleanLiteralExpCS : (name_0= 'true' | name_1= 'false' );
    // $ANTLR start "rule_BooleanLiteralExpCS"
    rule_BooleanLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_BooleanLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var name_0 = null;
        var name_1 = null;

        var name_0_tree=null;
        var name_1_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:453:25: (name_0= 'true' | name_1= 'false' )
            var alt53=2;
            var LA53_0 = this.input.LA(1);

            if ( (LA53_0==78) ) {
                alt53=1;
            }
            else if ( (LA53_0==80) ) {
                alt53=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 53, 0, this.input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:454:2: name_0= 'true'
                    root_0 = this.adaptor.nil();

                    name_0=this.match(this.input,78,MyAtlParser.FOLLOW_78_in_rule_BooleanLiteralExpCS1612); 
                    name_0_tree = this.adaptor.create(name_0);
                    this.adaptor.addChild(root_0, name_0_tree);



                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:454:18: name_1= 'false'
                    root_0 = this.adaptor.nil();

                    name_1=this.match(this.input,80,MyAtlParser.FOLLOW_80_in_rule_BooleanLiteralExpCS1618); 
                    name_1_tree = this.adaptor.create(name_1);
                    this.adaptor.addChild(root_0, name_1_tree);



                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_UnlimitedNaturalLiteralExpCS_return: (function() {
        MyAtlParser.rule_UnlimitedNaturalLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_UnlimitedNaturalLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:463:1: rule_UnlimitedNaturalLiteralExpCS : '*' ;
    // $ANTLR start "rule_UnlimitedNaturalLiteralExpCS"
    rule_UnlimitedNaturalLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_UnlimitedNaturalLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal135 = null;

        var char_literal135_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:463:34: ( '*' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:464:3: '*'
            root_0 = this.adaptor.nil();

            char_literal135=this.match(this.input,69,MyAtlParser.FOLLOW_69_in_rule_UnlimitedNaturalLiteralExpCS1634); 
            char_literal135_tree = this.adaptor.create(char_literal135);
            this.adaptor.addChild(root_0, char_literal135_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_InvalidLiteralExpCS_return: (function() {
        MyAtlParser.rule_InvalidLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_InvalidLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:470:1: rule_InvalidLiteralExpCS : 'invalid' ;
    // $ANTLR start "rule_InvalidLiteralExpCS"
    rule_InvalidLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_InvalidLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal136 = null;

        var string_literal136_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:470:25: ( 'invalid' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:471:3: 'invalid'
            root_0 = this.adaptor.nil();

            string_literal136=this.match(this.input,81,MyAtlParser.FOLLOW_81_in_rule_InvalidLiteralExpCS1647); 
            string_literal136_tree = this.adaptor.create(string_literal136);
            this.adaptor.addChild(root_0, string_literal136_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NullLiteralExpCS_return: (function() {
        MyAtlParser.rule_NullLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NullLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:477:1: rule_NullLiteralExpCS : 'null' ;
    // $ANTLR start "rule_NullLiteralExpCS"
    rule_NullLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_NullLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal137 = null;

        var string_literal137_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:477:22: ( 'null' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:478:3: 'null'
            root_0 = this.adaptor.nil();

            string_literal137=this.match(this.input,82,MyAtlParser.FOLLOW_82_in_rule_NullLiteralExpCS1660); 
            string_literal137_tree = this.adaptor.create(string_literal137);
            this.adaptor.addChild(root_0, string_literal137_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_PrimitiveTypeCS_return: (function() {
        MyAtlParser.rule_PrimitiveTypeCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_PrimitiveTypeCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:486:1: rule_PrimitiveTypeCS : name_0= rule_PrimitiveTypeIdentifier ;
    // $ANTLR start "rule_PrimitiveTypeCS"
    rule_PrimitiveTypeCS: function() {
        var retval = new MyAtlParser.rule_PrimitiveTypeCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var name_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:486:21: (name_0= rule_PrimitiveTypeIdentifier )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:487:2: name_0= rule_PrimitiveTypeIdentifier
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_PrimitiveTypeIdentifier_in_rule_PrimitiveTypeCS1676);
            name_0=this.rule_PrimitiveTypeIdentifier();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_TypeLiteralCS_return: (function() {
        MyAtlParser.rule_TypeLiteralCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_TypeLiteralCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:495:1: rule_TypeLiteralCS : ( rule_PrimitiveTypeCS | rule_TupleTypeCS | rule_CollectionTypeCS );
    // $ANTLR start "rule_TypeLiteralCS"
    rule_TypeLiteralCS: function() {
        var retval = new MyAtlParser.rule_TypeLiteralCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_PrimitiveTypeCS138 = null;
         var rule_TupleTypeCS139 = null;
         var rule_CollectionTypeCS140 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:495:19: ( rule_PrimitiveTypeCS | rule_TupleTypeCS | rule_CollectionTypeCS )
            var alt54=3;
            switch ( this.input.LA(1) ) {
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                alt54=1;
                break;
            case 21:
                alt54=2;
                break;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                alt54=3;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 54, 0, this.input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:496:2: rule_PrimitiveTypeCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_PrimitiveTypeCS_in_rule_TypeLiteralCS1690);
                    rule_PrimitiveTypeCS138=this.rule_PrimitiveTypeCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_PrimitiveTypeCS138.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:496:26: rule_TupleTypeCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TupleTypeCS_in_rule_TypeLiteralCS1695);
                    rule_TupleTypeCS139=this.rule_TupleTypeCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_TupleTypeCS139.getTree());


                    break;
                case 3 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:496:45: rule_CollectionTypeCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionTypeCS_in_rule_TypeLiteralCS1699);
                    rule_CollectionTypeCS140=this.rule_CollectionTypeCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_CollectionTypeCS140.getTree());


                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_TypeLiteralExpCS_return: (function() {
        MyAtlParser.rule_TypeLiteralExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_TypeLiteralExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:502:1: rule_TypeLiteralExpCS : ownedtype_0= rule_TypeLiteralCS ;
    // $ANTLR start "rule_TypeLiteralExpCS"
    rule_TypeLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_TypeLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var ownedtype_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:502:22: (ownedtype_0= rule_TypeLiteralCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:503:2: ownedtype_0= rule_TypeLiteralCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_TypeLiteralCS_in_rule_TypeLiteralExpCS1715);
            ownedtype_0=this.rule_TypeLiteralCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, ownedtype_0.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_TypeNameExpCS_return: (function() {
        MyAtlParser.rule_TypeNameExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_TypeNameExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:511:1: rule_TypeNameExpCS : namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )? ;
    // $ANTLR start "rule_TypeNameExpCS"
    rule_TypeNameExpCS: function() {
        var retval = new MyAtlParser.rule_TypeNameExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal141 = null;
        var string_literal142 = null;
        var list_namespace_0=null;
        var list_namespace_1=null;
         var element_2 = null;
         var element_3 = null;
        var namespace_0 = null;
        var namespace_1 = null;
        var string_literal141_tree=null;
        var string_literal142_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:511:19: (namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:512:2: namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_TypeNameExpCS1732);
            namespace_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, namespace_0.getTree());
            if (org.antlr.lang.isNull(list_namespace_0)) list_namespace_0 = [];
            list_namespace_0.push(namespace_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:513:2: ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )?
            var alt57=2;
            var LA57_0 = this.input.LA(1);

            if ( (LA57_0==SIMPLE_ID||LA57_0==83) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:513:3: ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:513:3: ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName )
                    var alt56=2;
                    var LA56_0 = this.input.LA(1);

                    if ( (LA56_0==83) ) {
                        alt56=1;
                    }
                    else if ( (LA56_0==SIMPLE_ID) ) {
                        alt56=2;
                    }
                    else {
                        var nvae =
                            new org.antlr.runtime.NoViableAltException("", 56, 0, this.input);

                        throw nvae;
                    }
                    switch (alt56) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:514:3: ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:514:3: ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:515:4: ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:515:4: ( '::' (namespace_1+= rule_UnreservedName '::' )* )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:515:7: '::' (namespace_1+= rule_UnreservedName '::' )*
                            string_literal141=this.match(this.input,83,MyAtlParser.FOLLOW_83_in_rule_TypeNameExpCS1750); 
                            string_literal141_tree = this.adaptor.create(string_literal141);
                            this.adaptor.addChild(root_0, string_literal141_tree);

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:515:12: (namespace_1+= rule_UnreservedName '::' )*
                            loop55:
                            do {
                                var alt55=2;
                                switch ( this.input.LA(1) ) {
                                case SIMPLE_ID:
                                    var LA55_1 = this.input.LA(2);

                                    if ( (LA55_1==83) ) {
                                        alt55=1;
                                    }


                                    break;
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                    var LA55_2 = this.input.LA(2);

                                    if ( (LA55_2==83) ) {
                                        alt55=1;
                                    }


                                    break;
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                    var LA55_3 = this.input.LA(2);

                                    if ( (LA55_3==83) ) {
                                        alt55=1;
                                    }


                                    break;
                                case 21:
                                    var LA55_4 = this.input.LA(2);

                                    if ( (LA55_4==83) ) {
                                        alt55=1;
                                    }


                                    break;

                                }

                                switch (alt55) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:515:13: namespace_1+= rule_UnreservedName '::'
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_UnreservedName_in_rule_TypeNameExpCS1756);
                                    namespace_1=this.rule_UnreservedName();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, namespace_1.getTree());
                                    if (org.antlr.lang.isNull(list_namespace_1)) list_namespace_1 = [];
                                    list_namespace_1.push(namespace_1.getTree());

                                    string_literal142=this.match(this.input,83,MyAtlParser.FOLLOW_83_in_rule_TypeNameExpCS1758); 
                                    string_literal142_tree = this.adaptor.create(string_literal142);
                                    this.adaptor.addChild(root_0, string_literal142_tree);



                                    break;

                                default :
                                    break loop55;
                                }
                            } while (true);




                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnreservedName_in_rule_TypeNameExpCS1770);
                            element_2=this.rule_UnreservedName();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, element_2.getTree());





                            break;
                        case 2 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:517:4: element_3= rule_UnrestrictedName
                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_TypeNameExpCS1779);
                            element_3=this.rule_UnrestrictedName();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, element_3.getTree());


                            break;

                    }



                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_TypeExpCS_return: (function() {
        MyAtlParser.rule_TypeExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_TypeExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:522:1: rule_TypeExpCS : ( rule_TypeNameExpCS | rule_TypeLiteralCS );
    // $ANTLR start "rule_TypeExpCS"
    rule_TypeExpCS: function() {
        var retval = new MyAtlParser.rule_TypeExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_TypeNameExpCS143 = null;
         var rule_TypeLiteralCS144 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:522:15: ( rule_TypeNameExpCS | rule_TypeLiteralCS )
            var alt58=2;
            var LA58_0 = this.input.LA(1);

            if ( (LA58_0==SIMPLE_ID) ) {
                alt58=1;
            }
            else if ( ((LA58_0>=21 && LA58_0<=34)) ) {
                alt58=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 58, 0, this.input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:523:2: rule_TypeNameExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeNameExpCS_in_rule_TypeExpCS1793);
                    rule_TypeNameExpCS143=this.rule_TypeNameExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_TypeNameExpCS143.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:523:23: rule_TypeLiteralCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeLiteralCS_in_rule_TypeExpCS1797);
                    rule_TypeLiteralCS144=this.rule_TypeLiteralCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_TypeLiteralCS144.getTree());


                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NavigatingArgCS_return: (function() {
        MyAtlParser.rule_NavigatingArgCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NavigatingArgCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:529:1: rule_NavigatingArgCS : name_0= rule_NavigatingArgExpCS ( ':' ownedtype_1= rule_TypeExpCS )? ( '=' init_2= rule_ExpCS )? ;
    // $ANTLR start "rule_NavigatingArgCS"
    rule_NavigatingArgCS: function() {
        var retval = new MyAtlParser.rule_NavigatingArgCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal145 = null;
        var char_literal146 = null;
         var name_0 = null;
         var ownedtype_1 = null;
         var init_2 = null;

        var char_literal145_tree=null;
        var char_literal146_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:529:21: (name_0= rule_NavigatingArgExpCS ( ':' ownedtype_1= rule_TypeExpCS )? ( '=' init_2= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:530:2: name_0= rule_NavigatingArgExpCS ( ':' ownedtype_1= rule_TypeExpCS )? ( '=' init_2= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingArgCS1812);
            name_0=this.rule_NavigatingArgExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:530:33: ( ':' ownedtype_1= rule_TypeExpCS )?
            var alt59=2;
            var LA59_0 = this.input.LA(1);

            if ( (LA59_0==16) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:530:34: ':' ownedtype_1= rule_TypeExpCS
                    char_literal145=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_NavigatingArgCS1815); 
                    char_literal145_tree = this.adaptor.create(char_literal145);
                    this.adaptor.addChild(root_0, char_literal145_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_NavigatingArgCS1819);
                    ownedtype_1=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_1.getTree());


                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:530:67: ( '=' init_2= rule_ExpCS )?
            var alt60=2;
            var LA60_0 = this.input.LA(1);

            if ( (LA60_0==48) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:530:68: '=' init_2= rule_ExpCS
                    char_literal146=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_NavigatingArgCS1824); 
                    char_literal146_tree = this.adaptor.create(char_literal146);
                    this.adaptor.addChild(root_0, char_literal146_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingArgCS1828);
                    init_2=this.rule_ExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, init_2.getTree());


                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NavigatingBarArgCS_return: (function() {
        MyAtlParser.rule_NavigatingBarArgCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NavigatingBarArgCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:536:1: rule_NavigatingBarArgCS : prefix_0= '|' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? ;
    // $ANTLR start "rule_NavigatingBarArgCS"
    rule_NavigatingBarArgCS: function() {
        var retval = new MyAtlParser.rule_NavigatingBarArgCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var prefix_0 = null;
        var char_literal147 = null;
        var char_literal148 = null;
         var name_1 = null;
         var ownedtype_2 = null;
         var init_3 = null;

        var prefix_0_tree=null;
        var char_literal147_tree=null;
        var char_literal148_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:536:24: (prefix_0= '|' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:537:2: prefix_0= '|' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            prefix_0=this.match(this.input,84,MyAtlParser.FOLLOW_84_in_rule_NavigatingBarArgCS1845); 
            prefix_0_tree = this.adaptor.create(prefix_0);
            this.adaptor.addChild(root_0, prefix_0_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingBarArgCS1849);
            name_1=this.rule_NavigatingArgExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:537:46: ( ':' ownedtype_2= rule_TypeExpCS )?
            var alt61=2;
            var LA61_0 = this.input.LA(1);

            if ( (LA61_0==16) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:537:47: ':' ownedtype_2= rule_TypeExpCS
                    char_literal147=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_NavigatingBarArgCS1852); 
                    char_literal147_tree = this.adaptor.create(char_literal147);
                    this.adaptor.addChild(root_0, char_literal147_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_NavigatingBarArgCS1856);
                    ownedtype_2=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_2.getTree());


                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:537:80: ( '=' init_3= rule_ExpCS )?
            var alt62=2;
            var LA62_0 = this.input.LA(1);

            if ( (LA62_0==48) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:537:81: '=' init_3= rule_ExpCS
                    char_literal148=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_NavigatingBarArgCS1861); 
                    char_literal148_tree = this.adaptor.create(char_literal148);
                    this.adaptor.addChild(root_0, char_literal148_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingBarArgCS1865);
                    init_3=this.rule_ExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, init_3.getTree());


                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NavigatingCommaArgCS_return: (function() {
        MyAtlParser.rule_NavigatingCommaArgCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NavigatingCommaArgCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:543:1: rule_NavigatingCommaArgCS : prefix_0= ',' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? ;
    // $ANTLR start "rule_NavigatingCommaArgCS"
    rule_NavigatingCommaArgCS: function() {
        var retval = new MyAtlParser.rule_NavigatingCommaArgCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var prefix_0 = null;
        var char_literal149 = null;
        var char_literal150 = null;
         var name_1 = null;
         var ownedtype_2 = null;
         var init_3 = null;

        var prefix_0_tree=null;
        var char_literal149_tree=null;
        var char_literal150_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:543:26: (prefix_0= ',' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:544:2: prefix_0= ',' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            prefix_0=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_NavigatingCommaArgCS1881); 
            prefix_0_tree = this.adaptor.create(prefix_0);
            this.adaptor.addChild(root_0, prefix_0_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingCommaArgCS1885);
            name_1=this.rule_NavigatingArgExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:544:46: ( ':' ownedtype_2= rule_TypeExpCS )?
            var alt63=2;
            var LA63_0 = this.input.LA(1);

            if ( (LA63_0==16) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:544:47: ':' ownedtype_2= rule_TypeExpCS
                    char_literal149=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_NavigatingCommaArgCS1888); 
                    char_literal149_tree = this.adaptor.create(char_literal149);
                    this.adaptor.addChild(root_0, char_literal149_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_NavigatingCommaArgCS1892);
                    ownedtype_2=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_2.getTree());


                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:544:80: ( '=' init_3= rule_ExpCS )?
            var alt64=2;
            var LA64_0 = this.input.LA(1);

            if ( (LA64_0==48) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:544:81: '=' init_3= rule_ExpCS
                    char_literal150=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_NavigatingCommaArgCS1897); 
                    char_literal150_tree = this.adaptor.create(char_literal150);
                    this.adaptor.addChild(root_0, char_literal150_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingCommaArgCS1901);
                    init_3=this.rule_ExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, init_3.getTree());


                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NavigatingSemiArgCS_return: (function() {
        MyAtlParser.rule_NavigatingSemiArgCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NavigatingSemiArgCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:550:1: rule_NavigatingSemiArgCS : prefix_0= ';' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? ;
    // $ANTLR start "rule_NavigatingSemiArgCS"
    rule_NavigatingSemiArgCS: function() {
        var retval = new MyAtlParser.rule_NavigatingSemiArgCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var prefix_0 = null;
        var char_literal151 = null;
        var char_literal152 = null;
         var name_1 = null;
         var ownedtype_2 = null;
         var init_3 = null;

        var prefix_0_tree=null;
        var char_literal151_tree=null;
        var char_literal152_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:550:26: (prefix_0= ';' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:551:2: prefix_0= ';' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            prefix_0=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_NavigatingSemiArgCS1920); 
            prefix_0_tree = this.adaptor.create(prefix_0);
            this.adaptor.addChild(root_0, prefix_0_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingSemiArgCS1924);
            name_1=this.rule_NavigatingArgExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:551:46: ( ':' ownedtype_2= rule_TypeExpCS )?
            var alt65=2;
            var LA65_0 = this.input.LA(1);

            if ( (LA65_0==16) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:551:47: ':' ownedtype_2= rule_TypeExpCS
                    char_literal151=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_NavigatingSemiArgCS1927); 
                    char_literal151_tree = this.adaptor.create(char_literal151);
                    this.adaptor.addChild(root_0, char_literal151_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_NavigatingSemiArgCS1931);
                    ownedtype_2=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_2.getTree());


                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:551:80: ( '=' init_3= rule_ExpCS )?
            var alt66=2;
            var LA66_0 = this.input.LA(1);

            if ( (LA66_0==48) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:551:81: '=' init_3= rule_ExpCS
                    char_literal152=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_NavigatingSemiArgCS1936); 
                    char_literal152_tree = this.adaptor.create(char_literal152);
                    this.adaptor.addChild(root_0, char_literal152_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingSemiArgCS1940);
                    init_3=this.rule_ExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, init_3.getTree());


                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NavigatingArgExpCS_return: (function() {
        MyAtlParser.rule_NavigatingArgExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NavigatingArgExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:557:1: rule_NavigatingArgExpCS : rule_ExpCS ;
    // $ANTLR start "rule_NavigatingArgExpCS"
    rule_NavigatingArgExpCS: function() {
        var retval = new MyAtlParser.rule_NavigatingArgExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_ExpCS153 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:557:24: ( rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:558:2: rule_ExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingArgExpCS1954);
            rule_ExpCS153=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_ExpCS153.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_IfExpCS_return: (function() {
        MyAtlParser.rule_IfExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_IfExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:564:1: rule_IfExpCS : 'if' condition_0= rule_ExpCS 'then' thenexpression_1= rule_ExpCS 'else' elseexpression_2= rule_ExpCS 'endif' ;
    // $ANTLR start "rule_IfExpCS"
    rule_IfExpCS: function() {
        var retval = new MyAtlParser.rule_IfExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal154 = null;
        var string_literal155 = null;
        var string_literal156 = null;
        var string_literal157 = null;
         var condition_0 = null;
         var thenexpression_1 = null;
         var elseexpression_2 = null;

        var string_literal154_tree=null;
        var string_literal155_tree=null;
        var string_literal156_tree=null;
        var string_literal157_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:564:13: ( 'if' condition_0= rule_ExpCS 'then' thenexpression_1= rule_ExpCS 'else' elseexpression_2= rule_ExpCS 'endif' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:565:2: 'if' condition_0= rule_ExpCS 'then' thenexpression_1= rule_ExpCS 'else' elseexpression_2= rule_ExpCS 'endif'
            root_0 = this.adaptor.nil();

            string_literal154=this.match(this.input,60,MyAtlParser.FOLLOW_60_in_rule_IfExpCS1967); 
            string_literal154_tree = this.adaptor.create(string_literal154);
            this.adaptor.addChild(root_0, string_literal154_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IfExpCS1971);
            condition_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, condition_0.getTree());
            string_literal155=this.match(this.input,66,MyAtlParser.FOLLOW_66_in_rule_IfExpCS1974); 
            string_literal155_tree = this.adaptor.create(string_literal155);
            this.adaptor.addChild(root_0, string_literal155_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IfExpCS1978);
            thenexpression_1=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, thenexpression_1.getTree());
            string_literal156=this.match(this.input,58,MyAtlParser.FOLLOW_58_in_rule_IfExpCS1981); 
            string_literal156_tree = this.adaptor.create(string_literal156);
            this.adaptor.addChild(root_0, string_literal156_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IfExpCS1985);
            elseexpression_2=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, elseexpression_2.getTree());
            string_literal157=this.match(this.input,59,MyAtlParser.FOLLOW_59_in_rule_IfExpCS1988); 
            string_literal157_tree = this.adaptor.create(string_literal157);
            this.adaptor.addChild(root_0, string_literal157_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_LetExpCS_return: (function() {
        MyAtlParser.rule_LetExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_LetExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:572:1: rule_LetExpCS : 'let' variable_0+= rule_LetVariableCS ( ',' variable_1+= rule_LetVariableCS )* 'in' in_2= rule_ExpCS ;
    // $ANTLR start "rule_LetExpCS"
    rule_LetExpCS: function() {
        var retval = new MyAtlParser.rule_LetExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal158 = null;
        var char_literal159 = null;
        var string_literal160 = null;
        var list_variable_0=null;
        var list_variable_1=null;
         var in_2 = null;
        var variable_0 = null;
        var variable_1 = null;
        var string_literal158_tree=null;
        var char_literal159_tree=null;
        var string_literal160_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:572:14: ( 'let' variable_0+= rule_LetVariableCS ( ',' variable_1+= rule_LetVariableCS )* 'in' in_2= rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:573:2: 'let' variable_0+= rule_LetVariableCS ( ',' variable_1+= rule_LetVariableCS )* 'in' in_2= rule_ExpCS
            root_0 = this.adaptor.nil();

            string_literal158=this.match(this.input,63,MyAtlParser.FOLLOW_63_in_rule_LetExpCS1998); 
            string_literal158_tree = this.adaptor.create(string_literal158);
            this.adaptor.addChild(root_0, string_literal158_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_LetVariableCS_in_rule_LetExpCS2002);
            variable_0=this.rule_LetVariableCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, variable_0.getTree());
            if (org.antlr.lang.isNull(list_variable_0)) list_variable_0 = [];
            list_variable_0.push(variable_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:573:39: ( ',' variable_1+= rule_LetVariableCS )*
            loop67:
            do {
                var alt67=2;
                var LA67_0 = this.input.LA(1);

                if ( (LA67_0==17) ) {
                    alt67=1;
                }


                switch (alt67) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:573:40: ',' variable_1+= rule_LetVariableCS
                    char_literal159=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_LetExpCS2005); 
                    char_literal159_tree = this.adaptor.create(char_literal159);
                    this.adaptor.addChild(root_0, char_literal159_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_LetVariableCS_in_rule_LetExpCS2009);
                    variable_1=this.rule_LetVariableCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, variable_1.getTree());
                    if (org.antlr.lang.isNull(list_variable_1)) list_variable_1 = [];
                    list_variable_1.push(variable_1.getTree());



                    break;

                default :
                    break loop67;
                }
            } while (true);

            string_literal160=this.match(this.input,62,MyAtlParser.FOLLOW_62_in_rule_LetExpCS2014); 
            string_literal160_tree = this.adaptor.create(string_literal160);
            this.adaptor.addChild(root_0, string_literal160_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_LetExpCS2018);
            in_2=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, in_2.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_LetVariableCS_return: (function() {
        MyAtlParser.rule_LetVariableCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_LetVariableCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:579:1: rule_LetVariableCS : name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS ;
    // $ANTLR start "rule_LetVariableCS"
    rule_LetVariableCS: function() {
        var retval = new MyAtlParser.rule_LetVariableCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal161 = null;
        var char_literal162 = null;
         var name_0 = null;
         var ownedtype_1 = null;
         var initexpression_2 = null;

        var char_literal161_tree=null;
        var char_literal162_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:579:19: (name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:580:2: name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_LetVariableCS2032);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:580:31: ( ':' ownedtype_1= rule_TypeExpCS )?
            var alt68=2;
            var LA68_0 = this.input.LA(1);

            if ( (LA68_0==16) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:580:32: ':' ownedtype_1= rule_TypeExpCS
                    char_literal161=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_LetVariableCS2035); 
                    char_literal161_tree = this.adaptor.create(char_literal161);
                    this.adaptor.addChild(root_0, char_literal161_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_LetVariableCS2038);
                    ownedtype_1=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_1.getTree());


                    break;

            }

            char_literal162=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_LetVariableCS2042); 
            char_literal162_tree = this.adaptor.create(char_literal162);
            this.adaptor.addChild(root_0, char_literal162_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_LetVariableCS2047);
            initexpression_2=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, initexpression_2.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NestedExpCS_return: (function() {
        MyAtlParser.rule_NestedExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NestedExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:587:1: rule_NestedExpCS : '(' source_0= rule_ExpCS ')' ;
    // $ANTLR start "rule_NestedExpCS"
    rule_NestedExpCS: function() {
        var retval = new MyAtlParser.rule_NestedExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal163 = null;
        var char_literal164 = null;
         var source_0 = null;

        var char_literal163_tree=null;
        var char_literal164_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:587:17: ( '(' source_0= rule_ExpCS ')' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:588:2: '(' source_0= rule_ExpCS ')'
            root_0 = this.adaptor.nil();

            char_literal163=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_NestedExpCS2060); 
            char_literal163_tree = this.adaptor.create(char_literal163);
            this.adaptor.addChild(root_0, char_literal163_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NestedExpCS2064);
            source_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, source_0.getTree());
            char_literal164=this.match(this.input,46,MyAtlParser.FOLLOW_46_in_rule_NestedExpCS2066); 
            char_literal164_tree = this.adaptor.create(char_literal164);
            this.adaptor.addChild(root_0, char_literal164_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_SelfExpCS_return: (function() {
        MyAtlParser.rule_SelfExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_SelfExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:594:1: rule_SelfExpCS : 'self' ;
    // $ANTLR start "rule_SelfExpCS"
    rule_SelfExpCS: function() {
        var retval = new MyAtlParser.rule_SelfExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal165 = null;

        var string_literal165_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:594:15: ( 'self' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:595:2: 'self'
            root_0 = this.adaptor.nil();

            string_literal165=this.match(this.input,85,MyAtlParser.FOLLOW_85_in_rule_SelfExpCS2079); 
            string_literal165_tree = this.adaptor.create(string_literal165);
            this.adaptor.addChild(root_0, string_literal165_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_PrimaryExpCS_return: (function() {
        MyAtlParser.rule_PrimaryExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_PrimaryExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:608:1: rule_PrimaryExpCS : ( rule_NavigatingExpCS | rule_SelfExpCS | rule_PrimitiveLiteralExpCS | rule_TupleLiteralExpCS | rule_LetExpCS | rule_IfExpCS | rule_NestedExpCS | rule_StringExpCs );
    // $ANTLR start "rule_PrimaryExpCS"
    rule_PrimaryExpCS: function() {
        var retval = new MyAtlParser.rule_PrimaryExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_NavigatingExpCS166 = null;
         var rule_SelfExpCS167 = null;
         var rule_PrimitiveLiteralExpCS168 = null;
         var rule_TupleLiteralExpCS169 = null;
         var rule_LetExpCS170 = null;
         var rule_IfExpCS171 = null;
         var rule_NestedExpCS172 = null;
         var rule_StringExpCs173 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:608:18: ( rule_NavigatingExpCS | rule_SelfExpCS | rule_PrimitiveLiteralExpCS | rule_TupleLiteralExpCS | rule_LetExpCS | rule_IfExpCS | rule_NestedExpCS | rule_StringExpCs )
            var alt69=8;
            switch ( this.input.LA(1) ) {
            case SIMPLE_ID:
                alt69=1;
                break;
            case 85:
                alt69=2;
                break;
            case SINGLE_QUOTED_STRING:
            case BIG_INT:
            case 69:
            case 78:
            case 80:
            case 81:
            case 82:
                alt69=3;
                break;
            case 21:
                alt69=4;
                break;
            case 63:
                alt69=5;
                break;
            case 60:
                alt69=6;
                break;
            case 45:
                alt69=7;
                break;
            case 41:
                alt69=8;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 69, 0, this.input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:609:2: rule_NavigatingExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingExpCS_in_rule_PrimaryExpCS2106);
                    rule_NavigatingExpCS166=this.rule_NavigatingExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NavigatingExpCS166.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:609:25: rule_SelfExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_SelfExpCS_in_rule_PrimaryExpCS2110);
                    rule_SelfExpCS167=this.rule_SelfExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_SelfExpCS167.getTree());


                    break;
                case 3 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:609:42: rule_PrimitiveLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_PrimitiveLiteralExpCS_in_rule_PrimaryExpCS2114);
                    rule_PrimitiveLiteralExpCS168=this.rule_PrimitiveLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_PrimitiveLiteralExpCS168.getTree());


                    break;
                case 4 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:609:71: rule_TupleLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TupleLiteralExpCS_in_rule_PrimaryExpCS2118);
                    rule_TupleLiteralExpCS169=this.rule_TupleLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_TupleLiteralExpCS169.getTree());


                    break;
                case 5 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:610:3: rule_LetExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_LetExpCS_in_rule_PrimaryExpCS2124);
                    rule_LetExpCS170=this.rule_LetExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_LetExpCS170.getTree());


                    break;
                case 6 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:610:19: rule_IfExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_IfExpCS_in_rule_PrimaryExpCS2128);
                    rule_IfExpCS171=this.rule_IfExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_IfExpCS171.getTree());


                    break;
                case 7 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:610:34: rule_NestedExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NestedExpCS_in_rule_PrimaryExpCS2132);
                    rule_NestedExpCS172=this.rule_NestedExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NestedExpCS172.getTree());


                    break;
                case 8 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:610:53: rule_StringExpCs
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_StringExpCs_in_rule_PrimaryExpCS2136);
                    rule_StringExpCs173=this.rule_StringExpCs();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_StringExpCs173.getTree());


                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_StringExpCs_return: (function() {
        MyAtlParser.rule_StringExpCs_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_StringExpCs_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:616:1: rule_StringExpCs : name_0= '...' ;
    // $ANTLR start "rule_StringExpCs"
    rule_StringExpCs: function() {
        var retval = new MyAtlParser.rule_StringExpCs_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var name_0 = null;

        var name_0_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:616:17: (name_0= '...' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:617:2: name_0= '...'
            root_0 = this.adaptor.nil();

            name_0=this.match(this.input,41,MyAtlParser.FOLLOW_41_in_rule_StringExpCs2153); 
            name_0_tree = this.adaptor.create(name_0);
            this.adaptor.addChild(root_0, name_0_tree);




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NameExpCS_return: (function() {
        MyAtlParser.rule_NameExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NameExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:625:1: rule_NameExpCS : namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )? ;
    // $ANTLR start "rule_NameExpCS"
    rule_NameExpCS: function() {
        var retval = new MyAtlParser.rule_NameExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal174 = null;
        var string_literal175 = null;
        var list_namespace_0=null;
        var list_namespace_1=null;
         var element_2 = null;
         var element_3 = null;
        var namespace_0 = null;
        var namespace_1 = null;
        var string_literal174_tree=null;
        var string_literal175_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:625:15: (namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:626:2: namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_NameExpCS2169);
            namespace_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, namespace_0.getTree());
            if (org.antlr.lang.isNull(list_namespace_0)) list_namespace_0 = [];
            list_namespace_0.push(namespace_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:627:2: ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )?
            var alt72=2;
            var LA72_0 = this.input.LA(1);

            if ( (LA72_0==83) ) {
                alt72=1;
            }
            else if ( (LA72_0==SIMPLE_ID) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:627:3: ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:627:3: ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName )
                    var alt71=2;
                    var LA71_0 = this.input.LA(1);

                    if ( (LA71_0==83) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==SIMPLE_ID) ) {
                        alt71=2;
                    }
                    else {
                        var nvae =
                            new org.antlr.runtime.NoViableAltException("", 71, 0, this.input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:628:3: ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:628:3: ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:629:4: ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:629:4: ( '::' (namespace_1+= rule_UnreservedName '::' )* )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:629:6: '::' (namespace_1+= rule_UnreservedName '::' )*
                            string_literal174=this.match(this.input,83,MyAtlParser.FOLLOW_83_in_rule_NameExpCS2186); 
                            string_literal174_tree = this.adaptor.create(string_literal174);
                            this.adaptor.addChild(root_0, string_literal174_tree);

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:629:11: (namespace_1+= rule_UnreservedName '::' )*
                            loop70:
                            do {
                                var alt70=2;
                                switch ( this.input.LA(1) ) {
                                case SIMPLE_ID:
                                    var LA70_1 = this.input.LA(2);

                                    if ( (LA70_1==83) ) {
                                        alt70=1;
                                    }


                                    break;
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                    var LA70_2 = this.input.LA(2);

                                    if ( (LA70_2==83) ) {
                                        alt70=1;
                                    }


                                    break;
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                    var LA70_3 = this.input.LA(2);

                                    if ( (LA70_3==83) ) {
                                        alt70=1;
                                    }


                                    break;
                                case 21:
                                    var LA70_4 = this.input.LA(2);

                                    if ( (LA70_4==83) ) {
                                        alt70=1;
                                    }


                                    break;

                                }

                                switch (alt70) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:629:12: namespace_1+= rule_UnreservedName '::'
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_UnreservedName_in_rule_NameExpCS2192);
                                    namespace_1=this.rule_UnreservedName();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, namespace_1.getTree());
                                    if (org.antlr.lang.isNull(list_namespace_1)) list_namespace_1 = [];
                                    list_namespace_1.push(namespace_1.getTree());

                                    string_literal175=this.match(this.input,83,MyAtlParser.FOLLOW_83_in_rule_NameExpCS2194); 
                                    string_literal175_tree = this.adaptor.create(string_literal175);
                                    this.adaptor.addChild(root_0, string_literal175_tree);



                                    break;

                                default :
                                    break loop70;
                                }
                            } while (true);




                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnreservedName_in_rule_NameExpCS2206);
                            element_2=this.rule_UnreservedName();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, element_2.getTree());





                            break;
                        case 2 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:631:4: element_3= rule_UnrestrictedName
                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_NameExpCS2215);
                            element_3=this.rule_UnrestrictedName();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, element_3.getTree());


                            break;

                    }



                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_ExpCS_return: (function() {
        MyAtlParser.rule_ExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_ExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:637:1: rule_ExpCS : rule_InfixedExpCS ;
    // $ANTLR start "rule_ExpCS"
    rule_ExpCS: function() {
        var retval = new MyAtlParser.rule_ExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_InfixedExpCS176 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:637:11: ( rule_InfixedExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:638:2: rule_InfixedExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_InfixedExpCS_in_rule_ExpCS2232);
            rule_InfixedExpCS176=this.rule_InfixedExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_InfixedExpCS176.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_InfixedExpCS_return: (function() {
        MyAtlParser.rule_InfixedExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_InfixedExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:646:1: rule_InfixedExpCS : rule_PrefixedExpCS ( (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+ )? ;
    // $ANTLR start "rule_InfixedExpCS"
    rule_InfixedExpCS: function() {
        var retval = new MyAtlParser.rule_InfixedExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var list_ownedoperator_0=null;
        var list_ownedexpression_1=null;
         var rule_PrefixedExpCS177 = null;
        var ownedoperator_0 = null;
        var ownedexpression_1 = null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:646:18: ( rule_PrefixedExpCS ( (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+ )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:647:3: rule_PrefixedExpCS ( (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+ )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_PrefixedExpCS_in_rule_InfixedExpCS2247);
            rule_PrefixedExpCS177=this.rule_PrefixedExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_PrefixedExpCS177.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:647:22: ( (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+ )?
            var alt74=2;
            switch ( this.input.LA(1) ) {
                case 48:
                    alt74=1;
                    break;
                case 55:
                    alt74=1;
                    break;
                case 77:
                    alt74=1;
                    break;
                case 57:
                case 61:
                case 65:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                    alt74=1;
                    break;
            }

            switch (alt74) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:648:2: (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:648:2: (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+
                    var cnt73=0;
                    loop73:
                    do {
                        var alt73=2;
                        switch ( this.input.LA(1) ) {
                        case 55:
                            alt73=1;
                            break;
                        case 48:
                            alt73=1;
                            break;
                        case 57:
                        case 61:
                        case 65:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                            alt73=1;
                            break;
                        case 77:
                            alt73=1;
                            break;

                        }

                        switch (alt73) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:648:3: ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS
                            this.pushFollow(MyAtlParser.FOLLOW_rule_BinaryOperatorCS_in_rule_InfixedExpCS2255);
                            ownedoperator_0=this.rule_BinaryOperatorCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedoperator_0.getTree());
                            if (org.antlr.lang.isNull(list_ownedoperator_0)) list_ownedoperator_0 = [];
                            list_ownedoperator_0.push(ownedoperator_0.getTree());

                            this.pushFollow(MyAtlParser.FOLLOW_rule_PrefixedExpCS_in_rule_InfixedExpCS2259);
                            ownedexpression_1=this.rule_PrefixedExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedexpression_1.getTree());
                            if (org.antlr.lang.isNull(list_ownedexpression_1)) list_ownedexpression_1 = [];
                            list_ownedexpression_1.push(ownedexpression_1.getTree());



                            break;

                        default :
                            if ( cnt73 >= 1 ) {
                                break loop73;
                            }
                                var eee = new org.antlr.runtime.EarlyExitException(73, this.input);
                                throw eee;
                        }
                        cnt73++;
                    } while (true);



                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_BinaryOperatorCS_return: (function() {
        MyAtlParser.rule_BinaryOperatorCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_BinaryOperatorCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:656:1: rule_BinaryOperatorCS : ( rule_InfixOperatorCS | rule_NavigationOperatorCS );
    // $ANTLR start "rule_BinaryOperatorCS"
    rule_BinaryOperatorCS: function() {
        var retval = new MyAtlParser.rule_BinaryOperatorCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_InfixOperatorCS178 = null;
         var rule_NavigationOperatorCS179 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:656:23: ( rule_InfixOperatorCS | rule_NavigationOperatorCS )
            var alt75=2;
            var LA75_0 = this.input.LA(1);

            if ( (LA75_0==48||LA75_0==57||LA75_0==61||LA75_0==65||(LA75_0>=67 && LA75_0<=76)) ) {
                alt75=1;
            }
            else if ( (LA75_0==55||LA75_0==77) ) {
                alt75=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 75, 0, this.input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:657:2: rule_InfixOperatorCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_InfixOperatorCS_in_rule_BinaryOperatorCS2280);
                    rule_InfixOperatorCS178=this.rule_InfixOperatorCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_InfixOperatorCS178.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:657:25: rule_NavigationOperatorCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigationOperatorCS_in_rule_BinaryOperatorCS2284);
                    rule_NavigationOperatorCS179=this.rule_NavigationOperatorCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NavigationOperatorCS179.getTree());


                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_InfixOperatorCS_return: (function() {
        MyAtlParser.rule_InfixOperatorCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_InfixOperatorCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:661:1: rule_InfixOperatorCS : name_0= rule_InfixOperator ;
    // $ANTLR start "rule_InfixOperatorCS"
    rule_InfixOperatorCS: function() {
        var retval = new MyAtlParser.rule_InfixOperatorCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var name_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:661:21: (name_0= rule_InfixOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:662:2: name_0= rule_InfixOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_InfixOperator_in_rule_InfixOperatorCS2298);
            name_0=this.rule_InfixOperator();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NavigationOperatorCS_return: (function() {
        MyAtlParser.rule_NavigationOperatorCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NavigationOperatorCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:668:1: rule_NavigationOperatorCS : name_0= rule_NavigationOperator ;
    // $ANTLR start "rule_NavigationOperatorCS"
    rule_NavigationOperatorCS: function() {
        var retval = new MyAtlParser.rule_NavigationOperatorCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var name_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:668:27: (name_0= rule_NavigationOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:669:2: name_0= rule_NavigationOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigationOperator_in_rule_NavigationOperatorCS2315);
            name_0=this.rule_NavigationOperator();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_PrefixedExpCS_return: (function() {
        MyAtlParser.rule_PrefixedExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_PrefixedExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:677:1: rule_PrefixedExpCS : ( rule_PrimaryExpCS | ( (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS ) );
    // $ANTLR start "rule_PrefixedExpCS"
    rule_PrefixedExpCS: function() {
        var retval = new MyAtlParser.rule_PrefixedExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var list_ownedoperator_0=null;
         var ownedexpression_1 = null;
         var rule_PrimaryExpCS180 = null;
        var ownedoperator_0 = null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:677:20: ( rule_PrimaryExpCS | ( (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS ) )
            var alt77=2;
            var LA77_0 = this.input.LA(1);

            if ( ((LA77_0>=SIMPLE_ID && LA77_0<=BIG_INT)||LA77_0==21||LA77_0==41||LA77_0==45||LA77_0==60||LA77_0==63||LA77_0==69||LA77_0==78||(LA77_0>=80 && LA77_0<=82)||LA77_0==85) ) {
                alt77=1;
            }
            else if ( (LA77_0==64||LA77_0==68) ) {
                alt77=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 77, 0, this.input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:678:2: rule_PrimaryExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_PrimaryExpCS_in_rule_PrefixedExpCS2331);
                    rule_PrimaryExpCS180=this.rule_PrimaryExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_PrimaryExpCS180.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:678:22: ( (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS )
                    root_0 = this.adaptor.nil();

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:678:22: ( (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:678:24: (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:678:39: (ownedoperator_0+= rule_UnaryOperatorCS )+
                    var cnt76=0;
                    loop76:
                    do {
                        var alt76=2;
                        var LA76_0 = this.input.LA(1);

                        if ( (LA76_0==64||LA76_0==68) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:678:39: ownedoperator_0+= rule_UnaryOperatorCS
                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnaryOperatorCS_in_rule_PrefixedExpCS2339);
                            ownedoperator_0=this.rule_UnaryOperatorCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedoperator_0.getTree());
                            if (org.antlr.lang.isNull(list_ownedoperator_0)) list_ownedoperator_0 = [];
                            list_ownedoperator_0.push(ownedoperator_0.getTree());



                            break;

                        default :
                            if ( cnt76 >= 1 ) {
                                break loop76;
                            }
                                var eee = new org.antlr.runtime.EarlyExitException(76, this.input);
                                throw eee;
                        }
                        cnt76++;
                    } while (true);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_PrimaryExpCS_in_rule_PrefixedExpCS2346);
                    ownedexpression_1=this.rule_PrimaryExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedexpression_1.getTree());





                    break;

            }
            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_UnaryOperatorCS_return: (function() {
        MyAtlParser.rule_UnaryOperatorCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_UnaryOperatorCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:685:1: rule_UnaryOperatorCS : name_0= rule_PrefixOperator ;
    // $ANTLR start "rule_UnaryOperatorCS"
    rule_UnaryOperatorCS: function() {
        var retval = new MyAtlParser.rule_UnaryOperatorCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var name_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:685:22: (name_0= rule_PrefixOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:686:2: name_0= rule_PrefixOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_PrefixOperator_in_rule_UnaryOperatorCS2365);
            name_0=this.rule_PrefixOperator();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_IndexExpCS_return: (function() {
        MyAtlParser.rule_IndexExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_IndexExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:694:1: rule_IndexExpCS : rule_NameExpCS ( '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )? )? ;
    // $ANTLR start "rule_IndexExpCS"
    rule_IndexExpCS: function() {
        var retval = new MyAtlParser.rule_IndexExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal182 = null;
        var char_literal183 = null;
        var char_literal184 = null;
        var char_literal185 = null;
        var char_literal186 = null;
        var char_literal187 = null;
        var list_firstindexes_0=null;
        var list_firstindexes_1=null;
        var list_secondindexes_2=null;
        var list_secondindexes_3=null;
         var rule_NameExpCS181 = null;
        var firstindexes_0 = null;
        var firstindexes_1 = null;
        var secondindexes_2 = null;
        var secondindexes_3 = null;
        var char_literal182_tree=null;
        var char_literal183_tree=null;
        var char_literal184_tree=null;
        var char_literal185_tree=null;
        var char_literal186_tree=null;
        var char_literal187_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:694:16: ( rule_NameExpCS ( '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )? )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:695:2: rule_NameExpCS ( '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )? )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_NameExpCS_in_rule_IndexExpCS2381);
            rule_NameExpCS181=this.rule_NameExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_NameExpCS181.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:696:2: ( '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )? )?
            var alt81=2;
            var LA81_0 = this.input.LA(1);

            if ( (LA81_0==86) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:697:3: '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )?
                    char_literal182=this.match(this.input,86,MyAtlParser.FOLLOW_86_in_rule_IndexExpCS2388); 
                    char_literal182_tree = this.adaptor.create(char_literal182);
                    this.adaptor.addChild(root_0, char_literal182_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IndexExpCS2392);
                    firstindexes_0=this.rule_ExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, firstindexes_0.getTree());
                    if (org.antlr.lang.isNull(list_firstindexes_0)) list_firstindexes_0 = [];
                    list_firstindexes_0.push(firstindexes_0.getTree());

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:697:34: ( ',' firstindexes_1+= rule_ExpCS )*
                    loop78:
                    do {
                        var alt78=2;
                        var LA78_0 = this.input.LA(1);

                        if ( (LA78_0==17) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:697:35: ',' firstindexes_1+= rule_ExpCS
                            char_literal183=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_IndexExpCS2395); 
                            char_literal183_tree = this.adaptor.create(char_literal183);
                            this.adaptor.addChild(root_0, char_literal183_tree);

                            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IndexExpCS2399);
                            firstindexes_1=this.rule_ExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, firstindexes_1.getTree());
                            if (org.antlr.lang.isNull(list_firstindexes_1)) list_firstindexes_1 = [];
                            list_firstindexes_1.push(firstindexes_1.getTree());



                            break;

                        default :
                            break loop78;
                        }
                    } while (true);

                    char_literal184=this.match(this.input,87,MyAtlParser.FOLLOW_87_in_rule_IndexExpCS2403); 
                    char_literal184_tree = this.adaptor.create(char_literal184);
                    this.adaptor.addChild(root_0, char_literal184_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:698:3: ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )?
                    var alt80=2;
                    var LA80_0 = this.input.LA(1);

                    if ( (LA80_0==86) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:698:4: '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']'
                            char_literal185=this.match(this.input,86,MyAtlParser.FOLLOW_86_in_rule_IndexExpCS2408); 
                            char_literal185_tree = this.adaptor.create(char_literal185);
                            this.adaptor.addChild(root_0, char_literal185_tree);

                            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IndexExpCS2412);
                            secondindexes_2=this.rule_ExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, secondindexes_2.getTree());
                            if (org.antlr.lang.isNull(list_secondindexes_2)) list_secondindexes_2 = [];
                            list_secondindexes_2.push(secondindexes_2.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:698:36: ( ',' secondindexes_3+= rule_ExpCS )*
                            loop79:
                            do {
                                var alt79=2;
                                var LA79_0 = this.input.LA(1);

                                if ( (LA79_0==17) ) {
                                    alt79=1;
                                }


                                switch (alt79) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:698:37: ',' secondindexes_3+= rule_ExpCS
                                    char_literal186=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_IndexExpCS2415); 
                                    char_literal186_tree = this.adaptor.create(char_literal186);
                                    this.adaptor.addChild(root_0, char_literal186_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IndexExpCS2419);
                                    secondindexes_3=this.rule_ExpCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, secondindexes_3.getTree());
                                    if (org.antlr.lang.isNull(list_secondindexes_3)) list_secondindexes_3 = [];
                                    list_secondindexes_3.push(secondindexes_3.getTree());



                                    break;

                                default :
                                    break loop79;
                                }
                            } while (true);

                            char_literal187=this.match(this.input,87,MyAtlParser.FOLLOW_87_in_rule_IndexExpCS2423); 
                            char_literal187_tree = this.adaptor.create(char_literal187);
                            this.adaptor.addChild(root_0, char_literal187_tree);



                            break;

                    }



                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NavigatingExpCS_Base_return: (function() {
        MyAtlParser.rule_NavigatingExpCS_Base_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NavigatingExpCS_Base_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:704:1: rule_NavigatingExpCS_Base : rule_IndexExpCS ;
    // $ANTLR start "rule_NavigatingExpCS_Base"
    rule_NavigatingExpCS_Base: function() {
        var retval = new MyAtlParser.rule_NavigatingExpCS_Base_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_IndexExpCS188 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:704:26: ( rule_IndexExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:706:2: rule_IndexExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_IndexExpCS_in_rule_NavigatingExpCS_Base2442);
            rule_IndexExpCS188=this.rule_IndexExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_IndexExpCS188.getTree());



            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    },

    // inline static return class
    rule_NavigatingExpCS_return: (function() {
        MyAtlParser.rule_NavigatingExpCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_NavigatingExpCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:714:1: rule_NavigatingExpCS : rule_NavigatingExpCS_Base ( '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')' )? ;
    // $ANTLR start "rule_NavigatingExpCS"
    rule_NavigatingExpCS: function() {
        var retval = new MyAtlParser.rule_NavigatingExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal190 = null;
        var char_literal191 = null;
        var list_argument_0=null;
        var list_argument_1=null;
        var list_argument_2=null;
        var list_argument_3=null;
        var list_argument_4=null;
        var list_argument_5=null;
         var rule_NavigatingExpCS_Base189 = null;
        var argument_0 = null;
        var argument_1 = null;
        var argument_2 = null;
        var argument_3 = null;
        var argument_4 = null;
        var argument_5 = null;
        var char_literal190_tree=null;
        var char_literal191_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:714:22: ( rule_NavigatingExpCS_Base ( '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')' )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:715:2: rule_NavigatingExpCS_Base ( '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')' )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingExpCS_Base_in_rule_NavigatingExpCS2457);
            rule_NavigatingExpCS_Base189=this.rule_NavigatingExpCS_Base();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_NavigatingExpCS_Base189.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:716:2: ( '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')' )?
            var alt88=2;
            var LA88_0 = this.input.LA(1);

            if ( (LA88_0==45) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:717:3: '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')'
                    char_literal190=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_NavigatingExpCS2465); 
                    char_literal190_tree = this.adaptor.create(char_literal190);
                    this.adaptor.addChild(root_0, char_literal190_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:717:7: (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )?
                    var alt87=2;
                    var LA87_0 = this.input.LA(1);

                    if ( ((LA87_0>=SIMPLE_ID && LA87_0<=BIG_INT)||LA87_0==21||LA87_0==41||LA87_0==45||LA87_0==60||(LA87_0>=63 && LA87_0<=64)||(LA87_0>=68 && LA87_0<=69)||LA87_0==78||(LA87_0>=80 && LA87_0<=82)||LA87_0==85) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:717:8: argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )?
                            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgCS_in_rule_NavigatingExpCS2470);
                            argument_0=this.rule_NavigatingArgCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, argument_0.getTree());
                            if (org.antlr.lang.isNull(list_argument_0)) list_argument_0 = [];
                            list_argument_0.push(argument_0.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:717:41: (argument_1+= rule_NavigatingCommaArgCS )*
                            loop82:
                            do {
                                var alt82=2;
                                var LA82_0 = this.input.LA(1);

                                if ( (LA82_0==17) ) {
                                    alt82=1;
                                }


                                switch (alt82) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:717:42: argument_1+= rule_NavigatingCommaArgCS
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2475);
                                    argument_1=this.rule_NavigatingCommaArgCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, argument_1.getTree());
                                    if (org.antlr.lang.isNull(list_argument_1)) list_argument_1 = [];
                                    list_argument_1.push(argument_1.getTree());



                                    break;

                                default :
                                    break loop82;
                                }
                            } while (true);

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:718:4: (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )?
                            var alt84=2;
                            var LA84_0 = this.input.LA(1);

                            if ( (LA84_0==13) ) {
                                alt84=1;
                            }
                            switch (alt84) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:718:5: argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )*
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingSemiArgCS_in_rule_NavigatingExpCS2485);
                                    argument_2=this.rule_NavigatingSemiArgCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, argument_2.getTree());
                                    if (org.antlr.lang.isNull(list_argument_2)) list_argument_2 = [];
                                    list_argument_2.push(argument_2.getTree());

                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:719:5: (argument_3+= rule_NavigatingCommaArgCS )*
                                    loop83:
                                    do {
                                        var alt83=2;
                                        var LA83_0 = this.input.LA(1);

                                        if ( (LA83_0==17) ) {
                                            alt83=1;
                                        }


                                        switch (alt83) {
                                        case 1 :
                                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:719:6: argument_3+= rule_NavigatingCommaArgCS
                                            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2494);
                                            argument_3=this.rule_NavigatingCommaArgCS();

                                            this.state._fsp--;

                                            this.adaptor.addChild(root_0, argument_3.getTree());
                                            if (org.antlr.lang.isNull(list_argument_3)) list_argument_3 = [];
                                            list_argument_3.push(argument_3.getTree());



                                            break;

                                        default :
                                            break loop83;
                                        }
                                    } while (true);



                                    break;

                            }

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:720:5: (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )?
                            var alt86=2;
                            var LA86_0 = this.input.LA(1);

                            if ( (LA86_0==84) ) {
                                alt86=1;
                            }
                            switch (alt86) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:720:6: argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )*
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingBarArgCS_in_rule_NavigatingExpCS2507);
                                    argument_4=this.rule_NavigatingBarArgCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, argument_4.getTree());
                                    if (org.antlr.lang.isNull(list_argument_4)) list_argument_4 = [];
                                    list_argument_4.push(argument_4.getTree());

                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:720:42: (argument_5+= rule_NavigatingCommaArgCS )*
                                    loop85:
                                    do {
                                        var alt85=2;
                                        var LA85_0 = this.input.LA(1);

                                        if ( (LA85_0==17) ) {
                                            alt85=1;
                                        }


                                        switch (alt85) {
                                        case 1 :
                                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:720:43: argument_5+= rule_NavigatingCommaArgCS
                                            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2512);
                                            argument_5=this.rule_NavigatingCommaArgCS();

                                            this.state._fsp--;

                                            this.adaptor.addChild(root_0, argument_5.getTree());
                                            if (org.antlr.lang.isNull(list_argument_5)) list_argument_5 = [];
                                            list_argument_5.push(argument_5.getTree());



                                            break;

                                        default :
                                            break loop85;
                                        }
                                    } while (true);



                                    break;

                            }



                            break;

                    }

                    char_literal191=this.match(this.input,46,MyAtlParser.FOLLOW_46_in_rule_NavigatingExpCS2519); 
                    char_literal191_tree = this.adaptor.create(char_literal191);
                    this.adaptor.addChild(root_0, char_literal191_tree);



                    break;

            }




            retval.stop = this.input.LT(-1);

            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }
        finally {
        }
        return retval;
    }

    // Delegated rules




}, true); // important to pass true to overwrite default implementations

org.antlr.lang.augmentObject(MyAtlParser, {
    DFA41_eotS:
        "\u001c\uffff",
    DFA41_eofS:
        "\u0001\u0004\u0007\uffff\u0001\u000e\u0013\uffff",
    DFA41_minS:
        "\u0001\u000d\u0001\u0004\u0001\uffff\u0001\u0004\u0001\uffff\u0001"+
    "\u0004\u0001\uffff\u0001\u0025\u0001\u000d\u0001\u0004\u0001\u0025\u0001"+
    "\uffff\u0001\u0004\u0001\u0011\u0001\uffff\u0001\u0004\u0001\u0027\u0001"+
    "\uffff\u0004\u0011\u0004\u0027\u0002\u0004",
    DFA41_maxS:
        "\u0001\u0054\u0001\u0055\u0001\uffff\u0001\u0055\u0001\uffff\u0001"+
    "\u0056\u0001\uffff\u0001\u004e\u0001\u0054\u0001\u0056\u0001\u004e\u0001"+
    "\uffff\u0001\u0022\u0001\u0056\u0001\uffff\u0001\u0022\u0001\u0056\u0001"+
    "\uffff\u0008\u0056\u0002\u0022",
    DFA41_acceptS:
        "\u0002\uffff\u0001\u0002\u0001\uffff\u0001\u0003\u0001\uffff\u0001"+
    "\u0001\u0004\uffff\u0001\u0001\u0002\uffff\u0001\u0001\u0002\uffff\u0001"+
    "\u0001\u000a\uffff",
    DFA41_specialS:
        "\u001c\uffff}>",
    DFA41_transitionS: [
            "\u0001\u0004\u0003\uffff\u0001\u0004\u0013\uffff\u0001\u0001"+
            "\u0005\u0004\u0002\uffff\u0001\u0003\u0001\u0004\u0001\uffff"+
            "\u0001\u0004\u0017\uffff\u0001\u0004\u0001\u0002\u000a\uffff"+
            "\u0001\u0004",
            "\u0001\u0005\u0002\u0004\u000e\uffff\u0001\u0007\u000d\u0006"+
            "\u0004\uffff\u0001\u0008\u0001\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\u0006\u000d\uffff\u0001\u0004\u0002\uffff"+
            "\u0002\u0004\u0003\uffff\u0002\u0004\u0008\uffff\u0001\u0004"+
            "\u0001\uffff\u0003\u0004\u0002\uffff\u0001\u0004",
            "",
            "\u0001\u0009\u0002\u0004\u000e\uffff\u0001\u000a\u000d\u0006"+
            "\u0004\uffff\u0001\u000b\u0001\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\u000b\u000d\uffff\u0001\u0004\u0002\uffff"+
            "\u0002\u0004\u0003\uffff\u0002\u0004\u0008\uffff\u0001\u0004"+
            "\u0001\uffff\u0003\u0004\u0002\uffff\u0001\u0004",
            "",
            "\u0001\u000d\u000c\uffff\u0001\u0004\u0015\uffff\u0001\u0008"+
            "\u0005\uffff\u0001\u0004\u0001\u000b\u0001\uffff\u0001\u0004"+
            "\u0006\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0003\uffff\u0001\u0004\u0001\uffff\u000b\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u000c\u0002\uffff"+
            "\u0001\u0004",
            "",
            "\u0001\u0004\u0007\uffff\u0001\u000b\u001b\uffff\u0001\u000b"+
            "\u0004\uffff\u0001\u000b",
            "\u0001\u000b\u0003\uffff\u0001\u000b\u0013\uffff\u0006\u000b"+
            "\u0002\uffff\u0002\u000b\u0001\uffff\u0001\u000b\u0017\uffff"+
            "\u0001\u000b\u000b\uffff\u0001\u000b",
            "\u0001\u0010\u0022\uffff\u0001\u0011\u0005\uffff\u0001\u0004"+
            "\u0001\u0011\u0001\uffff\u0001\u0004\u0005\uffff\u0002\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0005\uffff\u0001\u000f"+
            "\u0002\uffff\u0001\u0004",
            "\u0001\u0004\u0007\uffff\u0001\u0011\u001b\uffff\u0001\u0011"+
            "\u0004\uffff\u0001\u0011",
            "",
            "\u0001\u0012\u0010\uffff\u0001\u0015\u0008\u0014\u0005\u0013",
            "\u0001\u0004\u0015\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
            "\u0001\u0011\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0001\uffff\u0001\u0004"+
            "\u0006\uffff\u0001\u0004",
            "",
            "\u0001\u0016\u0010\uffff\u0001\u0019\u0008\u0018\u0005\u0017",
            "\u0001\u000e\u0005\uffff\u0001\u0004\u0001\u0011\u0001\uffff"+
            "\u0001\u0004\u0006\uffff\u0001\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0001\uffff"+
            "\u000b\u0004\u0008\uffff\u0001\u0004",
            "",
            "\u0001\u0004\u0015\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
            "\u0001\u000e\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u001a\u0002\uffff\u0001\u0004",
            "\u0001\u0004\u0015\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
            "\u0001\u000e\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u001a\u0002\uffff\u0001\u0004",
            "\u0001\u0004\u0015\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
            "\u0001\u000e\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u001a\u0002\uffff\u0001\u0004",
            "\u0001\u0004\u0015\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
            "\u0001\u000e\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u001a\u0002\uffff\u0001\u0004",
            "\u0001\u000e\u0005\uffff\u0001\u0004\u0001\u0011\u0001\uffff"+
            "\u0001\u0004\u0006\uffff\u0001\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0001\uffff"+
            "\u000b\u0004\u0005\uffff\u0001\u001b\u0002\uffff\u0001\u0004",
            "\u0001\u000e\u0005\uffff\u0001\u0004\u0001\u0011\u0001\uffff"+
            "\u0001\u0004\u0006\uffff\u0001\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0001\uffff"+
            "\u000b\u0004\u0005\uffff\u0001\u001b\u0002\uffff\u0001\u0004",
            "\u0001\u000e\u0005\uffff\u0001\u0004\u0001\u0011\u0001\uffff"+
            "\u0001\u0004\u0006\uffff\u0001\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0001\uffff"+
            "\u000b\u0004\u0005\uffff\u0001\u001b\u0002\uffff\u0001\u0004",
            "\u0001\u000e\u0005\uffff\u0001\u0004\u0001\u0011\u0001\uffff"+
            "\u0001\u0004\u0006\uffff\u0001\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0001\uffff"+
            "\u000b\u0004\u0005\uffff\u0001\u001b\u0002\uffff\u0001\u0004",
            "\u0001\u0012\u0010\uffff\u0001\u0015\u0008\u0014\u0005\u0013",
            "\u0001\u0016\u0010\uffff\u0001\u0019\u0008\u0018\u0005\u0017"
    ]
});

org.antlr.lang.augmentObject(MyAtlParser, {
    DFA41_eot:
        org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA41_eotS),
    DFA41_eof:
        org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA41_eofS),
    DFA41_min:
        org.antlr.runtime.DFA.unpackEncodedStringToUnsignedChars(MyAtlParser.DFA41_minS),
    DFA41_max:
        org.antlr.runtime.DFA.unpackEncodedStringToUnsignedChars(MyAtlParser.DFA41_maxS),
    DFA41_accept:
        org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA41_acceptS),
    DFA41_special:
        org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA41_specialS),
    DFA41_transition: (function() {
        var a = [],
            i,
            numStates = MyAtlParser.DFA41_transitionS.length;
        for (i=0; i<numStates; i++) {
            a.push(org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA41_transitionS[i]));
        }
        return a;
    })()
});

MyAtlParser.DFA41 = function(recognizer) {
    this.recognizer = recognizer;
    this.decisionNumber = 41;
    this.eot = MyAtlParser.DFA41_eot;
    this.eof = MyAtlParser.DFA41_eof;
    this.min = MyAtlParser.DFA41_min;
    this.max = MyAtlParser.DFA41_max;
    this.accept = MyAtlParser.DFA41_accept;
    this.special = MyAtlParser.DFA41_special;
    this.transition = MyAtlParser.DFA41_transition;
};

org.antlr.lang.extend(MyAtlParser.DFA41, org.antlr.runtime.DFA, {
    getDescription: function() {
        return "369:39: ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )?";
    },
    dummy: null
});
 

// public class variables
org.antlr.lang.augmentObject(MyAtlParser, {
    tokenNames: ["<invalid>", "<EOR>", "<DOWN>", "<UP>", "SIMPLE_ID", "SINGLE_QUOTED_STRING", "BIG_INT", "ID", "STRING", "COMMENT", "WS", "INT", "'module'", "';'", "'create'", "'OUT'", "':'", "','", "'from'", "'IN'", "'uses'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'lazy'", "'rule'", "'{'", "'using'", "'}'", "'to'", "'...'", "'do'", "'entrypoint'", "'endpoint'", "'('", "')'", "'query'", "'='", "'helper'", "'context'", "'def'", "'xxx'", "'yyy'", "'<-'", "'.'", "'!'", "'and'", "'else'", "'endif'", "'if'", "'implies'", "'in'", "'let'", "'not'", "'or'", "'then'", "'xor'", "'-'", "'*'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'<>'", "'->'", "'true'", "'..'", "'false'", "'invalid'", "'null'", "'::'", "'|'", "'self'", "'['", "']'"],
    FOLLOW_12_in_rule_Module58: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_Module63: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_Module64: new org.antlr.runtime.BitSet([0x00004000, 0x00000000]),
    FOLLOW_14_in_rule_Module68: new org.antlr.runtime.BitSet([0x00008000, 0x00000000]),
    FOLLOW_15_in_rule_Module70: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_Module72: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_Module76: new org.antlr.runtime.BitSet([0x00060000, 0x00000000]),
    FOLLOW_17_in_rule_Module79: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_Module82: new org.antlr.runtime.BitSet([0x00060000, 0x00000000]),
    FOLLOW_18_in_rule_Module87: new org.antlr.runtime.BitSet([0x00080010, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_Module92: new org.antlr.runtime.BitSet([0x00030000, 0x00000000]),
    FOLLOW_set_in_rule_Module94: new org.antlr.runtime.BitSet([0x000A0010, 0x00000000]),
    FOLLOW_17_in_rule_Module103: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_Module106: new org.antlr.runtime.BitSet([0x000A0010, 0x00000000]),
    FOLLOW_19_in_rule_Module112: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_Module114: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_Module118: new org.antlr.runtime.BitSet([0x00022000, 0x00000000]),
    FOLLOW_17_in_rule_Module121: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_Module124: new org.antlr.runtime.BitSet([0x00022000, 0x00000000]),
    FOLLOW_13_in_rule_Module130: new org.antlr.runtime.BitSet([0x00100000, 0x00029818]),
    FOLLOW_20_in_rule_Module133: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_Module137: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_Module139: new org.antlr.runtime.BitSet([0x00000000, 0x00029818]),
    FOLLOW_rule_ModuleElement_in_rule_Module147: new org.antlr.runtime.BitSet([0x00000000, 0x00029818]),
    FOLLOW_EOF_in_rule_Module154: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_EssentialOCLUnreservedName171: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_CollectionTypeIdentifier_in_rule_EssentialOCLUnreservedName175: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrimitiveTypeIdentifier_in_rule_EssentialOCLUnreservedName180: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_21_in_rule_EssentialOCLUnreservedName184: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_EssentialOCLUnreservedName_in_rule_UnreservedName197: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_PrimitiveTypeIdentifier0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_CollectionTypeIdentifier0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_EssentialOCLUnrestrictedName_in_rule_UnrestrictedName280: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_SIMPLE_ID_in_rule_EssentialOCLUnrestrictedName295: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_Helper_in_rule_ModuleElement309: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_MatchedRule_in_rule_ModuleElement313: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_CalledRule_in_rule_ModuleElement317: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_QueryRule_in_rule_ModuleElement322: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_35_in_rule_MatchedRule335: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_MatchedRule339: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_MatchedRule343: new org.antlr.runtime.BitSet([0x00000000, 0x00000020]),
    FOLLOW_37_in_rule_MatchedRule345: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_18_in_rule_MatchedRule349: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_InPattern_in_rule_MatchedRule355: new org.antlr.runtime.BitSet([0x00000000, 0x00000140]),
    FOLLOW_38_in_rule_MatchedRule361: new org.antlr.runtime.BitSet([0x00000000, 0x00000020]),
    FOLLOW_37_in_rule_MatchedRule363: new org.antlr.runtime.BitSet([0x00000010, 0x00000080]),
    FOLLOW_rule_RuleVariableDeclaration_in_rule_MatchedRule371: new org.antlr.runtime.BitSet([0x00000010, 0x00000080]),
    FOLLOW_39_in_rule_MatchedRule376: new org.antlr.runtime.BitSet([0x00000000, 0x00000100]),
    FOLLOW_40_in_rule_MatchedRule382: new org.antlr.runtime.BitSet([0x00000010, 0x00100000]),
    FOLLOW_rule_OutPattern_in_rule_MatchedRule388: new org.antlr.runtime.BitSet([0x00020000, 0x00000680]),
    FOLLOW_41_in_rule_MatchedRule391: new org.antlr.runtime.BitSet([0x00020000, 0x00000480]),
    FOLLOW_17_in_rule_MatchedRule396: new org.antlr.runtime.BitSet([0x00020000, 0x00000480]),
    FOLLOW_42_in_rule_MatchedRule403: new org.antlr.runtime.BitSet([0x00000000, 0x00000020]),
    FOLLOW_37_in_rule_MatchedRule405: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ActionBlock_in_rule_MatchedRule412: new org.antlr.runtime.BitSet([0x00000000, 0x00000080]),
    FOLLOW_39_in_rule_MatchedRule417: new org.antlr.runtime.BitSet([0x00020000, 0x00000080]),
    FOLLOW_17_in_rule_MatchedRule428: new org.antlr.runtime.BitSet([0x00000000, 0x00000080]),
    FOLLOW_39_in_rule_MatchedRule431: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_CalledRule445: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_CalledRule453: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_CalledRule457: new org.antlr.runtime.BitSet([0x00000000, 0x00002020]),
    FOLLOW_45_in_rule_CalledRule461: new org.antlr.runtime.BitSet([0x00000000, 0x00004000]),
    FOLLOW_46_in_rule_CalledRule462: new org.antlr.runtime.BitSet([0x00000000, 0x00000020]),
    FOLLOW_37_in_rule_CalledRule466: new org.antlr.runtime.BitSet([0x00000000, 0x00000140]),
    FOLLOW_38_in_rule_CalledRule471: new org.antlr.runtime.BitSet([0x00000000, 0x00000020]),
    FOLLOW_37_in_rule_CalledRule473: new org.antlr.runtime.BitSet([0x00000010, 0x00000080]),
    FOLLOW_rule_RuleVariableDeclaration_in_rule_CalledRule481: new org.antlr.runtime.BitSet([0x00000010, 0x00000080]),
    FOLLOW_39_in_rule_CalledRule486: new org.antlr.runtime.BitSet([0x00000000, 0x00000100]),
    FOLLOW_40_in_rule_CalledRule492: new org.antlr.runtime.BitSet([0x00000010, 0x00100000]),
    FOLLOW_rule_OutPattern_in_rule_CalledRule498: new org.antlr.runtime.BitSet([0x00020000, 0x00000680]),
    FOLLOW_41_in_rule_CalledRule501: new org.antlr.runtime.BitSet([0x00020000, 0x00000480]),
    FOLLOW_17_in_rule_CalledRule506: new org.antlr.runtime.BitSet([0x00020000, 0x00000480]),
    FOLLOW_42_in_rule_CalledRule513: new org.antlr.runtime.BitSet([0x00000000, 0x00000020]),
    FOLLOW_37_in_rule_CalledRule515: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ActionBlock_in_rule_CalledRule522: new org.antlr.runtime.BitSet([0x00000000, 0x00000080]),
    FOLLOW_39_in_rule_CalledRule526: new org.antlr.runtime.BitSet([0x00020000, 0x00000080]),
    FOLLOW_17_in_rule_CalledRule536: new org.antlr.runtime.BitSet([0x00000000, 0x00000080]),
    FOLLOW_39_in_rule_CalledRule539: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_47_in_rule_QueryRule551: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_QueryRule556: new org.antlr.runtime.BitSet([0x00000000, 0x00012000]),
    FOLLOW_45_in_rule_QueryRule561: new org.antlr.runtime.BitSet([0x00000010, 0x00004000]),
    FOLLOW_rule_ATLParameterCS_in_rule_QueryRule567: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_17_in_rule_QueryRule570: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_ATLParameterCS_in_rule_QueryRule576: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_46_in_rule_QueryRule583: new org.antlr.runtime.BitSet([0x00000000, 0x00010000]),
    FOLLOW_48_in_rule_QueryRule590: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_QueryRule594: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_QueryRule596: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_49_in_rule_Helper615: new org.antlr.runtime.BitSet([0x00000010, 0x000C0000]),
    FOLLOW_50_in_rule_Helper619: new org.antlr.runtime.BitSet([0x00000010, 0x000C0000]),
    FOLLOW_rule_UnrestrictedName_in_rule_Helper626: new org.antlr.runtime.BitSet([0x00000010, 0x000C0000]),
    FOLLOW_rule_ATLDefCS_in_rule_Helper635: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_51_in_rule_ATLDefCS656: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_ATLDefCS658: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_ATLDefCS662: new org.antlr.runtime.BitSet([0x00010000, 0x00002000]),
    FOLLOW_45_in_rule_ATLDefCS666: new org.antlr.runtime.BitSet([0x00000010, 0x00004000]),
    FOLLOW_rule_ATLParameterCS_in_rule_ATLDefCS672: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_17_in_rule_ATLDefCS675: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_ATLParameterCS_in_rule_ATLDefCS681: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_46_in_rule_ATLDefCS688: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_ATLDefCS693: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_ATLDefCS697: new org.antlr.runtime.BitSet([0x00000000, 0x00010000]),
    FOLLOW_48_in_rule_ATLDefCS700: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_ATLDefCS704: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_ATLDefCS706: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_ATLParameterCS724: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_ATLParameterCS726: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_ATLParameterCS730: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_RuleVariableDeclaration747: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_RuleVariableDeclaration749: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_RuleVariableDeclaration753: new org.antlr.runtime.BitSet([0x00000000, 0x00010000]),
    FOLLOW_48_in_rule_RuleVariableDeclaration758: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_RuleVariableDeclaration762: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_RuleVariableDeclaration764: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_InPatternElement_in_rule_InPattern780: new org.antlr.runtime.BitSet([0x00000002, 0x00002000]),
    FOLLOW_45_in_rule_InPattern783: new org.antlr.runtime.BitSet([0x00200070, 0x90006200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_InPattern788: new org.antlr.runtime.BitSet([0x00000000, 0x00004000]),
    FOLLOW_46_in_rule_InPattern792: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_InPatternElement811: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_InPatternElement813: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_InPatternElement817: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_OutPatternElement_in_rule_OutPattern832: new org.antlr.runtime.BitSet([0x00020002, 0x00000000]),
    FOLLOW_17_in_rule_OutPattern835: new org.antlr.runtime.BitSet([0x00000010, 0x00100000]),
    FOLLOW_rule_OutPatternElement_in_rule_OutPattern841: new org.antlr.runtime.BitSet([0x00020002, 0x00000000]),
    FOLLOW_rule_SimpleOutPatternElement_in_rule_OutPatternElement856: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ForEachOutPatternElement_in_rule_OutPatternElement860: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_SimpleOutPatternElement875: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_SimpleOutPatternElement877: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_SimpleOutPatternElement881: new org.antlr.runtime.BitSet([0x00000002, 0x00002000]),
    FOLLOW_45_in_rule_SimpleOutPatternElement885: new org.antlr.runtime.BitSet([0x00000010, 0x00004000]),
    FOLLOW_rule_Binding_in_rule_SimpleOutPatternElement892: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_17_in_rule_SimpleOutPatternElement895: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_Binding_in_rule_SimpleOutPatternElement899: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_46_in_rule_SimpleOutPatternElement906: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_52_in_rule_ForEachOutPatternElement921: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_ForEachOutPatternElement928: new org.antlr.runtime.BitSet([0x00000000, 0x00200000]),
    FOLLOW_53_in_rule_ForEachOutPatternElement931: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_Binding944: new org.antlr.runtime.BitSet([0x00000000, 0x00400000]),
    FOLLOW_54_in_rule_Binding946: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_Binding950: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_Statement_in_rule_ActionBlock966: new org.antlr.runtime.BitSet([0x00200072, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_BindingStat_in_rule_Statement980: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_BindingStat995: new org.antlr.runtime.BitSet([0x00000000, 0x00800000]),
    FOLLOW_55_in_rule_BindingStat997: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_BindingStat1003: new org.antlr.runtime.BitSet([0x00000000, 0x00400000]),
    FOLLOW_54_in_rule_BindingStat1005: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_BindingStat1010: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_BindingStat1012: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ATLModelName_in_rule_ATLType1030: new org.antlr.runtime.BitSet([0x00000000, 0x01000000]),
    FOLLOW_56_in_rule_ATLType1032: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_ATLType1040: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_ATLModelName1054: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_EssentialOCLRersevedKeyword0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_EssentialOCLPrefixOperator0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_EssentialOCLInfixOperator0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_EssentialOCLNavigationOperator0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_SINGLE_QUOTED_STRING_in_rule_StringLiteral1220: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_EssentialOCLPrefixOperator_in_rule_PrefixOperator1233: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_EssentialOCLInfixOperator_in_rule_InfixOperator1244: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_EssentialOCLNavigationOperator_in_rule_NavigationOperator1256: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_CollectionTypeIdentifier_in_rule_CollectionTypeCS1272: new org.antlr.runtime.BitSet([0x00000002, 0x00002020,0x00000200, 0x00000000]),
    FOLLOW_set_in_rule_CollectionTypeCS1276: new org.antlr.runtime.BitSet([0xFFE00010, 0x00004087]),
    FOLLOW_rule_TypeExpCS_in_rule_CollectionTypeCS1287: new org.antlr.runtime.BitSet([0x00000000, 0x00004080]),
    FOLLOW_set_in_rule_CollectionTypeCS1291: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_73_in_rule_CollectionTypeCS1305: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_CollectionTypeCS1309: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00000100, 0x00000000]),
    FOLLOW_72_in_rule_CollectionTypeCS1311: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_21_in_rule_TupleTypeCS1335: new org.antlr.runtime.BitSet([0x00000000, 0x00002000,0x00004200, 0x00000000]),
    FOLLOW_45_in_rule_TupleTypeCS1340: new org.antlr.runtime.BitSet([0x00000010, 0x00004000]),
    FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1345: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_17_in_rule_TupleTypeCS1348: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1352: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_46_in_rule_TupleTypeCS1358: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00004000, 0x00000000]),
    FOLLOW_73_in_rule_TupleTypeCS1366: new org.antlr.runtime.BitSet([0x00000010, 0x00000000,0x00000100, 0x00000000]),
    FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1371: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00000100, 0x00000000]),
    FOLLOW_17_in_rule_TupleTypeCS1374: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1378: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00000100, 0x00000000]),
    FOLLOW_72_in_rule_TupleTypeCS1383: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00004000, 0x00000000]),
    FOLLOW_78_in_rule_TupleTypeCS1393: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_TuplePartCS1409: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_TuplePartCS1411: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_TuplePartCS1415: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_CollectionTypeCS_in_rule_CollectionLiteralExpCS1430: new org.antlr.runtime.BitSet([0x00000000, 0x00000020]),
    FOLLOW_37_in_rule_CollectionLiteralExpCS1433: new org.antlr.runtime.BitSet([0x00200070, 0x90002280,0x00274031, 0x00000000]),
    FOLLOW_rule_CollectionLiteralPartCS_in_rule_CollectionLiteralExpCS1438: new org.antlr.runtime.BitSet([0x00020000, 0x00000080]),
    FOLLOW_17_in_rule_CollectionLiteralExpCS1441: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_CollectionLiteralPartCS_in_rule_CollectionLiteralExpCS1445: new org.antlr.runtime.BitSet([0x00020000, 0x00000080]),
    FOLLOW_39_in_rule_CollectionLiteralExpCS1450: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_CollectionLiteralPartCS1465: new org.antlr.runtime.BitSet([0x00000002, 0x00000000,0x00008000, 0x00000000]),
    FOLLOW_79_in_rule_CollectionLiteralPartCS1468: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_CollectionLiteralPartCS1472: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NumberLiteralExpCS_in_rule_PrimitiveLiteralExpCS1488: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_StringLiteralExpCS_in_rule_PrimitiveLiteralExpCS1492: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_BooleanLiteralExpCS_in_rule_PrimitiveLiteralExpCS1496: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnlimitedNaturalLiteralExpCS_in_rule_PrimitiveLiteralExpCS1502: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_InvalidLiteralExpCS_in_rule_PrimitiveLiteralExpCS1506: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NullLiteralExpCS_in_rule_PrimitiveLiteralExpCS1510: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_21_in_rule_TupleLiteralExpCS1522: new org.antlr.runtime.BitSet([0x00000000, 0x00000020]),
    FOLLOW_37_in_rule_TupleLiteralExpCS1524: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_TupleLiteralPartCS_in_rule_TupleLiteralExpCS1528: new org.antlr.runtime.BitSet([0x00020000, 0x00000080]),
    FOLLOW_17_in_rule_TupleLiteralExpCS1531: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_TupleLiteralPartCS_in_rule_TupleLiteralExpCS1537: new org.antlr.runtime.BitSet([0x00020000, 0x00000080]),
    FOLLOW_39_in_rule_TupleLiteralExpCS1541: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_TupleLiteralPartCS1555: new org.antlr.runtime.BitSet([0x00010000, 0x00010000]),
    FOLLOW_16_in_rule_TupleLiteralPartCS1558: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_TupleLiteralPartCS1562: new org.antlr.runtime.BitSet([0x00000000, 0x00010000]),
    FOLLOW_48_in_rule_TupleLiteralPartCS1566: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_TupleLiteralPartCS1571: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_BIG_INT_in_rule_NumberLiteralExpCS1584: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_StringLiteral_in_rule_StringLiteralExpCS1598: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_78_in_rule_BooleanLiteralExpCS1612: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_80_in_rule_BooleanLiteralExpCS1618: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_69_in_rule_UnlimitedNaturalLiteralExpCS1634: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_81_in_rule_InvalidLiteralExpCS1647: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_82_in_rule_NullLiteralExpCS1660: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrimitiveTypeIdentifier_in_rule_PrimitiveTypeCS1676: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrimitiveTypeCS_in_rule_TypeLiteralCS1690: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TupleTypeCS_in_rule_TypeLiteralCS1695: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_CollectionTypeCS_in_rule_TypeLiteralCS1699: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TypeLiteralCS_in_rule_TypeLiteralExpCS1715: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_TypeNameExpCS1732: new org.antlr.runtime.BitSet([0x00000012, 0x00000000,0x00080000, 0x00000000]),
    FOLLOW_83_in_rule_TypeNameExpCS1750: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_UnreservedName_in_rule_TypeNameExpCS1756: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00080000, 0x00000000]),
    FOLLOW_83_in_rule_TypeNameExpCS1758: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_UnreservedName_in_rule_TypeNameExpCS1770: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_TypeNameExpCS1779: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TypeNameExpCS_in_rule_TypeExpCS1793: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TypeLiteralCS_in_rule_TypeExpCS1797: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingArgCS1812: new org.antlr.runtime.BitSet([0x00010002, 0x00010000]),
    FOLLOW_16_in_rule_NavigatingArgCS1815: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_NavigatingArgCS1819: new org.antlr.runtime.BitSet([0x00000002, 0x00010000]),
    FOLLOW_48_in_rule_NavigatingArgCS1824: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingArgCS1828: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_84_in_rule_NavigatingBarArgCS1845: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingBarArgCS1849: new org.antlr.runtime.BitSet([0x00010002, 0x00010000]),
    FOLLOW_16_in_rule_NavigatingBarArgCS1852: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_NavigatingBarArgCS1856: new org.antlr.runtime.BitSet([0x00000002, 0x00010000]),
    FOLLOW_48_in_rule_NavigatingBarArgCS1861: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingBarArgCS1865: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_17_in_rule_NavigatingCommaArgCS1881: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingCommaArgCS1885: new org.antlr.runtime.BitSet([0x00010002, 0x00010000]),
    FOLLOW_16_in_rule_NavigatingCommaArgCS1888: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_NavigatingCommaArgCS1892: new org.antlr.runtime.BitSet([0x00000002, 0x00010000]),
    FOLLOW_48_in_rule_NavigatingCommaArgCS1897: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingCommaArgCS1901: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_13_in_rule_NavigatingSemiArgCS1920: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingSemiArgCS1924: new org.antlr.runtime.BitSet([0x00010002, 0x00010000]),
    FOLLOW_16_in_rule_NavigatingSemiArgCS1927: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_NavigatingSemiArgCS1931: new org.antlr.runtime.BitSet([0x00000002, 0x00010000]),
    FOLLOW_48_in_rule_NavigatingSemiArgCS1936: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingSemiArgCS1940: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingArgExpCS1954: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_60_in_rule_IfExpCS1967: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IfExpCS1971: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00000004, 0x00000000]),
    FOLLOW_66_in_rule_IfExpCS1974: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IfExpCS1978: new org.antlr.runtime.BitSet([0x00000000, 0x04000000]),
    FOLLOW_58_in_rule_IfExpCS1981: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IfExpCS1985: new org.antlr.runtime.BitSet([0x00000000, 0x08000000]),
    FOLLOW_59_in_rule_IfExpCS1988: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_63_in_rule_LetExpCS1998: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_LetVariableCS_in_rule_LetExpCS2002: new org.antlr.runtime.BitSet([0x00020000, 0x40000000]),
    FOLLOW_17_in_rule_LetExpCS2005: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_LetVariableCS_in_rule_LetExpCS2009: new org.antlr.runtime.BitSet([0x00020000, 0x40000000]),
    FOLLOW_62_in_rule_LetExpCS2014: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_LetExpCS2018: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_LetVariableCS2032: new org.antlr.runtime.BitSet([0x00010000, 0x00010000]),
    FOLLOW_16_in_rule_LetVariableCS2035: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_LetVariableCS2038: new org.antlr.runtime.BitSet([0x00000000, 0x00010000]),
    FOLLOW_48_in_rule_LetVariableCS2042: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_LetVariableCS2047: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_45_in_rule_NestedExpCS2060: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NestedExpCS2064: new org.antlr.runtime.BitSet([0x00000000, 0x00004000]),
    FOLLOW_46_in_rule_NestedExpCS2066: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_85_in_rule_SelfExpCS2079: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigatingExpCS_in_rule_PrimaryExpCS2106: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_SelfExpCS_in_rule_PrimaryExpCS2110: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrimitiveLiteralExpCS_in_rule_PrimaryExpCS2114: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TupleLiteralExpCS_in_rule_PrimaryExpCS2118: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_LetExpCS_in_rule_PrimaryExpCS2124: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_IfExpCS_in_rule_PrimaryExpCS2128: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NestedExpCS_in_rule_PrimaryExpCS2132: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_StringExpCs_in_rule_PrimaryExpCS2136: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_41_in_rule_StringExpCs2153: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_NameExpCS2169: new org.antlr.runtime.BitSet([0x00000012, 0x00000000,0x00080000, 0x00000000]),
    FOLLOW_83_in_rule_NameExpCS2186: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_UnreservedName_in_rule_NameExpCS2192: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00080000, 0x00000000]),
    FOLLOW_83_in_rule_NameExpCS2194: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_UnreservedName_in_rule_NameExpCS2206: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_NameExpCS2215: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_InfixedExpCS_in_rule_ExpCS2232: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrefixedExpCS_in_rule_InfixedExpCS2247: new org.antlr.runtime.BitSet([0x00000002, 0x22810000,0x00003FFA, 0x00000000]),
    FOLLOW_rule_BinaryOperatorCS_in_rule_InfixedExpCS2255: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_PrefixedExpCS_in_rule_InfixedExpCS2259: new org.antlr.runtime.BitSet([0x00000002, 0x22810000,0x00003FFA, 0x00000000]),
    FOLLOW_rule_InfixOperatorCS_in_rule_BinaryOperatorCS2280: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigationOperatorCS_in_rule_BinaryOperatorCS2284: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_InfixOperator_in_rule_InfixOperatorCS2298: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigationOperator_in_rule_NavigationOperatorCS2315: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrimaryExpCS_in_rule_PrefixedExpCS2331: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnaryOperatorCS_in_rule_PrefixedExpCS2339: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_PrimaryExpCS_in_rule_PrefixedExpCS2346: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrefixOperator_in_rule_UnaryOperatorCS2365: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_IndexExpCS2381: new org.antlr.runtime.BitSet([0x00000002, 0x00000000,0x00400000, 0x00000000]),
    FOLLOW_86_in_rule_IndexExpCS2388: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IndexExpCS2392: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00800000, 0x00000000]),
    FOLLOW_17_in_rule_IndexExpCS2395: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IndexExpCS2399: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00800000, 0x00000000]),
    FOLLOW_87_in_rule_IndexExpCS2403: new org.antlr.runtime.BitSet([0x00000002, 0x00000000,0x00400000, 0x00000000]),
    FOLLOW_86_in_rule_IndexExpCS2408: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IndexExpCS2412: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00800000, 0x00000000]),
    FOLLOW_17_in_rule_IndexExpCS2415: new org.antlr.runtime.BitSet([0x00200070, 0x90002200,0x00274031, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IndexExpCS2419: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00800000, 0x00000000]),
    FOLLOW_87_in_rule_IndexExpCS2423: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_IndexExpCS_in_rule_NavigatingExpCS_Base2442: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigatingExpCS_Base_in_rule_NavigatingExpCS2457: new org.antlr.runtime.BitSet([0x00000002, 0x00002000]),
    FOLLOW_45_in_rule_NavigatingExpCS2465: new org.antlr.runtime.BitSet([0x00200070, 0x90006200,0x00274031, 0x00000000]),
    FOLLOW_rule_NavigatingArgCS_in_rule_NavigatingExpCS2470: new org.antlr.runtime.BitSet([0x00022000, 0x00004000,0x00100000, 0x00000000]),
    FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2475: new org.antlr.runtime.BitSet([0x00022000, 0x00004000,0x00100000, 0x00000000]),
    FOLLOW_rule_NavigatingSemiArgCS_in_rule_NavigatingExpCS2485: new org.antlr.runtime.BitSet([0x00020000, 0x00004000,0x00100000, 0x00000000]),
    FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2494: new org.antlr.runtime.BitSet([0x00020000, 0x00004000,0x00100000, 0x00000000]),
    FOLLOW_rule_NavigatingBarArgCS_in_rule_NavigatingExpCS2507: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2512: new org.antlr.runtime.BitSet([0x00020000, 0x00004000]),
    FOLLOW_46_in_rule_NavigatingExpCS2519: new org.antlr.runtime.BitSet([0x00000002, 0x00000000])
});

})();