function draw5(img,i)
og=squeeze(imread(img));
x=og;
if size(x,3)~=1
    x=x(:,:,2);
end
x(x<128)=1;
x2=[];
z=unique([find(x==1),find(x2==1)]);

osax=48-mod(z,48);
osay=floor(z/48);
k=LinReg(osax,osay);
if k>0
    t=pul([osax(1),osax(end),min(osax),max(osax)],[osay(1),osay(end),max(osay(osax==min(osax))),min(osay(osax==max(osax)))],k);
else
    t=pul([osax(1),osax(end),min(osax),max(osax)],[osay(1),osay(end),min(osay(osax==min(osax))),max(osay(osax==max(osax)))],k);
end
t(end+1)=rad2deg(atan(k));
og=255-og;
x=imrotate(og,sum(t,'all')/2,'bilinear','crop');
x=255-x;
og=255-og;

%x(x==0)=255;
subplot(8,2,1+2*i);
imshow(og,'InitialMagnification','fit');
subplot(8,2,2+2*i);
imshow(x,'InitialMagnification','fit');
end