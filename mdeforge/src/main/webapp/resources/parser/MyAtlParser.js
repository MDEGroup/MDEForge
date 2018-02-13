// $ANTLR 3.3 avr. 19, 2016 01:13:22 E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g 2018-02-12 19:08:28



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

    this.dfa40 = new MyAtlParser.DFA40(this);

         

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

                if ( (LA6_0==35||(LA6_0>=42 && LA6_0<=43)||LA6_0==46||LA6_0==48) ) {
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
            case 48:
                alt8=1;
                break;
            case 35:
                alt8=2;
                break;
            case 42:
            case 43:
                alt8=3;
                break;
            case 46:
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:84:1: rule_MatchedRule : 'rule' name_0= rule_UnrestrictedName '{' 'from' inpattern_1= rule_InPattern ( 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_3= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_4= rule_ActionBlock '}' )? ( ',' )? '}' ;
    // $ANTLR start "rule_MatchedRule"
    rule_MatchedRule: function() {
        var retval = new MyAtlParser.rule_MatchedRule_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal30 = null;
        var char_literal31 = null;
        var string_literal32 = null;
        var string_literal33 = null;
        var char_literal34 = null;
        var char_literal35 = null;
        var string_literal36 = null;
        var string_literal37 = null;
        var char_literal38 = null;
        var string_literal39 = null;
        var char_literal40 = null;
        var char_literal41 = null;
        var char_literal42 = null;
        var char_literal43 = null;
        var list_variables_2=null;
         var name_0 = null;
         var inpattern_1 = null;
         var outpattern_3 = null;
         var actionblock_4 = null;
        var variables_2 = null;
        var string_literal30_tree=null;
        var char_literal31_tree=null;
        var string_literal32_tree=null;
        var string_literal33_tree=null;
        var char_literal34_tree=null;
        var char_literal35_tree=null;
        var string_literal36_tree=null;
        var string_literal37_tree=null;
        var char_literal38_tree=null;
        var string_literal39_tree=null;
        var char_literal40_tree=null;
        var char_literal41_tree=null;
        var char_literal42_tree=null;
        var char_literal43_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:84:18: ( 'rule' name_0= rule_UnrestrictedName '{' 'from' inpattern_1= rule_InPattern ( 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_3= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_4= rule_ActionBlock '}' )? ( ',' )? '}' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:85:2: 'rule' name_0= rule_UnrestrictedName '{' 'from' inpattern_1= rule_InPattern ( 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_3= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_4= rule_ActionBlock '}' )? ( ',' )? '}'
            root_0 = this.adaptor.nil();

            string_literal30=this.match(this.input,35,MyAtlParser.FOLLOW_35_in_rule_MatchedRule335); 
            string_literal30_tree = this.adaptor.create(string_literal30);
            this.adaptor.addChild(root_0, string_literal30_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_MatchedRule339);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            char_literal31=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_MatchedRule341); 
            char_literal31_tree = this.adaptor.create(char_literal31);
            this.adaptor.addChild(root_0, char_literal31_tree);

            string_literal32=this.match(this.input,18,MyAtlParser.FOLLOW_18_in_rule_MatchedRule345); 
            string_literal32_tree = this.adaptor.create(string_literal32);
            this.adaptor.addChild(root_0, string_literal32_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_InPattern_in_rule_MatchedRule351);
            inpattern_1=this.rule_InPattern();

            this.state._fsp--;

            this.adaptor.addChild(root_0, inpattern_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:88:3: ( 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}' )?
            var alt10=2;
            var LA10_0 = this.input.LA(1);

            if ( (LA10_0==37) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:88:4: 'using' '{' (variables_2+= rule_RuleVariableDeclaration )* '}'
                    string_literal33=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_MatchedRule357); 
                    string_literal33_tree = this.adaptor.create(string_literal33);
                    this.adaptor.addChild(root_0, string_literal33_tree);

                    char_literal34=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_MatchedRule359); 
                    char_literal34_tree = this.adaptor.create(char_literal34);
                    this.adaptor.addChild(root_0, char_literal34_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:89:15: (variables_2+= rule_RuleVariableDeclaration )*
                    loop9:
                    do {
                        var alt9=2;
                        var LA9_0 = this.input.LA(1);

                        if ( (LA9_0==SIMPLE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:89:15: variables_2+= rule_RuleVariableDeclaration
                            this.pushFollow(MyAtlParser.FOLLOW_rule_RuleVariableDeclaration_in_rule_MatchedRule367);
                            variables_2=this.rule_RuleVariableDeclaration();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, variables_2.getTree());
                            if (org.antlr.lang.isNull(list_variables_2)) list_variables_2 = [];
                            list_variables_2.push(variables_2.getTree());



                            break;

                        default :
                            break loop9;
                        }
                    } while (true);

                    char_literal35=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_MatchedRule372); 
                    char_literal35_tree = this.adaptor.create(char_literal35);
                    this.adaptor.addChild(root_0, char_literal35_tree);



                    break;

            }

            string_literal36=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_MatchedRule378); 
            string_literal36_tree = this.adaptor.create(string_literal36);
            this.adaptor.addChild(root_0, string_literal36_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_OutPattern_in_rule_MatchedRule384);
            outpattern_3=this.rule_OutPattern();

            this.state._fsp--;

            this.adaptor.addChild(root_0, outpattern_3.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:92:32: ( '...' )?
            var alt11=2;
            var LA11_0 = this.input.LA(1);

            if ( (LA11_0==40) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:92:33: '...'
                    string_literal37=this.match(this.input,40,MyAtlParser.FOLLOW_40_in_rule_MatchedRule387); 
                    string_literal37_tree = this.adaptor.create(string_literal37);
                    this.adaptor.addChild(root_0, string_literal37_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:92:41: ( ',' )?
            var alt12=2;
            var LA12_0 = this.input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:92:42: ','
                    char_literal38=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_MatchedRule392); 
                    char_literal38_tree = this.adaptor.create(char_literal38);
                    this.adaptor.addChild(root_0, char_literal38_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:93:3: ( 'do' '{' actionblock_4= rule_ActionBlock '}' )?
            var alt13=2;
            var LA13_0 = this.input.LA(1);

            if ( (LA13_0==41) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:93:4: 'do' '{' actionblock_4= rule_ActionBlock '}'
                    string_literal39=this.match(this.input,41,MyAtlParser.FOLLOW_41_in_rule_MatchedRule399); 
                    string_literal39_tree = this.adaptor.create(string_literal39);
                    this.adaptor.addChild(root_0, string_literal39_tree);

                    char_literal40=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_MatchedRule401); 
                    char_literal40_tree = this.adaptor.create(char_literal40);
                    this.adaptor.addChild(root_0, char_literal40_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ActionBlock_in_rule_MatchedRule408);
                    actionblock_4=this.rule_ActionBlock();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, actionblock_4.getTree());
                    char_literal41=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_MatchedRule413); 
                    char_literal41_tree = this.adaptor.create(char_literal41);
                    this.adaptor.addChild(root_0, char_literal41_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:98:3: ( ',' )?
            var alt14=2;
            var LA14_0 = this.input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:98:4: ','
                    char_literal42=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_MatchedRule424); 
                    char_literal42_tree = this.adaptor.create(char_literal42);
                    this.adaptor.addChild(root_0, char_literal42_tree);



                    break;

            }

            char_literal43=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_MatchedRule427); 
            char_literal43_tree = this.adaptor.create(char_literal43);
            this.adaptor.addChild(root_0, char_literal43_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:105:1: rule_CalledRule : ( 'entrypoint' | 'endpoint' ) 'rule' name_0= rule_UnrestrictedName ( '(' ')' )? '{' ( 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_2= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_3= rule_ActionBlock '}' )? ( ',' )? '}' ;
    // $ANTLR start "rule_CalledRule"
    rule_CalledRule: function() {
        var retval = new MyAtlParser.rule_CalledRule_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set44 = null;
        var string_literal45 = null;
        var char_literal46 = null;
        var char_literal47 = null;
        var char_literal48 = null;
        var string_literal49 = null;
        var char_literal50 = null;
        var char_literal51 = null;
        var string_literal52 = null;
        var string_literal53 = null;
        var char_literal54 = null;
        var string_literal55 = null;
        var char_literal56 = null;
        var char_literal57 = null;
        var char_literal58 = null;
        var char_literal59 = null;
        var list_variables_1=null;
         var name_0 = null;
         var outpattern_2 = null;
         var actionblock_3 = null;
        var variables_1 = null;
        var set44_tree=null;
        var string_literal45_tree=null;
        var char_literal46_tree=null;
        var char_literal47_tree=null;
        var char_literal48_tree=null;
        var string_literal49_tree=null;
        var char_literal50_tree=null;
        var char_literal51_tree=null;
        var string_literal52_tree=null;
        var string_literal53_tree=null;
        var char_literal54_tree=null;
        var string_literal55_tree=null;
        var char_literal56_tree=null;
        var char_literal57_tree=null;
        var char_literal58_tree=null;
        var char_literal59_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:105:17: ( ( 'entrypoint' | 'endpoint' ) 'rule' name_0= rule_UnrestrictedName ( '(' ')' )? '{' ( 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_2= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_3= rule_ActionBlock '}' )? ( ',' )? '}' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:106:2: ( 'entrypoint' | 'endpoint' ) 'rule' name_0= rule_UnrestrictedName ( '(' ')' )? '{' ( 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}' )? 'to' outpattern_2= rule_OutPattern ( '...' )? ( ',' )? ( 'do' '{' actionblock_3= rule_ActionBlock '}' )? ( ',' )? '}'
            root_0 = this.adaptor.nil();

            set44=this.input.LT(1);
            if ( (this.input.LA(1)>=42 && this.input.LA(1)<=43) ) {
                this.input.consume();
                this.adaptor.addChild(root_0, this.adaptor.create(set44));
                this.state.errorRecovery=false;
            }
            else {
                var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                throw mse;
            }

            string_literal45=this.match(this.input,35,MyAtlParser.FOLLOW_35_in_rule_CalledRule449); 
            string_literal45_tree = this.adaptor.create(string_literal45);
            this.adaptor.addChild(root_0, string_literal45_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_CalledRule453);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:107:2: ( '(' ')' )?
            var alt15=2;
            var LA15_0 = this.input.LA(1);

            if ( (LA15_0==44) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:107:3: '(' ')'
                    char_literal46=this.match(this.input,44,MyAtlParser.FOLLOW_44_in_rule_CalledRule457); 
                    char_literal46_tree = this.adaptor.create(char_literal46);
                    this.adaptor.addChild(root_0, char_literal46_tree);

                    char_literal47=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_CalledRule458); 
                    char_literal47_tree = this.adaptor.create(char_literal47);
                    this.adaptor.addChild(root_0, char_literal47_tree);



                    break;

            }

            char_literal48=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_CalledRule462); 
            char_literal48_tree = this.adaptor.create(char_literal48);
            this.adaptor.addChild(root_0, char_literal48_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:108:3: ( 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}' )?
            var alt17=2;
            var LA17_0 = this.input.LA(1);

            if ( (LA17_0==37) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:108:4: 'using' '{' (variables_1+= rule_RuleVariableDeclaration )* '}'
                    string_literal49=this.match(this.input,37,MyAtlParser.FOLLOW_37_in_rule_CalledRule467); 
                    string_literal49_tree = this.adaptor.create(string_literal49);
                    this.adaptor.addChild(root_0, string_literal49_tree);

                    char_literal50=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_CalledRule469); 
                    char_literal50_tree = this.adaptor.create(char_literal50);
                    this.adaptor.addChild(root_0, char_literal50_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:109:15: (variables_1+= rule_RuleVariableDeclaration )*
                    loop16:
                    do {
                        var alt16=2;
                        var LA16_0 = this.input.LA(1);

                        if ( (LA16_0==SIMPLE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:109:15: variables_1+= rule_RuleVariableDeclaration
                            this.pushFollow(MyAtlParser.FOLLOW_rule_RuleVariableDeclaration_in_rule_CalledRule477);
                            variables_1=this.rule_RuleVariableDeclaration();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, variables_1.getTree());
                            if (org.antlr.lang.isNull(list_variables_1)) list_variables_1 = [];
                            list_variables_1.push(variables_1.getTree());



                            break;

                        default :
                            break loop16;
                        }
                    } while (true);

                    char_literal51=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_CalledRule482); 
                    char_literal51_tree = this.adaptor.create(char_literal51);
                    this.adaptor.addChild(root_0, char_literal51_tree);



                    break;

            }

            string_literal52=this.match(this.input,39,MyAtlParser.FOLLOW_39_in_rule_CalledRule488); 
            string_literal52_tree = this.adaptor.create(string_literal52);
            this.adaptor.addChild(root_0, string_literal52_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_OutPattern_in_rule_CalledRule494);
            outpattern_2=this.rule_OutPattern();

            this.state._fsp--;

            this.adaptor.addChild(root_0, outpattern_2.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:112:32: ( '...' )?
            var alt18=2;
            var LA18_0 = this.input.LA(1);

            if ( (LA18_0==40) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:112:33: '...'
                    string_literal53=this.match(this.input,40,MyAtlParser.FOLLOW_40_in_rule_CalledRule497); 
                    string_literal53_tree = this.adaptor.create(string_literal53);
                    this.adaptor.addChild(root_0, string_literal53_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:112:41: ( ',' )?
            var alt19=2;
            var LA19_0 = this.input.LA(1);

            if ( (LA19_0==17) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:112:42: ','
                    char_literal54=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_CalledRule502); 
                    char_literal54_tree = this.adaptor.create(char_literal54);
                    this.adaptor.addChild(root_0, char_literal54_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:113:3: ( 'do' '{' actionblock_3= rule_ActionBlock '}' )?
            var alt20=2;
            var LA20_0 = this.input.LA(1);

            if ( (LA20_0==41) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:113:4: 'do' '{' actionblock_3= rule_ActionBlock '}'
                    string_literal55=this.match(this.input,41,MyAtlParser.FOLLOW_41_in_rule_CalledRule509); 
                    string_literal55_tree = this.adaptor.create(string_literal55);
                    this.adaptor.addChild(root_0, string_literal55_tree);

                    char_literal56=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_CalledRule511); 
                    char_literal56_tree = this.adaptor.create(char_literal56);
                    this.adaptor.addChild(root_0, char_literal56_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ActionBlock_in_rule_CalledRule518);
                    actionblock_3=this.rule_ActionBlock();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, actionblock_3.getTree());
                    char_literal57=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_CalledRule522); 
                    char_literal57_tree = this.adaptor.create(char_literal57);
                    this.adaptor.addChild(root_0, char_literal57_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:117:3: ( ',' )?
            var alt21=2;
            var LA21_0 = this.input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:117:4: ','
                    char_literal58=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_CalledRule532); 
                    char_literal58_tree = this.adaptor.create(char_literal58);
                    this.adaptor.addChild(root_0, char_literal58_tree);



                    break;

            }

            char_literal59=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_CalledRule535); 
            char_literal59_tree = this.adaptor.create(char_literal59);
            this.adaptor.addChild(root_0, char_literal59_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:122:1: rule_QueryRule : 'query' name_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? '=' initexpression_3= rule_ExpCS ';' ;
    // $ANTLR start "rule_QueryRule"
    rule_QueryRule: function() {
        var retval = new MyAtlParser.rule_QueryRule_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal60 = null;
        var char_literal61 = null;
        var char_literal62 = null;
        var char_literal63 = null;
        var char_literal64 = null;
        var char_literal65 = null;
        var list_parameters_1=null;
        var list_parameters_2=null;
         var name_0 = null;
         var initexpression_3 = null;
        var parameters_1 = null;
        var parameters_2 = null;
        var string_literal60_tree=null;
        var char_literal61_tree=null;
        var char_literal62_tree=null;
        var char_literal63_tree=null;
        var char_literal64_tree=null;
        var char_literal65_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:122:16: ( 'query' name_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? '=' initexpression_3= rule_ExpCS ';' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:123:2: 'query' name_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? '=' initexpression_3= rule_ExpCS ';'
            root_0 = this.adaptor.nil();

            string_literal60=this.match(this.input,46,MyAtlParser.FOLLOW_46_in_rule_QueryRule547); 
            string_literal60_tree = this.adaptor.create(string_literal60);
            this.adaptor.addChild(root_0, string_literal60_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_QueryRule552);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:124:2: ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )?
            var alt24=2;
            var LA24_0 = this.input.LA(1);

            if ( (LA24_0==44) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:124:3: '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')'
                    char_literal61=this.match(this.input,44,MyAtlParser.FOLLOW_44_in_rule_QueryRule557); 
                    char_literal61_tree = this.adaptor.create(char_literal61);
                    this.adaptor.addChild(root_0, char_literal61_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:125:2: (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )?
                    var alt23=2;
                    var LA23_0 = this.input.LA(1);

                    if ( (LA23_0==SIMPLE_ID) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:125:3: parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLParameterCS_in_rule_QueryRule563);
                            parameters_1=this.rule_ATLParameterCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, parameters_1.getTree());
                            if (org.antlr.lang.isNull(list_parameters_1)) list_parameters_1 = [];
                            list_parameters_1.push(parameters_1.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:125:37: ( ',' parameters_2+= rule_ATLParameterCS )*
                            loop22:
                            do {
                                var alt22=2;
                                var LA22_0 = this.input.LA(1);

                                if ( (LA22_0==17) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:125:38: ',' parameters_2+= rule_ATLParameterCS
                                    char_literal62=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_QueryRule566); 
                                    char_literal62_tree = this.adaptor.create(char_literal62);
                                    this.adaptor.addChild(root_0, char_literal62_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_ATLParameterCS_in_rule_QueryRule572);
                                    parameters_2=this.rule_ATLParameterCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, parameters_2.getTree());
                                    if (org.antlr.lang.isNull(list_parameters_2)) list_parameters_2 = [];
                                    list_parameters_2.push(parameters_2.getTree());



                                    break;

                                default :
                                    break loop22;
                                }
                            } while (true);



                            break;

                    }

                    char_literal63=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_QueryRule579); 
                    char_literal63_tree = this.adaptor.create(char_literal63);
                    this.adaptor.addChild(root_0, char_literal63_tree);



                    break;

            }

            char_literal64=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_QueryRule586); 
            char_literal64_tree = this.adaptor.create(char_literal64);
            this.adaptor.addChild(root_0, char_literal64_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_QueryRule590);
            initexpression_3=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, initexpression_3.getTree());
            char_literal65=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_QueryRule592); 
            char_literal65_tree = this.adaptor.create(char_literal65);
            this.adaptor.addChild(root_0, char_literal65_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:145:1: rule_Helper : 'helper' ( 'context' )? (name_0= rule_UnrestrictedName )? definition_1= rule_ATLDefCS ;
    // $ANTLR start "rule_Helper"
    rule_Helper: function() {
        var retval = new MyAtlParser.rule_Helper_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal66 = null;
        var string_literal67 = null;
         var name_0 = null;
         var definition_1 = null;

        var string_literal66_tree=null;
        var string_literal67_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:145:13: ( 'helper' ( 'context' )? (name_0= rule_UnrestrictedName )? definition_1= rule_ATLDefCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:146:2: 'helper' ( 'context' )? (name_0= rule_UnrestrictedName )? definition_1= rule_ATLDefCS
            root_0 = this.adaptor.nil();

            string_literal66=this.match(this.input,48,MyAtlParser.FOLLOW_48_in_rule_Helper611); 
            string_literal66_tree = this.adaptor.create(string_literal66);
            this.adaptor.addChild(root_0, string_literal66_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:146:12: ( 'context' )?
            var alt25=2;
            var LA25_0 = this.input.LA(1);

            if ( (LA25_0==49) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:146:13: 'context'
                    string_literal67=this.match(this.input,49,MyAtlParser.FOLLOW_49_in_rule_Helper615); 
                    string_literal67_tree = this.adaptor.create(string_literal67);
                    this.adaptor.addChild(root_0, string_literal67_tree);



                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:146:25: (name_0= rule_UnrestrictedName )?
            var alt26=2;
            var LA26_0 = this.input.LA(1);

            if ( (LA26_0==SIMPLE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:146:26: name_0= rule_UnrestrictedName
                    this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_Helper622);
                    name_0=this.rule_UnrestrictedName();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, name_0.getTree());


                    break;

            }

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLDefCS_in_rule_Helper631);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:169:1: rule_ATLDefCS : 'def' ':' varname_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? ':' type_3= rule_ATLType '=' initexpression_4= rule_ExpCS ';' ;
    // $ANTLR start "rule_ATLDefCS"
    rule_ATLDefCS: function() {
        var retval = new MyAtlParser.rule_ATLDefCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal68 = null;
        var char_literal69 = null;
        var char_literal70 = null;
        var char_literal71 = null;
        var char_literal72 = null;
        var char_literal73 = null;
        var char_literal74 = null;
        var char_literal75 = null;
        var list_parameters_1=null;
        var list_parameters_2=null;
         var varname_0 = null;
         var type_3 = null;
         var initexpression_4 = null;
        var parameters_1 = null;
        var parameters_2 = null;
        var string_literal68_tree=null;
        var char_literal69_tree=null;
        var char_literal70_tree=null;
        var char_literal71_tree=null;
        var char_literal72_tree=null;
        var char_literal73_tree=null;
        var char_literal74_tree=null;
        var char_literal75_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:169:14: ( 'def' ':' varname_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? ':' type_3= rule_ATLType '=' initexpression_4= rule_ExpCS ';' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:171:2: 'def' ':' varname_0= rule_UnrestrictedName ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )? ':' type_3= rule_ATLType '=' initexpression_4= rule_ExpCS ';'
            root_0 = this.adaptor.nil();

            string_literal68=this.match(this.input,50,MyAtlParser.FOLLOW_50_in_rule_ATLDefCS652); 
            string_literal68_tree = this.adaptor.create(string_literal68);
            this.adaptor.addChild(root_0, string_literal68_tree);

            char_literal69=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_ATLDefCS654); 
            char_literal69_tree = this.adaptor.create(char_literal69);
            this.adaptor.addChild(root_0, char_literal69_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_ATLDefCS658);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:172:2: ( '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')' )?
            var alt29=2;
            var LA29_0 = this.input.LA(1);

            if ( (LA29_0==44) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:172:3: '(' (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )? ')'
                    char_literal70=this.match(this.input,44,MyAtlParser.FOLLOW_44_in_rule_ATLDefCS662); 
                    char_literal70_tree = this.adaptor.create(char_literal70);
                    this.adaptor.addChild(root_0, char_literal70_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:173:2: (parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )* )?
                    var alt28=2;
                    var LA28_0 = this.input.LA(1);

                    if ( (LA28_0==SIMPLE_ID) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:173:3: parameters_1+= rule_ATLParameterCS ( ',' parameters_2+= rule_ATLParameterCS )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLParameterCS_in_rule_ATLDefCS668);
                            parameters_1=this.rule_ATLParameterCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, parameters_1.getTree());
                            if (org.antlr.lang.isNull(list_parameters_1)) list_parameters_1 = [];
                            list_parameters_1.push(parameters_1.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:173:37: ( ',' parameters_2+= rule_ATLParameterCS )*
                            loop27:
                            do {
                                var alt27=2;
                                var LA27_0 = this.input.LA(1);

                                if ( (LA27_0==17) ) {
                                    alt27=1;
                                }


                                switch (alt27) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:173:38: ',' parameters_2+= rule_ATLParameterCS
                                    char_literal71=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_ATLDefCS671); 
                                    char_literal71_tree = this.adaptor.create(char_literal71);
                                    this.adaptor.addChild(root_0, char_literal71_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_ATLParameterCS_in_rule_ATLDefCS677);
                                    parameters_2=this.rule_ATLParameterCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, parameters_2.getTree());
                                    if (org.antlr.lang.isNull(list_parameters_2)) list_parameters_2 = [];
                                    list_parameters_2.push(parameters_2.getTree());



                                    break;

                                default :
                                    break loop27;
                                }
                            } while (true);



                            break;

                    }

                    char_literal72=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_ATLDefCS684); 
                    char_literal72_tree = this.adaptor.create(char_literal72);
                    this.adaptor.addChild(root_0, char_literal72_tree);



                    break;

            }

            char_literal73=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_ATLDefCS689); 
            char_literal73_tree = this.adaptor.create(char_literal73);
            this.adaptor.addChild(root_0, char_literal73_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_ATLDefCS693);
            type_3=this.rule_ATLType();

            this.state._fsp--;

            this.adaptor.addChild(root_0, type_3.getTree());
            char_literal74=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_ATLDefCS696); 
            char_literal74_tree = this.adaptor.create(char_literal74);
            this.adaptor.addChild(root_0, char_literal74_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_ATLDefCS700);
            initexpression_4=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, initexpression_4.getTree());
            char_literal75=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_ATLDefCS702); 
            char_literal75_tree = this.adaptor.create(char_literal75);
            this.adaptor.addChild(root_0, char_literal75_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:186:1: rule_ATLParameterCS : varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ;
    // $ANTLR start "rule_ATLParameterCS"
    rule_ATLParameterCS: function() {
        var retval = new MyAtlParser.rule_ATLParameterCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal76 = null;
         var varname_0 = null;
         var type_1 = null;

        var char_literal76_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:186:20: (varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:188:2: varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_ATLParameterCS720);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            char_literal76=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_ATLParameterCS722); 
            char_literal76_tree = this.adaptor.create(char_literal76);
            this.adaptor.addChild(root_0, char_literal76_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_ATLParameterCS726);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:196:1: rule_RuleVariableDeclaration : varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType '=' initexpression_2= rule_ExpCS ';' ;
    // $ANTLR start "rule_RuleVariableDeclaration"
    rule_RuleVariableDeclaration: function() {
        var retval = new MyAtlParser.rule_RuleVariableDeclaration_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal77 = null;
        var char_literal78 = null;
        var char_literal79 = null;
         var varname_0 = null;
         var type_1 = null;
         var initexpression_2 = null;

        var char_literal77_tree=null;
        var char_literal78_tree=null;
        var char_literal79_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:196:29: (varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType '=' initexpression_2= rule_ExpCS ';' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:197:3: varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType '=' initexpression_2= rule_ExpCS ';'
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_RuleVariableDeclaration743);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            char_literal77=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_RuleVariableDeclaration745); 
            char_literal77_tree = this.adaptor.create(char_literal77);
            this.adaptor.addChild(root_0, char_literal77_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_RuleVariableDeclaration749);
            type_1=this.rule_ATLType();

            this.state._fsp--;

            this.adaptor.addChild(root_0, type_1.getTree());
            char_literal78=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_RuleVariableDeclaration754); 
            char_literal78_tree = this.adaptor.create(char_literal78);
            this.adaptor.addChild(root_0, char_literal78_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_RuleVariableDeclaration758);
            initexpression_2=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, initexpression_2.getTree());
            char_literal79=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_RuleVariableDeclaration760); 
            char_literal79_tree = this.adaptor.create(char_literal79);
            this.adaptor.addChild(root_0, char_literal79_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:206:1: rule_InPattern : elements_0+= rule_InPatternElement ( '(' (filter_1= rule_ExpCS )? ')' )? ;
    // $ANTLR start "rule_InPattern"
    rule_InPattern: function() {
        var retval = new MyAtlParser.rule_InPattern_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal80 = null;
        var char_literal81 = null;
        var list_elements_0=null;
         var filter_1 = null;
        var elements_0 = null;
        var char_literal80_tree=null;
        var char_literal81_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:206:15: (elements_0+= rule_InPatternElement ( '(' (filter_1= rule_ExpCS )? ')' )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:207:2: elements_0+= rule_InPatternElement ( '(' (filter_1= rule_ExpCS )? ')' )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_InPatternElement_in_rule_InPattern776);
            elements_0=this.rule_InPatternElement();

            this.state._fsp--;

            this.adaptor.addChild(root_0, elements_0.getTree());
            if (org.antlr.lang.isNull(list_elements_0)) list_elements_0 = [];
            list_elements_0.push(elements_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:207:36: ( '(' (filter_1= rule_ExpCS )? ')' )?
            var alt31=2;
            var LA31_0 = this.input.LA(1);

            if ( (LA31_0==44) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:207:37: '(' (filter_1= rule_ExpCS )? ')'
                    char_literal80=this.match(this.input,44,MyAtlParser.FOLLOW_44_in_rule_InPattern779); 
                    char_literal80_tree = this.adaptor.create(char_literal80);
                    this.adaptor.addChild(root_0, char_literal80_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:208:10: (filter_1= rule_ExpCS )?
                    var alt30=2;
                    var LA30_0 = this.input.LA(1);

                    if ( ((LA30_0>=SIMPLE_ID && LA30_0<=BIG_INT)||LA30_0==21||LA30_0==40||LA30_0==44||LA30_0==59||(LA30_0>=62 && LA30_0<=63)||(LA30_0>=67 && LA30_0<=68)||LA30_0==77||(LA30_0>=79 && LA30_0<=81)||LA30_0==84) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:208:10: filter_1= rule_ExpCS
                            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_InPattern784);
                            filter_1=this.rule_ExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, filter_1.getTree());


                            break;

                    }

                    char_literal81=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_InPattern788); 
                    char_literal81_tree = this.adaptor.create(char_literal81);
                    this.adaptor.addChild(root_0, char_literal81_tree);



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:216:1: rule_InPatternElement : varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ;
    // $ANTLR start "rule_InPatternElement"
    rule_InPatternElement: function() {
        var retval = new MyAtlParser.rule_InPatternElement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal82 = null;
         var varname_0 = null;
         var type_1 = null;

        var char_literal82_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:216:24: (varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:217:2: varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_InPatternElement807);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            char_literal82=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_InPatternElement809); 
            char_literal82_tree = this.adaptor.create(char_literal82);
            this.adaptor.addChild(root_0, char_literal82_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_InPatternElement813);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:224:1: rule_OutPattern : elements_0+= rule_OutPatternElement ( ',' elements_1+= rule_OutPatternElement )* ;
    // $ANTLR start "rule_OutPattern"
    rule_OutPattern: function() {
        var retval = new MyAtlParser.rule_OutPattern_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal83 = null;
        var list_elements_0=null;
        var list_elements_1=null;
        var elements_0 = null;
        var elements_1 = null;
        var char_literal83_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:224:16: (elements_0+= rule_OutPatternElement ( ',' elements_1+= rule_OutPatternElement )* )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:225:2: elements_0+= rule_OutPatternElement ( ',' elements_1+= rule_OutPatternElement )*
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_OutPatternElement_in_rule_OutPattern828);
            elements_0=this.rule_OutPatternElement();

            this.state._fsp--;

            this.adaptor.addChild(root_0, elements_0.getTree());
            if (org.antlr.lang.isNull(list_elements_0)) list_elements_0 = [];
            list_elements_0.push(elements_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:225:37: ( ',' elements_1+= rule_OutPatternElement )*
            loop32:
            do {
                var alt32=2;
                var LA32_0 = this.input.LA(1);

                if ( (LA32_0==17) ) {
                    var LA32_2 = this.input.LA(2);

                    if ( (LA32_2==SIMPLE_ID||LA32_2==51) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:225:38: ',' elements_1+= rule_OutPatternElement
                    char_literal83=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_OutPattern831); 
                    char_literal83_tree = this.adaptor.create(char_literal83);
                    this.adaptor.addChild(root_0, char_literal83_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_OutPatternElement_in_rule_OutPattern837);
                    elements_1=this.rule_OutPatternElement();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, elements_1.getTree());
                    if (org.antlr.lang.isNull(list_elements_1)) list_elements_1 = [];
                    list_elements_1.push(elements_1.getTree());



                    break;

                default :
                    break loop32;
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:233:1: rule_OutPatternElement : ( rule_SimpleOutPatternElement | rule_ForEachOutPatternElement );
    // $ANTLR start "rule_OutPatternElement"
    rule_OutPatternElement: function() {
        var retval = new MyAtlParser.rule_OutPatternElement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_SimpleOutPatternElement84 = null;
         var rule_ForEachOutPatternElement85 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:233:23: ( rule_SimpleOutPatternElement | rule_ForEachOutPatternElement )
            var alt33=2;
            var LA33_0 = this.input.LA(1);

            if ( (LA33_0==SIMPLE_ID) ) {
                alt33=1;
            }
            else if ( (LA33_0==51) ) {
                alt33=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 33, 0, this.input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:234:2: rule_SimpleOutPatternElement
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_SimpleOutPatternElement_in_rule_OutPatternElement852);
                    rule_SimpleOutPatternElement84=this.rule_SimpleOutPatternElement();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_SimpleOutPatternElement84.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:234:33: rule_ForEachOutPatternElement
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ForEachOutPatternElement_in_rule_OutPatternElement856);
                    rule_ForEachOutPatternElement85=this.rule_ForEachOutPatternElement();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_ForEachOutPatternElement85.getTree());


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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:240:1: rule_SimpleOutPatternElement : varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ( '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')' )? ;
    // $ANTLR start "rule_SimpleOutPatternElement"
    rule_SimpleOutPatternElement: function() {
        var retval = new MyAtlParser.rule_SimpleOutPatternElement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal86 = null;
        var char_literal87 = null;
        var char_literal88 = null;
        var char_literal89 = null;
        var list_bindings_2=null;
        var list_bindings_3=null;
         var varname_0 = null;
         var type_1 = null;
        var bindings_2 = null;
        var bindings_3 = null;
        var char_literal86_tree=null;
        var char_literal87_tree=null;
        var char_literal88_tree=null;
        var char_literal89_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:240:30: (varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ( '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')' )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:241:2: varname_0= rule_UnrestrictedName ':' type_1= rule_ATLType ( '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')' )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_SimpleOutPatternElement871);
            varname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, varname_0.getTree());
            char_literal86=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_SimpleOutPatternElement873); 
            char_literal86_tree = this.adaptor.create(char_literal86);
            this.adaptor.addChild(root_0, char_literal86_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ATLType_in_rule_SimpleOutPatternElement877);
            type_1=this.rule_ATLType();

            this.state._fsp--;

            this.adaptor.addChild(root_0, type_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:242:2: ( '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')' )?
            var alt36=2;
            var LA36_0 = this.input.LA(1);

            if ( (LA36_0==44) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:242:3: '(' (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )? ')'
                    char_literal87=this.match(this.input,44,MyAtlParser.FOLLOW_44_in_rule_SimpleOutPatternElement881); 
                    char_literal87_tree = this.adaptor.create(char_literal87);
                    this.adaptor.addChild(root_0, char_literal87_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:243:3: (bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )* )?
                    var alt35=2;
                    var LA35_0 = this.input.LA(1);

                    if ( (LA35_0==SIMPLE_ID) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:243:4: bindings_2+= rule_Binding ( ',' bindings_3+= rule_Binding )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_Binding_in_rule_SimpleOutPatternElement888);
                            bindings_2=this.rule_Binding();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, bindings_2.getTree());
                            if (org.antlr.lang.isNull(list_bindings_2)) list_bindings_2 = [];
                            list_bindings_2.push(bindings_2.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:243:29: ( ',' bindings_3+= rule_Binding )*
                            loop34:
                            do {
                                var alt34=2;
                                var LA34_0 = this.input.LA(1);

                                if ( (LA34_0==17) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:243:30: ',' bindings_3+= rule_Binding
                                    char_literal88=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_SimpleOutPatternElement891); 
                                    char_literal88_tree = this.adaptor.create(char_literal88);
                                    this.adaptor.addChild(root_0, char_literal88_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_Binding_in_rule_SimpleOutPatternElement895);
                                    bindings_3=this.rule_Binding();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, bindings_3.getTree());
                                    if (org.antlr.lang.isNull(list_bindings_3)) list_bindings_3 = [];
                                    list_bindings_3.push(bindings_3.getTree());



                                    break;

                                default :
                                    break loop34;
                                }
                            } while (true);



                            break;

                    }

                    char_literal89=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_SimpleOutPatternElement902); 
                    char_literal89_tree = this.adaptor.create(char_literal89);
                    this.adaptor.addChild(root_0, char_literal89_tree);



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:251:1: rule_ForEachOutPatternElement : 'xxx' collection_0= rule_ExpCS 'yyy' ;
    // $ANTLR start "rule_ForEachOutPatternElement"
    rule_ForEachOutPatternElement: function() {
        var retval = new MyAtlParser.rule_ForEachOutPatternElement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal90 = null;
        var string_literal91 = null;
         var collection_0 = null;

        var string_literal90_tree=null;
        var string_literal91_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:251:30: ( 'xxx' collection_0= rule_ExpCS 'yyy' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:252:2: 'xxx' collection_0= rule_ExpCS 'yyy'
            root_0 = this.adaptor.nil();

            string_literal90=this.match(this.input,51,MyAtlParser.FOLLOW_51_in_rule_ForEachOutPatternElement917); 
            string_literal90_tree = this.adaptor.create(string_literal90);
            this.adaptor.addChild(root_0, string_literal90_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_ForEachOutPatternElement924);
            collection_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, collection_0.getTree());
            string_literal91=this.match(this.input,52,MyAtlParser.FOLLOW_52_in_rule_ForEachOutPatternElement927); 
            string_literal91_tree = this.adaptor.create(string_literal91);
            this.adaptor.addChild(root_0, string_literal91_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:259:1: rule_Binding : propertyname_0= rule_UnrestrictedName '<-' value_1= rule_ExpCS ;
    // $ANTLR start "rule_Binding"
    rule_Binding: function() {
        var retval = new MyAtlParser.rule_Binding_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal92 = null;
         var propertyname_0 = null;
         var value_1 = null;

        var string_literal92_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:259:13: (propertyname_0= rule_UnrestrictedName '<-' value_1= rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:260:2: propertyname_0= rule_UnrestrictedName '<-' value_1= rule_ExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_Binding940);
            propertyname_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, propertyname_0.getTree());
            string_literal92=this.match(this.input,53,MyAtlParser.FOLLOW_53_in_rule_Binding942); 
            string_literal92_tree = this.adaptor.create(string_literal92);
            this.adaptor.addChild(root_0, string_literal92_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_Binding946);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:268:1: rule_ActionBlock : (statements_0+= rule_Statement )+ ;
    // $ANTLR start "rule_ActionBlock"
    rule_ActionBlock: function() {
        var retval = new MyAtlParser.rule_ActionBlock_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var list_statements_0=null;
        var statements_0 = null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:268:17: ( (statements_0+= rule_Statement )+ )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:269:2: (statements_0+= rule_Statement )+
            root_0 = this.adaptor.nil();

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:269:14: (statements_0+= rule_Statement )+
            var cnt37=0;
            loop37:
            do {
                var alt37=2;
                var LA37_0 = this.input.LA(1);

                if ( ((LA37_0>=SIMPLE_ID && LA37_0<=BIG_INT)||LA37_0==21||LA37_0==40||LA37_0==44||LA37_0==59||(LA37_0>=62 && LA37_0<=63)||(LA37_0>=67 && LA37_0<=68)||LA37_0==77||(LA37_0>=79 && LA37_0<=81)||LA37_0==84) ) {
                    alt37=1;
                }


                switch (alt37) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:269:14: statements_0+= rule_Statement
                    this.pushFollow(MyAtlParser.FOLLOW_rule_Statement_in_rule_ActionBlock962);
                    statements_0=this.rule_Statement();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, statements_0.getTree());
                    if (org.antlr.lang.isNull(list_statements_0)) list_statements_0 = [];
                    list_statements_0.push(statements_0.getTree());



                    break;

                default :
                    if ( cnt37 >= 1 ) {
                        break loop37;
                    }
                        var eee = new org.antlr.runtime.EarlyExitException(37, this.input);
                        throw eee;
                }
                cnt37++;
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:276:1: rule_Statement : rule_BindingStat ;
    // $ANTLR start "rule_Statement"
    rule_Statement: function() {
        var retval = new MyAtlParser.rule_Statement_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_BindingStat93 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:276:15: ( rule_BindingStat )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:277:2: rule_BindingStat
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_BindingStat_in_rule_Statement976);
            rule_BindingStat93=this.rule_BindingStat();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_BindingStat93.getTree());



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:284:1: rule_BindingStat : source_0= rule_ExpCS '.' propertyname_1= rule_UnrestrictedName '<-' value_2= rule_ExpCS ';' ;
    // $ANTLR start "rule_BindingStat"
    rule_BindingStat: function() {
        var retval = new MyAtlParser.rule_BindingStat_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal94 = null;
        var string_literal95 = null;
        var char_literal96 = null;
         var source_0 = null;
         var propertyname_1 = null;
         var value_2 = null;

        var char_literal94_tree=null;
        var string_literal95_tree=null;
        var char_literal96_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:284:17: (source_0= rule_ExpCS '.' propertyname_1= rule_UnrestrictedName '<-' value_2= rule_ExpCS ';' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:285:2: source_0= rule_ExpCS '.' propertyname_1= rule_UnrestrictedName '<-' value_2= rule_ExpCS ';'
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_BindingStat991);
            source_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, source_0.getTree());
            char_literal94=this.match(this.input,54,MyAtlParser.FOLLOW_54_in_rule_BindingStat993); 
            char_literal94_tree = this.adaptor.create(char_literal94);
            this.adaptor.addChild(root_0, char_literal94_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_BindingStat999);
            propertyname_1=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, propertyname_1.getTree());
            string_literal95=this.match(this.input,53,MyAtlParser.FOLLOW_53_in_rule_BindingStat1001); 
            string_literal95_tree = this.adaptor.create(string_literal95);
            this.adaptor.addChild(root_0, string_literal95_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_BindingStat1006);
            value_2=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, value_2.getTree());
            char_literal96=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_BindingStat1008); 
            char_literal96_tree = this.adaptor.create(char_literal96);
            this.adaptor.addChild(root_0, char_literal96_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:293:1: rule_ATLType : (modelname_0= rule_ATLModelName '!' )? type_1= rule_TypeExpCS ;
    // $ANTLR start "rule_ATLType"
    rule_ATLType: function() {
        var retval = new MyAtlParser.rule_ATLType_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal97 = null;
         var modelname_0 = null;
         var type_1 = null;

        var char_literal97_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:293:14: ( (modelname_0= rule_ATLModelName '!' )? type_1= rule_TypeExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:294:2: (modelname_0= rule_ATLModelName '!' )? type_1= rule_TypeExpCS
            root_0 = this.adaptor.nil();

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:294:2: (modelname_0= rule_ATLModelName '!' )?
            var alt38=2;
            var LA38_0 = this.input.LA(1);

            if ( (LA38_0==SIMPLE_ID) ) {
                var LA38_1 = this.input.LA(2);

                if ( (LA38_1==55) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:294:3: modelname_0= rule_ATLModelName '!'
                    this.pushFollow(MyAtlParser.FOLLOW_rule_ATLModelName_in_rule_ATLType1026);
                    modelname_0=this.rule_ATLModelName();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, modelname_0.getTree());
                    char_literal97=this.match(this.input,55,MyAtlParser.FOLLOW_55_in_rule_ATLType1028); 
                    char_literal97_tree = this.adaptor.create(char_literal97);
                    this.adaptor.addChild(root_0, char_literal97_tree);



                    break;

            }

            this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_ATLType1036);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:301:1: rule_ATLModelName : rule_UnrestrictedName ;
    // $ANTLR start "rule_ATLModelName"
    rule_ATLModelName: function() {
        var retval = new MyAtlParser.rule_ATLModelName_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_UnrestrictedName98 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:301:19: ( rule_UnrestrictedName )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:302:2: rule_UnrestrictedName
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_ATLModelName1050);
            rule_UnrestrictedName98=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_UnrestrictedName98.getTree());



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:308:1: rule_EssentialOCLRersevedKeyword : ( 'and' | 'else' | 'endif' | 'if' | 'implies' | 'in' | 'let' | 'not' | 'or' | 'then' | 'xor' );
    // $ANTLR start "rule_EssentialOCLRersevedKeyword"
    rule_EssentialOCLRersevedKeyword: function() {
        var retval = new MyAtlParser.rule_EssentialOCLRersevedKeyword_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set99 = null;

        var set99_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:308:33: ( 'and' | 'else' | 'endif' | 'if' | 'implies' | 'in' | 'let' | 'not' | 'or' | 'then' | 'xor' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set99=this.input.LT(1);
            if ( (this.input.LA(1)>=56 && this.input.LA(1)<=66) ) {
                this.input.consume();
                this.adaptor.addChild(root_0, this.adaptor.create(set99));
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:316:1: rule_EssentialOCLPrefixOperator : ( '-' | 'not' );
    // $ANTLR start "rule_EssentialOCLPrefixOperator"
    rule_EssentialOCLPrefixOperator: function() {
        var retval = new MyAtlParser.rule_EssentialOCLPrefixOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set100 = null;

        var set100_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:316:32: ( '-' | 'not' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set100=this.input.LT(1);
            if ( this.input.LA(1)==63||this.input.LA(1)==67 ) {
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
    rule_EssentialOCLInfixOperator_return: (function() {
        MyAtlParser.rule_EssentialOCLInfixOperator_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_EssentialOCLInfixOperator_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:324:1: rule_EssentialOCLInfixOperator : ( '*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'or' | 'xor' | 'implies' );
    // $ANTLR start "rule_EssentialOCLInfixOperator"
    rule_EssentialOCLInfixOperator: function() {
        var retval = new MyAtlParser.rule_EssentialOCLInfixOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set101 = null;

        var set101_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:324:31: ( '*' | '/' | '+' | '-' | '>' | '<' | '>=' | '<=' | '=' | '<>' | 'and' | 'or' | 'xor' | 'implies' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set101=this.input.LT(1);
            if ( this.input.LA(1)==47||this.input.LA(1)==56||this.input.LA(1)==60||this.input.LA(1)==64||(this.input.LA(1)>=66 && this.input.LA(1)<=75) ) {
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
    rule_EssentialOCLNavigationOperator_return: (function() {
        MyAtlParser.rule_EssentialOCLNavigationOperator_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_EssentialOCLNavigationOperator_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:332:1: rule_EssentialOCLNavigationOperator : ( '.' | '->' );
    // $ANTLR start "rule_EssentialOCLNavigationOperator"
    rule_EssentialOCLNavigationOperator: function() {
        var retval = new MyAtlParser.rule_EssentialOCLNavigationOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set102 = null;

        var set102_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:332:36: ( '.' | '->' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:
            root_0 = this.adaptor.nil();

            set102=this.input.LT(1);
            if ( this.input.LA(1)==54||this.input.LA(1)==76 ) {
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
    rule_StringLiteral_return: (function() {
        MyAtlParser.rule_StringLiteral_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_StringLiteral_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:340:1: rule_StringLiteral : SINGLE_QUOTED_STRING ;
    // $ANTLR start "rule_StringLiteral"
    rule_StringLiteral: function() {
        var retval = new MyAtlParser.rule_StringLiteral_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var SINGLE_QUOTED_STRING103 = null;

        var SINGLE_QUOTED_STRING103_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:340:19: ( SINGLE_QUOTED_STRING )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:341:2: SINGLE_QUOTED_STRING
            root_0 = this.adaptor.nil();

            SINGLE_QUOTED_STRING103=this.match(this.input,SINGLE_QUOTED_STRING,MyAtlParser.FOLLOW_SINGLE_QUOTED_STRING_in_rule_StringLiteral1216); 
            SINGLE_QUOTED_STRING103_tree = this.adaptor.create(SINGLE_QUOTED_STRING103);
            this.adaptor.addChild(root_0, SINGLE_QUOTED_STRING103_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:348:1: rule_PrefixOperator : rule_EssentialOCLPrefixOperator ;
    // $ANTLR start "rule_PrefixOperator"
    rule_PrefixOperator: function() {
        var retval = new MyAtlParser.rule_PrefixOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_EssentialOCLPrefixOperator104 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:348:20: ( rule_EssentialOCLPrefixOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:349:2: rule_EssentialOCLPrefixOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_EssentialOCLPrefixOperator_in_rule_PrefixOperator1229);
            rule_EssentialOCLPrefixOperator104=this.rule_EssentialOCLPrefixOperator();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_EssentialOCLPrefixOperator104.getTree());



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:354:1: rule_InfixOperator : rule_EssentialOCLInfixOperator ;
    // $ANTLR start "rule_InfixOperator"
    rule_InfixOperator: function() {
        var retval = new MyAtlParser.rule_InfixOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_EssentialOCLInfixOperator105 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:354:19: ( rule_EssentialOCLInfixOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:355:2: rule_EssentialOCLInfixOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_EssentialOCLInfixOperator_in_rule_InfixOperator1240);
            rule_EssentialOCLInfixOperator105=this.rule_EssentialOCLInfixOperator();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_EssentialOCLInfixOperator105.getTree());



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:361:1: rule_NavigationOperator : rule_EssentialOCLNavigationOperator ;
    // $ANTLR start "rule_NavigationOperator"
    rule_NavigationOperator: function() {
        var retval = new MyAtlParser.rule_NavigationOperator_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_EssentialOCLNavigationOperator106 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:361:24: ( rule_EssentialOCLNavigationOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:362:2: rule_EssentialOCLNavigationOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_EssentialOCLNavigationOperator_in_rule_NavigationOperator1252);
            rule_EssentialOCLNavigationOperator106=this.rule_EssentialOCLNavigationOperator();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_EssentialOCLNavigationOperator106.getTree());



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:369:1: rule_CollectionTypeCS : name_0= rule_CollectionTypeIdentifier ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )? ;
    // $ANTLR start "rule_CollectionTypeCS"
    rule_CollectionTypeCS: function() {
        var retval = new MyAtlParser.rule_CollectionTypeCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var set107 = null;
        var set108 = null;
        var char_literal109 = null;
        var char_literal110 = null;
         var name_0 = null;
         var ownedtype_1 = null;
         var ownedtype_2 = null;

        var set107_tree=null;
        var set108_tree=null;
        var char_literal109_tree=null;
        var char_literal110_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:369:23: (name_0= rule_CollectionTypeIdentifier ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:2: name_0= rule_CollectionTypeIdentifier ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionTypeIdentifier_in_rule_CollectionTypeCS1268);
            name_0=this.rule_CollectionTypeIdentifier();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:39: ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )?
            var alt40=3;
            alt40 = this.dfa40.predict(this.input);
            switch (alt40) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:40: ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:40: ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:41: ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' )
                    set107=this.input.LT(1);
                    if ( this.input.LA(1)==36||this.input.LA(1)==44 ) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set107));
                        this.state.errorRecovery=false;
                    }
                    else {
                        var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                        throw mse;
                    }

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:53: (ownedtype_1= rule_TypeExpCS )?
                    var alt39=2;
                    var LA39_0 = this.input.LA(1);

                    if ( (LA39_0==SIMPLE_ID||(LA39_0>=21 && LA39_0<=34)) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:370:54: ownedtype_1= rule_TypeExpCS
                            this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_CollectionTypeCS1283);
                            ownedtype_1=this.rule_TypeExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedtype_1.getTree());


                            break;

                    }

                    set108=this.input.LT(1);
                    if ( this.input.LA(1)==38||this.input.LA(1)==45 ) {
                        this.input.consume();
                        this.adaptor.addChild(root_0, this.adaptor.create(set108));
                        this.state.errorRecovery=false;
                    }
                    else {
                        var mse = new org.antlr.runtime.MismatchedSetException(null,this.input);
                        throw mse;
                    }






                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:371:5: ( '<' ownedtype_2= rule_TypeExpCS '>' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:371:5: ( '<' ownedtype_2= rule_TypeExpCS '>' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:371:6: '<' ownedtype_2= rule_TypeExpCS '>'
                    char_literal109=this.match(this.input,72,MyAtlParser.FOLLOW_72_in_rule_CollectionTypeCS1301); 
                    char_literal109_tree = this.adaptor.create(char_literal109);
                    this.adaptor.addChild(root_0, char_literal109_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_CollectionTypeCS1305);
                    ownedtype_2=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_2.getTree());
                    char_literal110=this.match(this.input,71,MyAtlParser.FOLLOW_71_in_rule_CollectionTypeCS1307); 
                    char_literal110_tree = this.adaptor.create(char_literal110);
                    this.adaptor.addChild(root_0, char_literal110_tree);






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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:380:1: rule_TupleTypeCS : name_0= 'Tuple' ( ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' ) | ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' ) )? backtrack_5= 'true' ;
    // $ANTLR start "rule_TupleTypeCS"
    rule_TupleTypeCS: function() {
        var retval = new MyAtlParser.rule_TupleTypeCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var name_0 = null;
        var backtrack_5 = null;
        var char_literal111 = null;
        var char_literal112 = null;
        var char_literal113 = null;
        var char_literal114 = null;
        var char_literal115 = null;
        var char_literal116 = null;
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
        var char_literal111_tree=null;
        var char_literal112_tree=null;
        var char_literal113_tree=null;
        var char_literal114_tree=null;
        var char_literal115_tree=null;
        var char_literal116_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:380:17: (name_0= 'Tuple' ( ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' ) | ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' ) )? backtrack_5= 'true' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:381:2: name_0= 'Tuple' ( ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' ) | ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' ) )? backtrack_5= 'true'
            root_0 = this.adaptor.nil();

            name_0=this.match(this.input,21,MyAtlParser.FOLLOW_21_in_rule_TupleTypeCS1331); 
            name_0_tree = this.adaptor.create(name_0);
            this.adaptor.addChild(root_0, name_0_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:2: ( ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' ) | ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' ) )?
            var alt45=3;
            var LA45_0 = this.input.LA(1);

            if ( (LA45_0==44) ) {
                alt45=1;
            }
            else if ( (LA45_0==72) ) {
                alt45=2;
            }
            switch (alt45) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:3: ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:3: ( '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:4: '(' (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )? ')'
                    char_literal111=this.match(this.input,44,MyAtlParser.FOLLOW_44_in_rule_TupleTypeCS1336); 
                    char_literal111_tree = this.adaptor.create(char_literal111);
                    this.adaptor.addChild(root_0, char_literal111_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:8: (ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )* )?
                    var alt42=2;
                    var LA42_0 = this.input.LA(1);

                    if ( (LA42_0==SIMPLE_ID) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:9: ownedparts_1+= rule_TuplePartCS ( ',' ownedparts_2+= rule_TuplePartCS )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1341);
                            ownedparts_1=this.rule_TuplePartCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedparts_1.getTree());
                            if (org.antlr.lang.isNull(list_ownedparts_1)) list_ownedparts_1 = [];
                            list_ownedparts_1.push(ownedparts_1.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:40: ( ',' ownedparts_2+= rule_TuplePartCS )*
                            loop41:
                            do {
                                var alt41=2;
                                var LA41_0 = this.input.LA(1);

                                if ( (LA41_0==17) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:382:41: ',' ownedparts_2+= rule_TuplePartCS
                                    char_literal112=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_TupleTypeCS1344); 
                                    char_literal112_tree = this.adaptor.create(char_literal112);
                                    this.adaptor.addChild(root_0, char_literal112_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1348);
                                    ownedparts_2=this.rule_TuplePartCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, ownedparts_2.getTree());
                                    if (org.antlr.lang.isNull(list_ownedparts_2)) list_ownedparts_2 = [];
                                    list_ownedparts_2.push(ownedparts_2.getTree());



                                    break;

                                default :
                                    break loop41;
                                }
                            } while (true);



                            break;

                    }

                    char_literal113=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_TupleTypeCS1354); 
                    char_literal113_tree = this.adaptor.create(char_literal113);
                    this.adaptor.addChild(root_0, char_literal113_tree);






                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:383:5: ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:383:5: ( '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>' )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:383:6: '<' (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )? '>'
                    char_literal114=this.match(this.input,72,MyAtlParser.FOLLOW_72_in_rule_TupleTypeCS1362); 
                    char_literal114_tree = this.adaptor.create(char_literal114);
                    this.adaptor.addChild(root_0, char_literal114_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:383:10: (ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )* )?
                    var alt44=2;
                    var LA44_0 = this.input.LA(1);

                    if ( (LA44_0==SIMPLE_ID) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:383:11: ownedparts_3+= rule_TuplePartCS ( ',' ownedparts_4+= rule_TuplePartCS )*
                            this.pushFollow(MyAtlParser.FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1367);
                            ownedparts_3=this.rule_TuplePartCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedparts_3.getTree());
                            if (org.antlr.lang.isNull(list_ownedparts_3)) list_ownedparts_3 = [];
                            list_ownedparts_3.push(ownedparts_3.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:383:42: ( ',' ownedparts_4+= rule_TuplePartCS )*
                            loop43:
                            do {
                                var alt43=2;
                                var LA43_0 = this.input.LA(1);

                                if ( (LA43_0==17) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:383:43: ',' ownedparts_4+= rule_TuplePartCS
                                    char_literal115=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_TupleTypeCS1370); 
                                    char_literal115_tree = this.adaptor.create(char_literal115);
                                    this.adaptor.addChild(root_0, char_literal115_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1374);
                                    ownedparts_4=this.rule_TuplePartCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, ownedparts_4.getTree());
                                    if (org.antlr.lang.isNull(list_ownedparts_4)) list_ownedparts_4 = [];
                                    list_ownedparts_4.push(ownedparts_4.getTree());



                                    break;

                                default :
                                    break loop43;
                                }
                            } while (true);



                            break;

                    }

                    char_literal116=this.match(this.input,71,MyAtlParser.FOLLOW_71_in_rule_TupleTypeCS1379); 
                    char_literal116_tree = this.adaptor.create(char_literal116);
                    this.adaptor.addChild(root_0, char_literal116_tree);






                    break;

            }

            backtrack_5=this.match(this.input,77,MyAtlParser.FOLLOW_77_in_rule_TupleTypeCS1389); 
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:391:1: rule_TuplePartCS : name_0= rule_UnrestrictedName ':' ownedtype_1= rule_TypeExpCS ;
    // $ANTLR start "rule_TuplePartCS"
    rule_TuplePartCS: function() {
        var retval = new MyAtlParser.rule_TuplePartCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal117 = null;
         var name_0 = null;
         var ownedtype_1 = null;

        var char_literal117_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:391:17: (name_0= rule_UnrestrictedName ':' ownedtype_1= rule_TypeExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:392:2: name_0= rule_UnrestrictedName ':' ownedtype_1= rule_TypeExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_TuplePartCS1405);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            char_literal117=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_TuplePartCS1407); 
            char_literal117_tree = this.adaptor.create(char_literal117);
            this.adaptor.addChild(root_0, char_literal117_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_TuplePartCS1411);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:399:1: rule_CollectionLiteralExpCS : ownedtype_0= rule_CollectionTypeCS '{' (ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )* )? '}' ;
    // $ANTLR start "rule_CollectionLiteralExpCS"
    rule_CollectionLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_CollectionLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal118 = null;
        var char_literal119 = null;
        var char_literal120 = null;
        var list_ownedparts_1=null;
        var list_ownedparts_2=null;
         var ownedtype_0 = null;
        var ownedparts_1 = null;
        var ownedparts_2 = null;
        var char_literal118_tree=null;
        var char_literal119_tree=null;
        var char_literal120_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:399:28: (ownedtype_0= rule_CollectionTypeCS '{' (ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )* )? '}' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:400:2: ownedtype_0= rule_CollectionTypeCS '{' (ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )* )? '}'
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionTypeCS_in_rule_CollectionLiteralExpCS1426);
            ownedtype_0=this.rule_CollectionTypeCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, ownedtype_0.getTree());
            char_literal118=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_CollectionLiteralExpCS1429); 
            char_literal118_tree = this.adaptor.create(char_literal118);
            this.adaptor.addChild(root_0, char_literal118_tree);

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:401:6: (ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )* )?
            var alt47=2;
            var LA47_0 = this.input.LA(1);

            if ( ((LA47_0>=SIMPLE_ID && LA47_0<=BIG_INT)||LA47_0==21||LA47_0==40||LA47_0==44||LA47_0==59||(LA47_0>=62 && LA47_0<=63)||(LA47_0>=67 && LA47_0<=68)||LA47_0==77||(LA47_0>=79 && LA47_0<=81)||LA47_0==84) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:401:7: ownedparts_1+= rule_CollectionLiteralPartCS ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )*
                    this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionLiteralPartCS_in_rule_CollectionLiteralExpCS1434);
                    ownedparts_1=this.rule_CollectionLiteralPartCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedparts_1.getTree());
                    if (org.antlr.lang.isNull(list_ownedparts_1)) list_ownedparts_1 = [];
                    list_ownedparts_1.push(ownedparts_1.getTree());

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:401:50: ( ',' ownedparts_2+= rule_CollectionLiteralPartCS )*
                    loop46:
                    do {
                        var alt46=2;
                        var LA46_0 = this.input.LA(1);

                        if ( (LA46_0==17) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:401:51: ',' ownedparts_2+= rule_CollectionLiteralPartCS
                            char_literal119=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_CollectionLiteralExpCS1437); 
                            char_literal119_tree = this.adaptor.create(char_literal119);
                            this.adaptor.addChild(root_0, char_literal119_tree);

                            this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionLiteralPartCS_in_rule_CollectionLiteralExpCS1441);
                            ownedparts_2=this.rule_CollectionLiteralPartCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedparts_2.getTree());
                            if (org.antlr.lang.isNull(list_ownedparts_2)) list_ownedparts_2 = [];
                            list_ownedparts_2.push(ownedparts_2.getTree());



                            break;

                        default :
                            break loop46;
                        }
                    } while (true);



                    break;

            }

            char_literal120=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_CollectionLiteralExpCS1446); 
            char_literal120_tree = this.adaptor.create(char_literal120);
            this.adaptor.addChild(root_0, char_literal120_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:408:1: rule_CollectionLiteralPartCS : expressioncs_0= rule_ExpCS ( '..' lastexpressioncs_1= rule_ExpCS )? ;
    // $ANTLR start "rule_CollectionLiteralPartCS"
    rule_CollectionLiteralPartCS: function() {
        var retval = new MyAtlParser.rule_CollectionLiteralPartCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal121 = null;
         var expressioncs_0 = null;
         var lastexpressioncs_1 = null;

        var string_literal121_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:408:29: (expressioncs_0= rule_ExpCS ( '..' lastexpressioncs_1= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:409:2: expressioncs_0= rule_ExpCS ( '..' lastexpressioncs_1= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_CollectionLiteralPartCS1461);
            expressioncs_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, expressioncs_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:409:28: ( '..' lastexpressioncs_1= rule_ExpCS )?
            var alt48=2;
            var LA48_0 = this.input.LA(1);

            if ( (LA48_0==78) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:409:29: '..' lastexpressioncs_1= rule_ExpCS
                    string_literal121=this.match(this.input,78,MyAtlParser.FOLLOW_78_in_rule_CollectionLiteralPartCS1464); 
                    string_literal121_tree = this.adaptor.create(string_literal121);
                    this.adaptor.addChild(root_0, string_literal121_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_CollectionLiteralPartCS1468);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:417:1: rule_PrimitiveLiteralExpCS : ( rule_NumberLiteralExpCS | rule_StringLiteralExpCS | rule_BooleanLiteralExpCS | rule_UnlimitedNaturalLiteralExpCS | rule_InvalidLiteralExpCS | rule_NullLiteralExpCS );
    // $ANTLR start "rule_PrimitiveLiteralExpCS"
    rule_PrimitiveLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_PrimitiveLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_NumberLiteralExpCS122 = null;
         var rule_StringLiteralExpCS123 = null;
         var rule_BooleanLiteralExpCS124 = null;
         var rule_UnlimitedNaturalLiteralExpCS125 = null;
         var rule_InvalidLiteralExpCS126 = null;
         var rule_NullLiteralExpCS127 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:417:27: ( rule_NumberLiteralExpCS | rule_StringLiteralExpCS | rule_BooleanLiteralExpCS | rule_UnlimitedNaturalLiteralExpCS | rule_InvalidLiteralExpCS | rule_NullLiteralExpCS )
            var alt49=6;
            switch ( this.input.LA(1) ) {
            case BIG_INT:
                alt49=1;
                break;
            case SINGLE_QUOTED_STRING:
                alt49=2;
                break;
            case 77:
            case 79:
                alt49=3;
                break;
            case 68:
                alt49=4;
                break;
            case 80:
                alt49=5;
                break;
            case 81:
                alt49=6;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 49, 0, this.input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:418:2: rule_NumberLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NumberLiteralExpCS_in_rule_PrimitiveLiteralExpCS1484);
                    rule_NumberLiteralExpCS122=this.rule_NumberLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NumberLiteralExpCS122.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:418:28: rule_StringLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_StringLiteralExpCS_in_rule_PrimitiveLiteralExpCS1488);
                    rule_StringLiteralExpCS123=this.rule_StringLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_StringLiteralExpCS123.getTree());


                    break;
                case 3 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:418:54: rule_BooleanLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_BooleanLiteralExpCS_in_rule_PrimitiveLiteralExpCS1492);
                    rule_BooleanLiteralExpCS124=this.rule_BooleanLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_BooleanLiteralExpCS124.getTree());


                    break;
                case 4 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:419:4: rule_UnlimitedNaturalLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_UnlimitedNaturalLiteralExpCS_in_rule_PrimitiveLiteralExpCS1498);
                    rule_UnlimitedNaturalLiteralExpCS125=this.rule_UnlimitedNaturalLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_UnlimitedNaturalLiteralExpCS125.getTree());


                    break;
                case 5 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:419:40: rule_InvalidLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_InvalidLiteralExpCS_in_rule_PrimitiveLiteralExpCS1502);
                    rule_InvalidLiteralExpCS126=this.rule_InvalidLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_InvalidLiteralExpCS126.getTree());


                    break;
                case 6 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:419:67: rule_NullLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NullLiteralExpCS_in_rule_PrimitiveLiteralExpCS1506);
                    rule_NullLiteralExpCS127=this.rule_NullLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NullLiteralExpCS127.getTree());


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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:425:1: rule_TupleLiteralExpCS : 'Tuple' '{' ownedparts_0+= rule_TupleLiteralPartCS ( ',' ownedparts_1+= rule_TupleLiteralPartCS )* '}' ;
    // $ANTLR start "rule_TupleLiteralExpCS"
    rule_TupleLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_TupleLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal128 = null;
        var char_literal129 = null;
        var char_literal130 = null;
        var char_literal131 = null;
        var list_ownedparts_0=null;
        var list_ownedparts_1=null;
        var ownedparts_0 = null;
        var ownedparts_1 = null;
        var string_literal128_tree=null;
        var char_literal129_tree=null;
        var char_literal130_tree=null;
        var char_literal131_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:425:23: ( 'Tuple' '{' ownedparts_0+= rule_TupleLiteralPartCS ( ',' ownedparts_1+= rule_TupleLiteralPartCS )* '}' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:426:2: 'Tuple' '{' ownedparts_0+= rule_TupleLiteralPartCS ( ',' ownedparts_1+= rule_TupleLiteralPartCS )* '}'
            root_0 = this.adaptor.nil();

            string_literal128=this.match(this.input,21,MyAtlParser.FOLLOW_21_in_rule_TupleLiteralExpCS1518); 
            string_literal128_tree = this.adaptor.create(string_literal128);
            this.adaptor.addChild(root_0, string_literal128_tree);

            char_literal129=this.match(this.input,36,MyAtlParser.FOLLOW_36_in_rule_TupleLiteralExpCS1520); 
            char_literal129_tree = this.adaptor.create(char_literal129);
            this.adaptor.addChild(root_0, char_literal129_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_TupleLiteralPartCS_in_rule_TupleLiteralExpCS1524);
            ownedparts_0=this.rule_TupleLiteralPartCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, ownedparts_0.getTree());
            if (org.antlr.lang.isNull(list_ownedparts_0)) list_ownedparts_0 = [];
            list_ownedparts_0.push(ownedparts_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:426:52: ( ',' ownedparts_1+= rule_TupleLiteralPartCS )*
            loop50:
            do {
                var alt50=2;
                var LA50_0 = this.input.LA(1);

                if ( (LA50_0==17) ) {
                    alt50=1;
                }


                switch (alt50) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:426:53: ',' ownedparts_1+= rule_TupleLiteralPartCS
                    char_literal130=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_TupleLiteralExpCS1527); 
                    char_literal130_tree = this.adaptor.create(char_literal130);
                    this.adaptor.addChild(root_0, char_literal130_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TupleLiteralPartCS_in_rule_TupleLiteralExpCS1533);
                    ownedparts_1=this.rule_TupleLiteralPartCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedparts_1.getTree());
                    if (org.antlr.lang.isNull(list_ownedparts_1)) list_ownedparts_1 = [];
                    list_ownedparts_1.push(ownedparts_1.getTree());



                    break;

                default :
                    break loop50;
                }
            } while (true);

            char_literal131=this.match(this.input,38,MyAtlParser.FOLLOW_38_in_rule_TupleLiteralExpCS1537); 
            char_literal131_tree = this.adaptor.create(char_literal131);
            this.adaptor.addChild(root_0, char_literal131_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:433:1: rule_TupleLiteralPartCS : name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS ;
    // $ANTLR start "rule_TupleLiteralPartCS"
    rule_TupleLiteralPartCS: function() {
        var retval = new MyAtlParser.rule_TupleLiteralPartCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal132 = null;
        var char_literal133 = null;
         var name_0 = null;
         var ownedtype_1 = null;
         var initexpression_2 = null;

        var char_literal132_tree=null;
        var char_literal133_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:433:24: (name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:434:2: name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_TupleLiteralPartCS1551);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:434:31: ( ':' ownedtype_1= rule_TypeExpCS )?
            var alt51=2;
            var LA51_0 = this.input.LA(1);

            if ( (LA51_0==16) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:434:32: ':' ownedtype_1= rule_TypeExpCS
                    char_literal132=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_TupleLiteralPartCS1554); 
                    char_literal132_tree = this.adaptor.create(char_literal132);
                    this.adaptor.addChild(root_0, char_literal132_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_TupleLiteralPartCS1558);
                    ownedtype_1=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_1.getTree());


                    break;

            }

            char_literal133=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_TupleLiteralPartCS1562); 
            char_literal133_tree = this.adaptor.create(char_literal133);
            this.adaptor.addChild(root_0, char_literal133_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_TupleLiteralPartCS1567);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:440:1: rule_NumberLiteralExpCS : name_0= BIG_INT ;
    // $ANTLR start "rule_NumberLiteralExpCS"
    rule_NumberLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_NumberLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var name_0 = null;

        var name_0_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:440:24: (name_0= BIG_INT )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:441:2: name_0= BIG_INT
            root_0 = this.adaptor.nil();

            name_0=this.match(this.input,BIG_INT,MyAtlParser.FOLLOW_BIG_INT_in_rule_NumberLiteralExpCS1580); 
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:447:1: rule_StringLiteralExpCS : name_0+= rule_StringLiteral ;
    // $ANTLR start "rule_StringLiteralExpCS"
    rule_StringLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_StringLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var list_name_0=null;
        var name_0 = null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:447:24: (name_0+= rule_StringLiteral )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:448:2: name_0+= rule_StringLiteral
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_StringLiteral_in_rule_StringLiteralExpCS1594);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:454:1: rule_BooleanLiteralExpCS : (name_0= 'true' | name_1= 'false' );
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
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:454:25: (name_0= 'true' | name_1= 'false' )
            var alt52=2;
            var LA52_0 = this.input.LA(1);

            if ( (LA52_0==77) ) {
                alt52=1;
            }
            else if ( (LA52_0==79) ) {
                alt52=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 52, 0, this.input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:455:2: name_0= 'true'
                    root_0 = this.adaptor.nil();

                    name_0=this.match(this.input,77,MyAtlParser.FOLLOW_77_in_rule_BooleanLiteralExpCS1608); 
                    name_0_tree = this.adaptor.create(name_0);
                    this.adaptor.addChild(root_0, name_0_tree);



                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:455:18: name_1= 'false'
                    root_0 = this.adaptor.nil();

                    name_1=this.match(this.input,79,MyAtlParser.FOLLOW_79_in_rule_BooleanLiteralExpCS1614); 
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:464:1: rule_UnlimitedNaturalLiteralExpCS : '*' ;
    // $ANTLR start "rule_UnlimitedNaturalLiteralExpCS"
    rule_UnlimitedNaturalLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_UnlimitedNaturalLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal134 = null;

        var char_literal134_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:464:34: ( '*' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:465:3: '*'
            root_0 = this.adaptor.nil();

            char_literal134=this.match(this.input,68,MyAtlParser.FOLLOW_68_in_rule_UnlimitedNaturalLiteralExpCS1630); 
            char_literal134_tree = this.adaptor.create(char_literal134);
            this.adaptor.addChild(root_0, char_literal134_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:471:1: rule_InvalidLiteralExpCS : 'invalid' ;
    // $ANTLR start "rule_InvalidLiteralExpCS"
    rule_InvalidLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_InvalidLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal135 = null;

        var string_literal135_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:471:25: ( 'invalid' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:472:3: 'invalid'
            root_0 = this.adaptor.nil();

            string_literal135=this.match(this.input,80,MyAtlParser.FOLLOW_80_in_rule_InvalidLiteralExpCS1643); 
            string_literal135_tree = this.adaptor.create(string_literal135);
            this.adaptor.addChild(root_0, string_literal135_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:478:1: rule_NullLiteralExpCS : 'null' ;
    // $ANTLR start "rule_NullLiteralExpCS"
    rule_NullLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_NullLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal136 = null;

        var string_literal136_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:478:22: ( 'null' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:479:3: 'null'
            root_0 = this.adaptor.nil();

            string_literal136=this.match(this.input,81,MyAtlParser.FOLLOW_81_in_rule_NullLiteralExpCS1656); 
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
    rule_PrimitiveTypeCS_return: (function() {
        MyAtlParser.rule_PrimitiveTypeCS_return = function(){};
        org.antlr.lang.extend(MyAtlParser.rule_PrimitiveTypeCS_return,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:487:1: rule_PrimitiveTypeCS : name_0= rule_PrimitiveTypeIdentifier ;
    // $ANTLR start "rule_PrimitiveTypeCS"
    rule_PrimitiveTypeCS: function() {
        var retval = new MyAtlParser.rule_PrimitiveTypeCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var name_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:487:21: (name_0= rule_PrimitiveTypeIdentifier )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:488:2: name_0= rule_PrimitiveTypeIdentifier
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_PrimitiveTypeIdentifier_in_rule_PrimitiveTypeCS1672);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:496:1: rule_TypeLiteralCS : ( rule_PrimitiveTypeCS | rule_TupleTypeCS | rule_CollectionTypeCS );
    // $ANTLR start "rule_TypeLiteralCS"
    rule_TypeLiteralCS: function() {
        var retval = new MyAtlParser.rule_TypeLiteralCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_PrimitiveTypeCS137 = null;
         var rule_TupleTypeCS138 = null;
         var rule_CollectionTypeCS139 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:496:19: ( rule_PrimitiveTypeCS | rule_TupleTypeCS | rule_CollectionTypeCS )
            var alt53=3;
            switch ( this.input.LA(1) ) {
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                alt53=1;
                break;
            case 21:
                alt53=2;
                break;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                alt53=3;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 53, 0, this.input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:497:2: rule_PrimitiveTypeCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_PrimitiveTypeCS_in_rule_TypeLiteralCS1686);
                    rule_PrimitiveTypeCS137=this.rule_PrimitiveTypeCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_PrimitiveTypeCS137.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:497:26: rule_TupleTypeCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TupleTypeCS_in_rule_TypeLiteralCS1691);
                    rule_TupleTypeCS138=this.rule_TupleTypeCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_TupleTypeCS138.getTree());


                    break;
                case 3 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:497:45: rule_CollectionTypeCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_CollectionTypeCS_in_rule_TypeLiteralCS1695);
                    rule_CollectionTypeCS139=this.rule_CollectionTypeCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_CollectionTypeCS139.getTree());


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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:503:1: rule_TypeLiteralExpCS : ownedtype_0= rule_TypeLiteralCS ;
    // $ANTLR start "rule_TypeLiteralExpCS"
    rule_TypeLiteralExpCS: function() {
        var retval = new MyAtlParser.rule_TypeLiteralExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var ownedtype_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:503:22: (ownedtype_0= rule_TypeLiteralCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:504:2: ownedtype_0= rule_TypeLiteralCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_TypeLiteralCS_in_rule_TypeLiteralExpCS1711);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:512:1: rule_TypeNameExpCS : namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )? ;
    // $ANTLR start "rule_TypeNameExpCS"
    rule_TypeNameExpCS: function() {
        var retval = new MyAtlParser.rule_TypeNameExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal140 = null;
        var string_literal141 = null;
        var list_namespace_0=null;
        var list_namespace_1=null;
         var element_2 = null;
         var element_3 = null;
        var namespace_0 = null;
        var namespace_1 = null;
        var string_literal140_tree=null;
        var string_literal141_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:512:19: (namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:513:2: namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_TypeNameExpCS1728);
            namespace_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, namespace_0.getTree());
            if (org.antlr.lang.isNull(list_namespace_0)) list_namespace_0 = [];
            list_namespace_0.push(namespace_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:514:2: ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )?
            var alt56=2;
            var LA56_0 = this.input.LA(1);

            if ( (LA56_0==SIMPLE_ID||LA56_0==82) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:514:3: ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:514:3: ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName )
                    var alt55=2;
                    var LA55_0 = this.input.LA(1);

                    if ( (LA55_0==82) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==SIMPLE_ID) ) {
                        alt55=2;
                    }
                    else {
                        var nvae =
                            new org.antlr.runtime.NoViableAltException("", 55, 0, this.input);

                        throw nvae;
                    }
                    switch (alt55) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:515:3: ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:515:3: ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:516:4: ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:516:4: ( '::' (namespace_1+= rule_UnreservedName '::' )* )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:516:7: '::' (namespace_1+= rule_UnreservedName '::' )*
                            string_literal140=this.match(this.input,82,MyAtlParser.FOLLOW_82_in_rule_TypeNameExpCS1746); 
                            string_literal140_tree = this.adaptor.create(string_literal140);
                            this.adaptor.addChild(root_0, string_literal140_tree);

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:516:12: (namespace_1+= rule_UnreservedName '::' )*
                            loop54:
                            do {
                                var alt54=2;
                                switch ( this.input.LA(1) ) {
                                case SIMPLE_ID:
                                    var LA54_1 = this.input.LA(2);

                                    if ( (LA54_1==82) ) {
                                        alt54=1;
                                    }


                                    break;
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                    var LA54_2 = this.input.LA(2);

                                    if ( (LA54_2==82) ) {
                                        alt54=1;
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
                                    var LA54_3 = this.input.LA(2);

                                    if ( (LA54_3==82) ) {
                                        alt54=1;
                                    }


                                    break;
                                case 21:
                                    var LA54_4 = this.input.LA(2);

                                    if ( (LA54_4==82) ) {
                                        alt54=1;
                                    }


                                    break;

                                }

                                switch (alt54) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:516:13: namespace_1+= rule_UnreservedName '::'
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_UnreservedName_in_rule_TypeNameExpCS1752);
                                    namespace_1=this.rule_UnreservedName();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, namespace_1.getTree());
                                    if (org.antlr.lang.isNull(list_namespace_1)) list_namespace_1 = [];
                                    list_namespace_1.push(namespace_1.getTree());

                                    string_literal141=this.match(this.input,82,MyAtlParser.FOLLOW_82_in_rule_TypeNameExpCS1754); 
                                    string_literal141_tree = this.adaptor.create(string_literal141);
                                    this.adaptor.addChild(root_0, string_literal141_tree);



                                    break;

                                default :
                                    break loop54;
                                }
                            } while (true);




                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnreservedName_in_rule_TypeNameExpCS1766);
                            element_2=this.rule_UnreservedName();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, element_2.getTree());





                            break;
                        case 2 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:518:4: element_3= rule_UnrestrictedName
                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_TypeNameExpCS1775);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:523:1: rule_TypeExpCS : ( rule_TypeNameExpCS | rule_TypeLiteralCS );
    // $ANTLR start "rule_TypeExpCS"
    rule_TypeExpCS: function() {
        var retval = new MyAtlParser.rule_TypeExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_TypeNameExpCS142 = null;
         var rule_TypeLiteralCS143 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:523:15: ( rule_TypeNameExpCS | rule_TypeLiteralCS )
            var alt57=2;
            var LA57_0 = this.input.LA(1);

            if ( (LA57_0==SIMPLE_ID) ) {
                alt57=1;
            }
            else if ( ((LA57_0>=21 && LA57_0<=34)) ) {
                alt57=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 57, 0, this.input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:524:2: rule_TypeNameExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeNameExpCS_in_rule_TypeExpCS1789);
                    rule_TypeNameExpCS142=this.rule_TypeNameExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_TypeNameExpCS142.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:524:23: rule_TypeLiteralCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeLiteralCS_in_rule_TypeExpCS1793);
                    rule_TypeLiteralCS143=this.rule_TypeLiteralCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_TypeLiteralCS143.getTree());


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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:530:1: rule_NavigatingArgCS : name_0= rule_NavigatingArgExpCS ( ':' ownedtype_1= rule_TypeExpCS )? ( '=' init_2= rule_ExpCS )? ;
    // $ANTLR start "rule_NavigatingArgCS"
    rule_NavigatingArgCS: function() {
        var retval = new MyAtlParser.rule_NavigatingArgCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal144 = null;
        var char_literal145 = null;
         var name_0 = null;
         var ownedtype_1 = null;
         var init_2 = null;

        var char_literal144_tree=null;
        var char_literal145_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:530:21: (name_0= rule_NavigatingArgExpCS ( ':' ownedtype_1= rule_TypeExpCS )? ( '=' init_2= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:531:2: name_0= rule_NavigatingArgExpCS ( ':' ownedtype_1= rule_TypeExpCS )? ( '=' init_2= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingArgCS1808);
            name_0=this.rule_NavigatingArgExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:531:33: ( ':' ownedtype_1= rule_TypeExpCS )?
            var alt58=2;
            var LA58_0 = this.input.LA(1);

            if ( (LA58_0==16) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:531:34: ':' ownedtype_1= rule_TypeExpCS
                    char_literal144=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_NavigatingArgCS1811); 
                    char_literal144_tree = this.adaptor.create(char_literal144);
                    this.adaptor.addChild(root_0, char_literal144_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_NavigatingArgCS1815);
                    ownedtype_1=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_1.getTree());


                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:531:67: ( '=' init_2= rule_ExpCS )?
            var alt59=2;
            var LA59_0 = this.input.LA(1);

            if ( (LA59_0==47) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:531:68: '=' init_2= rule_ExpCS
                    char_literal145=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_NavigatingArgCS1820); 
                    char_literal145_tree = this.adaptor.create(char_literal145);
                    this.adaptor.addChild(root_0, char_literal145_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingArgCS1824);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:537:1: rule_NavigatingBarArgCS : prefix_0= '|' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? ;
    // $ANTLR start "rule_NavigatingBarArgCS"
    rule_NavigatingBarArgCS: function() {
        var retval = new MyAtlParser.rule_NavigatingBarArgCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var prefix_0 = null;
        var char_literal146 = null;
        var char_literal147 = null;
         var name_1 = null;
         var ownedtype_2 = null;
         var init_3 = null;

        var prefix_0_tree=null;
        var char_literal146_tree=null;
        var char_literal147_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:537:24: (prefix_0= '|' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:538:2: prefix_0= '|' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            prefix_0=this.match(this.input,83,MyAtlParser.FOLLOW_83_in_rule_NavigatingBarArgCS1841); 
            prefix_0_tree = this.adaptor.create(prefix_0);
            this.adaptor.addChild(root_0, prefix_0_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingBarArgCS1845);
            name_1=this.rule_NavigatingArgExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:538:46: ( ':' ownedtype_2= rule_TypeExpCS )?
            var alt60=2;
            var LA60_0 = this.input.LA(1);

            if ( (LA60_0==16) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:538:47: ':' ownedtype_2= rule_TypeExpCS
                    char_literal146=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_NavigatingBarArgCS1848); 
                    char_literal146_tree = this.adaptor.create(char_literal146);
                    this.adaptor.addChild(root_0, char_literal146_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_NavigatingBarArgCS1852);
                    ownedtype_2=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_2.getTree());


                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:538:80: ( '=' init_3= rule_ExpCS )?
            var alt61=2;
            var LA61_0 = this.input.LA(1);

            if ( (LA61_0==47) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:538:81: '=' init_3= rule_ExpCS
                    char_literal147=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_NavigatingBarArgCS1857); 
                    char_literal147_tree = this.adaptor.create(char_literal147);
                    this.adaptor.addChild(root_0, char_literal147_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingBarArgCS1861);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:544:1: rule_NavigatingCommaArgCS : prefix_0= ',' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? ;
    // $ANTLR start "rule_NavigatingCommaArgCS"
    rule_NavigatingCommaArgCS: function() {
        var retval = new MyAtlParser.rule_NavigatingCommaArgCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var prefix_0 = null;
        var char_literal148 = null;
        var char_literal149 = null;
         var name_1 = null;
         var ownedtype_2 = null;
         var init_3 = null;

        var prefix_0_tree=null;
        var char_literal148_tree=null;
        var char_literal149_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:544:26: (prefix_0= ',' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:545:2: prefix_0= ',' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            prefix_0=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_NavigatingCommaArgCS1877); 
            prefix_0_tree = this.adaptor.create(prefix_0);
            this.adaptor.addChild(root_0, prefix_0_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingCommaArgCS1881);
            name_1=this.rule_NavigatingArgExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:545:46: ( ':' ownedtype_2= rule_TypeExpCS )?
            var alt62=2;
            var LA62_0 = this.input.LA(1);

            if ( (LA62_0==16) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:545:47: ':' ownedtype_2= rule_TypeExpCS
                    char_literal148=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_NavigatingCommaArgCS1884); 
                    char_literal148_tree = this.adaptor.create(char_literal148);
                    this.adaptor.addChild(root_0, char_literal148_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_NavigatingCommaArgCS1888);
                    ownedtype_2=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_2.getTree());


                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:545:80: ( '=' init_3= rule_ExpCS )?
            var alt63=2;
            var LA63_0 = this.input.LA(1);

            if ( (LA63_0==47) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:545:81: '=' init_3= rule_ExpCS
                    char_literal149=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_NavigatingCommaArgCS1893); 
                    char_literal149_tree = this.adaptor.create(char_literal149);
                    this.adaptor.addChild(root_0, char_literal149_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingCommaArgCS1897);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:551:1: rule_NavigatingSemiArgCS : prefix_0= ';' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? ;
    // $ANTLR start "rule_NavigatingSemiArgCS"
    rule_NavigatingSemiArgCS: function() {
        var retval = new MyAtlParser.rule_NavigatingSemiArgCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var prefix_0 = null;
        var char_literal150 = null;
        var char_literal151 = null;
         var name_1 = null;
         var ownedtype_2 = null;
         var init_3 = null;

        var prefix_0_tree=null;
        var char_literal150_tree=null;
        var char_literal151_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:551:26: (prefix_0= ';' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:552:2: prefix_0= ';' name_1= rule_NavigatingArgExpCS ( ':' ownedtype_2= rule_TypeExpCS )? ( '=' init_3= rule_ExpCS )?
            root_0 = this.adaptor.nil();

            prefix_0=this.match(this.input,13,MyAtlParser.FOLLOW_13_in_rule_NavigatingSemiArgCS1916); 
            prefix_0_tree = this.adaptor.create(prefix_0);
            this.adaptor.addChild(root_0, prefix_0_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingSemiArgCS1920);
            name_1=this.rule_NavigatingArgExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_1.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:552:46: ( ':' ownedtype_2= rule_TypeExpCS )?
            var alt64=2;
            var LA64_0 = this.input.LA(1);

            if ( (LA64_0==16) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:552:47: ':' ownedtype_2= rule_TypeExpCS
                    char_literal150=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_NavigatingSemiArgCS1923); 
                    char_literal150_tree = this.adaptor.create(char_literal150);
                    this.adaptor.addChild(root_0, char_literal150_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_NavigatingSemiArgCS1927);
                    ownedtype_2=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_2.getTree());


                    break;

            }

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:552:80: ( '=' init_3= rule_ExpCS )?
            var alt65=2;
            var LA65_0 = this.input.LA(1);

            if ( (LA65_0==47) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:552:81: '=' init_3= rule_ExpCS
                    char_literal151=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_NavigatingSemiArgCS1932); 
                    char_literal151_tree = this.adaptor.create(char_literal151);
                    this.adaptor.addChild(root_0, char_literal151_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingSemiArgCS1936);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:558:1: rule_NavigatingArgExpCS : rule_ExpCS ;
    // $ANTLR start "rule_NavigatingArgExpCS"
    rule_NavigatingArgExpCS: function() {
        var retval = new MyAtlParser.rule_NavigatingArgExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_ExpCS152 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:558:24: ( rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:559:2: rule_ExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NavigatingArgExpCS1950);
            rule_ExpCS152=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_ExpCS152.getTree());



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:565:1: rule_IfExpCS : 'if' condition_0= rule_ExpCS 'then' thenexpression_1= rule_ExpCS 'else' elseexpression_2= rule_ExpCS 'endif' ;
    // $ANTLR start "rule_IfExpCS"
    rule_IfExpCS: function() {
        var retval = new MyAtlParser.rule_IfExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal153 = null;
        var string_literal154 = null;
        var string_literal155 = null;
        var string_literal156 = null;
         var condition_0 = null;
         var thenexpression_1 = null;
         var elseexpression_2 = null;

        var string_literal153_tree=null;
        var string_literal154_tree=null;
        var string_literal155_tree=null;
        var string_literal156_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:565:13: ( 'if' condition_0= rule_ExpCS 'then' thenexpression_1= rule_ExpCS 'else' elseexpression_2= rule_ExpCS 'endif' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:566:2: 'if' condition_0= rule_ExpCS 'then' thenexpression_1= rule_ExpCS 'else' elseexpression_2= rule_ExpCS 'endif'
            root_0 = this.adaptor.nil();

            string_literal153=this.match(this.input,59,MyAtlParser.FOLLOW_59_in_rule_IfExpCS1963); 
            string_literal153_tree = this.adaptor.create(string_literal153);
            this.adaptor.addChild(root_0, string_literal153_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IfExpCS1967);
            condition_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, condition_0.getTree());
            string_literal154=this.match(this.input,65,MyAtlParser.FOLLOW_65_in_rule_IfExpCS1970); 
            string_literal154_tree = this.adaptor.create(string_literal154);
            this.adaptor.addChild(root_0, string_literal154_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IfExpCS1974);
            thenexpression_1=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, thenexpression_1.getTree());
            string_literal155=this.match(this.input,57,MyAtlParser.FOLLOW_57_in_rule_IfExpCS1977); 
            string_literal155_tree = this.adaptor.create(string_literal155);
            this.adaptor.addChild(root_0, string_literal155_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IfExpCS1981);
            elseexpression_2=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, elseexpression_2.getTree());
            string_literal156=this.match(this.input,58,MyAtlParser.FOLLOW_58_in_rule_IfExpCS1984); 
            string_literal156_tree = this.adaptor.create(string_literal156);
            this.adaptor.addChild(root_0, string_literal156_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:573:1: rule_LetExpCS : 'let' variable_0+= rule_LetVariableCS ( ',' variable_1+= rule_LetVariableCS )* 'in' in_2= rule_ExpCS ;
    // $ANTLR start "rule_LetExpCS"
    rule_LetExpCS: function() {
        var retval = new MyAtlParser.rule_LetExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal157 = null;
        var char_literal158 = null;
        var string_literal159 = null;
        var list_variable_0=null;
        var list_variable_1=null;
         var in_2 = null;
        var variable_0 = null;
        var variable_1 = null;
        var string_literal157_tree=null;
        var char_literal158_tree=null;
        var string_literal159_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:573:14: ( 'let' variable_0+= rule_LetVariableCS ( ',' variable_1+= rule_LetVariableCS )* 'in' in_2= rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:574:2: 'let' variable_0+= rule_LetVariableCS ( ',' variable_1+= rule_LetVariableCS )* 'in' in_2= rule_ExpCS
            root_0 = this.adaptor.nil();

            string_literal157=this.match(this.input,62,MyAtlParser.FOLLOW_62_in_rule_LetExpCS1994); 
            string_literal157_tree = this.adaptor.create(string_literal157);
            this.adaptor.addChild(root_0, string_literal157_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_LetVariableCS_in_rule_LetExpCS1998);
            variable_0=this.rule_LetVariableCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, variable_0.getTree());
            if (org.antlr.lang.isNull(list_variable_0)) list_variable_0 = [];
            list_variable_0.push(variable_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:574:39: ( ',' variable_1+= rule_LetVariableCS )*
            loop66:
            do {
                var alt66=2;
                var LA66_0 = this.input.LA(1);

                if ( (LA66_0==17) ) {
                    alt66=1;
                }


                switch (alt66) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:574:40: ',' variable_1+= rule_LetVariableCS
                    char_literal158=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_LetExpCS2001); 
                    char_literal158_tree = this.adaptor.create(char_literal158);
                    this.adaptor.addChild(root_0, char_literal158_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_LetVariableCS_in_rule_LetExpCS2005);
                    variable_1=this.rule_LetVariableCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, variable_1.getTree());
                    if (org.antlr.lang.isNull(list_variable_1)) list_variable_1 = [];
                    list_variable_1.push(variable_1.getTree());



                    break;

                default :
                    break loop66;
                }
            } while (true);

            string_literal159=this.match(this.input,61,MyAtlParser.FOLLOW_61_in_rule_LetExpCS2010); 
            string_literal159_tree = this.adaptor.create(string_literal159);
            this.adaptor.addChild(root_0, string_literal159_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_LetExpCS2014);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:580:1: rule_LetVariableCS : name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS ;
    // $ANTLR start "rule_LetVariableCS"
    rule_LetVariableCS: function() {
        var retval = new MyAtlParser.rule_LetVariableCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal160 = null;
        var char_literal161 = null;
         var name_0 = null;
         var ownedtype_1 = null;
         var initexpression_2 = null;

        var char_literal160_tree=null;
        var char_literal161_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:580:19: (name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:581:2: name_0= rule_UnrestrictedName ( ':' ownedtype_1= rule_TypeExpCS )? '=' initexpression_2= rule_ExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_LetVariableCS2028);
            name_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, name_0.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:581:31: ( ':' ownedtype_1= rule_TypeExpCS )?
            var alt67=2;
            var LA67_0 = this.input.LA(1);

            if ( (LA67_0==16) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:581:32: ':' ownedtype_1= rule_TypeExpCS
                    char_literal160=this.match(this.input,16,MyAtlParser.FOLLOW_16_in_rule_LetVariableCS2031); 
                    char_literal160_tree = this.adaptor.create(char_literal160);
                    this.adaptor.addChild(root_0, char_literal160_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TypeExpCS_in_rule_LetVariableCS2034);
                    ownedtype_1=this.rule_TypeExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, ownedtype_1.getTree());


                    break;

            }

            char_literal161=this.match(this.input,47,MyAtlParser.FOLLOW_47_in_rule_LetVariableCS2038); 
            char_literal161_tree = this.adaptor.create(char_literal161);
            this.adaptor.addChild(root_0, char_literal161_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_LetVariableCS2043);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:588:1: rule_NestedExpCS : '(' source_0= rule_ExpCS ')' ;
    // $ANTLR start "rule_NestedExpCS"
    rule_NestedExpCS: function() {
        var retval = new MyAtlParser.rule_NestedExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal162 = null;
        var char_literal163 = null;
         var source_0 = null;

        var char_literal162_tree=null;
        var char_literal163_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:588:17: ( '(' source_0= rule_ExpCS ')' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:589:2: '(' source_0= rule_ExpCS ')'
            root_0 = this.adaptor.nil();

            char_literal162=this.match(this.input,44,MyAtlParser.FOLLOW_44_in_rule_NestedExpCS2056); 
            char_literal162_tree = this.adaptor.create(char_literal162);
            this.adaptor.addChild(root_0, char_literal162_tree);

            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_NestedExpCS2060);
            source_0=this.rule_ExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, source_0.getTree());
            char_literal163=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_NestedExpCS2062); 
            char_literal163_tree = this.adaptor.create(char_literal163);
            this.adaptor.addChild(root_0, char_literal163_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:595:1: rule_SelfExpCS : 'self' ;
    // $ANTLR start "rule_SelfExpCS"
    rule_SelfExpCS: function() {
        var retval = new MyAtlParser.rule_SelfExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal164 = null;

        var string_literal164_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:595:15: ( 'self' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:596:2: 'self'
            root_0 = this.adaptor.nil();

            string_literal164=this.match(this.input,84,MyAtlParser.FOLLOW_84_in_rule_SelfExpCS2075); 
            string_literal164_tree = this.adaptor.create(string_literal164);
            this.adaptor.addChild(root_0, string_literal164_tree);




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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:609:1: rule_PrimaryExpCS : ( rule_NavigatingExpCS | rule_SelfExpCS | rule_PrimitiveLiteralExpCS | rule_TupleLiteralExpCS | rule_LetExpCS | rule_IfExpCS | rule_NestedExpCS | rule_StringExpCs );
    // $ANTLR start "rule_PrimaryExpCS"
    rule_PrimaryExpCS: function() {
        var retval = new MyAtlParser.rule_PrimaryExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_NavigatingExpCS165 = null;
         var rule_SelfExpCS166 = null;
         var rule_PrimitiveLiteralExpCS167 = null;
         var rule_TupleLiteralExpCS168 = null;
         var rule_LetExpCS169 = null;
         var rule_IfExpCS170 = null;
         var rule_NestedExpCS171 = null;
         var rule_StringExpCs172 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:609:18: ( rule_NavigatingExpCS | rule_SelfExpCS | rule_PrimitiveLiteralExpCS | rule_TupleLiteralExpCS | rule_LetExpCS | rule_IfExpCS | rule_NestedExpCS | rule_StringExpCs )
            var alt68=8;
            switch ( this.input.LA(1) ) {
            case SIMPLE_ID:
                alt68=1;
                break;
            case 84:
                alt68=2;
                break;
            case SINGLE_QUOTED_STRING:
            case BIG_INT:
            case 68:
            case 77:
            case 79:
            case 80:
            case 81:
                alt68=3;
                break;
            case 21:
                alt68=4;
                break;
            case 62:
                alt68=5;
                break;
            case 59:
                alt68=6;
                break;
            case 44:
                alt68=7;
                break;
            case 40:
                alt68=8;
                break;
            default:
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 68, 0, this.input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:610:2: rule_NavigatingExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingExpCS_in_rule_PrimaryExpCS2102);
                    rule_NavigatingExpCS165=this.rule_NavigatingExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NavigatingExpCS165.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:610:25: rule_SelfExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_SelfExpCS_in_rule_PrimaryExpCS2106);
                    rule_SelfExpCS166=this.rule_SelfExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_SelfExpCS166.getTree());


                    break;
                case 3 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:610:42: rule_PrimitiveLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_PrimitiveLiteralExpCS_in_rule_PrimaryExpCS2110);
                    rule_PrimitiveLiteralExpCS167=this.rule_PrimitiveLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_PrimitiveLiteralExpCS167.getTree());


                    break;
                case 4 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:610:71: rule_TupleLiteralExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_TupleLiteralExpCS_in_rule_PrimaryExpCS2114);
                    rule_TupleLiteralExpCS168=this.rule_TupleLiteralExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_TupleLiteralExpCS168.getTree());


                    break;
                case 5 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:611:3: rule_LetExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_LetExpCS_in_rule_PrimaryExpCS2120);
                    rule_LetExpCS169=this.rule_LetExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_LetExpCS169.getTree());


                    break;
                case 6 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:611:19: rule_IfExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_IfExpCS_in_rule_PrimaryExpCS2124);
                    rule_IfExpCS170=this.rule_IfExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_IfExpCS170.getTree());


                    break;
                case 7 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:611:34: rule_NestedExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NestedExpCS_in_rule_PrimaryExpCS2128);
                    rule_NestedExpCS171=this.rule_NestedExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NestedExpCS171.getTree());


                    break;
                case 8 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:611:53: rule_StringExpCs
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_StringExpCs_in_rule_PrimaryExpCS2132);
                    rule_StringExpCs172=this.rule_StringExpCs();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_StringExpCs172.getTree());


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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:617:1: rule_StringExpCs : name_0= '...' ;
    // $ANTLR start "rule_StringExpCs"
    rule_StringExpCs: function() {
        var retval = new MyAtlParser.rule_StringExpCs_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var name_0 = null;

        var name_0_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:617:17: (name_0= '...' )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:618:2: name_0= '...'
            root_0 = this.adaptor.nil();

            name_0=this.match(this.input,40,MyAtlParser.FOLLOW_40_in_rule_StringExpCs2149); 
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:626:1: rule_NameExpCS : namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )? ;
    // $ANTLR start "rule_NameExpCS"
    rule_NameExpCS: function() {
        var retval = new MyAtlParser.rule_NameExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var string_literal173 = null;
        var string_literal174 = null;
        var list_namespace_0=null;
        var list_namespace_1=null;
         var element_2 = null;
         var element_3 = null;
        var namespace_0 = null;
        var namespace_1 = null;
        var string_literal173_tree=null;
        var string_literal174_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:626:15: (namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:627:2: namespace_0+= rule_UnrestrictedName ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_NameExpCS2165);
            namespace_0=this.rule_UnrestrictedName();

            this.state._fsp--;

            this.adaptor.addChild(root_0, namespace_0.getTree());
            if (org.antlr.lang.isNull(list_namespace_0)) list_namespace_0 = [];
            list_namespace_0.push(namespace_0.getTree());

            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:628:2: ( ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName ) )?
            var alt71=2;
            var LA71_0 = this.input.LA(1);

            if ( (LA71_0==82) ) {
                alt71=1;
            }
            else if ( (LA71_0==SIMPLE_ID) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:628:3: ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:628:3: ( ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName ) | element_3= rule_UnrestrictedName )
                    var alt70=2;
                    var LA70_0 = this.input.LA(1);

                    if ( (LA70_0==82) ) {
                        alt70=1;
                    }
                    else if ( (LA70_0==SIMPLE_ID) ) {
                        alt70=2;
                    }
                    else {
                        var nvae =
                            new org.antlr.runtime.NoViableAltException("", 70, 0, this.input);

                        throw nvae;
                    }
                    switch (alt70) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:629:3: ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:629:3: ( ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:630:4: ( '::' (namespace_1+= rule_UnreservedName '::' )* ) element_2= rule_UnreservedName
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:630:4: ( '::' (namespace_1+= rule_UnreservedName '::' )* )
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:630:6: '::' (namespace_1+= rule_UnreservedName '::' )*
                            string_literal173=this.match(this.input,82,MyAtlParser.FOLLOW_82_in_rule_NameExpCS2182); 
                            string_literal173_tree = this.adaptor.create(string_literal173);
                            this.adaptor.addChild(root_0, string_literal173_tree);

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:630:11: (namespace_1+= rule_UnreservedName '::' )*
                            loop69:
                            do {
                                var alt69=2;
                                switch ( this.input.LA(1) ) {
                                case SIMPLE_ID:
                                    var LA69_1 = this.input.LA(2);

                                    if ( (LA69_1==82) ) {
                                        alt69=1;
                                    }


                                    break;
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                    var LA69_2 = this.input.LA(2);

                                    if ( (LA69_2==82) ) {
                                        alt69=1;
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
                                    var LA69_3 = this.input.LA(2);

                                    if ( (LA69_3==82) ) {
                                        alt69=1;
                                    }


                                    break;
                                case 21:
                                    var LA69_4 = this.input.LA(2);

                                    if ( (LA69_4==82) ) {
                                        alt69=1;
                                    }


                                    break;

                                }

                                switch (alt69) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:630:12: namespace_1+= rule_UnreservedName '::'
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_UnreservedName_in_rule_NameExpCS2188);
                                    namespace_1=this.rule_UnreservedName();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, namespace_1.getTree());
                                    if (org.antlr.lang.isNull(list_namespace_1)) list_namespace_1 = [];
                                    list_namespace_1.push(namespace_1.getTree());

                                    string_literal174=this.match(this.input,82,MyAtlParser.FOLLOW_82_in_rule_NameExpCS2190); 
                                    string_literal174_tree = this.adaptor.create(string_literal174);
                                    this.adaptor.addChild(root_0, string_literal174_tree);



                                    break;

                                default :
                                    break loop69;
                                }
                            } while (true);




                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnreservedName_in_rule_NameExpCS2202);
                            element_2=this.rule_UnreservedName();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, element_2.getTree());





                            break;
                        case 2 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:632:4: element_3= rule_UnrestrictedName
                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnrestrictedName_in_rule_NameExpCS2211);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:638:1: rule_ExpCS : rule_InfixedExpCS ;
    // $ANTLR start "rule_ExpCS"
    rule_ExpCS: function() {
        var retval = new MyAtlParser.rule_ExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_InfixedExpCS175 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:638:11: ( rule_InfixedExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:639:2: rule_InfixedExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_InfixedExpCS_in_rule_ExpCS2228);
            rule_InfixedExpCS175=this.rule_InfixedExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_InfixedExpCS175.getTree());



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:647:1: rule_InfixedExpCS : rule_PrefixedExpCS ( (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+ )? ;
    // $ANTLR start "rule_InfixedExpCS"
    rule_InfixedExpCS: function() {
        var retval = new MyAtlParser.rule_InfixedExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var list_ownedoperator_0=null;
        var list_ownedexpression_1=null;
         var rule_PrefixedExpCS176 = null;
        var ownedoperator_0 = null;
        var ownedexpression_1 = null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:647:18: ( rule_PrefixedExpCS ( (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+ )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:648:3: rule_PrefixedExpCS ( (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+ )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_PrefixedExpCS_in_rule_InfixedExpCS2243);
            rule_PrefixedExpCS176=this.rule_PrefixedExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_PrefixedExpCS176.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:648:22: ( (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+ )?
            var alt73=2;
            switch ( this.input.LA(1) ) {
                case 47:
                    alt73=1;
                    break;
                case 54:
                    alt73=1;
                    break;
                case 76:
                    alt73=1;
                    break;
                case 56:
                case 60:
                case 64:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                    alt73=1;
                    break;
            }

            switch (alt73) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:649:2: (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:649:2: (ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS )+
                    var cnt72=0;
                    loop72:
                    do {
                        var alt72=2;
                        switch ( this.input.LA(1) ) {
                        case 54:
                            alt72=1;
                            break;
                        case 47:
                            alt72=1;
                            break;
                        case 56:
                        case 60:
                        case 64:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            alt72=1;
                            break;
                        case 76:
                            alt72=1;
                            break;

                        }

                        switch (alt72) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:649:3: ownedoperator_0+= rule_BinaryOperatorCS ownedexpression_1+= rule_PrefixedExpCS
                            this.pushFollow(MyAtlParser.FOLLOW_rule_BinaryOperatorCS_in_rule_InfixedExpCS2251);
                            ownedoperator_0=this.rule_BinaryOperatorCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedoperator_0.getTree());
                            if (org.antlr.lang.isNull(list_ownedoperator_0)) list_ownedoperator_0 = [];
                            list_ownedoperator_0.push(ownedoperator_0.getTree());

                            this.pushFollow(MyAtlParser.FOLLOW_rule_PrefixedExpCS_in_rule_InfixedExpCS2255);
                            ownedexpression_1=this.rule_PrefixedExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedexpression_1.getTree());
                            if (org.antlr.lang.isNull(list_ownedexpression_1)) list_ownedexpression_1 = [];
                            list_ownedexpression_1.push(ownedexpression_1.getTree());



                            break;

                        default :
                            if ( cnt72 >= 1 ) {
                                break loop72;
                            }
                                var eee = new org.antlr.runtime.EarlyExitException(72, this.input);
                                throw eee;
                        }
                        cnt72++;
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:657:1: rule_BinaryOperatorCS : ( rule_InfixOperatorCS | rule_NavigationOperatorCS );
    // $ANTLR start "rule_BinaryOperatorCS"
    rule_BinaryOperatorCS: function() {
        var retval = new MyAtlParser.rule_BinaryOperatorCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_InfixOperatorCS177 = null;
         var rule_NavigationOperatorCS178 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:657:23: ( rule_InfixOperatorCS | rule_NavigationOperatorCS )
            var alt74=2;
            var LA74_0 = this.input.LA(1);

            if ( (LA74_0==47||LA74_0==56||LA74_0==60||LA74_0==64||(LA74_0>=66 && LA74_0<=75)) ) {
                alt74=1;
            }
            else if ( (LA74_0==54||LA74_0==76) ) {
                alt74=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 74, 0, this.input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:658:2: rule_InfixOperatorCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_InfixOperatorCS_in_rule_BinaryOperatorCS2276);
                    rule_InfixOperatorCS177=this.rule_InfixOperatorCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_InfixOperatorCS177.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:658:25: rule_NavigationOperatorCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigationOperatorCS_in_rule_BinaryOperatorCS2280);
                    rule_NavigationOperatorCS178=this.rule_NavigationOperatorCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_NavigationOperatorCS178.getTree());


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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:662:1: rule_InfixOperatorCS : name_0= rule_InfixOperator ;
    // $ANTLR start "rule_InfixOperatorCS"
    rule_InfixOperatorCS: function() {
        var retval = new MyAtlParser.rule_InfixOperatorCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var name_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:662:21: (name_0= rule_InfixOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:663:2: name_0= rule_InfixOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_InfixOperator_in_rule_InfixOperatorCS2294);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:669:1: rule_NavigationOperatorCS : name_0= rule_NavigationOperator ;
    // $ANTLR start "rule_NavigationOperatorCS"
    rule_NavigationOperatorCS: function() {
        var retval = new MyAtlParser.rule_NavigationOperatorCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var name_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:669:27: (name_0= rule_NavigationOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:670:2: name_0= rule_NavigationOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigationOperator_in_rule_NavigationOperatorCS2311);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:678:1: rule_PrefixedExpCS : ( rule_PrimaryExpCS | ( (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS ) );
    // $ANTLR start "rule_PrefixedExpCS"
    rule_PrefixedExpCS: function() {
        var retval = new MyAtlParser.rule_PrefixedExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var list_ownedoperator_0=null;
         var ownedexpression_1 = null;
         var rule_PrimaryExpCS179 = null;
        var ownedoperator_0 = null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:678:20: ( rule_PrimaryExpCS | ( (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS ) )
            var alt76=2;
            var LA76_0 = this.input.LA(1);

            if ( ((LA76_0>=SIMPLE_ID && LA76_0<=BIG_INT)||LA76_0==21||LA76_0==40||LA76_0==44||LA76_0==59||LA76_0==62||LA76_0==68||LA76_0==77||(LA76_0>=79 && LA76_0<=81)||LA76_0==84) ) {
                alt76=1;
            }
            else if ( (LA76_0==63||LA76_0==67) ) {
                alt76=2;
            }
            else {
                var nvae =
                    new org.antlr.runtime.NoViableAltException("", 76, 0, this.input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:679:2: rule_PrimaryExpCS
                    root_0 = this.adaptor.nil();

                    this.pushFollow(MyAtlParser.FOLLOW_rule_PrimaryExpCS_in_rule_PrefixedExpCS2327);
                    rule_PrimaryExpCS179=this.rule_PrimaryExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, rule_PrimaryExpCS179.getTree());


                    break;
                case 2 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:679:22: ( (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS )
                    root_0 = this.adaptor.nil();

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:679:22: ( (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS )
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:679:24: (ownedoperator_0+= rule_UnaryOperatorCS )+ ownedexpression_1= rule_PrimaryExpCS
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:679:39: (ownedoperator_0+= rule_UnaryOperatorCS )+
                    var cnt75=0;
                    loop75:
                    do {
                        var alt75=2;
                        var LA75_0 = this.input.LA(1);

                        if ( (LA75_0==63||LA75_0==67) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:679:39: ownedoperator_0+= rule_UnaryOperatorCS
                            this.pushFollow(MyAtlParser.FOLLOW_rule_UnaryOperatorCS_in_rule_PrefixedExpCS2335);
                            ownedoperator_0=this.rule_UnaryOperatorCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, ownedoperator_0.getTree());
                            if (org.antlr.lang.isNull(list_ownedoperator_0)) list_ownedoperator_0 = [];
                            list_ownedoperator_0.push(ownedoperator_0.getTree());



                            break;

                        default :
                            if ( cnt75 >= 1 ) {
                                break loop75;
                            }
                                var eee = new org.antlr.runtime.EarlyExitException(75, this.input);
                                throw eee;
                        }
                        cnt75++;
                    } while (true);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_PrimaryExpCS_in_rule_PrefixedExpCS2342);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:686:1: rule_UnaryOperatorCS : name_0= rule_PrefixOperator ;
    // $ANTLR start "rule_UnaryOperatorCS"
    rule_UnaryOperatorCS: function() {
        var retval = new MyAtlParser.rule_UnaryOperatorCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var name_0 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:686:22: (name_0= rule_PrefixOperator )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:687:2: name_0= rule_PrefixOperator
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_PrefixOperator_in_rule_UnaryOperatorCS2361);
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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:695:1: rule_IndexExpCS : rule_NameExpCS ( '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )? )? ;
    // $ANTLR start "rule_IndexExpCS"
    rule_IndexExpCS: function() {
        var retval = new MyAtlParser.rule_IndexExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal181 = null;
        var char_literal182 = null;
        var char_literal183 = null;
        var char_literal184 = null;
        var char_literal185 = null;
        var char_literal186 = null;
        var list_firstindexes_0=null;
        var list_firstindexes_1=null;
        var list_secondindexes_2=null;
        var list_secondindexes_3=null;
         var rule_NameExpCS180 = null;
        var firstindexes_0 = null;
        var firstindexes_1 = null;
        var secondindexes_2 = null;
        var secondindexes_3 = null;
        var char_literal181_tree=null;
        var char_literal182_tree=null;
        var char_literal183_tree=null;
        var char_literal184_tree=null;
        var char_literal185_tree=null;
        var char_literal186_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:695:16: ( rule_NameExpCS ( '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )? )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:696:2: rule_NameExpCS ( '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )? )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_NameExpCS_in_rule_IndexExpCS2377);
            rule_NameExpCS180=this.rule_NameExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_NameExpCS180.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:697:2: ( '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )? )?
            var alt80=2;
            var LA80_0 = this.input.LA(1);

            if ( (LA80_0==85) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:698:3: '[' firstindexes_0+= rule_ExpCS ( ',' firstindexes_1+= rule_ExpCS )* ']' ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )?
                    char_literal181=this.match(this.input,85,MyAtlParser.FOLLOW_85_in_rule_IndexExpCS2384); 
                    char_literal181_tree = this.adaptor.create(char_literal181);
                    this.adaptor.addChild(root_0, char_literal181_tree);

                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IndexExpCS2388);
                    firstindexes_0=this.rule_ExpCS();

                    this.state._fsp--;

                    this.adaptor.addChild(root_0, firstindexes_0.getTree());
                    if (org.antlr.lang.isNull(list_firstindexes_0)) list_firstindexes_0 = [];
                    list_firstindexes_0.push(firstindexes_0.getTree());

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:698:34: ( ',' firstindexes_1+= rule_ExpCS )*
                    loop77:
                    do {
                        var alt77=2;
                        var LA77_0 = this.input.LA(1);

                        if ( (LA77_0==17) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:698:35: ',' firstindexes_1+= rule_ExpCS
                            char_literal182=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_IndexExpCS2391); 
                            char_literal182_tree = this.adaptor.create(char_literal182);
                            this.adaptor.addChild(root_0, char_literal182_tree);

                            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IndexExpCS2395);
                            firstindexes_1=this.rule_ExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, firstindexes_1.getTree());
                            if (org.antlr.lang.isNull(list_firstindexes_1)) list_firstindexes_1 = [];
                            list_firstindexes_1.push(firstindexes_1.getTree());



                            break;

                        default :
                            break loop77;
                        }
                    } while (true);

                    char_literal183=this.match(this.input,86,MyAtlParser.FOLLOW_86_in_rule_IndexExpCS2399); 
                    char_literal183_tree = this.adaptor.create(char_literal183);
                    this.adaptor.addChild(root_0, char_literal183_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:699:3: ( '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']' )?
                    var alt79=2;
                    var LA79_0 = this.input.LA(1);

                    if ( (LA79_0==85) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:699:4: '[' secondindexes_2+= rule_ExpCS ( ',' secondindexes_3+= rule_ExpCS )* ']'
                            char_literal184=this.match(this.input,85,MyAtlParser.FOLLOW_85_in_rule_IndexExpCS2404); 
                            char_literal184_tree = this.adaptor.create(char_literal184);
                            this.adaptor.addChild(root_0, char_literal184_tree);

                            this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IndexExpCS2408);
                            secondindexes_2=this.rule_ExpCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, secondindexes_2.getTree());
                            if (org.antlr.lang.isNull(list_secondindexes_2)) list_secondindexes_2 = [];
                            list_secondindexes_2.push(secondindexes_2.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:699:36: ( ',' secondindexes_3+= rule_ExpCS )*
                            loop78:
                            do {
                                var alt78=2;
                                var LA78_0 = this.input.LA(1);

                                if ( (LA78_0==17) ) {
                                    alt78=1;
                                }


                                switch (alt78) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:699:37: ',' secondindexes_3+= rule_ExpCS
                                    char_literal185=this.match(this.input,17,MyAtlParser.FOLLOW_17_in_rule_IndexExpCS2411); 
                                    char_literal185_tree = this.adaptor.create(char_literal185);
                                    this.adaptor.addChild(root_0, char_literal185_tree);

                                    this.pushFollow(MyAtlParser.FOLLOW_rule_ExpCS_in_rule_IndexExpCS2415);
                                    secondindexes_3=this.rule_ExpCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, secondindexes_3.getTree());
                                    if (org.antlr.lang.isNull(list_secondindexes_3)) list_secondindexes_3 = [];
                                    list_secondindexes_3.push(secondindexes_3.getTree());



                                    break;

                                default :
                                    break loop78;
                                }
                            } while (true);

                            char_literal186=this.match(this.input,86,MyAtlParser.FOLLOW_86_in_rule_IndexExpCS2419); 
                            char_literal186_tree = this.adaptor.create(char_literal186);
                            this.adaptor.addChild(root_0, char_literal186_tree);



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:705:1: rule_NavigatingExpCS_Base : rule_IndexExpCS ;
    // $ANTLR start "rule_NavigatingExpCS_Base"
    rule_NavigatingExpCS_Base: function() {
        var retval = new MyAtlParser.rule_NavigatingExpCS_Base_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

         var rule_IndexExpCS187 = null;


        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:705:26: ( rule_IndexExpCS )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:707:2: rule_IndexExpCS
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_IndexExpCS_in_rule_NavigatingExpCS_Base2438);
            rule_IndexExpCS187=this.rule_IndexExpCS();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_IndexExpCS187.getTree());



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

    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:715:1: rule_NavigatingExpCS : rule_NavigatingExpCS_Base ( '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')' )? ;
    // $ANTLR start "rule_NavigatingExpCS"
    rule_NavigatingExpCS: function() {
        var retval = new MyAtlParser.rule_NavigatingExpCS_return();
        retval.start = this.input.LT(1);

        var root_0 = null;

        var char_literal189 = null;
        var char_literal190 = null;
        var list_argument_0=null;
        var list_argument_1=null;
        var list_argument_2=null;
        var list_argument_3=null;
        var list_argument_4=null;
        var list_argument_5=null;
         var rule_NavigatingExpCS_Base188 = null;
        var argument_0 = null;
        var argument_1 = null;
        var argument_2 = null;
        var argument_3 = null;
        var argument_4 = null;
        var argument_5 = null;
        var char_literal189_tree=null;
        var char_literal190_tree=null;

        try {
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:715:22: ( rule_NavigatingExpCS_Base ( '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')' )? )
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:716:2: rule_NavigatingExpCS_Base ( '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')' )?
            root_0 = this.adaptor.nil();

            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingExpCS_Base_in_rule_NavigatingExpCS2453);
            rule_NavigatingExpCS_Base188=this.rule_NavigatingExpCS_Base();

            this.state._fsp--;

            this.adaptor.addChild(root_0, rule_NavigatingExpCS_Base188.getTree());
            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:717:2: ( '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')' )?
            var alt87=2;
            var LA87_0 = this.input.LA(1);

            if ( (LA87_0==44) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:718:3: '(' (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )? ')'
                    char_literal189=this.match(this.input,44,MyAtlParser.FOLLOW_44_in_rule_NavigatingExpCS2461); 
                    char_literal189_tree = this.adaptor.create(char_literal189);
                    this.adaptor.addChild(root_0, char_literal189_tree);

                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:718:7: (argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )? )?
                    var alt86=2;
                    var LA86_0 = this.input.LA(1);

                    if ( ((LA86_0>=SIMPLE_ID && LA86_0<=BIG_INT)||LA86_0==21||LA86_0==40||LA86_0==44||LA86_0==59||(LA86_0>=62 && LA86_0<=63)||(LA86_0>=67 && LA86_0<=68)||LA86_0==77||(LA86_0>=79 && LA86_0<=81)||LA86_0==84) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:718:8: argument_0+= rule_NavigatingArgCS (argument_1+= rule_NavigatingCommaArgCS )* (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )? (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )?
                            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingArgCS_in_rule_NavigatingExpCS2466);
                            argument_0=this.rule_NavigatingArgCS();

                            this.state._fsp--;

                            this.adaptor.addChild(root_0, argument_0.getTree());
                            if (org.antlr.lang.isNull(list_argument_0)) list_argument_0 = [];
                            list_argument_0.push(argument_0.getTree());

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:718:41: (argument_1+= rule_NavigatingCommaArgCS )*
                            loop81:
                            do {
                                var alt81=2;
                                var LA81_0 = this.input.LA(1);

                                if ( (LA81_0==17) ) {
                                    alt81=1;
                                }


                                switch (alt81) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:718:42: argument_1+= rule_NavigatingCommaArgCS
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2471);
                                    argument_1=this.rule_NavigatingCommaArgCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, argument_1.getTree());
                                    if (org.antlr.lang.isNull(list_argument_1)) list_argument_1 = [];
                                    list_argument_1.push(argument_1.getTree());



                                    break;

                                default :
                                    break loop81;
                                }
                            } while (true);

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:719:4: (argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )* )?
                            var alt83=2;
                            var LA83_0 = this.input.LA(1);

                            if ( (LA83_0==13) ) {
                                alt83=1;
                            }
                            switch (alt83) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:719:5: argument_2+= rule_NavigatingSemiArgCS (argument_3+= rule_NavigatingCommaArgCS )*
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingSemiArgCS_in_rule_NavigatingExpCS2481);
                                    argument_2=this.rule_NavigatingSemiArgCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, argument_2.getTree());
                                    if (org.antlr.lang.isNull(list_argument_2)) list_argument_2 = [];
                                    list_argument_2.push(argument_2.getTree());

                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:720:5: (argument_3+= rule_NavigatingCommaArgCS )*
                                    loop82:
                                    do {
                                        var alt82=2;
                                        var LA82_0 = this.input.LA(1);

                                        if ( (LA82_0==17) ) {
                                            alt82=1;
                                        }


                                        switch (alt82) {
                                        case 1 :
                                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:720:6: argument_3+= rule_NavigatingCommaArgCS
                                            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2490);
                                            argument_3=this.rule_NavigatingCommaArgCS();

                                            this.state._fsp--;

                                            this.adaptor.addChild(root_0, argument_3.getTree());
                                            if (org.antlr.lang.isNull(list_argument_3)) list_argument_3 = [];
                                            list_argument_3.push(argument_3.getTree());



                                            break;

                                        default :
                                            break loop82;
                                        }
                                    } while (true);



                                    break;

                            }

                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:721:5: (argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )* )?
                            var alt85=2;
                            var LA85_0 = this.input.LA(1);

                            if ( (LA85_0==83) ) {
                                alt85=1;
                            }
                            switch (alt85) {
                                case 1 :
                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:721:6: argument_4+= rule_NavigatingBarArgCS (argument_5+= rule_NavigatingCommaArgCS )*
                                    this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingBarArgCS_in_rule_NavigatingExpCS2503);
                                    argument_4=this.rule_NavigatingBarArgCS();

                                    this.state._fsp--;

                                    this.adaptor.addChild(root_0, argument_4.getTree());
                                    if (org.antlr.lang.isNull(list_argument_4)) list_argument_4 = [];
                                    list_argument_4.push(argument_4.getTree());

                                    // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:721:42: (argument_5+= rule_NavigatingCommaArgCS )*
                                    loop84:
                                    do {
                                        var alt84=2;
                                        var LA84_0 = this.input.LA(1);

                                        if ( (LA84_0==17) ) {
                                            alt84=1;
                                        }


                                        switch (alt84) {
                                        case 1 :
                                            // E:\\Programmi\\Model Driven Engineering\\Workspace_DEFINITIVO\\org.mvcl.MyAtl\\WebContent\\parser\\MyAtl.g:721:43: argument_5+= rule_NavigatingCommaArgCS
                                            this.pushFollow(MyAtlParser.FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2508);
                                            argument_5=this.rule_NavigatingCommaArgCS();

                                            this.state._fsp--;

                                            this.adaptor.addChild(root_0, argument_5.getTree());
                                            if (org.antlr.lang.isNull(list_argument_5)) list_argument_5 = [];
                                            list_argument_5.push(argument_5.getTree());



                                            break;

                                        default :
                                            break loop84;
                                        }
                                    } while (true);



                                    break;

                            }



                            break;

                    }

                    char_literal190=this.match(this.input,45,MyAtlParser.FOLLOW_45_in_rule_NavigatingExpCS2515); 
                    char_literal190_tree = this.adaptor.create(char_literal190);
                    this.adaptor.addChild(root_0, char_literal190_tree);



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
    DFA40_eotS:
        "\u001c\uffff",
    DFA40_eofS:
        "\u0001\u0004\u0007\uffff\u0001\u000e\u0013\uffff",
    DFA40_minS:
        "\u0001\u000d\u0001\u0004\u0001\uffff\u0001\u0004\u0001\uffff\u0001"+
    "\u0004\u0001\uffff\u0001\u0024\u0001\u000d\u0001\u0004\u0001\u0024\u0001"+
    "\uffff\u0001\u0004\u0001\u0011\u0001\uffff\u0001\u0004\u0001\u0026\u0001"+
    "\uffff\u0004\u0011\u0004\u0026\u0002\u0004",
    DFA40_maxS:
        "\u0001\u0053\u0001\u0054\u0001\uffff\u0001\u0054\u0001\uffff\u0001"+
    "\u0055\u0001\uffff\u0001\u004d\u0001\u0053\u0001\u0055\u0001\u004d\u0001"+
    "\uffff\u0001\u0022\u0001\u0055\u0001\uffff\u0001\u0022\u0001\u0055\u0001"+
    "\uffff\u0008\u0055\u0002\u0022",
    DFA40_acceptS:
        "\u0002\uffff\u0001\u0002\u0001\uffff\u0001\u0003\u0001\uffff\u0001"+
    "\u0001\u0004\uffff\u0001\u0001\u0002\uffff\u0001\u0001\u0002\uffff\u0001"+
    "\u0001\u000a\uffff",
    DFA40_specialS:
        "\u001c\uffff}>",
    DFA40_transitionS: [
            "\u0001\u0004\u0003\uffff\u0001\u0004\u0012\uffff\u0001\u0001"+
            "\u0005\u0004\u0002\uffff\u0001\u0003\u0001\u0004\u0001\uffff"+
            "\u0001\u0004\u0017\uffff\u0001\u0004\u0001\u0002\u000a\uffff"+
            "\u0001\u0004",
            "\u0001\u0005\u0002\u0004\u000e\uffff\u0001\u0007\u000d\u0006"+
            "\u0003\uffff\u0001\u0008\u0001\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\u0006\u000d\uffff\u0001\u0004\u0002\uffff"+
            "\u0002\u0004\u0003\uffff\u0002\u0004\u0008\uffff\u0001\u0004"+
            "\u0001\uffff\u0003\u0004\u0002\uffff\u0001\u0004",
            "",
            "\u0001\u0009\u0002\u0004\u000e\uffff\u0001\u000a\u000d\u0006"+
            "\u0003\uffff\u0001\u000b\u0001\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\u000b\u000d\uffff\u0001\u0004\u0002\uffff"+
            "\u0002\u0004\u0003\uffff\u0002\u0004\u0008\uffff\u0001\u0004"+
            "\u0001\uffff\u0003\u0004\u0002\uffff\u0001\u0004",
            "",
            "\u0001\u000d\u000c\uffff\u0001\u0004\u0014\uffff\u0001\u0008"+
            "\u0005\uffff\u0001\u0004\u0001\u000b\u0001\uffff\u0001\u0004"+
            "\u0006\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0003\uffff\u0001\u0004\u0001\uffff\u000b\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u000c\u0002\uffff"+
            "\u0001\u0004",
            "",
            "\u0001\u0004\u0007\uffff\u0001\u000b\u001b\uffff\u0001\u000b"+
            "\u0004\uffff\u0001\u000b",
            "\u0001\u000b\u0003\uffff\u0001\u000b\u0012\uffff\u0006\u000b"+
            "\u0002\uffff\u0002\u000b\u0001\uffff\u0001\u000b\u0017\uffff"+
            "\u0001\u000b\u000b\uffff\u0001\u000b",
            "\u0001\u0010\u0021\uffff\u0001\u0011\u0005\uffff\u0001\u0004"+
            "\u0001\u0011\u0001\uffff\u0001\u0004\u0005\uffff\u0002\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0005\uffff\u0001\u000f"+
            "\u0002\uffff\u0001\u0004",
            "\u0001\u0004\u0007\uffff\u0001\u0011\u001b\uffff\u0001\u0011"+
            "\u0004\uffff\u0001\u0011",
            "",
            "\u0001\u0012\u0010\uffff\u0001\u0015\u0008\u0014\u0005\u0013",
            "\u0001\u0004\u0014\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
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
            "\u0001\u0004\u0014\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
            "\u0001\u000e\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u001a\u0002\uffff\u0001\u0004",
            "\u0001\u0004\u0014\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
            "\u0001\u000e\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u001a\u0002\uffff\u0001\u0004",
            "\u0001\u0004\u0014\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
            "\u0001\u000e\u0001\uffff\u0001\u0004\u0006\uffff\u0001\u0004"+
            "\u0001\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u0003\uffff"+
            "\u0001\u0004\u0001\uffff\u000b\u0004\u0001\uffff\u0001\u0004"+
            "\u0003\uffff\u0001\u001a\u0002\uffff\u0001\u0004",
            "\u0001\u0004\u0014\uffff\u0001\u0008\u0005\uffff\u0001\u0004"+
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
    DFA40_eot:
        org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA40_eotS),
    DFA40_eof:
        org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA40_eofS),
    DFA40_min:
        org.antlr.runtime.DFA.unpackEncodedStringToUnsignedChars(MyAtlParser.DFA40_minS),
    DFA40_max:
        org.antlr.runtime.DFA.unpackEncodedStringToUnsignedChars(MyAtlParser.DFA40_maxS),
    DFA40_accept:
        org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA40_acceptS),
    DFA40_special:
        org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA40_specialS),
    DFA40_transition: (function() {
        var a = [],
            i,
            numStates = MyAtlParser.DFA40_transitionS.length;
        for (i=0; i<numStates; i++) {
            a.push(org.antlr.runtime.DFA.unpackEncodedString(MyAtlParser.DFA40_transitionS[i]));
        }
        return a;
    })()
});

MyAtlParser.DFA40 = function(recognizer) {
    this.recognizer = recognizer;
    this.decisionNumber = 40;
    this.eot = MyAtlParser.DFA40_eot;
    this.eof = MyAtlParser.DFA40_eof;
    this.min = MyAtlParser.DFA40_min;
    this.max = MyAtlParser.DFA40_max;
    this.accept = MyAtlParser.DFA40_accept;
    this.special = MyAtlParser.DFA40_special;
    this.transition = MyAtlParser.DFA40_transition;
};

org.antlr.lang.extend(MyAtlParser.DFA40, org.antlr.runtime.DFA, {
    getDescription: function() {
        return "370:39: ( ( ( '(' | '{' ) (ownedtype_1= rule_TypeExpCS )? ( ')' | '}' ) ) | ( '<' ownedtype_2= rule_TypeExpCS '>' ) )?";
    },
    dummy: null
});
 

// public class variables
org.antlr.lang.augmentObject(MyAtlParser, {
    tokenNames: ["<invalid>", "<EOR>", "<DOWN>", "<UP>", "SIMPLE_ID", "SINGLE_QUOTED_STRING", "BIG_INT", "ID", "STRING", "COMMENT", "WS", "INT", "'module'", "';'", "'create'", "'OUT'", "':'", "','", "'from'", "'IN'", "'uses'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'rule'", "'{'", "'using'", "'}'", "'to'", "'...'", "'do'", "'entrypoint'", "'endpoint'", "'('", "')'", "'query'", "'='", "'helper'", "'context'", "'def'", "'xxx'", "'yyy'", "'<-'", "'.'", "'!'", "'and'", "'else'", "'endif'", "'if'", "'implies'", "'in'", "'let'", "'not'", "'or'", "'then'", "'xor'", "'-'", "'*'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'<>'", "'->'", "'true'", "'..'", "'false'", "'invalid'", "'null'", "'::'", "'|'", "'self'", "'['", "']'"],
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
    FOLLOW_13_in_rule_Module130: new org.antlr.runtime.BitSet([0x00100000, 0x00014C08]),
    FOLLOW_20_in_rule_Module133: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_Module137: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_Module139: new org.antlr.runtime.BitSet([0x00000000, 0x00014C08]),
    FOLLOW_rule_ModuleElement_in_rule_Module147: new org.antlr.runtime.BitSet([0x00000000, 0x00014C08]),
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
    FOLLOW_35_in_rule_MatchedRule335: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_MatchedRule339: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_MatchedRule341: new org.antlr.runtime.BitSet([0x00040000, 0x00000000]),
    FOLLOW_18_in_rule_MatchedRule345: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_InPattern_in_rule_MatchedRule351: new org.antlr.runtime.BitSet([0x00000000, 0x000000A0]),
    FOLLOW_37_in_rule_MatchedRule357: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_MatchedRule359: new org.antlr.runtime.BitSet([0x00000010, 0x00000040]),
    FOLLOW_rule_RuleVariableDeclaration_in_rule_MatchedRule367: new org.antlr.runtime.BitSet([0x00000010, 0x00000040]),
    FOLLOW_38_in_rule_MatchedRule372: new org.antlr.runtime.BitSet([0x00000000, 0x00000080]),
    FOLLOW_39_in_rule_MatchedRule378: new org.antlr.runtime.BitSet([0x00000010, 0x00080000]),
    FOLLOW_rule_OutPattern_in_rule_MatchedRule384: new org.antlr.runtime.BitSet([0x00020000, 0x00000340]),
    FOLLOW_40_in_rule_MatchedRule387: new org.antlr.runtime.BitSet([0x00020000, 0x00000240]),
    FOLLOW_17_in_rule_MatchedRule392: new org.antlr.runtime.BitSet([0x00020000, 0x00000240]),
    FOLLOW_41_in_rule_MatchedRule399: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_MatchedRule401: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ActionBlock_in_rule_MatchedRule408: new org.antlr.runtime.BitSet([0x00000000, 0x00000040]),
    FOLLOW_38_in_rule_MatchedRule413: new org.antlr.runtime.BitSet([0x00020000, 0x00000040]),
    FOLLOW_17_in_rule_MatchedRule424: new org.antlr.runtime.BitSet([0x00000000, 0x00000040]),
    FOLLOW_38_in_rule_MatchedRule427: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_CalledRule441: new org.antlr.runtime.BitSet([0x00000000, 0x00000008]),
    FOLLOW_35_in_rule_CalledRule449: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_CalledRule453: new org.antlr.runtime.BitSet([0x00000000, 0x00001010]),
    FOLLOW_44_in_rule_CalledRule457: new org.antlr.runtime.BitSet([0x00000000, 0x00002000]),
    FOLLOW_45_in_rule_CalledRule458: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_CalledRule462: new org.antlr.runtime.BitSet([0x00000000, 0x000000A0]),
    FOLLOW_37_in_rule_CalledRule467: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_CalledRule469: new org.antlr.runtime.BitSet([0x00000010, 0x00000040]),
    FOLLOW_rule_RuleVariableDeclaration_in_rule_CalledRule477: new org.antlr.runtime.BitSet([0x00000010, 0x00000040]),
    FOLLOW_38_in_rule_CalledRule482: new org.antlr.runtime.BitSet([0x00000000, 0x00000080]),
    FOLLOW_39_in_rule_CalledRule488: new org.antlr.runtime.BitSet([0x00000010, 0x00080000]),
    FOLLOW_rule_OutPattern_in_rule_CalledRule494: new org.antlr.runtime.BitSet([0x00020000, 0x00000340]),
    FOLLOW_40_in_rule_CalledRule497: new org.antlr.runtime.BitSet([0x00020000, 0x00000240]),
    FOLLOW_17_in_rule_CalledRule502: new org.antlr.runtime.BitSet([0x00020000, 0x00000240]),
    FOLLOW_41_in_rule_CalledRule509: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_CalledRule511: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ActionBlock_in_rule_CalledRule518: new org.antlr.runtime.BitSet([0x00000000, 0x00000040]),
    FOLLOW_38_in_rule_CalledRule522: new org.antlr.runtime.BitSet([0x00020000, 0x00000040]),
    FOLLOW_17_in_rule_CalledRule532: new org.antlr.runtime.BitSet([0x00000000, 0x00000040]),
    FOLLOW_38_in_rule_CalledRule535: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_46_in_rule_QueryRule547: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_QueryRule552: new org.antlr.runtime.BitSet([0x00000000, 0x00009000]),
    FOLLOW_44_in_rule_QueryRule557: new org.antlr.runtime.BitSet([0x00000010, 0x00002000]),
    FOLLOW_rule_ATLParameterCS_in_rule_QueryRule563: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_17_in_rule_QueryRule566: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_ATLParameterCS_in_rule_QueryRule572: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_45_in_rule_QueryRule579: new org.antlr.runtime.BitSet([0x00000000, 0x00008000]),
    FOLLOW_47_in_rule_QueryRule586: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_QueryRule590: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_QueryRule592: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_48_in_rule_Helper611: new org.antlr.runtime.BitSet([0x00000010, 0x00060000]),
    FOLLOW_49_in_rule_Helper615: new org.antlr.runtime.BitSet([0x00000010, 0x00060000]),
    FOLLOW_rule_UnrestrictedName_in_rule_Helper622: new org.antlr.runtime.BitSet([0x00000010, 0x00060000]),
    FOLLOW_rule_ATLDefCS_in_rule_Helper631: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_50_in_rule_ATLDefCS652: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_ATLDefCS654: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_ATLDefCS658: new org.antlr.runtime.BitSet([0x00010000, 0x00001000]),
    FOLLOW_44_in_rule_ATLDefCS662: new org.antlr.runtime.BitSet([0x00000010, 0x00002000]),
    FOLLOW_rule_ATLParameterCS_in_rule_ATLDefCS668: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_17_in_rule_ATLDefCS671: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_ATLParameterCS_in_rule_ATLDefCS677: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_45_in_rule_ATLDefCS684: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_ATLDefCS689: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_ATLDefCS693: new org.antlr.runtime.BitSet([0x00000000, 0x00008000]),
    FOLLOW_47_in_rule_ATLDefCS696: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_ATLDefCS700: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_ATLDefCS702: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_ATLParameterCS720: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_ATLParameterCS722: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_ATLParameterCS726: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_RuleVariableDeclaration743: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_RuleVariableDeclaration745: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_RuleVariableDeclaration749: new org.antlr.runtime.BitSet([0x00000000, 0x00008000]),
    FOLLOW_47_in_rule_RuleVariableDeclaration754: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_RuleVariableDeclaration758: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_RuleVariableDeclaration760: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_InPatternElement_in_rule_InPattern776: new org.antlr.runtime.BitSet([0x00000002, 0x00001000]),
    FOLLOW_44_in_rule_InPattern779: new org.antlr.runtime.BitSet([0x00200070, 0xC8003100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_InPattern784: new org.antlr.runtime.BitSet([0x00000000, 0x00002000]),
    FOLLOW_45_in_rule_InPattern788: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_InPatternElement807: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_InPatternElement809: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_InPatternElement813: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_OutPatternElement_in_rule_OutPattern828: new org.antlr.runtime.BitSet([0x00020002, 0x00000000]),
    FOLLOW_17_in_rule_OutPattern831: new org.antlr.runtime.BitSet([0x00000010, 0x00080000]),
    FOLLOW_rule_OutPatternElement_in_rule_OutPattern837: new org.antlr.runtime.BitSet([0x00020002, 0x00000000]),
    FOLLOW_rule_SimpleOutPatternElement_in_rule_OutPatternElement852: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ForEachOutPatternElement_in_rule_OutPatternElement856: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_SimpleOutPatternElement871: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_SimpleOutPatternElement873: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_ATLType_in_rule_SimpleOutPatternElement877: new org.antlr.runtime.BitSet([0x00000002, 0x00001000]),
    FOLLOW_44_in_rule_SimpleOutPatternElement881: new org.antlr.runtime.BitSet([0x00000010, 0x00002000]),
    FOLLOW_rule_Binding_in_rule_SimpleOutPatternElement888: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_17_in_rule_SimpleOutPatternElement891: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_Binding_in_rule_SimpleOutPatternElement895: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_45_in_rule_SimpleOutPatternElement902: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_51_in_rule_ForEachOutPatternElement917: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_ForEachOutPatternElement924: new org.antlr.runtime.BitSet([0x00000000, 0x00100000]),
    FOLLOW_52_in_rule_ForEachOutPatternElement927: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_Binding940: new org.antlr.runtime.BitSet([0x00000000, 0x00200000]),
    FOLLOW_53_in_rule_Binding942: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_Binding946: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_Statement_in_rule_ActionBlock962: new org.antlr.runtime.BitSet([0x00200072, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_BindingStat_in_rule_Statement976: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_BindingStat991: new org.antlr.runtime.BitSet([0x00000000, 0x00400000]),
    FOLLOW_54_in_rule_BindingStat993: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_BindingStat999: new org.antlr.runtime.BitSet([0x00000000, 0x00200000]),
    FOLLOW_53_in_rule_BindingStat1001: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_BindingStat1006: new org.antlr.runtime.BitSet([0x00002000, 0x00000000]),
    FOLLOW_13_in_rule_BindingStat1008: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ATLModelName_in_rule_ATLType1026: new org.antlr.runtime.BitSet([0x00000000, 0x00800000]),
    FOLLOW_55_in_rule_ATLType1028: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_ATLType1036: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_ATLModelName1050: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_EssentialOCLRersevedKeyword0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_EssentialOCLPrefixOperator0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_EssentialOCLInfixOperator0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_set_in_rule_EssentialOCLNavigationOperator0: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_SINGLE_QUOTED_STRING_in_rule_StringLiteral1216: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_EssentialOCLPrefixOperator_in_rule_PrefixOperator1229: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_EssentialOCLInfixOperator_in_rule_InfixOperator1240: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_EssentialOCLNavigationOperator_in_rule_NavigationOperator1252: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_CollectionTypeIdentifier_in_rule_CollectionTypeCS1268: new org.antlr.runtime.BitSet([0x00000002, 0x00001010,0x00000100, 0x00000000]),
    FOLLOW_set_in_rule_CollectionTypeCS1272: new org.antlr.runtime.BitSet([0xFFE00010, 0x00002047]),
    FOLLOW_rule_TypeExpCS_in_rule_CollectionTypeCS1283: new org.antlr.runtime.BitSet([0x00000000, 0x00002040]),
    FOLLOW_set_in_rule_CollectionTypeCS1287: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_72_in_rule_CollectionTypeCS1301: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_CollectionTypeCS1305: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00000080, 0x00000000]),
    FOLLOW_71_in_rule_CollectionTypeCS1307: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_21_in_rule_TupleTypeCS1331: new org.antlr.runtime.BitSet([0x00000000, 0x00001000,0x00002100, 0x00000000]),
    FOLLOW_44_in_rule_TupleTypeCS1336: new org.antlr.runtime.BitSet([0x00000010, 0x00002000]),
    FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1341: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_17_in_rule_TupleTypeCS1344: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1348: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_45_in_rule_TupleTypeCS1354: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00002000, 0x00000000]),
    FOLLOW_72_in_rule_TupleTypeCS1362: new org.antlr.runtime.BitSet([0x00000010, 0x00000000,0x00000080, 0x00000000]),
    FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1367: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00000080, 0x00000000]),
    FOLLOW_17_in_rule_TupleTypeCS1370: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_TuplePartCS_in_rule_TupleTypeCS1374: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00000080, 0x00000000]),
    FOLLOW_71_in_rule_TupleTypeCS1379: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00002000, 0x00000000]),
    FOLLOW_77_in_rule_TupleTypeCS1389: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_TuplePartCS1405: new org.antlr.runtime.BitSet([0x00010000, 0x00000000]),
    FOLLOW_16_in_rule_TuplePartCS1407: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_TuplePartCS1411: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_CollectionTypeCS_in_rule_CollectionLiteralExpCS1426: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_CollectionLiteralExpCS1429: new org.antlr.runtime.BitSet([0x00200070, 0xC8001140,0x0013A018, 0x00000000]),
    FOLLOW_rule_CollectionLiteralPartCS_in_rule_CollectionLiteralExpCS1434: new org.antlr.runtime.BitSet([0x00020000, 0x00000040]),
    FOLLOW_17_in_rule_CollectionLiteralExpCS1437: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_CollectionLiteralPartCS_in_rule_CollectionLiteralExpCS1441: new org.antlr.runtime.BitSet([0x00020000, 0x00000040]),
    FOLLOW_38_in_rule_CollectionLiteralExpCS1446: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_CollectionLiteralPartCS1461: new org.antlr.runtime.BitSet([0x00000002, 0x00000000,0x00004000, 0x00000000]),
    FOLLOW_78_in_rule_CollectionLiteralPartCS1464: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_CollectionLiteralPartCS1468: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NumberLiteralExpCS_in_rule_PrimitiveLiteralExpCS1484: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_StringLiteralExpCS_in_rule_PrimitiveLiteralExpCS1488: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_BooleanLiteralExpCS_in_rule_PrimitiveLiteralExpCS1492: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnlimitedNaturalLiteralExpCS_in_rule_PrimitiveLiteralExpCS1498: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_InvalidLiteralExpCS_in_rule_PrimitiveLiteralExpCS1502: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NullLiteralExpCS_in_rule_PrimitiveLiteralExpCS1506: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_21_in_rule_TupleLiteralExpCS1518: new org.antlr.runtime.BitSet([0x00000000, 0x00000010]),
    FOLLOW_36_in_rule_TupleLiteralExpCS1520: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_TupleLiteralPartCS_in_rule_TupleLiteralExpCS1524: new org.antlr.runtime.BitSet([0x00020000, 0x00000040]),
    FOLLOW_17_in_rule_TupleLiteralExpCS1527: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_TupleLiteralPartCS_in_rule_TupleLiteralExpCS1533: new org.antlr.runtime.BitSet([0x00020000, 0x00000040]),
    FOLLOW_38_in_rule_TupleLiteralExpCS1537: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_TupleLiteralPartCS1551: new org.antlr.runtime.BitSet([0x00010000, 0x00008000]),
    FOLLOW_16_in_rule_TupleLiteralPartCS1554: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_TupleLiteralPartCS1558: new org.antlr.runtime.BitSet([0x00000000, 0x00008000]),
    FOLLOW_47_in_rule_TupleLiteralPartCS1562: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_TupleLiteralPartCS1567: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_BIG_INT_in_rule_NumberLiteralExpCS1580: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_StringLiteral_in_rule_StringLiteralExpCS1594: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_77_in_rule_BooleanLiteralExpCS1608: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_79_in_rule_BooleanLiteralExpCS1614: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_68_in_rule_UnlimitedNaturalLiteralExpCS1630: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_80_in_rule_InvalidLiteralExpCS1643: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_81_in_rule_NullLiteralExpCS1656: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrimitiveTypeIdentifier_in_rule_PrimitiveTypeCS1672: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrimitiveTypeCS_in_rule_TypeLiteralCS1686: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TupleTypeCS_in_rule_TypeLiteralCS1691: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_CollectionTypeCS_in_rule_TypeLiteralCS1695: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TypeLiteralCS_in_rule_TypeLiteralExpCS1711: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_TypeNameExpCS1728: new org.antlr.runtime.BitSet([0x00000012, 0x00000000,0x00040000, 0x00000000]),
    FOLLOW_82_in_rule_TypeNameExpCS1746: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_UnreservedName_in_rule_TypeNameExpCS1752: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00040000, 0x00000000]),
    FOLLOW_82_in_rule_TypeNameExpCS1754: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_UnreservedName_in_rule_TypeNameExpCS1766: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_TypeNameExpCS1775: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TypeNameExpCS_in_rule_TypeExpCS1789: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TypeLiteralCS_in_rule_TypeExpCS1793: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingArgCS1808: new org.antlr.runtime.BitSet([0x00010002, 0x00008000]),
    FOLLOW_16_in_rule_NavigatingArgCS1811: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_NavigatingArgCS1815: new org.antlr.runtime.BitSet([0x00000002, 0x00008000]),
    FOLLOW_47_in_rule_NavigatingArgCS1820: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingArgCS1824: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_83_in_rule_NavigatingBarArgCS1841: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingBarArgCS1845: new org.antlr.runtime.BitSet([0x00010002, 0x00008000]),
    FOLLOW_16_in_rule_NavigatingBarArgCS1848: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_NavigatingBarArgCS1852: new org.antlr.runtime.BitSet([0x00000002, 0x00008000]),
    FOLLOW_47_in_rule_NavigatingBarArgCS1857: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingBarArgCS1861: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_17_in_rule_NavigatingCommaArgCS1877: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingCommaArgCS1881: new org.antlr.runtime.BitSet([0x00010002, 0x00008000]),
    FOLLOW_16_in_rule_NavigatingCommaArgCS1884: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_NavigatingCommaArgCS1888: new org.antlr.runtime.BitSet([0x00000002, 0x00008000]),
    FOLLOW_47_in_rule_NavigatingCommaArgCS1893: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingCommaArgCS1897: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_13_in_rule_NavigatingSemiArgCS1916: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_NavigatingArgExpCS_in_rule_NavigatingSemiArgCS1920: new org.antlr.runtime.BitSet([0x00010002, 0x00008000]),
    FOLLOW_16_in_rule_NavigatingSemiArgCS1923: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_NavigatingSemiArgCS1927: new org.antlr.runtime.BitSet([0x00000002, 0x00008000]),
    FOLLOW_47_in_rule_NavigatingSemiArgCS1932: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingSemiArgCS1936: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NavigatingArgExpCS1950: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_59_in_rule_IfExpCS1963: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IfExpCS1967: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00000002, 0x00000000]),
    FOLLOW_65_in_rule_IfExpCS1970: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IfExpCS1974: new org.antlr.runtime.BitSet([0x00000000, 0x02000000]),
    FOLLOW_57_in_rule_IfExpCS1977: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IfExpCS1981: new org.antlr.runtime.BitSet([0x00000000, 0x04000000]),
    FOLLOW_58_in_rule_IfExpCS1984: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_62_in_rule_LetExpCS1994: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_LetVariableCS_in_rule_LetExpCS1998: new org.antlr.runtime.BitSet([0x00020000, 0x20000000]),
    FOLLOW_17_in_rule_LetExpCS2001: new org.antlr.runtime.BitSet([0x00000010, 0x00000000]),
    FOLLOW_rule_LetVariableCS_in_rule_LetExpCS2005: new org.antlr.runtime.BitSet([0x00020000, 0x20000000]),
    FOLLOW_61_in_rule_LetExpCS2010: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_LetExpCS2014: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_LetVariableCS2028: new org.antlr.runtime.BitSet([0x00010000, 0x00008000]),
    FOLLOW_16_in_rule_LetVariableCS2031: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_TypeExpCS_in_rule_LetVariableCS2034: new org.antlr.runtime.BitSet([0x00000000, 0x00008000]),
    FOLLOW_47_in_rule_LetVariableCS2038: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_LetVariableCS2043: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_44_in_rule_NestedExpCS2056: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_NestedExpCS2060: new org.antlr.runtime.BitSet([0x00000000, 0x00002000]),
    FOLLOW_45_in_rule_NestedExpCS2062: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_84_in_rule_SelfExpCS2075: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigatingExpCS_in_rule_PrimaryExpCS2102: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_SelfExpCS_in_rule_PrimaryExpCS2106: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrimitiveLiteralExpCS_in_rule_PrimaryExpCS2110: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_TupleLiteralExpCS_in_rule_PrimaryExpCS2114: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_LetExpCS_in_rule_PrimaryExpCS2120: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_IfExpCS_in_rule_PrimaryExpCS2124: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NestedExpCS_in_rule_PrimaryExpCS2128: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_StringExpCs_in_rule_PrimaryExpCS2132: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_40_in_rule_StringExpCs2149: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_NameExpCS2165: new org.antlr.runtime.BitSet([0x00000012, 0x00000000,0x00040000, 0x00000000]),
    FOLLOW_82_in_rule_NameExpCS2182: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_UnreservedName_in_rule_NameExpCS2188: new org.antlr.runtime.BitSet([0x00000000, 0x00000000,0x00040000, 0x00000000]),
    FOLLOW_82_in_rule_NameExpCS2190: new org.antlr.runtime.BitSet([0xFFE00010, 0x00000007]),
    FOLLOW_rule_UnreservedName_in_rule_NameExpCS2202: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnrestrictedName_in_rule_NameExpCS2211: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_InfixedExpCS_in_rule_ExpCS2228: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrefixedExpCS_in_rule_InfixedExpCS2243: new org.antlr.runtime.BitSet([0x00000002, 0x11408000,0x00001FFD, 0x00000000]),
    FOLLOW_rule_BinaryOperatorCS_in_rule_InfixedExpCS2251: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_PrefixedExpCS_in_rule_InfixedExpCS2255: new org.antlr.runtime.BitSet([0x00000002, 0x11408000,0x00001FFD, 0x00000000]),
    FOLLOW_rule_InfixOperatorCS_in_rule_BinaryOperatorCS2276: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigationOperatorCS_in_rule_BinaryOperatorCS2280: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_InfixOperator_in_rule_InfixOperatorCS2294: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigationOperator_in_rule_NavigationOperatorCS2311: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrimaryExpCS_in_rule_PrefixedExpCS2327: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_UnaryOperatorCS_in_rule_PrefixedExpCS2335: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_PrimaryExpCS_in_rule_PrefixedExpCS2342: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_PrefixOperator_in_rule_UnaryOperatorCS2361: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NameExpCS_in_rule_IndexExpCS2377: new org.antlr.runtime.BitSet([0x00000002, 0x00000000,0x00200000, 0x00000000]),
    FOLLOW_85_in_rule_IndexExpCS2384: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IndexExpCS2388: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00400000, 0x00000000]),
    FOLLOW_17_in_rule_IndexExpCS2391: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IndexExpCS2395: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00400000, 0x00000000]),
    FOLLOW_86_in_rule_IndexExpCS2399: new org.antlr.runtime.BitSet([0x00000002, 0x00000000,0x00200000, 0x00000000]),
    FOLLOW_85_in_rule_IndexExpCS2404: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IndexExpCS2408: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00400000, 0x00000000]),
    FOLLOW_17_in_rule_IndexExpCS2411: new org.antlr.runtime.BitSet([0x00200070, 0xC8001100,0x0013A018, 0x00000000]),
    FOLLOW_rule_ExpCS_in_rule_IndexExpCS2415: new org.antlr.runtime.BitSet([0x00020000, 0x00000000,0x00400000, 0x00000000]),
    FOLLOW_86_in_rule_IndexExpCS2419: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_IndexExpCS_in_rule_NavigatingExpCS_Base2438: new org.antlr.runtime.BitSet([0x00000002, 0x00000000]),
    FOLLOW_rule_NavigatingExpCS_Base_in_rule_NavigatingExpCS2453: new org.antlr.runtime.BitSet([0x00000002, 0x00001000]),
    FOLLOW_44_in_rule_NavigatingExpCS2461: new org.antlr.runtime.BitSet([0x00200070, 0xC8003100,0x0013A018, 0x00000000]),
    FOLLOW_rule_NavigatingArgCS_in_rule_NavigatingExpCS2466: new org.antlr.runtime.BitSet([0x00022000, 0x00002000,0x00080000, 0x00000000]),
    FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2471: new org.antlr.runtime.BitSet([0x00022000, 0x00002000,0x00080000, 0x00000000]),
    FOLLOW_rule_NavigatingSemiArgCS_in_rule_NavigatingExpCS2481: new org.antlr.runtime.BitSet([0x00020000, 0x00002000,0x00080000, 0x00000000]),
    FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2490: new org.antlr.runtime.BitSet([0x00020000, 0x00002000,0x00080000, 0x00000000]),
    FOLLOW_rule_NavigatingBarArgCS_in_rule_NavigatingExpCS2503: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_rule_NavigatingCommaArgCS_in_rule_NavigatingExpCS2508: new org.antlr.runtime.BitSet([0x00020000, 0x00002000]),
    FOLLOW_45_in_rule_NavigatingExpCS2515: new org.antlr.runtime.BitSet([0x00000002, 0x00000000])
});

})();