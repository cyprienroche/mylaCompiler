
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer;
}

// program
prog : UINT* EOF ;
