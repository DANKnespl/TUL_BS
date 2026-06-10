clc;clear;close all;
A4=440;
BPM=120;%/min

Fs=8000;
q=nthroot(2,12);

quart=60/120;
half=quart*2;


T=20*quart+4*quart+4*half;

%freq
a=A4;
d=A4/power(q,7);
e=A4/power(q,5);
f=A4/power(q,4);
g=A4/power(q,2);


%f,FS,T
not=[...
    tone(g,Fs,quart) tone(g,Fs,quart) tone(e,Fs,quart) zeros(1,4000)...
    tone(g,Fs,quart) tone(g,Fs,quart) tone(e,Fs,quart) zeros(1,4000)...
    tone(g,Fs,quart) tone(g,Fs,quart) tone(a,Fs,quart) tone(g,Fs,quart)...
    tone(g,Fs,half) tone(f,Fs,half)...
    tone(f,Fs,quart) tone(f,Fs,quart) tone(d,Fs,quart) zeros(1,4000)...
    tone(f,Fs,quart) tone(f,Fs,quart) tone(d,Fs,quart) zeros(1,4000)...
    tone(f,Fs,quart) tone(f,Fs,quart) tone(g,Fs,quart) tone(f,Fs,quart)...
    tone(f,Fs,half) tone(e,Fs,half)];
    sound(not,Fs)
%---
% not(end+1)=tone(f,Fs,quart);
% not(end+1)=tone(f,Fs,quart);
% not(end+1)=tone(g,Fs,quart);
% not(end+1)=tone(f,Fs,quart);
% 
% not(end+1)=tone(f,Fs,half);
% not(end+1)=tone(e,Fs,half);
% sound(not,Fs);