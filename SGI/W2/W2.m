clear;clc;clf;

Fs=8;
T=4;
A=4;
f=2;
fi=pi/2;
M=0;

Ts=1/Fs;
t=0:Ts:T-Ts;
y=A*cos(2*pi*f*t+fi)+M;

subplot(1,2,1);
plot(t,y);
title("plotík")
ylabel("Cos(t)");
xlabel("t[s]");
subplot(1,2,2);

stem(t,y);
title("ScienceTechnolgyEducationMaths");
ylabel("Cos(t)");
xlabel("t[s]");