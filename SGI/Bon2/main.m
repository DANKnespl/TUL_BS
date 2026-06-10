clc;clear all;clf;close all;
figure('Name','Ones','NumberTitle','off');
for i=1:8
    draw(sprintf('.\\ones\\c1-%d.jpg',i),i-1);
end
figure('Name','Fives','NumberTitle','off');
for i=1:8
    draw5(sprintf('.\\fives\\c5-%d.jpg',i),i-1);
end
figure('Name','Eights','NumberTitle','off');
for i=1:8
    draw(sprintf('.\\eights\\c8-%d.jpg',i),i-1);
end