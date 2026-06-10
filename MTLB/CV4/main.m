clc; clear all; close all; echo off;

key = 'matlab'; %516423
text = 'ABCDEFgh';
%keyLength=length(key);     %pro key delší než 6
keyLength=6;        %pro stejný output jako původní
keyNums = double(key);
[c cisla] = sort(keyNums);

if rem(length(text),keyLength)~=0
    bl=blanks(keyLength-rem(length(text),keyLength));
    text=append(text,bl);
end
M =reshape(text, [keyLength,fix(length(text)/keyLength)]).';
X=M(:,cisla);
cypher =[X(:)].'