clear;clc;clf;

sc = get( groot, 'Screensize' );
fyB = 42;
fyT = sc(4)/2+fyB-20;
fxL = 2;
fxR = fxL+sc(3)/2;
fSize1=sc(3)/2-fxL;
fSize2=sc(4)/2-3*20-2*fxL-fyB;
fSize = [fSize1 fSize2];


X=(-5:0.05:5);

f1= figure(1);
    set(gcf,'position',[fxL fyT fSize]);
    gone(6);
    
    title("hexagon")
    
f2 = figure(2);
    set(gcf,'position',[fxR fyT fSize]);
    hold on;
    
    Y=fun(X);
    Z=fun(X,1);
    W=fun(X,2); 
    plot(X,Y,'R');
    plot(X,Z,'G');
    plot(X,W,'B');
    
    title("plot(x,f(x,y))")
    xlabel("x")
    ylabel("f(x,y)")
    legend("f(x,0)","f(x,1)","f(x,2)")
    
f3 = figure(3);
    set(gcf,'position',[fxL fyB fSize]);
    title("f(x,y)")
    ax1=subplot(1,3,1);
    plot(X,Y,'R');
    ax2=subplot(1,3,2);
    plot(X,Z,'G');
    ax3=subplot(1,3,3);
    plot(X,W,'B');
    
    linkaxes([ax1, ax2, ax3],'xy');
    xlabel([ax1 ax2 ax3],"x");
    ylabel([ax1 ax2 ax3],"f(x,y)");
    legend(ax1,"f(x,0)");
    legend(ax2,"f(x,1)");
    legend(ax3,"f(x,2)");
    axis([-5 5 -1.5 1.5]);
    
    
saveas(f2,"cv5f2.jpg");  %39 kB, kvalitativně nejhorší - barva nesedí, méně ostrý 
saveas(f2,"cv5f2.bmp");  %2978 kB, kvalitativně někde mezi - barva sedí 
saveas(f2,"cv5f2.pdf");  %8 kB, kvalitativně nejlepší - díky vektorovému přístupu překresluje výstup při přiblížení
saveas(f3,"cv5f3.fig");  
    
f4 = figure(4);
    set(gcf,'position',[fxR fyB fSize]);
    x=-5:0.1:5;
    y=-6:0.2:6;
    [A B] = meshgrid(x,y);
    C=fun(A,B);
    surf(A,B,C); %mesh(A,B,C)
    
    title("Surf/Mesh");
    xlabel("x");
    ylabel("y");
    zlabel("f(x,y)");
    
    
    
    
function [z] = fun(x,y)
    if nargin==1
        y=0;
    end
    z=x.*exp(-power(x,2)-power(y,2))+(tanh(x.*y));    
end