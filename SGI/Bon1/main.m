clf;clc;clear;
%input

audiofile="c4.wav"; %název souboru
%audiofile=input('Zadejte nazev souboru\n',"s");
vzor1=40; %tyto hodnoty se zdají být !poměrně! optimální pro zkoušené úlohy
vzor2=25;



%setup
info = audioinfo(audiofile);
nazev=split(string(info.Filename),'\');
[y,Fs]=audioread(audiofile);
y=y(:,1);
t = 0:1/Fs:info.Duration-1/Fs;
AudioObject=audioplayer(y,Fs);
y=y-ones(size(y))*mean(y); %pohyb po ose y kvůli správné funkčnosti absolutních hodnot
plot(t,y);
hold on;
plot(t,abs(y));
%finding noise
AVG=mean(abs(y));
yline(AVG);
tmp=[];
for i=(0:(length(y)/vzor1)-1)
    tmp(end+1)=median(abs(y(1+vzor1*i:vzor1*(i+1))));
end
x=find(tmp>AVG);
tmp=[];
for i=(0:floor(x(1)*vzor1/vzor2))
    tmp(end+1)=max(abs(y(x(1)*vzor1-vzor2*(i+1):x(1)*vzor1-vzor2*i)));
    if tmp(end)<AVG
        break
    end
end
x1=length(tmp)*vzor2;
tmp=[];
for i=(0:floor((info.TotalSamples-x(end)*vzor1)/vzor2))
    tmp(end+1)=max(abs(y(x(end)*vzor1+vzor2*i:x(end)*vzor1+vzor2*(i+1))));
    if tmp(end)<AVG
        break
    end
end
x2=length(tmp)*vzor2;
Start=(x(1)*vzor1-x1);
Stop=(x(end)*vzor1+x2);

%OUTPUT
%figure
xline([Start/Fs, Stop/Fs]);
xlabel('t [s]');
title('Zvuková nahrávka '+nazev(end));
%console
fprintf('Zacatek: %.2f s        Konec: %.2f s\n',(Start/Fs),(Stop/Fs));              %fprintf('Začátek: %5.2f \x00B1 0.05 s \nKonec: %7.2f \x00B1 0.05 s\n',(Start/Fs),(Stop/Fs));
%audio-cut
play(AudioObject,[Start,Stop]);