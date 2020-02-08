
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer;
}

// program
prog : INTEGER* EOF ;
